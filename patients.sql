-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 19, 2025 at 01:21 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hospital`
--

-- --------------------------------------------------------

--
-- Table structure for table `patients`
--

CREATE TABLE `patients` (
  `Patientname` varchar(30) NOT NULL,
  `Phonenumber` bigint(20) NOT NULL,
  `Address` varchar(50) NOT NULL,
  `DOB` date NOT NULL,
  `Illness` varchar(50) NOT NULL,
  `Insurance` varchar(3) NOT NULL,
  `Datecalled` date NOT NULL,
  `Appointmenttime` time NOT NULL,
  `Doc_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `patients`
--

INSERT INTO `patients` (`Patientname`, `Phonenumber`, `Address`, `DOB`, `Illness`, `Insurance`, `Datecalled`, `Appointmenttime`, `Doc_id`) VALUES
('Dan Lyman', 7098675410, '201 Bellevue Square, Space 201 Bellevue', '2006-07-25', 'Cavity problem', 'No', '2024-08-21', '20:00:00', 111),
('Hermoine Granger', 7098675478, '8 Heathgate, Hampstead Garden, Suburb.', '1979-09-19', 'Epilepsy', 'Yes', '2024-09-02', '09:30:00', 112),
('Megan Hart', 7098675490, '201 Bellevue Square, Space 201 Bellevue', '2017-09-20', 'Cavity problem', 'No', '2024-09-18', '10:00:00', 116),
('Harry Potter', 8089238700, 'Number 4, Privet Drive, Chancellors', '1980-07-31', 'Head Stroke', 'No', '2024-09-02', '10:30:00', 113),
('Wendy Coleman', 8089238785, '2829 Ala Kalanikaumaka, Kukuiula Village Koloa', '2005-01-12', 'Oral Cancer', 'Yes', '2024-10-01', '15:00:00', 117),
('Kyle Wong', 8118109345, '2829 Ala Kalanikaumaka, Kukuiula Village, Koloa', '1994-07-12', 'Impacted teeth', 'No', '2024-10-10', '12:30:00', 115),
('Una Gill', 8125349011, '8F, 4035-1 Ikenobecho, Tsuzuki-ku, Yokohama', '1995-10-18', 'Ataxia', 'Yes', '2024-10-09', '15:00:00', 118),
('Adrian Sutherland', 8147483640, '854 Avocado Ave., Newport Beach ', '2014-09-24', 'Sports Injuries', 'No', '2024-09-17', '10:45:00', 119),
('April Newton', 8170987023, '3750 Wailea Drive Kihei', '1991-01-15', 'Oral Cancer', 'No', '2024-10-16', '16:00:00', 114),
('Sally Mackay', 8170987098, '8F, 5-24-2, Sendagaya, Shibuya-ku', '2004-05-11', 'Muscular Dystrophy', 'Yes', '2024-09-06', '12:00:00', 120),
('Andrea Wright', 8170987123, '15205 North Kierland Blvd. Suite 100', '2014-09-29', 'Osteoporosis', 'No', '2024-09-30', '19:30:00', 121),
('Olivia Morrison', 8170987559, '854 Avocado Ave., Newport Beach ', '2000-12-12', 'Back and Neck Pain', 'No', '2024-10-01', '10:15:00', 122),
('Christan Welch', 8198675410, '8 Heathgate, Hampstead Garden, Suburb.', '1992-08-23', 'Lymphedema', 'Yes', '2024-10-31', '20:30:00', 123),
('Grace Kerr', 8198675419, '201 Bellevue Square, Space 201 Bellevue', '2015-06-30', 'Hypertension', 'No', '2024-11-01', '16:30:00', 124),
('Liam Randall', 8234015670, '298 Beachwalk, Honolulu', '2007-09-12', 'Cardiomyopathies', 'Yes', '2024-11-01', '08:30:00', 125),
('David Rutherford', 8765349012, '2F, 4035-1 Ikenobecho, Tsuzuki-ku, Yokohama', '1990-11-14', 'Heart Stroke', 'Yes', '2024-10-31', '20:00:00', 126),
('Sebastan Hodges', 8765349892, '8F, 4035-1 Ikenobecho, Tsuzuki-ku, Yokohama', '1990-12-25', 'Heart valve disease', 'Yes', '2024-09-26', '09:30:00', 127),
('Austin Vance', 8769054321, '3750 Street, Wailea Drive, Kihei', '1984-09-27', 'Peripheral artery', 'Yes', '2024-08-20', '20:30:00', 128),
('Ron Weasley', 8769054322, '3750 Street, Wailea Drive, Kihei', '1980-03-01', 'Anorexia nervosa', 'No', '2024-09-25', '21:30:00', 129),
('Amelia Edmunds', 8769054330, '3750 Street, Wailea Drive, Kihei', '1996-07-14', 'Bulimia', 'No', '2024-10-09', '17:30:00', 130),
('Draco Malfoy', 8905349012, '2F, 4035-1 Ikenobecho, Tsuzuki-ku, Yokohama', '1996-10-08', 'Binge-eating disorder', 'Yes', '2024-10-18', '14:15:00', 131),
('Rebeus Hagrid', 8924015600, '298 Beachwalk, Honolulu', '1986-09-10', 'Pica', 'Yes', '2024-10-17', '19:45:00', 132),
('Elizabeth Kelly', 8924015670, '298 Beachwalk, Honolulu', '2024-11-02', 'Rumination disorder', 'Yes', '2024-10-09', '17:00:00', 133),
('Draco Malfoy', 9123456780, 'Mumbai', '2014-10-14', 'Cavity Problem', 'No', '2024-10-18', '14:30:00', 111),
('Victor Harris', 9497601886, '298 Beachwalk Honolulu', '2004-04-19', 'Multiple Sclerosis', 'No', '2024-10-04', '09:00:00', 134),
('Julia Turner', 9798109345, '15205 North Kierland Blvd. Suite 100', '1998-12-09', 'Parkinson\'s disorder', 'Yes', '2024-09-20', '20:00:00', 135);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `patients`
--
ALTER TABLE `patients`
  ADD PRIMARY KEY (`Phonenumber`),
  ADD KEY `fn_key` (`Doc_id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `patients`
--
ALTER TABLE `patients`
  ADD CONSTRAINT `fn_key` FOREIGN KEY (`Doc_id`) REFERENCES `doctor` (`Doc_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
