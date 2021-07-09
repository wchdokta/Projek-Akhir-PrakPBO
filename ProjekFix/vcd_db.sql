-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 05 Jul 2021 pada 15.27
-- Versi server: 10.4.6-MariaDB
-- Versi PHP: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `vcd_db`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `penyewa`
--

CREATE TABLE `penyewa` (
  `nm_cust` varchar(15) NOT NULL,
  `nm_vcd` varchar(15) NOT NULL,
  `biaya` int(20) NOT NULL,
  `status` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `vcd`
--

CREATE TABLE `vcd` (
  `nm_vcd` varchar(30) NOT NULL,
  `harga` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `vcd`
--

INSERT INTO `vcd` (`nm_vcd`, `harga`) VALUES
('ironman', 1),
('PSS Sleman', 5),
('q', 3),
('s', 1);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `penyewa`
--
ALTER TABLE `penyewa`
  ADD UNIQUE KEY `nm_vcd` (`nm_vcd`);

--
-- Indeks untuk tabel `vcd`
--
ALTER TABLE `vcd`
  ADD UNIQUE KEY `judul` (`nm_vcd`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
