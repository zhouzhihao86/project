-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: localhost    Database: xplore
-- ------------------------------------------------------
-- Server version	5.6.23

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
-- Table structure for table `tbl_admin`
--

DROP TABLE IF EXISTS `tbl_admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_admin` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) DEFAULT NULL,
  `password` varchar(256) DEFAULT NULL,
  `department_id` int(32) DEFAULT NULL,
  `real_name` varchar(32) DEFAULT NULL,
  `mobile` varchar(16) DEFAULT NULL,
  `rec_st` int(32) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_admin`
--

LOCK TABLES `tbl_admin` WRITE;
/*!40000 ALTER TABLE `tbl_admin` DISABLE KEYS */;
INSERT INTO `tbl_admin` VALUES (1,'admin','21232f297a57a5a743894a0e4a801fc3',1,'zzh','13918395294',1,'2014-12-14 00:37:01'),(2,'adminadmin','21232f297a57a5a743894a0e4a801fc3',1,'1','',1,'2014-11-25 07:59:02');
/*!40000 ALTER TABLE `tbl_admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_admin_role`
--

DROP TABLE IF EXISTS `tbl_admin_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_admin_role` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `admin_id` int(32) DEFAULT NULL,
  `role_id` int(32) DEFAULT NULL,
  `rec_st` int(32) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_admin_role`
--

