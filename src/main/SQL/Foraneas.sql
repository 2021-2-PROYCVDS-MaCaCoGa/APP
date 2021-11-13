/*LLAVES FORANEAS*/

/*TABLA NECESIDAD*/
--Conexion con los datos de la tabla categoria
--de acuerdo al nombre de la categoria
ALTER TABLE NECESIDAD
    ADD CONSTRAINT fk_categoria FOREIGN KEY ( CATEGORIA )
    REFERENCES CATEGORIA ( NOMBRE );

--Conexion con los datos de la tabla usuario
--de acuerdo al login del usuario
ALTER TABLE NECESIDAD 
    ADD CONSTRAINT fk_usuario FOREIGN KEY ( USUARIO )
    REFERENCES USUARIO ( LOGIN );