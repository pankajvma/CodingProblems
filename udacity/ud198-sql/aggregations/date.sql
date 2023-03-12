-- Q27.1. Find the sales in terms of total dollars for all orders in each year, ordered from greatest to least. Do you notice any trends in the yearly sales totals?
SELECT
    DATE_PART('year', ord.occurred_at) sales_year,
    SUM(ord.total_amt_usd) total_sales
FROM
    orders ord
GROUP BY
    1
ORDER BY
    2 DESC;

-- Observation: When we look at the yearly totals, you might notice that 2013 and 2017 have much smaller totals than all other years. 
-- If we look further at the monthly data, we see that for 2013 and 2017 there is only one month of sales for each of these years (12 for 2013 and 1 for 2017). 
-- Therefore, neither of these are evenly represented. 
-- Sales have been increasing year over year, with 2016 being the largest sales to date. At this rate, we might expect 2017 to have the largest sales.

-- Q27.2. Which month did Parch & Posey have the greatest sales in terms of total dollars? Are all months evenly represented by the dataset?

-- In order for this to be 'fair', we should remove the sales from 2013 and 2017. For the same reasons as discussed above.
SELECT
    DATE_PART('month', ord.occurred_at) sales_month,
    SUM(ord.total_amt_usd) total_sales
FROM
    orders ord
WHERE ord.occurred_at BETWEEN '2014-01-01' AND '2017-01-01'
GROUP BY
    1
ORDER BY
    2 DESC;

-- Q27.3. Which year did Parch & Posey have the greatest sales in terms of total number of orders? Are all years evenly represented by the dataset?
SELECT
    DATE_PART('year', ord.occurred_at) sales_year,
    COUNT(*) total_orders
FROM
    orders ord
GROUP BY
    1
ORDER BY
    2 DESC;

-- Q27.4. Which month did Parch & Posey have the greatest sales in terms of total number of orders? Are all months evenly represented by the dataset?

-- December still has the most sales, but interestingly, November has the second most sales (but not the most dollar sales. 
-- To make a fair comparison from one month to another 2017 and 2013 data were removed.
SELECT
    DATE_PART('month', ord.occurred_at) sales_month,
    COUNT(*) total_orders
FROM
    orders ord
WHERE ord.occurred_at BETWEEN '2014-01-01' AND '2017-01-01'
GROUP BY
    1
ORDER BY
    2 DESC;

-- Q27.5. In which month of which year did Walmart spend the most on gloss paper in terms of dollars?
SELECT
    DATE_PART('month', ord.occurred_at) sales_month,
    DATE_PART('year', ord.occurred_at) sales_year,
    SUM(ord.gloss_amt_usd)
FROM
    orders ord
    JOIN accounts acc ON acc.id = ord.account_id
    AND acc.name = 'Walmart'
GROUP BY
    2,
    1
ORDER BY
    3 DESC;

-- OR --
SELECT
    DATE_TRUNC('month', o.occurred_at) ord_date,
    SUM(o.gloss_amt_usd) tot_spent
FROM
    orders o
    JOIN accounts a ON a.id = o.account_id
WHERE
    a.name = 'Walmart'
GROUP BY
    1
ORDER BY
    2 DESC
LIMIT
    1;