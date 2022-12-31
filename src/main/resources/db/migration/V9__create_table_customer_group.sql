create table customer_group (
	customer_id bigint not null,
	groups_id bigint not null,
	constraint fk_group_id foreign key(groups_id) references ifood_v1.group(id),
	constraint fk_customer_id foreign key(customer_id) references ifood_v1.customer(id)
)engine=InnoDB default charset=utf8;