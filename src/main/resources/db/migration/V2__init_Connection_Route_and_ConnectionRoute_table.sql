drop table if exists connections cascade;
/*drop table if exists routes cascade;
drop table if exists routeconnections cascade;*/

create table connections(
    connection_id bigint auto_increment ,
    airport_src_id bigint not null,
    airport_dst_id  bigint not null,
    airline_id bigint not null,
    number_seats int not null,
    departure_date date  not null,
    arrival_date date not null,
    departure_time time  not null,
    arrival_time time not null,
    price double not null,

    foreign key (airport_src_id) references airports(airport_id),
    foreign key (airport_dst_id) references airports(airport_id),
    foreign key (airline_id) references airlines(airline_id)
);
/*
create table routes(
    route_id bigint primary key auto_increment,
    airline_id  bigint not null,
    airport_src_id  bigint not null,
    airport_dst_id  bigint not null,
    foreign key (airline_id ) references airlines(airline_id),
    foreign key (airport_src_id) references airports(airport_id),
    foreign key (airport_dst_id) references airports(airport_id)
);

create table routeconnections(
    routeconnection_id bigint primary key auto_increment,
    connection_id  bigint not null,
    route_id  bigint not null,
    foreign key (connection_id) references connections(connection_id),
    foreign key (route_id) references routes(route_id)
);
*/
