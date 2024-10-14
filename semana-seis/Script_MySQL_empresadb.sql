-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 14-10-2024 a las 23:52:26
-- Versión del servidor: 8.0.17
-- Versión de PHP: 7.3.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `empresadb`
--
CREATE DATABASE IF NOT EXISTS `empresadb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE `empresadb`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `departamento`
--

CREATE TABLE `departamento` (
  `DepartamentoID` int(11) NOT NULL,
  `Nombre` varchar(255) DEFAULT NULL,
  `Ubicacion` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `departamento`
--

INSERT INTO `departamento` (`DepartamentoID`, `Nombre`, `Ubicacion`) VALUES
(1, 'Ventas', 'Piso 5, Edificio A'),
(2, 'Desarrollo', 'Piso 2, Edificio B'),
(3, 'Recursos Humanos', 'Piso 1, Edificio C'),
(4, 'Marketing', 'Piso 4, Edificio D');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `EmpleadoID` int(11) NOT NULL,
  `Nombre` varchar(255) DEFAULT NULL,
  `Cargo` varchar(255) DEFAULT NULL,
  `Salario` decimal(10,2) DEFAULT NULL,
  `DepartamentoID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`EmpleadoID`, `Nombre`, `Cargo`, `Salario`, `DepartamentoID`) VALUES
(101, 'Juan Pérez', 'Vendedor', '54450.00', 1),
(102, 'Ana García', 'Programador', '60000.00', 2),
(103, 'Carlos Rodríguez', 'Analista de Recursos Humanos', '50000.00', 3),
(104, 'María López', 'Desarrollador Senior', '75000.00', 2);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `departamento`
--
ALTER TABLE `departamento`
  ADD PRIMARY KEY (`DepartamentoID`);

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`EmpleadoID`),
  ADD KEY `DepartamentoID` (`DepartamentoID`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD CONSTRAINT `empleado_ibfk_1` FOREIGN KEY (`DepartamentoID`) REFERENCES `departamento` (`DepartamentoID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
