
-- ----------------------------
-- Table structure for `role_privilege`
-- ----------------------------
CREATE TABLE `role_privilege` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL,
  `privilege_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_privilege
-- ----------------------------
INSERT INTO `role_privilege` VALUES ('1', '1', '1');
INSERT INTO `role_privilege` VALUES ('2', '1', '2');
INSERT INTO `role_privilege` VALUES ('3', '1', '3');
INSERT INTO `role_privilege` VALUES ('4', '2', '2');
INSERT INTO `role_privilege` VALUES ('5', '2', '3');
