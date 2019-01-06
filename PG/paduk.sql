-- phpMyAdmin SQL Dump
-- version 4.8.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 04, 2018 at 01:37 PM
-- Server version: 10.1.30-MariaDB
-- PHP Version: 7.2.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `paduk`
--

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id_role` int(11) NOT NULL,
  `nama_role` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id_role`, `nama_role`) VALUES
(1, 'administrator'),
(2, 'penggalang dana'),
(3, 'donatur');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_bank`
--

CREATE TABLE `tbl_bank` (
  `id_bank` int(11) NOT NULL,
  `nama_bank` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_bank`
--

INSERT INTO `tbl_bank` (`id_bank`, `nama_bank`) VALUES
(1, 'BRI'),
(2, 'BNI'),
(3, 'BCA'),
(4, 'MANDIRI');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_bencana`
--

CREATE TABLE `tbl_bencana` (
  `id_bencana` int(11) NOT NULL,
  `judul_bencana` text NOT NULL,
  `deskripsi_bencana` text NOT NULL,
  `tanggal_posting` date NOT NULL,
  `tumnel` varchar(100) NOT NULL,
  `total_donasi` int(11) NOT NULL,
  `unik_donasi` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_bencana`
--

INSERT INTO `tbl_bencana` (`id_bencana`, `judul_bencana`, `deskripsi_bencana`, `tanggal_posting`, `tumnel`, `total_donasi`, `unik_donasi`) VALUES
(1, 'Gempa bumi Lombok', 'sebuah gempa darat berkekuatan 6,4 yang melanda Pulau Lombok, Indonesia. Pusat gempa berada di 47 km timur laut Kota Mataram, Nusa Tenggara Barat dengan kedalaman 24 km. Guncangan gempa bumi dirasakan di seluruh wilayah Pulau Lombok, Pulau Bali, dan Pulau Sumbawa.\r\n\r\nGempa ini merupakan rangkaian gempa awal sebelum gempa bermagnitudo lebih besar mengguncang Lombok pada 5 Agustus 2018', '2018-07-29', '', 0, 0),
(2, 'qqweq', 'asdasdahdag', '2018-11-08', 'file_1541653101.jpg', 0, 0),
(5, 'dsadas', 'asdsadas', '2018-11-23', 'file_1542967595.png', 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_donasi`
--

CREATE TABLE `tbl_donasi` (
  `id_donasi` int(11) NOT NULL,
  `id_donatur` int(11) NOT NULL,
  `waktu_donasi` date NOT NULL,
  `nominal_donasi` int(11) NOT NULL,
  `foto_donasi` varchar(100) NOT NULL,
  `status_donasi` varchar(100) NOT NULL,
  `id_bencana` int(11) NOT NULL,
  `id_rekening` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_donatur`
--

CREATE TABLE `tbl_donatur` (
  `id_donatur` int(11) NOT NULL,
  `id_pengguna` int(11) NOT NULL,
  `nama_donatur` text NOT NULL,
  `foto_donatur` text NOT NULL,
  `telepon_donatur` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_donatur`
--

INSERT INTO `tbl_donatur` (`id_donatur`, `id_pengguna`, `nama_donatur`, `foto_donatur`, `telepon_donatur`) VALUES
(2, 1, 'jhon cena', 'asdashdag.jpg', 123456789);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_fotobencana`
--

CREATE TABLE `tbl_fotobencana` (
  `id_fotobencana` int(11) NOT NULL,
  `id_bencana` int(11) NOT NULL,
  `nama_foto` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_fotoktp`
--

CREATE TABLE `tbl_fotoktp` (
  `id_fotoktp` int(11) NOT NULL,
  `ktp` int(11) NOT NULL,
  `id_pengggalangdana` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_fotonpwp`
--

CREATE TABLE `tbl_fotonpwp` (
  `id_fotonpwp` int(11) NOT NULL,
  `npwp` text NOT NULL,
  `id_penggalangdana` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_penggalangdana`
--

CREATE TABLE `tbl_penggalangdana` (
  `id_penggalangdana` int(11) NOT NULL,
  `nama_foto` text NOT NULL,
  `nama_bank` text NOT NULL,
  `nomer_rekening` varchar(20) NOT NULL,
  `nama_penggalangdana` text NOT NULL,
  `id_pengguna` int(11) NOT NULL,
  `alamat` text NOT NULL,
  `telepon` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_penggalangdana`
--

INSERT INTO `tbl_penggalangdana` (`id_penggalangdana`, `nama_foto`, `nama_bank`, `nomer_rekening`, `nama_penggalangdana`, `id_pengguna`, `alamat`, `telepon`) VALUES
(1, '', 'BRI', '91838471371298', 'jhon cena', 2, 'jlnin aja', '0852372137191'),
(2, '', 'bri', '12312321', 'asdasda', 2, 'asdasds', '23123123');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_pengguna`
--

CREATE TABLE `tbl_pengguna` (
  `id_pengguna` int(11) NOT NULL,
  `email` text NOT NULL,
  `password` text NOT NULL,
  `id_role` int(100) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `status` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_pengguna`
--

INSERT INTO `tbl_pengguna` (`id_pengguna`, `email`, `password`, `id_role`, `nama`, `status`) VALUES
(1, 'admin@gmail.com', '123456789', 1, 'admin', '1'),
(2, 'agus@gmail.com', '12345', 2, 'agus', '1'),
(3, 'aja@gmail.com', '1234567890', 2, 'aja', '1'),
(4, 'astaga@gmail.com', '12345', 2, 'astaga', '1');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_rekening`
--

CREATE TABLE `tbl_rekening` (
  `id_rekening` int(11) NOT NULL,
  `nama_bank` varchar(100) NOT NULL,
  `image_bank` varchar(100) NOT NULL,
  `nomer_rekening` text NOT NULL,
  `atas_nama` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_rekening`
--

INSERT INTO `tbl_rekening` (`id_rekening`, `nama_bank`, `image_bank`, `nomer_rekening`, `atas_nama`) VALUES
(1, 'a', '', '7567545524324235', 'asdaggegeeg');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_bank`
--
ALTER TABLE `tbl_bank`
  ADD PRIMARY KEY (`id_bank`);

--
-- Indexes for table `tbl_bencana`
--
ALTER TABLE `tbl_bencana`
  ADD PRIMARY KEY (`id_bencana`);

--
-- Indexes for table `tbl_donatur`
--
ALTER TABLE `tbl_donatur`
  ADD PRIMARY KEY (`id_donatur`);

--
-- Indexes for table `tbl_fotoktp`
--
ALTER TABLE `tbl_fotoktp`
  ADD PRIMARY KEY (`id_fotoktp`);

--
-- Indexes for table `tbl_fotonpwp`
--
ALTER TABLE `tbl_fotonpwp`
  ADD PRIMARY KEY (`id_fotonpwp`);

--
-- Indexes for table `tbl_penggalangdana`
--
ALTER TABLE `tbl_penggalangdana`
  ADD PRIMARY KEY (`id_penggalangdana`);

--
-- Indexes for table `tbl_pengguna`
--
ALTER TABLE `tbl_pengguna`
  ADD PRIMARY KEY (`id_pengguna`);

--
-- Indexes for table `tbl_rekening`
--
ALTER TABLE `tbl_rekening`
  ADD PRIMARY KEY (`id_rekening`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_bank`
--
ALTER TABLE `tbl_bank`
  MODIFY `id_bank` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `tbl_bencana`
--
ALTER TABLE `tbl_bencana`
  MODIFY `id_bencana` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `tbl_donatur`
--
ALTER TABLE `tbl_donatur`
  MODIFY `id_donatur` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tbl_fotonpwp`
--
ALTER TABLE `tbl_fotonpwp`
  MODIFY `id_fotonpwp` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbl_penggalangdana`
--
ALTER TABLE `tbl_penggalangdana`
  MODIFY `id_penggalangdana` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tbl_pengguna`
--
ALTER TABLE `tbl_pengguna`
  MODIFY `id_pengguna` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `tbl_rekening`
--
ALTER TABLE `tbl_rekening`
  MODIFY `id_rekening` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
