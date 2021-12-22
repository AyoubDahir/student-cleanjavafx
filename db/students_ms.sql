-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 22, 2021 at 04:28 PM
-- Server version: 10.4.13-MariaDB
-- PHP Version: 7.4.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `students ms`
--

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `id` int(100) NOT NULL,
  `fullname` varchar(100) NOT NULL,
  `address` varchar(100) NOT NULL,
  `phone` varchar(100) NOT NULL,
  `gender` varchar(100) NOT NULL,
  `status` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`id`, `fullname`, `address`, `phone`, `gender`, `status`) VALUES
(90, 'jamac', 'hargeis', '3333', 'male', 'deleted'),
(91, 'salim', 'hargeish', '3333', 'male', 'deleted'),
(92, 'ayuub', 'hargeis', '3333', 'male', 'available'),
(93, 'guhaad', 'hargeis', '3333', 'male', 'deleted'),
(94, 'Mohamed Saalim', 'Sh Madar', '0633225567', 'male', 'available'),
(95, 'MHassan', 'Sh Madar', '0633225567', 'male', 'available'),
(96, 'Hassan', 'Hero', '6729202', 'male', 'deleted'),
(97, 'Hassan', 'Hero', '6729202', 'male', 'deleted'),
(98, 'Hassan', 'Hero', '6729202', 'male', 'deleted'),
(99, 'Hassan', 'Hero', '6729202', 'male', 'deleted'),
(100, 'Hassan', 'Hero', '6729202', 'male', 'deleted'),
(101, 'Hassan', 'Hero', '6729202', 'male', 'deleted'),
(102, 'Hassan', 'Hero', '6729202', 'male', 'deleted'),
(103, 'daahir Mohamed', 'Hargeia ', '62718910', 'male', 'available');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=104;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
