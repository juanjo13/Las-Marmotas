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
INSERT INTO `automovil` VALUES (1,'Ford','Ranger',1999,'Camioneta de color azul turqueza, con detalle de estrellado en el vidrio de la ventana del chofer.',2508.9,0,23.2,0,0,0,0,0,'0'),(3,'Audi','R8',2016,'Recien pintado el muy pinshe',4000,0,16,9,0,0,0,0,'0'),(4,'Ford','Mustang',1998,'asdocnpasvpa',7500,0,35.3,0,0,0,0,0,'0'),(5,'Dodge','Viper',2010,'sadacmapsdnapncd',45000,0,20.12,0,0,0,0,0,'0'),(6,'Ford','Expedition',1998,'N/A',5600,0,30,0,0,0,0,0,'1'),(7,'Dodge','Caravan',1999,'asdasefs',56000,0,32,0,0,0,0,0,'1'),(8,'Maseratti','Vanquish',2017,'Está perron',2000,0,49.1,0,0,0,0,0,'activo'),(9,'Mitsubishi','Lancer EVO',2016,'Irelo desgraciado',50000,0,23.98,0,0,0,0,0,'activo');
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
