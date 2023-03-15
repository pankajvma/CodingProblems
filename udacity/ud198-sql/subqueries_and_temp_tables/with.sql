-- Q12. Same as Q4. Find the average number of events each channel per day.
WITH eve_count AS (
    SELECT
        -- Subquery to find the average number of events that occur each day for each channel.
        DATE_TRUNC('day', web.occurred_at),
        web.channel,
        COUNT(*) event_count
    FROM
        web_events web
    GROUP BY
        1,
        2
)
SELECT
    eve_count.channel,
    AVG(eve_count.event_count)
FROM
    eve_count
GROUP BY
    1
ORDER BY
    2 DESC;

-- Q13.1. Provide the name of the sales_rep in each region with the largest amount of total_amt_usd sales.
WITH top_sales AS(
    (
        -- Table to find total sales done by a sales_person in  a region
        SELECT
            rep.name sales_rep_name,
            reg.name region_name,
            SUM(ord.total_amt_usd) largest_sale
        FROM
            region reg
            LEFT JOIN sales_reps rep ON rep.region_id = reg.id
            LEFT JOIN accounts acc ON rep.id = acc.sales_rep_id
            LEFT JOIN orders ord ON acc.id = ord.account_id
        GROUP BY
            1,
            2
        ORDER BY
            3 DESC
    )
),
max_sales_by_region AS (
    -- Table to find maximum total  sale done by a sales_person in  a region
    SELECT
        top_sales.region_name,
        MAX(top_sales.largest_sale) max_sale
    FROM
        top_sales
    GROUP BY
        1
)
SELECT
    top_sales.sales_rep_name,
    top_sales.region_name,
    max_sales_by_region.max_sale
FROM
    max_sales_by_region
    JOIN top_sales ON max_sales_by_region.region_name = top_sales.region_name
    AND max_sales_by_region.max_sale = top_sales.largest_sale
ORDER BY
    3;

-- Q13.2. For the region with the largest sales total_amt_usd, how many total orders were placed?
WITH max_sales_region AS(
    (
        -- Table with largest sum of total_amt_usd in a region
        SELECT
            reg.id,
            reg.name region_name,
            SUM(ord.total_amt_usd) largest_sale_amt_in_region
        FROM
            region reg
            LEFT JOIN sales_reps rep ON rep.region_id = reg.id
            LEFT JOIN accounts acc ON rep.id = acc.sales_rep_id
            LEFT JOIN orders ord ON acc.id = ord.account_id
        GROUP BY
            1,
            2
        ORDER BY
            3 DESC
        LIMIT
            1
    )
)
SELECT
    max_sales_region.region_name,
    max_sales_region.largest_sale_amt_in_region,
    COUNT(*)
FROM
    max_sales_region
    JOIN sales_reps rep ON max_sales_region.id = rep.region_id
    JOIN accounts acc ON acc.sales_rep_id = rep.id
    JOIN orders ord ON acc.id = ord.account_id
GROUP BY
    1,
    2;

-- Q13.3. How many accounts had more total purchases than the account name which has bought the most standard_qty paper throughout their lifetime as a customer?
WITH max_std AS(
    -- Querying the record that has purchased maximum number of standard_qty paper
    SELECT
        acc.name,
        SUM(ord.standard_qty) max_standard_qty,
        SUM(ord.total) max_total_qty
    FROM
        accounts acc
        JOIN orders ord ON ord.account_id = acc.id
    GROUP BY
        1
    ORDER BY
        2 DESC
    LIMIT
        1
), get_count AS (
    -- Extracting the sum at account_name level
    SELECT
        acc.name,
        SUM(ord.total)
    FROM
        accounts acc
        JOIN orders ord ON ord.account_id = acc.id
    GROUP BY
        1
    HAVING
        SUM(ord.total) > (
            -- Extracting the value of total  purchases where standard_qty paper purchase is highest
            SELECT
                max_std.max_total_qty
            FROM
                max_std
        )
    ORDER BY
        2 DESC
)
SELECT
    COUNT(*)
FROM
    get_count;

-- Q13.4. For the customer that spent the most (in total over their lifetime as a customer) total_amt_usd, how many web_events did they have for each channel?
WITH max_usd AS(
    -- Table with customer that spent the most (in total over their lifetime as a customer) total_amt_usd
    SELECT
        acc.id,
        acc.name,
        SUM(ord.total_amt_usd) max_usd_spent
    FROM
        accounts acc
        JOIN orders ord ON ord.account_id = acc.id
    GROUP BY
        1,
        2
    ORDER BY
        3 DESC
    LIMIT
        1
)
SELECT
    max_usd.name,
    web.channel,
    COUNT(*)
FROM
    web_events web
    JOIN max_usd ON max_usd.id = web.account_id
GROUP BY
    1,
    2
ORDER BY
    3 DESC;

-- Q13.5. What is the lifetime average amount spent in terms of total_amt_usd for the top 10 total spending accounts?
WITH top_ten AS (
    -- Querying total_amt_usd for the top 10 total spending accounts
    SELECT
        acc.id,
        acc.name,
        SUM(ord.total_amt_usd) avg_usd_spent
    FROM
        accounts acc
        JOIN orders ord ON ord.account_id = acc.id
    GROUP BY
        1,
        2
    ORDER BY
        3 DESC
    LIMIT
        10
)
SELECT
    AVG(top_ten.avg_usd_spent)
FROM
    top_ten;

-- Q13.6. What is the lifetime average amount spent in terms of total_amt_usd, including only the companies that spent more per order, on average, than the average of all orders.
WITH account_avg_exp AS (
    -- Companies that spent more per order, on average, than the average of all orders.
    SELECT
        acc.name,
        AVG(ord.total_amt_usd) company_avg_spent
    FROM
        accounts acc
        JOIN orders ord ON acc.id = ord.account_id
    GROUP BY
        1
    HAVING
        AVG(ord.total_amt_usd) > (
            -- average of all orders
            SELECT
                AVG(ord.total_amt_usd)
            FROM
                orders ord
        )
    ORDER BY
        2 DESC
)
SELECT
    AVG(account_avg_exp.company_avg_spent)
FROM
    account_avg_exp;