CREATE TABLE ifood_v2.dbo.product (
	id bigint IDENTITY(1,1) NOT NULL,
	description varchar(255) NOT NULL,
	is_active bit NOT NULL,
	name varchar(255) NOT NULL,
	price numeric(19,2) NOT NULL,
	restaurant_id bigint NOT NULL,
	PRIMARY KEY (id),
	CONSTRAINT fk_product_restaurant_id FOREIGN KEY (restaurant_id) REFERENCES ifood_v2.dbo.restaurant(id)
);