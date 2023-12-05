#SQL code to run
CREATE DATABASE `world_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

CREATE TABLE `business` (
                            `id_business` int NOT NULL AUTO_INCREMENT,
                            `name` varchar(50) NOT NULL,
                            `type` varchar(45) NOT NULL,
                            `address` varchar(80) NOT NULL,
                            `profit` float DEFAULT NULL,
                            PRIMARY KEY (`id_business`),
                            UNIQUE KEY `address_UNIQUE` (`address`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
