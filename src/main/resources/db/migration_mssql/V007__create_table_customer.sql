CREATE TABLE ifood_v2.dbo.customer (
	id bigint IDENTITY(1,1) NOT NULL,
	create_at datetime NOT NULL,
	email varchar(55) NOT NULL,
	name varchar(20) NOT NULL,
	password varchar(50) NOT NULL,
	PRIMARY KEY (id)
);