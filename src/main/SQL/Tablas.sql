

-- -----------------------------------------------
-- Table `USUARIO`
-- -----------------------------------------------
CREATE TABLE IF NOT EXISTS `USUARIO` (
    `ID` SERIAL PRIMARY KEY NOT NULL,
    `NOMBRE` VARCHAR(100) NOT NULL,
    `ROL` VARCHAR(20) NOT NULL,
    `CORREO` VARCHAR(100) NOT NULL,
    `PASSWORD` VARCHAR(20) NOT NULL,
    `LOGIN` VARCHAR(20) NOT NULL);
-- -----------------------------------------------
-- Table `CATEGORIA`
-- -----------------------------------------------

CREATE TABLE IF NOT EXISTS `CATEGORIA` (
    `ID` SERIAL PRIMARY KEY NOT NULL,
    `NOMBRE` VARCHAR(100) NOT NULL,
    `DESCRIPCION` VARCHAR(200) NOT NULL,
    `FECHACREACION` DATE NOT NULL,
    `ESTADO` VARCHAR(50) NOT NULL,
    `FECHAMODIFICACION` DATE);

-- ------------------------------------------------
-- Table "Necesidad"
-- ------------------------------------------------

CREATE TABLE IF NOT EXISTS `NECESIDAD`(
    `ID` SERIAL PRIMARY KEY NOT NULL,
    `CATEGORIA` VARCHAR(100) NOT NULL,
    `NOMBRE` VARCHAR(20) NOT NULL,
    `DESCRIPCION` VARCHAR(200) NOT NULL,
    `FECHACREACION` DATE NOT NULL,
    `ESTADO` VARCHAR(10) NOT NULL,
    `FECHAMODIFICACION` DATE,
    `USUARIO` VARCHAR(20) NOT NULL,
    `URGENCIA` NUMBER NOT NULL);


-- ------------------------------------------------
-- Table "Oferta"
-- ------------------------------------------------
CREATE TABLE IF NOT EXISTS `OFERTA`(
    `ID` SERIAL PRIMARY KEY NOT NULL,
    `CATEGORIA` VARCHAR(100) NOT NULL,
    `NOMBRE` VARCHAR(20) NOT NULL,
    `DESCRIPCION` VARCHAR(200) NOT NULL,
    `FECHACREACION` DATE NOT NULL,
    `ESTADO` VARCHAR(10) NOT NULL,
    `FECHAMODIFICACION` DATE,
    `USUARIO` VARCHAR(20) NOT NULL);

    -- ------------------------------------------------
-- Table "Respuesta"
-- ------------------------------------------------
CREATE TABLE IF NOT EXISTS `RESPUESTA`(
    `ID` SERIAL PRIMARY KEY NOT NULL,
    `NOMBRE` VARCHAR(100) NOT NULL,
    `COMENTARIO` INTEGER NOT NULL,
    `FECHACREACION` DATE NOT NULL,
    `ACTIVIDAD` VARCHAR(20) NOT NULl);
