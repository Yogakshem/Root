-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.11 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for database
CREATE DATABASE IF NOT EXISTS `database` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `database`;

-- Dumping structure for table database.bussinessclassseats
CREATE TABLE IF NOT EXISTS `bussinessclassseats` (
  `SeatNo` int(100) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `PhoneNo` varchar(10) NOT NULL,
  `Address` varchar(50) NOT NULL,
  `Source` varchar(50) NOT NULL,
  `Destination` varchar(50) NOT NULL,
  `Date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- Dumping data for table database.bussinessclassseats: ~0 rows (approximately)
/*!40000 ALTER TABLE `bussinessclassseats` DISABLE KEYS */;
/*!40000 ALTER TABLE `bussinessclassseats` ENABLE KEYS */;

-- Dumping structure for table database.economicclassseats
CREATE TABLE IF NOT EXISTS `economicclassseats` (
  `SeatNo` int(100) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `PhoneNo` varchar(10) NOT NULL,
  `Address` varchar(50) NOT NULL,
  `Source` varchar(50) NOT NULL,
  `Destination` varchar(50) NOT NULL,
  `Date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table database.economicclassseats: ~0 rows (approximately)
/*!40000 ALTER TABLE `economicclassseats` DISABLE KEYS */;
/*!40000 ALTER TABLE `economicclassseats` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
