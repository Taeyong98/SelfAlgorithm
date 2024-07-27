-- 코드를 작성해주세요
select count(*) as COUNT
from ecoli_data
where  (4&genotype or 1&genotype) and not 2&genotype