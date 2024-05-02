CREATE DATABASE  IF NOT EXISTS `eventelion2.0` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `eventelion2.0`;
-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: eventelion2.0
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `approvals`
--

DROP TABLE IF EXISTS `approvals`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `approvals` (
  `Id` mediumint unsigned NOT NULL AUTO_INCREMENT,
  `UserName` varchar(45) NOT NULL,
  `Email` varchar(225) NOT NULL,
  `MobileNo` bigint NOT NULL,
  `Password` varchar(50) NOT NULL,
  `Designation` varchar(45) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `approvals`
--

LOCK TABLES `approvals` WRITE;
/*!40000 ALTER TABLE `approvals` DISABLE KEYS */;
/*!40000 ALTER TABLE `approvals` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `submissions`
--

DROP TABLE IF EXISTS `submissions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `submissions` (
  `Id` mediumint unsigned NOT NULL AUTO_INCREMENT,
  `UserName` varchar(30) NOT NULL,
  `Tasks` varchar(255) NOT NULL,
  `Date` varchar(30) NOT NULL,
  `StartTime` varchar(30) NOT NULL,
  `EndTime` varchar(30) NOT NULL,
  `SubmittedAt` varchar(30) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `UserName_idx` (`UserName`),
  CONSTRAINT `UserNames` FOREIGN KEY (`UserName`) REFERENCES `users` (`UserName`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `submissions`
--

LOCK TABLES `submissions` WRITE;
/*!40000 ALTER TABLE `submissions` DISABLE KEYS */;
INSERT INTO `submissions` VALUES (5,'AK','Submission Update Done ( Updated on Fri Dec 08 11:57:31 IST 2023 ) ','2023-12-07','13:35','17:30','Thu Dec 07 23:33:52 IST 2023'),(6,'NotPrath19','Reminder','2023-12-07','10:00','22:00','Fri Dec 08 10:31:03 IST 2023');
/*!40000 ALTER TABLE `submissions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tasks`
--

DROP TABLE IF EXISTS `tasks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tasks` (
  `Id` mediumint unsigned NOT NULL AUTO_INCREMENT,
  `UserName` varchar(30) NOT NULL,
  `Tasks` varchar(255) NOT NULL,
  `Date` varchar(30) NOT NULL,
  `StartTime` varchar(30) NOT NULL,
  `EndTime` varchar(30) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `UserName_idx` (`UserName`),
  CONSTRAINT `UserName` FOREIGN KEY (`UserName`) REFERENCES `users` (`UserName`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tasks`
--

LOCK TABLES `tasks` WRITE;
/*!40000 ALTER TABLE `tasks` DISABLE KEYS */;
INSERT INTO `tasks` VALUES (2,'AK','India Finals','2023-12-14','14:31','17:31'),(5,'NotPrath19','Finish Presentation','2023-12-08','10:30','17:00');
/*!40000 ALTER TABLE `tasks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `UserName` varchar(30) NOT NULL,
  `Email` varchar(225) NOT NULL,
  `MobileNo` bigint NOT NULL,
  `Password` varchar(50) NOT NULL,
  `Designation` varchar(45) NOT NULL DEFAULT 'User',
  `ActiveStauts` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`UserName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('AK','ak27@gmail.com',8762345678,'Heya@12','User',1),('Ayushi','ayu12@gmail.com',9097654329,'1234','User',0),('CeoOfDemons','priyanshranadive@gmail.com',8319023349,'Really','Admin',0),('Meanie','meanie19@gmail.com',83190576657,'12345','User',0),('Means','means0108@gmail.com',8319023347,'Prath19','Admin',0),('NotPrath19','prathmeshranadive19@gmail.com',83190576659,'1234','User',0),('Prath19','prathmeshranadive19@gmail.com',8319057558,'Work','Admin',1),('Zanther','zanther777',8306746538,'12345','User',0);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-08 20:23:00
