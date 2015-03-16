CREATE DATABASE  IF NOT EXISTS `xplore` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `xplore`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: localhost    Database: xplore
-- ------------------------------------------------------
-- Server version	5.6.22-log

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
INSERT INTO `tbl_admin` VALUES (1,'admin','21232f297a57a5a743894a0e4a801fc3',1,'zzh','13918395294',1,'2014-12-13 16:37:01'),(2,'adminadmin','21232f297a57a5a743894a0e4a801fc3',1,'1','',1,'2014-11-24 23:59:02');
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
INSERT INTO `tbl_admin_role` VALUES (1,1,1,1,'2014-11-24 21:30:28'),(2,1,2,1,'2014-11-24 21:30:28'),(3,1,3,1,'2014-12-13 23:06:06'),(4,2,1,1,'2014-12-13 23:06:06'),(5,2,2,1,'2014-12-13 23:06:06'),(6,2,3,1,'2014-12-13 23:06:06');
/*!40000 ALTER TABLE `tbl_admin_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_campus_cn`
--

DROP TABLE IF EXISTS `tbl_campus_cn`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_campus_cn` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `country_id` int(11) DEFAULT NULL,
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
  `country_id` int(11) DEFAULT NULL,
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
INSERT INTO `tbl_campus_en` VALUES (1,1,'asdfsfasadsdfssafdsafsafsa','profile_1','facts_1','curadsf_1',100,'2015-03-16 01:50:06'),(2,1,'2121342424142134','profile_1','facts_1','curadsf_1',100,'2015-03-16 01:50:06'),(3,1,'asf','profile_1','facts_1','curadsf_1',100,'2015-03-16 01:50:06'),(4,1,'1342314231421','profile_1','facts_1','curadsf_1',100,'2015-03-16 01:50:06'),(5,1,'asfsdf','profile_1','facts_1','curadsf_1',100,'2015-03-16 01:50:06'),(6,1,'421421421','profile_1','facts_1','curadsf_1',100,'2015-03-16 01:50:06'),(7,1,'asdfsafdsfsafsafs','profile_1','facts_1','curadsf_1',100,'2015-03-16 01:50:06'),(8,1,'sdfsafs','profile_1','facts_1','curadsf_1',100,'2015-03-16 01:50:06');
/*!40000 ALTER TABLE `tbl_campus_en` ENABLE KEYS */;
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
INSERT INTO `tbl_config` VALUES (1,'context_path','http://localhost:8080/xplore-web',1,1,'2015-03-01 23:17:29'),(2,'proxy_location','http://localhost:8080/xplore-web/admin/',1,1,'2015-03-01 23:17:29'),(3,'fileUpload_location','E:\\',1,1,'2014-12-21 23:24:30'),(4,'page_size','10',1,1,'2014-12-27 23:43:13'),(5,'web_page_size','8',1,1,'2014-12-30 21:10:43'),(6,'total_cnt','38',1,1,'2015-01-09 12:00:00'),(7,'key_admin_path','http://localhost:8080/xplore-web',1,1,'2015-03-01 23:17:29');
/*!40000 ALTER TABLE `tbl_config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_menu`
--

DROP TABLE IF EXISTS `tbl_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_menu` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `cn_name` varchar(32) DEFAULT NULL,
  `en_name` varchar(128) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_menu`
--

LOCK TABLES `tbl_menu` WRITE;
/*!40000 ALTER TABLE `tbl_menu` DISABLE KEYS */;
INSERT INTO `tbl_menu` VALUES (1,'常规全年活动','ALL YEAR ROUND GROUPS','2015-03-11 06:54:29'),(2,'夏令营','SUMMER CAMPUS','2015-03-11 06:54:29'),(3,'量身定制','TAILOR MADE EDUCATION PACKAGES FOR GROUPS','2015-03-11 06:54:29'),(4,'中学','MY CHOICE HIGH SCHOLL PROGRAMS','2015-03-11 06:54:29'),(5,'代理专区','AGENTS ZONE','2015-03-11 06:54:29'),(6,'关于Xplore','ABOUT XPLORE','2015-03-11 06:54:29'),(7,'轮播图（第一个）','XXXXX','2015-03-11 06:54:29');
/*!40000 ALTER TABLE `tbl_menu` ENABLE KEYS */;
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
INSERT INTO `tbl_perm` VALUES (1,'list','添加轮播图',NULL,1,'2015-03-16 03:10:05',1),(2,'list','文章',NULL,1,'2015-03-16 03:18:02',3),(3,'list','校园',NULL,1,'2015-03-16 03:18:02',4),(4,'list','校园',NULL,1,'2015-03-16 03:18:02',5),(5,'add','添加校园',NULL,1,'2015-03-16 03:13:58',5),(6,'list','查看企业文化',NULL,1,'2014-12-23 22:19:37',7),(7,'edit','编辑轮播图',NULL,1,'2015-03-16 03:10:05',1),(9,'del','删除轮播图',NULL,1,'2015-03-16 03:10:05',1),(10,'add','新增轮播图',NULL,1,'2015-03-16 03:10:05',1),(11,'list','行业建设列表',NULL,1,'2014-12-23 22:51:50',8),(12,'edit','编辑行业建设',NULL,1,'2014-12-23 22:51:50',8),(13,'list','文章',NULL,1,'2015-03-16 03:18:02',2),(14,'list','服务项目列表',NULL,1,'2014-12-23 22:47:29',6),(15,'add','新增服务项目',NULL,1,'2014-12-23 22:47:29',6),(16,'edit','编辑服务项目',NULL,1,'2014-12-23 22:47:29',6),(17,'del','删除服务项目',NULL,1,'2014-12-23 22:47:29',6),(20,'list','在线咨询',NULL,1,'2014-12-24 10:08:51',9),(21,'del','在线咨询',NULL,1,'2014-12-24 10:08:51',9),(24,'edit','编辑企业文化',NULL,1,'2014-12-23 22:19:37',7),(25,'del','删除企业文化',NULL,1,'2014-12-23 22:19:37',7),(26,'add','添加文章',NULL,1,'2015-03-16 03:10:05',2),(27,'edit','编辑文章',NULL,1,'2015-03-16 03:10:05',2),(28,'del','删除文章',NULL,1,'2015-03-16 03:10:05',2),(29,'add','新增企业文化',NULL,1,'2014-12-01 21:13:34',7),(30,'add','新增行业建设',NULL,1,'2014-11-23 20:44:20',8),(31,'del','删除行业建设',NULL,1,'2014-11-23 20:44:20',8),(32,'add','添加校园',NULL,1,'2015-03-16 03:13:58',4),(33,'del','删除校园',NULL,1,'2015-03-16 03:13:58',4),(34,'edit','编辑校园',NULL,1,'2015-03-16 03:13:58',4),(35,'add','添加文章',NULL,1,'2015-03-16 03:11:34',3),(36,'edit','编辑文章',NULL,1,'2015-03-16 03:11:34',3),(37,'del','删除文章',NULL,1,'2015-03-16 03:11:34',3),(38,'del','删除校园',NULL,1,'2015-03-16 03:13:58',5),(39,'edit','编辑校园',NULL,1,'2015-03-16 03:13:58',5),(40,'add','公司荣誉',NULL,1,'2014-12-24 13:00:37',10),(41,'edit','公司荣誉',NULL,1,'2014-12-24 13:00:37',10),(42,'del','公司荣誉',NULL,1,'2014-12-24 13:00:37',10),(43,'list','公司荣誉',NULL,1,'2014-12-24 13:00:37',10),(44,'add','党政建设',NULL,1,'2014-12-27 23:38:50',11),(45,'del','党政建设',NULL,1,'2014-12-27 23:38:50',11),(46,'edit','党政建设',NULL,1,'2014-12-27 23:38:50',11),(47,'list','党政建设',NULL,1,'2014-12-27 23:38:50',11);
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_plate_cn`
--

LOCK TABLES `tbl_plate_cn` WRITE;
/*!40000 ALTER TABLE `tbl_plate_cn` DISABLE KEYS */;
INSERT INTO `tbl_plate_cn` VALUES (3,1,'我','bbb','url_b','nbbbbbbbbbbbbbbbbbbb',8,'2015-03-11 03:11:11'),(4,2,'你','ccc','url_c','cccccccccccccccccccc',10,'2015-03-13 08:51:19'),(5,3,'他','ccc','url_c','cccccccccccccccccccc',8,'2015-03-13 08:51:19'),(6,4,'我','ccc','url_c','cccccccccccccccccccc',9,'2015-03-13 08:51:19'),(7,5,'你','ccc','url_c','cccccccccccccccccccc',1,'2015-03-13 08:51:19'),(8,6,'他','ccc','url_c','cccccccccccccccccccc',2,'2015-03-13 08:51:19'),(9,3,'我','ccc','url_c','cccccccccccccccccccc',3,'2015-03-13 08:51:19'),(10,7,'xplore历史','ccc','url_c','cccccccccccccccccccc',100,'2015-03-13 08:56:07'),(12,7,'xplore团队','summary of haha',NULL,'<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;asdflkaksldjliwqeoiruqwerlkja;dfadf&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p><p>asdf</p><p>dsaf</p><p>asdf</p><p>asdf</p><p>asdf</p><p>as</p><p>df</p><p>a</p><p>ew</p><p>trqwe</p><p>t</p><p>rey</p><p>ewy</p><p>gf</p><p><br/></p>',90,'2015-03-13 08:56:07'),(13,7,'xplore办事处',NULL,NULL,NULL,80,'2015-03-13 08:56:07'),(14,7,'xplore愿景',NULL,NULL,NULL,70,'2015-03-13 08:56:07');
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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_plate_en`
--

