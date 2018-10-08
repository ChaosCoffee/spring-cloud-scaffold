CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_code` bigint(20) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `total_amount` decimal(6,2) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
);