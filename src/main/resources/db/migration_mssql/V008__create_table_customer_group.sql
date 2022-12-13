
CREATE TABLE ifood_v2.dbo.customer_group (
	customer_id bigint NOT NULL,
	groups_id bigint NOT NULL,
	CONSTRAINT fk_group_id FOREIGN KEY (groups_id) REFERENCES ifood_v2.dbo.[group](id),
	CONSTRAINT fk_customer_id FOREIGN KEY (customer_id) REFERENCES ifood_v2.dbo.customer(id)
);