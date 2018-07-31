CREATE TABLE `role` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `role` VALUES ('1', 'admin');
INSERT INTO `role` VALUES ('2', 'manager');
INSERT INTO `role` VALUES ('3', 'parkingboy');