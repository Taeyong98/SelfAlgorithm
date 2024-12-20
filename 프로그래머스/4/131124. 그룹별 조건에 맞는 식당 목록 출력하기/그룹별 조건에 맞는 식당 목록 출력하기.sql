-- 코드를 입력하세요
SELECT MP.MEMBER_NAME, RR.REVIEW_TEXT, DATE_FORMAT(RR.REVIEW_DATE,"%Y-%m-%d") REVIEW_DATE
FROM MEMBER_PROFILE MP 
    JOIN
        (SELECT COUNT(*) AS REVIEW_COUNT, MEMBER_ID
        FROM REST_REVIEW 
        GROUP BY MEMBER_ID
        ORDER BY REVIEW_COUNT DESC
        LIMIT 1) AS B
    ON 
        B.MEMBER_ID = MP.MEMBER_ID
    JOIN 
        REST_REVIEW RR
    ON 
        B.MEMBER_ID = RR.MEMBER_ID
        
ORDER BY RR.REVIEW_DATE, RR.REVIEW_TEXT