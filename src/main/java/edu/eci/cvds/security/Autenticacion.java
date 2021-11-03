
package edu.eci.cvds.security;


import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *
 * @author diego
 */
public class Autenticacion extends AccessControlFilter{
    String welcomeurl ="/index.html";

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object o) throws Exception {
       Subject subject = getSubject(request, response);
        return !subject.isAuthenticated();
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        Subject subject = getSubject(request, response);
        if( subject.hasRole("Administrador")){
            welcomeurl = "roles/administrador.xhtml";
        }   
        else if( subject.hasRole("Estudiante") ){
            welcomeurl = "roles/estudiante.xhtml";
        }
        WebUtils.issueRedirect(request, response, welcomeurl);
        return false;
        
    }
    
}
