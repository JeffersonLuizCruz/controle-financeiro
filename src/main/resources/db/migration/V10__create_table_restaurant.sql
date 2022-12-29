create table restaurant (
	id bigint auto_increment not null,
	address_cep varchar(15) null,
	address_coplement varchar(255) null,
	address_district varchar(25) null,
	address_number varchar(5) null,
	address_street varchar(20) null,
	name varchar(20) not null,
	freight_rate numeric(19,2) not null,
	is_active bit null,
	is_open bit null,
	create_at datetime not null,
	update_at datetime not null,
	address_city_id bigint null,
	kitchen_id bigint not null,

	primary key (id),
	constraint fk_address_city_id foreign key (address_city_id) references city(id),
	constraint fk_kitchen_id foreign key (kitchen_id) references kitchen(id)
) engine=InnoDB default charset=utf8;