-- Q1. Provide a table for all web_events associated with account name of Walmart. There should be three columns. 
-- Be sure to include the primary_poc, time of the event, and the channel for each event. 
-- Additionally, you might choose to add a fourth column to assure only Walmart events were chosen.
SELECT
    acc.primary_poc,
    web.occurred_at,
    web.channel,
    acc.name
FROM
    web_events web
    JOIN accounts acc ON web.account_id = acc.id
WHERE
    acc.name = 'Walmart';

-- Q2. Provide a table that provides the region for each sales_rep along with their associated accounts. 
-- Your final table should include three columns: the region name, the sales rep name, and the account name. 
-- Sort the accounts alphabetically (A-Z) according to account name.
SELECT
    reg.name region_name,
    rep.name sales_rep_name,
    acc.name account_name
FROM
    sales_reps rep
    JOIN accounts acc ON rep.id = acc.sales_rep_id
    JOIN region reg ON rep.region_id = reg.id;

-- Q3. Provide the name for each region for every order, as well as the account name and the unit price they paid (total_amt_usd/total) for the order. 
-- Your final table should have 3 columns: region name, account name, and unit price. 
-- A few accounts have 0 for total, so I divided by (total + 0.01) to assure not dividing by zero.
SELECT
    reg.name region_name,
    acc.name account_name,
    (ord.total_amt_usd /(ord.total + 0.01)) unit_price
FROM
    sales_reps rep
    JOIN accounts acc ON rep.id = acc.sales_rep_id
    JOIN region reg ON rep.region_id = reg.id
    JOIN orders ord ON ord.account_id = acc.id;

-- JOINs and Filtering

-- Query 1
-- This Query will Select a joined table that satisfies all the given condition/s. 
-- And since it is a LEFT JOIN everything from the LEFT table will be included even for the rows where both the conditions doesn't fullfil.
-- For such rows the right table (orders) columns will have NULL cells.
SELECT
    accounts.*,
    orders.*
FROM
    accounts
    LEFT JOIN orders ON accounts.id = orders.account_id
    AND accounts.sales_rep_id = 321500;

-- Query 2
-- This Query will Select a joined table that satisfies all the given condition/s. 
-- And since it is a LEFT JOIN everything from the LEFT table will be included even for the rows where both the conditions doesn't fullfil.
-- After selecting the table it will apply the condition mentioned under the WHERE clause.
-- It is Similar to when we apply the an INNER JOIN and in the joining condition we include the condition mentioned under the WHERE clause.
SELECT
    accounts.*,
    orders.*
FROM
    accounts
    LEFT JOIN orders ON accounts.id = orders.account_id
WHERE
    accounts.sales_rep_id = 321500;

-- Query 3
-- This Query will give the same result as the Query 2
 
SELECT
    accounts.*,
    orders.*
FROM
    accounts
    JOIN orders ON accounts.id = orders.account_id
	AND
    accounts.sales_rep_id = 321500;