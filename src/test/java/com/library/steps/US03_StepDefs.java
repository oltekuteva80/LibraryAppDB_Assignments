package com.library.steps;

import com.library.pages.BasePage;
import com.library.pages.BookPage;
import com.library.pages.LoginPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Base64;
import java.util.List;

public class US03_StepDefs {

    LoginPage loginPage=new LoginPage();

    BookPage bookPage=new BookPage();


    @Given("the {string} on the home page")
    public void the_on_the_home_page(String librarian) {
        loginPage.login(librarian);
        BrowserUtil.waitFor(2);

    }
    @When("the user navigates to {string} page")
    public void the_user_navigates_to_page(String book) {
        bookPage.navigateModule(book);
        BrowserUtil.waitFor(2);

    }
    @When("the user clicks book categories")
    public void the_user_clicks_book_categories() {
        BrowserUtil.clickWithTimeOut(bookPage.mainCategoryElement,2);

    }
    @Then("verify book categories must match book_categories table from db")
    public void verify_book_categories_must_match_book_categories_table_from_db() {
//Actual List of Book Categories
        List<String> actualBookCategories=BrowserUtil.getAllSelectOptions(bookPage.mainCategoryElement);
        actualBookCategories.remove(0);
        //Expected List of Book Categories
        String query="select name from book_categories";
        DB_Util.runQuery(query);
        List <String> expectedBookCategories=DB_Util.getColumnDataAsList(1);
        Assert.assertEquals(expectedBookCategories,actualBookCategories);
    }





}
