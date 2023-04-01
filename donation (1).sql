-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3310
-- Generation Time: Oct 12, 2021 at 06:34 PM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 7.3.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `donation`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `email` text NOT NULL,
  `password` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `email`, `password`) VALUES
(1, 'admin@admin.com', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `donator`
--

CREATE TABLE `donator` (
  `d_id` int(11) NOT NULL,
  `d_uname` text NOT NULL,
  `d_pass` text NOT NULL,
  `address` text NOT NULL,
  `contact` text NOT NULL,
  `email` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `donator`
--

INSERT INTO `donator` (`d_id`, `d_uname`, `d_pass`, `address`, `contact`, `email`) VALUES
(1, 'Vishal', 'VJJ', 'Address wer', '877454', 'vishalwankhede44@gmail.com'),
(2, 'Donator', '12345', 'Donator Address', '8989787898', 'vv@gg.com');

-- --------------------------------------------------------

--
-- Table structure for table `food_meal`
--

CREATE TABLE `food_meal` (
  `fm_id` int(11) NOT NULL,
  `fm_type` text NOT NULL,
  `fm_desc` text NOT NULL,
  `fm_quantity` text NOT NULL,
  `v_id` int(11) DEFAULT NULL,
  `d_id` int(11) NOT NULL,
  `o_id` int(11) NOT NULL,
  `fm_date` text NOT NULL,
  `p_address` text NOT NULL,
  `status` text NOT NULL,
  `contactNumber` text NOT NULL,
  `feedback` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `food_meal`
--

INSERT INTO `food_meal` (`fm_id`, `fm_type`, `fm_desc`, `fm_quantity`, `v_id`, `d_id`, `o_id`, `fm_date`, `p_address`, `status`, `contactNumber`, `feedback`) VALUES
(1, 'Dal Tadka', 'Fresh Food', 'For 20 People', 6, 1, 1, '03/10/2021 20:38:19', '', 'Delivered', '', 'TESTING FEEDBACK'),
(2, 'Veg', 'Dal Rice', 'For 10 kids', 0, 1, 2, '04/10/2021 09:11:44', 'Shivajinagar,Pune', 'Rejected', '7898789878', 'Service was good'),
(3, 'Veg', 'Fresh Food', 'For 50 Kids', 6, 1, 2, '04/10/2021 18:33:41', 'Near Park,Pune', 'Delivered', '9878987855', 'Working Fine'),
(7, 'Veg Curry', 'Meal Desc', 'for 10 kids', 6, 2, 2, '04/10/2021 23:36:41', 'Pickup from Home', 'Delivered', '9878654598', 'Working Fine'),
(8, 'Palak Paneer', 'Fresh Food', 'For 25 Kids', 6, 1, 2, '10/10/2021 14:24:48', 'Pune', 'Delivered', '7972117756', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `orphanage`
--

CREATE TABLE `orphanage` (
  `o_id` int(11) NOT NULL,
  `o_name` text NOT NULL,
  `o_address` text NOT NULL,
  `o_contact` text NOT NULL,
  `o_desc` text NOT NULL,
  `o_email` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `orphanage`
--

INSERT INTO `orphanage` (`o_id`, `o_name`, `o_address`, `o_contact`, `o_desc`, `o_email`) VALUES
(1, 'Matoshree Orphanage', 'Near Jalgaon', '7878787', 'For Aged peoples', 'matoshree@gmail.com'),
(2, 'Save The Children', '16, Shivaji Nagar, Pune', '9998887771', 'For Children\'s', 'svc@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `volunteer`
--

CREATE TABLE `volunteer` (
  `v_id` int(11) NOT NULL,
  `d_uname` text NOT NULL,
  `contact` text NOT NULL,
  `d_pass` text NOT NULL,
  `d_email` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `volunteer`
--

INSERT INTO `volunteer` (`v_id`, `d_uname`, `contact`, `d_pass`, `d_email`) VALUES
(6, 'Vishal Wankhede', '78989789', 'Vishal', 'vw7@gmail.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `donator`
--
ALTER TABLE `donator`
  ADD PRIMARY KEY (`d_id`),
  ADD UNIQUE KEY `email` (`email`) USING HASH;

--
-- Indexes for table `food_meal`
--
ALTER TABLE `food_meal`
  ADD PRIMARY KEY (`fm_id`);

--
-- Indexes for table `orphanage`
--
ALTER TABLE `orphanage`
  ADD PRIMARY KEY (`o_id`),
  ADD UNIQUE KEY `o_email` (`o_email`) USING HASH;

--
-- Indexes for table `volunteer`
--
ALTER TABLE `volunteer`
  ADD PRIMARY KEY (`v_id`),
  ADD UNIQUE KEY `d_email` (`d_email`) USING HASH;

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `donator`
--
ALTER TABLE `donator`
  MODIFY `d_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `food_meal`
--
ALTER TABLE `food_meal`
  MODIFY `fm_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `orphanage`
--
ALTER TABLE `orphanage`
  MODIFY `o_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `volunteer`
--
ALTER TABLE `volunteer`
  MODIFY `v_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
