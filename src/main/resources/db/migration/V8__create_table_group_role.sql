create table group_role(
	groups_id bigint not null,
	roles_id bigint not null,
	constraint fk_groups_id foreign key (groups_id) references ifood_v1.group(id),
	constraint fk_roles_id foreign key (roles_id) references ifood_v1.group(id)
)engine=InnoDB default charset=utf8;