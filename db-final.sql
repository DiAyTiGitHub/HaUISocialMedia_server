-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: hauisocialmedia
-- ------------------------------------------------------
-- Server version	8.0.36

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tbl_board_record`
--

DROP TABLE IF EXISTS `tbl_board_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_board_record` (
  `id` varchar(36) NOT NULL,
  `last_modify_date` datetime(6) DEFAULT NULL,
  `nums_ofa` int DEFAULT NULL,
  `nums_ofb` int DEFAULT NULL,
  `nums_ofbplus` int DEFAULT NULL,
  `nums_ofc` int DEFAULT NULL,
  `nums_ofcplus` int DEFAULT NULL,
  `nums_ofd` int DEFAULT NULL,
  `nums_ofdplus` int DEFAULT NULL,
  `user_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_nyutw20qgm6153c6dyl3y72sa` (`user_id`),
  CONSTRAINT `FK29h3nqpfdemj3kkjmsyw33frx` FOREIGN KEY (`user_id`) REFERENCES `tbl_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_board_record`
--

LOCK TABLES `tbl_board_record` WRITE;
/*!40000 ALTER TABLE `tbl_board_record` DISABLE KEYS */;
INSERT INTO `tbl_board_record` VALUES ('11be51bb-9981-447f-aab2-750d15e18752',NULL,0,0,0,0,0,0,0,'8194a9b3-8928-4e71-bcd5-8c9e097477a2'),('1934c6d3-fe64-494d-becd-9b0d140767bc',NULL,0,0,0,0,0,0,0,'425de6bd-d753-4018-ae17-ef60899a5d83'),('233d247a-9f68-49e1-973b-5e83940cd2fc','2024-06-02 18:24:12.538000',1,0,1,0,0,0,0,'18db5d5e-b0ca-40aa-a30a-77689ca15c81'),('2893ec64-bf6c-49d4-9ad1-2b43223fae10',NULL,0,0,0,0,0,0,0,'6e33737a-1793-45fa-90aa-200a81aa040f'),('3b32c5d2-652b-498e-a7ac-b69e238317a5',NULL,0,0,0,0,0,0,0,'494472fd-7efe-4f16-aac2-5f4b9ddbb858'),('51fe30fc-4997-47c2-8ce5-48827747376d','2024-06-02 18:24:51.364000',3,0,0,0,0,0,0,'8f92ac71-000f-4b7b-a44b-38d9a5600dcf'),('6420d41e-6dac-40cc-ae42-19db7f118b0c','2024-06-02 18:26:39.488000',1,0,0,0,0,0,0,'0de3a80c-b081-4ed1-b226-959eac2ba890'),('657494d8-4895-459f-811a-b5bfa6cb4443',NULL,0,0,0,0,0,0,0,'6e3c4374-9f54-46c2-bb9a-49c16bd8db58'),('6f3af965-b4f4-41a2-aead-b4b9ab56e0b7','2024-06-02 18:24:36.839000',1,1,0,0,0,0,0,'27630a2d-1ee2-4d4d-bd43-df16f8629de3'),('8d766379-edc2-4000-a55c-572faf3d4297','2024-06-02 18:26:43.717000',2,1,1,0,0,0,0,'2858dab1-4fe2-4ee6-87c0-84a597d42233'),('ab687200-9dec-48c5-b751-211ba6bdbf65',NULL,0,0,0,0,0,0,0,'b40391f8-ef74-43a9-9af5-b7c58063142c'),('b339cbbc-da32-4a83-9ea1-d6ba74c38df4','2024-06-02 18:26:58.135000',0,1,0,0,0,0,0,'2a1fae2e-c56c-4c7c-b95d-235721fcd1ec'),('bcb9ef81-d451-4b47-9625-571c36fcd6b5',NULL,0,0,0,0,0,0,0,'2ae2e621-b81f-4035-aa2d-8d3280c288c5'),('e763624f-cf17-4184-a3de-c8e4e67b8e31','2024-06-02 18:27:02.389000',3,0,0,0,0,0,0,'b0a97e72-6dec-4e2d-82a7-679339ccbd00'),('f3ee7233-6a5b-483d-9173-96a2fe7a7e5d',NULL,0,0,0,0,0,0,0,'86903379-c3f9-4139-8e63-f19f976b7152');
/*!40000 ALTER TABLE `tbl_board_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_class`
--

DROP TABLE IF EXISTS `tbl_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_class` (
  `id` varchar(36) NOT NULL,
  `code` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_class`
--

