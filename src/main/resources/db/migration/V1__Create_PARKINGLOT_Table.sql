create table parkinglot(
id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
name varchar (20) not null,
size int not null ,
employeeId BIGINT default null,
status varchar(10) default 'open'
)