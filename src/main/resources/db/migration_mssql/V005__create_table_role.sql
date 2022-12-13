CREATE TABLE ifood_v2.dbo.[role] (
	id bigint IDENTITY(1,1) NOT NULL,
	description varchar(50) NOT NULL,
	name varchar(50) NOT NULL,
	PRIMARY KEY (id)
);