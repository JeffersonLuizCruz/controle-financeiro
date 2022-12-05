
EXEC sp_msforeachtable 'ALTER TABLE ? NOCHECK CONSTRAINT all'

DELETE FROM ifood_v2.dbo.city;
DELETE FROM ifood_v2.dbo.customer;
DELETE FROM ifood_v2.dbo.customer_group;
DELETE FROM ifood_v2.dbo.[group];
DELETE FROM ifood_v2.dbo.group_role;
DELETE FROM ifood_v2.dbo.kitchen;
DELETE FROM ifood_v2.dbo.payment_method;
DELETE FROM ifood_v2.dbo.product;
DELETE FROM ifood_v2.dbo.restaurant;
DELETE FROM ifood_v2.dbo.restaurant_payment_methods;
DELETE FROM ifood_v2.dbo.restaurant_user_owner;
DELETE FROM ifood_v2.dbo.[role];
DELETE FROM ifood_v2.dbo.state ;

EXEC sp_msforeachtable 'ALTER TABLE ? WITH CHECK CHECK CONSTRAINT all'

DBCC CHECKIDENT (city, RESEED, 0);
DBCC CHECKIDENT (customer, RESEED, 0);
DBCC CHECKIDENT ([group], RESEED, 0);
DBCC CHECKIDENT (kitchen, RESEED, 0);
DBCC CHECKIDENT (payment_method, RESEED, 0);
DBCC CHECKIDENT (product, RESEED, 0);
DBCC CHECKIDENT (restaurant, RESEED, 0);
DBCC CHECKIDENT ([role], RESEED, 0);
DBCC CHECKIDENT (state, RESEED, 0);


SET IDENTITY_INSERT ifood_v2.dbo.state ON
INSERT INTO ifood_v2.dbo.state (id, name) values (1, 'Pernambuco');
INSERT INTO ifood_v2.dbo.state (id, name) values (2, 'São Paulo');
INSERT INTO ifood_v2.dbo.state (id, name) values (3, 'Rio de Janeiro');
SET IDENTITY_INSERT ifood_v2.dbo.state OFF 

SET IDENTITY_INSERT ifood_v2.dbo.city ON
INSERT INTO ifood_v2.dbo.city (id, name, state_id) values (1, 'Recife', 1);
INSERT INTO ifood_v2.dbo.city (id, name, state_id) values (2, 'SP Capital', 2);
INSERT INTO ifood_v2.dbo.city (id, name, state_id) values (3, 'RJ Capital', 3);
SET IDENTITY_INSERT ifood_v2.dbo.city OFF 


SET IDENTITY_INSERT ifood_v2.dbo.[role] ON
INSERT INTO ifood_v2.dbo.[role] (id, description, name) values (1, 'admin', 'admin');
INSERT INTO ifood_v2.dbo.[role] (id, description, name) values (2, 'simple', 'simple');
INSERT INTO ifood_v2.dbo.[role] (id, description, name) values (3, 'basic', 'basic');
SET IDENTITY_INSERT ifood_v2.dbo.[role] OFF 

SET IDENTITY_INSERT ifood_v2.dbo.[group] ON
INSERT INTO ifood_v2.dbo.[group] (id, name) values (1, 'group admin');
INSERT INTO ifood_v2.dbo.[group] (id, name) values (2, 'group simple');
INSERT INTO ifood_v2.dbo.[group] (id, name) values (3, 'group basic');
SET IDENTITY_INSERT ifood_v2.dbo.[group] OFF

---- START 
INSERT INTO ifood_v2.dbo.group_role (groups_id, roles_id) values (1, 1);
INSERT INTO ifood_v2.dbo.group_role (groups_id, roles_id) values (1, 2);
INSERT INTO ifood_v2.dbo.group_role (groups_id, roles_id) values (1, 3);

INSERT INTO ifood_v2.dbo.group_role (groups_id, roles_id) values (2, 2);
INSERT INTO ifood_v2.dbo.group_role (groups_id, roles_id) values (2, 3);

INSERT INTO ifood_v2.dbo.group_role (groups_id, roles_id) values (3, 3);
----END 

SET IDENTITY_INSERT ifood_v2.dbo.customer  ON
INSERT INTO ifood_v2.dbo.customer (id, create_at, email, name, password) values (1, GETUTCDATE(), 'jefferson.luiz.cruz@gmail.com', 'Jefferson Luiz', '123456789');
INSERT INTO ifood_v2.dbo.customer (id, create_at, email, name, password) values (2, GETUTCDATE(), 'hugo.luiz.cruz@gmail.com', 'hugo Luiz', '123456789');
INSERT INTO ifood_v2.dbo.customer (id, create_at, email, name, password) values (3, GETUTCDATE(), 'jeff.luiz.cruz@gmail.com', 'jeff Luiz', '123456789');
SET IDENTITY_INSERT ifood_v2.dbo.customer OFF

