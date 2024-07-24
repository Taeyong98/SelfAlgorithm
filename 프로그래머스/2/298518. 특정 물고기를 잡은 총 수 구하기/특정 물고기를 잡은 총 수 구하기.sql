-- 코드를 작성해주세요
select count(*) as fish_count
from fish_info as A join fish_name_info as B
    on A.fish_type = B.fish_type
where B.fish_name in ('BASS', 'SNAPPER')