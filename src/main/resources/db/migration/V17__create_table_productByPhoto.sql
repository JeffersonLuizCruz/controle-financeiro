create table product_photo (
	id bigint auto_increment not null,
	file_name varchar(55) null,
	description varchar(55) null,
	content_type varchar(20) null,
	size_path varchar(50) not null,
	product_id bigint not null unique,

    primary key (id),
    constraint fk_product_photo foreign key (product_id) references product(id)
)engine=InnoDB default charset=utf8;