DROP TABLE IF EXISTS `config`;
CREATE TABLE `config` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ruc` varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  `nombre` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `telefono` varchar(11) COLLATE utf8_spanish_ci NOT NULL,
  `direccion` text COLLATE utf8_spanish_ci NOT NULL,
  `mensaje` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;


LOCK TABLES `config` WRITE;
INSERT INTO `config` VALUES (1,'65479877','Restaurante la Delicia','957847894','Lima - Perú','Gracias por la compra');

UNLOCK TABLES;


DROP TABLE IF EXISTS `detalle_pedidos`;

CREATE TABLE `detalle_pedidos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(200) COLLATE utf8_spanish_ci NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `comentario` text COLLATE utf8_spanish_ci DEFAULT NULL,
  `id_pedido` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_pedido` (`id_pedido`),
  CONSTRAINT `detalle_pedidos_ibfk_1` FOREIGN KEY (`id_pedido`) REFERENCES `pedidos` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;


LOCK TABLES `detalle_pedidos` WRITE;

INSERT INTO `detalle_pedidos` VALUES (1,'CHAUFA',20.00,1,'',1),(2,'ARROZ CON POLLO',10.00,5,'ARTO MAYONESA',1),(3,'GASEOSA COCA COLA 1.5 LITROS',8.00,1,'',1),(4,'ARROZ CON POLLO',10.00,1,'',2),(5,'CHAUFA',20.00,1,'',2),(6,'GASEOSA COCA COLA 1.5 LITROS',8.00,1,'',3),(7,'CHAUFA',20.00,1,'',3),(8,'ARROZ CON POLLO',10.00,2,'',4);
UNLOCK TABLES;


DROP TABLE IF EXISTS `pedidos`;

CREATE TABLE `pedidos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_sala` int(11) NOT NULL,
  `num_mesa` int(11) NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `total` decimal(10,2) NOT NULL,
  `estado` enum('PENDIENTE','FINALIZADO') COLLATE utf8_spanish_ci NOT NULL DEFAULT 'PENDIENTE',
  `usuario` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_sala` (`id_sala`),
  CONSTRAINT `pedidos_ibfk_1` FOREIGN KEY (`id_sala`) REFERENCES `salas` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;


LOCK TABLES `pedidos` WRITE;

INSERT INTO `pedidos` VALUES (1,1,2,'2022-05-18 00:31:52',78.00,'FINALIZADO','ANGEL SIFUENTES'),(2,2,8,'2022-05-18 00:32:20',30.00,'PENDIENTE','ANGEL SIFUENTES'),(3,1,9,'2022-05-18 00:32:29',28.00,'PENDIENTE','ANGEL SIFUENTES'),(4,1,11,'2022-05-18 01:04:47',20.00,'PENDIENTE','ANGEL SIFUENTES');
UNLOCK TABLES;


DROP TABLE IF EXISTS `platos`;

CREATE TABLE `platos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(200) COLLATE utf8_spanish_ci NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  `fecha` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;


LOCK TABLES `platos` WRITE;

INSERT INTO `platos` VALUES (1,'ARROZ CON POLLO',10.00,'2022-05-17'),(2,'CHAUFA',20.00,'2022-05-17'),(3,'GASEOSA COCA COLA 1.5 LITROS',8.00,'2022-05-17');
UNLOCK TABLES;


DROP TABLE IF EXISTS `salas`;
CREATE TABLE `salas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `mesas` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;


LOCK TABLES `salas` WRITE;

INSERT INTO `salas` VALUES (1,'SALA PRINCIPAL',15),(2,'SEGUNDO PISO',10);
UNLOCK TABLES;


DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(200) COLLATE utf8_spanish_ci NOT NULL,
  `correo` varchar(200) COLLATE utf8_spanish_ci NOT NULL,
  `pass` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `rol` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;


LOCK TABLES `usuarios` WRITE;

INSERT INTO `usuarios` VALUES (1,'Samuel Hernandez','shernandez@admin.com','admin1','Administrador');

UNLOCK TABLES;

USE restaurante;
SELECT * FROM usuarios;