LOCK TABLES `tbl_class` WRITE;
/*!40000 ALTER TABLE `tbl_class` DISABLE KEYS */;
INSERT INTO `tbl_class` VALUES ('09143f0a-5757-45f4-9b78-3b969b78bb1e','018','Ngành quản trị kinh doanh','QTKD02'),('1283e394-a43f-4b4c-9136-eecffa87387c','005','Ngành hệ thống thông tin','HTTT)1'),('1c740839-daf3-450e-a3b8-dbd1d92fcf22','017','Ngành quản trị kinh doanh','QTKD01'),('251323e4-0106-4e49-b20f-7e0429e18994','014','Ngành khoa học máy tính','KHMT02'),('2a317206-0749-4a20-ade3-c77552fdc86d','011','Ngành công nghệ thôn tin','CNTT03'),('2a605468-e82b-4882-8823-e1c00847d6b6','005','Ngành hệ thống thông tin','HTTT)1'),('2d85f87d-38df-4139-8538-4a10d648aef4','016','Ngành khoa học máy tính','KHMT04'),('30f1fe70-0f2f-4a1c-9b05-605b36f652df','006','Ngành hệ thống thông tin','HTTT02'),('31526e23-1801-4044-a28a-547a53d8055f','004','Ngành kĩ thuật phần mềm','KTPM01'),('3614c54d-b08a-4119-9bfb-aba2dc92a96b','005','Ngành hệ thống thông tin','HTTT)1'),('3fb5892b-aba2-4a2a-b09e-9d0e0762519b','012','Ngành công nghệ thôn tin','CNTT04'),('45734aa9-ed10-4680-b64d-16d79a4a64ea','015','Ngành khoa học máy tính','KHMT03'),('47b23ff1-27a1-4387-acd3-5e00ec630ca7','008','Ngành hệ thống thông tin','HTTT04'),('47b5238b-ec56-456c-a4b9-fb26063b7db4','005','Ngành hệ thống thông tin','HTTT)1'),('5d0935ad-639b-444b-8e9d-8f9924a59f65','009','Ngành công nghệ thôn tin','CNTT01'),('5d613b8e-fca7-4b27-93e7-f6a62be7762b','019','Ngành quản trị kinh doanh','QTKD03'),('701f0aae-36f5-4959-8d39-a56443b45365','007','Ngành hệ thống thông tin','HTTT03'),('7098227f-3674-4b7f-a476-e1e6d2e904e6','010','Ngành công nghệ thôn tin','CNTT02'),('b6c8fff9-843f-457e-8c92-8de104009cb8','001','Ngành kĩ thuật phần mềm','KTPM04'),('b9e832ec-a333-4dd4-95c9-93a6e08b7f30','005','Ngành hệ thống thông tin','HTTT)1'),('c0024924-3d6c-4e3e-8ade-3fff75579cbd','002','Ngành kĩ thuật phần mềm','KTPM03'),('dcd64c84-b03d-4376-969d-9e6fb4863eb5','003','Ngành kĩ thuật phần mềm','KTPM02'),('eb35ae0a-9fad-482e-9d48-994be63e1129','020','Ngành quản trị kinh doanh','QTKD04'),('effa5d00-2861-4bb4-88a1-9de4dd9bced5','005','Ngành hệ thống thông tin','HTTT)1'),('f68316cd-c606-4d73-8907-20a7c1c7fd5d','013','Ngành khoa học máy tính','KHMT01');
/*!40000 ALTER TABLE `tbl_class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_comment`
--

DROP TABLE IF EXISTS `tbl_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_comment` (
  `id` varchar(36) NOT NULL,
  `content` longtext,
  `create_date` datetime(6) DEFAULT NULL,
  `owner_id` varchar(36) DEFAULT NULL,
  `post_id` varchar(36) DEFAULT NULL,
  `replied_comment_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKa2ybupfuy2ga2otmqaiela3j1` (`owner_id`),
  KEY `FKi7k73l5d2j9cvam2bkepym80k` (`post_id`),
  KEY `FKnfox2si8mbjb0ofbtcq32dymg` (`replied_comment_id`),
  CONSTRAINT `FKa2ybupfuy2ga2otmqaiela3j1` FOREIGN KEY (`owner_id`) REFERENCES `tbl_user` (`id`),
  CONSTRAINT `FKi7k73l5d2j9cvam2bkepym80k` FOREIGN KEY (`post_id`) REFERENCES `tbl_post` (`id`),
  CONSTRAINT `FKnfox2si8mbjb0ofbtcq32dymg` FOREIGN KEY (`replied_comment_id`) REFERENCES `tbl_comment` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_comment`
--

LOCK TABLES `tbl_comment` WRITE;
/*!40000 ALTER TABLE `tbl_comment` DISABLE KEYS */;
INSERT INTO `tbl_comment` VALUES ('3ea66617-974e-40b5-819b-cc840e7d7f7d','study with me','2024-06-02 20:38:40.340000','27630a2d-1ee2-4d4d-bd43-df16f8629de3','95e5ba14-c21b-47d8-b797-f2cb7dd711af',NULL),('c5c50e62-157d-4f75-bdb4-105d47ed9326',':3','2024-06-02 20:35:29.946000','27630a2d-1ee2-4d4d-bd43-df16f8629de3','21731018-f3d9-4505-8336-ab33f3cfe5f8',NULL),('e189cdf4-db8a-4dad-bd5a-ba9a436e6467','thanks','2024-06-02 20:36:25.209000','2ae2e621-b81f-4035-aa2d-8d3280c288c5','21731018-f3d9-4505-8336-ab33f3cfe5f8','c5c50e62-157d-4f75-bdb4-105d47ed9326');
/*!40000 ALTER TABLE `tbl_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_course`
--

DROP TABLE IF EXISTS `tbl_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_course` (
  `id` varchar(36) NOT NULL,
  `code` varchar(255) NOT NULL,
  `description` longtext,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_course`
--

LOCK TABLES `tbl_course` WRITE;
/*!40000 ALTER TABLE `tbl_course` DISABLE KEYS */;
INSERT INTO `tbl_course` VALUES ('01c8364f-783e-4d5c-b5e5-2cdc60da3dcd','001','Môn học tính toán cơ bản','Giải tích'),('020ab6d2-86fb-4241-aea2-66a4f77f1323','020','Môn học thực tập chuyên ngành','Thực tập chuyên ngành'),('0eb386ef-bbd5-4c1c-a682-bcdc063c340a','011','Môn học của C# cơ bản','Lập trình .Net'),('25dc9b6f-4793-4bfb-97eb-029a5c551a50','004','Môn lập trình hướng đối tượng','Lập trình hướng đối tượng'),('2832ffc9-88cf-4314-8cf7-3b901cf256f5','006','Môn học java cơ bản','Lập trình java'),('441f7e10-43bb-4ff5-a258-8b7916dcfc03','018','Môn học về thiết kế web','Thiết kế web'),('5d58f6fc-c660-48d3-a38b-3bcca7616bb4','019','Môn học về kiểm thử phần mềm','Kiểm thử phần mềm'),('66848185-828b-48c0-a8b6-14d0310df1cd','002','Môn học tính toán trung binh','Đại số tuyến tính'),('7a02cbc7-d1e1-4251-8b6c-2d52e1f53ae9','013','Môn lập trình game cơ bản','Lập trình game'),('8e9cf898-6953-4453-ba3a-573a793479a0','017','Môn học về an toàn bảo mật thông tin','An toàn bảo mật thông tin'),('9068deaf-c4b7-4668-a7c0-4c027f9e3acc','008','Môn học liên quan đến lịch sử đất nước','Lịch sử đảng'),('a6831aa2-d976-41d4-abac-6e49f2be7bb4','010','Môn lập trình C++ cơ bản','Lập trình C++'),('b1915384-ba53-40a8-8fe7-c9ece08246ad','005','Môn học của java mạng socket','Java nâng cao'),('b876ca6c-399c-469c-9c45-de623e369174','007','Môn học liên quan đến đời sống xã hội','Triết học'),('c4485d51-8eb0-4d3a-940c-a9ab236eb2df','016','Môn học về kiến trúc máy tính','Kiến trúc máy tính'),('c522540c-10b5-4d35-932c-ccb0788b8c51','014','Môn thiết kế cơ bản về giao diện','Thiết kế giao diện người dùng'),('cb4860c6-c5e7-4e1f-9924-6bde1533f9e0','003','Môn lập trình cơ bản','Kỹ thuật lập trình'),('eb2ab1b7-399d-465a-a0d0-efb8f6a453f3','015','Môn học về đồ họa máy tính','Đồ họa máy tính'),('f61453d5-2d69-414b-8131-208406817a82','009','Môn liên quan đến pháp luật cơ bản','Pháp luật đại cương'),('fc586e87-140a-4721-8189-929dff9e7f37','012','Môn học liên quan đến C# nâng cao','ASP.Net');
/*!40000 ALTER TABLE `tbl_course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_course_result`
--

DROP TABLE IF EXISTS `tbl_course_result`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_course_result` (
  `id` varchar(36) NOT NULL,
  `code` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_course_result`
--

LOCK TABLES `tbl_course_result` WRITE;
/*!40000 ALTER TABLE `tbl_course_result` DISABLE KEYS */;
INSERT INTO `tbl_course_result` VALUES ('1a37827a-0801-4ea6-b2c1-d2b23956f320','F','Học sinh đạt thành tích kém','Kém'),('206f920e-a79f-4513-a297-07b846818800','C','Học sinh đạt thành tích trung bình khá','Trung bình khá'),('32cfd477-a445-4b23-a815-2f22d170e1e5','A','Học sinh đạt thành tích xuất sắc','Xuất sắc'),('4e7bb095-c9d3-4594-af9f-98bef4d4e2d7','C+','Học sinh đạt thành tích khá','Khá'),('a0a6ae42-bbc4-41bc-a07a-1ac9b15e9a36','D+','Học sinh đạt thành tích trung bình','Trung bình'),('a2aa251c-aefe-450c-925b-50ccc793ba88','B+','Học sinh đạt thành tích giỏi','Giỏi'),('da2dfd9f-0b1e-482f-ade9-9ee9b9a95923','D','Học sinh đạt thành tích trung bình kém','Trung bình kém'),('e5f8d916-b555-4565-a3c6-826f97909ab9','B','Học sinh đạt thành tích khá giỏi','Khá giỏi');
/*!40000 ALTER TABLE `tbl_course_result` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_group`
--

DROP TABLE IF EXISTS `tbl_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_group` (
  `id` varchar(36) NOT NULL,
  `avatar` longtext,
  `back_ground_image` longtext,
  `code` varchar(255) DEFAULT NULL,
  `create_date` datetime(6) DEFAULT NULL,
  `description` longtext,
  `name` varchar(255) NOT NULL,
  `user_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlyn4fsojm5crqa6gfpmkkk98` (`user_id`),
  CONSTRAINT `FKlyn4fsojm5crqa6gfpmkkk98` FOREIGN KEY (`user_id`) REFERENCES `tbl_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_group`
--

LOCK TABLES `tbl_group` WRITE;
/*!40000 ALTER TABLE `tbl_group` DISABLE KEYS */;
INSERT INTO `tbl_group` VALUES ('18115076-c413-4248-984e-bfaad22b542f','https://images.pexels.com/photos/9046696/pexels-photo-9046696.jpeg?auto=compress&cs=tinysrgb&w=600','https://images.pexels.com/photos/9046696/pexels-photo-9046696.jpeg?auto=compress&cs=tinysrgb&w=600',NULL,'2024-06-02 17:56:00.953000','Nhóm của chúng ta đang chờ đón bạn - Hãy cùng nhau chinh phục những mục tiêu mới!','Làm Việc Hiệu Quả','6e3c4374-9f54-46c2-bb9a-49c16bd8db58'),('2ada6fb9-3115-4e07-9be8-eb11c5ce671a','https://images.pexels.com/photos/301920/pexels-photo-301920.jpeg?auto=compress&cs=tinysrgb&w=600','https://images.pexels.com/photos/301920/pexels-photo-301920.jpeg?auto=compress&cs=tinysrgb&w=600',NULL,'2024-06-02 18:01:15.133000','Học tập hiệu quả không chỉ là học chăm chỉ, mà còn là học thông minh. Khám phá ngay các phương pháp giúp bạn tối ưu hóa thời gian và công sức!','Chia Sẻ Phương Pháp Học Tập','2ae2e621-b81f-4035-aa2d-8d3280c288c5');
/*!40000 ALTER TABLE `tbl_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_like`
--

DROP TABLE IF EXISTS `tbl_like`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_like` (
  `id` varchar(36) NOT NULL,
  `create_date` datetime(6) DEFAULT NULL,
  `post_id` varchar(36) DEFAULT NULL,
  `user_like_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1gtdp58335loyc3oyoi71pkpx` (`post_id`),
  KEY `FKcq19w94na0fui2wopteil7kkf` (`user_like_id`),
  CONSTRAINT `FK1gtdp58335loyc3oyoi71pkpx` FOREIGN KEY (`post_id`) REFERENCES `tbl_post` (`id`),
  CONSTRAINT `FKcq19w94na0fui2wopteil7kkf` FOREIGN KEY (`user_like_id`) REFERENCES `tbl_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_like`
--

LOCK TABLES `tbl_like` WRITE;
/*!40000 ALTER TABLE `tbl_like` DISABLE KEYS */;
INSERT INTO `tbl_like` VALUES ('0af3a865-83f2-4d8c-a599-4bdc15725a74','2024-06-02 18:11:29.841000','21731018-f3d9-4505-8336-ab33f3cfe5f8','2a1fae2e-c56c-4c7c-b95d-235721fcd1ec'),('8d16be9d-2696-4d17-a1bb-e7dbb15f00c2','2024-06-03 14:48:08.604000','21731018-f3d9-4505-8336-ab33f3cfe5f8','2ae2e621-b81f-4035-aa2d-8d3280c288c5'),('b9eb4ea2-ac93-40f7-b527-51c06801ca68','2024-06-02 18:10:55.058000','99898889-d3e6-4aa5-a319-7b9218d13d10','2ae2e621-b81f-4035-aa2d-8d3280c288c5'),('c5533eb4-9941-44fc-a14d-bb2bf9d966b2','2024-06-02 20:35:15.277000','95e5ba14-c21b-47d8-b797-f2cb7dd711af','27630a2d-1ee2-4d4d-bd43-df16f8629de3'),('f300a84a-6fd6-4958-80c1-8d25a565eecb','2024-06-02 18:10:58.028000','2a89bcd3-4c78-4275-96f8-2940ef7f8e96','2ae2e621-b81f-4035-aa2d-8d3280c288c5'),('f5e5a249-6ab7-4a06-9883-3546f26575b7','2024-06-03 14:48:27.754000','95e5ba14-c21b-47d8-b797-f2cb7dd711af','2ae2e621-b81f-4035-aa2d-8d3280c288c5');
/*!40000 ALTER TABLE `tbl_like` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_member`
--

DROP TABLE IF EXISTS `tbl_member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_member` (
  `id` varchar(36) NOT NULL,
  `is_approved` bit(1) DEFAULT NULL,
  `join_date` datetime(6) DEFAULT NULL,
  `role` tinyint NOT NULL,
  `group_id` varchar(36) DEFAULT NULL,
  `user_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKtdxhotuflt1maof8nqv9nh6o9` (`group_id`),
  KEY `FK8h4fnujphelw6r6eb6grmjaab` (`user_id`),
  CONSTRAINT `FK8h4fnujphelw6r6eb6grmjaab` FOREIGN KEY (`user_id`) REFERENCES `tbl_user` (`id`),
  CONSTRAINT `FKtdxhotuflt1maof8nqv9nh6o9` FOREIGN KEY (`group_id`) REFERENCES `tbl_group` (`id`),
  CONSTRAINT `tbl_member_chk_1` CHECK ((`role` between 0 and 1))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_member`
--

LOCK TABLES `tbl_member` WRITE;
/*!40000 ALTER TABLE `tbl_member` DISABLE KEYS */;
INSERT INTO `tbl_member` VALUES ('10ae418f-ddea-4197-a58d-af51625d685b',_binary '',NULL,1,'2ada6fb9-3115-4e07-9be8-eb11c5ce671a','86903379-c3f9-4139-8e63-f19f976b7152'),('4146639d-6cc8-44c5-9596-1649b939574c',_binary '','2024-06-02 17:56:00.963000',0,'18115076-c413-4248-984e-bfaad22b542f','6e3c4374-9f54-46c2-bb9a-49c16bd8db58'),('b215f18a-81cf-49ed-8bc8-6a1271a86349',_binary '\0',NULL,1,'2ada6fb9-3115-4e07-9be8-eb11c5ce671a','2a1fae2e-c56c-4c7c-b95d-235721fcd1ec'),('ce4183fb-18a3-4492-8a86-fb38f8bd9c86',_binary '',NULL,1,'18115076-c413-4248-984e-bfaad22b542f','27630a2d-1ee2-4d4d-bd43-df16f8629de3'),('d0f326f9-0507-4ba7-b304-1f6a383dab49',_binary '','2024-06-02 18:01:15.177000',0,'2ada6fb9-3115-4e07-9be8-eb11c5ce671a','2ae2e621-b81f-4035-aa2d-8d3280c288c5'),('f24904b1-663b-4c68-aa50-58e90e99f5cd',_binary '\0',NULL,1,'2ada6fb9-3115-4e07-9be8-eb11c5ce671a','0de3a80c-b081-4ed1-b226-959eac2ba890');
/*!40000 ALTER TABLE `tbl_member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_message`
--

DROP TABLE IF EXISTS `tbl_message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_message` (
  `id` varchar(36) NOT NULL,
  `content` longtext,
  `send_date` datetime(6) DEFAULT NULL,
  `message_type_id` varchar(36) DEFAULT NULL,
  `room_id` varchar(36) DEFAULT NULL,
  `user_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKh5qqt34dhtarh7bu0kldu1djc` (`message_type_id`),
  KEY `FK240k54csbuahxpoamqbetvn7s` (`room_id`),
  KEY `FKf26lq84gj2cumeomuck24pkr8` (`user_id`),
  CONSTRAINT `FK240k54csbuahxpoamqbetvn7s` FOREIGN KEY (`room_id`) REFERENCES `tbl_room` (`id`),
  CONSTRAINT `FKf26lq84gj2cumeomuck24pkr8` FOREIGN KEY (`user_id`) REFERENCES `tbl_user` (`id`),
  CONSTRAINT `FKh5qqt34dhtarh7bu0kldu1djc` FOREIGN KEY (`message_type_id`) REFERENCES `tbl_message_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_message`
--

LOCK TABLES `tbl_message` WRITE;
/*!40000 ALTER TABLE `tbl_message` DISABLE KEYS */;
INSERT INTO `tbl_message` VALUES ('09dc4929-f1e6-470e-a218-52e46a7a5505','user đã chấp nhận lơi mời kết bạn','2024-06-02 17:40:30.405000','055b1a7d-e846-46b1-8816-505afb132226','f0f82b4f-70f4-4119-9d22-3e10eeeaf31a',NULL),('0c16a6f7-10de-4ff3-9897-1bcf6dc9b370','có gì không cậu','2024-06-02 18:13:06.377000','6cbaadb8-5a58-4c93-9a0f-2e55c1009c99','e8518c14-2828-4cda-9bf6-cf8d9b8912b4','2858dab1-4fe2-4ee6-87c0-84a597d42233'),('25f216c5-5988-4f90-9bbf-71ecc5a276cb','mai coffe học bài nhé','2024-06-02 18:14:42.094000','6cbaadb8-5a58-4c93-9a0f-2e55c1009c99','207aeebd-e872-41e9-b284-01ec2d52ca2e','2ae2e621-b81f-4035-aa2d-8d3280c288c5'),('28a62c5f-1b8b-4461-8d38-3a0f6c2ad781','nhi đã chấp nhận lơi mời kết bạn','2024-06-02 17:35:01.510000','055b1a7d-e846-46b1-8816-505afb132226','95a5e190-8250-4864-9e15-68c38e82c61a',NULL),('2ae22f3d-0a00-41aa-a3ef-948b4b8915fb','duyen đã chấp nhận lơi mời kết bạn','2024-06-02 17:43:41.856000','055b1a7d-e846-46b1-8816-505afb132226','5e9da4f6-b03b-4575-8e22-0958106dec14',NULL),('3093cb82-3e9b-4f46-8170-083c5df28c74','dong đã tham gia cuộc trò chuyện','2024-06-02 18:14:12.241000','82a30bb0-7bfd-4abf-9951-0cf975fe9304','207aeebd-e872-41e9-b284-01ec2d52ca2e','27630a2d-1ee2-4d4d-bd43-df16f8629de3'),('5bd621d5-3bc5-4b41-84d5-ef7d202458a8','user đã tạo cuộc trò chuyện','2024-06-02 18:14:12.236000','82a30bb0-7bfd-4abf-9951-0cf975fe9304','207aeebd-e872-41e9-b284-01ec2d52ca2e','2ae2e621-b81f-4035-aa2d-8d3280c288c5'),('7e2850e1-18d4-4db2-8576-63b12f7864d0','user đã chấp nhận lơi mời kết bạn','2024-06-02 17:38:33.104000','055b1a7d-e846-46b1-8816-505afb132226','e8518c14-2828-4cda-9bf6-cf8d9b8912b4',NULL),('c1eea4e3-02e7-4ba2-ab8a-ef1c0d911aa0','an đã chấp nhận lơi mời kết bạn','2024-06-02 17:07:57.719000','055b1a7d-e846-46b1-8816-505afb132226','a9ae6c80-daf9-486d-8272-afdb22c9c1ea',NULL),('c998b143-39f9-4822-8e60-0c711bfffa65','17','2024-06-02 18:12:19.138000','26989a4f-76fb-4db8-8b1a-ef038d9771b7','e8518c14-2828-4cda-9bf6-cf8d9b8912b4','2ae2e621-b81f-4035-aa2d-8d3280c288c5'),('cc201572-c4a8-4822-9aef-86313f9ddeb2','3','2024-06-02 18:12:08.634000','26989a4f-76fb-4db8-8b1a-ef038d9771b7','83d40126-ff76-427b-8398-73787ee49219','2ae2e621-b81f-4035-aa2d-8d3280c288c5'),('cd1ddca2-0b5e-4b70-bd30-faeca452cad5','user đã chấp nhận lơi mời kết bạn','2024-06-02 17:42:40.770000','055b1a7d-e846-46b1-8816-505afb132226','83d40126-ff76-427b-8398-73787ee49219',NULL),('ce4e710e-e121-484b-9ba8-1c84855de068','hi','2024-06-02 18:12:11.389000','6cbaadb8-5a58-4c93-9a0f-2e55c1009c99','83d40126-ff76-427b-8398-73787ee49219','2ae2e621-b81f-4035-aa2d-8d3280c288c5'),('d0ea5802-1db8-4a98-8cad-b6b373a2f7a3','okie luôn ','2024-06-02 18:15:29.431000','6cbaadb8-5a58-4c93-9a0f-2e55c1009c99','207aeebd-e872-41e9-b284-01ec2d52ca2e','27630a2d-1ee2-4d4d-bd43-df16f8629de3'),('f4e6fcdb-5603-429e-bb3b-ef6d1c4663e0','huyen đã tham gia cuộc trò chuyện','2024-06-02 18:14:12.247000','82a30bb0-7bfd-4abf-9951-0cf975fe9304','207aeebd-e872-41e9-b284-01ec2d52ca2e','8f92ac71-000f-4b7b-a44b-38d9a5600dcf');
/*!40000 ALTER TABLE `tbl_message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_message_type`
--

DROP TABLE IF EXISTS `tbl_message_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_message_type` (
  `id` varchar(36) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_message_type`
--

LOCK TABLES `tbl_message_type` WRITE;
/*!40000 ALTER TABLE `tbl_message_type` DISABLE KEYS */;
INSERT INTO `tbl_message_type` VALUES ('055b1a7d-e846-46b1-8816-505afb132226','004','is a notification','notification'),('26989a4f-76fb-4db8-8b1a-ef038d9771b7','007','sticker in conversation','sticker'),('5541fd6e-a420-453e-829f-1476336e9679','006','a message which is recalled by creator','recall'),('6cbaadb8-5a58-4c93-9a0f-2e55c1009c99','003','a common message in the conversation','chat'),('82a30bb0-7bfd-4abf-9951-0cf975fe9304','001','new user joined conversation','join'),('bf4368c0-c870-4683-8f61-95587c0500a6','002','an user had left the conversation','left');
/*!40000 ALTER TABLE `tbl_message_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_notification`
--

DROP TABLE IF EXISTS `tbl_notification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_notification` (
  `id` varchar(36) NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `create_date` datetime(6) DEFAULT NULL,
  `actor_id` varchar(36) DEFAULT NULL,
  `group_id` varchar(36) DEFAULT NULL,
  `notification_type_id` varchar(36) DEFAULT NULL,
  `owner_id` varchar(36) DEFAULT NULL,
  `post_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKtnutoxhcuvuwnutmvbtj71uhc` (`actor_id`),
  KEY `FK3h05r7o3p0wl513x8n6lkr7fk` (`group_id`),
  KEY `FKo883hbuutqe7i7mymjl8mqe98` (`notification_type_id`),
  KEY `FK20fm9lxgf4nel8uvqtxsg1h9n` (`owner_id`),
  KEY `FKsvgonotyaf3sscmeq5yryi1rc` (`post_id`),
  CONSTRAINT `FK20fm9lxgf4nel8uvqtxsg1h9n` FOREIGN KEY (`owner_id`) REFERENCES `tbl_user` (`id`),
  CONSTRAINT `FK3h05r7o3p0wl513x8n6lkr7fk` FOREIGN KEY (`group_id`) REFERENCES `tbl_group` (`id`),
  CONSTRAINT `FKo883hbuutqe7i7mymjl8mqe98` FOREIGN KEY (`notification_type_id`) REFERENCES `tbl_notification_type` (`id`),
  CONSTRAINT `FKsvgonotyaf3sscmeq5yryi1rc` FOREIGN KEY (`post_id`) REFERENCES `tbl_post` (`id`),
  CONSTRAINT `FKtnutoxhcuvuwnutmvbtj71uhc` FOREIGN KEY (`actor_id`) REFERENCES `tbl_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_notification`
--

LOCK TABLES `tbl_notification` WRITE;
/*!40000 ALTER TABLE `tbl_notification` DISABLE KEYS */;
INSERT INTO `tbl_notification` VALUES ('059b64b3-9d3a-438d-87e6-3415175639b7','user đã tạo một bài viết mới: Ghi chú thông minh, ôn tập đúng cách và luôn duy trì động lực - chìa khóa để học tập hiệu quả. Hãy để chúng tôi hướng dẫn bạn!','2024-06-02 18:02:52.373000','2ae2e621-b81f-4035-aa2d-8d3280c288c5',NULL,'9e646fa4-d804-41f1-9e1f-6df5000575a2','2858dab1-4fe2-4ee6-87c0-84a597d42233','301ef856-fb5d-47c2-8266-d76c6ae2745b'),('06ab93e2-8ff7-444c-9bec-d219fc55ad6e','nam đã gửi lời mời kết bạn','2024-06-02 18:10:24.151000','2a1fae2e-c56c-4c7c-b95d-235721fcd1ec',NULL,'29565507-dc9d-458b-9d57-a592ea117733','2ae2e621-b81f-4035-aa2d-8d3280c288c5',NULL),('092611e9-dc60-45ac-b279-a11d88390e0c','dong đã tạo một bài viết mới: #coffee','2024-06-02 17:53:07.021000','27630a2d-1ee2-4d4d-bd43-df16f8629de3',NULL,'9e646fa4-d804-41f1-9e1f-6df5000575a2','2ae2e621-b81f-4035-aa2d-8d3280c288c5','95e5ba14-c21b-47d8-b797-f2cb7dd711af'),('09c975fc-e438-4908-9b6c-912fd214646b','Yêu cầu tham gia nhóm Chia Sẻ Phương Pháp Học Tập đã được duyệt','2024-06-02 18:04:11.611000','2ae2e621-b81f-4035-aa2d-8d3280c288c5','2ada6fb9-3115-4e07-9be8-eb11c5ce671a','6696c9e0-bf5f-404e-b20c-9d6b4adceb63','86903379-c3f9-4139-8e63-f19f976b7152',NULL),('0a531dfa-40bf-4716-8acf-c477fe6d9957','user đã tạo một bài viết mới: Ghi chú thông minh, ôn tập đúng cách và luôn duy trì động lực - chìa khóa để học tập hiệu quả. Hãy để chúng tôi hướng dẫn bạn!','2024-06-02 18:02:52.278000','2ae2e621-b81f-4035-aa2d-8d3280c288c5',NULL,'9e646fa4-d804-41f1-9e1f-6df5000575a2','27630a2d-1ee2-4d4d-bd43-df16f8629de3','301ef856-fb5d-47c2-8266-d76c6ae2745b'),('0abeaa54-c8da-4961-8f7a-93047a8a1977','user đã tạo một bài viết mới: Ghi chú thông minh, ôn tập đúng cách và luôn duy trì động lực - chìa khóa để học tập hiệu quả. Hãy để chúng tôi hướng dẫn bạn!','2024-06-02 18:02:52.176000','2ae2e621-b81f-4035-aa2d-8d3280c288c5',NULL,'9e646fa4-d804-41f1-9e1f-6df5000575a2','18db5d5e-b0ca-40aa-a30a-77689ca15c81','301ef856-fb5d-47c2-8266-d76c6ae2745b'),('108bc82a-1e6e-4252-88f9-0b725bf876ef','user đã chấp nhận lời mời kết bạn','2024-06-02 17:38:33.099000','2ae2e621-b81f-4035-aa2d-8d3280c288c5',NULL,'29565507-dc9d-458b-9d57-a592ea117733','2858dab1-4fe2-4ee6-87c0-84a597d42233',NULL),('171ada21-51cb-4700-9a4b-dc2e103193c2','Yêu cầu tham gia nhóm Làm Việc Hiệu Quả đã được duyệt','2024-06-02 21:06:06.735000','6e3c4374-9f54-46c2-bb9a-49c16bd8db58','18115076-c413-4248-984e-bfaad22b542f','6696c9e0-bf5f-404e-b20c-9d6b4adceb63','2ae2e621-b81f-4035-aa2d-8d3280c288c5',NULL),('1c1d7e81-40f2-4856-8632-0e3db466bcdf','huyen đã gửi lời mời kết bạn','2024-06-02 17:42:32.359000','8f92ac71-000f-4b7b-a44b-38d9a5600dcf',NULL,'29565507-dc9d-458b-9d57-a592ea117733','2ae2e621-b81f-4035-aa2d-8d3280c288c5',NULL),('20e94b0b-f924-4dbf-b851-ff1438ff96fe','dong đã bình luận một bài đăng của bạn','2024-06-02 20:35:30.085000','27630a2d-1ee2-4d4d-bd43-df16f8629de3',NULL,'9e646fa4-d804-41f1-9e1f-6df5000575a2','2ae2e621-b81f-4035-aa2d-8d3280c288c5','21731018-f3d9-4505-8336-ab33f3cfe5f8'),('39e3ade2-1ce3-40a2-9415-e636499060da','nhi đã chấp nhận lời mời kết bạn','2024-06-02 17:35:01.506000','2858dab1-4fe2-4ee6-87c0-84a597d42233',NULL,'29565507-dc9d-458b-9d57-a592ea117733','18db5d5e-b0ca-40aa-a30a-77689ca15c81',NULL),('6da1fb62-e8ac-4aeb-ab45-48828aa99dc7','duyen đã chấp nhận lời mời kết bạn','2024-06-02 17:43:41.850000','b0a97e72-6dec-4e2d-82a7-679339ccbd00',NULL,'29565507-dc9d-458b-9d57-a592ea117733','8f92ac71-000f-4b7b-a44b-38d9a5600dcf',NULL),('6faae266-dfe7-45b1-a220-22684ae2196b','user đã thích bài viết của bạn','2024-06-02 18:10:58.036000','2ae2e621-b81f-4035-aa2d-8d3280c288c5',NULL,'9e646fa4-d804-41f1-9e1f-6df5000575a2','2858dab1-4fe2-4ee6-87c0-84a597d42233','2a89bcd3-4c78-4275-96f8-2940ef7f8e96'),('71ef2d0d-ecf8-42c6-bff8-f428f241372a','nhi đã gửi lời mời kết bạn','2024-06-02 17:38:14.444000','2858dab1-4fe2-4ee6-87c0-84a597d42233',NULL,'29565507-dc9d-458b-9d57-a592ea117733','2ae2e621-b81f-4035-aa2d-8d3280c288c5',NULL),('73c1e158-eef1-43c5-b53c-629fded1efdd','nam đã thích bài viết của bạn','2024-06-02 18:11:29.852000','2a1fae2e-c56c-4c7c-b95d-235721fcd1ec',NULL,'9e646fa4-d804-41f1-9e1f-6df5000575a2','2ae2e621-b81f-4035-aa2d-8d3280c288c5','21731018-f3d9-4505-8336-ab33f3cfe5f8'),('74923db6-5844-4262-91e3-d05724dd745b','user đã chấp nhận lời mời kết bạn','2024-06-02 17:42:40.765000','2ae2e621-b81f-4035-aa2d-8d3280c288c5',NULL,'29565507-dc9d-458b-9d57-a592ea117733','8f92ac71-000f-4b7b-a44b-38d9a5600dcf',NULL),('761661ef-bcba-4d62-b2d5-9d03a46e1944','dong đã gửi lời mời kết bạn','2024-06-02 17:40:06.081000','27630a2d-1ee2-4d4d-bd43-df16f8629de3',NULL,'29565507-dc9d-458b-9d57-a592ea117733','2ae2e621-b81f-4035-aa2d-8d3280c288c5',NULL),('765ccfdd-775b-4d43-a831-07bc340593ca','huyen đã gửi lời mời kết bạn','2024-06-02 17:43:21.398000','8f92ac71-000f-4b7b-a44b-38d9a5600dcf',NULL,'29565507-dc9d-458b-9d57-a592ea117733','b0a97e72-6dec-4e2d-82a7-679339ccbd00',NULL),('7f242cb2-3f4a-4fed-ad6e-8a12578ea58f','an đã chấp nhận lời mời kết bạn','2024-06-02 17:07:57.706000','18db5d5e-b0ca-40aa-a30a-77689ca15c81',NULL,'29565507-dc9d-458b-9d57-a592ea117733','2ae2e621-b81f-4035-aa2d-8d3280c288c5',NULL),('83fb4484-891d-4721-84cb-68bd96940337','duyen đã gửi lời mời kết bạn','2024-06-02 17:44:01.362000','b0a97e72-6dec-4e2d-82a7-679339ccbd00',NULL,'29565507-dc9d-458b-9d57-a592ea117733','2ae2e621-b81f-4035-aa2d-8d3280c288c5',NULL),('8ac2bea5-d8a1-475a-8a90-d5a2801b3e3e','Yêu cầu tham gia nhóm Làm Việc Hiệu Quả đã được duyệt','2024-06-02 18:21:31.272000','6e3c4374-9f54-46c2-bb9a-49c16bd8db58','18115076-c413-4248-984e-bfaad22b542f','6696c9e0-bf5f-404e-b20c-9d6b4adceb63','27630a2d-1ee2-4d4d-bd43-df16f8629de3',NULL),('95db84d0-d013-40c1-82bd-e7a0b0810442','user đã chấp nhận lời mời kết bạn','2024-06-02 17:40:30.400000','2ae2e621-b81f-4035-aa2d-8d3280c288c5',NULL,'29565507-dc9d-458b-9d57-a592ea117733','27630a2d-1ee2-4d4d-bd43-df16f8629de3',NULL),('a2aedeb0-7b2c-47b9-b95e-1254154acea2','user đã gửi lời mời kết bạn','2024-06-02 17:07:24.247000','2ae2e621-b81f-4035-aa2d-8d3280c288c5',NULL,'29565507-dc9d-458b-9d57-a592ea117733','18db5d5e-b0ca-40aa-a30a-77689ca15c81',NULL),('a6d3babe-d7a3-4ba2-acee-87675667be54','user đã trả lời bình luận của bạn trong một bài viết','2024-06-02 20:36:25.365000',NULL,NULL,'9e646fa4-d804-41f1-9e1f-6df5000575a2','27630a2d-1ee2-4d4d-bd43-df16f8629de3','21731018-f3d9-4505-8336-ab33f3cfe5f8'),('a74df159-d00b-4bbf-8aa3-3d93132115df','an đã gửi lời mời kết bạn','2024-06-02 17:34:23.717000','18db5d5e-b0ca-40aa-a30a-77689ca15c81',NULL,'29565507-dc9d-458b-9d57-a592ea117733','2858dab1-4fe2-4ee6-87c0-84a597d42233',NULL),('ade981d5-fb1f-4a74-88c5-f3f96560b972','huyen đã gửi lời mời kết bạn','2024-06-02 17:42:57.722000','8f92ac71-000f-4b7b-a44b-38d9a5600dcf',NULL,'29565507-dc9d-458b-9d57-a592ea117733','2858dab1-4fe2-4ee6-87c0-84a597d42233',NULL),('aff73b79-9c57-4fb6-a495-b7e6401f45d3','an đã gửi lời mời kết bạn','2024-06-02 17:34:30.772000','18db5d5e-b0ca-40aa-a30a-77689ca15c81',NULL,'29565507-dc9d-458b-9d57-a592ea117733','27630a2d-1ee2-4d4d-bd43-df16f8629de3',NULL),('b2a2af52-aacc-4ee6-8dc1-01208ab4e246','nhi đã gửi lời mời kết bạn','2024-06-02 17:38:19.001000','2858dab1-4fe2-4ee6-87c0-84a597d42233',NULL,'29565507-dc9d-458b-9d57-a592ea117733','27630a2d-1ee2-4d4d-bd43-df16f8629de3',NULL),('b8c02981-be0a-4264-8234-f2b9f7b2f101','dong đã tạo một bài viết mới: Tạo ra môi trường làm việc lý tưởng và nâng cao năng suất mỗi ngày. Đừng bỏ lỡ những bí quyết làm việc hiệu quả này!','2024-06-02 18:19:36.306000','27630a2d-1ee2-4d4d-bd43-df16f8629de3',NULL,'9e646fa4-d804-41f1-9e1f-6df5000575a2','2ae2e621-b81f-4035-aa2d-8d3280c288c5','adf1e970-4e5e-4b37-9146-6e276d5e6ee3'),('d14c0338-04e6-4a27-b359-726d3965cfd5','user và 1 người khác đã thích bài viết của bạn: #coffee','2024-06-03 14:48:27.761000','2ae2e621-b81f-4035-aa2d-8d3280c288c5',NULL,'9e646fa4-d804-41f1-9e1f-6df5000575a2','27630a2d-1ee2-4d4d-bd43-df16f8629de3','95e5ba14-c21b-47d8-b797-f2cb7dd711af'),('e02b65b3-f5a1-47d3-88b5-244158ee8303','nhi đã gửi lời mời kết bạn','2024-06-02 17:38:24.307000','2858dab1-4fe2-4ee6-87c0-84a597d42233',NULL,'29565507-dc9d-458b-9d57-a592ea117733','6e33737a-1793-45fa-90aa-200a81aa040f',NULL),('f39a8955-37b5-46df-addb-5b8fbcb94dfd','user đã tạo một bài viết mới: Ghi chú thông minh, ôn tập đúng cách và luôn duy trì động lực - chìa khóa để học tập hiệu quả. Hãy để chúng tôi hướng dẫn bạn!','2024-06-02 18:02:52.493000','2ae2e621-b81f-4035-aa2d-8d3280c288c5',NULL,'9e646fa4-d804-41f1-9e1f-6df5000575a2','8f92ac71-000f-4b7b-a44b-38d9a5600dcf','301ef856-fb5d-47c2-8266-d76c6ae2745b'),('fc90dbaa-857a-4160-b3ad-370f3b07fe4c','user đã thích bài viết của bạn','2024-06-02 18:10:55.069000','2ae2e621-b81f-4035-aa2d-8d3280c288c5',NULL,'9e646fa4-d804-41f1-9e1f-6df5000575a2','8f92ac71-000f-4b7b-a44b-38d9a5600dcf','99898889-d3e6-4aa5-a319-7b9218d13d10');
/*!40000 ALTER TABLE `tbl_notification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_notification_type`
--

DROP TABLE IF EXISTS `tbl_notification_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_notification_type` (
  `id` varchar(36) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_notification_type`
--

LOCK TABLES `tbl_notification_type` WRITE;
/*!40000 ALTER TABLE `tbl_notification_type` DISABLE KEYS */;
INSERT INTO `tbl_notification_type` VALUES ('29565507-dc9d-458b-9d57-a592ea117733','002','add friend, accept friend','Friend'),('6696c9e0-bf5f-404e-b20c-9d6b4adceb63','003','approve request, update background group','Group'),('79f2af85-4c65-4412-8bbf-5412a7a41ff9','004','alert when a message is sent to a conversation that user joined in','Chat'),('9e646fa4-d804-41f1-9e1f-6df5000575a2','001','Tym, Comment, Reply Comment','Post');
/*!40000 ALTER TABLE `tbl_notification_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_post`
--

DROP TABLE IF EXISTS `tbl_post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_post` (
  `id` varchar(36) NOT NULL,
  `content` longtext,
  `create_date` datetime(6) DEFAULT NULL,
  `group_id` varchar(36) DEFAULT NULL,
  `owner_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKs2qqevi91xvk06kuqoh3wdewx` (`group_id`),
  KEY `FKedkvwvb2g5twqwk1b1njcodbb` (`owner_id`),
  CONSTRAINT `FKedkvwvb2g5twqwk1b1njcodbb` FOREIGN KEY (`owner_id`) REFERENCES `tbl_user` (`id`),
  CONSTRAINT `FKs2qqevi91xvk06kuqoh3wdewx` FOREIGN KEY (`group_id`) REFERENCES `tbl_group` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_post`
--

LOCK TABLES `tbl_post` WRITE;
/*!40000 ALTER TABLE `tbl_post` DISABLE KEYS */;
INSERT INTO `tbl_post` VALUES ('21731018-f3d9-4505-8336-ab33f3cfe5f8','Để học tập hiệu quả, trước tiên bạn cần xây dựng một kế hoạch học tập chi tiết và thực tế. Hãy chia nhỏ khối lượng kiến thức cần học thành các phần nhỏ và đặt ra các mục tiêu ngắn hạn để dễ dàng theo dõi tiến bộ. Sử dụng các phương pháp học tập như ghi chú theo kiểu Cornell, sơ đồ tư duy hoặc flashcards để ghi nhớ thông tin một cách hiệu quả hơn. Ngoài ra, việc thường xuyên đánh giá lại kiến thức đã học và thực hành thông qua các bài tập, đề thi mẫu cũng rất quan trọng để củng cố kiến thức và chuẩn bị tốt cho các kỳ thi. Đừng quên dành thời gian nghỉ ngơi và giữ gìn sức khỏe để duy trì năng lượng và tinh thần học tập tốt nhất','2024-06-02 17:53:57.192000',NULL,'2ae2e621-b81f-4035-aa2d-8d3280c288c5'),('2a89bcd3-4c78-4275-96f8-2940ef7f8e96','Quản lý thời gian hiệu quả là chìa khóa để đạt được sự cân bằng trong cuộc sống và công việc. Đầu tiên, bạn cần xác định các mục tiêu rõ ràng và cụ thể, sau đó lập kế hoạch chi tiết để thực hiện chúng. Sử dụng các công cụ như lịch Google, ứng dụng nhắc việc hoặc phương pháp bullet journal có thể giúp bạn theo dõi tiến độ công việc và không bỏ sót bất kỳ nhiệm vụ quan trọng nào. Hơn nữa, việc học cách từ chối những công việc không quan trọng và tập trung vào những gì thực sự cần thiết sẽ giúp bạn sử dụng thời gian một cách thông minh và hiệu quả.','2024-06-02 17:36:40.056000',NULL,'2858dab1-4fe2-4ee6-87c0-84a597d42233'),('301ef856-fb5d-47c2-8266-d76c6ae2745b','Ghi chú thông minh, ôn tập đúng cách và luôn duy trì động lực - chìa khóa để học tập hiệu quả. Hãy để chúng tôi hướng dẫn bạn!','2024-06-02 18:02:51.081000','2ada6fb9-3115-4e07-9be8-eb11c5ce671a','2ae2e621-b81f-4035-aa2d-8d3280c288c5'),('6184f4d8-1498-454d-ae9b-63c43ab126f6','Biến mỗi ngày làm việc thành một ngày thành công với những chiến lược quản lý thời gian thông minh. Đừng bỏ lỡ!','2024-06-02 18:17:33.640000','18115076-c413-4248-984e-bfaad22b542f','6e3c4374-9f54-46c2-bb9a-49c16bd8db58'),('95e5ba14-c21b-47d8-b797-f2cb7dd711af','#coffee','2024-06-02 17:53:06.587000',NULL,'27630a2d-1ee2-4d4d-bd43-df16f8629de3'),('99898889-d3e6-4aa5-a319-7b9218d13d10','Việc phân chia thời gian hợp lý giữa các hoạt động giúp bạn tránh được tình trạng quá tải và căng thẳng. Hãy dành thời gian cho những nhiệm vụ quan trọng nhất vào lúc bạn cảm thấy năng lượng dồi dào nhất trong ngày. Bên cạnh đó, việc lên kế hoạch cho những khoảng thời gian nghỉ ngơi ngắn cũng rất cần thiết để duy trì sự tỉnh táo và sáng tạo.','2024-06-02 17:48:55.256000',NULL,'8f92ac71-000f-4b7b-a44b-38d9a5600dcf'),('a6b8cd17-09ff-4d26-bfe9-feaa7f8546db','Trong môi trường làm việc hiện đại, khả năng làm việc hiệu quả là một yếu tố quan trọng quyết định sự thành công. Điều này đòi hỏi sự tập trung cao độ, kỹ năng quản lý thời gian và khả năng làm việc nhóm. Một trong những cách để nâng cao hiệu quả công việc là sử dụng các công cụ và kỹ thuật như phương pháp Pomodoro, ưu tiên công việc theo ma trận Eisenhower và duy trì môi trường làm việc gọn gàng, ngăn nắp. Ngoài ra, việc thường xuyên cập nhật kiến thức và kỹ năng chuyên môn cũng giúp bạn luôn sẵn sàng đối mặt với những thách thức mới trong công việc.','2024-06-02 18:10:02.555000',NULL,'2a1fae2e-c56c-4c7c-b95d-235721fcd1ec'),('adf1e970-4e5e-4b37-9146-6e276d5e6ee3','Tạo ra môi trường làm việc lý tưởng và nâng cao năng suất mỗi ngày. Đừng bỏ lỡ những bí quyết làm việc hiệu quả này!','2024-06-02 18:19:33.027000','18115076-c413-4248-984e-bfaad22b542f','27630a2d-1ee2-4d4d-bd43-df16f8629de3'),('d50846dc-4df7-4976-aee7-c5e695f3b7f3','Ghi chú thông minh, ôn tập đúng cách và luôn duy trì động lực - chìa khóa để học tập hiệu quả. Hãy để chúng tôi hướng dẫn bạn!','2024-06-02 18:04:47.171000','2ada6fb9-3115-4e07-9be8-eb11c5ce671a','86903379-c3f9-4139-8e63-f19f976b7152');
/*!40000 ALTER TABLE `tbl_post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_post_image`
--

DROP TABLE IF EXISTS `tbl_post_image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_post_image` (
  `id` varchar(36) NOT NULL,
  `create_date` datetime(6) DEFAULT NULL,
  `description` longtext,
  `image` varchar(255) DEFAULT NULL,
  `post_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgu0k1ycm57rgt76r10atw8f8i` (`post_id`),
  CONSTRAINT `FKgu0k1ycm57rgt76r10atw8f8i` FOREIGN KEY (`post_id`) REFERENCES `tbl_post` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_post_image`
--

LOCK TABLES `tbl_post_image` WRITE;
/*!40000 ALTER TABLE `tbl_post_image` DISABLE KEYS */;
INSERT INTO `tbl_post_image` VALUES ('07e6a1d9-6b68-427e-8142-9334c6ac6b10','2024-06-02 17:53:06.698000',NULL,'https://images.pexels.com/photos/17864141/pexels-photo-17864141/free-photo-of-cup-of-cappuccino-and-plant.jpeg?auto=compress&cs=tinysrgb&w=600','95e5ba14-c21b-47d8-b797-f2cb7dd711af'),('12277447-319d-40bd-a56e-301911f61f13','2024-06-02 17:48:55.298000',NULL,'https://images.pexels.com/photos/6005007/pexels-photo-6005007.jpeg?auto=compress&cs=tinysrgb&w=600','99898889-d3e6-4aa5-a319-7b9218d13d10'),('792e42af-71fe-4fbb-9480-9ed21223e1c2','2024-06-02 17:53:06.660000',NULL,'https://images.pexels.com/photos/12255407/pexels-photo-12255407.jpeg?auto=compress&cs=tinysrgb&w=600','95e5ba14-c21b-47d8-b797-f2cb7dd711af'),('7c86f79e-31a0-4c0a-8ec1-d77294d9aced','2024-06-02 17:53:06.733000',NULL,'https://images.pexels.com/photos/4109850/pexels-photo-4109850.jpeg?auto=compress&cs=tinysrgb&w=600','95e5ba14-c21b-47d8-b797-f2cb7dd711af'),('df327d61-680d-4ee0-8f3e-82fe488851be','2024-06-02 18:19:33.417000',NULL,'https://images.pexels.com/photos/1925536/pexels-photo-1925536.jpeg?auto=compress&cs=tinysrgb&w=600','adf1e970-4e5e-4b37-9146-6e276d5e6ee3'),('f9059e08-8559-4383-a1bb-dd01aae72937','2024-06-02 17:53:06.624000',NULL,'https://images.pexels.com/photos/5942726/pexels-photo-5942726.jpeg?auto=compress&cs=tinysrgb&w=600','95e5ba14-c21b-47d8-b797-f2cb7dd711af'),('fc2078b1-92da-46bf-98e8-f84a057a9ffa','2024-06-02 17:53:06.771000',NULL,'https://images.pexels.com/photos/15529295/pexels-photo-15529295/free-photo-of-roll-cake-and-coffee.jpeg?auto=compress&cs=tinysrgb&w=600','95e5ba14-c21b-47d8-b797-f2cb7dd711af');
/*!40000 ALTER TABLE `tbl_post_image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_relationship`
--

DROP TABLE IF EXISTS `tbl_relationship`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_relationship` (
  `id` varchar(36) NOT NULL,
  `last_modify_date` datetime(6) DEFAULT NULL,
  `state` bit(1) DEFAULT NULL,
  `receiver_id` varchar(36) DEFAULT NULL,
  `request_sender_id` varchar(36) DEFAULT NULL,
  `room_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_49gg059iuvl4whxf9bsu9qcq` (`room_id`),
  KEY `FKrch0rp9xas57h3mj5n2yop6u0` (`receiver_id`),
  KEY `FKi7dueabocxgur7oul8h4uwdp3` (`request_sender_id`),
  CONSTRAINT `FK50roryatoju1jr84t52yg5ohv` FOREIGN KEY (`room_id`) REFERENCES `tbl_room` (`id`),
  CONSTRAINT `FKi7dueabocxgur7oul8h4uwdp3` FOREIGN KEY (`request_sender_id`) REFERENCES `tbl_user` (`id`),
  CONSTRAINT `FKrch0rp9xas57h3mj5n2yop6u0` FOREIGN KEY (`receiver_id`) REFERENCES `tbl_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_relationship`
--

LOCK TABLES `tbl_relationship` WRITE;
/*!40000 ALTER TABLE `tbl_relationship` DISABLE KEYS */;
INSERT INTO `tbl_relationship` VALUES ('16268bf2-f2d6-49fe-a6bb-cc0ee8510458','2024-06-02 18:10:24.056000',_binary '\0','2ae2e621-b81f-4035-aa2d-8d3280c288c5','2a1fae2e-c56c-4c7c-b95d-235721fcd1ec',NULL),('28983d2a-a5af-4c7e-a196-2ead43a70bde','2024-06-02 17:44:01.315000',_binary '\0','2ae2e621-b81f-4035-aa2d-8d3280c288c5','b0a97e72-6dec-4e2d-82a7-679339ccbd00',NULL),('3e796893-ac48-4b31-8e4b-adf2eee0939e','2024-06-02 17:40:06.041000',_binary '','2ae2e621-b81f-4035-aa2d-8d3280c288c5','27630a2d-1ee2-4d4d-bd43-df16f8629de3','f0f82b4f-70f4-4119-9d22-3e10eeeaf31a'),('53650695-a5e2-4eb5-92be-a2a3e8e6b5c6','2024-06-02 17:42:57.669000',_binary '\0','2858dab1-4fe2-4ee6-87c0-84a597d42233','8f92ac71-000f-4b7b-a44b-38d9a5600dcf',NULL),('5573c488-08d1-4f61-9e22-2b0788badf88','2024-06-02 17:07:24.225000',_binary '','18db5d5e-b0ca-40aa-a30a-77689ca15c81','2ae2e621-b81f-4035-aa2d-8d3280c288c5','a9ae6c80-daf9-486d-8272-afdb22c9c1ea'),('58fb5978-2bd4-41b4-8ecc-068fd26ee117','2024-06-02 17:34:30.744000',_binary '\0','27630a2d-1ee2-4d4d-bd43-df16f8629de3','18db5d5e-b0ca-40aa-a30a-77689ca15c81',NULL),('6d266045-c9f5-49b6-9030-33dbf7338ca7','2024-06-02 17:38:24.272000',_binary '\0','6e33737a-1793-45fa-90aa-200a81aa040f','2858dab1-4fe2-4ee6-87c0-84a597d42233',NULL),('6e410a55-8feb-4beb-aa06-33021bc22b6d','2024-06-02 17:38:18.938000',_binary '\0','27630a2d-1ee2-4d4d-bd43-df16f8629de3','2858dab1-4fe2-4ee6-87c0-84a597d42233',NULL),('6ee8c857-81fd-4f57-b770-767d456b16c9','2024-06-02 17:43:21.316000',_binary '','b0a97e72-6dec-4e2d-82a7-679339ccbd00','8f92ac71-000f-4b7b-a44b-38d9a5600dcf','5e9da4f6-b03b-4575-8e22-0958106dec14'),('7f6f64c2-1c2b-4248-935a-f6d7d26a80b9','2024-06-02 17:38:14.412000',_binary '','2ae2e621-b81f-4035-aa2d-8d3280c288c5','2858dab1-4fe2-4ee6-87c0-84a597d42233','e8518c14-2828-4cda-9bf6-cf8d9b8912b4'),('91ccefd5-8c5d-434a-a2ed-c6613826f219','2024-06-02 17:42:32.309000',_binary '','2ae2e621-b81f-4035-aa2d-8d3280c288c5','8f92ac71-000f-4b7b-a44b-38d9a5600dcf','83d40126-ff76-427b-8398-73787ee49219'),('92f925cf-4d99-4dc4-9b0e-a7046bc99895','2024-06-02 17:34:23.691000',_binary '','2858dab1-4fe2-4ee6-87c0-84a597d42233','18db5d5e-b0ca-40aa-a30a-77689ca15c81','95a5e190-8250-4864-9e15-68c38e82c61a');
/*!40000 ALTER TABLE `tbl_relationship` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_room`
--

DROP TABLE IF EXISTS `tbl_room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_room` (
  `id` varchar(36) NOT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `create_date` datetime(6) DEFAULT NULL,
  `description` longtext,
  `name` longtext,
  `room_type_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsq26n7x09891tujjx47klp3jk` (`room_type_id`),
  CONSTRAINT `FKsq26n7x09891tujjx47klp3jk` FOREIGN KEY (`room_type_id`) REFERENCES `tbl_room_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_room`
--

LOCK TABLES `tbl_room` WRITE;
/*!40000 ALTER TABLE `tbl_room` DISABLE KEYS */;
INSERT INTO `tbl_room` VALUES ('207aeebd-e872-41e9-b284-01ec2d52ca2e',NULL,NULL,NULL,NULL,NULL,'Hội Bạn Thân','5a829c7c-3b4f-4848-80bf-9503db80779b'),('5e9da4f6-b03b-4575-8e22-0958106dec14',NULL,NULL,NULL,'2024-06-02 17:43:41.774000',NULL,NULL,'477d9400-17b0-4b6c-884d-e7d001c3c642'),('83d40126-ff76-427b-8398-73787ee49219',NULL,NULL,NULL,'2024-06-02 17:42:40.694000',NULL,NULL,'477d9400-17b0-4b6c-884d-e7d001c3c642'),('95a5e190-8250-4864-9e15-68c38e82c61a',NULL,NULL,NULL,'2024-06-02 17:35:01.473000',NULL,NULL,'477d9400-17b0-4b6c-884d-e7d001c3c642'),('a9ae6c80-daf9-486d-8272-afdb22c9c1ea',NULL,NULL,NULL,'2024-06-02 17:07:57.672000',NULL,NULL,'477d9400-17b0-4b6c-884d-e7d001c3c642'),('e8518c14-2828-4cda-9bf6-cf8d9b8912b4',NULL,NULL,NULL,'2024-06-02 17:38:33.046000',NULL,NULL,'477d9400-17b0-4b6c-884d-e7d001c3c642'),('f0f82b4f-70f4-4119-9d22-3e10eeeaf31a',NULL,NULL,NULL,'2024-06-02 17:40:30.345000',NULL,NULL,'477d9400-17b0-4b6c-884d-e7d001c3c642');
/*!40000 ALTER TABLE `tbl_room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_room_type`
--

DROP TABLE IF EXISTS `tbl_room_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_room_type` (
  `id` varchar(36) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_room_type`
--

LOCK TABLES `tbl_room_type` WRITE;
/*!40000 ALTER TABLE `tbl_room_type` DISABLE KEYS */;
INSERT INTO `tbl_room_type` VALUES ('3b40145a-579d-4b2f-950b-aceb2f102fe4','002','public room is for multiple people chatting','public'),('477d9400-17b0-4b6c-884d-e7d001c3c642','001','private room is for 2 people chatting','private'),('5a829c7c-3b4f-4848-80bf-9503db80779b','003','is private room chat for at least 3 people','group');
/*!40000 ALTER TABLE `tbl_room_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_user`
--

DROP TABLE IF EXISTS `tbl_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_user` (
  `id` varchar(36) NOT NULL,
  `address` longtext,
  `avatar` varchar(255) DEFAULT NULL,
  `background` varchar(255) DEFAULT NULL,
  `birth_date` datetime(6) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `disable` bit(1) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `gender` bit(1) NOT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  `class_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_k0bty7tbcye41jpxam88q5kj2` (`username`),
  UNIQUE KEY `UK_npn1wf1yu1g5rjohbek375pp1` (`email`),
  KEY `FK5bpy3av6hhtfq7opnyx1qr124` (`class_id`),
  CONSTRAINT `FK5bpy3av6hhtfq7opnyx1qr124` FOREIGN KEY (`class_id`) REFERENCES `tbl_class` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_user`
--

LOCK TABLES `tbl_user` WRITE;
/*!40000 ALTER TABLE `tbl_user` DISABLE KEYS */;
INSERT INTO `tbl_user` VALUES ('0de3a80c-b081-4ed1-b226-959eac2ba890','Hà Nội','https://images.pexels.com/photos/11725367/pexels-photo-11725367.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load',NULL,NULL,'2021563214',_binary '\0','quan@gmail.com','Quân',_binary '','Minh','$2a$10$lJdsPwu7ehkBRN/snznKted4z6TrtSiRzvYKTv6K7ZzGivmpCi.FO','0569123624','USER','quan',NULL),('18db5d5e-b0ca-40aa-a30a-77689ca15c81','Hà Nội','https://images.pexels.com/photos/17392875/pexels-photo-17392875/free-photo-of-young-woman-in-a-dress-walking-in-the-garden.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load',NULL,NULL,'2021746813',_binary '\0','hoangan@gmail.com','An',_binary '\0','Nguyễn Hoàng','$2a$10$7GFCo5AMpWVHa.zKafSR4OdmbMJB1LCaZtySyempfPUeJOggs9qAa','0349123654','USER','an',NULL),('27630a2d-1ee2-4d4d-bd43-df16f8629de3','Hồ Chí Minh','https://images.pexels.com/photos/91224/pexels-photo-91224.jpeg?auto=compress&cs=tinysrgb&w=600',NULL,NULL,'20216615229',_binary '\0','dong@gmail.com','Đông',_binary '','Trần','$2a$10$19ucu1LcEwNOlPJ.2VHROO9ZzIalBbNTFbHQhFn9xBldKaBEqh/Xa','0243523678','USER','dong',NULL),('2858dab1-4fe2-4ee6-87c0-84a597d42233','Hà Nội','https://images.pexels.com/photos/1391498/pexels-photo-1391498.jpeg?auto=compress&cs=tinysrgb&w=600',NULL,NULL,'2021655367',_binary '\0','nhi@gmail.com','Nhi',_binary '\0','Quế','$2a$10$wyH78c.4t.Eey13AVVkJjuguDHssSHB4TpOS2Y.kEi6W6OZQyFgeW','0543563697','USER','nhi',NULL),('2a1fae2e-c56c-4c7c-b95d-235721fcd1ec','Hà Nội','https://images.pexels.com/photos/303159/pexels-photo-303159.jpeg?auto=compress&cs=tinysrgb&w=600',NULL,NULL,'2021455167',_binary '\0','nam@gmail.com','Nam',_binary '','Thành','$2a$10$Ng54yEztLPX28OsqQZeQWeRhPOdAKPe.FyuKYzj66Fp/nFYBuxYvq','0443563687','USER','nam',NULL),('2ae2e621-b81f-4035-aa2d-8d3280c288c5','Hà Nội','https://images.pexels.com/photos/457446/pexels-photo-457446.jpeg?auto=compress&cs=tinysrgb&w=600',NULL,'2003-11-04 00:00:00.000000','2021546877',_binary '\0','thanhthuan@gmail.com','Thuận',_binary '','Nguyễn Thành','$2a$10$qBmRDOW9Zlo6OWUhfdxZvOO.Oqa1UyagOjAZenzKuFI0m8c.Jkm7W','0123456789','USER','user','b6c8fff9-843f-457e-8c92-8de104009cb8'),('425de6bd-d753-4018-ae17-ef60899a5d83','Hà Nội','https://images.pexels.com/photos/460031/pexels-photo-460031.jpeg?auto=compress&cs=tinysrgb&w=600',NULL,NULL,'2021755562',_binary '\0','khoi@gmail.com','Khôi',_binary '','Trần','$2a$10$XMcbq0sCZzSJaM5p395TYuWYighctEY0eO8Mlqf7ZGbv7fIiqWWui','0353563667','USER','khoi',NULL),('494472fd-7efe-4f16-aac2-5f4b9ddbb858','Hồ Chí Minh','https://images.pexels.com/photos/8443648/pexels-photo-8443648.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load',NULL,NULL,'20215613267',_binary '\0','duy@gmail.com','Duy',_binary '','Nguyễn','$2a$10$/jyjQvsenl7t0OiYeAYf8.TfxGk9MsaCw48mWUjX8vtonp6er62ym','0339223674','USER','duy',NULL),('6e33737a-1793-45fa-90aa-200a81aa040f','Hồ Chí Minh','https://images.pexels.com/photos/3866555/pexels-photo-3866555.png?auto=compress&cs=tinysrgb&w=600',NULL,NULL,'20216615229',_binary '\0','thuy@gmail.com','Thuý',_binary '\0','Lê','$2a$10$ZCVVH.4P6eBPVIag1vP5.eYalHZIcRi1nY4IsY3wDUzLoQn.Kiw/a','0543523639','USER','thuy',NULL),('6e3c4374-9f54-46c2-bb9a-49c16bd8db58','Hà Nội','https://images.pexels.com/photos/792385/pexels-photo-792385.jpeg?auto=compress&cs=tinysrgb&w=600',NULL,NULL,'2021456564',_binary '\0','tan@gmail.com','Tân',_binary '','Duy','$2a$10$sxvM2pr7xDZ9HNWmhpea/OSI3b.g/33wN.E/kwJbJCAxoVjtBN4z6','0363573360','USER','tan',NULL),('8194a9b3-8928-4e71-bcd5-8c9e097477a2','Đà Nẵng','https://images.pexels.com/photos/23531767/pexels-photo-23531767/free-photo-of-a-man-in-a-black-coat-standing-on-a-bridge.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load',NULL,NULL,'20218613223',_binary '\0','bao@gmail.com','Bảo',_binary '','Duy','$2a$10$3e2TSGbWO/WKQEoSZ/MnBe1uEAhp//8w4eE9/1q2yGFXVAB6WLMtm','0643523636','USER','bao',NULL),('86903379-c3f9-4139-8e63-f19f976b7152','Đà Nẵng','https://images.pexels.com/photos/25019975/pexels-photo-25019975/free-photo-of-a-woman-in-glasses-and-a-floral-shirt-is-standing-near-a-bridge.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load',NULL,NULL,'2021563214',_binary '\0','vi@gmail.com','Vy',_binary '\0','Đông','$2a$10$FBbx7dT/Q0XkCZVt7vxfaurVRINpYEgicj8cTt64BQslTf0cDeDwe','0329223622','USER','vi',NULL),('8f92ac71-000f-4b7b-a44b-38d9a5600dcf','Hồ Chí Minh','https://images.pexels.com/photos/18287752/pexels-photo-18287752/free-photo-of-person-with-smartphone-by-window.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load',NULL,NULL,'2021563214',_binary '\0','huyen@gmail.com','Huyền',_binary '\0','Thanh','$2a$10$D3BJ3MLf7mMzJtjqZioc/eJGVXoPSYlc61Y81WI0j8V8ypCYYzAHS','0429223624','USER','huyen',NULL),('b0a97e72-6dec-4e2d-82a7-679339ccbd00','Đà Nẵng','https://images.pexels.com/photos/12882769/pexels-photo-12882769.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load',NULL,NULL,'20215613267',_binary '\0','duyen@gmail.com','Duyên',_binary '\0','Hà','$2a$10$W9ALdzEwXOe4lRg3LqDnBeZMRG8vwTr8W1JgpR5ewv/QK1yCz7sY.','0349523634','USER','duyen',NULL),('b40391f8-ef74-43a9-9af5-b7c58063142c','Hà Nội','https://images.pexels.com/photos/371160/pexels-photo-371160.jpeg?auto=compress&cs=tinysrgb&w=600',NULL,NULL,'2021452138',_binary '\0','trang@gmail.com','Trang',_binary '\0','Minh','$2a$10$gvX0vl/ZZdq5BTx38qy7K.Sl3uG1hIOoXA9sNLOMgMLA8u98EzUE2','0343563686','USER','trang',NULL),('cf869aac-c8db-497a-87b0-52b4001177de',NULL,NULL,NULL,NULL,NULL,_binary '\0',NULL,NULL,_binary '\0',NULL,'$2a$10$5rgN5pUuHdUVTvZ3/Hs2jOIEgiWJ7r1exyKhnb10ofV0JZQXKlYpy',NULL,'ADMIN','admin',NULL);
/*!40000 ALTER TABLE `tbl_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_user_course`
--

DROP TABLE IF EXISTS `tbl_user_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_user_course` (
  `id` varchar(36) NOT NULL,
  `is_validated` bit(1) DEFAULT NULL,
  `modify_date` datetime(6) DEFAULT NULL,
  `score` double DEFAULT NULL,
  `course_id` varchar(36) DEFAULT NULL,
  `course_result_id` varchar(36) DEFAULT NULL,
  `user_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKr4ad0llrc7jrelkgsuwdix3ko` (`course_id`),
  KEY `FKjl36bxmp2r28v38xlpsb25xxt` (`course_result_id`),
  KEY `FK1fyoumxopii9il8sw3oo953ly` (`user_id`),
  CONSTRAINT `FK1fyoumxopii9il8sw3oo953ly` FOREIGN KEY (`user_id`) REFERENCES `tbl_user` (`id`),
  CONSTRAINT `FKjl36bxmp2r28v38xlpsb25xxt` FOREIGN KEY (`course_result_id`) REFERENCES `tbl_course_result` (`id`),
  CONSTRAINT `FKr4ad0llrc7jrelkgsuwdix3ko` FOREIGN KEY (`course_id`) REFERENCES `tbl_course` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_user_course`
--

LOCK TABLES `tbl_user_course` WRITE;
/*!40000 ALTER TABLE `tbl_user_course` DISABLE KEYS */;
INSERT INTO `tbl_user_course` VALUES ('0e0c5171-f340-4eed-9a35-8c4caaa7862b',_binary '','2024-06-02 17:33:41.717000',8,'8e9cf898-6953-4453-ba3a-573a793479a0','a2aa251c-aefe-450c-925b-50ccc793ba88','18db5d5e-b0ca-40aa-a30a-77689ca15c81'),('10f5814c-a603-415f-afbd-329722caec8d',_binary '','2024-06-02 18:09:04.818000',8,'c522540c-10b5-4d35-932c-ccb0788b8c51','e5f8d916-b555-4565-a3c6-826f97909ab9','2a1fae2e-c56c-4c7c-b95d-235721fcd1ec'),('14c93745-4fae-4db5-b5b6-d0bed4ebc3ad',_binary '','2024-06-02 17:41:14.404000',9,'eb2ab1b7-399d-465a-a0d0-efb8f6a453f3','32cfd477-a445-4b23-a815-2f22d170e1e5','8f92ac71-000f-4b7b-a44b-38d9a5600dcf'),('2d0732c1-4ee2-415d-937d-3262da35b18b',_binary '','2024-06-02 18:07:52.624000',6.5,'a6831aa2-d976-41d4-abac-6e49f2be7bb4','32cfd477-a445-4b23-a815-2f22d170e1e5','0de3a80c-b081-4ed1-b226-959eac2ba890'),('4bc929e8-7dc7-4fcb-9ef6-c8b2baf4b70c',_binary '','2024-06-02 17:38:03.018000',7,'c522540c-10b5-4d35-932c-ccb0788b8c51','e5f8d916-b555-4565-a3c6-826f97909ab9','2858dab1-4fe2-4ee6-87c0-84a597d42233'),('5c7b39fe-a7b6-48c8-beb9-ebd75309401a',_binary '','2024-06-02 17:37:09.246000',8,'441f7e10-43bb-4ff5-a258-8b7916dcfc03','a2aa251c-aefe-450c-925b-50ccc793ba88','2858dab1-4fe2-4ee6-87c0-84a597d42233'),('617aa19d-d175-4e26-98fa-a88147bd8c95',_binary '\0','2024-06-02 18:07:36.307000',10,'66848185-828b-48c0-a8b6-14d0310df1cd','32cfd477-a445-4b23-a815-2f22d170e1e5','0de3a80c-b081-4ed1-b226-959eac2ba890'),('6ee1b2fa-b7cb-440b-82ab-4a3500ccdaa4',_binary '','2024-06-02 17:39:53.880000',8,'b1915384-ba53-40a8-8fe7-c9ece08246ad','e5f8d916-b555-4565-a3c6-826f97909ab9','27630a2d-1ee2-4d4d-bd43-df16f8629de3'),('6fddb236-5885-4176-aef5-8e4e31774464',_binary '\0','2024-06-02 17:39:27.064000',9,'01c8364f-783e-4d5c-b5e5-2cdc60da3dcd','32cfd477-a445-4b23-a815-2f22d170e1e5','27630a2d-1ee2-4d4d-bd43-df16f8629de3'),('7c473cd3-0468-4cdc-b70a-91120d50e324',_binary '\0','2024-06-02 17:34:12.634000',8,'fc586e87-140a-4721-8189-929dff9e7f37','a2aa251c-aefe-450c-925b-50ccc793ba88','18db5d5e-b0ca-40aa-a30a-77689ca15c81'),('7fd693f0-e7a6-4969-be19-8fba02e13048',_binary '','2024-06-02 17:41:44.552000',9,'66848185-828b-48c0-a8b6-14d0310df1cd','32cfd477-a445-4b23-a815-2f22d170e1e5','8f92ac71-000f-4b7b-a44b-38d9a5600dcf'),('8dbbcfad-7da0-4911-b1ff-9d947880619d',_binary '\0','2024-06-02 18:07:10.069000',10,'441f7e10-43bb-4ff5-a258-8b7916dcfc03','32cfd477-a445-4b23-a815-2f22d170e1e5','0de3a80c-b081-4ed1-b226-959eac2ba890'),('8e7ff7cd-b666-4ebe-9856-e52f54225621',_binary '\0','2024-06-02 17:33:54.244000',9,'b876ca6c-399c-469c-9c45-de623e369174','a2aa251c-aefe-450c-925b-50ccc793ba88','18db5d5e-b0ca-40aa-a30a-77689ca15c81'),('9471ed2a-d015-4e3a-b613-f2c55b8fb2b0',_binary '','2024-06-02 17:33:27.636000',10,'cb4860c6-c5e7-4e1f-9924-6bde1533f9e0','32cfd477-a445-4b23-a815-2f22d170e1e5','18db5d5e-b0ca-40aa-a30a-77689ca15c81'),('9f32fe5c-7ba9-4974-8744-68d597cee5d0',_binary '\0','2024-06-02 18:09:36.539000',8,'8e9cf898-6953-4453-ba3a-573a793479a0','a2aa251c-aefe-450c-925b-50ccc793ba88','2a1fae2e-c56c-4c7c-b95d-235721fcd1ec'),('a34aedac-406e-49e6-b2fa-37bdcd5b7f1b',_binary '','2024-06-02 17:44:43.998000',10,'441f7e10-43bb-4ff5-a258-8b7916dcfc03','32cfd477-a445-4b23-a815-2f22d170e1e5','b0a97e72-6dec-4e2d-82a7-679339ccbd00'),('aae7aef0-00f9-4b26-92ea-b4351cf0f620',_binary '','2024-06-02 17:44:56.328000',10,'eb2ab1b7-399d-465a-a0d0-efb8f6a453f3','32cfd477-a445-4b23-a815-2f22d170e1e5','b0a97e72-6dec-4e2d-82a7-679339ccbd00'),('c64e6594-aa43-49fc-a371-7c9fb61e2580',_binary '','2024-06-02 17:37:38.110000',9,'25dc9b6f-4793-4bfb-97eb-029a5c551a50','32cfd477-a445-4b23-a815-2f22d170e1e5','2858dab1-4fe2-4ee6-87c0-84a597d42233'),('c8508045-51c1-4379-8215-556f2428ed46',_binary '\0','2024-06-02 18:07:22.971000',8,'f61453d5-2d69-414b-8131-208406817a82','a2aa251c-aefe-450c-925b-50ccc793ba88','0de3a80c-b081-4ed1-b226-959eac2ba890'),('d54b4468-ab2d-40a6-8025-5b289f1393a0',_binary '','2024-06-02 17:39:38.616000',9,'eb2ab1b7-399d-465a-a0d0-efb8f6a453f3','32cfd477-a445-4b23-a815-2f22d170e1e5','27630a2d-1ee2-4d4d-bd43-df16f8629de3'),('d7db5a9d-43bb-4eed-9e42-5bbdc826078a',_binary '','2024-06-02 17:37:20.765000',9,'5d58f6fc-c660-48d3-a38b-3bcca7616bb4','32cfd477-a445-4b23-a815-2f22d170e1e5','2858dab1-4fe2-4ee6-87c0-84a597d42233'),('dfd1d391-cab9-4a0c-ae71-eadf7429bd95',_binary '','2024-06-02 17:41:29.130000',8,'2832ffc9-88cf-4314-8cf7-3b901cf256f5','32cfd477-a445-4b23-a815-2f22d170e1e5','8f92ac71-000f-4b7b-a44b-38d9a5600dcf'),('f2fceb96-f378-44a7-9d97-059639f7d6ab',_binary '','2024-06-02 17:45:09.595000',10,'2832ffc9-88cf-4314-8cf7-3b901cf256f5','32cfd477-a445-4b23-a815-2f22d170e1e5','b0a97e72-6dec-4e2d-82a7-679339ccbd00'),('f3f76ba9-a2f6-4469-9793-3425f0b7cee4',_binary '\0','2024-06-02 18:09:20.735000',9,'b1915384-ba53-40a8-8fe7-c9ece08246ad','32cfd477-a445-4b23-a815-2f22d170e1e5','2a1fae2e-c56c-4c7c-b95d-235721fcd1ec');
/*!40000 ALTER TABLE `tbl_user_course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_user_room`
--

DROP TABLE IF EXISTS `tbl_user_room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_user_room` (
  `id` varchar(36) NOT NULL,
  `join_date` datetime(6) DEFAULT NULL,
  `nick_name` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `room_id` varchar(36) DEFAULT NULL,
  `user_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK13y2akkmkmg8jopbocob4c80a` (`room_id`),
  KEY `FKcc01wixit56mh5dsg904xwome` (`user_id`),
  CONSTRAINT `FK13y2akkmkmg8jopbocob4c80a` FOREIGN KEY (`room_id`) REFERENCES `tbl_room` (`id`),
  CONSTRAINT `FKcc01wixit56mh5dsg904xwome` FOREIGN KEY (`user_id`) REFERENCES `tbl_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_user_room`
--

LOCK TABLES `tbl_user_room` WRITE;
/*!40000 ALTER TABLE `tbl_user_room` DISABLE KEYS */;
INSERT INTO `tbl_user_room` VALUES ('233801b0-a33c-42e4-81c3-35d9a0777600',NULL,NULL,'user','83d40126-ff76-427b-8398-73787ee49219','8f92ac71-000f-4b7b-a44b-38d9a5600dcf'),('29b7a4d1-97eb-4aa6-b487-51a9f152abbd',NULL,NULL,'user','83d40126-ff76-427b-8398-73787ee49219','2ae2e621-b81f-4035-aa2d-8d3280c288c5'),('2a06d5b7-1ff8-47bb-83e6-691a0de91542','2024-06-02 18:14:12.036000',NULL,'Participant','207aeebd-e872-41e9-b284-01ec2d52ca2e','27630a2d-1ee2-4d4d-bd43-df16f8629de3'),('3c8e779d-5baa-48fe-b3b7-8812a718524b',NULL,NULL,'user','5e9da4f6-b03b-4575-8e22-0958106dec14','8f92ac71-000f-4b7b-a44b-38d9a5600dcf'),('3dc32a96-2c13-4cbe-8567-6129086c21dd',NULL,NULL,'user','a9ae6c80-daf9-486d-8272-afdb22c9c1ea','18db5d5e-b0ca-40aa-a30a-77689ca15c81'),('4dd4710d-d309-4e33-8d91-9f17a6c3a9eb',NULL,NULL,'user','e8518c14-2828-4cda-9bf6-cf8d9b8912b4','2858dab1-4fe2-4ee6-87c0-84a597d42233'),('699079f0-e73d-42ad-8504-bb6ccdbb2100',NULL,NULL,'user','f0f82b4f-70f4-4119-9d22-3e10eeeaf31a','27630a2d-1ee2-4d4d-bd43-df16f8629de3'),('75b1dfe5-7159-4928-aff0-af1a7fb8ad81',NULL,NULL,'user','f0f82b4f-70f4-4119-9d22-3e10eeeaf31a','2ae2e621-b81f-4035-aa2d-8d3280c288c5'),('7db0a977-d80c-4d2d-8eab-2d9f1faf9c9b','2024-06-02 18:14:12.040000',NULL,'Participant','207aeebd-e872-41e9-b284-01ec2d52ca2e','8f92ac71-000f-4b7b-a44b-38d9a5600dcf'),('91325df1-c629-4072-91f8-56fdcf9bf159',NULL,NULL,'user','5e9da4f6-b03b-4575-8e22-0958106dec14','b0a97e72-6dec-4e2d-82a7-679339ccbd00'),('92fbd130-50dc-4071-8bd8-63a4a80146a1','2024-06-02 18:14:12.031000',NULL,'Admin','207aeebd-e872-41e9-b284-01ec2d52ca2e','2ae2e621-b81f-4035-aa2d-8d3280c288c5'),('c54b144f-cbf8-4a45-bf33-ce3a3e3f1f03',NULL,NULL,'user','95a5e190-8250-4864-9e15-68c38e82c61a','2858dab1-4fe2-4ee6-87c0-84a597d42233'),('c77b0c53-1040-4ffe-9a4b-2794543ea625',NULL,NULL,'user','a9ae6c80-daf9-486d-8272-afdb22c9c1ea','2ae2e621-b81f-4035-aa2d-8d3280c288c5'),('d340fb85-5582-4900-b027-8c121ab73a81',NULL,NULL,'user','95a5e190-8250-4864-9e15-68c38e82c61a','18db5d5e-b0ca-40aa-a30a-77689ca15c81'),('de9cfd13-cd56-44c5-8ee6-337cf9588495',NULL,NULL,'user','e8518c14-2828-4cda-9bf6-cf8d9b8912b4','2ae2e621-b81f-4035-aa2d-8d3280c288c5');
/*!40000 ALTER TABLE `tbl_user_room` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-03 20:11:13
