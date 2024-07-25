-- 코드를 작성해주세요
select B.id, count(A.parent_id) as CHILD_COUNT
from ecoli_data as A right join ecoli_data as B
    on A.parent_id = B.id
group by B.id
order by B.id
