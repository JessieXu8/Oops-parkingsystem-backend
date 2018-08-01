CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(20) NOT NULL,
  `name` varchar(50) NOT NULL,
  `email` varchar(20) NOT NULL,
  `phone` varchar(11) NOT NULL,
  `work_status` varchar(20) DEFAULT NULL,
  `account_status` varchar(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

INSERT INTO `user` VALUES (1, 'root', 'admin', '系统管理员', 'm18390990364@163.com', '18390990364', null, 'normal', 1);
INSERT INTO `user` VALUES (2, 'user1', '123456', 'Terry', 'm18390990364@163.com', '18390990364', NULL, 'normal', 2);
INSERT INTO `user` VALUES (3, 'user2', '123456', 'Carol', 'm18390990364@163.com', '18390990364', NULL, 'normal', 3);
INSERT INTO `user` VALUES (4, 'user3', '123456', 'Jessie', 'm18390990364', '18390990364', NULL, 'normal', 3);
INSERT INTO `user` VALUES (5, 'user4', '123456', 'Allen', 'm18390990364', '18390990364', NULL, 'normal', 3);