-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Waktu pembuatan: 06 Jan 2019 pada 17.18
-- Versi server: 10.1.37-MariaDB
-- Versi PHP: 7.2.12

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
-- Struktur dari tabel `tbl_bencana`
--

CREATE TABLE `tbl_bencana` (
  `id_bencana` int(11) NOT NULL,
  `judul_bencana` text NOT NULL,
  `deskripsi_bencana` text NOT NULL,
  `tanggal_posting` date NOT NULL,
  `tumnel` varchar(100) NOT NULL,
  `total_donasi` int(11) NOT NULL,
  `id_penggalangdana` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tbl_bencana`
--

INSERT INTO `tbl_bencana` (`id_bencana`, `judul_bencana`, `deskripsi_bencana`, `tanggal_posting`, `tumnel`, `total_donasi`, `id_penggalangdana`) VALUES
(1, 'Gempa bumi Lombok', 'sebuah gempa darat berkekuatan 6,4 yang melanda Pulau Lombok, Indonesia. Pusat gempa berada di 47 km timur laut Kota Mataram, Nusa Tenggara Barat dengan kedalaman 24 km. Guncangan gempa bumi dirasakan di seluruh wilayah Pulau Lombok, Pulau Bali, dan Pulau Sumbawa.\r\n\r\nGempa ini merupakan rangkaian gempa awal sebelum gempa bermagnitudo lebih besar mengguncang Lombok pada 5 Agustus 2018', '2018-07-29', 'file_1546621428.jpg', 0, 1),
(5, 'dsadas', 'asdsadas', '2018-11-23', 'file_1542967595.png', 0, 1),
(6, 'gempa', 'gempa', '2019-01-04', 'file_1546612200.jpg', 0, 1);

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_donatur`
--

CREATE TABLE `tbl_donatur` (
  `id_donatur` int(11) NOT NULL,
  `id_pengguna` int(11) NOT NULL,
  `nama_donatur` text NOT NULL,
  `foto_donatur` text NOT NULL,
  `telepon_donatur` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tbl_donatur`
--

INSERT INTO `tbl_donatur` (`id_donatur`, `id_pengguna`, `nama_donatur`, `foto_donatur`, `telepon_donatur`) VALUES
(2, 1, 'jhon cena', 'asdashdag.jpg', 123456789),
(3, 0, 'andhika', '', 1234578979),
(4, 0, 'andhika', '', 1234578979),
(5, 0, 'test', '', 1234578979),
(6, 0, 'test1', '', 1234578979),
(7, 0, 'popo', '', 85291028575),
(8, 0, 'andhikap', '', 85431661694);

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_penggalangdana`
--

CREATE TABLE `tbl_penggalangdana` (
  `id_penggalangdana` int(11) NOT NULL,
  `foto_ktp` text NOT NULL,
  `nama_bank` text NOT NULL,
  `nomer_rekening` varchar(20) NOT NULL,
  `nama_penggalangdana` text NOT NULL,
  `alamat` text NOT NULL,
  `telepon` varchar(20) NOT NULL,
  `nama_rekening` text NOT NULL,
  `password` text NOT NULL,
  `email` text NOT NULL,
  `id_role` int(11) NOT NULL,
  `status` text NOT NULL,
  `deskripsi_penggalangdana` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tbl_penggalangdana`
--

INSERT INTO `tbl_penggalangdana` (`id_penggalangdana`, `foto_ktp`, `nama_bank`, `nomer_rekening`, `nama_penggalangdana`, `alamat`, `telepon`, `nama_rekening`, `password`, `email`, `id_role`, `status`, `deskripsi_penggalangdana`) VALUES
(1, 'file_1544005987.jpg', 'BRI', '91838471371298', 'jhon cena', 'jlnin aja', '0852372137191', '0', '12345', 'test3@gmaIl.com', 2, '1', 'coba aha'),
(2, 'file_1546621940.jpg', 'bri', '12312321', 'asdasda', 'asdasds', '23123123', '0', '123', 'test1@gmail.com', 2, '1', 'testing 3'),
(4, 'file_1546621990.jpg', 'bri', '3215323432', 'test', 'test', '084782428', '0', '123', 'test@gmail.com', 2, '1', 'testing'),
(5, 'file_1546621569.jpg', 'bri1', '68678965745', 'test1', 'test', '45747475474', '0', '1234', 'test2@gmail.com', 2, '1', 'coba');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_pengguna`
--

CREATE TABLE `tbl_pengguna` (
  `id_pengguna` int(11) NOT NULL,
  `email` text NOT NULL,
  `password` text NOT NULL,
  `id_role` int(100) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `status` text NOT NULL,
  `nomor_telephone` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tbl_pengguna`
--

INSERT INTO `tbl_pengguna` (`id_pengguna`, `email`, `password`, `id_role`, `nama`, `status`, `nomor_telephone`) VALUES
(1, 'admin@gmail.com', '123456789', 1, 'admin', '1', 0),
(2, 'agus@gmail.com', '12345', 2, 'agus', '1', 0),
(3, 'aja@gmail.com', '1234567890', 2, 'aja', '1', 0),
(4, 'astaga@gmail.com', '12345', 2, 'astaga', '1', 0),
(5, 'inyoman@gmail.com', 'cobaaja', 2, 'i nyoman', '1', 0);

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_rekening`
--

CREATE TABLE `tbl_rekening` (
  `id_rekening` int(11) NOT NULL,
  `nama_bank` varchar(100) NOT NULL,
  `image_bank` varchar(100) NOT NULL,
  `nomer_rekening` text NOT NULL,
  `atas_nama` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tbl_rekening`
--

INSERT INTO `tbl_rekening` (`id_rekening`, `nama_bank`, `image_bank`, `nomer_rekening`, `atas_nama`) VALUES
(1, 'a', '', '7567545524324235', 'asdaggegeeg');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_role`
--

CREATE TABLE `tbl_role` (
  `id_role` int(11) NOT NULL,
  `role` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tbl_role`
--

INSERT INTO `tbl_role` (`id_role`, `role`) VALUES
(1, 'Admnistrator'),
(2, 'Penggalang Dana'),
(3, 'Donatur');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_transaksi`
--

CREATE TABLE `tbl_transaksi` (
  `id_transaksi` int(11) NOT NULL,
  `id_pengguna` int(11) NOT NULL,
  `id_bencana` int(11) NOT NULL,
  `nominal` double NOT NULL,
  `kode_unik` int(11) NOT NULL,
  `status` tinyint(1) NOT NULL,
  `tanggal_transaksi` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tbl_transaksi`
--

INSERT INTO `tbl_transaksi` (`id_transaksi`, `id_pengguna`, `id_bencana`, `nominal`, `kode_unik`, `status`, `tanggal_transaksi`) VALUES
(1, 2, 5, 50000, 0, 0, '0000-00-00'),
(2, 1, 5, 25000, 0, 0, '0000-00-00');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `tbl_bencana`
--
ALTER TABLE `tbl_bencana`
  ADD PRIMARY KEY (`id_bencana`),
  ADD KEY `id_penggalangdana` (`id_penggalangdana`);

--
-- Indeks untuk tabel `tbl_donatur`
--
ALTER TABLE `tbl_donatur`
  ADD PRIMARY KEY (`id_donatur`);

--
-- Indeks untuk tabel `tbl_penggalangdana`
--
ALTER TABLE `tbl_penggalangdana`
  ADD PRIMARY KEY (`id_penggalangdana`),
  ADD KEY `id_role` (`id_role`);

--
-- Indeks untuk tabel `tbl_pengguna`
--
ALTER TABLE `tbl_pengguna`
  ADD PRIMARY KEY (`id_pengguna`),
  ADD KEY `id_role` (`id_role`);

--
-- Indeks untuk tabel `tbl_rekening`
--
ALTER TABLE `tbl_rekening`
  ADD PRIMARY KEY (`id_rekening`);

--
-- Indeks untuk tabel `tbl_role`
--
ALTER TABLE `tbl_role`
  ADD PRIMARY KEY (`id_role`);

--
-- Indeks untuk tabel `tbl_transaksi`
--
ALTER TABLE `tbl_transaksi`
  ADD PRIMARY KEY (`id_transaksi`),
  ADD KEY `id_bencana` (`id_bencana`),
  ADD KEY `id_pengguna` (`id_pengguna`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `tbl_bencana`
--
ALTER TABLE `tbl_bencana`
  MODIFY `id_bencana` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT untuk tabel `tbl_donatur`
--
ALTER TABLE `tbl_donatur`
  MODIFY `id_donatur` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT untuk tabel `tbl_penggalangdana`
--
ALTER TABLE `tbl_penggalangdana`
  MODIFY `id_penggalangdana` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT untuk tabel `tbl_pengguna`
--
ALTER TABLE `tbl_pengguna`
  MODIFY `id_pengguna` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT untuk tabel `tbl_rekening`
--
ALTER TABLE `tbl_rekening`
  MODIFY `id_rekening` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT untuk tabel `tbl_role`
--
ALTER TABLE `tbl_role`
  MODIFY `id_role` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT untuk tabel `tbl_transaksi`
--
ALTER TABLE `tbl_transaksi`
  MODIFY `id_transaksi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `tbl_bencana`
--
ALTER TABLE `tbl_bencana`
  ADD CONSTRAINT `tbl_bencana_ibfk_1` FOREIGN KEY (`id_penggalangdana`) REFERENCES `tbl_penggalangdana` (`id_penggalangdana`);

--
-- Ketidakleluasaan untuk tabel `tbl_penggalangdana`
--
ALTER TABLE `tbl_penggalangdana`
  ADD CONSTRAINT `tbl_penggalangdana_ibfk_1` FOREIGN KEY (`id_role`) REFERENCES `tbl_role` (`id_role`);

--
-- Ketidakleluasaan untuk tabel `tbl_pengguna`
--
ALTER TABLE `tbl_pengguna`
  ADD CONSTRAINT `tbl_pengguna_ibfk_1` FOREIGN KEY (`id_role`) REFERENCES `tbl_role` (`id_role`);

--
-- Ketidakleluasaan untuk tabel `tbl_transaksi`
--
ALTER TABLE `tbl_transaksi`
  ADD CONSTRAINT `tbl_transaksi_ibfk_1` FOREIGN KEY (`id_bencana`) REFERENCES `tbl_bencana` (`id_bencana`),
  ADD CONSTRAINT `tbl_transaksi_ibfk_2` FOREIGN KEY (`id_pengguna`) REFERENCES `tbl_pengguna` (`id_pengguna`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
