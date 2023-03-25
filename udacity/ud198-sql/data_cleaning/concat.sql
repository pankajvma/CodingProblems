-- Q9.1. Each company in the accounts table wants to create an email address for each primary_poc. 
-- The email address should be the first name of the primary_poc . last name primary_poc @ company name .com.
SELECT
    LEFT(
        acc.primary_poc,
        STRPOS(acc.primary_poc, ' ') - 1 -- Subtracting 1 to exclude ' '
    ) || '.' || RIGHT(
        acc.primary_poc,
        LENGTH(acc.primary_poc) - STRPOS(acc.primary_poc, ' ') -- extracting surname length from right
    ) || '@' || acc.name || '.com' email
FROM
    accounts acc;

-- OR --
-- The below query is much more readable
WITH acc_names AS(
    SELECT
        LEFT(
            acc.primary_poc,
            STRPOS(acc.primary_poc, ' ') - 1 -- Subtracting 1 to exclude ' '
        ) first_name,
        RIGHT(
            acc.primary_poc,
            LENGTH(acc.primary_poc) - STRPOS(acc.primary_poc, ' ') -- extracting surname length from right
        ) last_name,
        acc.name
    FROM
        accounts acc
)
SELECT
    acc.first_name || '.' || acc.last_name || '@' || acc.name || '.com' email
FROM
    acc_names acc;

-- Q9.2. You may have noticed that in the previous solution some of the company names include spaces, which will certainly not work in an email address. 
-- See if you can create an email address that will work by removing all of the spaces in the account name, but otherwise your solution should be just as in question 1.
WITH acc_names AS(
    SELECT
        LEFT(
            acc.primary_poc,
            STRPOS(acc.primary_poc, ' ') - 1 -- Subtracting 1 to exclude ' '
        ) first_name,
        RIGHT(
            acc.primary_poc,
            LENGTH(acc.primary_poc) - STRPOS(acc.primary_poc, ' ') -- extracting surname length from right
        ) last_name,
        acc.name
    FROM
        accounts acc
)
SELECT
    acc.first_name || '.' || acc.last_name || '@' || REPLACE(acc.name, ' ', '') || '.com' email
FROM
    acc_names acc;

-- Q9.3. We would also like to create an initial password, which they will change after their first log in. 
-- The first password will be 
------ the first letter of the primary_poc's first name (lowercase)
------ then the last letter of their first name (lowercase) 
------ the first letter of their last name (lowercase) 
------ the last letter of their last name (lowercase) 
------ the number of letters in their first name
------ the number of letters in their last name
------ and then the name of the company they are working with, all capitalized with no spaces.
WITH acc_names AS(
    SELECT
        LEFT(
            acc.primary_poc,
            STRPOS(acc.primary_poc, ' ') - 1 -- Subtracting 1 to exclude ' '
        ) first_name,
        RIGHT(
            acc.primary_poc,
            LENGTH(acc.primary_poc) - STRPOS(acc.primary_poc, ' ') -- extracting surname length from right
        ) last_name,
        acc.name
    FROM
        accounts acc
)
SELECT
    LOWER(
        LEFT(acc.first_name, 1) || RIGHT(acc.first_name, 1) || LEFT(acc.last_name, 1) || RIGHT(acc.last_name, 1)
    ) || LENGTH(acc.first_name) || LENGTH(acc.last_name) || UPPER(REPLACE(acc.name, ' ', '')) pass
FROM
    acc_names acc;