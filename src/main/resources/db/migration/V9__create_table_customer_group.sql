create table customer_group (
	customer_id bigint not null,
	groups_id bigint not null,
	constraint fk_profile_group_id foreign key(groups_id) references ifood_v1.profile_group(id),
	constraint fk_customer_id foreign key(customer_id) references ifood_v1.profile_group(id)
)engine=InnoDB default charset=utf8;