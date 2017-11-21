-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: localhost    Database: smv
-- ------------------------------------------------------
-- Server version	5.6.17

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
-- Table structure for table `automovil`
--

DROP TABLE IF EXISTS `automovil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `automovil` (
  `idAutomovil` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Marca` varchar(25) NOT NULL,
  `Modelo` varchar(25) NOT NULL,
  `Anio` int(10) unsigned NOT NULL,
  `Desc_Extra` text NOT NULL,
  `Kilometraje_Actual` float NOT NULL,
  `Kilometraje_Recorrido` float NOT NULL,
  `Combustible_Actual` float NOT NULL,
  `Combustible_Gastado` float NOT NULL,
  `km_carroceria` float unsigned NOT NULL,
  `km_neumaticos` float unsigned NOT NULL,
  `km_frenos` float unsigned NOT NULL,
  `km_afinacion` float unsigned NOT NULL,
  `estado` varchar(25) NOT NULL,
  PRIMARY KEY (`idAutomovil`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `automovil`
--

LOCK TABLES `automovil` WRITE;
/*!40000 ALTER TABLE `automovil` DISABLE KEYS */;
/*!40000 ALTER TABLE `automovil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mantenimiento`
--

DROP TABLE IF EXISTS `mantenimiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mantenimiento` (
  `idMantenimiento` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Automovil_idAutomovil` int(10) unsigned NOT NULL,
  `Tipo` varchar(25) NOT NULL,
  `Fecha` date NOT NULL,
  `Estado` int(10) unsigned NOT NULL,
  PRIMARY KEY (`idMantenimiento`),
  KEY `Mantenimiento` (`Automovil_idAutomovil`),
  CONSTRAINT `Mantenimiento` FOREIGN KEY (`Automovil_idAutomovil`) REFERENCES `automovil` (`idAutomovil`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mantenimiento`
--

LOCK TABLES `mantenimiento` WRITE;
/*!40000 ALTER TABLE `mantenimiento` DISABLE KEYS */;
/*!40000 ALTER TABLE `mantenimiento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rendimiento`
--

DROP TABLE IF EXISTS `rendimiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rendimiento` (
  `idRendimiento` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Automovil_idAutomovil` int(10) unsigned NOT NULL,
  `Rendimiento` float unsigned NOT NULL,
  PRIMARY KEY (`idRendimiento`),
  KEY `Rendimiento` (`Automovil_idAutomovil`),
  CONSTRAINT `Rendimiento` FOREIGN KEY (`Automovil_idAutomovil`) REFERENCES `automovil` (`idAutomovil`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rendimiento`
--

LOCK TABLES `rendimiento` WRITE;
/*!40000 ALTER TABLE `rendimiento` DISABLE KEYS */;
/*!40000 ALTER TABLE `rendimiento` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-11 11:01:08
