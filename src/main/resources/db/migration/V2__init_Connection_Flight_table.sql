drop table if exists connections cascade;
drop table if exists flights cascade;


create table connections(
    connection_id bigint auto_increment primary key,
    id_src_airport bigint not null,
    id_dst_airport  bigint not null,
    departure_date date not null,
    arrival_date date not null,
    departure_time time not null,
    arrival_time time not null,

    foreign key (id_src_airport) references airports(airport_id),
    foreign key (id_dst_airport) references airports(airport_id)
);

create table flights(
    flight_id bigint auto_increment primary key auto_increment,
    id_connection bigint not null,
    id_airline  bigint not null,
    number_seats int not null,
    price double not null,

    foreign key (id_connection) references connections(connection_id),
    foreign key (id_airline) references airlines(airline_id)
);


