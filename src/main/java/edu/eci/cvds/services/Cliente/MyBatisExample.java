
package edu.eci.cvds.services.Cliente;


import com.mysql.jdbc.Connection;
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

    

    /**
     * Programa principal de ejempo de uso de MyBATIS
     * @param args
     * @throws SQLException
     */
    public static void main(String args[]) throws SQLException {
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
}