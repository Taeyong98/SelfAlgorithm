-- 코드를 작성해주세요
select D.id, C.fish_name, D.length
from fish_info as D join
(select max(A.length) as max_length, B.fish_type, B.fish_name
from fish_info as A join fish_name_info as B
    on A.fish_type = B.fish_type
group by B.fish_type, B.fish_name) as C
on D.fish_type = C.fish_type
where D.length = C.max_length
