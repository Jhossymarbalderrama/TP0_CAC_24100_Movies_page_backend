-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         8.4.0 - MySQL Community Server - GPL
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.7.0.6850
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para tp_cac_24100_movies
CREATE DATABASE IF NOT EXISTS `tp_cac_24100_movies` /*!40100 DEFAULT CHARACTER SET latin1 COLLATE latin1_spanish_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `tp_cac_24100_movies`;

-- Volcando estructura para tabla tp_cac_24100_movies.gender
CREATE TABLE IF NOT EXISTS `gender` (
  `id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(50) COLLATE latin1_spanish_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- Volcando datos para la tabla tp_cac_24100_movies.gender: ~0 rows (aproximadamente)

-- Volcando estructura para tabla tp_cac_24100_movies.language
CREATE TABLE IF NOT EXISTS `language` (
  `id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(80) COLLATE latin1_spanish_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- Volcando datos para la tabla tp_cac_24100_movies.language: ~0 rows (aproximadamente)

-- Volcando estructura para tabla tp_cac_24100_movies.movie
CREATE TABLE IF NOT EXISTS `movie` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(80) COLLATE latin1_spanish_ci NOT NULL DEFAULT '',
  `poster` varchar(200) COLLATE latin1_spanish_ci NOT NULL DEFAULT '',
  `backdrop` varchar(200) COLLATE latin1_spanish_ci NOT NULL DEFAULT '',
  `release_date` date NOT NULL,
  `runtime` int NOT NULL,
  `overview` varchar(480) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL DEFAULT '',
  `status` varchar(40) COLLATE latin1_spanish_ci NOT NULL DEFAULT '',
  `budget` int NOT NULL,
  `revenue` int NOT NULL,
  `language` varchar(80) COLLATE latin1_spanish_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- Volcando datos para la tabla tp_cac_24100_movies.movie: ~6 rows (aproximadamente)
INSERT INTO `movie` (`id`, `title`, `poster`, `backdrop`, `release_date`, `runtime`, `overview`, `status`, `budget`, `revenue`, `language`) VALUES
	(2, 'Bad Boys Ride or Die', 'https://image.tmdb.org/t/p/w500//nP6RliHjxsz4irTKsxe8FRhKZYl.jpg', 'https://example.com/bad_boys_ride_or_die_backdrop.jpg', '2021-03-08', 130, 'Two Miami detectives, Mike and Marcus, are back on the streets to bring justice and action. This time, they are up against a dangerous drug cartel, but their loyalty and friendship will be tested like never before.', 'Released', 120000000, 450000000, 'English'),
	(3, 'The Matrix', 'https://image.tmdb.org/t/p/w500//f89U3ADr1oiB1s9GkdPOEpXUk5H.jpg', 'https://example.com/the_matrix_backdrop.jpg', '1999-03-31', 136, 'A computer hacker learns from mysterious rebels about the true nature of his reality and his role in the war against its controllers.', 'Released', 63000000, 466364845, 'English'),
	(5, 'Interstellar', 'https://image.tmdb.org/t/p/w500//gEU2QniE6E77NI6lCU6MxlNBvIx.jpg', 'https://example.com/backdrops/interstellar.jpg', '2014-11-06', 169, 'A team of explorers travel through a wormhole in space in an attempt to ensure humanity\'s survival.', 'Released', 165000000, 677471339, 'English'),
	(6, 'Kingdom of the Planet of the Apes', 'https://image.tmdb.org/t/p/w500//gKkl37BQuKTanygYQG1pyYgLVgf.jpg', 'https://example.com/kingdom_planet_of_the_apes_backdrop.jpg', '2023-07-02', 140, 'In a dystopian future where intelligent apes dominate the Earth, a young ape leader must navigate political intrigue and warfare to secure the survival and prosperity of their kingdom against human resistance.', 'Released', 150000000, 600000000, 'English'),
	(7, 'Inside Out 2', 'https://image.tmdb.org/t/p/w500//vpnVM9B6NMmQpWeZvzLvDESb2QY.jpg', 'https://example.com/inside_out_2_backdrop.jpg', '2025-06-24', 95, 'Riley is now a teenager, and her emotions are more complex than ever. Joy, Sadness, and the rest of the gang face new challenges as they navigate Riley\'s evolving mind, making new friends and discovering unknown territories of the emotional spectrum.', 'Post-Production', 200000000, 0, 'English'),
	(8, 'Deadpool & Wolverine', 'https://image.tmdb.org/t/p/w500//jbwYaoYWZwxtPP76AZnfYKQjCEB.jpg', 'https://example.com/deadpool_wolverine_backdrop.jpg', '2024-07-23', 130, 'In a high-octane, action-packed adventure, Deadpool teams up with Wolverine to take down a powerful new enemy threatening to disrupt the fabric of time. With their unique blend of humor and brute force, the unlikely duo must navigate through perilous missions, face off against formidable foes, and learn to work together to save the day.', 'In Production', 200000000, 1, 'English');

-- Volcando estructura para tabla tp_cac_24100_movies.mv_gender
CREATE TABLE IF NOT EXISTS `mv_gender` (
  `id_movie` int NOT NULL,
  `id_gender` int NOT NULL,
  UNIQUE KEY `mv_gender` (`id_movie`,`id_gender`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- Volcando datos para la tabla tp_cac_24100_movies.mv_gender: ~0 rows (aproximadamente)

-- Volcando estructura para tabla tp_cac_24100_movies.mv_prod_comp
CREATE TABLE IF NOT EXISTS `mv_prod_comp` (
  `id_movie` int NOT NULL,
  `id_production_companie` int NOT NULL,
  UNIQUE KEY `mv_prod_comp` (`id_movie`,`id_production_companie`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- Volcando datos para la tabla tp_cac_24100_movies.mv_prod_comp: ~0 rows (aproximadamente)

-- Volcando estructura para tabla tp_cac_24100_movies.production_companie
CREATE TABLE IF NOT EXISTS `production_companie` (
  `id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(50) COLLATE latin1_spanish_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- Volcando datos para la tabla tp_cac_24100_movies.production_companie: ~0 rows (aproximadamente)

-- Volcando estructura para tabla tp_cac_24100_movies.type_user
CREATE TABLE IF NOT EXISTS `type_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(45) COLLATE latin1_spanish_ci NOT NULL DEFAULT '',
  `state` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- Volcando datos para la tabla tp_cac_24100_movies.type_user: ~0 rows (aproximadamente)

-- Volcando estructura para tabla tp_cac_24100_movies.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `firstname` varchar(80) COLLATE latin1_spanish_ci NOT NULL DEFAULT '',
  `lastname` varchar(80) COLLATE latin1_spanish_ci NOT NULL DEFAULT '',
  `email` varchar(80) COLLATE latin1_spanish_ci NOT NULL DEFAULT '',
  `password` varchar(80) COLLATE latin1_spanish_ci NOT NULL DEFAULT '',
  `birthday` date DEFAULT NULL,
  `country` varchar(50) COLLATE latin1_spanish_ci DEFAULT '',
  `image` blob,
  `id_type_user` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- Volcando datos para la tabla tp_cac_24100_movies.user: ~0 rows (aproximadamente)
INSERT INTO `user` (`id`, `firstname`, `lastname`, `email`, `password`, `birthday`, `country`, `image`, `id_type_user`) VALUES
	(1, 'jhossy', 'balderrama', 'jhossy@gmail.com', 'jhossymar', '2025-05-03', 'Argentina', _binary 0x68747470733a2f2f6578616d706c652e636f6d2f6578616d706c652e6a7067, 1);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
