create table city
(
    id   bigint generated by default as identity,
    name varchar(255),
    primary key (id)
);

create table delivery_address
(
    id           bigint generated by default as identity,
    address_line varchar(255),
    email        varchar(255),
    name         varchar(255),
    surname      varchar(255),
    zip_code     varchar(255),
    city_id      bigint,
    primary key (id)
);

create table diet
(
    id           bigint generated by default as identity,
    description  varchar(255),
    image        varchar(255),
    name         varchar(255),
    weekly_price integer not null,
    primary key (id)
);

create table purchase
(
    id                  bigint generated by default as identity,
    created_at          timestamp,
    status              varchar(255),
    weeks               integer not null,
    delivery_address_id bigint,
    diet_id             bigint,
    primary key (id)
);

alter table delivery_address
    add constraint city_fk foreign key (city_id) references city;
alter table purchase
    add constraint delivery_address_fk foreign key (delivery_address_id) references delivery_address;
alter table purchase
    add constraint diet_fk foreign key (diet_id) references diet;