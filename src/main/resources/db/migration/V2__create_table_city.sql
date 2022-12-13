create table city (
	id bigint auto_increment not null,
	name varchar(20) not null,
	state_id bigint not null,
	primary key(id),
	constraint fk_id_city foreign key(state_id) references state(id)
)engine=InnoDB default charset=utf8;