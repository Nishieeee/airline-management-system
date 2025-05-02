-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 02, 2025 at 11:56 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `airlinemanagementsystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `airplanes`
--

CREATE TABLE `airplanes` (
  `id` int(11) NOT NULL,
  `EconomyCapacity` int(11) NOT NULL,
  `BusinessCapacity` int(11) NOT NULL,
  `model` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `airplanes`
--

INSERT INTO `airplanes` (`id`, `EconomyCapacity`, `BusinessCapacity`, `model`) VALUES
(0, 123, 123, 'Boeing 777'),
(1, 12, 123, 'Boeing 777');

-- --------------------------------------------------------

--
-- Table structure for table `airports`
--

CREATE TABLE `airports` (
  `id` int(11) NOT NULL,
  `name` text NOT NULL,
  `code` text NOT NULL,
  `city` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `airports`
--

INSERT INTO `airports` (`id`, `name`, `code`, `city`) VALUES
(0, 'ZC National Aeropuerto', 'Zamboanga', 'Pagadian'),
(1, 'Cebu Specific', 'Cebu', 'zamboanga');

-- --------------------------------------------------------

--
-- Table structure for table `employees`
--

CREATE TABLE `employees` (
  `id` int(11) NOT NULL,
  `firstName` text NOT NULL,
  `lastName` text NOT NULL,
  `Tel` text NOT NULL,
  `email` text NOT NULL,
  `salary` double NOT NULL,
  `position` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employees`
--

INSERT INTO `employees` (`id`, `firstName`, `lastName`, `Tel`, `email`, `salary`, `position`) VALUES
(0, 'Clein', 'Pagarogan', '098765', 'test', 6746, 'lkjhgf'),
(1, 'razel', 'herodias', '098765', 'test@test', 0, 'jr dev');

-- --------------------------------------------------------

--
-- Table structure for table `flights`
--

CREATE TABLE `flights` (
  `id` int(11) NOT NULL,
  `airplane` text NOT NULL,
  `origin` text NOT NULL,
  `destination` text NOT NULL,
  `departureTime` text NOT NULL,
  `arrivalTime` text NOT NULL,
  `isDelayed` tinyint(1) NOT NULL,
  `bookedEconomy` int(11) NOT NULL,
  `bookedBusiness` int(11) NOT NULL,
  `stuff` text NOT NULL,
  `passengers` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `flights`
--

INSERT INTO `flights` (`id`, `airplane`, `origin`, `destination`, `departureTime`, `arrivalTime`, `isDelayed`, `bookedEconomy`, `bookedBusiness`, `stuff`, `passengers`) VALUES
(0, '0', '0', '1', '2024-10-10::10:10:10', '2024-10-10::15:15:10', 0, 0, 1, '<%%/>', '0<%%/>');

-- --------------------------------------------------------

--
-- Table structure for table `passengers`
--

CREATE TABLE `passengers` (
  `id` int(11) NOT NULL,
  `firstName` text NOT NULL,
  `lastName` text NOT NULL,
  `Tel` text NOT NULL,
  `email` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `passengers`
--

INSERT INTO `passengers` (`id`, `firstName`, `lastName`, `Tel`, `email`) VALUES
(0, 'clein', 'pagarogan', '098654', 'test@test');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
