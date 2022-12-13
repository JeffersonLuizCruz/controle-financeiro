CREATE TABLE ifood_v2.dbo.restaurant_payment_methods (
	restaurants_id bigint NOT NULL,
	payment_methods_id bigint NOT NULL,
	CONSTRAINT fk_restaurants_id FOREIGN KEY (restaurants_id) REFERENCES ifood_v2.dbo.restaurant(id),
	CONSTRAINT fk_payment_methods_id FOREIGN KEY (payment_methods_id) REFERENCES ifood_v2.dbo.payment_method(id)
);