/*LLAVES UNICAS*/

/*TABLA USUARIO*/
--El usuario debe tener un correo unico
ALTER TABLE USUARIO ADD CONSTRAINT uk_user_correo UNIQUE( CORREO );
--El usuario debe tener un login unico
ALTER TABLE USUARIO ADD CONSTRAINT uk_login UNIQUE( LOGIN );


/*TABLA CATEGORIA*/
--La categoria debe tener un nombre unico
ALTER TABLE CATEGORIA ADD CONSTRAINT uk_nombre_categoria UNIQUE( NOMBRE);



