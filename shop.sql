-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1
-- Время создания: Окт 05 2017 г., 12:38
-- Версия сервера: 5.5.55-log
-- Версия PHP: 5.6.8

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- База данных: `shop`
--

-- --------------------------------------------------------

--
-- Структура таблицы `brands`
--

CREATE TABLE IF NOT EXISTS `brands` (
  `id` varchar(32) CHARACTER SET utf8 NOT NULL,
  `brand` varchar(32) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `brands`
--

INSERT INTO `brands` (`id`, `brand`) VALUES
('active', 'Active'),
('beloli', 'Beloli-Belali'),
('berehynya', 'Берегиня'),
('bg', 'B&G'),
('bistfor', 'Bistfor'),
('malvy', 'Мальвы');

-- --------------------------------------------------------

--
-- Структура таблицы `categories`
--

CREATE TABLE IF NOT EXISTS `categories` (
  `id` varchar(32) NOT NULL,
  `categories` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK92a74cs1m2va8vqnp9mno5w0c` (`categories`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `categories`
--

INSERT INTO `categories` (`id`, `categories`) VALUES
('sandals', 'Босоножки'),
('boot', 'Ботинки'),
('gumshoes', 'Кеды'),
('snickers', 'Кроссовки'),
('slippers', 'Тапочки'),
('flats', 'Туфли');

-- --------------------------------------------------------

--
-- Структура таблицы `gender`
--

CREATE TABLE IF NOT EXISTS `gender` (
  `id` varchar(32) NOT NULL,
  `gender` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `gender`
--

INSERT INTO `gender` (`id`, `gender`) VALUES
('boy', 'Для мальчиков'),
('girl', 'Для девочек');

-- --------------------------------------------------------

--
-- Структура таблицы `liner_materials`
--

CREATE TABLE IF NOT EXISTS `liner_materials` (
  `id` varchar(32) NOT NULL,
  `liner_material` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `liner_materials`
--

INSERT INTO `liner_materials` (`id`, `liner_material`) VALUES
('eco-leather', 'Эко-кожа'),
('fur', 'Мех'),
('leather', 'Кожа'),
('nubuck', 'Нубук'),
('patent_leather', 'Лакированная кожа'),
('suede', 'Замша'),
('textile', 'Текстиль'),
('wool', 'Шерсть');

-- --------------------------------------------------------

--
-- Структура таблицы `orders`
--

CREATE TABLE IF NOT EXISTS `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL,
  `product_brand` varchar(64) NOT NULL,
  `product_model` varchar(64) NOT NULL,
  `product_size` int(11) NOT NULL,
  `product_price` int(11) NOT NULL,
  `product_quantity` int(11) NOT NULL,
  `username` varchar(64) NOT NULL,
  `user_email` varchar(64) NOT NULL,
  `user_phonenumber` varchar(64) NOT NULL,
  `date` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Структура таблицы `products`
--

CREATE TABLE IF NOT EXISTS `products` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `brand_id` varchar(32) NOT NULL,
  `gender_id` varchar(32) NOT NULL,
  `liner_material_id` varchar(32) NOT NULL,
  `upper_material_id` varchar(32) NOT NULL,
  `category_id` varchar(32) NOT NULL,
  `model` varchar(32) NOT NULL,
  `price` int(11) NOT NULL,
  `quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKa3a4mpsfdf4d2y6r8ra3sc8mv` (`brand_id`),
  KEY `FKog2rp4qthbtt2lfyhfo32lsw9` (`category_id`),
  KEY `FK218pgeyeyhf8c0qi67tlcshq7` (`gender_id`),
  KEY `FK88aei7pj5dwmoftxsek76jdh8` (`liner_material_id`),
  KEY `FKht59t2cdpl3kc7y632k9ch4hp` (`upper_material_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;

--
-- Дамп данных таблицы `products`
--

INSERT INTO `products` (`id`, `brand_id`, `gender_id`, `liner_material_id`, `upper_material_id`, `category_id`, `model`, `price`, `quantity`) VALUES
(1, 'beloli', 'girl', 'leather', 'leather', 'flats', '1864', 640, NULL),
(2, 'berehynya', 'girl', 'leather', 'leather', 'flats', '0650', 825, NULL),
(3, 'bistfor', 'girl', 'leather', 'leather', 'flats', '54001', 1195, NULL),
(4, 'bg', 'boy', 'leather', 'leather', 'sandals', 'BG170-119', 495, NULL),
(5, 'berehynya', 'boy', 'wool', 'leather', 'boot', '1318', 895, NULL),
(6, 'active', 'boy', 'textile', 'textile', 'snickers', '08-175', 350, NULL),
(7, 'malvy', 'girl', 'leather', 'leather', 'flats', '373-388', 870, NULL),
(8, 'beloli', 'girl', 'leather', 'eco-leather', 'flats', '2924', 645, NULL);

-- --------------------------------------------------------

--
-- Структура таблицы `products_size`
--

CREATE TABLE IF NOT EXISTS `products_size` (
  `products_id` int(11) NOT NULL,
  `size_id` int(11) NOT NULL,
  PRIMARY KEY (`products_id`,`size_id`),
  KEY `FK6v3d9ihk9xql4co59ddjtv8l7` (`size_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `products_size`
--

INSERT INTO `products_size` (`products_id`, `size_id`) VALUES
(2, 29),
(4, 29),
(5, 29),
(2, 30),
(1, 31),
(2, 31),
(7, 31),
(1, 32),
(4, 32),
(1, 33),
(4, 33),
(7, 33),
(8, 33),
(1, 34),
(2, 34),
(3, 34),
(5, 34),
(6, 34),
(8, 34),
(1, 35),
(1, 36),
(3, 36),
(4, 37),
(6, 37);

-- --------------------------------------------------------

--
-- Структура таблицы `size`
--

CREATE TABLE IF NOT EXISTS `size` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `size` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=40 ;

--
-- Дамп данных таблицы `size`
--

INSERT INTO `size` (`id`, `size`) VALUES
(21, '21'),
(22, '22'),
(23, '23'),
(24, '24'),
(25, '25'),
(26, '26'),
(27, '27'),
(28, '28'),
(29, '29'),
(30, '30'),
(31, '31'),
(32, '32'),
(33, '33'),
(34, '34'),
(35, '35'),
(36, '36'),
(37, '37'),
(38, '38'),
(39, '39');

-- --------------------------------------------------------

--
-- Структура таблицы `upper_materials`
--

CREATE TABLE IF NOT EXISTS `upper_materials` (
  `id` varchar(32) NOT NULL,
  `upper_material` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `upper_materials`
--

INSERT INTO `upper_materials` (`id`, `upper_material`) VALUES
('eco-leather', 'Эко-кожа'),
('leather', 'Кожа'),
('nubuck', 'Нубук'),
('patent_leather', 'Лакированная кожа'),
('suede', 'Замша'),
('textile', 'Текстиль');

-- --------------------------------------------------------

--
-- Структура таблицы `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(32) NOT NULL,
  `email` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `name` varchar(32) NOT NULL,
  `region` varchar(12) NOT NULL,
  `feedback` varchar(255) NOT NULL,
  `gender` varchar(4) NOT NULL,
  `phonenumber` varchar(32) NOT NULL,
  `success` bit(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- Дамп данных таблицы `users`
--

INSERT INTO `users` (`id`, `login`, `email`, `password`, `name`, `region`, `feedback`, `gender`, `phonenumber`, `success`) VALUES
(1, '_WHALE_', 'maksim12288@meta.ua', 'f703780618443a3df8c0b3554617d9dd', 'Maksym', 'UA', 'Call me pls', 'M', '0509691471', b'0'),
(2, 'whale', 'maks@ukr.net', '2af9b1ba42dc5eb01743e6b3759b6e4b', 'MAKS', 'UA', 'aaaaa', 'M', '0501722168', b'0'),
(5, 'Admin', 'maksim12288@yandex.ru', 'f703780618443a3df8c0b3554617d9dd', 'Max', 'USA', '-->', 'M', '0501722168', b'0'),
(6, '_Luska_', 'luska2@i.ua', 'f703780618443a3df8c0b3554617d9dd', 'Luda', 'UA', '-->', 'F', '0501111455', b'0');

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `FK218pgeyeyhf8c0qi67tlcshq7` FOREIGN KEY (`gender_id`) REFERENCES `gender` (`id`),
  ADD CONSTRAINT `FK88aei7pj5dwmoftxsek76jdh8` FOREIGN KEY (`liner_material_id`) REFERENCES `liner_materials` (`id`),
  ADD CONSTRAINT `FKa3a4mpsfdf4d2y6r8ra3sc8mv` FOREIGN KEY (`brand_id`) REFERENCES `brands` (`id`),
  ADD CONSTRAINT `FKht59t2cdpl3kc7y632k9ch4hp` FOREIGN KEY (`upper_material_id`) REFERENCES `upper_materials` (`id`),
  ADD CONSTRAINT `FKog2rp4qthbtt2lfyhfo32lsw9` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`);

--
-- Ограничения внешнего ключа таблицы `products_size`
--
ALTER TABLE `products_size`
  ADD CONSTRAINT `FK6v3d9ihk9xql4co59ddjtv8l7` FOREIGN KEY (`size_id`) REFERENCES `size` (`id`),
  ADD CONSTRAINT `FKh6lqof5chxth430aq6eyqnru6` FOREIGN KEY (`products_id`) REFERENCES `products` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
