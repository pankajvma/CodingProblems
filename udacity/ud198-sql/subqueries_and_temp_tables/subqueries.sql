-- Q4. Find the average number of events each channel per day.
SELECT
    eve_count.channel,
    AVG(eve_count.event_count)
FROM
    (
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
    ) eve_count
GROUP BY
    1
ORDER BY
    2 DESC;

-- Q7.1. Query only those orders that took place in the month in which the first order took place.
SELECT
    *
FROM
    orders
WHERE
    DATE_TRUNC('month', occurred_at) = (
        SELECT
            DATE_TRUNC('month', MIN(ord.occurred_at))
        FROM
            orders ord
    );

-- Q7.2. The average amount of standard, gloss, poster paper sold (in terms of quantity), and total amount spent on the first month that any order was placed in the orders table .
SELECT
    AVG(standard_qty) avg_standard_qty,
    AVG(gloss_qty) avg_gloss_qty,
    AVG(poster_qty) avg_poster_qty,
    SUM(total_amt_usd)
FROM
    orders
WHERE
    DATE_TRUNC('month', occurred_at) = (
        SELECT
            DATE_TRUNC('month', MIN(ord.occurred_at))
        FROM
            orders ord
    );

-- Q10.1. Provide the name of the sales_rep in each region with the largest amount of total_amt_usd sales.
SELECT
    top_sales.sales_rep_name,
    top_sales.region_name,
    max_sales_by_region.max_sale
FROM
    (
        -- Query to find maximum total  sale done by a sales_person in  a region
        SELECT
            top_sales.region_name,
            MAX(top_sales.largest_sale) max_sale
        FROM
            (
                -- Query to find total sales done by a sales_person in  a region
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
            ) top_sales
        GROUP BY
            1
    ) max_sales_by_region
    JOIN (
        -- Query to find total sales done by a sales_person in  a region
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
    ) top_sales ON max_sales_by_region.region_name = top_sales.region_name
    AND max_sales_by_region.max_sale = top_sales.largest_sale
ORDER BY
    3;

-- Q10.2. For the region with the largest (sum) of sales total_amt_usd, how many total (count) orders were placed?
SELECT
    max_sales_region.region_name,
    max_sales_region.largest_sale_amt_in_region,
    COUNT(*)
FROM
    (
        -- Largest sum of total_amt_usd in a region
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
    ) max_sales_region
    JOIN sales_reps rep ON max_sales_region.id = rep.region_id
    JOIN accounts acc ON acc.sales_rep_id = rep.id
    JOIN orders ord ON acc.id = ord.account_id
GROUP BY
    1,
    2;

-- Q10.3. How many accounts had more total purchases than the account name which has bought the most standard_qty paper throughout their lifetime as a customer?
SELECT
    COUNT(*)
FROM
    (
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
                    (
                        -- Querying the record for that has purchased maximum number of standard_qty paper
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
                    ) max_std
            )
        ORDER BY
            2 DESC
    ) get_count;

-- Q10.4. For the customer that spent the most (in total over their lifetime as a customer) total_amt_usd, how many web_events did they have for each channel?
SELECT
    max_usd.name,
    web.channel,
    COUNT(*)
FROM
    web_events web
    JOIN (
        -- Querying customer that spent the most (in total over their lifetime as a customer) total_amt_usd
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
    ) max_usd ON max_usd.id = web.account_id
GROUP BY
    1,
    2
ORDER BY
    2 DESC;

-- Q10.5. What is the lifetime average amount spent in terms of total_amt_usd for the top 10 total spending accounts?
SELECT
    AVG(top_ten.avg_usd_spent)
FROM
    (
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
    ) top_ten;

-- Q10.6. What is the lifetime average amount spent in terms of total_amt_usd, including only the companies that spent more per order, on average, than the average of all orders.
SELECT
    AVG(account_avg_exp.company_avg_spent)
FROM
    (
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
    ) account_avg_exp;