drop table if exists seats cascade;

create table seats
(
    seat_id        bigint auto_increment primary key,
    seat_number    int not null,
    id_flight      bigint not null,

    foreign key (id_flight) references flights(flight_id)
);







