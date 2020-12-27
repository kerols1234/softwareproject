-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Dec 27, 2020 at 05:48 PM
-- Server version: 8.0.17
-- PHP Version: 7.3.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `notification`
--

-- --------------------------------------------------------

--
-- Table structure for table `email_queue`
--

CREATE TABLE `email_queue` (
  `id` int(11) NOT NULL,
  `sender` varchar(60) NOT NULL,
  `receiver` varchar(60) NOT NULL,
  `body` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `subject` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `language` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `email_queue`
--

INSERT INTO `email_queue` (`id`, `sender`, `receiver`, `body`, `subject`, `language`) VALUES
(1, 'sfsdgdsfg', 'dddsddddd', 'ssssssssssssss', 'saaaaaaaaaaaaaaaaaaaaa', 'dddddddd');

-- --------------------------------------------------------

--
-- Table structure for table `sms_queue`
--

CREATE TABLE `sms_queue` (
  `id` int(11) NOT NULL,
  `sender` varchar(60) NOT NULL,
  `receiver` varchar(60) NOT NULL,
  `body` varchar(500) NOT NULL,
  `subject` varchar(50) NOT NULL,
  `language` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `template`
--

CREATE TABLE `template` (
  `id` int(11) NOT NULL,
  `data` varchar(600) NOT NULL,
  `template_name` varchar(50) NOT NULL,
  `language` varchar(30) NOT NULL,
  `subject` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `template`
--

INSERT INTO `template` (`id`, `data`, `template_name`, `language`, `subject`) VALUES
(18, 'sfsdgdsfg', '500', 'Internal Server Error', 'fsdfgsdfsdf'),
(19, 'sfsdgdsfg', 'dddsddddd', 'Internal Server Error', 'fsdfgsdfsdf'),
(20, 'sfsdgdsfg', 'dddsddddd', 'Internal Server Error', 'fsdfgsdfsdf'),
(21, 'sfsdgdsfg', 'dddsddddd', 'Internal Server Error', 'fsdfgsdfsdf');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `email_queue`
--
ALTER TABLE `email_queue`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sms_queue`
--
ALTER TABLE `sms_queue`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `template`
--
ALTER TABLE `template`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `email_queue`
--
ALTER TABLE `email_queue`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `sms_queue`
--
ALTER TABLE `sms_queue`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `template`
--
ALTER TABLE `template`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
