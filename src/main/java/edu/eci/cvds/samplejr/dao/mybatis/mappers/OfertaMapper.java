
package edu.eci.cvds.samplejr.dao.mybatis.mappers;

import edu.eci.cvds.samples.entities.Oferta;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author crisa
 */
public interface OfertaMapper {
    
    public void addOferta(@Param("id") int id,
                        @Param("categoria") String categoria,
                        @Param("Descripcion") String Descripcion,
                        @Param("nombre") String nombre);
    
    
    public void consultarOferta(@Param("id") int id);
    public List<Oferta> consultarOfertas(@Param("categoria") int categoria);
    public List<Oferta> consultarOfertas();
    
}
