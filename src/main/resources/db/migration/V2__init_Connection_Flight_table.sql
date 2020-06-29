drop table if exists connections cascade;
drop table if exists flights cascade;


create table connections(
    id bigint auto_increment primary key auto_increment,
    src_airport_id bigint not null,
    dst_airport_id  bigint not null,
    departure_date varchar(50) not null,
    arrival_date varchar(50) not null,

    foreign key (src_airport_id) references airports(id),
    foreign key (src_airport_id) references airports(id)
);

create table flights(
    id bigint auto_increment primary key auto_increment,
    connection_id bigint not null,
    airline_id  bigint not null,
    number_seats int not null,
    price double not null,

    foreign key (connection_id) references connections(id),
    foreign key (airline_id) references airlines(id)
);


