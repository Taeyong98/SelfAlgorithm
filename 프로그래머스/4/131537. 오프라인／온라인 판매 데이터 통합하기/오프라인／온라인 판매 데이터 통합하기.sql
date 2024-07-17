-- 코드를 입력하세요
select date_format(a.sales_date, "%Y-%m-%d")as date_format, a.product_id, a.user_id, a.sales_amount
from(
    (SELECT sales_date, product_id, user_id, sales_amount
    from online_sale
    where sales_date like "2022-03%") 
          union all
    (select sales_date, product_id, NULL as user_id, sales_amount
    from offline_sale
    where sales_date like "2022-03%")) as a
order by sales_date asc, product_id asc, user_id asc