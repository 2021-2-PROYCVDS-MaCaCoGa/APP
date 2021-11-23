package edu.eci.cvds.samplejr.dao.mybatis.mappers;

import edu.eci.cvds.samples.entities.Respuesta;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author crisa
 */
public interface RespuestaMapper {
    
    public void addRespuesta(@Param("nombre") String nombre,
                        @Param("comentario") String comentario,
                        @Param("nComentario") String nombreComentario,    
                        @Param("actividad") String actividad,
                        @Param("usuario") String usuario);
    
    public void addComentario(@Param("comentario") String comentario,
                            @Param("usuario") String usuario,
                            @Param("respuesta") String respuesta,
                            @Param("nombre") String mombre);
    
    public List<Respuesta> consultarRespuestas();
    
    public void deleteComentario(@Param("comentario") String comentario);
    public void deleteRespuesta(@Param("respuesta") String respuesta);
    
    public List<Respuesta> consultarRespuesta(@Param("respuesta") String respuesta);

}
