-- 코드를 입력하세요
SELECT a.REST_ID, a.REST_NAME, a.FOOD_TYPE, a.FAVORITES,a.ADDRESS, IFNULL(ROUND(AVG(review_score),2),0) AS SCORE
FROM rest_info AS a JOIN rest_review AS b
    ON a.rest_id = b.rest_id
WHERE a.ADDRESS LIKE "서울%"
GROUP BY a.rest_id
ORDER BY score DESC, a.favorites DESC