-- MySQL dump 10.13  Distrib 8.0.32, for Linux (x86_64)
--
-- Host: localhost    Database: boarddb
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `article` (
  `article_id` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_date` datetime(6) NOT NULL,
  `last_modified_date` datetime(6) NOT NULL,
  `comment_count` int DEFAULT NULL,
  `content` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `likes` int DEFAULT NULL,
  `profile_path` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `title` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `type` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `user_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `user_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `views` int DEFAULT NULL,
  PRIMARY KEY (`article_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` VALUES ('2c92808e86589b110186589b21820000','2023-02-16 05:03:27.034000','2023-02-16 05:03:27.034000',0,'내용입니다.',0,NULL,'제목입니다','CHUNGCHEONG','123456','baek',0),('2c92808e86589b110186589b21cd0001','2023-02-16 05:03:27.181000','2023-02-16 05:03:27.181000',0,'내용입니다.',0,NULL,'제목입니다','CHUNGCHEONG','1234567','seung',0),('2c92808e86589b11018658b2e6f30002','2023-02-16 05:29:24.979000','2023-02-16 05:29:24.979000',0,'seoul',0,'https://k.kakaocdn.net/dn/dpk9l1/btqmGhA2lKL/Oz0wDuJn1YV2DIn92f6DVK/img_640x640.jpg','seoul','SEOUL','2626273266 ','장유범',0),('2c92808e86589b11018658b34b5d0003','2023-02-16 05:29:50.685000','2023-02-16 05:29:50.685000',0,'iiiii',0,'https://k.kakaocdn.net/dn/dpk9l1/btqmGhA2lKL/Oz0wDuJn1YV2DIn92f6DVK/img_640x640.jpg','ggggg','JEONLA','2626273266 ','장유범',0),('2c92808e86589b11018658b3ad5b0004','2023-02-16 05:30:15.771000','2023-02-16 05:30:15.771000',0,'oooo',0,'https://k.kakaocdn.net/dn/dpk9l1/btqmGhA2lKL/Oz0wDuJn1YV2DIn92f6DVK/img_640x640.jpg','hello','JEONLA','2626273266 ','장유범',0),('2c92808e86589b11018658b49ad50005','2023-02-16 05:31:16.565000','2023-02-16 05:31:16.565000',0,'aaaaaaaaaaaaaaaaaa',0,'https://k.kakaocdn.net/dn/dpk9l1/btqmGhA2lKL/Oz0wDuJn1YV2DIn92f6DVK/img_640x640.jpg','zzzzzzzzzzzzzzzzzzzzzz','INCHEON','2626273266 ','장유범',0),('2c92808e86589b11018658b4b7950006','2023-02-16 05:31:23.925000','2023-02-16 05:31:23.925000',0,'aaaaaaaaaaaaaaaaaa',0,'https://k.kakaocdn.net/dn/dpk9l1/btqmGhA2lKL/Oz0wDuJn1YV2DIn92f6DVK/img_640x640.jpg','zzzzzzzzzzzzzzzzzzzzzz','INCHEON','2626273266 ','장유범',0),('2c92808e86589b11018658b554940007','2023-02-16 05:32:04.116000','2023-02-16 05:32:04.116000',0,'abcd',0,'https://k.kakaocdn.net/dn/dpk9l1/btqmGhA2lKL/Oz0wDuJn1YV2DIn92f6DVK/img_640x640.jpg','abcd','KANGWON','2626273266 ','장유범',0),('2c92808e86589b11018658b5aecc0008','2023-02-16 05:32:27.212000','2023-02-16 05:32:27.212000',0,'logic',0,'https://k.kakaocdn.net/dn/dpk9l1/btqmGhA2lKL/Oz0wDuJn1YV2DIn92f6DVK/img_640x640.jpg','jeju','JEJU','2626273266 ','장유범',0),('2c92808e86589b11018658c96fba0009','2023-02-16 05:54:01.785000','2023-02-16 05:54:01.785000',0,'yl',0,'https://k.kakaocdn.net/dn/dpk9l1/btqmGhA2lKL/Oz0wDuJn1YV2DIn92f6DVK/img_640x640.jpg','so','SEOUL','2626273266 ','장유범',0),('2c92808e86589b11018658da12b6000a','2023-02-16 06:12:12.085000','2023-02-16 06:12:12.085000',0,'c1',0,'https://k.kakaocdn.net/dn/dpk9l1/btqmGhA2lKL/Oz0wDuJn1YV2DIn92f6DVK/img_640x640.jpg','h1','CHUNGCHEONG','2626273266 ','장유범',0),('2c92808e86589b11018658dec26d000b','2023-02-16 06:17:19.213000','2023-02-16 06:17:19.213000',0,'dddddddd',0,'https://k.kakaocdn.net/dn/dpk9l1/btqmGhA2lKL/Oz0wDuJn1YV2DIn92f6DVK/img_640x640.jpg','boarddddd','SEOUL','2626273266 ','장유범',0),('2c92808e86589b11018658e2d6ed000c','2023-02-16 06:21:46.604000','2023-02-16 06:21:46.604000',0,'aaa',0,'https://k.kakaocdn.net/dn/dpk9l1/btqmGhA2lKL/Oz0wDuJn1YV2DIn92f6DVK/img_640x640.jpg','abc','SEOUL','2626273266 ','장유범',0),('2c92808e86589b11018658e47470000d','2023-02-16 06:23:32.464000','2023-02-16 06:23:32.464000',0,'asdadasdaadasd',0,'https://k.kakaocdn.net/dn/dpk9l1/btqmGhA2lKL/Oz0wDuJn1YV2DIn92f6DVK/img_640x640.jpg','aadasdadasda','SEOUL','2626273266 ','장유범',0),('2c92808e86589b11018658e6a9bd000e','2023-02-16 06:25:57.181000','2023-02-16 06:25:57.181000',0,'qweasdzxc',0,'https://k.kakaocdn.net/dn/dpk9l1/btqmGhA2lKL/Oz0wDuJn1YV2DIn92f6DVK/img_640x640.jpg','ABCDefg',NULL,'2626273266 ','장유범',0),('2c92808e86589b11018658e6b849000f','2023-02-16 06:26:00.905000','2023-02-16 06:26:00.905000',0,'qweasdzxc',0,'https://k.kakaocdn.net/dn/dpk9l1/btqmGhA2lKL/Oz0wDuJn1YV2DIn92f6DVK/img_640x640.jpg','ABCDefg','JEONLA','2626273266 ','장유범',0),('2c92808e86589b11018658e8fe690010','2023-02-16 06:28:29.929000','2023-02-16 06:28:29.929000',0,'ddddddd',0,'https://k.kakaocdn.net/dn/dpk9l1/btqmGhA2lKL/Oz0wDuJn1YV2DIn92f6DVK/img_640x640.jpg','hellloooo','JEONLA','2626273266 ','장유범',0),('2c92808e86589b11018658ef94da0011','2023-02-16 06:35:41.658000','2023-02-16 06:35:41.658000',0,'hello',0,'https://k.kakaocdn.net/dn/dpk9l1/btqmGhA2lKL/Oz0wDuJn1YV2DIn92f6DVK/img_640x640.jpg','hi','SEOUL','2626273266 ','장유범',0),('2c92808e86589b110186591e43430012','2023-02-16 07:26:40.963000','2023-02-16 07:27:00.012000',0,'hi',0,'https://k.kakaocdn.net/dn/dpk9l1/btqmGhA2lKL/Oz0wDuJn1YV2DIn92f6DVK/img_640x640.jpg','sell pumpkin','SEOUL','2626273266 ','장유범',1),('2c92808e86589b1101865930cc890014','2023-02-16 07:46:55.753000','2023-02-16 08:14:00.010000',0,'hello',0,'https://k.kakaocdn.net/dn/dpk9l1/btqmGhA2lKL/Oz0wDuJn1YV2DIn92f6DVK/img_640x640.jpg','hi ','GYEONGSANG','2626273266 ','장유범',1),('2c92808e86589b110186593e4d670017','2023-02-16 08:01:40.711000','2023-02-16 08:02:00.012000',0,'here',0,'https://k.kakaocdn.net/dn/dpk9l1/btqmGhA2lKL/Oz0wDuJn1YV2DIn92f6DVK/img_640x640.jpg','welcome','SEOUL','2626273266 ','장유범',1),('2c92808e86589b110186594bbb7d0019','2023-02-16 08:16:20.861000','2023-02-16 14:55:00.013000',0,'contents',0,'https://k.kakaocdn.net/dn/dpk9l1/btqmGhA2lKL/Oz0wDuJn1YV2DIn92f6DVK/img_640x640.jpg','seoul text ','SEOUL','2626273266 ','장유범',1),('2c92808e86589b110186595cc9e90020','2023-02-16 08:34:58.665000','2023-02-16 08:51:00.008000',0,'asdf',0,'https://k.kakaocdn.net/dn/dpk9l1/btqmGhA2lKL/Oz0wDuJn1YV2DIn92f6DVK/img_640x640.jpg','hhhhhqwer','CHUNGCHEONG','2626273266 ','장유범',1),('2c92808e86589b1101865962cb190022','2023-02-16 08:41:32.184000','2023-02-16 08:42:00.012000',0,'cdcdcdcdasddddddddddddddd',0,'https://k.kakaocdn.net/dn/dpk9l1/btqmGhA2lKL/Oz0wDuJn1YV2DIn92f6DVK/img_640x640.jpg','Inchhhhh','INCHEON','2626273266 ','장유범',1),('2c92808e86589b110186596dd4670026','2023-02-16 08:53:35.463000','2023-02-16 08:53:35.463000',0,'iiiii',0,'https://k.kakaocdn.net/dn/dpk9l1/btqmGhA2lKL/Oz0wDuJn1YV2DIn92f6DVK/img_640x640.jpg','hhhh','JEJU','2626273266 ','장유범',0),('2c92808e86589b110186596e9fd00027','2023-02-16 08:54:27.536000','2023-02-16 08:54:27.536000',0,'hi',0,'https://k.kakaocdn.net/dn/dpk9l1/btqmGhA2lKL/Oz0wDuJn1YV2DIn92f6DVK/img_640x640.jpg','hi','INCHEON','2626273266 ','장유범',0),('2c92808e86589b11018659c633cc0029','2023-02-16 10:30:07.052000','2023-02-16 10:30:07.052000',0,'hhhh',0,'https://k.kakaocdn.net/dn/dpk9l1/btqmGhA2lKL/Oz0wDuJn1YV2DIn92f6DVK/img_640x640.jpg','hi','JEONLA','2626273266 ','장유범',0),('2c92808e86589b1101865ab4980b002b','2023-02-16 14:50:30.283000','2023-02-16 14:50:30.283000',0,'',0,'maryfarm/f5cbdd05-909d-40a7-9606-3e1104faf25b.png','화분 추천해주세요','SEOUL','2657407159 ','강차분',0),('2c92808e86589b1101865ab4d9e8002c','2023-02-16 14:50:47.144000','2023-02-16 14:50:47.144000',0,'',0,'maryfarm/f5cbdd05-909d-40a7-9606-3e1104faf25b.png','안녕하세요','SEOUL','2657407159 ','강차분',0),('2c92808e86589b1101865ab6c179002d','2023-02-16 14:52:51.961000','2023-02-16 14:52:51.961000',0,'궁금해요',0,'maryfarm/f5cbdd05-909d-40a7-9606-3e1104faf25b.png','강서 꽃집 어디있나요','SEOUL','2657407159 ','강차분',0),('2c92808e86589b1101865ab72338002e','2023-02-16 14:53:16.984000','2023-02-16 14:53:16.984000',0,'',0,'maryfarm/f5cbdd05-909d-40a7-9606-3e1104faf25b.png','첫 게시글 반가워요',NULL,'2657407159 ','강차분',0),('2c92808e86589b1101865ab7316e002f','2023-02-16 14:53:20.621000','2023-02-16 14:53:20.621000',0,'',0,'maryfarm/f5cbdd05-909d-40a7-9606-3e1104faf25b.png','첫 게시글 반가워요','SEOUL','2657407159 ','강차분',0),('2c92808e86589b1101865ab7bb470030','2023-02-16 14:53:55.911000','2023-02-16 14:53:55.911000',0,'',0,'maryfarm/f5cbdd05-909d-40a7-9606-3e1104faf25b.png','호박씨 파는곳 있나요','SEOUL','2657407159 ','강차분',0),('2c92808e86589b1101865ab869030031','2023-02-16 14:54:40.387000','2023-02-16 14:54:40.387000',0,'',0,'maryfarm/f5cbdd05-909d-40a7-9606-3e1104faf25b.png','집에서 키울만한 작물','SEOUL','2657407159 ','강차분',0),('2c92808e86589b1101865ab8c3990032','2023-02-16 14:55:03.577000','2023-02-16 14:55:03.577000',0,'',0,'maryfarm/f5cbdd05-909d-40a7-9606-3e1104faf25b.png','반가워요','SEOUL','2657407159 ','강차분',0),('2c92808e86589b1101865aba9dad0033','2023-02-16 14:57:04.940000','2023-02-16 14:57:04.940000',0,'ㅎㅎ',0,'maryfarm/f5cbdd05-909d-40a7-9606-3e1104faf25b.png','안녕하세요',NULL,'2657407159 ','강차분',0),('2c92808e86589b1101865abaad7c0034','2023-02-16 14:57:08.988000','2023-02-16 14:58:00.014000',0,'ㅎㅎ',0,'maryfarm/f5cbdd05-909d-40a7-9606-3e1104faf25b.png','안녕하세요','SEOUL','2657407159 ','강차분',1);
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `article_comment`
--

DROP TABLE IF EXISTS `article_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `article_comment` (
  `article_comment_id` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_date` datetime(6) NOT NULL,
  `last_modified_date` datetime(6) NOT NULL,
  `content` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `likes` int DEFAULT NULL,
  `profile_path` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `user_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `user_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `article_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`article_comment_id`),
  KEY `FKghmocqkgqs5tkmucf5putw64t` (`article_id`),
  CONSTRAINT `FKghmocqkgqs5tkmucf5putw64t` FOREIGN KEY (`article_id`) REFERENCES `article` (`article_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article_comment`
--

LOCK TABLES `article_comment` WRITE;
/*!40000 ALTER TABLE `article_comment` DISABLE KEYS */;
INSERT INTO `article_comment` VALUES ('2c92808e86589b110186591e7ba20013','2023-02-16 07:26:55.390000','2023-02-16 07:26:55.390000','hello',0,'https://k.kakaocdn.net/dn/dpk9l1/btqmGhA2lKL/Oz0wDuJn1YV2DIn92f6DVK/img_640x640.jpg','2626273266 ','장유범','2c92808e86589b110186591e43430012'),('2c92808e86589b1101865930f5d00015','2023-02-16 07:47:06.320000','2023-02-16 07:47:06.320000','hhhh',0,'https://k.kakaocdn.net/dn/dpk9l1/btqmGhA2lKL/Oz0wDuJn1YV2DIn92f6DVK/img_640x640.jpg','2626273266 ','장유범','2c92808e86589b1101865930cc890014'),('2c92808e86589b1101865937afa20016','2023-02-16 07:54:27.105000','2023-02-16 07:54:27.105000','hello',0,'https://k.kakaocdn.net/dn/dpk9l1/btqmGhA2lKL/Oz0wDuJn1YV2DIn92f6DVK/img_640x640.jpg','2626273266 ','장유범','2c92808e86589b1101865930cc890014'),('2c92808e86589b110186593e7b8d0018','2023-02-16 08:01:52.525000','2023-02-16 08:01:52.525000','hi',0,'https://k.kakaocdn.net/dn/dpk9l1/btqmGhA2lKL/Oz0wDuJn1YV2DIn92f6DVK/img_640x640.jpg','2626273266 ','장유범','2c92808e86589b110186593e4d670017'),('2c92808e86589b110186594bfdd8001a','2023-02-16 08:16:37.848000','2023-02-16 08:16:37.848000','cotnentssss',0,'https://k.kakaocdn.net/dn/dpk9l1/btqmGhA2lKL/Oz0wDuJn1YV2DIn92f6DVK/img_640x640.jpg','2626273266 ','장유범','2c92808e86589b110186594bbb7d0019'),('2c92808e86589b110186594c98b4001b','2023-02-16 08:17:17.492000','2023-02-16 08:17:17.492000','text',0,'https://k.kakaocdn.net/dn/dpk9l1/btqmGhA2lKL/Oz0wDuJn1YV2DIn92f6DVK/img_640x640.jpg','2626273266 ','장유범','2c92808e86589b110186594bbb7d0019'),('2c92808e86589b11018659530a87001c','2023-02-16 08:24:19.847000','2023-02-16 08:24:19.847000','text',0,'https://k.kakaocdn.net/dn/dpk9l1/btqmGhA2lKL/Oz0wDuJn1YV2DIn92f6DVK/img_640x640.jpg','2626273266 ','장유범','2c92808e86589b110186594bbb7d0019'),('2c92808e86589b11018659532447001d','2023-02-16 08:24:26.439000','2023-02-16 08:24:26.439000','text',0,'https://k.kakaocdn.net/dn/dpk9l1/btqmGhA2lKL/Oz0wDuJn1YV2DIn92f6DVK/img_640x640.jpg','2626273266 ','장유범','2c92808e86589b110186594bbb7d0019'),('2c92808e86589b110186595328ec001e','2023-02-16 08:24:27.628000','2023-02-16 08:24:27.628000','',0,'https://k.kakaocdn.net/dn/dpk9l1/btqmGhA2lKL/Oz0wDuJn1YV2DIn92f6DVK/img_640x640.jpg','2626273266 ','장유범','2c92808e86589b110186594bbb7d0019'),('2c92808e86589b1101865953f7e1001f','2023-02-16 08:25:20.609000','2023-02-16 08:25:20.609000','hi',0,'https://k.kakaocdn.net/dn/dpk9l1/btqmGhA2lKL/Oz0wDuJn1YV2DIn92f6DVK/img_640x640.jpg','2626273266 ','장유범','2c92808e86589b110186594bbb7d0019'),('2c92808e86589b110186595cf3fd0021','2023-02-16 08:35:09.436000','2023-02-16 08:35:09.436000','hi',0,'https://k.kakaocdn.net/dn/dpk9l1/btqmGhA2lKL/Oz0wDuJn1YV2DIn92f6DVK/img_640x640.jpg','2626273266 ','장유범','2c92808e86589b110186595cc9e90020'),('2c92808e86589b1101865962efb80023','2023-02-16 08:41:41.560000','2023-02-16 08:41:41.560000','hi',0,'https://k.kakaocdn.net/dn/dpk9l1/btqmGhA2lKL/Oz0wDuJn1YV2DIn92f6DVK/img_640x640.jpg','2626273266 ','장유범','2c92808e86589b1101865962cb190022'),('2c92808e86589b110186596b17e10024','2023-02-16 08:50:36.129000','2023-02-16 08:50:36.129000','hello',0,'https://k.kakaocdn.net/dn/dpk9l1/btqmGhA2lKL/Oz0wDuJn1YV2DIn92f6DVK/img_640x640.jpg','2626273266 ','장유범','2c92808e86589b110186595cc9e90020'),('2c92808e86589b110186596b299f0025','2023-02-16 08:50:40.671000','2023-02-16 08:50:40.671000','hi',0,'https://k.kakaocdn.net/dn/dpk9l1/btqmGhA2lKL/Oz0wDuJn1YV2DIn92f6DVK/img_640x640.jpg','2626273266 ','장유범','2c92808e86589b110186595cc9e90020'),('2c92808e86589b110186596ece360028','2023-02-16 08:54:39.414000','2023-02-16 08:54:39.414000','hee',0,'https://k.kakaocdn.net/dn/dpk9l1/btqmGhA2lKL/Oz0wDuJn1YV2DIn92f6DVK/img_640x640.jpg','2626273266 ','장유범','2c92808e86589b110186596e9fd00027'),('2c92808e86589b11018659c66971002a','2023-02-16 10:30:20.785000','2023-02-16 10:30:20.785000','tt',0,'https://k.kakaocdn.net/dn/dpk9l1/btqmGhA2lKL/Oz0wDuJn1YV2DIn92f6DVK/img_640x640.jpg','2626273266 ','장유범','2c92808e86589b11018659c633cc0029'),('2c92808e86589b1101865abb2e3c0035','2023-02-16 14:57:41.948000','2023-02-16 14:57:41.948000','안녕',0,'maryfarm/f5cbdd05-909d-40a7-9606-3e1104faf25b.png','2657407159 ','강차분','2c92808e86589b1101865abaad7c0034');
/*!40000 ALTER TABLE `article_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `article_comment_like`
--

DROP TABLE IF EXISTS `article_comment_like`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `article_comment_like` (
  `article_comment_like_id` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_date` datetime(6) NOT NULL,
  `last_modified_date` datetime(6) NOT NULL,
  `user_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `article_comment_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`article_comment_like_id`),
  KEY `FKo4e7um6u9w9l64d9nqs8bqqgf` (`article_comment_id`),
  CONSTRAINT `FKo4e7um6u9w9l64d9nqs8bqqgf` FOREIGN KEY (`article_comment_id`) REFERENCES `article_comment` (`article_comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article_comment_like`
--

LOCK TABLES `article_comment_like` WRITE;
/*!40000 ALTER TABLE `article_comment_like` DISABLE KEYS */;
/*!40000 ALTER TABLE `article_comment_like` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `article_like`
--

DROP TABLE IF EXISTS `article_like`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `article_like` (
  `article_like_id` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_date` datetime(6) NOT NULL,
  `last_modified_date` datetime(6) NOT NULL,
  `user_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `article_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`article_like_id`),
  KEY `FKabthli6g1qjriusniw93pbesw` (`article_id`),
  CONSTRAINT `FKabthli6g1qjriusniw93pbesw` FOREIGN KEY (`article_id`) REFERENCES `article` (`article_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article_like`
--

LOCK TABLES `article_like` WRITE;
/*!40000 ALTER TABLE `article_like` DISABLE KEYS */;
/*!40000 ALTER TABLE `article_like` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `article_re_comment`
--

DROP TABLE IF EXISTS `article_re_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `article_re_comment` (
  `article_recomment_id` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_date` datetime(6) NOT NULL,
  `last_modified_date` datetime(6) NOT NULL,
  `content` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `user_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `user_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `comment_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`article_recomment_id`),
  KEY `FKk7a1srm6nyyv5j5grmnlvqub9` (`comment_id`),
  CONSTRAINT `FKk7a1srm6nyyv5j5grmnlvqub9` FOREIGN KEY (`comment_id`) REFERENCES `article_comment` (`article_comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article_re_comment`
--

LOCK TABLES `article_re_comment` WRITE;
/*!40000 ALTER TABLE `article_re_comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `article_re_comment` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-16 16:23:20
