-- MySQL dump 10.13  Distrib 8.0.46, for Win64 (x86_64)
--
-- Host: localhost    Database: joyasoscar
-- ------------------------------------------------------
-- Server version	26.7.0

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
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ '099148e0-c0e1-11f1-a03d-f875a4f14b53:1-210';

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `id_cliente` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `telefono` varchar(100) NOT NULL,
  `direccion` varchar(150) NOT NULL,
  `activo` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'Laura','Hernandez','1234567892','calle 33 d# 76-90, la floresta',0),(2,'Juan','Buitrago','1234567898','direccion',1),(3,'Jhosep','Nuñez','1234567895','Carrera 39 # 9-32, el peñon',0),(4,'Sodia','hola','1234567893','jnkjandkca',0),(5,'pruebas','1','111111111','jjjjj',0),(6,'prueba','prueba 2','1111111111','sss',1),(7,'rfrf','','1234567833','',0),(8,'hola','jajajjaa','0000000000','kjsjkjas',0),(9,'orueba','hola','1234567894','mmm',1),(10,'Karen','Díaz','3159998877','la floresta calle 33d #76-45',0),(11,'James','Rodriguez','0000000004','direccion',1);
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_pedidos`
--

DROP TABLE IF EXISTS `detalle_pedidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalle_pedidos` (
  `id_joya` int NOT NULL,
  `id_pedido` int NOT NULL,
  `precio_unitario` decimal(12,2) NOT NULL,
  `subtotal` decimal(12,2) NOT NULL,
  `cantidad` int NOT NULL,
  PRIMARY KEY (`id_pedido`,`id_joya`),
  KEY `id_joya` (`id_joya`),
  CONSTRAINT `detalle_pedidos_ibfk_1` FOREIGN KEY (`id_joya`) REFERENCES `joyas` (`id_joya`),
  CONSTRAINT `detalle_pedidos_ibfk_2` FOREIGN KEY (`id_pedido`) REFERENCES `pedidos` (`id_pedido`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_pedidos`
--

