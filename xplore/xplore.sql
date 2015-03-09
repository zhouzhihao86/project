CREATE DATABASE  IF NOT EXISTS `xplore` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `xplore`;
-- test
-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: localhost    Database: xplore
-- ------------------------------------------------------
-- Server version	5.6.21-log

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
-- Table structure for table `tbl_plate`
--

DROP TABLE IF EXISTS `tbl_plate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_plate` (
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
-- Dumping data for table `tbl_plate`
--

LOCK TABLES `tbl_plate` WRITE;
/*!40000 ALTER TABLE `tbl_plate` DISABLE KEYS */;
INSERT INTO `tbl_plate` VALUES (2,1,'你','abc','url_a','aaaaaaaaaaaaaaaaaaaaaaaaaaaa',9,'2015-03-06 05:05:39'),(3,1,'我','bbb','url_b','nbbbbbbbbbbbbbbbbbbb',8,'2015-03-06 05:05:39'),(4,1,'他','ccc','url_c','cccccccccccccccccccc',10,'2015-03-06 05:05:39'),(5,2,'你','ccc','url_c','cccccccccccccccccccc',8,'2015-03-06 05:05:39'),(6,2,'我','ccc','url_c','cccccccccccccccccccc',9,'2015-03-06 05:05:39'),(7,3,'你','ccc','url_c','cccccccccccccccccccc',1,'2015-03-06 05:05:39'),(8,3,'我','ccc','url_c','cccccccccccccccccccc',2,'2015-03-06 05:05:39'),(9,4,'4我','ccc','url_c','cccccccccccccccccccc',3,'2015-03-06 05:05:39'),(10,4,'4他','ccc','url_c','cccccccccccccccccccc',3,'2015-03-06 05:05:39'),(11,4,'4他','ccc','url_c','cccccccccccccccccccc',5,'2015-03-06 05:05:39');
/*!40000 ALTER TABLE `tbl_plate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_achieve`
--

DROP TABLE IF EXISTS `tbl_achieve`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_achieve` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `title` varchar(64) DEFAULT NULL,
  `content` varchar(16384) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `brief` varchar(512) DEFAULT NULL,
  `log_time` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_achieve`
--

LOCK TABLES `tbl_achieve` WRITE;
/*!40000 ALTER TABLE `tbl_achieve` DISABLE KEYS */;
INSERT INTO `tbl_achieve` VALUES (8,'123','<p>&nbsp; &nbsp; &nbsp; &nbsp;在这里输入内容\r\n\r\n\r\n &nbsp; &nbsp; &nbsp; &nbsp;</p>','2015-01-05 12:50:09','123','2014-12-05'),(9,'123','<p>&nbsp; &nbsp; &nbsp; &nbsp;在这里输入内容\r\n\r\n\r\n &nbsp; &nbsp; &nbsp; &nbsp;</p>','2014-12-24 13:12:46','123',NULL),(10,'123','<p>&nbsp; &nbsp; &nbsp; &nbsp;在这里输入内容\r\n\r\n\r\n &nbsp; &nbsp; &nbsp; &nbsp;</p>','2014-12-24 13:12:48','123',NULL),(11,'123','<p>&nbsp; &nbsp; &nbsp; &nbsp;在这里输入内容\r\n\r\n\r\n &nbsp; &nbsp; &nbsp; &nbsp;</p>','2014-12-24 13:12:51','123',NULL),(12,'1','<p>&nbsp; &nbsp; &nbsp; &nbsp;在这里输入内容\r\n\r\n\r\n &nbsp; &nbsp; &nbsp; &nbsp;</p>','2014-12-24 13:12:52','',NULL),(13,'1','<p>&nbsp; &nbsp; &nbsp; &nbsp;在这里输入内容\r\n\r\n\r\n &nbsp; &nbsp; &nbsp; &nbsp;</p>','2014-12-24 13:12:54','',NULL),(14,'123','<p>&nbsp; &nbsp; &nbsp; &nbsp;在这里输入内容\r\n\r\n\r\n &nbsp; &nbsp; &nbsp; &nbsp;</p>','2014-12-24 13:12:56','',NULL),(15,'123','<p>&nbsp; &nbsp; &nbsp; &nbsp;在这里输入内容\r\n\r\n\r\n &nbsp; &nbsp; &nbsp; &nbsp;</p>','2014-12-24 13:12:58','',NULL),(16,'123','<p>&nbsp; &nbsp; &nbsp; &nbsp;在这里输入内容\r\n\r\n\r\n &nbsp; &nbsp; &nbsp; &nbsp;</p>','2014-12-24 13:13:01','',NULL);
/*!40000 ALTER TABLE `tbl_achieve` ENABLE KEYS */;
UNLOCK TABLES;

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
INSERT INTO `tbl_admin` VALUES (1,'admin','21232f297a57a5a743894a0e4a801fc3',1,'zzh','13918395294',1,'2014-12-14 08:37:01'),(2,'adminadmin','21232f297a57a5a743894a0e4a801fc3',1,'1','',1,'2014-11-25 15:59:02');
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
INSERT INTO `tbl_admin_role` VALUES (1,1,1,1,'2014-11-25 13:30:28'),(2,1,2,1,'2014-11-25 13:30:28'),(3,1,3,1,'2014-12-14 15:06:06'),(4,2,1,1,'2014-12-14 15:06:06'),(5,2,2,1,'2014-12-14 15:06:06'),(6,2,3,1,'2014-12-14 15:06:06');
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
INSERT INTO `tbl_config` VALUES (1,'context_path','http://localhost:8080/xplore-web',1,1,'2015-03-02 15:17:29'),(2,'proxy_location','http://localhost:8080/xplore-web/admin/',1,1,'2015-03-02 15:17:29'),(3,'fileUpload_location','E:\\',1,1,'2014-12-22 15:24:30'),(4,'page_size','10',1,1,'2014-12-28 15:43:13'),(5,'web_page_size','8',1,1,'2014-12-31 13:10:43'),(6,'total_cnt','38',1,1,'2015-01-10 04:00:00'),(7,'key_admin_path','http://localhost:8080/xplore-web',1,1,'2015-03-02 15:17:29');
/*!40000 ALTER TABLE `tbl_config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_culture`
--

DROP TABLE IF EXISTS `tbl_culture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_culture` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `title` varchar(64) DEFAULT NULL,
  `content` varchar(16384) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `brief` varchar(512) DEFAULT NULL,
  `log_time` varchar(64) DEFAULT NULL,
  `pic_url` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_culture`
--

LOCK TABLES `tbl_culture` WRITE;
/*!40000 ALTER TABLE `tbl_culture` DISABLE KEYS */;
INSERT INTO `tbl_culture` VALUES (2,'','<p style=\"text-align: center;\"><img src=\"/dc-web/resources/img/uploads/545556.jpg\" title=\"\" alt=\"\"/></p><p>11月21日下午，东晨公司举办2014年“我是城市美容师，我为城市添光彩”主题演讲比赛初赛。公司20余名人才库学员纷纷登台亮相，精彩讲演。</p><p>演讲台上，“城市美容师”们结合自身的工作经历和他人的先进事迹，真诚阐述了环卫工作“苦、累、脏、险”的感人情怀，热情讴歌了环卫工人“辛苦我一人，换来万家净”的无私奉献精神。</p><p>举办演讲比赛等丰富多彩的学习教育活动，加强公司职工的思想政治教育，是东晨公司队伍建设的重要举措。通过演讲比赛旨在进一步激发东晨人的事业心和责任感，营造凝心聚力、创新进取的企业文化氛围。</p><p style=\"text-align: right;\">东晨公司</p><p style=\"text-align: right;\">2014年11月</p>','2015-01-05 12:50:15','我是城市美容师，我为城市添光彩','2014-12-05','http://121.42.45.249/dc-web/resources/img/uploads/qywh4.jpg'),(6,'以比促学 以比代教','<p>11月6日，随着一声哨响，15名穿戴整齐的东晨职工挥舞起手中的扫帚，开始娴熟高效地清扫路面，拉开了东晨公司2014年“靓化宝山，美丽东晨” 人工清道技能比武大赛的序幕。局工会副主席施巧云同志亲临比赛现场观摩。</p><p>赛场内比赛精彩纷呈，东晨人各显神通，个个展现着自己的绝活。在赛场一边，“清扫高手”们身着统一工作服，争分夺秒地挥舞着大扫把，最终，来自东晨作业区的张忻艳以自己多年的工作经验、巧妙灵活地清扫本领获得了个人一等奖，凭借她的优异成绩，东晨作业区获得人工清道团体一等奖殊荣。在赛场另一边，同样来自东晨作业区的朱立荣娴熟地驾驶着快速保洁车参赛，她在规定区域内以最快的速度完成垃圾捡拾动作，荣获了快速保洁个人第一名。</p><p>人工清道大赛经过2个多小时的激烈比拼落下帷幕，同时也为东晨公司2014年系列劳动竞赛画上圆满句号。东晨工会积极发挥桥梁纽带作用，时刻把握职工需求，积极探索有效方法，确保劳动竞赛各项工作落到实处。劳动竞赛并不仅仅只是为了比赛，而是给每一位参赛选手提供一个展现自己水平和魅力的平台，同时通过比赛提高自身的操作技能和水平，把在比赛中的拼搏精神带到一线工作中去，把东晨品牌做大做强做亮。</p><p><img src=\"/dc-web/resources/img/uploads/ldjs.jpg\" title=\"\" alt=\"\"/></p>','2014-12-30 01:47:02','以比促学 以比代教——东晨公司2014年劳动竞赛圆满落幕',NULL,'http://121.42.45.249/dc-web/resources/img/uploads/qywh3.jpg'),(7,'东晨公司走进社区，慰问孤老情暖人心','<p style=\"text-align: center;\"><img src=\"/dc-web/resources/img/uploads/DSC02083.JPG\" title=\"\" alt=\"\"/></p><p>重阳至，桂花飘，敬老爱老情意浓。在一年一度的重阳节即将到来之际，东晨公司工会在关心慰问公司退休员工之余，组织团支部志愿者队，先后走进宝山六村居委和友谊家园居委，看望慰问社区孤寡老人，提前送上了节日的祝福。 &nbsp; &nbsp; 9月28日上午，东晨公司团支部一行来到宝山六村陈银妹老人和友谊家园张洪度老人家中，为老人送去了节日慰问品。慰问中，大家与老人一起聊天，了解他的生活状况，听老人讲过去的故事，现场笑声阵阵，其乐融融。活动共走访10户孤老家，或嘘寒问暖，或帮忙做事，一颗颗真诚的爱心，驱散老人的孤单，温暖老人的心田。关爱老人不仅是社会的责任也是企业的责任。</p><p>长期以来，东晨公司一直致力于将中华传统文化教育融入企业文化之中，每逢节假日，公司职工便自发组织前去看望共建社区孤寡老人，给老人们带去生活用品及食品、帮助他们打扫卫生、与老人们一起读报、谈心。公司将把这项活动持之以恒的开展下去，搭建一条企业联系社区的桥梁纽带，为社区的老人营造充满温暖的幸福晚年生活</p><p style=\"text-align: center;\"><img src=\"/dc-web/resources/img/uploads/DSC02103.JPG\" title=\"\" alt=\"\"/></p>','2014-12-30 01:47:22','东晨公司走进社区，慰问孤老情暖人心',NULL,'http://121.42.45.249/dc-web/resources/img/uploads/qywh2.jpg'),(8,'东晨慰问武警支队 军企共建鱼水情','<p style=\"text-align: center;\"><img src=\"/dc-web/resources/img/uploads/dangzhibu.jpg\" title=\"\" alt=\"\"/></p><p>7月28日上午，在第87个建军节来临之际，东晨公司党支部书记张英、工会主席王春看望慰问了宝山区武警七支队官兵，为武警官兵送去防暑降温饮料等慰问品和诚挚的节日问候，共叙军企鱼水情。</p><p>在慰问中，张英书记与武警官兵领导进行了亲切交流，询问了部队建设情况以及对武警支队给予东晨公司的大力支持和帮助表示感谢。武警七支队领导对东晨公司的真情到访和历年来对部队建设的大力支持和帮助表示感谢，表示会一如既往地支持市容环境发展，并在今后的国防知识、思想道德教育、消防演习与军训等方面，继续给予更多的支持和帮助，促进军民团结互助。</p><p>东晨公司坚持每年“八一”建军节走访慰问区武警七支队官兵，认真落实拥军工作，凝聚党心、军心、民心，继承和发扬拥军优属、拥政爱民的光荣传统。通过走访慰问活动，进一步增进了东晨公司与武警官兵间的深厚感情，加强了军企间的交流合作，促使双拥工作不断迈上新台阶，共建和谐社会。</p><p style=\"text-align: right;\">东晨公司党支部</p><p style=\"text-align: right;\">2014年7月28日</p><p><br/></p>','2014-12-30 01:47:39','东晨慰问武警支队 军企共建鱼水情',NULL,'http://121.42.45.249/dc-web/resources/img/uploads/qywh1.jpg'),(9,'东晨公司组织开展职工法律知识培训','<p style=\"text-align: center;\"><img src=\"/dc-web/resources/img/uploads/falvzhishipeixun.jpg\" title=\"\" alt=\"\"/></p><p>为积极推进工会送清凉、送安全、送健康、送文化、送法律“五送”工作，提升全体职工法律保护和学法用法意识，维护企业的合法权益，增强规避风险能力， 7月18日下午，东晨公司工会组织开展了职工法律知识培训活动。此次培训邀请到了恒业律师事务所施扬律师作主讲。</p><p>施扬律师以新劳动法入手，结合公司在法律实践中容易出现的典型案例及员工合同执行过程中可能出现的问题进行了深入浅出、细致耐心的讲解和分析，重点对制度文书化、证据书面化等重点问题进行了强调和提示。</p><p>培训会上，施律师就参训职工现场提出的关于消极怠工、工伤鉴定以及在配合公安、城管执法环节遇到的具体问题进行答疑、指导。参训职工普遍认为，此次培训内容充实、贴近实际、实用性强，不仅为进一步规范公司制度，有效规避劳资纠纷，维护公司在合同履行和制度管理过程中的合法权益起到了重要作用，还为推进公司科学化管理奠定了坚实的基础。</p><p style=\"text-align: right;\">东晨公司工会</p><p style=\"text-align: right;\">2014年7月18日</p><p><br/></p>','2014-12-30 01:47:52','东晨公司组织开展职工法律知识培训',NULL,'http://121.42.45.249/dc-web/resources/img/uploads/qywh5.jpg');
/*!40000 ALTER TABLE `tbl_culture` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_honor`
--

DROP TABLE IF EXISTS `tbl_honor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_honor` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `title` varchar(64) DEFAULT NULL,
  `pic_url` varchar(128) DEFAULT NULL,
  `content` varchar(16384) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `brief` varchar(256) DEFAULT NULL,
  `log_time` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_honor`
--

LOCK TABLES `tbl_honor` WRITE;
/*!40000 ALTER TABLE `tbl_honor` DISABLE KEYS */;
INSERT INTO `tbl_honor` VALUES (7,'','http://121.42.45.249/dc-web/resources/img/uploads/444.jpg','<p>2011年度环卫行业创新奖</p>','2015-01-05 12:50:24','2011年度环卫行业创新奖','2014-12-05'),(8,'宝山区五一劳动奖状','http://121.42.45.249/dc-web/resources/img/uploads/333.jpg','<p>宝山区五一劳动奖状</p>','2014-12-28 16:35:38','宝山区五一劳动奖状',NULL),(9,'全国住房城乡建设系统先进集体','http://121.42.45.249/dc-web/resources/img/uploads/222.jpg','<p class=\"p1\"><span class=\"s1\"><strong>全国住房城乡建设系统先进集体</strong></span></p><p><br/></p>','2014-12-28 16:51:41','全国住房城乡建设系统先进集体',NULL),(10,'2011-2012年度上海市文明单位','http://121.42.45.249/dc-web/resources/img/uploads/111.jpg','<p class=\"p1\"><span class=\"s1\"><strong>2011-2012年度上海市文明单位</strong></span></p><p><br/></p>','2014-12-28 16:52:15','2011-2012年度上海市文明单位',NULL);
/*!40000 ALTER TABLE `tbl_honor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_jianshe`
--

DROP TABLE IF EXISTS `tbl_jianshe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_jianshe` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `title` varchar(64) DEFAULT NULL,
  `content` varchar(16384) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `brief` varchar(512) DEFAULT NULL,
  `log_time` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_jianshe`
--

LOCK TABLES `tbl_jianshe` WRITE;
/*!40000 ALTER TABLE `tbl_jianshe` DISABLE KEYS */;
INSERT INTO `tbl_jianshe` VALUES (1,'志愿服务和谐共建，东晨志愿者在行动','<p style=\"text-align: center;\"><img src=\"/dc-web/resources/img/uploads/43252354.jpg\" title=\"\" alt=\"\"/></p><p>今年12月5日是第29个国际志愿者日，为进一步营造学习雷锋、志愿服务的浓厚氛围，东晨公司党支部开展了“温馨志愿”系列活动，广泛弘扬“奉献、友爱、互助、进步”的志愿精神。</p><p>当天上午，东晨公司志愿者一行走进共建社区宝山六村，大家身披志愿者马甲，手拿铁锹、铲子、扫把，清除小区内卫生死角、白色垃圾以及路旁堆积物等，为小区居民营造干净、卫生的生活环境的同时，进一步向居民倡导了保护环境、美化家园的理念，为环境综合整治打下坚实的群众基础。</p><p>&nbsp; &nbsp; 下午，志愿者们来到和丰路，向门责单位及市民群众派发垃圾分类减排宣传单和小礼品，志愿者们详细讲解垃圾分类概念，希望市民群众在生活里能够建立一种环保意识，共同维护社区环境。</p><p>东晨公司希望通过持续不断的志愿服务活动，弘扬志愿服务精神，为宝山区创建上海市文明城区作出积极贡献。</p><p style=\"text-align: right;\">党支部</p><p style=\"text-align: right;\">201年12月</p>','2015-01-05 12:50:20','志愿服务和谐共建，东晨志愿者在行动','2014-12-05'),(2,'远离黑车 平安出行','<p style=\"text-align: center;\"><img src=\"/dc-web/resources/img/uploads/456554554.jpg\" title=\"\" alt=\"\" width=\"326\" height=\"234\" style=\"width: 326px; height: 234px;\"/>&nbsp;<img src=\"/dc-web/resources/img/uploads/666767.jpg\" title=\"\" alt=\"\" width=\"367\" height=\"236\" style=\"width: 367px; height: 236px;\"/></p><p style=\"text-align: left;\"><span style=\"font-size: 20px;\">&nbsp; &nbsp; <span style=\"font-size: 14px; font-family: 宋体, SimSun;\">2014年12月2日，为提高市民交通安全意识，宣传搭乘黑车的危险，上海东晨清洁服务有限公司与共建小区宝山六村合作举行《远离黑车，平安出行》的交通安全教育活动。</span></span></p><p style=\"text-align: left;\"><span style=\"font-size: 14px; font-family: 宋体, SimSun;\">为了进一步宣传东晨公司交通安全活动，维护小区居民生命财产安全，保障出行平安。我公司开展了“远离黑车，平安出行”宣传活动，在小区居委会的支持下活动通过发放宣传单、展板展示、演讲介绍等大量的宣传工作，增强了小区居民对黑车危害的认知，提高了居民对交通安全的认识，小区居民纷纷表示支持和理解，并愿意在今后的生活中做到远离黑车、平安出行。</span></p><p style=\"text-align: left;\"><span style=\"font-size: 14px; font-family: 宋体, SimSun;\">安全活动主持人顾伟佳给大家介绍了乘坐“黑车”的危险：一是“黑车”等非法从事出租汽车驾驶人员未经正规培训，驾驶技术无保障；二是未经有关部门定期检测，车辆安全状况无保障；三是乘座“黑车”等非法从事出租汽车未参加相关保险无抗风险能力，道路交通故事和服务质量事件无力赔偿，乘客无处投诉，利益将受到损害；四是躲避监控，违章得不到及时纠正，行车安全无保障；五是甩客、绕道、价格欺诈手段恶劣，乘客权益无保障。活动尾声，小区居委会代表小区居民表示将坚决投入到“远离黑车、文明出行”中来。</span></p><p style=\"text-align: left;\"><span style=\"font-size: 14px; font-family: 宋体, SimSun;\">&nbsp;</span></p><p style=\"text-align: left;\"><span style=\"font-size: 14px; font-family: 宋体, SimSun;\">&nbsp;</span></p><p style=\"text-align: right;\"><span style=\"font-size: 14px; font-family: 宋体, SimSun;\">安全保障部</span></p><p style=\"text-align: right;\"><span style=\"font-size: 14px; font-family: 宋体, SimSun;\">2014年12月2日</span></p>','2015-01-04 02:11:28','远离黑车 平安出行',NULL),(3,'东晨公司开展电瓶保洁车应知应会培训','<p style=\"text-align: center;\"><img src=\"/dc-web/resources/img/uploads/3242345.jpg\" title=\"\" alt=\"\"/></p><p>2014年11月20、21日两天，东晨公司对全体电瓶保洁车驾驶员进行了专项应知应会培训。</p><p>在为期两天的培训中，公司生产管理部就电瓶保洁车驾驶员上岗前需掌握的理论知识、交通意识、法律法规及实地操作等都做了细致的指导与严格的培训。在培训中，公司小教员认真辅导，学员们踊跃提问、求知，制造了浓厚的学习气氛，现场氛围热烈且严谨。在实地操作中，小教员对学员们每一个微小的动作都耐心指导。</p><p>通过两天的集中培训，上岗学员深刻的认识到了岗前培训的重要性。明白了这不仅仅是对市容环卫作业上岗的严要求，更是对社会大众及自身安全的保障与尊重。东晨公司会继续做好上岗及企业内部培训，认真践实好市容环卫文明行业的搭建。</p><p>&nbsp;</p><p style=\"text-align: right;\">东晨公司</p>','2014-12-28 18:46:20','东晨公司开展电瓶保洁车应知应会培训',NULL),(4,'积极服务共建小学，提升良好环卫形象','<p style=\"text-align: center;\"><img src=\"/dc-web/resources/img/uploads/zhudongdasao.JPG\" title=\"\" alt=\"\"/></p><p>在9.1开学日来临之际，为了给孩子创造一个舒适、优美、整洁的学习环境，近日，我东晨公司主动与共建单位益钢小学取得联系，安排员工到学校参加义务劳动。</p><p>活动中，班组长分工明确，员工们一鼓作劲展开了卫生清理大行动，教室内、校道中、绿化带里、楼梯上，都闪动着员工们劳动的身影，他们分工具体，积极配合，将校园环境打扫得干干净净，焕然一新。期间，由于学校修剪绿化残留了大量枝叶，无法清理，公司利用小型六桶收集车清运树枝，为学校决解了一直头疼的问题。</p><p>活动结束后，东晨公司得到了校方领导高度赞扬，公司将把这项活动持之以恒的开展下去，尽最大能力为校方办实事、办好事。</p><p style=\"text-align: right;\">东晨公司</p><p style=\"text-align: right;\">2014年9月5日</p>','2014-12-28 18:47:31','积极服务共建小学，提升良好环卫形象',NULL),(5,'美化沿街道路环境，开启除草歼灭战','<p style=\"text-align: center;\"><img src=\"/dc-web/resources/img/uploads/yanlulvhua.jpg\" title=\"\" alt=\"\"/></p><p>随着夏日雨季的到来，近日连续降雨的雨水促进了绿化植物的旺盛生长，人行道等处的杂草呈现疯长态势，野草“拔地而起”，严重破坏了道路的美观和谐，同时也给行人通行带来了影响。</p><p>为此，我东晨公司积极调整工作计划，开展“道路美化，除草歼灭战”，我们安排作业区员工对雨后滋生的杂草进行拔除或喷药清除，每位清扫保洁员工在完成第一遍普扫作业后，加快速度拔除、铲除和清除墙角、绿化带外上街沿和沟底石缝中的野草，大家像“丰收的农民”一样奋力“抢收”，保证在这秋收季节道路上没有野草横生。</p><p>虽然雨后较易除草，但潮湿的环境，加上天气闷热，作业人员清除杂草过程并不轻松，经过3天的清除，终于有效地改善了道路环境，为市民在即将来临的“中秋佳节”提供一个美观整洁的出行环境。</p><p style=\"text-align: right;\">东晨公司</p><p style=\"text-align: right;\">2014年8月</p>','2014-12-28 18:48:13','美化沿街道路环境，开启除草歼灭战',NULL),(6,'以国防精神塑造企业形象','<p style=\"text-align: center;\"><img src=\"/dc-web/resources/img/uploads/guofangjiaoyu.jpg\" title=\"\" alt=\"\"/></p><p>为引导广大职工树立居安思危的忧患意识，增强依法履行国防义务的责任感，形成关心和支持国防建设的浓厚氛围，7月10日下午，上海东晨市容清洁服务有限公司开展2014年国防形势教育主题培训，邀请宝山区武警7支队的冒俊杰股长作国防专题报告。公司中层以上领导干部及全体党员参加学习培训。</p><p>学习会上，冒股长从关系到国家安全的国际与国内形势重要论述出发，结合当前我国处于安全威胁叠加期的现实，提出我国面临的生存安全和发展安全问题并存，传统安全威胁和非传统安全威胁交织。我们要全面认识和把握我国国家安全面临的新形势新挑战，充分认清国家安全形势的复杂性严峻性，进一步增强忧患意识、危机意识、使命意识。</p><p>“天下兴亡，匹夫有责”，国家的稳固强盛与每个人都息息相关，国防教育是建设和巩固国防的基础，是提高职工凝聚力的重要途径。强化国防观念，居安思危，增强忧患意识，使职工能站在更高的角度以主人翁思想处处为企业着想，才能形成一股强大的凝聚力，推动企业不断发展。</p><p style=\"text-align: right;\">东晨公司</p><p style=\"text-align: right;\">2014年7月10日</p>','2014-12-28 18:49:01','以国防精神塑造企业形象',NULL);
/*!40000 ALTER TABLE `tbl_jianshe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_news`
--

DROP TABLE IF EXISTS `tbl_news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_news` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `title` varchar(64) DEFAULT NULL,
  `content` varchar(16384) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `brief` varchar(512) DEFAULT NULL,
  `has_video` int(32) DEFAULT NULL,
  `log_time` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_news`
--

LOCK TABLES `tbl_news` WRITE;
/*!40000 ALTER TABLE `tbl_news` DISABLE KEYS */;
INSERT INTO `tbl_news` VALUES (1,'宝山区绿化和市容管理局来东晨公司开展基层调研会','<p style=\"text-align: center;\"><img src=\"/dc-web/resources/img/uploads/ewefewfwe.jpg\" title=\"\" alt=\"\"/></p><p>11月19日下午，宝山区绿化和市容管理局一行来到我东晨公司进行工作调研。区局主要负责人出席参加会议。</p><p>会上，东晨公司总经理陈霖就公司2014年工作开展情况及2015年工作思路进行了汇报。今年，东晨公司紧密结合党的群众路线教育实践活动，积极围绕热点、难点开展工作，坚持在“改”字上下功夫，用过硬的措施、管用的办法、有效的规章，把教育实践活动的成果转化为加速公司发展的动力。</p><p>黄振德局长对东晨公司敢创敢想的服务精神及主动发现问题、解决问题的工作实效给予了充分的肯定。最后他要求东晨公司在今后的工作中继续带好头、起好步：一是要带好一支队伍，加强队伍建设，强化工作合力，体现品牌实力，发挥导向作用；二是要走好改革步伐，立足市容管理，坚持市场化导向，拓展市场化服务新渠道，推进市容管理与经济发展的同步转型；三是要持续推进信息化建设，不断完善ERP系统，拓展企业管理的新思路和新领域，为信息化管理做好示范作用。</p><p style=\"text-align: right;\">东晨公司</p><p style=\"text-align: right;\">2014年11月</p>','2015-01-05 12:47:51','11月19日下午，宝山区绿化和市容管理局一行来到我东晨公司进行工作调研。',0,'2014-12-05'),(2,'掌握消防技能，消除火灾隐患','<p style=\"text-align: center;\"><img src=\"/dc-web/resources/img/uploads/xiaofan2.jpg\" title=\"\" alt=\"\"/><img src=\"/dc-web/resources/img/uploads/xiaofang1.jpg\" title=\"\" alt=\"\" width=\"324\" height=\"220\" style=\"width: 324px; height: 220px;\"/></p><p>11.9为消防安全日，为全面做好企业消防宣传工作，进一步提高公司消防安全管理水平，不断增强员工的安全意识和消防安全能力，11月7日，我东晨公司安全保障部对杨行作业区一线职工进行消防技能培训。</p><p>此次培训用通俗易懂的语言向参训人员详细讲解了发生火灾的原因、预防措施、正确使用灭火器及逃生自救等消防常识。并就企业如何做好消防安全管理、如何检查并清除整改火灾隐患等方面进行了全面细致的阐述。全体参训人员用心听讲，认真记录，通过互动环节，管理人员向大家详细讲解了灭火器的使用方法和注意事项，并指导一线员工逐个操作灭火器，对部分员工的不规范、不正确的操作进行了指导和纠正。</p><p>此次培训让一线职工体会到消防技能不仅能防身而且能救助他人和公司财产，做到一技防身有备无患。</p><p style=\"text-align: right;\">东晨公司</p><p style=\"text-align: right;\">2014年11月</p>','2014-12-30 07:44:48','掌握消防技能，消除火灾隐患',0,NULL),(3,'深入一线，实践在环卫','<p>宝山区第十六期中青班调研组来到东晨公司调研工作</p><p>10月21日，宝山区第十六期中青班调研组一行12人来到我东晨公司，开展基层调研活动。</p><p>公司党政领导班子成员对区中青班调研组的到来表示欢迎，总经理陈霖当起了现场解说员，一一向区中青班学员介绍现代环卫作业设施、组团式保洁流程和隔离障保洁等具体工作。在一线调研中，区中青班学员换上工作服、手拿大扫帚，向一线员工“拜师学艺”，认认真真当了一回环卫工人。</p><p>中青班调研组对我东晨公司取得的成绩给予高度评价，一致认为公司对道路保洁、市容管理上的各项工作，思路清晰、措施得力、成效显著，创造了许多的成功的经验和做法，十分值学习借鉴。</p><p style=\"text-align: center;\"><img src=\"/dc-web/resources/img/uploads/fwefewfewe.jpg.png\" title=\"\" alt=\"\"/></p>','2014-12-30 07:44:52','深入一线，实践在环卫',0,NULL),(5,'昼夜错时冲洗，及时清除污染','<p style=\"text-align: center;\"><img src=\"/dc-web/resources/img/uploads/zhouyechongxi.jpg\" title=\"\" alt=\"\"/></p><p>最近，宝山城区多处工地施工、道路铺设管道，造成泥沙淤积在沟底，道路的隔离栏下积灰较厚，形成“黄带”，污染严重。我东晨公司积极调整作业方式，针对不同道路的特点，制定了不同的作业模式进行冲洗：对于宝杨路、双庆路、漠河路等无隔离障区域，由于路宽、车少、行人少，公司安排员工在白天进行人工保洁配合冲洗车的保洁模式；对于牡丹江路等一级道路，由于白天车流量、人流量较大，无法正常冲洗路面，公司安排车队在夜间进行冲洗作业。在夜间冲洗的过程中，公司职工不怕苦、不怕累，积极配合冲洗车，紧随其后用扫帚洗刷路面，并及时把积存的污水推入下水道，使道路恢复原色。</p><p>经过多天作业区与车队的昼夜分时配合作业，我们有效清除了城区道路的黄带污染，道路质量得到了明显提升。</p><p style=\"text-align: right;\">东晨公司</p><p style=\"text-align: right;\">2014年10月</p>','2014-12-30 07:44:57','昼夜错时冲洗，及时清除污染',0,NULL),(6,'协合力、攻难点，集中整治“大蚝门”','<p class=\"p1\" style=\"text-align: left;\"><span class=\"s1\">位于宝山万达广场南侧共和新路上的“大蚝门”烧烤店于今年三月下旬开始营业，其经营涉及违规现象：严重跨门经营、烧烤产生的油烟直排影响居民正常生活、经营物品涉及到国家明令禁止的野生保护动物（蛇、穿山甲）等。</span></p><p class=\"p1\" style=\"text-align: center;\"><span class=\"s1\"><img src=\"/dc-web/resources/img/uploads/33444.jpg\" title=\"\" alt=\"\"/></span></p><p class=\"p1\" style=\"text-align: left;\"><span class=\"s1\">通过镇政府、公安、城管中队的前期排摸，我东晨公司配合城管中队多次与大蚝门负责人沟通协调责令整改，但责任方拒不履行其承诺，在执法前期将违规物品暂放店内及小区后门，规避执法导致执法效果收效甚微。</span></p><p class=\"p1\" style=\"text-align: center;\"><span class=\"s1\"><img src=\"/dc-web/resources/img/uploads/32423433.jpg\" title=\"\" alt=\"\"/></span></p><p class=\"p1\"><span class=\"s1\">在镇政府领导的大力协调组织下，我东晨公司制定了缜密方案，于9月12日联合公安、城管、综治等多部门进行大规模集中整治。整治人员按既定方案统一部署操作，在不影响共和新路主干道通行的基础上规范执法。为期三天的整治得到了周边居民的高度赞赏，在其后的固守管理上，公司加强夜间管理力度，力争做到严格管理杜绝返潮。</span></p>','2014-12-30 07:45:02','协合力、攻难点，集中整治“大蚝门”',0,NULL),(7,'联勤联动，集中整治淞浦路水产市场','<p style=\"text-align: center;\"><img src=\"/dc-web/resources/img/uploads/664a59d8-991d-4312-aa93-fe24c9882bb3.jpg\" title=\"\" alt=\"\"/></p><p>随着淞浦路鱼市场“开网”，各种海鲜产品的上市，鱼市场周边的脏、乱、差现象有所反弹，环境卫生情况显得不容乐观。</p><p>群众路线教育实践活动进入整改落实、建章立制环节后，工作更紧，任务更重，我东晨公司继续坚持“改”字当头，在整改上狠下功夫。为此，公司协同城管、管理所，对淞浦路水产市场开展了“三位一体”的环境卫生综合整治活动。我东晨公司共出动10余名员工、5辆两桶收集车、1辆冲洗车，另配备扫帚、铁锹等，对水产市场进行了垃圾清理、道路冲洗等各项整治活动。在三方单位联勤联动的全面部署和精心配合下，整治现场有序分工，共清理垃圾约10余吨。</p><p>此次综合整治活动，不仅使水产市场的面貌大变样，也给市民营造了更加洁净的购物环境，东晨公司将坚持走群众路线，在提高群众满意度上下功夫。</p><p style=\"text-align: right;\">东晨公司</p><p style=\"text-align: right;\">2014年9月5日</p>','2014-12-30 07:45:06','联勤联动，集中整治淞浦路水产市场',0,NULL),(10,'中国梦·东晨梦','<p style=\"white-space: normal; text-align: center; line-height: 40px;\"><strong><span style=\"font-size: 29px; font-family: 华文中宋;\">中国梦·东晨梦</span></strong></p><p style=\"white-space: normal; text-align: right; line-height: 40px;\"><span style=\"font-size: 21px; font-family: 仿宋_GB2312;\">——东晨公司2014年工作总结</span></p><p style=\"text-align: center;\"><embed type=\"application/x-shockwave-flash\" class=\"edui-faked-video\" pluginspage=\"http://www.macromedia.com/go/getflashplayer\" src=\"http://www.tudou.com/v/6628qjWgo4Q/&rpid=39875200&resourceId=39875200_04_05_99/v.swf\" width=\"720\" height=\"480\" wmode=\"transparent\" play=\"true\" loop=\"false\" menu=\"false\" allowscriptaccess=\"never\" allowfullscreen=\"true\"/></p><p style=\"text-align:center;line-height:40px\"><br/></p><p><br/></p>','2015-01-05 12:49:14','上海东晨市容清洁服务有限公司',1,'2014-12-09');
/*!40000 ALTER TABLE `tbl_news` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_party`
--

DROP TABLE IF EXISTS `tbl_party`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_party` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `title` varchar(64) DEFAULT NULL,
  `content` varchar(16384) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `brief` varchar(512) DEFAULT NULL,
  `log_time` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_party`
--

LOCK TABLES `tbl_party` WRITE;
/*!40000 ALTER TABLE `tbl_party` DISABLE KEYS */;
INSERT INTO `tbl_party` VALUES (18,'上海东晨市容清洁服务有限公司党政','<p>&nbsp; &nbsp; &nbsp; &nbsp;在这里输入内容 &nbsp; &nbsp; 测试 &nbsp; &nbsp; &nbsp;</p>','2015-01-05 12:50:30','测试','2014-12-05');
/*!40000 ALTER TABLE `tbl_party` ENABLE KEYS */;
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
INSERT INTO `tbl_perm` VALUES (1,'list','公司业绩',NULL,1,'2014-12-23 14:04:05',1),(2,'list','图片新闻',NULL,1,'2014-12-25 02:49:21',3),(3,'list','轮播图',NULL,1,'2014-12-24 15:11:55',4),(4,'list','视频',NULL,1,'2014-12-25 04:14:33',5),(5,'add','视频',NULL,1,'2014-12-25 04:14:33',5),(6,'list','查看企业文化',NULL,1,'2014-12-24 14:19:37',7),(7,'edit','编辑公司业绩',NULL,1,'2014-12-23 14:04:05',1),(9,'del','删除公司业绩',NULL,1,'2014-12-23 14:04:05',1),(10,'add','新增管理员',NULL,1,'2014-11-22 18:19:57',1),(11,'list','行业建设列表',NULL,1,'2014-12-24 14:51:50',8),(12,'edit','编辑行业建设',NULL,1,'2014-12-24 14:51:50',8),(13,'list','公司动态',NULL,1,'2014-12-23 15:12:47',2),(14,'list','服务项目列表',NULL,1,'2014-12-24 14:47:29',6),(15,'add','新增服务项目',NULL,1,'2014-12-24 14:47:29',6),(16,'edit','编辑服务项目',NULL,1,'2014-12-24 14:47:29',6),(17,'del','删除服务项目',NULL,1,'2014-12-24 14:47:29',6),(20,'list','在线咨询',NULL,1,'2014-12-25 02:08:51',9),(21,'del','在线咨询',NULL,1,'2014-12-25 02:08:51',9),(24,'edit','编辑企业文化',NULL,1,'2014-12-24 14:19:37',7),(25,'del','删除企业文化',NULL,1,'2014-12-24 14:19:37',7),(26,'add','新增公司动态',NULL,1,'2014-12-23 15:12:47',2),(27,'edit','编辑公司动态',NULL,1,'2014-12-23 15:12:47',2),(28,'del','删除公司动态',NULL,1,'2014-12-23 15:12:47',2),(29,'add','新增企业文化',NULL,1,'2014-12-02 13:13:34',7),(30,'add','新增行业建设',NULL,1,'2014-11-24 12:44:20',8),(31,'del','删除行业建设',NULL,1,'2014-11-24 12:44:20',8),(32,'add','轮播图',NULL,1,'2014-11-18 15:19:02',4),(33,'del','轮播图',NULL,1,'2014-11-18 15:19:02',4),(34,'edit','轮播图',NULL,1,'2014-11-18 15:19:02',4),(35,'add','图片新闻',NULL,1,'2014-12-25 02:49:21',3),(36,'edit','图片新闻',NULL,1,'2014-12-25 02:49:21',3),(37,'del','图片新闻',NULL,1,'2014-12-25 02:49:21',3),(38,'del','视频',NULL,1,'2014-11-18 16:09:07',5),(39,'edit','视频',NULL,1,'2014-11-18 16:09:07',5),(40,'add','公司荣誉',NULL,1,'2014-12-25 05:00:37',10),(41,'edit','公司荣誉',NULL,1,'2014-12-25 05:00:37',10),(42,'del','公司荣誉',NULL,1,'2014-12-25 05:00:37',10),(43,'list','公司荣誉',NULL,1,'2014-12-25 05:00:37',10),(44,'add','党政建设',NULL,1,'2014-12-28 15:38:50',11),(45,'del','党政建设',NULL,1,'2014-12-28 15:38:50',11),(46,'edit','党政建设',NULL,1,'2014-12-28 15:38:50',11),(47,'list','党政建设',NULL,1,'2014-12-28 15:38:50',11);
/*!40000 ALTER TABLE `tbl_perm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_picnews`
--

DROP TABLE IF EXISTS `tbl_picnews`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_picnews` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `title` varchar(64) DEFAULT NULL,
  `pic_url` varchar(128) DEFAULT NULL,
  `content` varchar(16384) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `brief` varchar(512) DEFAULT NULL,
  `log_time` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_picnews`
--

LOCK TABLES `tbl_picnews` WRITE;
/*!40000 ALTER TABLE `tbl_picnews` DISABLE KEYS */;
INSERT INTO `tbl_picnews` VALUES (7,'','http://121.42.45.249/dc-web/resources/img/uploads/东晨微平台二维码.jpg','<p style=\"text-align: center;\"><img src=\"/dc-web/resources/img/uploads/IMG_4080.JPG\" title=\"\" alt=\"\"/></p><p>测试东晨市容请今天是星期几做了什么事情什么的</p>','2015-01-05 12:51:04','以比促学 以比代教——东晨公司2014年劳动竞赛圆满落幕','2014-12-05'),(8,'F1作业','http://121.42.45.249/dc-web/resources/img/uploads/F1.png','<p><img src=\"/dc-web/resources/img/uploads/F1zuoye.jpg\" title=\"\" alt=\"\" width=\"342\" height=\"280\" style=\"width: 342px; height: 280px;\"/><img src=\"/dc-web/resources/img/uploads/f1zuoye123.jpg\" title=\"\" alt=\"\" width=\"336\" height=\"295\" style=\"width: 336px; height: 295px;\"/></p><p><img src=\"/dc-web/resources/img/uploads/f1zuoye1234.jpg\" title=\"\" alt=\"\" width=\"343\" height=\"331\" style=\"width: 343px; height: 331px;\"/><img src=\"/dc-web/resources/img/uploads/f456.jpg\" title=\"\" alt=\"\" width=\"335\" height=\"335\" style=\"width: 335px; height: 335px;\"/></p>','2014-12-28 18:14:21','F1作业',NULL),(9,'东晨公司全力做好“上海邮轮旅游节”环境保障工作','http://121.42.45.249/dc-web/resources/img/uploads/CAOA.jpg','<p style=\"text-align: center;\"><img src=\"/dc-web/resources/img/uploads/b610f202-f254-4cb5-8091-696a88fc713a.jpg\" title=\"\" alt=\"\"/></p>','2014-12-28 18:16:40','东晨公司全力做好“上海邮轮旅游节”环境保障工作',NULL),(10,'搏浪健儿竞英豪 东晨职工展新姿','http://121.42.45.249/dc-web/resources/img/uploads/YOUA.jpg','<p style=\"text-align: center;\"><img src=\"/dc-web/resources/img/uploads/youyongbisai.jpg\" title=\"\" alt=\"\"/></p>','2014-12-28 18:17:22','搏浪健儿竞英豪 东晨职工展新姿',NULL),(15,'东晨公司2014年度人才库培训班结业典礼圆满落幕','','<p style=\"line-height:150%\"><span style=\"font-size: 16px;line-height:150%;font-family:宋体\"></span></p><p style=\"line-height:150%\"><span style=\"font-size: 16px;line-height:150%;font-family:宋体\">12</span><span style=\"font-size:16px;line-height:150%;font-family:宋体\">月30日，伴随着冬日暖阳，东晨公司2014年度人才库培训班结业典礼落幕，参加结业典礼的35名学员分别来自公司各个部门及一线作业区、车队、车间的优秀人才，他们经过一年的系统培训，结合实际工作运用所学、所感、所悟顺利完成了结业成果汇报。</span></p><p style=\"text-indent:32px;line-height:150%\"><span style=\"font-size:16px;line-height:150%;font-family:宋体\">在结业仪式之前，首先进行了“我是城市美容师，我为城市添光彩”东晨公司主题演讲比赛决赛，由初赛选拨推荐出的10名选手参加了此次决赛，他们以朴实的语言，感人的事迹，道出了环卫工人的心酸苦辣，同时也展现了环卫工人的精神风貌和思想境界。在决赛现场，选手们都发挥了较好水平，精彩的演讲赢得台下的热烈掌声。经过激烈角逐，来自同济作业区的潘正芝荣获一等奖。</span></p><p style=\"text-indent:32px;line-height:150%\"><span style=\"font-size:16px;line-height:150%;font-family: 宋体\">结业典礼上，公司党支部书记张英鼓励学员要在东晨这个强大、充满机遇、温暖的平台上充满信心，同时要对自身岗位倍加珍惜。结业典礼在学员们满怀激动的接过了沉甸甸的结业证书与合影留念中落幕，这是学员再踏征程的幕启。</span></p><p style=\"text-align:right;line-height:150%\"><span style=\"font-size:16px;line-height:150%;font-family:宋体\">　　　　 <strong>东晨公司</strong></span></p><p style=\"text-align:right;line-height:150%\"><strong><span style=\"font-size:16px;line-height:150%;font-family:宋体\">2014</span></strong><strong><span style=\"font-size:16px;line-height:150%;font-family:宋体\">年12月</span></strong></p><p><br/></p>','2015-01-04 02:52:36','东晨公司2014年度人才库培训班结业典礼圆满落幕',NULL),(16,'','','<p><img src=\"/dc-web/resources/img/uploads/3243423e3ere2.jpg\" title=\"\" alt=\"\"/></p>','2015-01-04 03:11:17','测试350',NULL);
/*!40000 ALTER TABLE `tbl_picnews` ENABLE KEYS */;
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
INSERT INTO `tbl_resource` VALUES (1,'公司业绩','achieve','',98,'通用管理',1,'2014-12-24 14:59:21'),(2,'公司动态','news',NULL,99,'通用管理',1,'2014-12-24 14:59:21'),(3,'图片新闻','picNews',NULL,59,'图片及视频管理',1,'2014-12-24 14:59:21'),(4,'轮播图','slider',NULL,80,'首页管理',1,'2014-12-24 14:56:01'),(5,'东晨视角','videos',NULL,60,'图片及视频管理',1,'2014-12-29 15:13:31'),(6,'服务项目','service',NULL,100,'通用管理',1,'2014-12-24 14:56:01'),(7,'企业文化','culture',NULL,97,'通用管理',1,'2014-12-24 14:59:21'),(8,'行业建设','jianshe',NULL,96,'通用管理',1,'2014-12-24 14:59:21'),(9,'在线咨询','suggestion',NULL,70,'在线咨询管理',1,'2014-12-24 14:59:21'),(10,'公司荣誉','honor',NULL,95,'通用管理',1,'2014-12-25 04:59:58'),(11,'党政建设','party',NULL,94,'党政建设',1,'2014-12-28 15:38:10');
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
INSERT INTO `tbl_role` VALUES (1,'系统管理员','全部权限',1,'2014-11-24 13:29:07');
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
INSERT INTO `tbl_role_resource` VALUES (1,1,1,1,'2014-11-11 14:20:55'),(2,1,2,1,'2014-11-18 15:27:15'),(3,1,3,1,'2014-12-17 15:35:36'),(4,1,4,1,'2014-12-17 15:35:36'),(5,1,5,1,'2014-12-17 15:35:36'),(6,1,6,1,'2014-12-17 15:35:36'),(7,1,7,1,'2014-12-17 15:35:36'),(8,1,8,1,'2014-11-23 03:41:18'),(9,1,9,1,'2014-11-29 07:46:45'),(10,1,10,1,'2014-11-29 07:46:45'),(11,1,11,1,'2014-12-28 15:38:19');
/*!40000 ALTER TABLE `tbl_role_resource` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_service`
--

DROP TABLE IF EXISTS `tbl_service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_service` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `title` varchar(64) DEFAULT NULL,
  `content` varchar(16384) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `brief` varchar(512) DEFAULT NULL,
  `log_time` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_service`
--

LOCK TABLES `tbl_service` WRITE;
/*!40000 ALTER TABLE `tbl_service` DISABLE KEYS */;
INSERT INTO `tbl_service` VALUES (1,'高压清洗路面油垢黄黑带结构物','<p>高压清洗路面油垢黄黑带结构物</p>','2015-01-05 12:49:58','高压清洗路面油垢黄黑带结构物','2014-12-05'),(2,'地墙面建筑物清洗涂刷处理翻新','<p>地墙面建筑物清洗涂刷处理翻新 &nbsp;</p>','2014-12-28 18:49:50','地墙面建筑物清洗涂刷处理翻新',NULL),(3,'公厕废物箱保洁','<p>公厕废物箱保洁</p>','2014-12-28 18:50:14','公厕废物箱保洁',NULL),(4,'人工清扫保洁','<p style=\"text-align: left;\">人工清扫保洁</p>','2014-12-30 02:41:06','人工清扫保洁',NULL),(5,'道路冲洗洗磨作业','<p>道路冲洗洗磨作业</p>','2014-12-28 18:50:40','道路冲洗洗磨作业',NULL),(6,'机械清扫保洁道路、场地','<p>机械清扫保洁道路、场地</p>','2014-12-28 18:50:51','机械清扫保洁道路、场地',NULL);
/*!40000 ALTER TABLE `tbl_service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_slider`
--

DROP TABLE IF EXISTS `tbl_slider`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_slider` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `link` varchar(128) DEFAULT NULL,
  `pic_url` varchar(128) DEFAULT NULL,
  `brief` varchar(512) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `log_time` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_slider`
--

LOCK TABLES `tbl_slider` WRITE;
/*!40000 ALTER TABLE `tbl_slider` DISABLE KEYS */;
INSERT INTO `tbl_slider` VALUES (4,'http://121.42.45.249/dc-web/web/picNews?id=7','http://121.42.45.249/dc-web/resources/img/uploads/qywh5.jpg','以比促学 以比代教','2015-01-05 12:50:47','2014-12-05'),(5,'http://121.42.45.249/dc-web/web/picNews?id=10','http://121.42.45.249/dc-web/resources/img/uploads/pic-xinwen04.jpg','搏浪健儿竞英豪 东晨职工展新姿','2014-12-28 18:18:04',NULL),(7,'http://121.42.45.249/dc-web/web/picNews?id=8','http://121.42.45.249/dc-web/resources/img/uploads/pic-xinwen01.png','F1作业','2014-12-28 18:19:00',NULL),(8,'http://121.42.45.249/dc-web/web/picNews?id=9','http://121.42.45.249/dc-web/resources/img/uploads/pic-xinwen03.png','东晨公司全力做好“上海邮轮旅游节”环境保障工作','2014-12-28 18:19:26',NULL),(11,'',NULL,'','2015-01-05 12:50:43','2014-12-05');
/*!40000 ALTER TABLE `tbl_slider` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_suggestion`
--

DROP TABLE IF EXISTS `tbl_suggestion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_suggestion` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) DEFAULT NULL,
  `mobile` varchar(64) DEFAULT NULL,
  `address` varchar(256) DEFAULT NULL,
  `email` varchar(128) DEFAULT NULL,
  `title` varchar(128) DEFAULT NULL,
  `content` varchar(2048) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_suggestion`
--

LOCK TABLES `tbl_suggestion` WRITE;
/*!40000 ALTER TABLE `tbl_suggestion` DISABLE KEYS */;
INSERT INTO `tbl_suggestion` VALUES (3,'234','234','234','243','234','2134','2014-12-26 05:23:04'),(4,'','','','','','','2015-01-10 04:02:28'),(5,'','','','','','','2015-01-10 04:03:48'),(6,'123','123','123','123','1234','','2015-01-10 04:04:44');
/*!40000 ALTER TABLE `tbl_suggestion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_videos`
--

DROP TABLE IF EXISTS `tbl_videos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_videos` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `title` varchar(64) DEFAULT NULL,
  `pic_url` varchar(128) DEFAULT NULL,
  `link` varchar(256) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `log_time` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_videos`
--

LOCK TABLES `tbl_videos` WRITE;
/*!40000 ALTER TABLE `tbl_videos` DISABLE KEYS */;
INSERT INTO `tbl_videos` VALUES (2,'2012年东晨公司工作总结','http://121.42.45.249/dc-web/resources/img/uploads/1.jpg','http://www.tudou.com/programs/view/html5embed.action?type=0&code=yRLHj2bPO5Q&lcode=&resourceId=0_06_05_99','2015-01-05 12:50:58','2014-12-05'),(3,'2012年东晨公司工作总结','http://121.42.45.249/dc-web/resources/img/uploads/2.jpg','http://www.tudou.com/v/yRLHj2bPO5Q/&resourceId=0_04_05_99/v.swf','2014-12-28 17:48:37',NULL),(4,'2011东晨市容工作总结','http://121.42.45.249/dc-web/resources/img/uploads/3.jpg','http://www.tudou.com/v/NMz7kXw7HH0/&resourceId=0_04_05_99/v.swf','2014-12-28 17:51:17',NULL),(5,'2011东晨市容工作总结','http://121.42.45.249/dc-web/resources/img/uploads/4.jpg','http://www.tudou.com/v/NMz7kXw7HH0/&resourceId=0_04_05_99/v.swf','2014-12-28 17:52:29',NULL),(7,'321测试','http://121.42.45.249/dc-web/resources/img/uploads/4.jpg','http://player.youku.com/player.php/Type/Folder/Fid/23275074/Ob/1/sid/XODU5MzM5MjI4/v.swf','2014-12-29 08:15:07',NULL);
/*!40000 ALTER TABLE `tbl_videos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-03-02 23:28:28
