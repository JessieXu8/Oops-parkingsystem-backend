CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(200) NOT NULL,
  `name` varchar(50) NOT NULL,
  `email` varchar(20) NOT NULL,
  `phone` varchar(11) NOT NULL,
  `work_status` varchar(20) DEFAULT NULL,
  `account_status` varchar(20) NOT NULL,
  `role_id` bigint(20),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

INSERT INTO `user` VALUES (1, 'root', '$2a$10$2C2TgYHq7Rr.XkCMK5gz5.uIlJuS9Uj7HDCLbdcJjUUNoX5Lz7Mei', '系统管理员', 'm18390990364@163.com', '18390990364', null, 'normal', 1);
INSERT INTO `user` VALUES (2, 'user1', '$2a$10$2C2TgYHq7Rr.XkCMK5gz5.uIlJuS9Uj7HDCLbdcJjUUNoX5Lz7Mei', 'Terry', 'm18390990364@163.com', '18390990364', '下班', 'normal', 2);
INSERT INTO `user` VALUES (3, 'user2', '$2a$10$2C2TgYHq7Rr.XkCMK5gz5.uIlJuS9Uj7HDCLbdcJjUUNoX5Lz7Mei', 'Carol', 'm18390990364@163.com', '18390990364', '下班', 'normal', 3);
INSERT INTO `user` VALUES (4, 'user3', '123456', 'Jessie', 'm18390990364', '18390990364', '下班', 'normal', 3);
INSERT INTO `user` VALUES (5, 'user4', '123456', 'Allen', 'm18390990364', '18390990364', '下班', 'normal', 3);