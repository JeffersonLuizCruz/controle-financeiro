set foreign_key_checks = 0;

delete from state;
delete from city;
delete from customer;
delete from customer_group;
delete from ifood_v1.group;
delete from group_role;
delete from kitchen;
delete from payment_method;
delete from product;
delete from restaurant;
delete from restaurant_payment_methods;
delete from restaurant_user_owner;
delete from order_item;
delete from ifood_v1.order;
delete from role;

set foreign_key_checks = 1;

alter table city auto_increment = 1;
alter table customer auto_increment = 1;
alter table ifood_v1.group auto_increment = 1;
alter table kitchen auto_increment = 1;
alter table payment_method auto_increment = 1;
alter table product auto_increment = 1;
alter table restaurant auto_increment = 1;
alter table ifood_v1.role auto_increment = 1;
alter table ifood_v1.state auto_increment = 1;
alter table order_item auto_increment = 1;
alter table ifood_v1.order auto_increment = 1;

INSERT INTO ifood_v1.state (id, name) values (1, 'Pernambuco');
INSERT INTO ifood_v1.state (id, name) values (2, 'São Paulo');
INSERT INTO ifood_v1.state (id, name) values (3, 'Rio de Janeiro');

INSERT INTO city (id, name, state_id) values (1, 'Recife', 1);
INSERT INTO city (id, name, state_id) values (2, 'SP Capital', 2);
INSERT INTO city (id, name, state_id) values (3, 'RJ Capital', 3);

INSERT INTO ifood_v1.role (id, description, name) values (1, 'admin', 'admin');
INSERT INTO ifood_v1.role (id, description, name) values (2, 'simple', 'simple');
INSERT INTO ifood_v1.role (id, description, name) values (3, 'basic', 'basic');

INSERT INTO ifood_v1.group (id, name) values (1, 'group admin');
INSERT INTO ifood_v1.group (id, name) values (2, 'group simple');
INSERT INTO ifood_v1.group (id, name) values (3, 'group basic');

INSERT INTO group_role (groups_id, roles_id) values (1, 1);
INSERT INTO group_role (groups_id, roles_id) values (1, 2);
INSERT INTO group_role (groups_id, roles_id) values (1, 3);

INSERT INTO group_role (groups_id, roles_id) values (2, 2);
INSERT INTO group_role (groups_id, roles_id) values (2, 3);
INSERT INTO group_role (groups_id, roles_id) values (3, 3);

INSERT INTO customer (id, create_at, email, name, password) values (1, utc_timestamp, 'jefferson.luiz.cruz@gmail.com', 'Jefferson Luiz', '123456789');
INSERT INTO customer (id, create_at, email, name, password) values (2, utc_timestamp, 'hugo.luiz.cruz@gmail.com', 'hugo Luiz', '123456789');
INSERT INTO customer (id, create_at, email, name, password) values (3, utc_timestamp, 'jeff.luiz.cruz@gmail.com', 'jeff Luiz', '123456789');

INSERT INTO kitchen (id, name) values (1, 'Comida Pernambucana');
INSERT INTO kitchen (id, name) values (2, 'Comida SP');
INSERT INTO kitchen (id, name) values (3, 'Comida RJ');

INSERT INTO customer_group (customer_id, groups_id) values (1, 1);
INSERT INTO customer_group (customer_id, groups_id) values (2, 2);
INSERT INTO customer_group (customer_id, groups_id) values (3, 3);

INSERT INTO restaurant (id, address_cep, address_coplement, address_district, address_number, address_street, name, freight_rate, is_active, is_open, create_at, update_at, address_city_id, kitchen_id)
values (1, '555559200', 'proximo de ibira', 'Pernambuco', '458', 'rua da casa', 'Libebula Comidas', 100, 1, 1, utc_timestamp, utc_timestamp, 1, 1);
INSERT INTO restaurant (id, address_cep, address_coplement, address_district, address_number, address_street, name, freight_rate, is_active, is_open, create_at, update_at, address_city_id, kitchen_id)
values (2, '111119100', 'proximo de timbu', 'São Paulo', '458', 'rua da florida', 'Jacaré Comidas', 200, 0, 0, utc_timestamp, utc_timestamp, 2, 2);
INSERT INTO restaurant (id, address_cep, address_coplement, address_district, address_number, address_street, name, freight_rate, is_active, is_open, create_at, update_at, address_city_id, kitchen_id)
values (3, '222229800', 'proximo de tapui', 'Rio de Janeiro', '23', 'rua de pereira', 'Formiga Comidas', 300, 1, 1, utc_timestamp, utc_timestamp, 3, 3);

INSERT INTO payment_method (id, description, update_at) values (1, 'Cartão de Credito', utc_timestamp);
INSERT INTO payment_method (id, description, update_at) values (2, 'Cartão de Depito', utc_timestamp);
INSERT INTO payment_method (id, description, update_at) values (3, 'PIX', utc_timestamp);

INSERT INTO restaurant_payment_methods (restaurants_id, payment_methods_id) values (1, 1);
INSERT INTO restaurant_payment_methods (restaurants_id, payment_methods_id) values (1, 2);
INSERT INTO restaurant_payment_methods (restaurants_id, payment_methods_id) values (1, 3);

INSERT INTO restaurant_payment_methods (restaurants_id, payment_methods_id) values (2, 1);
INSERT INTO restaurant_payment_methods (restaurants_id, payment_methods_id) values (2, 2);

