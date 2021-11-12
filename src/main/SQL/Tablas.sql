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
    `ROL` VARCHAR(20) NOT NULL,
    `CORREO` VARCHAR(100) NOT NULL,
    `PASSWORD` VARCHAR(20) NOT NULL,
    `LOGIN` VARCHAR(20) NOT NULL);
-- -----------------------------------------------
-- Table `CATEGORIA`
-- -----------------------------------------------

CREATE TABLE IF NOT EXISTS `CATEGORIAS` (
    `ID` NUMBER NOT NULL,
    `NOMBRE` VARCHAR(100) NOT NULL,
    `DESCRIPCION` VARCHAR(200) NOT NULL,
    `FECHACREACION` DATE NOT NULL,
    `ESTADO` VARCHAR(50) NOT NULL,
    `FECHAMODIFICACION` DATE);

