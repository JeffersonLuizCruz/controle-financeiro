CREATE TABLE ifood_v2.dbo.payment_method (
	id bigint IDENTITY(1,1) NOT NULL,
	description varchar(50) NOT NULL,
	update_at datetime,
	PRIMARY KEY (id)
);