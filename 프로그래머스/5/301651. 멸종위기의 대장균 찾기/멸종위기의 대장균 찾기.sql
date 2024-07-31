-- 코드를 작성해주세요
with recursive A as(
    select id, parent_id, 1 as GENERATION
    from ecoli_data
    where parent_id is null
    
    union all
    
    select e.id, e.parent_id, a.GENERATION + 1 as GENERATION
    from ecoli_data as e join A as a
        on e.parent_id = a.id
)
select count(*) as COUNT, a.GENERATION
from A a
where a.id not in (select parent_id from A
                where parent_id is not null)
group by a.GENERATION
order by a.GENERATION
    

