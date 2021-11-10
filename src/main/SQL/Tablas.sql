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

<<<<<<< HEAD
CREATE TABLE USUARIO (
    ID NUMBER NOT NULL,
    NOMBRE VARCHAR(100) NOT NULL,
    ROL VARCHAR(20) NOT NULL,
    CORREO VARCHAR(100) NOT NULL,
    CONTRASEÑA VARCHAR(20) NOT NULL,
    LOGIN VARCHAR(20) NOT NULL
)
=======
CREATE TABLE IF NOT EXISTS `CATEGORIA` (
    `ID` NUMBER NOT NULL,
    `NOMBRE` VARCHAR(100) NOT NULL,
    `DESCRIPCION` VARCHAR(200) NOT NULL,
    `FECHACREACION` DATE NOT NULL,
    `ESTADO` VARCHAR(50) NOT NULL,
    `FECHAMODIFICACION` DATE);
>>>>>>> db620d0fb789e7c478ac26da7a01a25f5e3ac312

