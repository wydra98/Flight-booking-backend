drop table if exists airlines cascade;
drop table if exists airports cascade;

create table airlines
(
    airline_id bigint auto_increment primary key,
    name       varchar(50) not null,
    country    varchar(50) not null
);

create table airports
(
    airport_id bigint auto_increment primary key,
    name       varchar(50) not null,
    city       varchar(50) not null,
    country    varchar(50) not null,
    longitude  float       not null,
    latitude   float       not null,
    timezone   int
)