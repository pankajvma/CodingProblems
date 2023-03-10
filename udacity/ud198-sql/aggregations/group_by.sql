-- Q14.1. Which account (by name) placed the earliest order? Your solution should have the account name and the date of the order.
SELECT
    acc.name,
    ord.occurred_at latest_order_placed_at
FROM
    accounts acc
    JOIN orders ord ON ord.account_id = acc.id
ORDER BY
    ord.occurred_at
LIMIT
    1;

-- Q14.2. Find the total sales in usd for each account. You should include two columns - the total sales for each company's orders in usd and the company name.
SELECT
    acc.name,
    SUM(ord.total_amt_usd) total_usd_sales
FROM
    accounts acc
    JOIN orders ord ON ord.account_id = acc.id
GROUP BY
    acc.name;

-- Q14.3. Via what channel did the most recent (latest) web_event occur, which account was associated with this web_event? 
-- Your query should return only three values - the date, channel, and account name.
SELECT
    web.occurred_at latest_web_event_occurred_at,
    web.channel latest_web_event_channel,
    acc.name latest_web_event_account_name
FROM
    accounts acc
    JOIN web_events web ON web.account_id = acc.id
ORDER BY
    web.occurred_at DESC
LIMIT
    1;

-- Q14.4. Find the total number of times each type of channel from the web_events was used. 
-- Your final table should have two columns - the channel and the number of times the channel was used.
SELECT
    web.channel,
    COUNT(*) times_used
FROM
    web_events web
GROUP BY
    web.channel;

-- Q14.5. Who was the primary contact associated with the earliest web_event?
SELECT
    acc.primary_poc primary_poc_for_earliest_web_event
FROM
    accounts acc
    JOIN web_events web ON web.account_id = acc.id
ORDER BY
    web.occurred_at
LIMIT
    1;

-- Q14.6. What was the smallest order placed by each account in terms of total usd. 
-- Provide only two columns - the account name and the total usd. Order from smallest dollar amounts to largest.
SELECT
    acc.name,
    MIN(ord.total_amt_usd) smallest_order_amt
FROM
    accounts acc
    JOIN orders ord ON ord.account_id = acc.id
GROUP BY
    acc.name;

-- Q14.7. Find the number of sales reps in each region. 
-- Your final table should have two columns - the region and the number of sales_reps. Order from fewest reps to most reps.
SELECT
    regn.name,
    COUNT(*) frequency
FROM
    region regn
    JOIN sales_reps rep ON rep.region_id = regn.id
GROUP BY
    regn.name
ORDER BY
    frequency;

-- Q16.1. For each account, determine the average amount of each type of paper they purchased across their orders. 
-- Your result should have four columns - one for the account name and one for the average quantity purchased for each of the paper types for each account.
SELECT
    acc.name,
    AVG(ord.standard_qty) avg_standard_qty,
    AVG(ord.gloss_qty) avg_gloss_qty,
    AVG(ord.poster_qty) avg_poster_qty
FROM
    accounts acc
    LEFT JOIN orders ord ON ord.account_id = acc.id
GROUP BY
    acc.name;

-- Q16.2. For each account, determine the average amount spent per order on each paper type. 
-- Your result should have four columns - one for the account name and one for the average amount spent on each paper type.
SELECT
    acc.name,
    AVG(ord.standard_amt_usd) avg_std,
    AVG(ord.gloss_amt_usd) avg_gloss,
    AVG(ord.poster_amt_usd) avg_poster
FROM
    accounts acc
    LEFT JOIN orders ord ON ord.account_id = acc.id
GROUP BY
    acc.name;

-- Q16.3. Determine the number of times a particular channel was used in the web_events table for each sales rep. 
-- Your final table should have three columns - the name of the sales rep, the channel, and the number of occurrences. 
-- Order your table with the highest number of occurrences first.
SELECT
    rep.name,
    web.channel,
    COUNT(*) times_used
FROM
    accounts acc
    LEFT JOIN sales_reps rep ON rep.id = acc.sales_rep_id
    LEFT JOIN web_events web ON acc.id = web.account_id
GROUP BY
    rep.name,
    web.channel
ORDER BY
    times_used DESC;

-- Q16.4. Determine the number of times a particular channel was used in the web_events table for each region. 
-- Your final table should have three columns - the region name, the channel, and the number of occurrences. 
-- Order your table with the highest number of occurrences first.
SELECT
    reg.name,
    web.channel,
    COUNT(*) times_used
FROM
    region reg
    LEFT JOIN sales_reps rep ON rep.region_id = reg.id
    LEFT JOIN accounts acc ON rep.id = acc.sales_rep_id
    LEFT JOIN web_events web ON acc.id = web.account_id
GROUP BY
    reg.name,
    web.channel
ORDER BY
    times_used DESC;