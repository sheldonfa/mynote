CREATE TABLE `camera` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `store_name` varchar(255) DEFAULT NULL,
  `customer_id` varchar(11) DEFAULT NULL,
  `customer_age` int(4) DEFAULT NULL,
  `customer_sex` int(10) DEFAULT NULL,
  `data_generate_time` timestamp NULL,
  `camera_id` varchar(255) DEFAULT NULL,
  `camera_name` varchar(255) DEFAULT NULL,
  `catch_area` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=200832 DEFAULT CHARSET=utf8;

