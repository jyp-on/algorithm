select count(id) fish_count from fish_info fi
join fish_name_info fni on fi.fish_type = fni.fish_type
where fish_name in ('BASS', 'SNAPPER')