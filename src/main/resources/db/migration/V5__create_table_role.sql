create table role (
	id bigint auto_increment not null,
	description varchar(50) not null,
	name varchar(50) not null,
	primary key(id)
)engine=InnoDB default charset=utf8;