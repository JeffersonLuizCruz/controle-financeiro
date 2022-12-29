create table product (
	id bigint auto_increment not null,
	description varchar(255) not null,
	is_active bit not null,
	name varchar(255) not null,
	price numeric(19,2) not null,
	restaurant_id bigint not null,

	primary key (id),
	constraint fk_product_restaurant_id foreign key (restaurant_id) references restaurant(id)
)engine=InnoDB default charset=utf8;