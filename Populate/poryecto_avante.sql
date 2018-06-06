-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 25-05-2018 a las 09:54:46
-- Versión del servidor: 5.5.24-log
-- Versión de PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `poryecto_avante`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administrador`
--

CREATE TABLE IF NOT EXISTS `administrador` (
  `nombre` varchar(50) NOT NULL,
  `apellidos` varchar(50) NOT NULL,
  `contraseña` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `avatar` varchar(200) DEFAULT NULL,
  `rol` enum('USUARIO','ADMINISTRADOR') NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `administrador`
--

INSERT INTO `administrador` (`nombre`, `apellidos`, `contraseña`, `email`, `avatar`, `rol`, `id`) VALUES
('Pepe', 'Pepote', 'pepe', 'pepe@gmail.com', 'http://static.alfabetajuega.com/abj_public_files/multimedia/imagenes/alfabetajuega-pepe-the-frog-1-151217.jpg', 'ADMINISTRADOR', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `banner`
--

CREATE TABLE IF NOT EXISTS `banner` (
  `imagen` varchar(200) DEFAULT NULL,
  `enlace` varchar(200) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=27 ;

--
-- Volcado de datos para la tabla `banner`
--

INSERT INTO `banner` (`imagen`, `enlace`, `id`) VALUES
('www.pepeblog.com', 'www.google.com', 22),
('www.sevillafc.com', 'www.rbb.com', 23),
('www.marca.com', 'www.estadiodeportivo.com', 24),
('www.elmundo.es', 'https://www.google.com/search?q=bu&ie=utf-8&oe=utf-8&client=firefox-b-ab', 25),
('www.abc.es', 'www.abcdesevilla.es', 26);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comentario`
--

