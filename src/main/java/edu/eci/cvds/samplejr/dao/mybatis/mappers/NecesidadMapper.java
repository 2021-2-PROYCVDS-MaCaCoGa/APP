package edu.eci.cvds.samplejr.dao.mybatis.mappers;

import java.sql.Date;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.Necesidad;

import java.util.List;

public interface NecesidadMapper {
    
    public void addNecesidad(@Param("categoria") int categoria,
                            @Param("nombre") String nombre,
                            @Param("descripcion")String descripcion,
                            @Param("urgencia") int urgencia,
                            @Param("estado") boolean estado);

    /**
     * Se consultan las necesidades de acuerdo a una categoria especifica
     * @return 
     */
    public List<Necesidad> consultarNecesidades(@Param("categoria") int categoria);
    public List<Necesidad> consultarNecesidades();
    
    public Necesidad consultarNecesidad(@Param("id") int id);
    
    public void actualizarEstado (@Param("id") int id,
                                    @Param("estado") String estado);
    
   
}
