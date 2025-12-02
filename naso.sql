-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 24-10-2025 a las 21:23:02
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `naso`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alcaldias`
--

CREATE TABLE `alcaldias` (
  `idalcaldia` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `estado` tinyint(1) DEFAULT 1,
  `fecha_creacion` date NOT NULL,
  `fkciudad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `alcaldias`
--

INSERT INTO `alcaldias` (`idalcaldia`, `nombre`, `direccion`, `telefono`, `email`, `estado`, `fecha_creacion`, `fkciudad`) VALUES
(1, 'Alcaldía de Medellín', 'Calle 50 # 51-50', '4444444', 'contacto@medellin.gov.co', 1, '2025-10-23', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `canes`
--

CREATE TABLE `canes` (
  `idPerro` int(11) NOT NULL,
  `nombre` varchar(200) NOT NULL,
  `codigo` varchar(50) NOT NULL,
  `sexo` enum('M','F') NOT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `peso_actual` double NOT NULL,
  `esterilizado` tinyint(1) DEFAULT 0,
  `imagen_sc` longblob DEFAULT NULL,
  `datos_sc` varchar(500) NOT NULL,
  `observaciones` text DEFAULT NULL,
  `fecha_creacion` timestamp NOT NULL DEFAULT current_timestamp(),
  `estado` tinyint(1) DEFAULT 1,
  `fk_raza` int(11) NOT NULL,
  `fkalcaldia` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `canes`
--

INSERT INTO `canes` (`idPerro`, `nombre`, `codigo`, `sexo`, `fecha_nacimiento`, `peso_actual`, `esterilizado`, `imagen_sc`, `datos_sc`, `observaciones`, `fecha_creacion`, `estado`, `fk_raza`, `fkalcaldia`) VALUES
(2, 'Rocky', 'P001', 'M', NULL, 12.5, 1, NULL, 'Sin registro adicional', NULL, '2025-10-24 15:40:32', 1, 4, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ciudades`
--

CREATE TABLE `ciudades` (
  `idciudad` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `barrio` varchar(50) NOT NULL,
  `estado` tinyint(1) DEFAULT 1,
  `fecha_creacion` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ciudades`
--

INSERT INTO `ciudades` (`idciudad`, `nombre`, `direccion`, `barrio`, `estado`, `fecha_creacion`) VALUES
(1, 'Ciudad Central', 'Calle 123 #45-67', 'Centro', 1, '2025-10-23');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historialvacunas`
--

CREATE TABLE `historialvacunas` (
  `idHistorialVacuna` int(11) NOT NULL,
  `tipo_vacuna` varchar(100) NOT NULL,
  `fecha_aplicacion` date NOT NULL,
  `proxima_dosis` date DEFAULT NULL,
  `lote_vacuna` varchar(50) DEFAULT NULL,
  `veterinario` varchar(100) DEFAULT NULL,
  `observaciones` text DEFAULT NULL,
  `fecha_registro` timestamp NOT NULL DEFAULT current_timestamp(),
  `estado` tinyint(1) DEFAULT 1,
  `fkPerro` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `historialvacunas`
--

INSERT INTO `historialvacunas` (`idHistorialVacuna`, `tipo_vacuna`, `fecha_aplicacion`, `proxima_dosis`, `lote_vacuna`, `veterinario`, `observaciones`, `fecha_registro`, `estado`, `fkPerro`) VALUES
(1, 'Rabia', '2025-10-23', '2026-10-23', 'L1234', 'Dr. Juan Perez', 'Perro saludable', '2025-10-23 05:00:00', 1, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `razas`
--

CREATE TABLE `razas` (
  `idRaza` int(11) NOT NULL,
  `nombre` varchar(200) NOT NULL,
  `color` varchar(50) NOT NULL,
  `tamanio` enum('toy','pequenio','mediano','grande','gigante') NOT NULL,
  `peso_promedio` double NOT NULL,
  `caracteristicas` text DEFAULT NULL,
  `estado` tinyint(1) DEFAULT 1,
  `fecha_creacion` date NOT NULL,
  `caracteristica` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `razas`
--

INSERT INTO `razas` (`idRaza`, `nombre`, `color`, `tamanio`, `peso_promedio`, `caracteristicas`, `estado`, `fecha_creacion`, `caracteristica`) VALUES
(4, 'Labrador Retriever', 'Dorado', 'grande', 30.5, NULL, 1, '2025-10-24', 'Amigable, activo y sociable');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tercero`
--

CREATE TABLE `tercero` (
  `idtercero` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `primer_apellido` varchar(100) NOT NULL,
  `segundo_apellido` varchar(100) DEFAULT NULL,
  `documento` varchar(20) NOT NULL,
  `tipo_documento` varchar(30) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `email` varchar(50) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `direccion` varchar(200) DEFAULT NULL,
  `rol` varchar(50) NOT NULL,
  `estado` tinyint(1) DEFAULT 1,
  `fecha_creacion` timestamp NOT NULL DEFAULT current_timestamp(),
  `fkalcaldia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tercero`
--

INSERT INTO `tercero` (`idtercero`, `nombre`, `primer_apellido`, `segundo_apellido`, `documento`, `tipo_documento`, `fecha_nacimiento`, `email`, `telefono`, `direccion`, `rol`, `estado`, `fecha_creacion`, `fkalcaldia`) VALUES
(1, 'Carlos', 'Rodríguez', 'López', '123456789', '1', '1990-05-09', 'carlos@example.com', '3105678901', 'Calle 123', '1', 1, '2025-10-24 05:00:00', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `idUsuario` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password_hash` varchar(255) NOT NULL,
  `fecha_creacion` timestamp NOT NULL DEFAULT current_timestamp(),
  `ultimo_acceso` timestamp NULL DEFAULT NULL,
  `estado` tinyint(1) DEFAULT 1,
  `fkalcaldia` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`idUsuario`, `username`, `email`, `password_hash`, `fecha_creacion`, `ultimo_acceso`, `estado`, `fkalcaldia`) VALUES
(1, 'juan.perez', 'juan.perez@example.com', '$2a$10$abcdefghijklmnopqrstuvwxyz123456', '2025-10-24 05:00:00', '2025-10-24 14:30:00', 1, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alcaldias`
--
ALTER TABLE `alcaldias`
  ADD PRIMARY KEY (`idalcaldia`),
  ADD KEY `fkciudad` (`fkciudad`);

--
-- Indices de la tabla `canes`
--
ALTER TABLE `canes`
  ADD PRIMARY KEY (`idPerro`),
  ADD UNIQUE KEY `codigo` (`codigo`),
  ADD KEY `fkRaza` (`fk_raza`),
  ADD KEY `fkalcaldia` (`fkalcaldia`);

--
-- Indices de la tabla `ciudades`
--
ALTER TABLE `ciudades`
  ADD PRIMARY KEY (`idciudad`);

--
-- Indices de la tabla `historialvacunas`
--
ALTER TABLE `historialvacunas`
  ADD PRIMARY KEY (`idHistorialVacuna`),
  ADD KEY `fkPerro` (`fkPerro`);

--
-- Indices de la tabla `razas`
--
ALTER TABLE `razas`
  ADD PRIMARY KEY (`idRaza`);

--
-- Indices de la tabla `tercero`
--
ALTER TABLE `tercero`
  ADD PRIMARY KEY (`idtercero`),
  ADD UNIQUE KEY `documento` (`documento`),
  ADD KEY `fk_tercero_alcaldia` (`fkalcaldia`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`idUsuario`),
  ADD UNIQUE KEY `username` (`username`),
  ADD UNIQUE KEY `email` (`email`),
  ADD KEY `fkalcaldia` (`fkalcaldia`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alcaldias`
--
ALTER TABLE `alcaldias`
  MODIFY `idalcaldia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `canes`
--
ALTER TABLE `canes`
  MODIFY `idPerro` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `ciudades`
--
ALTER TABLE `ciudades`
  MODIFY `idciudad` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `historialvacunas`
--
ALTER TABLE `historialvacunas`
  MODIFY `idHistorialVacuna` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `razas`
--
ALTER TABLE `razas`
  MODIFY `idRaza` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `tercero`
--
ALTER TABLE `tercero`
  MODIFY `idtercero` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `alcaldias`
--
ALTER TABLE `alcaldias`
  ADD CONSTRAINT `alcaldias_ibfk_1` FOREIGN KEY (`fkciudad`) REFERENCES `ciudades` (`idciudad`);

--
-- Filtros para la tabla `canes`
--
ALTER TABLE `canes`
  ADD CONSTRAINT `canes_ibfk_1` FOREIGN KEY (`fk_raza`) REFERENCES `razas` (`idRaza`),
  ADD CONSTRAINT `canes_ibfk_2` FOREIGN KEY (`fkalcaldia`) REFERENCES `alcaldias` (`idalcaldia`);

--
-- Filtros para la tabla `historialvacunas`
--
ALTER TABLE `historialvacunas`
  ADD CONSTRAINT `historialvacunas_ibfk_1` FOREIGN KEY (`fkPerro`) REFERENCES `canes` (`idPerro`);

--
-- Filtros para la tabla `tercero`
--
ALTER TABLE `tercero`
  ADD CONSTRAINT `fk_tercero_alcaldia` FOREIGN KEY (`fkalcaldia`) REFERENCES `alcaldias` (`idalcaldia`);

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`fkalcaldia`) REFERENCES `alcaldias` (`idalcaldia`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
