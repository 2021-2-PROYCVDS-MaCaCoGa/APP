/*RESTRICCIONES USUARIO*/

--Restriccion encargada de revisar que el usuario
--Solo pueda tener dos roles a escoger
ALTER TABLE USUARIO 
    ADD CONSTRAINT ck_rol CHECK(ROL IN (
        'Administrador',
        'Estudiante'
    ));


--Restriccion encargada de revisar si el correo contiene un @
--y el dominio del correo termina en .com.co
ALTER TABLE USUARIO 
    ADD CONSTRAINT ck_correo CHECK(CORREO LIKE '%@%'
    AND CORREO LIKE '%.com.co');


--Restriccion encargada de revisar de que la longitud de la 
--contraseña sea de minimo 8 caracteres
ALTER TABLE USUARIO
    ADD CONSTRAINT ck_password CHECK(length(PASSWORD)>=8);


/*RESTRICCIONES CATEGORIA*/

--Restriccion encargada de chequear de que una categoria solo
--puede tener dos estados
ALTER TABLE CATEGORIA 
    ADD CONSTRAINT ck_estado CHECK(ESTADO IN(
        'ACTIVO',
        'NO ACTIVO'
    ));



/*RESTRICCIONES NECESIDAD*/

--Restriccion encargada de chequear de que una necesidad solo
--puede tener dos estados
ALTER TABLE NECESIDAD 
    ADD CONSTRAINT ck_estado_necesidad CHECK(ESTADO IN(
        'ACTIVO',
        'NO ACTIVO'
    ));

--Restriccion que chequea que la urgencia de la necesidad
--este en el rango de numero entre 1 y 5.
ALTER TABLE NECESIDAD 
    ADD CONSTRAINT ck_urgencia CHECK(URGENCIA BETWEEN 1 AND 5);



/*RESTRICCIONES OFERTA*/

--Restriccion encargada de chequear de que una oferta solo
--puede tener dos estados
ALTER TABLE OFERTA
    ADD CONSTRAINT ck_estado_oferta CHECK(ESTADO IN(
        'ACTIVO',
        'NO ACTIVO'
    ))