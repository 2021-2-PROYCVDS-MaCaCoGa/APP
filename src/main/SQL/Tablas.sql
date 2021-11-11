/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  crisa
 * Created: 3/11/2021
 */

-- -----------------------------------------------
-- Table `USUARIO`
-- -----------------------------------------------
CREATE TABLE IF NOT EXISTS `USUARIO` (
    `ID` NUMBER NOT NULL,
    `NOMBRE` VARCHAR(100) NOT NULL,
    `PERFIL` VARCHAR(20) NOT NULL,
    `CORREO` VARCHAR(100) NOT NULL,
    `PASSWORD` VARCHAR(20) NOT NULL,
    `LOGIN` VARCHAR(20) NOT NULL);
-- -----------------------------------------------
-- Table `CATEGORIA`
-- -----------------------------------------------

CREATE TABLE IF NOT EXISTS `CATEGORIA` (
    `ID` NUMBER NOT NULL,
    `NOMBRE` VARCHAR(100) NOT NULL,
    `DESCRIPCION` VARCHAR(200) NOT NULL,
    `FECHACREACION` DATE NOT NULL,
    `ESTADO` VARCHAR(50) NOT NULL,
    `FECHAMODIFICACION` DATE);

-- ------------------------------------------------
-- Table "Necesidad"
-- ------------------------------------------------

CREATE TABLE IF NOT EXISTS `NECESIDAD`(
    `ID` NUMBER NOT NULL,
    `CATEGORIA` NUMBER NOT NULL,
    `NOMBRE` VARCHAR(20) NOT NULL,
    `DESCRIPCION` VARCHAR(200) NOT NULL,
    `FECHACREACION` DATE NOT NULL,
    `ESTADO` VARCHAR(10) NOT NULL,
    `FECHAMODIFICACION` DATE,
    `USUARIO` VARCHAR(20) NOT NULL,
    `URGENCIA` NUMBER NOT NULL);