CREATE TABLE IF NOT EXISTS `comentario` (
  `titulo` varchar(50) NOT NULL,
  `texto` varchar(1000) NOT NULL,
  `fecha` date NOT NULL,
  `positivos` int(11) NOT NULL,
  `negativos` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `id_publicacion` int(11) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `id_usuario` (`id_usuario`,`id_publicacion`),
  KEY `id_usuario_2` (`id_usuario`),
  KEY `id_usuario_3` (`id_usuario`),
  KEY `id_publicacion` (`id_publicacion`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=22 ;

--
-- Volcado de datos para la tabla `comentario`
--

INSERT INTO `comentario` (`titulo`, `texto`, `fecha`, `positivos`, `negativos`, `id_usuario`, `id_publicacion`, `id`) VALUES
('Comentario 1', 'Este es el comentario 1', '2025-05-18', 200, 100, 4, 6, 14),
('Comentario 2', 'Este es el comentario 2', '2025-05-18', 2, 10, 5, 6, 15),
('Comentario 3', 'Este es el comentario 3', '2025-05-18', 12, 4, 2, 6, 16),
('Comentario 4', 'Este es el comentario 4', '2018-04-20', 28, 100, 3, 8, 17),
('Comentario 5', 'Este es el comentario 5', '2018-04-20', 78, 10, 4, 8, 18),
('Comentario 6', 'Este es el comentario 6', '2018-04-20', 212, 56, 2, 8, 19),
('Comentario 7', 'Este es el comentario 7', '2002-05-19', 200, 100, 4, 6, 20),
('Comentario 8', 'Este es el comentario 8', '2002-05-19', 2, 10, 5, 6, 21);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `configuracion`
--

CREATE TABLE IF NOT EXISTS `configuracion` (
  `longitud_titulo` int(11) NOT NULL,
  `longitud_mensaje` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `configuracion`
--

INSERT INTO `configuracion` (`longitud_titulo`, `longitud_mensaje`) VALUES
(50, 1000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `publicacion`
--

CREATE TABLE IF NOT EXISTS `publicacion` (
  `titulo` varchar(50) NOT NULL,
  `descripcion` varchar(2000) NOT NULL,
  `etiqueta` varchar(200) NOT NULL,
  `fecha` date NOT NULL,
  `valoracion` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `id_usuario` (`id_usuario`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=14 ;

--
-- Volcado de datos para la tabla `publicacion`
--

INSERT INTO `publicacion` (`titulo`, `descripcion`, `etiqueta`, `fecha`, `valoracion`, `id_usuario`, `id`) VALUES
('Lorem ipsum dolor sit amet consectetur', 'Adipiscing elit mus erat, lacinia sed mollis a. Tristique nam cursus dui nullam lacus imperdiet dapibus metus tortor laoreet, mi netus interdum penatibus montes habitant egestas porttitor tincidunt libero, non augue ornare sagittis volutpat eget ante cum euismod. At risus tempus nam egestas purus accumsan nullam eleifend posuere, leo dui ridiculus dictumst sed justo orci interdum viverra, eros donec elementum placerat curabitur cubilia duis vitae.', 'Vamos-buenaPublicacion', '2025-05-18', 2, 2, 6),
('Nullam scelerisque congue ad euismod volutpat', 'taciti duis cras vehicula id accumsan magnis suscipit, auctor donec per tempus egestas ultrices mollis posuere. Diam habitasse duis facilisi nam himenaeos in conubia praesent nostra consequat, integer ante fringilla natoque habitant risus hac hendrerit porttitor lacinia euismod, aliquam taciti montes eleifend netus fermentum tortor morbi pulvinar. Quisque scelerisque per dictum torquent montes nam condimentum pellentesque ultricies neque viverra, cras feugiat ad semper cum primis integer non cubilia sodales, cursus sollicitudin eros elementum fringilla class rhoncus urna ac netus.', 'laMejor', '2002-05-18', 3, 2, 7),
('XCOM 2 y Trials Fusion son tus juegos de PlayStation Plus para junio', 'Hola a todos! El verano, esa época de tardes largas de relax, comidas fuera de casa y vacaciones familiares bajo el sol, está a la vuelta de la esquina. Esperamos que tengas grandes planes para los próximos meses y que, mientras disfrutas del bueno tiempo, no te olvides de tu querida PlayStation. Cuando llueva (que seguro que pasa) o se ponga el sol (algo inevitable), necesitarás un amigo con algo de encanto ‘interior’ para entretenerte. Por suerte, estaremos contigo todo el verano, ofreciéndote grandes juegos cada mes con PlayStation Plus, así que, llueva o brille el sol, ¡puedes contar con nosotros!', 'Fiesta-cerveza', '2025-05-19', 1, 3, 8),
('La cuenta atrás de PlayStation para E3 2018 empieza el miércoles 6 de junio', 'Atención, llega otra vez el E3! PlayStation tiene montones de novedades que anunciar. Tantas, de hecho, que empezaremos un poco antes. El plato principal será la PlayStation E3 2018 Showcase, que empezará la madrugada del martes 12 de junio a las 3 h CEST. Míralo en directo en playstation.com/e3.', 'vamos', '2025-05-18', 2, 4, 9),
('Lorem ipsum dolor sit amet consectetur', 'Esta es la publicacion 5', 'Cosas-masCosas', '2025-06-18', 0, 4, 10),
('Lorem ipsum dolor sit amet consectetur', 'Esta es la publicacion 6', 'masCosas', '2022-02-18', 5, 4, 11),
('Lorem ipsum dolor sit amet consectetur', 'Esta es la publicacion 7', 'buenaPublicacion', '2012-11-18', 2, 5, 12),
('Lorem ipsum dolor sit amet consectetur', 'Esta es la publicacion 8', 'bu ', '2002-05-18', 3, 5, 13);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `nombre` varchar(20) NOT NULL,
  `apellidos` varchar(50) NOT NULL,
  `contraseña` varchar(50) NOT NULL,
  `email` varchar(200) NOT NULL,
  `avatar` varchar(200) DEFAULT NULL,
  `rol` enum('USUARIO','ADMINISTRADOR') DEFAULT NULL,
  `mensajebaneo` varchar(600) DEFAULT NULL,
  `estado` enum('BANEADO','SUSCRITO','NO_SUSCRITO') DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`nombre`, `apellidos`, `contraseña`, `email`, `avatar`, `rol`, `mensajebaneo`, `estado`, `id`) VALUES
('Juan Carlos', 'Cansino Suarez', 'bu', 'jucansu@gmail.com', 'www.google.com', 'USUARIO', '', 'SUSCRITO', 2),
('Antonio', 'Lopez', 'bu', 'antonio@gmail.com', 'www.google.com', 'USUARIO', 'Estas baneado', 'BANEADO', 3),
('Maite', 'Rodriguez', 'bu', 'maite@gmail.com', 'www.google.com', 'USUARIO', '', 'NO_SUSCRITO', 4),
('Laura', 'Perez', 'bu', 'laura@gmail.com', 'www.google.com', 'USUARIO', '', 'SUSCRITO', 5);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `comentario`
--
ALTER TABLE `comentario`
  ADD CONSTRAINT `comentario_ibfk_2` FOREIGN KEY (`id_publicacion`) REFERENCES `publicacion` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `comentario_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `publicacion`
--
ALTER TABLE `publicacion`
  ADD CONSTRAINT `publicacion_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
