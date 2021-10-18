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
-- Table structure for table `faculty`
--

DROP TABLE IF EXISTS `faculty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `faculty` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `price` decimal(19,2) NOT NULL,
  `title` varchar(255) NOT NULL,
  `direction_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_2inxuk0d9gjymgptu637w5piv` (`title`),
  KEY `FKao02nnjtfsreo40lsxdofxu2c` (`direction_id`),
  CONSTRAINT `FKao02nnjtfsreo40lsxdofxu2c` FOREIGN KEY (`direction_id`) REFERENCES `direction` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faculty`
--

LOCK TABLES `faculty` WRITE;
/*!40000 ALTER TABLE `faculty` DISABLE KEYS */;
INSERT INTO `faculty` VALUES (5,'Java - строго типизированный объектно-ориентированный язык программирования общего назначения, разработанный компанией Sun Microsystems.',25000.00,'Java разработчик',3),(6,'Python является мультипарадигмальным языком программирования, поддерживающим императивное, процедурное, структурное, объектно-ориентированное программирование, метапрограммирование и функциональное программирование.',25000.00,'Pythone разработчик',3),(7,'Мобильная разработка под платформу Android.',25000.00,'Android разработчик',3),(8,'Мобильная разработка под платформу iOS.',25000.00,'iOS разработка',3),(9,'SMM и все все все',30000.00,'SMM менеджмент',5),(10,'Интернет-маркетолог разрабатывает digital-стратегию, запускает рекламные кампании и анализирует их эффективность.',30000.00,'Интернет маркетинг ',5),(11,'SEO (Search Engine Optimization) – это технология раскрутки сайта в поисковой выдаче с целью получения трафика.',30000.00,'SEO продвижение',5),(12,'Это процесс создания формы и содержания игрового процесса (геймплея) разрабатываемой игры.',35000.00,'Геймдизайн',6),(13,'Художественно-проектная деятельность по созданию гармоничной и эффективной визуально-коммуникационной среды.',23000.00,'Графический дизайн',6),(14,'Отрасль веб-разработки и разновидность дизайна, в задачи которой входит проектирование пользовательских веб-интерфейсов для сайтов или веб-приложений.',31000.00,'Веб дизайн',6),(15,'Трёхмерная графика — раздел компьютерной графики, посвящённый методам создания изображений или видео путём моделирования объектов в трёх измерениях.',31000.00,'3D моделирование',6),(16,'Пусть машина работает за вас',40000.00,'Искусственный интеллект',7),(17,'Обработка больших объемов данных при помощи специальных автоматизированных инструментов, чтобы использовать  их для статистики, анализа, прогнозов и принятия решений.',410000.00,'Big Data аналитика',7),(18,'Data Science - междисциплинарная область на стыке статистики, математики, системного анализа и машинного обучения, которая охватывает все этапы работы с данными. ',50000.00,'Data Science',7),(19,'Экономический анализа, связанный с исследованием финансовых результатов и финансового состояния организации.',38000.00,'Финансовая аналитика',7);
/*!40000 ALTER TABLE `faculty` ENABLE KEYS */;
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
