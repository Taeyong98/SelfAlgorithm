with temp as (
    select id, ntile(4) over (order by size_of_colony desc) as ecoli_rank
    from ecoli_data
)
select  id,
        case
            when ecoli_rank = 1 then 'CRITICAL'
            when ecoli_rank = 2 then 'HIGH'
            when ecoli_rank = 3 then 'MEDIUM'
            when ecoli_rank = 4 then 'LOW'
        end as colony_name
from temp
order by id