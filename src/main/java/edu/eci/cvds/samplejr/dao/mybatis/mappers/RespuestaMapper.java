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
                        @Param("comentarios") List<String> comentarios,
                        @Param("oferta_respondida") String oferta_respondida);
    
    public List<Respuesta> consultarRespuestas();
    
    public Respuesta consultarRespuesta(@Param("id") int id);

}
