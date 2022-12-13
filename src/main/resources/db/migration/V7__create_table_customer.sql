create table customer (
	id bigint auto_increment not null,
	create_at datetime not null,
	email varchar(55) not null,
	name varchar(20) not null,
	password varchar(50) not null,
	primary key (id)
)engine=InnoDB default charset=utf8;