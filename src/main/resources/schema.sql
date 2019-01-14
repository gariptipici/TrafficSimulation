create table vehicle
(
   id integer not null,
   tank_size double not null,
   consumption_per_5_sec double not null,
   current_fuel_quantity double not null,
   status varchar(255) not null,
   primary key(id)
);
