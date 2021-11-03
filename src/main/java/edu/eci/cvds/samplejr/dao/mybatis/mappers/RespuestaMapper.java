package edu.eci.cvds.samplejr.dao.mybatis.mappers;

import edu.eci.cvds.samples.entities.Respuesta;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author crisa
 */
public interface RespuestaMapper {
    
    public void addRespuesta(@Param("id") int id,
                        @Param("nombre") String nombre,
                        @Param("comentarios") List<String> comentarios);
    
    public List<Respuesta> consultarRespuestas();
    
    public Respuesta consultarRespuesta(@Param("id") int id);

}
