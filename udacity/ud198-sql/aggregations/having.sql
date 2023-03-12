-- Q23.1. How many of the sales reps have more than 5 accounts that they manage?
SELECT
    COUNT(*)
FROM
    (
        SELECT
            acc.sales_rep_id,
            COUNT(*)
        FROM
            accounts acc
        GROUP BY
            1
        HAVING
            COUNT(*) > 5
    ) selection;

-- OR --
SELECT
    COUNT(*) num_reps_above5
FROM
    (
        SELECT
            s.id,
            s.name,
            COUNT(*) num_accounts
        FROM
            accounts a
            JOIN sales_reps s ON s.id = a.sales_rep_id
        GROUP BY
            s.id,
            s.name
        HAVING
            COUNT(*) > 5
        ORDER BY
            num_accounts
    ) AS Table1;

-- Q23.2. How many accounts have more than 20 orders?
SELECT
    COUNT(*)
FROM
    (
        SELECT
            ord.account_id,
            COUNT(*) num_orders
        FROM
            orders ord
        GROUP BY
            1
        HAVING
            COUNT(*) > 20
    ) selection;

-- OR --
SELECT
    a.id,
    a.name,
    COUNT(*) num_orders
FROM
    accounts a
    JOIN orders o ON a.id = o.account_id
GROUP BY
    a.id,
    a.name
HAVING
    COUNT(*) > 20
ORDER BY
    num_orders;

-- Q23.3. Which account has the most orders?
SELECT
    acc.id, acc.name,
    COUNT(*)
FROM
    accounts acc
    LEFT JOIN orders ord ON ord.account_id = acc.id
GROUP BY
    1, 2
ORDER BY
    3 DESC
LIMIT
    1;

-- Q23.4. Which accounts spent more than 30,000 usd total across all orders?
SELECT
    acc.id, acc.name,
    SUM(ord.total_amt_usd) spent_more_thn_30k
FROM
    accounts acc
    LEFT JOIN orders ord ON ord.account_id = acc.id
GROUP BY
    1, 2
HAVING
    SUM(ord.total_amt_usd) > 30000
ORDER BY 2;

-- OR --
SELECT
    ord.account_id,
    SUM(ord.total_amt_usd) spent_more_thn_30k
FROM
    orders ord
GROUP BY
    1
HAVING
    SUM(ord.total_amt_usd) > 30000
ORDER BY 2;

-- Q23.5. Which accounts spent less than 1,000 usd total across all orders?
SELECT
    acc.id, acc.name,
    SUM(ord.total_amt_usd) spent_less_thn_1k
FROM
    accounts acc
    LEFT JOIN orders ord ON ord.account_id = acc.id
GROUP BY
    1, 2
HAVING
    SUM(ord.total_amt_usd) < 1000;

-- OR --
SELECT
    ord.account_id,
    SUM(ord.total_amt_usd) spent_less_thn_1k
FROM
    orders ord
GROUP BY
    1
HAVING
    SUM(ord.total_amt_usd) < 1000;

-- Q23.6. Which account has spent the most with us?
SELECT
    acc.id, acc.name,
    SUM(ord.total_amt_usd) most_active_client
FROM
    accounts acc
    JOIN orders ord ON ord.account_id = acc.id -- Using  inner join here since performing ASC order by in case of outer joins, the null values come on top
GROUP BY
    1, 2
ORDER BY
    3 DESC
LIMIT
    1;

-- Q23.7. Which account has spent the least with us?
SELECT
    acc.id, acc.name,
    SUM(ord.total_amt_usd) least_active_client
FROM
    accounts acc
    LEFT JOIN orders ord ON ord.account_id = acc.id -- When performing ASC order by in case of outer joins, the null values come on top
GROUP BY
    1, 2
ORDER BY
    3
LIMIT
    1;

-- Q23.8. Which accounts used facebook as a channel to contact customers more than 6 times?
SELECT
    acc.id, acc.name,
    COUNT(*) facebook_as_channel
FROM
    accounts acc
    JOIN web_events web ON web.account_id = acc.id
    AND web.channel = 'facebook'
GROUP BY
    1, 2
HAVING
    COUNT(*) > 6
ORDER BY 3;

-- Q23.9. Which account used facebook most as a channel?
SELECT
    acc.id, acc.name,
    COUNT(*) facebook_as_channel
FROM
    accounts acc
    JOIN web_events web ON web.account_id = acc.id
    AND web.channel = 'facebook'
GROUP BY
    1, 2
ORDER BY
    3 DESC
LIMIT 1;

-- Q23.10. Which channel was most frequently used by most accounts?
SELECT
    acc.id, acc.name, web.channel,
    COUNT(*)
FROM
    accounts acc
    JOIN web_events web ON web.account_id = acc.id
GROUP BY
    1, 2, 3
ORDER BY
    4 DESC
LIMIT 10;