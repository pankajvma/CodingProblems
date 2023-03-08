-- Q7.1. Find the total amount of poster_qty paper ordered in the orders table.
SELECT
    SUM(ord.poster_qty) total_poster_sales
FROM
    orders ord;

-- Q7.2. Find the total amount of standard_qty paper ordered in the orders table.
SELECT
    SUM(ord.standard_qty) total_standard_sales
FROM
    orders ord;

-- Q7.3. Find the total dollar amount of sales using the total_amt_usd in the orders table.
SELECT
    SUM(ord.total_amt_usd) total_dollar_sales
FROM
    orders ord;

-- Q7.4. Find the total amount spent on standard_amt_usd and gloss_amt_usd paper for each order in the orders table. This should give a dollar amount for each order in the table.
SELECT
    (ord.standard_amt_usd + ord.gloss_amt_usd) total_standard_gloss
FROM
    orders ord;

-- Q7.5. Find the standard_amt_usd per unit of standard_qty paper. Your solution should use both an aggregation and a mathematical operator.
SELECT
    SUM(ord.standard_amt_usd) / SUM(ord.standard_qty) standard_price_per_unit
FROM
    orders ord;