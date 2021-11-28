
package edu.eci.cvds.samplejr.dao.mybatis.mappers;

import edu.eci.cvds.samples.entities.Actividad;
import edu.eci.cvds.samples.entities.Oferta;
import java.util.List;
import org.apache.ibatis.annotations.Param;


public interface OfertaMapper {
    
    public void addOferta(@Param("categoria") String categoria,
                        @Param("descripcion") String Descripcion,
                        @Param("nombre") String nombre,
                        @Param("usuario") String usuario);
    
    
    public void actualizarEstado(@Param("oferta") String categoria,
                                @Param("estado") String estado);
    
    public Oferta consultarOferta(@Param("Oferta") String oferta);
    public List<Oferta> consultarOfertasXcategoria(@Param("categoria") String categoria);
    public List<Actividad> consultarOfertas();
    
    public void deleteOferta(@Param("oferta") String oferta);
    
}
