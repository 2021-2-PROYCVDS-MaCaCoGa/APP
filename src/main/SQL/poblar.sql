INSERT INTO USUARIO VALUES(1,'Diego Gonzalez','Estudiante','diego@gmail.com','prueba123','DiegoG');
INSERT INTO USUARIO VALUES(2,'Cristian Castellanos','Administrador','cristian@gmail.com','prueba123','CristianC');

INSERT INTO CATEGORIA (ID, NOMBRE, DESCRIPCION, FECHACREACION, ESTADO)
VALUES (1,'CIENCIAS','Se expresan los problemas o soliciones con respecto a la ciencia natural', CURDATE(), TRUE);
INSERT INTO CATEGORIA (ID, NOMBRE, DESCRIPCION, FECHACREACION, ESTADO)
VALUES (2,'SISTEMAS','Se expresan los problemas o soliciones con respecto a la carrera de sistemas', CURDATE(), TRUE);

INSERT INTO NECESIDAD (ID, CATEGORIA, NOMBRE, DESCRIPCION, FECHACREACION, ESTADO, USUARIO, URGENCIA)
VALUES (1,'SISTEMAS','PROBLEMA','Necesito ayuda con un problema en un codigo',CURDATE(),'ACTIVA', 1, 3);
INSERT INTO NECESIDAD (ID, CATEGORIA, NOMBRE, DESCRIPCION, FECHACREACION, ESTADO, USUARIO, URGENCIA)
VALUES (2,'CIENCIAS','PELIGRO','Sucedio un prblema!!',CURDATE(),'ACTIVA', 2, 5);

INSERT INTO OFERTA (CATEGORIA, NOMBRE, FECHACREACION, DESCRIPCION, USUARIO, ESTADO)
VALUES ('SISTEMAS', 'IMPORTANTE', CURDATE(), 'Cuando esten haciendo un trbajo deben tener en cuenta...', 'CristianC', 'ACTIVO' );
INSERT INTO OFERTA (CATEGORIA, NOMBRE, FECHACREACION, DESCRIPCION, USUARIO, ESTADO)
VALUES ('CIENCIAS', 'CUIDADO' , CURDATE(), 'Cuando esten haciendo las practicas, lean muy bien ...', 'DiegoG', 'ACTIVO');
