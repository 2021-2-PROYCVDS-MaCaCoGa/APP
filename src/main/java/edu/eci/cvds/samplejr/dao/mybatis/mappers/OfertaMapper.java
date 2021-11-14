
package edu.eci.cvds.samplejr.dao.mybatis.mappers;

import edu.eci.cvds.samples.entities.Oferta;
import java.util.List;
import org.apache.ibatis.annotations.Param;


public interface OfertaMapper {
    
    public void addOferta(@Param("categoria") String categoria,
                        @Param("Descripcion") String Descripcion,
                        @Param("nombre") String nombre);
    
    
    public void actualizarEstado(@Param("id") int id,
                                @Param("estado") String estado);
    
    public Oferta consultarOferta(@Param("id") int id);
    public List<Oferta> consultarOfertas(@Param("categoria") int categoria);
    public List<Oferta> consultarOfertas();
    
}
