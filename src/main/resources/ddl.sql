
    create table city (
       id bigint identity not null,
        name varchar(255) not null,
        state_id bigint not null,
        primary key (id)
    );

    create table customer (
       id bigint identity not null,
        create_at datetime not null,
        email varchar(255) not null,
        name varchar(255) not null,
        password varchar(255) not null,
        primary key (id)
    );

    create table customer_group (
       customer_id bigint not null,
        groups_id bigint not null
    );

    create table [group] (
       id bigint identity not null,
        nome varchar(255),
        primary key (id)
    );

    create table group_role (
       groups_id bigint not null,
        roles_id bigint not null
    );

    create table kitchen (
       id bigint identity not null,
        name varchar(255) not null,
        primary key (id)
    );

    create table payment_method (
       id bigint identity not null,
        description varchar(255) not null,
        update_at datetime2,
        primary key (id)
    );

    create table product (
       id bigint identity not null,
        description varchar(255),
        is_active bit,
        name varchar(255),
        price numeric(19,2),
        [restaurant_id] bigint not null,
        primary key (id)
    );

    create table request (
       id bigint identity not null,
        codigo varchar(255),
        data_cancelamento datetime2,
        data_confirmacao datetime2,
        data_criacao datetime2,
        data_entrega datetime2,
        address_cep varchar(255),
        address_coplement varchar(255),
        address_district varchar(255),
        address_number varchar(255),
        address_street varchar(255),
        subtotal numeric(19,2),
        taxa_frete numeric(19,2),
        valor_total numeric(19,2),
        usuario_cliente_id bigint not null,
        address_city_id bigint,
        payment_method_id bigint not null,
        [restaurante_id] bigint not null,
        primary key (id)
    );

    create table [restaurant] (
       id bigint identity not null,
        address_cep varchar(255),
        address_coplement varchar(255),
        address_district varchar(255),
        address_number varchar(255),
        address_street varchar(255),
        create_at datetime not null,
        freight_rate numeric(19,2) not null,
        is_active bit,
        is_open bit,
        name varchar(255) not null,
        update_at datetime not null,
        address_city_id bigint,
        kitchen_id bigint not null,
        primary key (id)
    );

    create table restaurant_payment_methods (
       restaurants_id bigint not null,
        payment_methods_id bigint not null,
        primary key (restaurants_id, payment_methods_id)
    );

    create table restaurant_user_owner (
       restaurant_id bigint not null,
        owner_id bigint not null,
        primary key (restaurant_id, owner_id)
    );

    create table role (
       id bigint identity not null,
        description varchar(255) not null,
        name varchar(255) not null,
        primary key (id)
    );

    create table state (
       id bigint identity not null,
        name varchar(255) not null,
        primary key (id)
    );

    alter table city 
       add constraint FK6p2u50v8fg2y0js6djc6xanit 
       foreign key (state_id) 
       references state;

    alter table customer_group 
       add constraint FK8ti0xpm3tyqdafw9mbmkd3px3 
       foreign key (groups_id) 
       references [group];

    alter table customer_group 
       add constraint FKbopjkmu9mriivehbk9yd6rbvw 
       foreign key (customer_id) 
       references customer;

    alter table group_role 
       add constraint FKjxv7yq9ee9o977xsokeudf2tg 
       foreign key (roles_id) 
       references role;

    alter table group_role 
       add constraint FK2wc9i7s4l79ai96lm630nr6wd 
       foreign key (groups_id) 
       references [group];

    alter table product 
       add constraint FK5ijfxcsw440m7xj8ilygwg4w6 
       foreign key ([restaurant_id]) 
       references [restaurant];

    alter table request 
       add constraint FK4jufierfu9s3hpnql8x71beqe 
       foreign key (usuario_cliente_id) 
       references customer;

    alter table request 
       add constraint FK6694gticog7k5fmdahlhfshg8 
       foreign key (address_city_id) 
       references city;

    alter table request 
       add constraint FK90bn4q929k2u8mc2ndiamo05k 
       foreign key (payment_method_id) 
       references payment_method;

    alter table request 
       add constraint FKeogtoh8m8ut0ltg6gugx5q4v9 
       foreign key ([restaurante_id]) 
       references [restaurant];

    alter table [restaurant] 
       add constraint FK1crorln8m0uututcu1uuwm8nw 
       foreign key (address_city_id) 
       references city;

    alter table [restaurant] 
       add constraint FKprthv6915h0jb4xtukckry5se 
       foreign key (kitchen_id) 
       references kitchen;

    alter table restaurant_payment_methods 
       add constraint FKa3bu8vqg9u3hgmlfqf87nnwvw 
       foreign key (payment_methods_id) 
       references payment_method;

    alter table restaurant_payment_methods 
       add constraint FKrhsgvj39vahe9orb8j5465rhe 
       foreign key (restaurants_id) 
       references [restaurant];

    alter table restaurant_user_owner 
       add constraint FK2bj42ex0230iymj840vxymin2 
       foreign key (owner_id) 
       references customer;

    alter table restaurant_user_owner 
       add constraint FKjjqdo1qnkfdkccyt056y680ox 
       foreign key (restaurant_id) 
       references [restaurant];

    create table city (
       id bigint identity not null,
        name varchar(255) not null,
        state_id bigint not null,
        primary key (id)
    );

    create table customer (
       id bigint identity not null,
        create_at datetime not null,
        email varchar(255) not null,
        name varchar(255) not null,
        password varchar(255) not null,
        primary key (id)
    );

    create table customer_group (
       customer_id bigint not null,
        groups_id bigint not null
    );

    create table [group] (
       id bigint identity not null,
        nome varchar(255),
        primary key (id)
    );

    create table group_role (
       groups_id bigint not null,
        roles_id bigint not null
    );

    create table kitchen (
       id bigint identity not null,
        name varchar(255) not null,
        primary key (id)
    );

    create table payment_method (
       id bigint identity not null,
        description varchar(255) not null,
        update_at datetime2,
        primary key (id)
    );

    create table product (
       id bigint identity not null,
        description varchar(255),
        is_active bit,
        name varchar(255),
        price numeric(19,2),
        [restaurant_id] bigint not null,
        primary key (id)
    );

    create table request (
       id bigint identity not null,
        codigo varchar(255),
        data_cancelamento datetime2,
        data_confirmacao datetime2,
        data_criacao datetime2,
        data_entrega datetime2,
        address_cep varchar(255),
        address_coplement varchar(255),
        address_district varchar(255),
        address_number varchar(255),
        address_street varchar(255),
        subtotal numeric(19,2),
        taxa_frete numeric(19,2),
        valor_total numeric(19,2),
        usuario_cliente_id bigint not null,
        address_city_id bigint,
        payment_method_id bigint not null,
        [restaurante_id] bigint not null,
        primary key (id)
    );

    create table [restaurant] (
       id bigint identity not null,
        address_cep varchar(255),
        address_coplement varchar(255),
        address_district varchar(255),
        address_number varchar(255),
        address_street varchar(255),
        create_at datetime not null,
        freight_rate numeric(19,2) not null,
        is_active bit,
        is_open bit,
        name varchar(255) not null,
        update_at datetime not null,
        address_city_id bigint,
        kitchen_id bigint not null,
        primary key (id)
    );

    create table restaurant_payment_methods (
       restaurants_id bigint not null,
        payment_methods_id bigint not null,
        primary key (restaurants_id, payment_methods_id)
    );

    create table restaurant_user_owner (
       restaurant_id bigint not null,
        owner_id bigint not null,
        primary key (restaurant_id, owner_id)
    );

    create table role (
       id bigint identity not null,
        description varchar(255) not null,
        name varchar(255) not null,
        primary key (id)
    );

    create table state (
       id bigint identity not null,
        name varchar(255) not null,
        primary key (id)
    );

    alter table city 
       add constraint FK6p2u50v8fg2y0js6djc6xanit 
       foreign key (state_id) 
       references state;

    alter table customer_group 
       add constraint FK8ti0xpm3tyqdafw9mbmkd3px3 
       foreign key (groups_id) 
       references [group];

    alter table customer_group 
       add constraint FKbopjkmu9mriivehbk9yd6rbvw 
       foreign key (customer_id) 
       references customer;

    alter table group_role 
       add constraint FKjxv7yq9ee9o977xsokeudf2tg 
       foreign key (roles_id) 
       references role;

    alter table group_role 
       add constraint FK2wc9i7s4l79ai96lm630nr6wd 
       foreign key (groups_id) 
       references [group];

    alter table product 
       add constraint FK5ijfxcsw440m7xj8ilygwg4w6 
       foreign key ([restaurant_id]) 
       references [restaurant];

    alter table request 
       add constraint FK4jufierfu9s3hpnql8x71beqe 
       foreign key (usuario_cliente_id) 
       references customer;

    alter table request 
       add constraint FK6694gticog7k5fmdahlhfshg8 
       foreign key (address_city_id) 
       references city;

    alter table request 
       add constraint FK90bn4q929k2u8mc2ndiamo05k 
       foreign key (payment_method_id) 
       references payment_method;

    alter table request 
       add constraint FKeogtoh8m8ut0ltg6gugx5q4v9 
       foreign key ([restaurante_id]) 
       references [restaurant];

    alter table [restaurant] 
       add constraint FK1crorln8m0uututcu1uuwm8nw 
       foreign key (address_city_id) 
       references city;

    alter table [restaurant] 
       add constraint FKprthv6915h0jb4xtukckry5se 
       foreign key (kitchen_id) 
       references kitchen;

    alter table restaurant_payment_methods 
       add constraint FKa3bu8vqg9u3hgmlfqf87nnwvw 
       foreign key (payment_methods_id) 
       references payment_method;

    alter table restaurant_payment_methods 
       add constraint FKrhsgvj39vahe9orb8j5465rhe 
       foreign key (restaurants_id) 
       references [restaurant];

    alter table restaurant_user_owner 
       add constraint FK2bj42ex0230iymj840vxymin2 
       foreign key (owner_id) 
       references customer;

    alter table restaurant_user_owner 
       add constraint FKjjqdo1qnkfdkccyt056y680ox 
       foreign key (restaurant_id) 
       references [restaurant];

    create table city (
       id bigint identity not null,
        name varchar(255) not null,
        state_id bigint not null,
        primary key (id)
    );

    create table customer (
       id bigint identity not null,
        create_at datetime not null,
        email varchar(255) not null,
        name varchar(255) not null,
        password varchar(255) not null,
        primary key (id)
    );

    create table customer_group (
       customer_id bigint not null,
        groups_id bigint not null
    );

    create table [group] (
       id bigint identity not null,
        nome varchar(255),
        primary key (id)
    );

    create table group_role (
       groups_id bigint not null,
        roles_id bigint not null
    );

    create table kitchen (
       id bigint identity not null,
        name varchar(255) not null,
        primary key (id)
    );

    create table payment_method (
       id bigint identity not null,
        description varchar(255) not null,
        update_at datetime2,
        primary key (id)
    );

    create table product (
       id bigint identity not null,
        description varchar(255),
        is_active bit,
        name varchar(255),
        price numeric(19,2),
        [restaurant_id] bigint not null,
        primary key (id)
    );

    create table request (
       id bigint identity not null,
        codigo varchar(255),
        data_cancelamento datetime2,
        data_confirmacao datetime2,
        data_criacao datetime2,
        data_entrega datetime2,
        address_cep varchar(255),
        address_coplement varchar(255),
        address_district varchar(255),
        address_number varchar(255),
        address_street varchar(255),
        subtotal numeric(19,2),
        taxa_frete numeric(19,2),
        valor_total numeric(19,2),
        usuario_cliente_id bigint not null,
        address_city_id bigint,
        payment_method_id bigint not null,
        [restaurante_id] bigint not null,
        primary key (id)
    );

    create table [restaurant] (
       id bigint identity not null,
        address_cep varchar(255),
        address_coplement varchar(255),
        address_district varchar(255),
        address_number varchar(255),
        address_street varchar(255),
        create_at datetime not null,
        freight_rate numeric(19,2) not null,
        is_active bit,
        is_open bit,
        name varchar(255) not null,
        update_at datetime not null,
        address_city_id bigint,
        kitchen_id bigint not null,
        primary key (id)
    );

    create table restaurant_payment_methods (
       restaurants_id bigint not null,
        payment_methods_id bigint not null,
        primary key (restaurants_id, payment_methods_id)
    );

    create table restaurant_user_owner (
       restaurant_id bigint not null,
        owner_id bigint not null,
        primary key (restaurant_id, owner_id)
    );

    create table role (
       id bigint identity not null,
        description varchar(255) not null,
        name varchar(255) not null,
        primary key (id)
    );

    create table state (
       id bigint identity not null,
        name varchar(255) not null,
        primary key (id)
    );

    alter table city 
       add constraint FK6p2u50v8fg2y0js6djc6xanit 
       foreign key (state_id) 
       references state;

    alter table customer_group 
       add constraint FK8ti0xpm3tyqdafw9mbmkd3px3 
       foreign key (groups_id) 
       references [group];

    alter table customer_group 
       add constraint FKbopjkmu9mriivehbk9yd6rbvw 
       foreign key (customer_id) 
       references customer;

    alter table group_role 
       add constraint FKjxv7yq9ee9o977xsokeudf2tg 
       foreign key (roles_id) 
       references role;

    alter table group_role 
       add constraint FK2wc9i7s4l79ai96lm630nr6wd 
       foreign key (groups_id) 
       references [group];

    alter table product 
       add constraint FK5ijfxcsw440m7xj8ilygwg4w6 
       foreign key ([restaurant_id]) 
       references [restaurant];

    alter table request 
       add constraint FK4jufierfu9s3hpnql8x71beqe 
       foreign key (usuario_cliente_id) 
       references customer;

    alter table request 
       add constraint FK6694gticog7k5fmdahlhfshg8 
       foreign key (address_city_id) 
       references city;

    alter table request 
       add constraint FK90bn4q929k2u8mc2ndiamo05k 
       foreign key (payment_method_id) 
       references payment_method;

    alter table request 
       add constraint FKeogtoh8m8ut0ltg6gugx5q4v9 
       foreign key ([restaurante_id]) 
       references [restaurant];

    alter table [restaurant] 
       add constraint FK1crorln8m0uututcu1uuwm8nw 
       foreign key (address_city_id) 
       references city;

    alter table [restaurant] 
       add constraint FKprthv6915h0jb4xtukckry5se 
       foreign key (kitchen_id) 
       references kitchen;

    alter table restaurant_payment_methods 
       add constraint FKa3bu8vqg9u3hgmlfqf87nnwvw 
       foreign key (payment_methods_id) 
       references payment_method;

    alter table restaurant_payment_methods 
       add constraint FKrhsgvj39vahe9orb8j5465rhe 
       foreign key (restaurants_id) 
       references [restaurant];

    alter table restaurant_user_owner 
       add constraint FK2bj42ex0230iymj840vxymin2 
       foreign key (owner_id) 
       references customer;

    alter table restaurant_user_owner 
       add constraint FKjjqdo1qnkfdkccyt056y680ox 
       foreign key (restaurant_id) 
       references [restaurant];

    create table city (
       id bigint identity not null,
        name varchar(255) not null,
        state_id bigint not null,
        primary key (id)
    );

    create table customer (
       id bigint identity not null,
        create_at datetime not null,
        email varchar(255) not null,
        name varchar(255) not null,
        password varchar(255) not null,
        primary key (id)
    );

    create table customer_group (
       customer_id bigint not null,
        groups_id bigint not null
    );

    create table [group] (
       id bigint identity not null,
        nome varchar(255),
        primary key (id)
    );

    create table group_role (
       groups_id bigint not null,
        roles_id bigint not null
    );

    create table kitchen (
       id bigint identity not null,
        name varchar(255) not null,
        primary key (id)
    );

    create table payment_method (
       id bigint identity not null,
        description varchar(255) not null,
        update_at datetime2,
        primary key (id)
    );

    create table product (
       id bigint identity not null,
        description varchar(255),
        is_active bit,
        name varchar(255),
        price numeric(19,2),
        [restaurant_id] bigint not null,
        primary key (id)
    );

    create table request (
       id bigint identity not null,
        codigo varchar(255),
        data_cancelamento datetime2,
        data_confirmacao datetime2,
        data_criacao datetime2,
        data_entrega datetime2,
        address_cep varchar(255),
        address_coplement varchar(255),
        address_district varchar(255),
        address_number varchar(255),
        address_street varchar(255),
        subtotal numeric(19,2),
        taxa_frete numeric(19,2),
        valor_total numeric(19,2),
        usuario_cliente_id bigint not null,
        address_city_id bigint,
        payment_method_id bigint not null,
        [restaurante_id] bigint not null,
        primary key (id)
    );

    create table [restaurant] (
       id bigint identity not null,
        address_cep varchar(255),
        address_coplement varchar(255),
        address_district varchar(255),
        address_number varchar(255),
        address_street varchar(255),
        create_at datetime not null,
        freight_rate numeric(19,2) not null,
        is_active bit,
        is_open bit,
        name varchar(255) not null,
        update_at datetime not null,
        address_city_id bigint,
        kitchen_id bigint not null,
        primary key (id)
    );

    create table restaurant_payment_methods (
       restaurants_id bigint not null,
        payment_methods_id bigint not null,
        primary key (restaurants_id, payment_methods_id)
    );

    create table restaurant_user_owner (
       restaurant_id bigint not null,
        owner_id bigint not null,
        primary key (restaurant_id, owner_id)
    );

    create table role (
       id bigint identity not null,
        description varchar(255) not null,
        name varchar(255) not null,
        primary key (id)
    );

    create table state (
       id bigint identity not null,
        name varchar(255) not null,
        primary key (id)
    );

    alter table city 
       add constraint FK6p2u50v8fg2y0js6djc6xanit 
       foreign key (state_id) 
       references state;

    alter table customer_group 
       add constraint FK8ti0xpm3tyqdafw9mbmkd3px3 
       foreign key (groups_id) 
       references [group];

    alter table customer_group 
       add constraint FKbopjkmu9mriivehbk9yd6rbvw 
       foreign key (customer_id) 
       references customer;

    alter table group_role 
       add constraint FKjxv7yq9ee9o977xsokeudf2tg 
       foreign key (roles_id) 
       references role;

    alter table group_role 
       add constraint FK2wc9i7s4l79ai96lm630nr6wd 
       foreign key (groups_id) 
       references [group];

    alter table product 
       add constraint FK5ijfxcsw440m7xj8ilygwg4w6 
       foreign key ([restaurant_id]) 
       references [restaurant];

    alter table request 
       add constraint FK4jufierfu9s3hpnql8x71beqe 
       foreign key (usuario_cliente_id) 
       references customer;

    alter table request 
       add constraint FK6694gticog7k5fmdahlhfshg8 
       foreign key (address_city_id) 
       references city;

    alter table request 
       add constraint FK90bn4q929k2u8mc2ndiamo05k 
       foreign key (payment_method_id) 
       references payment_method;

    alter table request 
       add constraint FKeogtoh8m8ut0ltg6gugx5q4v9 
       foreign key ([restaurante_id]) 
       references [restaurant];

    alter table [restaurant] 
       add constraint FK1crorln8m0uututcu1uuwm8nw 
       foreign key (address_city_id) 
       references city;

    alter table [restaurant] 
       add constraint FKprthv6915h0jb4xtukckry5se 
       foreign key (kitchen_id) 
       references kitchen;

    alter table restaurant_payment_methods 
       add constraint FKa3bu8vqg9u3hgmlfqf87nnwvw 
       foreign key (payment_methods_id) 
       references payment_method;

    alter table restaurant_payment_methods 
       add constraint FKrhsgvj39vahe9orb8j5465rhe 
       foreign key (restaurants_id) 
       references [restaurant];

    alter table restaurant_user_owner 
       add constraint FK2bj42ex0230iymj840vxymin2 
       foreign key (owner_id) 
       references customer;

    alter table restaurant_user_owner 
       add constraint FKjjqdo1qnkfdkccyt056y680ox 
       foreign key (restaurant_id) 
       references [restaurant];
