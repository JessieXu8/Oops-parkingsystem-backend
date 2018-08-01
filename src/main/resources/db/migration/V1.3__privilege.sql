DROP TABLE IF EXISTS `privilege`;
CREATE TABLE `privilege` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `privilege` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- ----------------------------
-- Records of privilege
-- ----------------------------
INSERT INTO `privilege` VALUES (1, 'user');
INSERT INTO `privilege` VALUES (2, 'parkinglot');
INSERT INTO `privilege` VALUES (3, 'order');