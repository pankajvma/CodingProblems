-- Q11.1. Provide a table for all web_events associated with account name of Walmart. There should be three columns. 
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

-- Q11.2. Provide a table that provides the region for each sales_rep along with their associated accounts. 
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

-- Q11.3. Provide the name for each region for every order, as well as the account name and the unit price they paid (total_amt_usd/total) for the order. 
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

-------------------------- JOINs and Filtering --------------------------
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
-- Since the inner join only returns matching rows, This Query will give the same result as the Query 2
SELECT
    accounts.*,
    orders.*
FROM
    accounts
    JOIN orders ON accounts.id = orders.account_id
    AND accounts.sales_rep_id = 321500;

-- Q19.1. Provide a table that provides the region for each sales_rep along with their associated accounts. 
-- This time only for the Midwest region. Your final table should include three columns: the region name, the sales rep name, and the account name. 
-- Sort the accounts alphabetically (A-Z) according to account name.
SELECT
    reg.name region_name,
    rep.name sales_rep_name,
    acc.name account_name
FROM
    region reg
    LEFT JOIN sales_reps rep ON rep.region_id = reg.id
    LEFT JOIN accounts acc ON rep.id = acc.sales_rep_id
WHERE
    reg.name = 'Midwest'
ORDER BY
    acc.name;

-- OR --
SELECT
    reg.name region_name,
    rep.name sales_rep_name,
    acc.name account_name
FROM
    region reg
    JOIN sales_reps rep ON rep.region_id = reg.id
    JOIN accounts acc ON rep.id = acc.sales_rep_id
    AND reg.name = 'Midwest'
ORDER BY
    acc.name;

-- Q19.2. Provide a table that provides the region for each sales_rep along with their associated accounts. 
-- This time only for accounts where the sales rep has a first name starting with S and in the Midwest region. 
-- Your final table should include three columns: the region name, the sales rep name, and the account name. 
-- Sort the accounts alphabetically (A-Z) according to account name.
SELECT
    reg.name region_name,
    rep.name sales_rep_name,
    acc.name account_name
FROM
    region reg
    LEFT JOIN sales_reps rep ON rep.region_id = reg.id
    LEFT JOIN accounts acc ON rep.id = acc.sales_rep_id
WHERE
    reg.name = 'Midwest'
    AND rep.name LIKE 'S%'
ORDER BY
    acc.name;

-- Q19.3. Provide a table that provides the region for each sales_rep along with their associated accounts. 
-- This time only for accounts where the sales rep has a last name starting with K and in the Midwest region. 
-- Your final table should include three columns: the region name, the sales rep name, and the account name. 
-- Sort the accounts alphabetically (A-Z) according to account name.
SELECT
    reg.name region_name,
    rep.name sales_rep_name,
    acc.name account_name
FROM
    region reg
    LEFT JOIN sales_reps rep ON rep.region_id = reg.id
    LEFT JOIN accounts acc ON rep.id = acc.sales_rep_id
WHERE
    reg.name = 'Midwest'
    AND rep.name LIKE '% K%'
ORDER BY
    acc.name;

-- Q19.4. Provide the name for each region for every order, as well as the account name and the unit price they paid (total_amt_usd/total) for the order. 
-- However, you should only provide the results if the standard order quantity exceeds 100. 
-- Your final table should have 3 columns: region name, account name, and unit price. In order to avoid a division by zero error, adding .01 to the denominator here is helpful total_amt_usd/(total+0.01).
SELECT
    reg.name region_name,
    acc.name account_name,
    ord.total_amt_usd /(ord.total + 0.01) unit_price
FROM
    region reg
    LEFT JOIN sales_reps rep ON rep.region_id = reg.id
    LEFT JOIN accounts acc ON rep.id = acc.sales_rep_id
    LEFT JOIN orders ord ON acc.id = ord.account_id
WHERE
    ord.standard_qty > 100;

-- Q19.5. Provide the name for each region for every order, as well as the account name and the unit price they paid (total_amt_usd/total) for the order. 
-- However, you should only provide the results if the standard order quantity exceeds 100 and the poster order quantity exceeds 50. 
-- Your final table should have 3 columns: region name, account name, and unit price. 
-- Sort for the smallest unit price first. In order to avoid a division by zero error, adding .01 to the denominator here is helpful (total_amt_usd/(total+0.01).
SELECT
    reg.name region_name,
    acc.name account_name,
    ord.total_amt_usd /(ord.total + 0.01) unit_price
FROM
    region reg
    LEFT JOIN sales_reps rep ON rep.region_id = reg.id
    LEFT JOIN accounts acc ON rep.id = acc.sales_rep_id
    LEFT JOIN orders ord ON acc.id = ord.account_id
WHERE
    ord.standard_qty > 100
    AND ord.poster_qty > 50
ORDER BY
    unit_price;

-- Q19.6. Provide the name for each region for every order, as well as the account name and the unit price they paid (total_amt_usd/total) for the order. 
-- However, you should only provide the results if the standard order quantity exceeds 100 and the poster order quantity exceeds 50. 
-- Your final table should have 3 columns: region name, account name, and unit price. Sort for the largest unit price first. 
-- In order to avoid a division by zero error, adding .01 to the denominator here is helpful (total_amt_usd/(total+0.01).
SELECT
    reg.name region_name,
    acc.name account_name,
    ord.total_amt_usd /(ord.total + 0.01) unit_price
FROM
    region reg
    LEFT JOIN sales_reps rep ON rep.region_id = reg.id
    LEFT JOIN accounts acc ON rep.id = acc.sales_rep_id
    LEFT JOIN orders ord ON acc.id = ord.account_id
WHERE
    ord.standard_qty > 100
    AND ord.poster_qty > 50
ORDER BY
    unit_price;

-- Q19.7. What are the different channels used by account id 1001? Your final table should have only 2 columns: account name and the different channels. 
-- You can try SELECT DISTINCT to narrow down the results to only the unique values.
SELECT
    DISTINCT acc.name,
    web.channel
FROM
    web_events web
    LEFT JOIN accounts acc ON acc.id = web.account_id
WHERE
    acc.id = 1001;

-- Q19.8. Find all the orders that occurred in 2015. Your final table should have 4 columns: occurred_at, account name, order total, and order total_amt_usd.
SELECT
    ord.occurred_at,
    acc.name,
    ord.total,
    ord.total_amt_usd
FROM
    orders ord
    LEFT JOIN accounts acc ON acc.id = ord.account_id
WHERE
    ord.occurred_at BETWEEN '01-01-2015'
    AND '01-01-2016'
ORDER BY
    ord.occurred_at DESC;