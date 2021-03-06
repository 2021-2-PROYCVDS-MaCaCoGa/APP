-- ------------------------------------------------
-- FUNCIONES
-- ------------------------------------------------

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

-- ------------------------------------------------
-- TRIGGERS CATEGORIA
-- ------------------------------------------------

--CREACION DE TRIGGER DE FECHA ACTUAL PARA CATEGORIA
CREATE TRIGGER AUTO_FECHA_INICIAL_CATEGORIA
BEFORE INSERT ON public.CATEGORIA
FOR EACH ROW 
EXECUTE PROCEDURE fechaCreacion();

--CREACION DE TRIGGER DE FECHA DE MODIFICACION DE CATEGORIA
--APENAS SE CREA LA CATEGORIA
CREATE TRIGGER AUTO_FECHA_MODIFICA_CATEGORIA
BEFORE INSERT ON public.CATEGORIA
FOR EACH ROW 
EXECUTE PROCEDURE fechaModificacionInicial();

--CREACION DE TRIGGER DE ESTADO DE LA CATEGORIA
CREATE TRIGGER AUTO_ESTADO_CATEGORIA
BEFORE INSERT ON public.CATEGORIA
FOR EACH ROW
EXECUTE PROCEDURE estadoCategoria();


-- ------------------------------------------------
-- TRIGGERS NECESIDAD
-- ------------------------------------------------

--CREACION DE TRIGGER PARA DAR A LA NECESIDAD UNA FECHA DE CREACION
--INICIAL, LA CUAL ES LA FECHA ACTUAL
CREATE TRIGGER AUTO_FECHA_INICIAL_NECESIDAD
BEFORE INSERT ON public.NECESIDAD
FOR EACH ROW
EXECUTE PROCEDURE fechaCreacion();

--CREACION DE TRIGGER PARA DAR ESTADO INICIAL AL CREAR
--UNA NECESIDAD
CREATE TRIGGER AUTO_ESTADO_NECESIDAD
BEFORE INSERT ON public.NECESIDAD
FOR EACH ROW
EXECUTE PROCEDURE estadoCategoria();

--CREACION DE TRIGGER PARA DAR A LA NECESIDAD UNA FECHA
--DE MODIFICACION IGUAL A NULL
CREATE TRIGGER AUTO_FECHA_MODIFICA_NECESIDAD
BEFORE INSERT ON public.NECESIDAD
FOR EACH ROW 
EXECUTE PROCEDURE fechaModificacionInicial();

-- ------------------------------------------------
-- TRIGGERS OFERTA
-- ------------------------------------------------
--CREACION DE TRIGGER PARA DAR A LA OFERTA UNA FECHA DE CREACION
--INICIAL, LA CUAL ES LA FECHA ACTUAL
CREATE TRIGGER AUTO_FECHA_INICIAL_OFERTA
BEFORE INSERT ON public.OFERTA
FOR EACH ROW 
EXECUTE PROCEDURE fechaCreacion();

--CREACION DE TRIGGER PARA DAR ESTADO INICIAL AL CREAR
--UNA OFERTA
CREATE TRIGGER AUTO_ESTADO_OFERTA
BEFORE INSERT ON public.OFERTA
FOR EACH ROW
EXECUTE PROCEDURE estadoCategoria();

--CREACION DE TRIGGER PARA DAR A LA OFERTA UNA FECHA
--DE MODIFICACION IGUAL A NULL
CREATE TRIGGER AUTO_FECHA_MODIFICA_OFERTA
BEFORE INSERT ON public.OFERTA
FOR EACH ROW 
EXECUTE PROCEDURE fechaModificacionInicial();