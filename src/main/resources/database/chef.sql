CREATE DATABASE `chef` /*!40100 DEFAULT CHARACTER SET utf8 */;

CREATE TABLE `menu` (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_name` varchar(50) NOT NULL,
  PRIMARY KEY (`menu_id`),
  UNIQUE KEY `menu_name_UNIQUE` (`menu_name`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

CREATE TABLE `salad` (
  `salad_id` int(11) NOT NULL AUTO_INCREMENT,
  `salad_name` varchar(50) NOT NULL,
  PRIMARY KEY (`salad_id`),
  UNIQUE KEY `salad_name_UNIQUE` (`salad_name`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

CREATE TABLE `vegetable` (
  `vegetable_id` int(11) NOT NULL AUTO_INCREMENT,
  `vegetable_name` varchar(50) NOT NULL,
  `calories` double NOT NULL,
  `fats` double NOT NULL,
  `proteins` double NOT NULL,
  `carbohydrates` double NOT NULL,
  PRIMARY KEY (`vegetable_id`),
  UNIQUE KEY `vegetable_name_UNIQUE` (`vegetable_name`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

CREATE TABLE `menu_m2m_salad` (
  `menu_id` int(11) NOT NULL,
  `salad_id` int(11) NOT NULL,
  KEY `fk_menu_id` (`menu_id`),
  KEY `fk_salad_id` (`salad_id`),
  CONSTRAINT `fk_menu_id` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`menu_id`),
  CONSTRAINT `fk_salad_id` FOREIGN KEY (`salad_id`) REFERENCES `salad` (`salad_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `salad_m2m_vegetable` (
  `salad_id` int(11) NOT NULL,
  `vegetable_id` int(11) NOT NULL,
  PRIMARY KEY (`salad_id`,`vegetable_id`),
  KEY `fk_vegetable_id_idx` (`vegetable_id`),
  CONSTRAINT `fk_salat_id` FOREIGN KEY (`salad_id`) REFERENCES `salad` (`salad_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_vegetable_id` FOREIGN KEY (`vegetable_id`) REFERENCES `vegetable` (`vegetable_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;