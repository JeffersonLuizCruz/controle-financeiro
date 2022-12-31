create table restaurant_user_owner (
	restaurant_id bigint not null,
	owner_id bigint not null,
	constraint fk_restaurant_id foreign key(restaurant_id) references restaurant(id),
	constraint fk_owner_id foreign key(owner_id) references customer(id)
) engine=InnoDB default charset=utf8;