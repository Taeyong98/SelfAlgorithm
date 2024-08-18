-- 코드를 입력하세요
WITH recursive CTE as( 
    select 0 as HOUR 
    union all 
    select HOUR+1 from CTE 
    where HOUR < 23 
)
SELECT CTE.HOUR, IFNULL(COUNT,0) COUNT
FROM CTE LEFT JOIN 
        (SELECT HOUR(DATETIME) HOUR, COUNT(*) COUNT
        FROM ANIMAL_OUTS
        GROUP BY HOUR(DATETIME)
        ORDER BY HOUR) AS B
        ON CTE.HOUR = B.HOUR
