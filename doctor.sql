-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 21, 2017 at 04:12 AM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `doctor`
--

-- --------------------------------------------------------

--
-- Table structure for table `appointments`
--

CREATE TABLE `appointments` (
  `booking_id` int(11) NOT NULL,
  `doc_id` int(6) NOT NULL,
  `ddate` varchar(30) NOT NULL,
  `dtime` varchar(30) NOT NULL,
  `patient_name` varchar(120) NOT NULL,
  `mobile` varchar(20) NOT NULL,
  `dob` varchar(20) NOT NULL,
  `country` varchar(120) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `dday` varchar(20) NOT NULL,
  `doc_name` varchar(120) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `appointments`
--

INSERT INTO `appointments` (`booking_id`, `doc_id`, `ddate`, `dtime`, `patient_name`, `mobile`, `dob`, `country`, `gender`, `dday`, `doc_name`) VALUES
(1, 4, 'Sep 13 2017', '01:00', 'imran', '923349089147', '2017-09-12', 'Pakistan', 'Female', 'Wed', 'Salman'),
(2, 4, 'Sep 13 2017', '01:45', 'imran', '923349089147', '2017-09-20', 'Pakistan', 'Female', 'Wed', 'Salman'),
(3, 4, 'Sep 13 2017', '02:00', 'imran', '923349089147', '2017-09-20', 'Pakistan', 'Female', 'Wed', 'Salman'),
(4, 4, 'Sep 13 2017', '02:15', 'imranuddin', '923349089147', '2017-09-19', 'Pakistan', 'Female', 'Wed', 'Salman'),
(5, 4, 'Sep 13 2017', '08:00', 'imranuddin', '923349089147', '2017-09-19', 'Pakistan', 'Female', 'Wed', 'Salman'),
(6, 4, 'Sep 13 2017', '02:30', 'waqas', '923349089147', '2017-09-13', 'Pakistan', 'Female', 'Wed', 'Salman'),
(7, 4, 'Sep 13 2017', '02:45', 'waqas', '923349089147', '2017-09-13', 'Pakistan', 'Female', 'Wed', 'Salman'),
(8, 4, 'Sep 13 2017', '03:00', 'waqas', '923349089147', '2017-09-13', 'Pakistan', 'Female', 'Wed', 'Salman'),
(9, 4, 'Sep 13 2017', '03:45', 'waqas', '923349089147', '2017-09-13', 'Pakistan', 'Female', 'Wed', 'Salman'),
(10, 4, 'Sep 13 2017', '04:30', 'waqas', '923349089147', '2017-09-13', 'Pakistan', 'Female', 'Wed', 'Salman'),
(11, 4, 'Sep 13 2017', '10:30', '11', '923349089147', '2017-09-13', 'Pakistan', 'Female', 'Wed', 'Salman'),
(12, 2, 'Sep 27 2017', '02:00', '12313', '923349089147', '2017-09-05', 'Pakistan', 'Female', 'Wed', 'Adil');

-- --------------------------------------------------------

--
-- Table structure for table `clinic`
--

CREATE TABLE `clinic` (
  `clinic_id` int(4) NOT NULL,
  `name` varchar(180) NOT NULL,
  `lat` double NOT NULL,
  `lng` double NOT NULL,
  `address` varchar(250) NOT NULL,
  `type` varchar(50) NOT NULL,
  `facilities` varchar(250) NOT NULL,
  `timmings` varchar(120) NOT NULL,
  `contact` varchar(80) NOT NULL,
  `cell` varchar(80) NOT NULL,
  `email` varchar(80) NOT NULL,
  `picture` varchar(120) NOT NULL,
  `district` varchar(80) NOT NULL,
  `tehsil` varchar(80) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `clinic`
--

INSERT INTO `clinic` (`clinic_id`, `name`, `lat`, `lng`, `address`, `type`, `facilities`, `timmings`, `contact`, `cell`, `email`, `picture`, `district`, `tehsil`) VALUES
(5, 'Rehman Medical Institute', 33.992405553423296, 71.43576622009277, 'Rehman Medical Institute 5-B/2, Phase-V,ØŒ Peshawar', 'hospital', 'All', '24 Hours', '(091) 5838000', '(091) 5838000', 'info@rmi.edu.pk', 'uploads/rmi.jpg', '16', 'Peshawar'),
(4, 'Northwest General Hospital & Research Center', 33.99400671093899, 71.43598079681396, 'Sector A-3, Phase 5ØŒ Passport Office RoadØŒ HayatabadØŒ Peshawar 25100', 'hospital', 'All', 'Open 24 hours', '(091) 5838800', '(091)111583880 ', 'info@nwgh.pk', 'uploads/north_west.jpg', '16', 'Peshawar');

-- --------------------------------------------------------

--
-- Table structure for table `district`
--

CREATE TABLE `district` (
  `district_id` int(3) NOT NULL DEFAULT '0',
  `name` varchar(40) NOT NULL,
  `province_id` int(3) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `district`
--

INSERT INTO `district` (`district_id`, `name`, `province_id`) VALUES
(1, 'Chitral', 1),
(2, 'Upper Dir', 1),
(3, ' Lower Dir', 1),
(4, ' Bunner', 1),
(5, ' Swat', 1),
(6, ' Shangla', 1),
(7, ' Malakand', 1),
(8, ' Kohistan', 1),
(9, ' Batagram', 1),
(10, 'Mansehra', 1),
(11, 'Abbottabad', 1),
(12, ' Haripur', 1),
(13, 'Mardan', 1),
(14, ' Swabi', 1),
(15, ' Charsadda', 1),
(16, ' Peshawar', 1),
(17, ' Nowshera', 1),
(18, 'Kohat', 1),
(19, 'Hangu', 1),
(20, 'Karak', 1),
(21, 'Bannu', 1),
(22, 'Lakki Marwat', 1),
(23, 'D.I. Khan', 1),
(24, 'Tank', 1),
(25, 'Kohat District', 1),
(26, 'Tank District', 1),
(27, 'Bannu District', 1),
(28, 'Bajaur Agency', 1),
(29, 'Khyber Agency', 1),
(30, 'Mohmand Agency', 1),
(31, ' Kurram Agency', 1),
(32, 'North Waziristan Agency', 1),
(33, 'Sourth Waziristan Agency', 1),
(34, 'Orakzai Agency', 1),
(35, 'Attock', 2),
(36, 'Rawalpindi', 2),
(37, 'Jhelum', 2),
(38, 'Chakwal', 2),
(39, 'Sargodha', 2),
(40, 'Bhakkar', 2),
(41, 'Khushab', 2),
(42, 'Mianwali', 2),
(43, 'Faisalabad', 2),
(44, 'Jhang', 2),
(45, 'Toba Tek Singh', 2),
(46, 'Gujranwala', 2),
(47, 'Hafizabad', 2),
(48, 'Gujrat', 2),
(49, 'Mandi Bahauddin', 2),
(50, 'Sialkot', 2),
(51, 'Narowal', 2),
(52, 'Lahore', 2),
(53, 'Kasur', 2),
(54, 'Okara', 2),
(55, 'Sheikhupura', 2),
(56, 'Vehari', 2),
(57, 'Sahiwal', 2),
(58, 'Pak Pattan', 2),
(59, 'Multan', 2),
(60, 'Lodhran', 2),
(61, 'Khanewal', 2),
(62, 'D.G. Khan', 2),
(63, 'Rajanpur', 2),
(64, 'Layyah', 2),
(65, 'Muzaffargarh', 2),
(66, 'Bahawalpur', 2),
(67, ' Bahawalnagar', 2),
(68, 'Rahim Yar Khan', 2),
(69, ' Jaccobabad', 3),
(70, 'Shikarpur', 3),
(71, 'Larkana', 3),
(72, 'Sukkur', 3),
(73, 'Ghotki', 3),
(74, 'Khairpur', 3),
(75, 'Naushahro Feroze', 3),
(76, 'Nawab Shah', 3),
(77, 'Dadu', 3),
(78, 'Hyderabad', 3),
(79, 'Badin', 3),
(80, 'Thatta', 3),
(81, 'Sanghar', 3),
(82, 'Mirpurkhas', 3),
(83, 'Umerkot', 3),
(84, 'Tharparkar', 3),
(85, 'Karachi East', 3),
(86, 'Karachi West', 3),
(87, ' Karachi South', 3),
(88, 'Karachi Central', 3),
(89, 'Malir', 3),
(90, 'Quetta', 5),
(91, 'Pashin', 5),
(92, 'Killa Abdullah', 5),
(93, 'Chagai', 5),
(94, 'LoraLai', 5),
(95, 'Barkhan', 5),
(96, 'Musakhel', 5),
(97, 'Killa Saifullah', 5),
(98, 'Zhob', 5),
(99, 'Sibi', 5),
(100, 'Ziarat', 5),
(101, 'Kohlu', 5),
(102, 'Dera Bughti', 5),
(103, 'Jaffarabad', 5),
(104, 'Nasirabad', 5),
(105, 'Bolan', 5),
(106, 'Jhal Magsi', 5),
(107, 'Kalat', 5),
(108, 'Mastung', 5),
(109, 'Khuzdar', 5),
(110, 'Awaran', 5),
(111, 'Kharan', 5),
(112, 'Lasbela', 5),
(113, 'Kech', 5),
(114, 'Gwadar', 5),
(115, 'Panjgur', 5),
(116, 'Azad Kashmir', 5),
(117, 'Bhimber ', 5),
(118, ' Mirpur', 5),
(119, 'Sudhnoti', 5),
(120, 'Poonch ', 5),
(121, 'Muzaffarabad ', 5),
(122, 'Bagh ', 5),
(123, 'Kotli ', 5),
(124, 'Gilgit ', 4),
(125, 'Ghizer', 4),
(126, 'Baltistan ', 4),
(127, 'Ghanchee ', 4),
(128, 'Diamir ', 4),
(-1, 'Select District', -1);

-- --------------------------------------------------------

--
-- Table structure for table `markers`
--

CREATE TABLE `markers` (
  `id` int(5) NOT NULL,
  `name` varchar(80) NOT NULL,
  `address` varchar(180) NOT NULL,
  `specialization` varchar(120) NOT NULL,
  `details` varchar(250) NOT NULL,
  `clinic` int(4) NOT NULL,
  `timming` varchar(80) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `cell` varchar(20) NOT NULL,
  `usermail` varchar(20) NOT NULL,
  `userpw` varchar(20) NOT NULL,
  `fee` int(11) NOT NULL,
  `lat` double NOT NULL,
  `lng` double NOT NULL,
  `pic` varchar(180) NOT NULL,
  `mon_morning_start` varchar(8) NOT NULL,
  `mon_morning_end` varchar(8) NOT NULL,
  `mon_evening_start` varchar(8) NOT NULL,
  `mon_evening_end` varchar(8) NOT NULL,
  `tue_morning_start` varchar(8) NOT NULL,
  `tue_morning_end` varchar(8) NOT NULL,
  `tue_evening_start` varchar(8) NOT NULL,
  `tue_evening_end` varchar(8) NOT NULL,
  `wed_morning_start` varchar(8) NOT NULL,
  `wed_morning_end` varchar(8) NOT NULL,
  `wed_evening_start` varchar(8) NOT NULL,
  `wed_evening_end` varchar(8) NOT NULL,
  `thu_morning_start` varchar(8) NOT NULL,
  `thu_morning_end` varchar(8) NOT NULL,
  `thu_evening_start` varchar(8) NOT NULL,
  `thu_evening_end` varchar(8) NOT NULL,
  `fri_morning_start` varchar(8) NOT NULL,
  `fri_morning_end` varchar(8) NOT NULL,
  `fri_evening_start` varchar(8) NOT NULL,
  `fri_evening_end` varchar(8) NOT NULL,
  `sat_morning_start` varchar(8) NOT NULL,
  `sat_morning_end` varchar(8) NOT NULL,
  `sat_evening_start` varchar(8) NOT NULL,
  `sat_evening_end` varchar(8) NOT NULL,
  `sun_morning_start` varchar(8) NOT NULL,
  `sun_morning_end` varchar(8) NOT NULL,
  `sun_evening_start` varchar(8) NOT NULL,
  `sun_evening_end` varchar(8) NOT NULL,
  `avg_time` varchar(8) NOT NULL,
  `district` varchar(8) NOT NULL,
  `tehsil` varchar(8) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `markers`
--

INSERT INTO `markers` (`id`, `name`, `address`, `specialization`, `details`, `clinic`, `timming`, `phone`, `cell`, `usermail`, `userpw`, `fee`, `lat`, `lng`, `pic`, `mon_morning_start`, `mon_morning_end`, `mon_evening_start`, `mon_evening_end`, `tue_morning_start`, `tue_morning_end`, `tue_evening_start`, `tue_evening_end`, `wed_morning_start`, `wed_morning_end`, `wed_evening_start`, `wed_evening_end`, `thu_morning_start`, `thu_morning_end`, `thu_evening_start`, `thu_evening_end`, `fri_morning_start`, `fri_morning_end`, `fri_evening_start`, `fri_evening_end`, `sat_morning_start`, `sat_morning_end`, `sat_evening_start`, `sat_evening_end`, `sun_morning_start`, `sun_morning_end`, `sun_evening_start`, `sun_evening_end`, `avg_time`, `district`, `tehsil`) VALUES
(1, 'Imran', 'Hayatabad', 'Dentist', 'asd', 4, '123', '123', '123', 'ali@gmail.com', 'ali', 222, 34.00019756942711, 71.43621683120728, 'uploads/doctor1.jpg', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', '15', '16', 'Peshawar'),
(2, 'Adil', 'HAyatabad', 'Dentist', 'aaa', 5, '24 hr', '123', '123', 'adil@gmail.com', 'adil', 222, 33.99368648184973, 71.43660306930542, 'uploads/doctor2.jpg', '01:00', '01:00', '01:00', '01:00', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', '02:00', '13:00', '05:00', '18:00', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', '15', '16', 'Peshawar'),
(3, 'rafi', 'Hayatabad', 'Dentist', 'asd', 5, '23', '3123', '123', 'rafi@gmail.com', 'rafi', 22, 33.99340183275714, 71.43656015396118, 'uploads/docto3.jpg', '01:00', '13:00', '10:00', '17:00', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', '12:00', '15:00', '17:00', '19:00', '15', '16', 'Peshawar'),
(4, 'Salman', 'hayatabad', 'Dentist', 'asdasd', 4, '23', 'hayatrabad', '123', 'salman@gmail.com', 'salman', 123, 33.992583461303965, 71.43617391586304, 'uploads/docto3.jpg', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', '01:00', '08:00', '09:00', '15:00', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', '15', '16', 'Peshawar');

-- --------------------------------------------------------

--
-- Table structure for table `media`
--

CREATE TABLE `media` (
  `id` int(11) NOT NULL,
  `doc_id` int(11) NOT NULL,
  `media` varchar(120) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `specialization`
--

CREATE TABLE `specialization` (
  `sp_id` int(11) NOT NULL,
  `name` varchar(120) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `specialization`
--

INSERT INTO `specialization` (`sp_id`, `name`) VALUES
(1, 'Dentist'),
(2, 'Dermatologist'),
(3, 'Cardiologist');

-- --------------------------------------------------------

--
-- Table structure for table `tehsil`
--

CREATE TABLE `tehsil` (
  `tehsil_id` int(3) NOT NULL DEFAULT '0',
  `name` varchar(50) NOT NULL,
  `district_id` int(3) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tehsil`
--

INSERT INTO `tehsil` (`tehsil_id`, `name`, `district_id`) VALUES
(1, 'Chitral', 1),
(2, 'Drosh', 1),
(3, 'Lutkoh', 1),
(4, 'Mastuj', 1),
(5, 'Turkoh', 1),
(6, 'Mulkoh', 1),
(7, 'Dir', 2),
(8, 'Barawal', 2),
(9, 'Kohistan', 2),
(10, 'Wari', 2),
(11, 'Khall', 2),
(12, 'Temergara', 3),
(13, 'Balambat', 3),
(14, 'Lalqila', 3),
(15, 'Adenzai', 3),
(16, 'Munda', 3),
(17, 'Samarbagh(Barwa)', 3),
(18, 'Swat', 5),
(19, 'Matta', 5),
(20, 'Alpuri', 6),
(21, 'Besham', 6),
(22, 'Chakesar', 6),
(23, 'Martung', 6),
(24, 'Puran', 6),
(25, 'Daggar/Buner', 4),
(26, 'Swat Ranizai', 7),
(27, 'Sam Ranizai', 7),
(28, 'Dassu', 8),
(29, 'Pattan', 8),
(30, 'Palas', 8),
(31, 'Mansehra', 10),
(32, 'Balakot', 10),
(33, 'Oghi', 10),
(34, 'T.A.Adj.Mansehra Distt.', 10),
(35, 'Batagram', 9),
(36, 'Allai', 9),
(37, 'Abbottabad', 11),
(38, 'Haripur', 12),
(39, 'Ghazi', 12),
(40, 'Mardan', 13),
(41, 'Takht Bhai', 13),
(42, 'Swabi', 14),
(43, 'Lahore', 14),
(44, 'Charsadda', 15),
(45, 'Tangi', 15),
(46, 'Peshawar', 16),
(47, 'Nowshera', 17),
(48, 'Kohat', 18),
(49, 'Lachi', 18),
(50, 'Hangu', 19),
(51, 'Karak', 20),
(52, 'Banda Daud Shah', 20),
(53, 'Takht-E-Nasrati', 20),
(54, 'Bannu', 21),
(55, 'Lakki Marwat', 22),
(56, 'Dera Ismail Khan', 23),
(57, 'Daraban', 23),
(58, 'Paharpur', 23),
(59, 'Kulachi', 23),
(60, 'Tank', 24),
(61, 'Barang', 28),
(62, 'Charmang', 28),
(63, 'Khar Bajaur', 28),
(64, 'Mamund', 28),
(65, 'Salarzai', 28),
(66, 'Utmankhel(Qzafi)', 28),
(67, 'Nawagai ', 28),
(68, 'Halimzai', 30),
(69, 'Pindiali', 30),
(70, 'Safi', 30),
(71, 'Upper Mohmand', 30),
(72, 'Utman Khel(Ambar)', 30),
(73, 'Yake Ghund', 30),
(74, 'Pringhar', 30),
(75, 'Bara', 29),
(76, 'Jamrud', 29),
(77, 'Landi Kotal', 29),
(78, 'Mula Ghori', 29),
(79, 'Lower Kurram', 31),
(80, 'Upper Kurram', 31),
(81, 'Kurram F.R.', 31),
(82, 'Central', 34),
(83, 'Lower', 34),
(84, 'Upper', 34),
(85, 'Ismailzai', 34),
(86, 'Ladha', 33),
(87, 'Makin(Charlai)', 33),
(88, 'Sararogha', 33),
(89, 'Sarwekai', 33),
(90, 'Tiarza', 33),
(91, 'Wana', 33),
(92, 'Toi Khullah', 33),
(93, 'Birmal', 33),
(94, 'Datta Khel', 32),
(95, 'Dossali', 32),
(96, 'Garyum', 32),
(97, 'Ghulam Khan', 32),
(98, 'Mir Ali', 32),
(99, 'Miran Shah', 32),
(100, 'Razmak', 32),
(101, 'Spinwam', 32),
(102, 'Shewa', 32),
(103, 'T.A. Adj. Peshawar District', 32),
(104, 'T.A. Adj. Kohat District', 25),
(105, 'T.A. Adj. Bannu District', 27),
(106, 'T.A. Adj. Lakki Marwat District', 27),
(107, 'T.A. Adj. Tank District', 26),
(108, 'T.A. Adj. D.I.Khan District', 26),
(109, 'Attock', 35),
(110, 'Hassanabdal', 35),
(111, 'Fateh Jang', 35),
(112, 'Pindi Gheb', 35),
(113, 'Jand', 35),
(114, 'Rawalpindi', 36),
(115, 'Taxila', 36),
(116, 'Kahuta', 36),
(117, 'Murree', 36),
(118, 'Kotli Sattian', 36),
(119, 'Gujar Khan', 36),
(120, 'Jhelum', 37),
(121, 'Sohawa', 37),
(122, 'Pind Dadan Khan', 37),
(123, 'Dina', 37),
(124, 'Chakwal', 38),
(125, 'Talagang', 38),
(126, 'Choa Saidan Shah', 38),
(127, 'Sargodha', 39),
(128, 'Sillanwali', 39),
(129, 'Bhalwal', 39),
(130, 'Shahpur', 39),
(131, 'Sahiwal', 39),
(132, 'Kot Momin', 39),
(133, 'Mankera', 40),
(134, 'Kalur Kot', 40),
(135, 'Bhakkar', 40),
(136, 'Darya Khan', 40),
(137, 'Khushab', 41),
(138, 'Nurpur', 41),
(139, 'Mianwali', 42),
(140, 'Isa Khel', 42),
(141, 'Piplan', 42),
(142, 'Faisalabad City', 43),
(143, 'Faisalabad Saddar', 43),
(144, 'Chak Jhumra', 43),
(145, 'Sammundri', 43),
(146, 'Jaranwala', 43),
(147, 'Tandlianwala', 43),
(148, 'Chiniot', 44),
(149, 'Jhang', 44),
(150, 'Shorkot', 44),
(151, 'Toba Tek Singh', 45),
(152, 'Kamalia', 45),
(153, 'Gojra', 45),
(154, 'Wazirabad', 46),
(155, 'Gujranwala City', 46),
(156, 'Gujranwala Saddar', 46),
(157, 'Nowshera Virkan', 46),
(158, 'Kamoki', 46),
(159, 'Hafizabad', 47),
(160, 'Pindi Bhattian', 47),
(161, 'Gujrat', 48),
(162, 'Kharian', 48),
(163, 'Sarai Alamgir', 48),
(164, 'Mandi Bahauddin', 49),
(165, 'Malikwal', 49),
(166, 'Phalia', 49),
(167, 'Sialkot', 50),
(168, 'Daska', 50),
(169, 'Pasrur', 50),
(170, 'Narowal', 51),
(171, 'Shakargarh', 51),
(172, 'Lahore City', 52),
(173, 'Lahore Cantt.', 52),
(174, 'Kasur', 53),
(175, 'Chunian', 53),
(176, 'Pattoki', 53),
(177, 'Okara', 54),
(178, 'Depalpur', 54),
(179, 'Renala Khurd', 54),
(180, 'Ferozewala', 55),
(181, 'Nankana Sahib', 55),
(182, 'Sheikhupura', 55),
(183, 'Safdarabad', 55),
(184, 'Vehari', 56),
(185, 'Burewala', 56),
(186, 'Mailsi', 56),
(187, 'Sahiwal', 57),
(188, 'Chichawatni', 57),
(189, 'Pakpattan', 58),
(190, 'Arifwala', 58),
(191, 'Multan City', 59),
(192, 'Multan Saddar', 59),
(193, 'Shujabad', 59),
(194, 'Jalalpur Pirwala', 59),
(195, 'Lodhran', 60),
(196, 'Kahror Pacca', 60),
(197, 'Dunyapur', 60),
(198, 'Khanewal', 61),
(199, 'Jehanian', 61),
(200, 'Mian Channu', 61),
(201, 'Kabirwala', 61),
(202, 'Dera Ghazi Khan', 62),
(203, 'Taunsa', 62),
(204, 'De-Ex.Area of D.G.Khan', 62),
(205, 'Rajanpur', 63),
(206, 'Rojhan', 63),
(207, 'Jampur', 63),
(208, 'De-Ex.Area of Rajanpur', 63),
(209, 'Leiah', 64),
(210, 'Chaubara', 64),
(211, 'Karor Lal Esan', 64),
(212, 'Muzaffargarh', 65),
(213, 'Alipur', 65),
(214, 'Jatoi', 65),
(215, 'Kot Addu', 65),
(216, 'Hasilpur', 66),
(217, 'Bahawalpur', 66),
(218, 'Yazman', 66),
(219, 'Ahmadpur East', 66),
(220, 'Khairpur Tamewali', 66),
(221, 'Minchinabad', 67),
(222, 'Bahawalnagar', 67),
(223, 'Fort Abbas', 67),
(224, 'Haroonabad', 67),
(225, 'Chishtian', 67),
(226, 'Liaquatpur', 68),
(227, 'Khanpur', 68),
(228, 'Rahim Yar Khan', 68),
(229, 'Sadiqabad', 68),
(230, 'Islamabad', 131),
(231, 'Quetta', 90),
(232, 'Panjpai/S/Teh. ', 90),
(233, 'Pishin', 91),
(234, 'Hurramzai S/Teh.', 91),
(235, 'Barshore S/Teh', 91),
(236, 'Karezat S/Teh', 91),
(237, 'Bostan S/Teh', 91),
(238, 'Killa Abdullah', 92),
(239, 'Gulistan S/Teh', 92),
(240, 'Chaman', 92),
(241, 'Dobandi S/Teh', 92),
(242, 'Nushki', 93),
(243, 'Dalbandin', 93),
(244, 'Chagai S/Teh.', 93),
(245, 'Nokundi S/Teh', 93),
(246, 'Dak S/Teh', 93),
(247, 'Taftan', 93),
(248, 'Loralai/Bori', 94),
(249, 'Mekhtar S/Teh', 94),
(250, 'Duki', 94),
(251, 'Barkhan', 95),
(252, 'Musakhel', 96),
(253, 'Kingri S/Teh', 96),
(254, 'Killa Saifullah', 97),
(255, 'Muslim Bagh', 97),
(256, 'Loiband S/Teh', 97),
(257, 'Baddini S/Teh.', 97),
(258, 'Zhob', 98),
(259, 'Sambaza S/Teh.', 98),
(260, 'Sherani S/Teh', 98),
(261, 'Qamar Din Karez', 98),
(262, 'Ashwat S/Teh.', 98),
(263, 'Sibi', 99),
(264, 'Kutmandai S/Teh.', 99),
(265, 'Sangan S/Teh.', 99),
(266, 'Lehri', 99),
(267, 'Ziarat', 100),
(268, 'Harnai ', 100),
(269, 'Sinjawi S/Teh', 100),
(270, 'Kohlu', 101),
(271, 'Kahan', 101),
(272, 'Mawand', 101),
(273, 'Dera Bugti', 102),
(274, 'Sangsillah S/Teh', 102),
(275, 'Sui', 102),
(276, 'Loti', 102),
(277, 'Phelawagh', 102),
(278, 'Malam S/Teh', 102),
(279, 'Baiker S/Teh', 102),
(280, 'Pir Koh S/Teh', 102),
(281, 'Jhat Pat ', 103),
(282, 'Panhwar S/Teh', 103),
(283, 'Usta Mohammad', 103),
(284, 'Gandaka S/Teh', 103),
(285, 'Chattar', 104),
(286, 'Tamboo', 104),
(287, 'D.M.Jamali', 104),
(288, 'Dhadar', 105),
(289, 'Bhag', 105),
(290, 'Balanari S/Teh', 105),
(291, 'Sani S/Teh.', 105),
(292, 'Khattan S/Teh', 105),
(293, 'Mach ', 105),
(294, 'Gandawa', 130),
(295, 'Mirpur S/Teh', 130),
(296, 'Jhal Magsi', 130),
(297, 'Kalat', 107),
(298, 'Mangochar S/Teh', 107),
(299, 'Johan S/Teh', 107),
(300, 'Surab', 107),
(301, 'Gazg S/Teh', 107),
(302, 'Mastung', 108),
(303, 'Kirdgap S/Teh.', 108),
(304, 'Dasht', 108),
(305, 'Khad Koocha S/Teh.', 108),
(306, 'Khuzdar', 109),
(307, 'Zehri', 109),
(308, 'Moola S/Teh.', 109),
(309, 'Karakh S/Teh.', 109),
(310, 'Nal S/Teh.', 109),
(311, 'Wadh S/Teh.', 109),
(312, 'Ornach S/Teh.', 109),
(313, 'Saroona S/Teh.', 109),
(314, 'Aranji S/Teh.', 109),
(315, 'Mashkai S/Teh.', 110),
(316, 'Awaran', 110),
(317, 'Jhal Jao', 110),
(318, 'Kharan', 111),
(319, 'Besima S/Teh.', 111),
(320, 'Nag S/Teh.', 111),
(321, 'Wasuk S/Teh.', 111),
(322, 'Mashkhel S/Teh.', 111),
(323, 'Bela', 112),
(324, 'Uthal', 112),
(325, 'Lakhra', 112),
(326, 'Liari S/Teh', 112),
(327, 'Hub', 112),
(328, 'Gadani S/Teh.', 112),
(329, 'Sonmiani/Winder', 112),
(330, 'Dureji', 112),
(331, 'Kanraj', 112),
(332, 'Kech', 113),
(333, 'Buleda S/Teh.', 113),
(334, 'Zamuran S/Teh.', 113),
(335, 'Hoshab S/Teh.', 113),
(336, 'Balnigor S/Teh.', 113),
(337, 'Dasht S/Teh.', 113),
(338, 'Tump', 113),
(339, 'Mand S/Teh.', 113),
(340, 'Gwadar', 114),
(341, 'Jiwani', 114),
(342, 'Suntsar S/Teh.', 114),
(343, 'Pasni', 114),
(344, 'Ormara', 114),
(345, 'Panjgur', 115),
(346, 'Parome S/Teh.', 115),
(347, 'Gichk S/Teh.', 115),
(348, 'Gowargo', 115),
(349, 'Jacobabad', 69),
(350, 'Garhi Khairo', 69),
(351, 'Thul', 69),
(352, 'Kandhkot', 69),
(353, 'Kashmor', 69),
(354, 'Shikarpur', 70),
(355, 'Khanrpur', 70),
(356, 'Garhi Yasin', 70),
(357, 'Lakhi', 70),
(358, 'Shahdadkot', 71),
(359, 'Miro Khan', 71),
(360, 'Rato Dero', 71),
(361, 'Larkana', 71),
(362, 'Dokri', 71),
(363, 'Kambar', 71),
(364, 'Warah', 71),
(365, 'Sukkur', 72),
(366, 'Rohri', 72),
(367, 'Pano Aqil', 72),
(368, 'Salehpat', 72),
(369, 'Ghotki', 73),
(370, 'Khangarh', 73),
(371, 'Mirpur Mathelo', 73),
(372, 'Ubauro', 73),
(373, 'Daharki', 73),
(374, 'Khairpur', 74),
(375, 'Kingri', 74),
(376, 'Sobhodero', 74),
(377, 'Gambat', 74),
(378, 'Kot Diji', 74),
(379, 'Mirwah', 74),
(380, 'Faiz Ganj', 74),
(381, 'Nara', 74),
(382, 'Kandioro', 75),
(383, 'Naushahro Feroze', 75),
(384, 'Bhiria', 75),
(385, 'Moro', 75),
(386, 'Sakrand', 76),
(387, 'Nawab Shah', 76),
(388, 'Daulatpur', 76),
(389, 'Mehar', 77),
(390, 'Khairpur Nathan Shah', 77),
(391, 'Sehwan', 77),
(392, 'Dadu', 77),
(393, 'Johi', 77),
(394, 'Kotri', 77),
(395, 'Thano Bula Khan', 77),
(396, 'Hala', 78),
(397, 'Matiari', 78),
(398, 'Tando Allahyar', 78),
(399, 'Hyderabad City', 78),
(400, 'Latifabad', 78),
(401, 'Hyderabad', 78),
(402, 'Qasimabad', 78),
(403, 'Tando Mohammad Khan', 78),
(404, 'Golarchi', 79),
(405, 'Badin', 79),
(406, 'Matli', 79),
(407, 'Tando Bagho', 79),
(408, 'Talhar', 79),
(409, 'Thatta', 80),
(410, 'Mirpur Sakro', 80),
(411, 'Keti Bunder', 80),
(412, 'Ghorabari', 80),
(413, 'Sujawal', 80),
(414, 'Mirpur Bathoro', 80),
(415, 'Jati', 80),
(416, 'Shah Bunder', 80),
(417, 'Kharo Chan', 80),
(418, 'Sanghar', 81),
(419, 'Sinjhoro', 81),
(420, 'Khipro', 81),
(421, 'Shahdadpur', 81),
(422, 'Jam Nawaz Ali', 81),
(423, 'Tando Adam', 81),
(424, 'Mirpur Khas ', 82),
(425, 'Digri', 82),
(426, 'Kot Ghulam Mohammad', 82),
(427, 'Umerkot', 83),
(428, 'Samaro', 83),
(429, 'Kunri', 83),
(430, 'Pithoro', 83),
(431, 'Chachro', 84),
(432, 'Nagar Parkar', 84),
(433, 'Diplo', 84),
(434, 'Mithi ', 84),
(435, 'Entire Urban', 85),
(436, 'Karachi West', 86),
(437, 'Entire Urban', 97),
(438, 'Entire Urban', 88),
(439, 'Malir', 89),
(-1, 'Select Tehsil', -1),
(440, 'Taimargara', 3),
(441, 'xxxxx', 1);

-- --------------------------------------------------------

--
-- Table structure for table `waqas`
--

CREATE TABLE `waqas` (
  `user_id` int(11) NOT NULL,
  `user` varchar(20) NOT NULL,
  `pw` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `waqas`
--

INSERT INTO `waqas` (`user_id`, `user`, `pw`) VALUES
(1, 'admin', 'admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `appointments`
--
ALTER TABLE `appointments`
  ADD PRIMARY KEY (`booking_id`);

--
-- Indexes for table `clinic`
--
ALTER TABLE `clinic`
  ADD PRIMARY KEY (`clinic_id`);

--
-- Indexes for table `markers`
--
ALTER TABLE `markers`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `media`
--
ALTER TABLE `media`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `specialization`
--
ALTER TABLE `specialization`
  ADD PRIMARY KEY (`sp_id`);

--
-- Indexes for table `waqas`
--
ALTER TABLE `waqas`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `appointments`
--
ALTER TABLE `appointments`
  MODIFY `booking_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `clinic`
--
ALTER TABLE `clinic`
  MODIFY `clinic_id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `markers`
--
ALTER TABLE `markers`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `media`
--
ALTER TABLE `media`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `specialization`
--
ALTER TABLE `specialization`
  MODIFY `sp_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `waqas`
--
ALTER TABLE `waqas`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
