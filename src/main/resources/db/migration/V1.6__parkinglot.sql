create table parkinglot(
id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
name varchar (20) not null,
size int not null ,
count_of_cars int default (0),
userId BIGINT default null ,
status varchar(10) default ('open')
);

insert into parkinglot values (1, '停车场A', 10, 0, null, 'open');
insert into parkinglot values (2, '停车场B', 20, 0, null, 'open');
insert into parkinglot values (3, '停车场C', 20, 0, null, 'logout');