INSERT INTO restaurant_payment_methods (restaurants_id, payment_methods_id) values (3, 3);

INSERT INTO restaurant_user_owner (restaurant_id, owner_id) values (1, 1);
INSERT INTO restaurant_user_owner (restaurant_id, owner_id) values (1, 2);
INSERT INTO restaurant_user_owner (restaurant_id, owner_id) values (1, 3);

INSERT INTO restaurant_user_owner (restaurant_id, owner_id) values (2, 1);
INSERT INTO restaurant_user_owner (restaurant_id, owner_id) values (2, 2);
INSERT INTO restaurant_user_owner (restaurant_id, owner_id) values (2, 3);

INSERT INTO restaurant_user_owner (restaurant_id, owner_id) values (3, 2);

INSERT INTO product (id, description, is_active, name, price, restaurant_id) values (1, 'Comida do Nordeste', 1, 'Mão de vaca', 150, 1);
INSERT INTO product (id, description, is_active, name, price, restaurant_id) values (2, 'Comida Paulista', 1, 'Pizza', 250, 2);
INSERT INTO product (id, description, is_active, name, price, restaurant_id) values (3, 'Comida Carioca', 1, 'Feijoada', 350, 3);

INSERT INTO ifood_v1.order
(id, code, subtotal, freight_rate, total_amount, address_cep, address_coplement, address_district, address_number, address_street, address_city_id,
status, createAt, confirmationAt, cancellationAt, deliveryAt, payment_method_id, restaurant_id, user_client_id)
VALUES(1, '123456', 300, 20, 320, '', '', '', '', '', null, 'DELIVERED', '2018-01-07 16:11:26', '2018-01-07 16:11:26', null, '2018-01-07 16:11:26', 1, 1, 1);

INSERT INTO ifood_v1.order
(id, code, subtotal, freight_rate, total_amount, address_cep, address_coplement, address_district, address_number, address_street, address_city_id,
status, createAt, confirmationAt, cancellationAt, deliveryAt, payment_method_id, restaurant_id, user_client_id)
VALUES(2, '123451', 100.00, 10.00, 110.00, '', '', '', '', '', null, 'CREATED', '2018-01-07 16:11:26', null, null, null, 2, 2, 2);

INSERT INTO ifood_v1.order
(id, code, subtotal, freight_rate, total_amount, address_cep, address_coplement, address_district, address_number, address_street, address_city_id,
status, createAt, confirmationAt, cancellationAt, deliveryAt, payment_method_id, restaurant_id, user_client_id)
VALUES(3, '123454', 200.00, 25.00, 225.00, '', '', '', '', '', null, 'CONFIRMED', '2018-01-07 16:11:26', '2018-01-07 16:11:26', null, '2018-01-07 16:11:26', 3, 3, 3);

INSERT INTO ifood_v1.order
(id, code, subtotal, freight_rate, total_amount, address_cep, address_coplement, address_district, address_number, address_street, address_city_id,
status, createAt, confirmationAt, cancellationAt, deliveryAt, payment_method_id, restaurant_id, user_client_id)
VALUES(4, '123456', 400.00, 25.00, 425.00, '', '', '', '', '', null, 'CANCELLED', '2018-01-07 16:11:26', '2018-01-07 16:11:26', '2018-01-07 16:11:26', null, 1, 2, 1);

INSERT INTO ifood_v1.order
(id, code, subtotal, freight_rate, total_amount, address_cep, address_coplement, address_district, address_number, address_street, address_city_id,
status, createAt, confirmationAt, cancellationAt, deliveryAt, payment_method_id, restaurant_id, user_client_id)
VALUES(5, '123456', 300.00, 20.00, 320.00, '', '', '', '', '', null, 'DELIVERED', '2018-01-07 16:11:26', '2018-01-07 16:11:26', null, '2018-01-07 16:11:26', 2, 2, 1);

INSERT INTO ifood_v1.order
(id, code, subtotal, freight_rate, total_amount, address_cep, address_coplement, address_district, address_number, address_street, address_city_id,
status, createAt, confirmationAt, cancellationAt, deliveryAt, payment_method_id, restaurant_id, user_client_id)
VALUES(6, '123456', 300, 20, 320, '', '', '', '', '', null, 'DELIVERED', '2018-01-07 16:11:26', '2018-01-07 16:11:26', null, '2018-01-07 16:11:26', 2, 3, 1);

INSERT INTO ifood_v1.order_item
(id, unitPrice, priceTotal, quantity, observation, order_id, product_id)
VALUES(1, 150, 200, 2, '', 1, 1);

INSERT INTO ifood_v1.order_item
(id, unitPrice, priceTotal, quantity, observation, order_id, product_id)
VALUES(2, 250, 500, 1, '', 1, 3);

INSERT INTO ifood_v1.order_item
(id, unitPrice, priceTotal, quantity, observation, order_id, product_id)
VALUES(3, 52, 10, 3, '', 2, 1);

INSERT INTO ifood_v1.order_item
(id, unitPrice, priceTotal, quantity, observation, order_id, product_id)
VALUES(4, 254, 20, 4, '', 3, 1);

INSERT INTO ifood_v1.order_item
(id, unitPrice, priceTotal, quantity, observation, order_id, product_id)
VALUES(5, 52, 10, 5, '', 3, 2);