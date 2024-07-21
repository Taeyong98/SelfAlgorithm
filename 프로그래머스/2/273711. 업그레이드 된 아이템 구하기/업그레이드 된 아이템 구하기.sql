select distinct(a.item_id), a.item_name, a.rarity
from ITEM_INFO as a join ITEM_TREE as b
    on a.item_id = b.item_id
where b.parent_item_id in (
    select item_id 
    from ITEM_INFO 
    where rarity = 'RARE'
)
order by a.item_id desc