-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 19, 2021 at 09:14 PM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 8.0.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `agencija_putovanja`
--

-- --------------------------------------------------------

--
-- Table structure for table `destinacija`
--

CREATE TABLE `destinacija` (
  `id_destinacija` int(10) NOT NULL,
  `naziv_destinacije` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `destinacija`
--

INSERT INTO `destinacija` (`id_destinacija`, `naziv_destinacije`) VALUES
(1, 'Indija'),
(2, 'Australija'),
(3, 'USA'),
(4, 'Francuska'),
(5, 'Indonezija'),
(6, 'Japan'),
(7, 'Egipat'),
(8, 'Turska'),
(11, 'Danska');

-- --------------------------------------------------------

--
-- Table structure for table `korisnici`
--

CREATE TABLE `korisnici` (
  `id_korisnika` int(10) NOT NULL,
  `ime` varchar(255) NOT NULL,
  `prezime` varchar(255) NOT NULL,
  `korisnicko_ime` varchar(255) NOT NULL,
  `lozinka` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `korisnici`
--

INSERT INTO `korisnici` (`id_korisnika`, `ime`, `prezime`, `korisnicko_ime`, `lozinka`) VALUES
(1, 'Marija', 'Ciric', 'marija@', 'Mateja74'),
(2, 'Andreja ', 'Ciric', 'andreja@', 'Mateja73'),
(3, 'David', 'Ciric', 'david@', 'Mateja08'),
(4, 'Mateja', 'Ciric', 'mateja@', 'Mateja03'),
(5, 'Nikola', 'Djuricko', 'nikola@', 'Nikola123'),
(6, 'Milan', 'Mladenovic', 'milan@', 'Milan123'),
(7, 'Carli', 'Caplin', 'carli@', 'Carli123'),
(8, 'Zoran', 'Radmilovic', 'zoran@', 'Zoran123');

-- --------------------------------------------------------

--
-- Table structure for table `putovanja`
--

CREATE TABLE `putovanja` (
  `id_putovanja` int(10) NOT NULL,
  `id_korisnika` int(10) NOT NULL,
  `id_destinacija` int(10) NOT NULL,
  `datum_polaska` date NOT NULL,
  `datum_povratka` date NOT NULL,
  `duzina` int(100) NOT NULL,
  `cena` double NOT NULL,
  `id_tip_prevoza` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `putovanja`
--

INSERT INTO `putovanja` (`id_putovanja`, `id_korisnika`, `id_destinacija`, `datum_polaska`, `datum_povratka`, `duzina`, `cena`, `id_tip_prevoza`) VALUES
(1, 1, 1, '2021-06-20', '2021-07-30', 2360, 78000, 1),
(2, 2, 4, '2021-06-13', '2021-06-30', 1700, 56000, 2),
(4, 4, 3, '2021-06-21', '2021-07-09', 5600, 147000, 2),
(5, 1, 4, '2021-08-15', '2021-09-12', 1500, 78000, 1),
(6, 1, 2, '2022-06-12', '2022-08-15', 13050, 250000, 2),
(10, 1, 1, '2021-06-10', '2021-06-24', 15000, 350000, 2),
(11, 1, 1, '2021-06-10', '2021-06-17', 6500, 27000, 1),
(12, 1, 5, '2021-06-08', '2021-06-26', 4500, 7500, 1),
(13, 5, 6, '2021-06-17', '2021-06-24', 4500, 386200, 2),
(14, 3, 4, '2021-08-10', '2021-10-06', 1700, 45000, 1),
(15, 1, 1, '2021-06-12', '2021-06-26', 3500, 125, 2);

-- --------------------------------------------------------

--
-- Table structure for table `tip_prevoza`
--

CREATE TABLE `tip_prevoza` (
  `id_tip_prevoza` int(10) NOT NULL,
  `vrsta_prevoza` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tip_prevoza`
--

INSERT INTO `tip_prevoza` (`id_tip_prevoza`, `vrsta_prevoza`) VALUES
(1, 'Autobus'),
(2, 'Avion');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `destinacija`
--
ALTER TABLE `destinacija`
  ADD PRIMARY KEY (`id_destinacija`);

--
-- Indexes for table `korisnici`
--
ALTER TABLE `korisnici`
  ADD PRIMARY KEY (`id_korisnika`);

--
-- Indexes for table `putovanja`
--
ALTER TABLE `putovanja`
  ADD PRIMARY KEY (`id_putovanja`),
  ADD KEY `id_korisnika` (`id_korisnika`,`id_destinacija`,`id_tip_prevoza`),
  ADD KEY `id_destinacija` (`id_destinacija`),
  ADD KEY `id_tip_prevoza` (`id_tip_prevoza`);

--
-- Indexes for table `tip_prevoza`
--
ALTER TABLE `tip_prevoza`
  ADD PRIMARY KEY (`id_tip_prevoza`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `destinacija`
--
ALTER TABLE `destinacija`
  MODIFY `id_destinacija` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `korisnici`
--
ALTER TABLE `korisnici`
  MODIFY `id_korisnika` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `putovanja`
--
ALTER TABLE `putovanja`
  MODIFY `id_putovanja` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `tip_prevoza`
--
ALTER TABLE `tip_prevoza`
  MODIFY `id_tip_prevoza` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `putovanja`
--
ALTER TABLE `putovanja`
  ADD CONSTRAINT `putovanja_ibfk_1` FOREIGN KEY (`id_korisnika`) REFERENCES `korisnici` (`id_korisnika`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `putovanja_ibfk_2` FOREIGN KEY (`id_destinacija`) REFERENCES `destinacija` (`id_destinacija`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `putovanja_ibfk_3` FOREIGN KEY (`id_tip_prevoza`) REFERENCES `tip_prevoza` (`id_tip_prevoza`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
