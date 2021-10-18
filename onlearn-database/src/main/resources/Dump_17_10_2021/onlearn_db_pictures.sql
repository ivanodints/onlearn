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
-- Table structure for table `pictures`
--

DROP TABLE IF EXISTS `pictures`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pictures` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content_type` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  `direction_id` bigint(20) DEFAULT NULL,
  `discipline_id` bigint(20) DEFAULT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  `faculty_id` bigint(20) DEFAULT NULL,
  `picture_data_id` bigint(20) NOT NULL,
  `student_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ehsu2tyinopypjox1ijxt3g3c` (`picture_data_id`),
  KEY `FKiukkvhu7srjhbbt7nsuk2eguy` (`direction_id`),
  KEY `FK93v43p9k6hh7yvvg6ue4f3sr` (`discipline_id`),
  KEY `FK1uvfoi51k753cunis3qadi31h` (`employee_id`),
  KEY `FK27j9jfyu0n9kud9ejfxfoxcrs` (`faculty_id`),
  KEY `FKa7d35stg838qve9uvpfo2es9i` (`student_id`),
  CONSTRAINT `FK1uvfoi51k753cunis3qadi31h` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`),
  CONSTRAINT `FK27j9jfyu0n9kud9ejfxfoxcrs` FOREIGN KEY (`faculty_id`) REFERENCES `faculty` (`id`),
  CONSTRAINT `FK93v43p9k6hh7yvvg6ue4f3sr` FOREIGN KEY (`discipline_id`) REFERENCES `discipline` (`id`),
  CONSTRAINT `FKa7d35stg838qve9uvpfo2es9i` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`),
  CONSTRAINT `FKe9cv52k04xoy6cj8xy308gnw3` FOREIGN KEY (`picture_data_id`) REFERENCES `pictures_data` (`id`),
  CONSTRAINT `FKiukkvhu7srjhbbt7nsuk2eguy` FOREIGN KEY (`direction_id`) REFERENCES `direction` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pictures`
--

LOCK TABLES `pictures` WRITE;
/*!40000 ALTER TABLE `pictures` DISABLE KEYS */;
INSERT INTO `pictures` VALUES (16,'image/jpeg','java.jpg',NULL,NULL,1,NULL,16,NULL),(42,'image/jpeg','c++.jpg',NULL,NULL,NULL,NULL,42,3),(44,'image/jpeg','маркетинг_logo_300x300.jpg',5,NULL,NULL,NULL,44,NULL),(45,'image/jpeg','программирование_logo_300x300.jpg',3,NULL,NULL,NULL,45,NULL),(46,'image/jpeg','дизайн_logo_300x300.jpg',6,NULL,NULL,NULL,46,NULL),(47,'image/jpeg','аналитика_logo_300x300.jpg',7,NULL,NULL,NULL,47,NULL),(49,'image/png','java_logo-300x300.png',NULL,NULL,NULL,5,49,NULL),(50,'image/png','python_logo_300x300.png',NULL,NULL,NULL,6,50,NULL),(51,'image/png','adnroid_logo_300x300.png',NULL,NULL,NULL,7,51,NULL),(52,'image/png','ios_logo_300x300.png',NULL,NULL,NULL,8,52,NULL),(53,'application/octet-stream','',NULL,NULL,NULL,8,53,NULL),(54,'image/jpeg','smm_menedgment_logo_300x300.jpg',NULL,NULL,NULL,9,54,NULL),(55,'image/png','internet_marketing_logo_300x300.png',NULL,NULL,NULL,10,55,NULL),(56,'image/png','internet_marketing_logo_300x300.png',NULL,NULL,NULL,11,56,NULL),(57,'image/png','game_design_logo_300x300.png',NULL,NULL,NULL,12,57,NULL),(58,'image/jpeg','graphics_design_logo_300x300.jpg',NULL,NULL,NULL,13,58,NULL),(59,'image/png','Web-design_logo_300x300.png',NULL,NULL,NULL,14,59,NULL),(60,'image/jpeg','3d_modeling_logo_300x300.jpg',NULL,NULL,NULL,15,60,NULL),(61,'image/jpeg','aI_logo_300x300.jpg',NULL,NULL,NULL,16,61,NULL),(62,'image/png','big_data_аналитика_logo_300x300.png',NULL,NULL,NULL,17,62,NULL),(63,'image/png','data_science_logo_300x300.png',NULL,NULL,NULL,18,63,NULL),(64,'image/jpeg','финансовая_аналитика_logo_300x300.jpg',NULL,NULL,NULL,19,64,NULL),(66,'image/png','java_logo-300x300.png',NULL,5,NULL,NULL,66,NULL),(67,'image/png','java_logo-300x300.png',NULL,7,NULL,NULL,67,NULL),(68,'image/jpeg','spring_300x300.jpg',NULL,8,NULL,NULL,68,NULL),(69,'image/png','python_logo_300x300.png',NULL,9,NULL,NULL,69,NULL),(70,'image/png','python_logo_300x300.png',NULL,10,NULL,NULL,70,NULL),(71,'image/png','Sql_300x300.png',NULL,11,NULL,NULL,71,NULL),(74,'image/jpeg','2-x-3-pirate-jolly-roger-polyester-flag.jpg',NULL,NULL,9,NULL,74,NULL),(76,'application/octet-stream','',NULL,NULL,NULL,NULL,76,5),(77,'application/octet-stream','',NULL,NULL,NULL,NULL,77,7),(78,'application/octet-stream','',NULL,NULL,10,NULL,78,NULL);
/*!40000 ALTER TABLE `pictures` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-17 19:41:23
