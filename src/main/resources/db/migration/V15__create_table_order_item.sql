create table order_item (
	id bigint auto_increment not null,
	unitPrice numeric(19,2) not null,
	priceTotal numeric(19,2) not null,
	quantity bigint not null,
	observation varchar(200) not null,
	order_id bigint not null,
	product_id bigint not null,
	
	primary key(id),
	constraint fk_order_order_item_id foreign key(order_id) references ifood_v1.order(id),
	constraint fk_product_order_item_id foreign key(product_id) references product(id)
)engine=InnoDB default charset=utf8;