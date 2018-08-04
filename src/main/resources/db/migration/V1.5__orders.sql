create table orders(
id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
car_id varchar (50) not null ,
type varchar (20),
status varchar (20),
operation varchar (20),
boy_id BIGINT default null ,
parkinglot_id BIGINT default null,
created_Time varchar default null
)ENGINE=InnoDB  DEFAULT CHARSET=utf8;
INSERT INTO `orders` VALUES (1, '粤A12345', '存车', '无人处理', '指派',null ,null,null );
INSERT INTO `orders` VALUES (2, '粤A88888', '存车', '无人处理', '指派',null ,null,null  );
-- INSERT INTO `orders` VALUES (2, 'car_2', '取车', '', '');
-- INSERT INTO `orders` VALUES (3, 'car_3', '存车', '无人处理', '指派');
-- INSERT INTO `orders` VALUES (4, 'car_4', '取车', '', '');
-- INSERT INTO `orders` VALUES (5, 'car_5', '存车', '无人处理', '指派');