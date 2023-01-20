-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 20 Oca 2023, 22:49:48
-- Sunucu sürümü: 10.4.27-MariaDB
-- PHP Sürümü: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `test`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `project`
--

CREATE TABLE `project` (
  `stok_id` int(11) NOT NULL,
  `stok_kodu` varchar(55) NOT NULL,
  `stok_adi` varchar(30) NOT NULL,
  `stok_tipi` varchar(2) NOT NULL,
  `stok_birim` varchar(10) NOT NULL,
  `stok_barkod` varchar(30) NOT NULL,
  `stok_kdv` varchar(4) NOT NULL,
  `stok_aciklama` varchar(30) NOT NULL,
  `stok_tarih` varchar(21) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Tablo döküm verisi `project`
--

INSERT INTO `project` (`stok_id`, `stok_kodu`, `stok_adi`, `stok_tipi`, `stok_birim`, `stok_barkod`, `stok_kdv`, `stok_aciklama`, `stok_tarih`) VALUES
(2, 'LAPTOP99X', 'LAPTOP', '2', '1', 'LAPTOPXX1', '18', 'ACER LAPTOP', '21.01.2023'),
(3, 'MNTR11', 'DELL MONITOR', '2', '1', '432123', '18', 'DELL 75HZ MONITOR', '21.01.2023'),
(4, 'LAPTOPX!', 'MSI LAPTOP', '4', '1', 'MSIX1321', '18', 'MSI 16GB RAM 3070', '21.01.2023'),
(5, 'LAPTOPASUX2', 'ASUS LAPTOP', '2', '3', 'ASUS324X2', '18', 'ASUS 16GB RAM 1060 GPU', '21.02.2023');

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `project`
--
ALTER TABLE `project`
  ADD PRIMARY KEY (`stok_id`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `project`
--
ALTER TABLE `project`
  MODIFY `stok_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
