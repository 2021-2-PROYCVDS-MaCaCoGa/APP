
package edu.eci.cvds.services.Cliente;


<<<<<<< HEAD
import com.mysql.jdbc.Connection;
=======
import edu.eci.cvds.samplejr.dao.mybatis.mappers.CategoriaMapper;
import edu.eci.cvds.samplejr.dao.mybatis.mappers.UsuarioMapper;
import edu.eci.cvds.samples.entities.Perfil;
>>>>>>> db620d0fb789e7c478ac26da7a01a25f5e3ac312
import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;


import java.sql.SQLException;
import java.sql.Statement;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


/**
 *
 * @author hcadavid
 */
public class MyBatisExample {
    
    static final String JDBC_DRIVER = "org.h2.Driver";   
    static final String DB_URL = "jdbc:h2:~/test";  
    static final String USER = "sa"; 
   static final String PASS = "sa"; 

<<<<<<< HEAD
    
=======
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
                inputStream = Resources.getResourceAsStream("mybatis-config-h2.xml");
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e.getCause());
            }
        }
        return sqlSessionFactory;
    }
>>>>>>> db620d0fb789e7c478ac26da7a01a25f5e3ac312

    /**
     * Programa principal de ejempo de uso de MyBATIS
     * @param args
     * @throws SQLException
     */
    public static void main(String args[]) throws SQLException {
<<<<<<< HEAD
        Connection conn = null; 
        Statement stmt = null; 
        try { 
         // STEP 1: Register JDBC driver 
         Class.forName(JDBC_DRIVER); 
             
         //STEP 2: Open a connection 
         System.out.println("Connecting to database..."); 
         conn = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);
         } catch(SQLException se) { 
         //Handle errors for JDBC 
         se.printStackTrace(); 
      } catch(Exception e) { 
         //Handle errors for Class.forName 
         e.printStackTrace(); 
      } finally { 
         //finally block used to close resources 
         try{ 
            if(stmt!=null) stmt.close(); 
         } catch(SQLException se2) { 
         } // nothing we can do 
         try { 
            if(conn!=null) conn.close(); 
         } catch(SQLException se){ 
            se.printStackTrace(); 
         } //end finally try 
      } //end try 
      System.out.println("Goodbye!");
   } 
=======
        SqlSessionFactory sessionfact = getSqlSessionFactory();
        //sessionfact.getConfiguration().addMapper(UsuarioMapper.class);
        SqlSession sqlss = sessionfact.openSession();
        
        UsuarioMapper usuarioM = (UsuarioMapper)sqlss.getMapper(UsuarioMapper.class);
        CategoriaMapper categoriaM = (CategoriaMapper)sqlss.getMapper(CategoriaMapper.class);
        
        System.out.println("-----------------------Consultar Clientes-------------------");
        System.out.println(usuarioM.consultarUsuarios());
        System.out.println("------------------------Consultar Cliente-------------------");
        System.out.println(usuarioM.consultarUsuario("CristianC"));
        usuarioM.ingresarUsuario(3,"Michael", "michael_mni", "14325mc", "michaelmni@gmail.com", Perfil.valueOf("ESTUDIANTE").toString());
        System.out.println("--------------------------Consultar Cliente michael_mni------------");
        System.out.println(usuarioM.consultarUsuario("michael_mni"));
        usuarioM.deleteUsuario(3);        
        System.out.println("--------------------Consultar Categorias-------------------");
        System.out.println(categoriaM.consultarCategorias());
        
        
        sqlss.commit();
        sqlss.close();
    }


>>>>>>> db620d0fb789e7c478ac26da7a01a25f5e3ac312
}