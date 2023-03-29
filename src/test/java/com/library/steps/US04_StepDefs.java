package com.library.steps;

import com.library.pages.BookPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.concurrent.BrokenBarrierException;

public class US04_StepDefs {
    BookPage bookPage=new BookPage();

    @When("the user searches for {string} book")
    public void the_user_searches_for_book(String bookName) {
        bookPage.search.sendKeys(bookName);
        BrowserUtil.waitFor(2);


    }
    @When("the user clicks edit book button")
    public void the_user_clicks_edit_book_button() {
       bookPage.editBook("Clean Code");

    }
    @Then("book information must match the Database")
    public void book_information_must_match_the_database() {
        String query="select *from books\n" +
                "where name='Clean Code'";
        DB_Util.runQuery(query);


    }

}
