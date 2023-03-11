-- Q20.1. Use DISTINCT to test if there are any accounts associated with more than one region.

SELECT DISTINCT acc.name account_name, reg.name region_name
FROM accounts acc
LEFT JOIN sales_reps rep
ON rep.id = acc.sales_rep_id
LEFT JOIN region reg 
ON rep.region_id = reg.id
ORDER BY acc.name;

-- Q20.2. Have any sales reps worked on more than one account?

SELECT DISTINCT rep.name sales_rep_name, acc.name account_name
FROM accounts acc
LEFT JOIN sales_reps rep
ON rep.id = acc.sales_rep_id
ORDER BY sales_rep_name;