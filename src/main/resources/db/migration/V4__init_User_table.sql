drop table if exists users cascade;

create table users
(
    user_id        bigint auto_increment primary key,
    password       varchar(200) not null,
    role           varchar(50) not null,
    email          varchar(50) not null,
    name           varchar(50) not null,
    surname        varchar(50) not null
);







