-- Q31.1. Write a query to display for each order, the account ID, total amount of the order, and the level of the order - ‘Large’ or ’Small’ - depending on if the order is $3000 or more, or smaller than $3000.
SELECT
    acc.id,
    ord.total_amt_usd,
    CASE
        WHEN ord.total_amt_usd >= 3000 THEN 'Large'
        ELSE 'Small'
    END AS order_size
FROM
    orders ord
    JOIN accounts acc ON ord.account_id = acc.id;

-- Q31.2. Write a query to display the number of orders in each of three categories, based on the total number of items in each order. 
-- The three categories are: 'At Least 2000', 'Between 1000 and 2000' and 'Less than 1000'.
SELECT
    CASE
        WHEN ord.total_amt_usd >= 2000 THEN 'At Least 2000'
        WHEN ord.total_amt_usd >= 1000 THEN 'Between 1000 and 2000'
        ELSE 'Less than 1000'
    END AS order_category,
    COUNT(*) order_count
FROM
    orders ord
GROUP BY
    1;

-- Q31.3. We would like to understand 3 different levels of customers based on the amount associated with their purchases. 
-- The top level includes anyone with a Lifetime Value (total sales of all orders) greater than 200,000 usd. 
-- The second level is between 200,000 and 100,000 usd. The lowest level is anyone under 100,000 usd. Provide a table that includes the level associated with each account. 
-- You should provide the account name, the total sales of all orders for the customer, and the level. Order with the top spending customers listed first.
SELECT
    acc.name,
    SUM(ord.total_amt_usd),
    CASE
        WHEN ord.total_amt_usd > 200000 THEN 'top'
        WHEN ord.total_amt_usd >= 1000 THEN 'middle'
        ELSE 'low'
    END AS customer_level
FROM
    accounts acc
    LEFT JOIN orders ord ON acc.id = ord.account_id
GROUP BY
    1,
    3
ORDER BY
    2 DESC;

-- Q31.4. We would now like to perform a similar calculation to the first, but we want to obtain the total amount spent by customers only in 2016 and 2017. 
-- Keep the same levels as in the previous question. Order with the top spending customers listed first.
SELECT
    acc.name,
    SUM(ord.total_amt_usd),
    CASE
        WHEN SUM(ord.total_amt_usd) > 200000 THEN 'top'
        WHEN SUM(ord.total_amt_usd) >= 1000 THEN 'middle'
        ELSE 'low'
    END AS order_size
FROM
    accounts acc
    LEFT JOIN orders ord ON acc.id = ord.account_id
WHERE
    DATE_PART('year', occurred_at) IN ('2016', '2017')
GROUP BY
    1
ORDER BY
    2 DESC;

-- Q31.5. We would like to identify top performing sales reps, which are sales reps associated with more than 200 orders. 
-- Create a table with the sales rep name, the total number of orders, and a column with top or not depending on if they have more than 200 orders. 
-- Place the top sales people first in your final table.
SELECT
    rep.name,
    COUNT(*) order_count,
    CASE
        WHEN COUNT(*) > 200 THEN 'Yes'
        ELSE 'No'
    END AS top_performer
FROM
    sales_reps rep
    JOIN accounts acc ON acc.sales_rep_id = rep.id
    JOIN orders ord ON ord.account_id = acc.id
GROUP BY
    1
ORDER BY
    2 DESC;

-- Q31.6. The previous didn't account for the middle, nor the dollar amount associated with the sales. Management decides they want to see these characteristics represented as well. 
-- We would like to identify top performing sales reps, which are sales reps associated with more than 200 orders or more than 750000 in total sales. 
-- The middle group has any rep with more than 150 orders or 500000 in sales.
-- Create a table with the sales rep name, the total number of orders, total sales across all orders, and a column with top, middle, or low depending on this criteria. 
-- Place the top sales people based on dollar amount of sales first in your final table. You might see a few upset sales people by this criteria!
SELECT
    rep.name,
    COUNT(*) order_count,
    SUM(ord.total_amt_usd),
    CASE
        WHEN COUNT(*) > 200
        OR SUM(ord.total_amt_usd) > 750000 THEN 'Top'
        WHEN COUNT(*) > 150
        OR SUM(ord.total_amt_usd) > 500000 THEN 'Middle'
        ELSE 'Low'
    END AS performer
FROM
    sales_reps rep
    JOIN accounts acc ON acc.sales_rep_id = rep.id
    JOIN orders ord ON ord.account_id = acc.id
GROUP BY
    1
ORDER BY
	4 DESC,
    3 DESC,
    2 DESC;