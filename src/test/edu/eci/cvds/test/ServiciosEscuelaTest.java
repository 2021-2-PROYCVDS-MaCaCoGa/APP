package edu.eci.cvds.test;

import com.google.inject.Inject;
import edu.eci.cvds.samples.services.ServiciosEscuela;
import edu.eci.cvds.samples.services.ServiciosEscuelaFactory;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;



public class ServiciosEscuelaTest {
    
    @Inject
    private SqlSession sqlSession;
    
    private ServiciosEscuela serviciosEscuela;
    
    public ServiciosEscuelaTest(){
        serviciosEscuela = ServiciosEscuelaFactory.getInstance().getServiciosEscuelaTesting();
    }
    
    @Before 
    public void setUp(){
    }
    
    
}