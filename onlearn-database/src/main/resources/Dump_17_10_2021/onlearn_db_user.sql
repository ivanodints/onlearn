-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: onlearn_db
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `login` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ew1hvam8uwaknuaellwhqchhb` (`login`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'1','$2a$10$uedJ6jkBS08x5mxZY6gV6.LAKSd202CiVutxz5VDq3TIyj9alkmIq'),(2,'2','$2a$10$pe9yc8cybKPXHWVwAE93t./1HJQVGqOsROzCyHY5zlzCI/jM2DgCa'),(3,'3','$2a$10$qvuhz/8Nd.JjhYLzXJHmsOzDBbynx31/rNOJ7MLqm6pDZuw0/gQ1.'),(14,'testStud2','$2a$10$W9u7CdbVzr0cWzJwT7W53Odw72S0/8wVWVrauMSVqX7AsNpqBoPxq'),(15,'testSt12','$2a$10$2GrnuWqOUqlfmFxDxBq.HOG7qiWhkyRQUHqmCEbcs7y.PEzad1ST2'),(16,'newEmployee77','$2a$10$NQsTNlDii6gxbKnEjNQ0Nujp6J0x/oHWEz3LOzR.6vPATV8V7YuJa'),(19,'studentNew555','$2a$10$h0S3aQQrtRjIWpmUGgSvBOZHPUr2moh8n2DTHbh5UqOeHLI4Wsyv6'),(21,'zeus55','$2a$10$go8K2BUbVs.3sC2/XoZAru7wvKhCBmAkIEHaqvvG7oQqNdaMK.gQC'),(23,'newStudentzzzzz','$2a$10$HB0ILnBQRe9NXMofjlV.M.ugAOg01fCVwJJb7qD37f1TW9t7vvdRi'),(25,'admin','$2a$10$AhBIMvahym5W0vyzq8VpReOlJeloJ9HWE/XInuZvxpFqkWfTWtY3e'),(28,'test','$2a$10$.9Mz8eBLgtc9WqYMrY0pAORVDAoKzHWKvAorLhMdAn5iFsFR/CtxO'),(29,'testUItwo','$2a$10$3IwXV8XOSr.h9mT3mS2CNOEOP4Syn92TYvM8qfdB/dCaM3fLhC2Dq'),(30,'superadmin','$2a$10$/S3R4zqqVFgWigU.qtniXOYG0Imyu8ON6GlEg3gfkVVCPQM54B2wG');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-17 19:41:22
