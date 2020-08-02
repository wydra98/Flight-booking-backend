drop table if exists tickets cascade;
//drop table if exists tickets_flights cascade;


create table tickets(

    ticket_id bigint auto_increment primary key,
    id_passenger bigint not null,
    id_flight bigint not null,
    purchase_date date not null,
    purchase_time time not null,
    seat_number int not null,
    price double not null,

    foreign key(id_passenger) references passengers(passenger_id),
    foreign key(id_flight) references flights(flight_id)
);

-- create table tickets_flights(
--     ticket_flight_id bigint auto_increment primary key,
--     ticket_ticket_id bigint not null,
--     flights_flight_id bigint not null,
--
--     foreign key(ticket_ticket_id) references tickets(ticket_id),
--     foreign key(flights_flight_id) references flights(flight_id)
-- )


