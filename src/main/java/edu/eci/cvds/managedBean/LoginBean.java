package edu.eci.cvds.managedBean;



import com.google.inject.Inject;
import edu.eci.cvds.security.login;
import edu.eci.cvds.security.loginconnection;

import javax.faces.application.FacesMessage;
import org.apache.shiro.subject.Subject;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.annotation.PostConstruct;
import org.apache.shiro.SecurityUtils;
import java.sql.Connection;
import java.sql.DriverManager;


@SuppressWarnings("deprecation")
@ManagedBean(name = "loginListener")
@SessionScoped
public class LoginBean {
}
