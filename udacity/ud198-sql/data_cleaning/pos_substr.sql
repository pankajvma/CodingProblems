-- Q6.1. Use the accounts table to create first and last name columns that hold the first and last names for the primary_poc.
SELECT
    LEFT(acc.primary_poc, STRPOS(acc.primary_poc, ' ') - 1) first_name, -- Subtracting 1 to exclude ' '
    RIGHT(
        acc.primary_poc,
        LENGTH(acc.primary_poc) - STRPOS(acc.primary_poc, ' ') -- extracting surname length from right
    ) last_name
FROM
    accounts acc;

-- Q6.2. Now see if you can do the same thing for every rep name in the sales_reps table. Again provide first and last name columns.
SELECT
    LEFT(rep.name, STRPOS(rep.name, ' ') - 1) first_name, -- Subtracting 1 to exclude ' '
    RIGHT(
        rep.name,
        LENGTH(rep.name) - STRPOS(rep.name, ' ')
    ) last_name
FROM
    sales_reps rep;