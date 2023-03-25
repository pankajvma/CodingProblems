-- Q12. In the sf_crime_data table the date are entered in "01/31/2014 08:00:00 AM +0000" format.
-- Our task is to Cast this column to SQL date format
SELECT
    sf.date raw_date,
    (
        RIGHT(LEFT(sf.date, 10), 4) || '-' || LEFT(sf.date, 2) || '-' || RIGHT(LEFT(sf.date, 5), 2)
    ) :: date proper_date
FROM
    sf_crime_data sf;

-- OR --
SELECT
    date orig_date,
    (
        SUBSTR(date, 7, 4) || '-' || LEFT(date, 2) || '-' || SUBSTR(date, 4, 2)
    ) :: DATE new_date
FROM
    sf_crime_data;