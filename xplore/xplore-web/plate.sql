use `xplore`

--
-- Table structure for table `tbl_plate_cn`
--

DROP TABLE IF EXISTS `tbl_plate_cn`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_plate_cn` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `plate_id` int(32) DEFAULT NULL,
  `title` varchar(128) DEFAULT NULL,
  `brief` varchar(128) DEFAULT NULL,
  `url` varchar(128) DEFAULT NULL,
  `content` varchar(16384) DEFAULT NULL,
  `weight` int(11) DEFAULT '0',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_plate_cn`
--

LOCK TABLES `tbl_plate_cn` WRITE;
/*!40000 ALTER TABLE `tbl_plate_cn` DISABLE KEYS */;
INSERT INTO `tbl_plate_cn` VALUES (2,1,'你','abc','url_a','aaaaaaaaaaaaaaaaaaaaaaaaaaaa',9,'2015-03-06 05:05:39'),(3,1,'我','bbb','url_b','nbbbbbbbbbbbbbbbbbbb',8,'2015-03-06 05:05:39'),(4,1,'他','ccc','url_c','cccccccccccccccccccc',10,'2015-03-06 05:05:39'),(5,2,'你','ccc','url_c','cccccccccccccccccccc',8,'2015-03-06 05:05:39'),(6,2,'我','ccc','url_c','cccccccccccccccccccc',9,'2015-03-06 05:05:39'),(7,3,'你','ccc','url_c','cccccccccccccccccccc',1,'2015-03-06 05:05:39'),(8,3,'我','ccc','url_c','cccccccccccccccccccc',2,'2015-03-06 05:05:39'),(9,4,'4我','ccc','url_c','cccccccccccccccccccc',3,'2015-03-06 05:05:39'),(10,4,'4他','ccc','url_c','cccccccccccccccccccc',3,'2015-03-06 05:05:39'),(11,4,'4他','ccc','url_c','cccccccccccccccccccc',5,'2015-03-06 05:05:39');
/*!40000 ALTER TABLE `tbl_plate_cn` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_plate_en`
--

DROP TABLE IF EXISTS `tbl_plate_en`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_plate_en` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `plate_id` int(32) DEFAULT NULL,
  `title` varchar(128) DEFAULT NULL,
  `brief` varchar(128) DEFAULT NULL,
  `url` varchar(128) DEFAULT NULL,
  `content` varchar(16384) DEFAULT NULL,
  `weight` int(11) DEFAULT '0',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_plate_en`
--

LOCK TABLES `tbl_plate_en` WRITE;
/*!40000 ALTER TABLE `tbl_plate_en` DISABLE KEYS */;
INSERT INTO `tbl_plate_en` VALUES (2,1,'aaa','abc','url_a','aaaaaaaaaaaaaaaaaaaaaaaaaaaa',9,'2015-03-06 03:45:58'),(3,3,'bbb','bbb','url_b','nbbbbbbbbbbbbbbbbbbb',8,'2015-03-06 03:45:58'),(4,2,'2aa','ccc','url_c','cccccccccccccccccccc',8,'2015-03-06 04:04:32'),(5,1,'aaa','abc','url_a','aaaaaaaaaaaaaaaaaaaaaaaaaaaa',9,'2015-03-06 03:45:58'),(6,1,'aaa','abc','url_a','aaaaaaaaaaaaaaaaaaaaaaaaaaaa',9,'2015-03-06 03:45:58'),(7,1,'aaa','abc','url_a','aaaaaaaaaaaaaaaaaaaaaaaaaaaa',9,'2015-03-06 03:45:58'),(8,1,'aaa','abc','url_a','aaaaaaaaaaaaaaaaaaaaaaaaaaaa',9,'2015-03-06 03:45:58'),(9,1,'aaa','abc','url_a','aaaaaaaaaaaaaaaaaaaaaaaaaaaa',9,'2015-03-06 03:45:58');
/*!40000 ALTER TABLE `tbl_plate_en` ENABLE KEYS */;
UNLOCK TABLES;