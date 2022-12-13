create table payment_method (
	id bigint auto_increment not null,
	description varchar(50) not null,
	update_at datetime,
	primary key (id)
)engine=InnoDB default charset=utf8;