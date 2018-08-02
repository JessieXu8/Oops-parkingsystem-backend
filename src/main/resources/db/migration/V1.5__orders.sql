create table orders(
id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
car_id varchar (50) not null ,
type varchar (20),
status varchar (20),
operation varchar (20),
boyId BIGINT default null ,
parkingLotId BIGINT default null
)
-- INSERT INTO `orders` VALUES (1, 'car_1', '存车', '无人处理', '指派');
-- INSERT INTO `orders` VALUES (2, 'car_2', '取车', '', '');
-- INSERT INTO `orders` VALUES (3, 'car_3', '存车', '无人处理', '指派');
-- INSERT INTO `orders` VALUES (4, 'car_4', '取车', '', '');
-- INSERT INTO `orders` VALUES (5, 'car_5', '存车', '无人处理', '指派');