-- Q11.1. When was the earliest order ever placed? You only need to return the date.
SELECT
    MIN(ord.occurred_at)
FROM
    orders ord;

-- Q11.2. Try performing the same query as in question 1 without using an aggregation function.
SELECT
    ord.occurred_at
FROM
    orders ord
ORDER BY
    ord.occurred_at
LIMIT
    1;

-- Q11.3. When did the most recent (latest) web_event occur?
SELECT
    MAX(web.occurred_at)
FROM
    web_events web;

-- Q11.4. Try to perform the result of the previous query without using an aggregation function.
SELECT
    web.occurred_at
FROM
    web_events web
ORDER BY
    web.occurred_at DESC
LIMIT
    1;

-- Q11.5. Find the mean (AVERAGE) amount spent per order on each paper type, as well as the mean amount of each paper type purchased per order. 
-- Your final answer should have 6 values - one for each paper type for the average number of sales, as well as the average amount.
SELECT
    AVG(ord.standard_amt_usd) avg_standard_amt_usd,
    AVG(ord.gloss_amt_usd) avg_gloss_amt_usd,
    AVG(ord.poster_amt_usd) avg_poster_amt_usd,
    AVG(ord.standard_qty) avg_standard_qty,
    AVG(ord.gloss_qty) avg_gloss_qty,
    AVG(ord.poster_qty) avg_poster_qty
FROM
    orders ord;

-- Q11.6. Via the video, you might be interested in how to calculate the MEDIAN. 
-- Though this is more advanced than what we have covered so far try finding - what is the MEDIAN total_usd spent on all orders?
SELECT
    ordered_orders.row_number,
    ordered_orders.total_amt_usd
FROM
    (
        SELECT
            ROW_NUMBER() OVER(
                ORDER BY
                    ord.total_amt_usd
            ),
            ord.total_amt_usd
        FROM
            orders ord
    ) ordered_orders
WHERE
    ordered_orders.row_number = (
        SELECT
            COUNT(*)
        FROM
            orders
    ) / 2;