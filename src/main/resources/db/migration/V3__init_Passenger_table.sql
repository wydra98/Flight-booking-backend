drop table if exists passengers cascade;

create table passengers
(
    passenger_id  bigint auto_increment primary key,
    pesel         varchar(50) not null,
    first_name    varchar(50) not null,
    surname       varchar(50) not null,
    document_id   varchar(50) not null,
    phone_number  varchar(50) not null,
    email         varchar(50) not null
);


