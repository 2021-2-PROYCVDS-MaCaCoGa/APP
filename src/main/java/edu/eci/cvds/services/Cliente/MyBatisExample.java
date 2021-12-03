

package edu.eci.cvds.services.Cliente;


import com.mysql.jdbc.Connection;
import edu.eci.cvds.samplejr.dao.mybatis.mappers.CategoriaMapper;
import edu.eci.cvds.samplejr.dao.mybatis.mappers.NecesidadMapper;
import edu.eci.cvds.samplejr.dao.mybatis.mappers.OfertaMapper;
import edu.eci.cvds.samplejr.dao.mybatis.mappers.RespuestaMapper;
import edu.eci.cvds.samplejr.dao.mybatis.mappers.UsuarioMapper;
import edu.eci.cvds.samples.entities.Perfil;
import edu.eci.cvds.samples.entities.Respuesta;
import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;


import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


/**
 *
 * @author hcadavid
 */
public class MyBatisExample {


   /**
     * Método que construye una fábrica de sesiones de MyBatis a partir del
     * archivo de configuración ubicado en src/main/resources
     *
     * @return instancia de SQLSessionFactory
     */
     public static SqlSessionFactory getSqlSessionFactory() {
        SqlSessionFactory sqlSessionFactory = null;
        if (sqlSessionFactory == null) {
            InputStream inputStream;
            try {
                inputStream = Resources.getResourceAsStream("mybatis-config.xml");
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e.getCause());
            }
        }
        return sqlSessionFactory;
    }

    /**
     * Programa principal de ejempo de uso de MyBATIS
     * @param args
     * @throws SQLException
     */
    public static void main(String args[]) throws SQLException {
        SqlSessionFactory sessionfact = getSqlSessionFactory();
        //sessionfact.getConfiguration().addMapper(UsuarioMapper.class);
        //sessionfact.getConfiguration().addMapper(CategoriaMapper.class);
        SqlSession sqlss = sessionfact.openSession();
        
        UsuarioMapper usuarioM = (UsuarioMapper)sqlss.getMapper(UsuarioMapper.class);
        CategoriaMapper categoriaM = (CategoriaMapper)sqlss.getMapper(CategoriaMapper.class);
        NecesidadMapper necesidadM = (NecesidadMapper)sqlss.getMapper(NecesidadMapper.class);
        OfertaMapper ofertaM = (OfertaMapper)sqlss.getMapper(OfertaMapper.class);
        RespuestaMapper respuestaM = (RespuestaMapper)sqlss.getMapper(RespuestaMapper.class);
        
        //Prueba de funcionamiento de los mapper
        //Prueba de funcionamiento de Usuarios
        System.out.println("-----------------------Consultar Usuarios-------------------");
        System.out.println(usuarioM.consultarUsuarios());
        System.out.println("------------------------Consultar Usuario-------------------");
        System.out.println(usuarioM.consultarUsuario("CristianC"));
        System.out.println("---------------------Ingresando usuario michael_mni------------------------");
        usuarioM.ingresarUsuario("Michael", "michael_mni", "14325mc", "michaelmni@gmail.com.co", Perfil.valueOf("ESTUDIANTE").toString());
        System.out.println("--------------------------Consultar usuario michael_mni------------");
        System.out.println(usuarioM.consultarUsuario("michael_mni"));
        //sqlss.commit();
        //usuarioM.deleteUsuario("michael_mni","14325mc");
        System.out.println("-----------------------Consultar Usuarios-------------------");
        System.out.println(usuarioM.consultarUsuarios());     
        //Prueba de funcionamiento de Categorias
        System.out.println("--------------------Consultar Categorias-------------------");
        System.out.println(categoriaM.consultarCategorias());
        categoriaM.agregarCategoria("LENGUAS", "Se expresan dudas de cualquier materia de lenguas extranjeras");
        System.out.println("--------------------Consultar Categoria LENGUAS-------------");
        System.out.println(categoriaM.consultarCategoriaNombre("LENGUAS"));
        categoriaM.modificarCategoria("LENGUAS","LENGUAJE", "Se expresan dudas de cualquier tema", "ACTIVA");
        System.out.println("--------------------Consultar Categoria LENGUAJE-------------");
        System.out.println(categoriaM.consultarCategoriaNombre("LENGUAJE"));
        //categoriaM.borrarCategoria("LENGUAJE");
        //sqlss.commit();
        //Prueba de funcionamient de Necesidades
        System.out.println("---------------------Consultar Necesidades---------------------");
        System.out.println(necesidadM.consultarNecesidades());
        System.out.println("----------------------Agregando Necesidad Advertencia-------------------");
        necesidadM.addNecesidad("SISTEMAS", "Advertencia", "Se hallo un problema en el dominio de la pagina", 5,"CristianC");
        System.out.println("---------------------Consultar Advertencia-----------");
        System.out.println(necesidadM.consultarNecesidad("Advertencia"));
        System.out.println("--------------Necesidad en no Activo ---------------------");
        necesidadM.actualizarEstado("Advertencia", "CERRADA");
        System.out.println(necesidadM.consultarNecesidad("Advertencia"));
        System.out.println("--------------Necesidad advertencia eliminada-------------------");
        //necesidadM.eliminarNecesidad("Advertencia");
        //sqlss.commit();
        System.out.println("---------------------Consultar Advertencia-----------");
        System.out.println(necesidadM.consultarNecesidad("Advertencia"));
        //Prueba funcionamiento de Ofertas
        System.out.println("---------------------Consultar ofertas-----------------");
        System.out.println(ofertaM.consultarOfertas());
        System.out.println("----------------------Agregar oferta LIBRO-GUIA---------");
        ofertaM.addOferta("LENGUAJE", "Para el tema de la semana consultar el libro ...", "LIBRO-GUIA", "michael_mni");
        System.out.println("-------------------Oferta en no Activo------------------");
        ofertaM.actualizarEstado("LIBRO-GUIA", "CERRADA");
        System.out.println("-----------------------Consultar LIBRO-GUIA----------------");
        // ELiminacion de pruebas
        ofertaM.deleteOferta("LIBRO-GUIA");
        System.out.println("------------------Eliminar LIBRO-GUIA---------------------");
        System.out.println(ofertaM.consultarOferta("LIBRO-GUIA"));
        necesidadM.eliminarNecesidad("Advertencia");
        System.out.println("--------------Necesidad advertencia eliminada-------------------");
        System.out.println(necesidadM.consultarNecesidad("Advertencia"));
        categoriaM.borrarCategoria("LENGUAJE");
        System.out.println("----------------Categoria LENGUAJE eliminada");
        System.out.println(categoriaM.consultarCategoriaNombre("LENGUAJE"));
        usuarioM.deleteUsuario("michael_mni","14325mc");
        System.out.println("-----------------------Usuario michael_mni eliminado------------");
        System.out.println(usuarioM.consultarUsuario("michael_mni"));
        sqlss.commit();
        //Prueba funcionamiento de Respuesta
        System.out.println("-------------------------Consultar Respuestas----------------------");
        System.out.println(respuestaM.consultarRespuestas());
        List<Respuesta> respuestas = respuestaM.consultarRespuestas();
        for(Respuesta respuesta:respuestas){
            System.out.println("Comentarios de Respuesta"+respuesta.getComentario());
        }
        System.out.println("--------------------------Insertar Respuesta------------------------");
        respuestaM.addRespuesta("RCuidado", "En el parrafo 10 se encuentra el error...", "RCuidado", "CUIDADO", "CristianC");
        respuestaM.addComentario("Si efectivamente, en ese parrafo se encuentra lo que les digo", "DiegoG", "RCuidado", "RRCuidado");
        System.out.println("--------------------------Consultar Respuesta RCuidado----------------------------------------");
        System.out.println(respuestaM.consultarRespuesta("RCuidado"));
        respuestaM.deleteComentario("RRCuidado");
        respuestaM.deleteRespuesta("RCuidado");
        respuestaM.deleteComentario("RCuidado");
        System.out.println("-------------------------Respuesta Eliminada-------------------------");
        System.out.println(respuestaM.consultarRespuesta("RCuidado"));
        
        
        sqlss.commit();
        sqlss.close();
    }


}