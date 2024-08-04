select A.year, abs(B.size_of_colony - A.max_size) as year_dev, B.id
from
(select year(differentiation_date) as year, max(size_of_colony) as max_size
from ecoli_data
group by year(differentiation_date)) as A
join
(select id, year(differentiation_date)as year, SIZE_OF_COLONY 
 from ecoli_data
) as B on
    A.year = B.year
order by A.year , year_dev