select C.ID as ID, C.GENOTYPE as GENOTYPE, P.GENOTYPE AS PARENT_GENOTYPE
from ecoli_data C join ecoli_data P
    on C.parent_id = P.id
where P.genotype & C.genotype = P.genotype
order by C.ID