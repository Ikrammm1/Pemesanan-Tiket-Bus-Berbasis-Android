-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 11 Jun 2022 pada 14.27
-- Versi server: 10.4.22-MariaDB
-- Versi PHP: 7.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `e-bus`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `bus`
--

CREATE TABLE `bus` (
  `id_bus` int(11) NOT NULL,
  `nama_bus` varchar(100) NOT NULL,
  `slot` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `bus`
--

INSERT INTO `bus` (`id_bus`, `nama_bus`, `slot`) VALUES
(1, 'Putra Remaja', 30),
(2, 'Rosalia Indah', 45);

-- --------------------------------------------------------

--
-- Struktur dari tabel `kategori`
--

CREATE TABLE `kategori` (
  `id_kategori` int(11) NOT NULL,
  `kategori` enum('Ekonomi','VIP') NOT NULL,
  `harga_kategori` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `kategori`
--

INSERT INTO `kategori` (`id_kategori`, `kategori`, `harga_kategori`) VALUES
(1, 'Ekonomi', 50000),
(2, 'VIP', 100000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `rute`
--

CREATE TABLE `rute` (
  `id_rute` int(11) NOT NULL,
  `rute` varchar(100) NOT NULL,
  `harga_rute` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `rute`
--

INSERT INTO `rute` (`id_rute`, `rute`, `harga_rute`) VALUES
(1, 'SMRG-JOG', 80000),
(2, 'JOG-JKT', 150000),
(3, 'LMPG-JKT', 200000),
(4, 'JOG-BNDG', 180000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksi`
--

CREATE TABLE `transaksi` (
  `id_transaksi` int(11) NOT NULL,
  `nama_pembeli` varchar(100) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_kategori` int(11) NOT NULL,
  `id_rute` int(11) NOT NULL,
  `id_bus` int(11) NOT NULL,
  `keberangkatan` date NOT NULL,
  `jam` time NOT NULL,
  `status` enum('ok','no') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `transaksi`
--

INSERT INTO `transaksi` (`id_transaksi`, `nama_pembeli`, `id_user`, `id_kategori`, `id_rute`, `id_bus`, `keberangkatan`, `jam`, `status`) VALUES
(1, 'Ikram', 1, 2, 1, 2, '2022-12-01', '11:00:00', 'ok'),
(2, 'surya', 1, 2, 1, 2, '2022-12-01', '11:00:00', 'ok'),
(8, 'Riski', 1, 1, 2, 1, '2022-10-11', '16:00:00', 'ok'),
(9, 'surya', 1, 2, 1, 2, '2022-12-01', '11:00:00', 'ok'),
(13, 'bima', 2, 1, 1, 1, '2022-06-12', '16:00:00', 'ok'),
(19, 'Halimah', 2, 1, 4, 2, '2022-06-06', '16:00:00', 'ok'),
(24, 'Coba', 2, 2, 1, 1, '2022-12-12', '11:00:00', 'ok'),
(25, 'Yogi', 2, 2, 3, 1, '2022-12-11', '11:00:00', 'ok'),
(26, 'Muna', 2, 1, 3, 1, '2022-12-11', '16:00:00', 'ok'),
(27, 'C2', 1, 1, 2, 1, '2022-01-01', '16:00:00', 'ok'),
(42, 'Muhammad Septianor', 2, 1, 4, 2, '2022-06-07', '16:00:00', 'ok'),
(101, 'Abim Maulana', 2, 1, 1, 1, '2022-07-06', '16:00:00', 'ok'),
(102, 'Ramadhan', 2, 1, 1, 2, '2022-06-07', '16:00:00', 'ok'),
(107, 'bisma', 1, 2, 3, 1, '2022-12-12', '16:00:00', 'ok'),
(108, 'Abim', 2, 1, 2, 2, '2022-12-01', '16:00:00', 'ok'),
(109, 'Nafisatur Ramadhan', 3, 2, 3, 1, '2022-08-06', '11:00:00', 'ok'),
(110, 'Muhammad Septianur', 22, 1, 1, 2, '2022-06-06', '16:00:00', 'ok'),
(112, 'Ibrahim', 22, 2, 1, 2, '2022-06-06', '16:00:00', 'no'),
(114, 'ikram123', 1, 2, 2, 2, '2022-06-06', '16:00:00', 'ok'),
(116, 'Riski2', 1, 1, 1, 2, '2022-06-06', '16:00:00', 'ok');

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `id_user` int(11) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `no_hp` varchar(50) NOT NULL,
  `alamat` varchar(250) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`id_user`, `nama`, `no_hp`, `alamat`, `email`, `password`) VALUES
(1, 'ikram', '08123456789', 'Kalimantan Selatan', 'ikram', 'ikram'),
(2, 'abim', '082255341234', 'Kalimantan Timur', 'apaaja', 'coba'),
(3, 'Ramadhan', '08123456789', 'Aceh', 'Ramadhan', 'user'),
(22, 'Septianur', '08133123456', 'Kalimantan Timur', 'septi@gmail', 'septi'),
(23, 'Ryyyy Abiyantoro', '0821718721', 'Lampung', 'aku@gmail.com', 'wkwkwk'),
(24, 'ikram2', '087654337865', 'kalsel', 'ikram2@', '1234');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `bus`
--
ALTER TABLE `bus`
  ADD PRIMARY KEY (`id_bus`);

--
-- Indeks untuk tabel `kategori`
--
ALTER TABLE `kategori`
  ADD PRIMARY KEY (`id_kategori`);

--
-- Indeks untuk tabel `rute`
--
ALTER TABLE `rute`
  ADD PRIMARY KEY (`id_rute`);

--
-- Indeks untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id_transaksi`),
  ADD KEY `relasi1` (`id_user`),
  ADD KEY `relasi2` (`id_kategori`),
  ADD KEY `relasi3` (`id_rute`),
  ADD KEY `relasi4` (`id_bus`);

--
-- Indeks untuk tabel `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `bus`
--
ALTER TABLE `bus`
  MODIFY `id_bus` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT untuk tabel `kategori`
--
ALTER TABLE `kategori`
  MODIFY `id_kategori` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT untuk tabel `rute`
--
ALTER TABLE `rute`
  MODIFY `id_rute` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `id_transaksi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=117;

--
-- AUTO_INCREMENT untuk tabel `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `relasi1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`),
  ADD CONSTRAINT `relasi2` FOREIGN KEY (`id_kategori`) REFERENCES `kategori` (`id_kategori`),
  ADD CONSTRAINT `relasi3` FOREIGN KEY (`id_rute`) REFERENCES `rute` (`id_rute`),
  ADD CONSTRAINT `relasi4` FOREIGN KEY (`id_bus`) REFERENCES `bus` (`id_bus`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
