create table parkinglot(
id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
name varchar (20) not null,
size int not null ,
count_of_cars int default (0),
userId BIGINT,
status varchar(10) default ('open')
);

insert into parkinglot values (1, '停车场A', 10, 0, null, 'open');
insert into parkinglot values (2, '停车场B', 20, 0, 3, 'open');
insert into parkinglot values (3, '停车场C', 5, 0, null, 'logout');
insert into parkinglot values (4, '停车场D', 10, 0, 3, 'open');
insert into parkinglot values (5, '停车场E', 15, 0, null, 'open');
insert into parkinglot values (6, '停车场F', 10, 0, 4, 'open');
insert into parkinglot values (7, '停车场G', 20, 0, null, 'open');