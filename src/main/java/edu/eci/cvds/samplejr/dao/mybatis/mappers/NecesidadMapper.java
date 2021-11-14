package edu.eci.cvds.samplejr.dao.mybatis.mappers;

import java.sql.Date;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.Necesidad;

import java.util.List;

public interface NecesidadMapper {
    
    /**
     * Se crea una necesidad de acuerdo a los parametros requeridos
     * No se pidie id debido a que la llave principal se autoincrementa automaticamente
     * las fechas son colocadas con disparadores SQL
     * @param categoria
     * @param nombre
     * @param descripcion
     * @param urgencia
     */
    public void addNecesidad(@Param("categoria") String categoria,
                            @Param("nombre") String nombre,
                            @Param("descripcion")String descripcion,
                            @Param("urgencia") int urgencia);

    /**
     * Se consultan las necesidades de acuerdo a una categoria especifica
     * @return 
     */
    public List<Necesidad> consultarNecesidadesCategoria(@Param("categoria") int categoria);
    public List<Necesidad> consultarNecesidades();
    
    public Necesidad consultarNecesidad(@Param("id") int id);
    
    public void actualizarEstado (@Param("id") int id,
                                    @Param("estado") String estado);
    
   
}
