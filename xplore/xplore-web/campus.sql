-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: localhost    Database: xplore
-- ------------------------------------------------------
-- Server version	5.5.38

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tbl_campus_cn`
--

DROP TABLE IF EXISTS `tbl_campus_cn`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_campus_cn` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `region_id` int(11) DEFAULT NULL,
  `title` varchar(128) DEFAULT NULL,
  `Profile` text,
  `Facts` varchar(16384) DEFAULT NULL,
  `Curriculum` text,
  `weight` int(11) DEFAULT '0',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_campus_cn`
--

LOCK TABLES `tbl_campus_cn` WRITE;
/*!40000 ALTER TABLE `tbl_campus_cn` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_campus_cn` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_campus_en`
--

DROP TABLE IF EXISTS `tbl_campus_en`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_campus_en` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `region_id` int(11) DEFAULT NULL,
  `title` varchar(128) DEFAULT NULL,
  `profile` text,
  `facts` varchar(16384) DEFAULT NULL,
  `curriculum` text,
  `weight` int(11) DEFAULT '0',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_campus_en`
--

LOCK TABLES `tbl_campus_en` WRITE;
/*!40000 ALTER TABLE `tbl_campus_en` DISABLE KEYS */;
INSERT INTO `tbl_campus_en` VALUES (1,1,'title','profile_1','facts_1','curadsf_1',100,'2015-03-12 06:24:12');
/*!40000 ALTER TABLE `tbl_campus_en` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_slider`
--

DROP TABLE IF EXISTS `tbl_slider`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_slider` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `plate_id` int(32) DEFAULT NULL,
  `big_url` varchar(128) DEFAULT NULL,
  `small_url` varchar(128) DEFAULT NULL,
  `brief_cn` varchar(128) DEFAULT NULL,
  `brief_en` varchar(128) DEFAULT NULL,
  `weight` int(11) DEFAULT '0',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_slider`
--

LOCK TABLES `tbl_slider` WRITE;
/*!40000 ALTER TABLE `tbl_slider` DISABLE KEYS */;
INSERT INTO `tbl_slider` VALUES (13,1,'bigurl','smallurl','cn','en',100,'2015-03-11 10:58:18');
/*!40000 ALTER TABLE `tbl_slider` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-03-12 14:28:33
