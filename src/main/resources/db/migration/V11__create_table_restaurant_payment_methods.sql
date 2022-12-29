create table restaurant_payment_methods (
	restaurants_id bigint not null,
	payment_methods_id bigint not null,
	constraint fk_restaurants_id foreign key(restaurants_id) references restaurant(id),
	constraint fk_payment_methods_id foreign key(payment_methods_id) references payment_method(id)
) engine=InnoDB default charset=utf8;