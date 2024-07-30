-- 코드를 작성해주세요
select a.id
from ecoli_data as a join ecoli_data as b
    on a.parent_id = b.id
    join ecoli_data as c
        on b.parent_id = c.id
where c.parent_id is null
order by id

