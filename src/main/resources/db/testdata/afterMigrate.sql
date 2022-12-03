DELETE FROM city;
DELETE FROM customer;
DELETE FROM customer_group;
DELETE FROM [group];
DELETE FROM group_role;
DELETE FROM kitchen;
DELETE FROM payment_method;
DELETE FROM product;
DELETE FROM restaurant;
DELETE FROM restaurant_payment_methods;
DELETE FROM restaurant_user_owner;
DELETE FROM [role];
DELETE FROM state ;


DBCC CHECKIDENT (city, RESEED, 0);
DBCC CHECKIDENT (customer, RESEED, 0);
DBCC CHECKIDENT ([group], RESEED, 0);
DBCC CHECKIDENT (kitchen, RESEED, 0);
DBCC CHECKIDENT (payment_method, RESEED, 0);
DBCC CHECKIDENT (product, RESEED, 0);
DBCC CHECKIDENT (restaurant, RESEED, 0);
DBCC CHECKIDENT ([role], RESEED, 0);
DBCC CHECKIDENT (state, RESEED, 0);