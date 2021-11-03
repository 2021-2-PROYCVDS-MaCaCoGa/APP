/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  crisa
 * Created: 3/11/2021
 */

CREATE TABLE USUARIO (
    ID NUMBER NOT NULL,
    NOMBRE VARCHAR(100) NOT NULL,
    PERFIL VARCHAR(20) NOT NULL,
    CORREO VARCHAR(100) NOT NULL,
    CONTRASEÑA VARCHAR(20) NOT NULL,
    LOGIN VARCHAR(20) NOT NULL
)

