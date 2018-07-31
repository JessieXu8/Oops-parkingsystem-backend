create table parkinglot(
id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
name varchar (20) not null,
size int not null ,
count_of_cars int default 0,
employeeId BIGINT default null,
status varchar(10) default 'open'
)