LOCK TABLES `tbl_admin_role` WRITE;
/*!40000 ALTER TABLE `tbl_admin_role` DISABLE KEYS */;
INSERT INTO `tbl_admin_role` VALUES (1,1,1,1,'2014-11-25 05:30:28'),(2,1,2,1,'2014-11-25 05:30:28'),(3,1,3,1,'2014-12-14 07:06:06'),(4,2,1,1,'2014-12-14 07:06:06'),(5,2,2,1,'2014-12-14 07:06:06'),(6,2,3,1,'2014-12-14 07:06:06');
/*!40000 ALTER TABLE `tbl_admin_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_config`
--

DROP TABLE IF EXISTS `tbl_config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_config` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `key` varchar(64) DEFAULT NULL,
  `value` varchar(512) DEFAULT NULL,
  `system_id` int(32) DEFAULT NULL,
  `rec_st` int(32) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_config`
--

LOCK TABLES `tbl_config` WRITE;
/*!40000 ALTER TABLE `tbl_config` DISABLE KEYS */;
INSERT INTO `tbl_config` VALUES (1,'context_path','http://localhost:8080/xplore-web',1,1,'2015-03-02 07:17:29'),(2,'proxy_location','http://localhost:8080/xplore-web/admin/',1,1,'2015-03-02 07:17:29'),(3,'fileUpload_location','E:\\',1,1,'2014-12-22 07:24:30'),(4,'page_size','10',1,1,'2014-12-28 07:43:13'),(5,'web_page_size','8',1,1,'2014-12-31 05:10:43'),(6,'total_cnt','38',1,1,'2015-01-09 20:00:00'),(7,'key_admin_path','http://localhost:8080/xplore-web',1,1,'2015-03-02 07:17:29');
/*!40000 ALTER TABLE `tbl_config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_perm`
--

DROP TABLE IF EXISTS `tbl_perm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_perm` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `uri` varchar(64) DEFAULT NULL,
  `name` varchar(32) DEFAULT NULL,
  `desc` varchar(64) DEFAULT NULL,
  `rec_st` int(32) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `resource_id` int(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_perm`
--

LOCK TABLES `tbl_perm` WRITE;
/*!40000 ALTER TABLE `tbl_perm` DISABLE KEYS */;
INSERT INTO `tbl_perm` VALUES (1,'list','公司业绩',NULL,1,'2014-12-23 06:04:05',1),(2,'list','图片新闻',NULL,1,'2014-12-24 18:49:21',3),(3,'list','轮播图',NULL,1,'2014-12-24 07:11:55',4),(4,'list','视频',NULL,1,'2014-12-24 20:14:33',5),(5,'add','视频',NULL,1,'2014-12-24 20:14:33',5),(6,'list','查看企业文化',NULL,1,'2014-12-24 06:19:37',7),(7,'edit','编辑公司业绩',NULL,1,'2014-12-23 06:04:05',1),(9,'del','删除公司业绩',NULL,1,'2014-12-23 06:04:05',1),(10,'add','新增管理员',NULL,1,'2014-11-22 10:19:57',1),(11,'list','行业建设列表',NULL,1,'2014-12-24 06:51:50',8),(12,'edit','编辑行业建设',NULL,1,'2014-12-24 06:51:50',8),(13,'list','公司动态',NULL,1,'2014-12-23 07:12:47',2),(14,'list','服务项目列表',NULL,1,'2014-12-24 06:47:29',6),(15,'add','新增服务项目',NULL,1,'2014-12-24 06:47:29',6),(16,'edit','编辑服务项目',NULL,1,'2014-12-24 06:47:29',6),(17,'del','删除服务项目',NULL,1,'2014-12-24 06:47:29',6),(20,'list','在线咨询',NULL,1,'2014-12-24 18:08:51',9),(21,'del','在线咨询',NULL,1,'2014-12-24 18:08:51',9),(24,'edit','编辑企业文化',NULL,1,'2014-12-24 06:19:37',7),(25,'del','删除企业文化',NULL,1,'2014-12-24 06:19:37',7),(26,'add','新增公司动态',NULL,1,'2014-12-23 07:12:47',2),(27,'edit','编辑公司动态',NULL,1,'2014-12-23 07:12:47',2),(28,'del','删除公司动态',NULL,1,'2014-12-23 07:12:47',2),(29,'add','新增企业文化',NULL,1,'2014-12-02 05:13:34',7),(30,'add','新增行业建设',NULL,1,'2014-11-24 04:44:20',8),(31,'del','删除行业建设',NULL,1,'2014-11-24 04:44:20',8),(32,'add','轮播图',NULL,1,'2014-11-18 07:19:02',4),(33,'del','轮播图',NULL,1,'2014-11-18 07:19:02',4),(34,'edit','轮播图',NULL,1,'2014-11-18 07:19:02',4),(35,'add','图片新闻',NULL,1,'2014-12-24 18:49:21',3),(36,'edit','图片新闻',NULL,1,'2014-12-24 18:49:21',3),(37,'del','图片新闻',NULL,1,'2014-12-24 18:49:21',3),(38,'del','视频',NULL,1,'2014-11-18 08:09:07',5),(39,'edit','视频',NULL,1,'2014-11-18 08:09:07',5),(40,'add','公司荣誉',NULL,1,'2014-12-24 21:00:37',10),(41,'edit','公司荣誉',NULL,1,'2014-12-24 21:00:37',10),(42,'del','公司荣誉',NULL,1,'2014-12-24 21:00:37',10),(43,'list','公司荣誉',NULL,1,'2014-12-24 21:00:37',10),(44,'add','党政建设',NULL,1,'2014-12-28 07:38:50',11),(45,'del','党政建设',NULL,1,'2014-12-28 07:38:50',11),(46,'edit','党政建设',NULL,1,'2014-12-28 07:38:50',11),(47,'list','党政建设',NULL,1,'2014-12-28 07:38:50',11);
/*!40000 ALTER TABLE `tbl_perm` ENABLE KEYS */;
UNLOCK TABLES;

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
  `parent_url` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_plate_cn`
--

LOCK TABLES `tbl_plate_cn` WRITE;
/*!40000 ALTER TABLE `tbl_plate_cn` DISABLE KEYS */;
INSERT INTO `tbl_plate_cn` VALUES (2,1,'67','abc','url_a','aaaaaaaaaaaaaaaaaaaaaaaaaaaa',9,'2015-03-08 04:08:11','234'),(3,1,'��','bbb','url_b','nbbbbbbbbbbbbbbbbbbb',8,'2015-03-08 04:08:11','234'),(4,1,'��','ccc','url_c','cccccccccccccccccccc',10,'2015-03-08 04:08:11','234234'),(5,2,'��','ccc','url_c','cccccccccccccccccccc',8,'2015-03-08 04:08:11','3'),(6,2,'��','ccc','url_c','cccccccccccccccccccc',9,'2015-03-08 04:08:11','234'),(7,3,'��','ccc','url_c','cccccccccccccccccccc',1,'2015-03-08 04:08:11','234'),(8,3,'��','ccc','url_c','cccccccccccccccccccc',2,'2015-03-08 04:08:11','23'),(9,4,'4��','ccc','url_c','cccccccccccccccccccc',3,'2015-03-08 04:08:11','234'),(10,4,'4��','ccc','url_c','cccccccccccccccccccc',3,'2015-03-08 04:08:11','234'),(11,4,'4��','ccc','url_c','cccccccccccccccccccc',5,'2015-03-08 04:08:11','234');
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
  `parent_url` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_plate_en`
--