LOCK TABLES `tbl_plate_en` WRITE;
/*!40000 ALTER TABLE `tbl_plate_en` DISABLE KEYS */;
INSERT INTO `tbl_plate_en` VALUES (2,1,'aaa','abc','url_a','aaaaaaaaaaaaaaaaaaaaaaaaaaaa',9,'2015-03-07 20:08:21'),(3,2,'bbb','bbb','url_b','nbbbbbbbbbbbbbbbbbbb',8,'2015-03-13 08:57:41'),(4,3,'2aa','ccc','url_c','cccccccccccccccccccc',8,'2015-03-13 08:57:41'),(5,4,'aaa','abc','url_a','aaaaaaaaaaaaaaaaaaaaaaaaaaaa',9,'2015-03-13 08:57:41'),(6,5,'aaa','abc','url_a','aaaaaaaaaaaaaaaaaaaaaaaaaaaa',9,'2015-03-13 08:57:41'),(7,6,'aaa','abc','url_a','aaaaaaaaaaaaaaaaaaaaaaaaaaaa',9,'2015-03-13 08:57:41'),(8,7,'Xplore History','abc','url_a','aaaaaaaaaaaaaaaaaaaaaaaaaaaa',100,'2015-03-13 08:57:41'),(9,7,'Xplore Team','abc','url_a','aaaaaaaaaaaaaaaaaaaaaaaaaaaa',90,'2015-03-13 08:57:41'),(10,7,'Xplore Offices','abc','url_a','aaaaaaaaaaaaaaaaaaaaaaaaaaaa',80,'2015-03-07 20:08:21'),(11,7,'Xplore Vision','abc','url_a','aaaaaaaaaaaaaaaaaaaaaaaaaaaa',70,'2015-03-07 20:08:21');
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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_resource`
--

LOCK TABLES `tbl_resource` WRITE;
/*!40000 ALTER TABLE `tbl_resource` DISABLE KEYS */;
INSERT INTO `tbl_resource` VALUES (1,'轮播图','slider',NULL,80,'首页管理',1,'2015-03-11 05:24:31'),(2,'文章管理','plateChinese',NULL,100,'中文管理',1,'2015-03-16 03:12:47'),(3,'文章管理','plateEnglish',NULL,100,'英文管理',1,'2015-03-16 03:12:47'),(4,'校园管理','campusChinese',NULL,100,'中文管理',1,'2015-03-16 03:12:47'),(5,'校园管理','campusEnglish',NULL,100,'英文管理',1,'2015-03-16 03:12:47');
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
INSERT INTO `tbl_role` VALUES (1,'系统管理员','全部权限',1,'2014-11-23 21:29:07');
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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_role_resource`
--

LOCK TABLES `tbl_role_resource` WRITE;
/*!40000 ALTER TABLE `tbl_role_resource` DISABLE KEYS */;
INSERT INTO `tbl_role_resource` VALUES (1,1,1,1,'2014-11-10 22:20:55'),(2,1,2,1,'2014-11-17 23:27:15'),(3,1,3,1,'2014-12-16 23:35:36'),(4,1,4,1,'2014-12-16 23:35:36'),(5,1,5,1,'2014-12-16 23:35:36'),(6,1,6,1,'2014-12-16 23:35:36'),(7,1,7,1,'2014-12-16 23:35:36'),(8,1,8,1,'2014-11-22 11:41:18'),(9,1,9,1,'2014-11-28 15:46:45'),(10,1,10,1,'2014-11-28 15:46:45'),(11,1,11,1,'2014-12-27 23:38:19'),(12,1,12,1,'2014-12-27 23:38:19');
/*!40000 ALTER TABLE `tbl_role_resource` ENABLE KEYS */;
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

-- Dump completed on 2015-03-16 11:20:00
