CREATE TABLE `tbl_country` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `title` varchar(64) DEFAULT NULL,
  `img1` varchar(128) DEFAULT NULL,
  `img2` varchar(128) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `test`.`tbl_country` (`title`) VALUES ('england');
INSERT INTO `test`.`tbl_country` (`title`) VALUES ('america');
INSERT INTO `test`.`tbl_country` (`title`) VALUES ('china');