LOCK TABLES `tbl_plate_en` WRITE;
/*!40000 ALTER TABLE `tbl_plate_en` DISABLE KEYS */;
INSERT INTO `tbl_plate_en` VALUES (2,1,'aaa','abc','url_a','aaaaaaaaaaaaaaaaaaaaaaaaaaaa',9,'2015-03-08 04:08:21','23'),(3,3,'bbb','bbb','url_b','nbbbbbbbbbbbbbbbbbbb',8,'2015-03-08 04:08:21','234'),(4,2,'2aa','ccc','url_c','cccccccccccccccccccc',8,'2015-03-08 04:08:21','4'),(5,1,'aaa','abc','url_a','aaaaaaaaaaaaaaaaaaaaaaaaaaaa',9,'2015-03-08 04:08:21','23'),(6,1,'aaa','abc','url_a','aaaaaaaaaaaaaaaaaaaaaaaaaaaa',9,'2015-03-08 04:08:21','432'),(7,1,'aaa','abc','url_a','aaaaaaaaaaaaaaaaaaaaaaaaaaaa',9,'2015-03-08 04:08:21','234'),(8,1,'aaa','abc','url_a','aaaaaaaaaaaaaaaaaaaaaaaaaaaa',9,'2015-03-08 04:08:21','324'),(9,1,'aaa','abc','url_a','aaaaaaaaaaaaaaaaaaaaaaaaaaaa',9,'2015-03-08 04:08:21','234');
/*!40000 ALTER TABLE `tbl_plate_en` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_resource`
--

DROP TABLE IF EXISTS `tbl_resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_resource` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `uri` varchar(64) DEFAULT NULL,
  `desc` varchar(64) DEFAULT NULL,
  `weight` int(32) DEFAULT NULL,
  `parent_name` varchar(64) DEFAULT NULL,
  `rec_st` int(32) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_resource`
--

LOCK TABLES `tbl_resource` WRITE;
/*!40000 ALTER TABLE `tbl_resource` DISABLE KEYS */;
INSERT INTO `tbl_resource` VALUES (1,'公司业绩','achieve','',98,'通用管理',1,'2014-12-24 06:59:21'),(2,'公司动态','news',NULL,99,'通用管理',1,'2014-12-24 06:59:21'),(3,'图片新闻','picNews',NULL,59,'图片及视频管理',1,'2014-12-24 06:59:21'),(4,'轮播图','slider',NULL,80,'首页管理',1,'2014-12-24 06:56:01'),(5,'东晨视角','videos',NULL,60,'图片及视频管理',1,'2014-12-29 07:13:31'),(6,'服务项目','service',NULL,100,'通用管理',1,'2014-12-24 06:56:01'),(7,'企业文化','culture',NULL,97,'通用管理',1,'2014-12-24 06:59:21'),(8,'行业建设','jianshe',NULL,96,'通用管理',1,'2014-12-24 06:59:21'),(9,'在线咨询','suggestion',NULL,70,'在线咨询管理',1,'2014-12-24 06:59:21'),(10,'公司荣誉','honor',NULL,95,'通用管理',1,'2014-12-24 20:59:58'),(11,'党政建设','party',NULL,94,'党政建设',1,'2014-12-28 07:38:10');
/*!40000 ALTER TABLE `tbl_resource` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_role`
--

DROP TABLE IF EXISTS `tbl_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_role` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL,
  `desc` varchar(256) DEFAULT NULL,
  `rec_st` int(32) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_role`
--

LOCK TABLES `tbl_role` WRITE;
/*!40000 ALTER TABLE `tbl_role` DISABLE KEYS */;
INSERT INTO `tbl_role` VALUES (1,'系统管理员','全部权限',1,'2014-11-24 05:29:07');
/*!40000 ALTER TABLE `tbl_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_role_resource`
--

DROP TABLE IF EXISTS `tbl_role_resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_role_resource` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `role_id` int(32) DEFAULT NULL,
  `resource_id` int(32) DEFAULT NULL,
  `rec_st` int(32) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_role_resource`
--

LOCK TABLES `tbl_role_resource` WRITE;
/*!40000 ALTER TABLE `tbl_role_resource` DISABLE KEYS */;
INSERT INTO `tbl_role_resource` VALUES (1,1,1,1,'2014-11-11 06:20:55'),(2,1,2,1,'2014-11-18 07:27:15'),(3,1,3,1,'2014-12-17 07:35:36'),(4,1,4,1,'2014-12-17 07:35:36'),(5,1,5,1,'2014-12-17 07:35:36'),(6,1,6,1,'2014-12-17 07:35:36'),(7,1,7,1,'2014-12-17 07:35:36'),(8,1,8,1,'2014-11-22 19:41:18'),(9,1,9,1,'2014-11-28 23:46:45'),(10,1,10,1,'2014-11-28 23:46:45'),(11,1,11,1,'2014-12-28 07:38:19');
/*!40000 ALTER TABLE `tbl_role_resource` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-03-08 12:08:39