SET IDENTITY_INSERT ifood_v2.dbo.kitchen ON
INSERT INTO ifood_v2.dbo.kitchen (id, name) values (1, 'Comida Pernambucana');
INSERT INTO ifood_v2.dbo.kitchen (id, name) values (2, 'Comida SP');
INSERT INTO ifood_v2.dbo.kitchen (id, name) values (3, 'Comida RJ');
SET IDENTITY_INSERT ifood_v2.dbo.kitchen OFF


INSERT INTO ifood_v2.dbo.customer_group (customer_id, groups_id) values (1, 1);
INSERT INTO ifood_v2.dbo.customer_group (customer_id, groups_id) values (2, 2);
INSERT INTO ifood_v2.dbo.customer_group (customer_id, groups_id) values (3, 3);

SELECT * FROM ifood_v2.dbo.restaurant r ;

SET IDENTITY_INSERT ifood_v2.dbo.restaurant ON
INSERT INTO ifood_v2.dbo.restaurant (id, address_cep, address_coplement, address_district, address_number, address_street, name, freight_rate, is_active, is_open, create_at, update_at, address_city_id, kitchen_id)
values (1, '555559200', 'proximo de ibira', 'Pernambuco', '458', 'rua da casa', 'Libebula Comidas', 100, 1, 1, GETUTCDATE(), GETUTCDATE(), 1, 1);

INSERT INTO ifood_v2.dbo.restaurant (id, address_cep, address_coplement, address_district, address_number, address_street, name, freight_rate, is_active, is_open, create_at, update_at, address_city_id, kitchen_id)
values (2, '111119100', 'proximo de timbu', 'São Paulo', '458', 'rua da florida', 'Jacaré Comidas', 200, 0, 0, GETUTCDATE(), GETUTCDATE(), 2, 2);

INSERT INTO ifood_v2.dbo.restaurant (id, address_cep, address_coplement, address_district, address_number, address_street, name, freight_rate, is_active, is_open, create_at, update_at, address_city_id, kitchen_id)
values (3, '222229800', 'proximo de tapui', 'Rio de Janeiro', '23', 'rua de pereira', 'Formiga Comidas', 300, 1, 1, GETUTCDATE(), GETUTCDATE(), 3, 3);
SET IDENTITY_INSERT ifood_v2.dbo.restaurant OFF

SET IDENTITY_INSERT ifood_v2.dbo.payment_method ON
INSERT INTO ifood_v2.dbo.payment_method (id, description, update_at) values (1, 'Cartão de Credito', GETUTCDATE());
INSERT INTO ifood_v2.dbo.payment_method (id, description, update_at) values (2, 'Cartão de Depito', GETUTCDATE());
INSERT INTO ifood_v2.dbo.payment_method (id, description, update_at) values (3, 'PIX', GETUTCDATE());
SET IDENTITY_INSERT ifood_v2.dbo.payment_method OFF

--- Start
INSERT INTO ifood_v2.dbo.restaurant_payment_methods (restaurants_id, payment_methods_id) values (1, 1);
INSERT INTO ifood_v2.dbo.restaurant_payment_methods (restaurants_id, payment_methods_id) values (1, 2);
INSERT INTO ifood_v2.dbo.restaurant_payment_methods (restaurants_id, payment_methods_id) values (1, 3);

INSERT INTO ifood_v2.dbo.restaurant_payment_methods (restaurants_id, payment_methods_id) values (2, 1);
INSERT INTO ifood_v2.dbo.restaurant_payment_methods (restaurants_id, payment_methods_id) values (2, 2);

INSERT INTO ifood_v2.dbo.restaurant_payment_methods (restaurants_id, payment_methods_id) values (3, 3);
--- End

--- Start
INSERT INTO ifood_v2.dbo.restaurant_user_owner (restaurant_id, owner_id) values (1, 1);
INSERT INTO ifood_v2.dbo.restaurant_user_owner (restaurant_id, owner_id) values (1, 2);
INSERT INTO ifood_v2.dbo.restaurant_user_owner (restaurant_id, owner_id) values (1, 3);

INSERT INTO ifood_v2.dbo.restaurant_user_owner (restaurant_id, owner_id) values (2, 1);
INSERT INTO ifood_v2.dbo.restaurant_user_owner (restaurant_id, owner_id) values (2, 2);
INSERT INTO ifood_v2.dbo.restaurant_user_owner (restaurant_id, owner_id) values (2, 3);

INSERT INTO ifood_v2.dbo.restaurant_user_owner (restaurant_id, owner_id) values (3, 2);
--- End

SET IDENTITY_INSERT ifood_v2.dbo.product ON
INSERT INTO ifood_v2.dbo.product (id, description, is_active, name, price, restaurant_id) values (1, 'Comida do Nordeste', 1, 'Mão de vaca', 150, 1);
INSERT INTO ifood_v2.dbo.product (id, description, is_active, name, price, restaurant_id) values (2, 'Comida Paulista', 1, 'Pizza', 250, 2);
INSERT INTO ifood_v2.dbo.product (id, description, is_active, name, price, restaurant_id) values (3, 'Comida Carioca', 1, 'Feijoada', 350, 3);
SET IDENTITY_INSERT ifood_v2.dbo.product OFF