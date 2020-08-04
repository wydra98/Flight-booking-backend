drop table if exists tickets cascade;
drop table if exists trips cascade;

create table trips
(
    trip_id        bigint auto_increment primary key,
    id_passenger   bigint not null,
    departure_date date   not null,
    departure_time time   not null,
    purchase_date  date   not null,
    purchase_time  time   not null,
    price          double not null,

    foreign key (id_passenger) references passengers (passenger_id)
);

create table tickets
(
    ticket_id     bigint auto_increment primary key,
    id_passenger  bigint not null,
    id_flight     bigint not null,
    id_trip       bigint not null,
    purchase_date date   not null,
    purchase_time time   not null,
    seat_number   int    not null,
    price         double not null,

    foreign key (id_passenger) references passengers (passenger_id),
    foreign key (id_flight) references flights (flight_id),
    foreign key (id_trip) references trips (trip_id)
);






