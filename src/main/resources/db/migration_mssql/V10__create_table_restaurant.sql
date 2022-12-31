CREATE TABLE ifood_v2.dbo.restaurant (
	id bigint IDENTITY(1,1) NOT NULL,
	address_cep varchar(15) NULL,
	address_coplement varchar(255)NULL,
	address_district varchar(25) NULL,
	address_number varchar(5) NULL,
	address_street varchar(20) NULL,
	name varchar(20) NOT NULL,
	freight_rate numeric(19,2) NOT NULL,
	is_active bit NULL,
	is_open bit NULL,
	create_at datetime NOT NULL,
	update_at datetime NOT NULL,
	address_city_id bigint NULL,
	kitchen_id bigint NOT NULL,
	PRIMARY KEY (id),
	CONSTRAINT fk_address_city_id FOREIGN KEY (address_city_id) REFERENCES ifood_v2.dbo.city(id),
	CONSTRAINT fk_kitchen_id FOREIGN KEY (kitchen_id) REFERENCES ifood_v2.dbo.kitchen(id)
);