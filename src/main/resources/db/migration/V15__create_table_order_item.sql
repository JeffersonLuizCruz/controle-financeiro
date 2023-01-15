create table order_item (
	id bigint auto_increment not null,
	unit_price numeric(19,2) null,
	price_total numeric(19,2) null,
	quantity bigint null,
	observation varchar(200) null,
	order_id bigint not null,
	product_id bigint not null,
	
	primary key(id),
	constraint fk_order_order_item_id foreign key(order_id) references tb_order(id),
	constraint fk_product_order_item_id foreign key(product_id) references product(id)
)engine=InnoDB default charset=utf8;