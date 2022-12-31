CREATE TABLE ifood_v2.dbo.restaurant_user_owner (
	restaurant_id bigint NOT NULL,
	owner_id bigint NOT NULL,
	CONSTRAINT fk_restaurant_id FOREIGN KEY (restaurant_id) REFERENCES ifood_v2.dbo.restaurant(id),
	CONSTRAINT fk_owner_id FOREIGN KEY (owner_id) REFERENCES ifood_v2.dbo.customer(id)
);