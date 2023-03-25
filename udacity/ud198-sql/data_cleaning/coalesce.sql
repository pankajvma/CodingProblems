-- Task 1. Execute the below query.
SELECT
    *
FROM
    accounts a
    LEFT JOIN orders o ON a.id = o.account_id
WHERE
    o.total IS NULL;

-- Q16.2. Replace NULL values of accounts.id with orders.account_id in the Query from Task #1
SELECT
    COALESCE(o.id, a.id) filled_id,
    a.name,
    a.website,
    a.lat,
    a.long,
    a.primary_poc,
    a.sales_rep_id,
    o.*
FROM
    accounts a
    LEFT JOIN orders o ON a.id = o.account_id
WHERE
    o.total IS NULL;

-- Q16.3. Replace NULL values of orders.account_id with accounts.id in the Query from Task #1
SELECT
    COALESCE(o.id, a.id) filled_id,
    a.name,
    a.website,
    a.lat,
    a.long,
    a.primary_poc,
    a.sales_rep_id,
    COALESCE(o.account_id, a.id) account_id,
    o.occurred_at,
    o.standard_qty,
    o.gloss_qty,
    o.poster_qty,
    o.total,
    o.standard_amt_usd,
    o.gloss_amt_usd,
    o.poster_amt_usd,
    o.total_amt_usd
FROM
    accounts a
    LEFT JOIN orders o ON a.id = o.account_id
WHERE
    o.total IS NULL;

-- Q16.4. Fill each of the qty and usd columns with 0 for Query from Task #1
SELECT
    COALESCE(o.id, a.id) filled_id,
    a.name,
    a.website,
    a.lat,
    a.long,
    a.primary_poc,
    a.sales_rep_id,
    COALESCE(o.account_id, a.id) account_id,
    o.occurred_at,
    COALESCE(o.standard_qty, 0) standard_qty,
    COALESCE(o.gloss_qty, 0) gloss_qty,
    COALESCE(o.poster_qty, 0) poster_qty,
    COALESCE(o.total, 0) total,
    COALESCE(o.standard_amt_usd, 0) standard_amt_usd,
    COALESCE(o.gloss_amt_usd, 0) gloss_amt_usd,
    COALESCE(o.poster_amt_usd, 0) poster_amt_usd,
    COALESCE(o.total_amt_usd, 0) total_amt_usd
FROM
    accounts a
    LEFT JOIN orders o ON a.id = o.account_id
WHERE
    o.total IS NULL;

-- Q16.5. Modify the Query from Task #1 and count number of ids without using WHERE
SELECT
    COUNT(*)
FROM
    accounts a
    LEFT JOIN orders o ON a.id = o.account_id;

-- Q16.6. Same as last question, however, you have to modify with the select statements used from Q2 - Q4
SELECT
    COALESCE(o.id, a.id) filled_id,
    a.name,
    a.website,
    a.lat,
    a.long,
    a.primary_poc,
    a.sales_rep_id,
    COALESCE(o.account_id, a.id) account_id,
    o.occurred_at,
    COALESCE(o.standard_qty, 0) standard_qty,
    COALESCE(o.gloss_qty, 0) gloss_qty,
    COALESCE(o.poster_qty, 0) poster_qty,
    COALESCE(o.total, 0) total,
    COALESCE(o.standard_amt_usd, 0) standard_amt_usd,
    COALESCE(o.gloss_amt_usd, 0) gloss_amt_usd,
    COALESCE(o.poster_amt_usd, 0) poster_amt_usd,
    COALESCE(o.total_amt_usd, 0) total_amt_usd
FROM
    accounts a
    LEFT JOIN orders o ON a.id = o.account_id;