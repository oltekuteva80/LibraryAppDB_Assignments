-- US 01
select count(id) from users;
-- 1855

select  count(distinct id) from users;
-- 1855

-- Result --> MANUALLY IT IS PASSED

-- US 02
select count(*) from book_borrow
where is_returned = '0';

-- US 03
select name from book_categories;

-- US04
select *from books
where name='Clean Code';
-- US 05
