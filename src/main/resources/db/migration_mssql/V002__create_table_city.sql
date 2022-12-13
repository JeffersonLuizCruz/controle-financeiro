CREATE TABLE city (
	id bigint IDENTITY(1,1) NOT NULL,
	name varchar(20) NOT NULL,
	state_id bigint NOT NULL,
	PRIMARY KEY (id),
	CONSTRAINT fk_id_city FOREIGN KEY (state_id) REFERENCES ifood_v2.dbo.state(id)
);