LOCK TABLES `detalle_pedidos` WRITE;
/*!40000 ALTER TABLE `detalle_pedidos` DISABLE KEYS */;
INSERT INTO `detalle_pedidos` VALUES (1,1,56000.00,56000.00,1),(2,2,28000.00,56000.00,2),(3,3,30000.00,90000.00,3);
/*!40000 ALTER TABLE `detalle_pedidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `joyas`
--

DROP TABLE IF EXISTS `joyas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `joyas` (
  `id_joya` int NOT NULL AUTO_INCREMENT,
  `stock` int NOT NULL,
  `precio` decimal(12,2) NOT NULL,
  `material` varchar(100) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `activo` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id_joya`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `joyas`
--

LOCK TABLES `joyas` WRITE;
/*!40000 ALTER TABLE `joyas` DISABLE KEYS */;
INSERT INTO `joyas` VALUES (1,12,56000.00,'Oro','Anilllo de oro 2k',1),(2,5,28000.00,'Plata','Collar de plata',1),(3,22,30000.00,'Platino','Aretes prueba2',1),(4,7,9876.54,'Platino','Joya actualizada',0),(5,7,9876.54,'Platino','Joya actualizada',0),(6,7,9876.54,'Platino','Joya actualizada',0),(7,2,4000.00,'nose','prueba',0),(8,22,30000.00,'Platino','Aretes prueba',0),(9,1,3499.00,'ijsjsjs','Prueba akd',0),(10,6,4500.00,'jajjaja','jakjsks',0),(11,11,3400.00,'sjsjdd','jsjs',0),(12,24,3400.00,'jejjeje','jajajaja',1);
/*!40000 ALTER TABLE `joyas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materiales`
--

DROP TABLE IF EXISTS `materiales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `materiales` (
  `id_material` int NOT NULL AUTO_INCREMENT,
  `tipo_material` varchar(100) NOT NULL,
  `stock` int NOT NULL,
  `nombre` varchar(150) DEFAULT NULL,
  `peso` decimal(10,3) NOT NULL,
  `precio` decimal(12,2) NOT NULL,
  `activo` tinyint(1) DEFAULT '1',
  `total` double DEFAULT NULL,
  PRIMARY KEY (`id_material`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materiales`
--

LOCK TABLES `materiales` WRITE;
/*!40000 ALTER TABLE `materiales` DISABLE KEYS */;
INSERT INTO `materiales` VALUES (1,'Oro',10,'Oro amarillo',13.000,60000.00,1,780000),(2,'PLata',6,'Plata fina',22.000,25000.00,0,NULL),(3,'Titanio',15,'Titanio anodizado',20.000,2500.00,0,NULL),(4,'Oro',2,'prueba oro',11.000,2500.00,0,NULL),(5,'prueba',4,'prueba hola',27.000,7800.00,1,NULL),(6,'jkjkj',5,'kjdljalk',23.000,2600.00,1,59800),(7,'prueba1',6,'Pueba',12.000,4500.00,1,54000);
/*!40000 ALTER TABLE `materiales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pagos`
--

DROP TABLE IF EXISTS `pagos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pagos` (
  `id_pago` int NOT NULL AUTO_INCREMENT,
  `fecha_pago` date NOT NULL,
  `estado` enum('pendiente','pagado','cancelado') NOT NULL DEFAULT 'pendiente',
  `metodo_pago` enum('nequi','transferencia','tarjeta','efectivo') NOT NULL DEFAULT 'efectivo',
  `monto` decimal(12,2) NOT NULL,
  `id_pedido` int DEFAULT NULL,
  PRIMARY KEY (`id_pago`),
  KEY `id_pedido` (`id_pedido`),
  CONSTRAINT `pagos_ibfk_1` FOREIGN KEY (`id_pedido`) REFERENCES `pedidos` (`id_pedido`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagos`
--

LOCK TABLES `pagos` WRITE;
/*!40000 ALTER TABLE `pagos` DISABLE KEYS */;
INSERT INTO `pagos` VALUES (1,'2026-11-11','pagado','efectivo',240000.00,1),(2,'2026-04-25','cancelado','efectivo',0.00,2),(3,'2026-09-30','pendiente','transferencia',1000000.00,3);
/*!40000 ALTER TABLE `pagos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedidos`
--

DROP TABLE IF EXISTS `pedidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedidos` (
  `id_pedido` int NOT NULL AUTO_INCREMENT,
  `estado` enum('pendiente','proceso','enviado','entregado','cancelado') NOT NULL DEFAULT 'pendiente',
  `direccion` varchar(150) NOT NULL,
  `fecha_pedido` date NOT NULL,
  `total` decimal(12,2) NOT NULL,
  `id_cliente` int DEFAULT NULL,
  PRIMARY KEY (`id_pedido`),
  KEY `id_cliente` (`id_cliente`),
  CONSTRAINT `pedidos_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedidos`
--

LOCK TABLES `pedidos` WRITE;
/*!40000 ALTER TABLE `pedidos` DISABLE KEYS */;
INSERT INTO `pedidos` VALUES (1,'proceso','calle 16 #100-20 ciudad jardin','2026-11-10',240000.00,1),(2,'enviado','calle 16 #100-20 ciudad jardin','2026-04-24',500000.00,2),(3,'pendiente','avenida 6N #28-50 granada','2026-09-29',1000000.00,3);
/*!40000 ALTER TABLE `pedidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id_rol` int NOT NULL AUTO_INCREMENT,
  `nombre` enum('Administrador','Vendedor','Joyero') DEFAULT NULL,
  PRIMARY KEY (`id_rol`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'Administrador'),(2,'Vendedor'),(3,'Joyero');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `contrasena_hash` char(64) NOT NULL,
  `activo` tinyint(1) NOT NULL DEFAULT '1',
  `nombre_completo` varchar(150) NOT NULL,
  `nombre_usuario` varchar(150) NOT NULL,
  `id_rol` int NOT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `nombre_usuario` (`nombre_usuario`),
  KEY `id_rol` (`id_rol`),
  CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`id_rol`) REFERENCES `roles` (`id_rol`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'a3b0965009ed307b9de3e46898d5fcc9ad22b532bf566cf84eb4c7396e11795a',1,'Oscar Toro','oscar',1),(2,'a3e1a8a3ccd08f006f9df0b36f7a83809aff603bcd0ad5504821592c85ed3b22',1,'Sofia Hernandez','sofi',2),(3,'f6ccb3e8d609012238c0b39e60b2c9632b3cdede91e035dad1de43469768f4cc',1,'Juan Toro','juanpa',3),(4,'03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4',1,'Laura Hernandez','prueba',1),(5,'03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4',0,'prueba2','Hola profe',1),(6,'5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5',0,'prueba2','hola',1),(7,'03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4',0,'vend','vendedor',1),(8,'03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4',0,'pruebasvendedor','vendedor hola',1),(9,'03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4',0,'Sebastian','sebas',1),(10,'03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4',0,'james rodriguez','james',1),(11,'03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4',1,'gomez hola','gomez',1),(12,'03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4',0,'andrea fernandez','andrea',1),(13,'9834876dcfb05cb167a5c24953eba58c4ac89b1adf57f28f2f9d09af107ee8f0',0,'aaa','aaa',1),(14,'282b91e08fd50a38f030dbbdee7898d36dd523605d94d9dd6e50b298e47844be',1,'eee','eee',1),(15,'f5557d4fcf727a981a3c315aca733eefa2996f7c7cdae1fa7e0de28522820bb0',1,'iii','iii',1),(16,'1ad25d0002690dc02e2708a297d8c9df1f160d376f663309cc261c7c921367e7',1,'ooo','ooo',2),(17,'b2fca9af31aae6953124439df5bc300c1ef11fb8be938aeb570767c5b6bfdaaf',1,'jjj','jjj',3);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-11-24 18:44:14
