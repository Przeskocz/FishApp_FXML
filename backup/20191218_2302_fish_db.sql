-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 18 Gru 2019, 23:01
-- Wersja serwera: 10.4.8-MariaDB
-- Wersja PHP: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `fish_db`
--
CREATE DATABASE IF NOT EXISTS `fish_db` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `fish_db`;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `connect_fish_piscary`
--

DROP TABLE IF EXISTS `connect_fish_piscary`;
CREATE TABLE `connect_fish_piscary` (
  `cfp_id` int(11) NOT NULL,
  `cfp_fish_id` int(11) NOT NULL COMMENT 'ID z tabeli Fish',
  `cfp_piscary_id` int(11) NOT NULL COMMENT 'ID z tabeli Piscary'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `connect_fish_piscary`
--

INSERT INTO `connect_fish_piscary` (`cfp_id`, `cfp_fish_id`, `cfp_piscary_id`) VALUES
(1, 1, 1),
(2, 2, 1),
(3, 3, 1),
(4, 4, 1),
(5, 5, 1),
(6, 6, 1),
(7, 7, 1),
(8, 8, 1),
(16, 1, 3),
(17, 2, 3),
(18, 4, 3),
(19, 6, 3),
(20, 7, 3),
(21, 8, 3),
(22, 1, 4),
(23, 2, 4),
(24, 3, 4),
(25, 4, 4),
(26, 5, 4),
(27, 6, 4),
(28, 7, 4);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `fish`
--

DROP TABLE IF EXISTS `fish`;
CREATE TABLE `fish` (
  `fish_id` int(11) NOT NULL,
  `fish_species` varchar(35) NOT NULL COMMENT 'Gatunek ryby',
  `fish_type` varchar(35) NOT NULL COMMENT 'Typ ryby',
  `fish_weight_from` int(11) NOT NULL COMMENT 'Waga od',
  `fish_weight_to` int(11) NOT NULL COMMENT 'Waga do'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `fish`
--

INSERT INTO `fish` (`fish_id`, `fish_species`, `fish_type`, `fish_weight_from`, `fish_weight_to`) VALUES
(1, 'Karp', 'HERBIVORE', 1, 25),
(2, 'Amur', 'HERBIVORE', 1, 15),
(3, 'Jesiotr', 'HERBIVORE', 2, 15),
(4, 'Szczupak', 'MEAT_EATER', 1, 10),
(5, 'Karaś', 'HERBIVORE', 1, 3),
(6, 'Płoć', 'HERBIVORE', 1, 2),
(7, 'Okoń', 'MEAT_EATER', 1, 2),
(8, 'Sum', 'SCAVENGER', 5, 40);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `piscary`
--

DROP TABLE IF EXISTS `piscary`;
CREATE TABLE `piscary` (
  `piscary_id` int(11) NOT NULL,
  `piscary_area` double(4,2) NOT NULL COMMENT 'Powierzchnia [ha]',
  `piscary_name` varchar(50) NOT NULL COMMENT 'Nazwa',
  `piscary_address` varchar(100) NOT NULL COMMENT 'Adres',
  `piscary_contact` varchar(20) NOT NULL COMMENT 'Kontakt',
  `piscary_hour_from` int(11) DEFAULT NULL COMMENT 'Godziny otwarcia od',
  `piscary_hour_to` int(11) DEFAULT NULL COMMENT 'Godziny otwarcia do',
  `piscary_price_day` int(11) DEFAULT NULL COMMENT 'Cena za dzień',
  `piscary_price_night` int(11) DEFAULT NULL COMMENT 'Cena za noc',
  `piscary_count_rod` int(11) DEFAULT NULL COMMENT 'Maksymalna liczba wędek',
  `piscary_booking_slot` tinyint(1) DEFAULT NULL COMMENT 'Wymagana rezerwacja (true/false)',
  `piscary_effective_bait` varchar(255) DEFAULT NULL COMMENT 'Efektywne przynęty'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `piscary`
--

INSERT INTO `piscary` (`piscary_id`, `piscary_area`, `piscary_name`, `piscary_address`, `piscary_contact`, `piscary_hour_from`, `piscary_hour_to`, `piscary_price_day`, `piscary_price_night`, `piscary_count_rod`, `piscary_booking_slot`, `piscary_effective_bait`) VALUES
(1, 5.00, 'Nad stawami', 'Siedliska 10', '+48 754 220 272', 7, 19, 30, 30, 3, 1, NULL),
(3, 3.40, 'Ranczo nad jeziorkiem', 'Czarna 803', '+48 665 921 994', 10, 16, 25, 25, 2, 1, NULL),
(4, 2.70, 'Staw u Domina', 'Harta 32', '+48 341 664 343', 6, 18, 20, 20, 2, 1, NULL),
(5, 6.40, 'Hurko', 'Przemyśl 43', '+48 839 843 754', 7, 19, 25, 25, 2, 1, '[Ljava.lang.String;@7eda2dbb');

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `connect_fish_piscary`
--
ALTER TABLE `connect_fish_piscary`
  ADD PRIMARY KEY (`cfp_id`),
  ADD KEY `fk_fish` (`cfp_fish_id`),
  ADD KEY `fk_piscary` (`cfp_piscary_id`);

--
-- Indeksy dla tabeli `fish`
--
ALTER TABLE `fish`
  ADD PRIMARY KEY (`fish_id`);

--
-- Indeksy dla tabeli `piscary`
--
ALTER TABLE `piscary`
  ADD PRIMARY KEY (`piscary_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `connect_fish_piscary`
--
ALTER TABLE `connect_fish_piscary`
  MODIFY `cfp_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT dla tabeli `fish`
--
ALTER TABLE `fish`
  MODIFY `fish_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT dla tabeli `piscary`
--
ALTER TABLE `piscary`
  MODIFY `piscary_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `connect_fish_piscary`
--
ALTER TABLE `connect_fish_piscary`
  ADD CONSTRAINT `fk_fish` FOREIGN KEY (`cfp_fish_id`) REFERENCES `fish` (`fish_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_piscary` FOREIGN KEY (`cfp_piscary_id`) REFERENCES `piscary` (`piscary_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
