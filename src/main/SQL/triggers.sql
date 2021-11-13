--TABLA CATEGORIA

--FUNCION QUE ME DA LA FECHA ACTUAL PARA LA FECHA DE CREACION DE LA CATEGORIA
CREATE OR REPLACE FUNCTION fechaCreacion()
    RETURNS TRIGGER
AS
$$
BEGIN
    NEW.fechacreacion := CURRENT_DATE;
    RETURN NEW;
END;
$$
LANGUAGE plpgsql;

--FUNCION PARA QUE LA FECHA DE MODIFICACION CUANDO SE INSERTA EL DATO SEA NULL
CREATE OR REPLACE FUNCTION fechaModificacionInicial()
    RETURNS TRIGGER
AS
$$
BEGIN
    NEW.fechamodificacion := NULL;
    RETURN NEW;
END;
$$
LANGUAGE plpgsql;

--FUNCION PARA QUE EL ESTADO DE UNA NUEVA CATEGORIA SEA ACTIVA
CREATE OR REPLACE FUNCTION estadoCategoria()
    RETURNS TRIGGER
AS
$$
BEGIN
    NEW.estado := 'ACTIVO';
    RETURN NEW;
END;
$$
LANGUAGE plpgsql    


--CREACION DE TRIGGER DE FECHA ACTUAL PARA USUARIO
BEFORE INSERT ON public.CATEGORIA
FOR EACH ROW 
EXECUTE PROCEDURE fechaCreacion();

--CREACION DE TRIGGER DE FECHA DE MODIFICACION DE CATEGORIA
--APENAS SE CREA LA CATEGORIA
BEFORE INSERT ON public.CATEGORIA
FOR EACH ROW 
EXECUTE PROCEDURE fechaModificacionInicial();

--CREACION DE TRIGGER DE ESTADO DE LA CATEGORIA
BEFORE INSERT ON public.CATEGORIA
FOR EACH ROW
EXECUTE PROCEDURE estadoCategoria();

------------------------TERMINACION TRIGGERS CATEGORIA-------------------

--TRIGGERS NECESIDAD

--CREACION DE TRIGGER PARA DAR A LA CATEGORIA UNA FECHA DE CREACION
--INICIAL, LA CUAL ES LA FECHA ACTUAL
BEFORE INSERT ON public.NECESIDAD
FOR EACH ROW
EXECUTE PROCEDURE fechaCreacion();

--CREACION DE TRIGGER PARA DAR CATEGORIA INICIAL AL CREAR
--UNA NECESIDAD
BEFORE INSERT ON public.NECESIDAD
FOR EACH ROW
EXECUTE PROCEDURE estadoCategoria();

--CREACION DE TRIGGER PARA DAR A LA CATEGORIA UNA FECHA
--DE MODIFICACION IGUAL A NULL
BEFORE INSERT ON public.NECESIDAD
FOR EACH ROW 
EXECUTE PROCEDURE fechaModificacionInicial();