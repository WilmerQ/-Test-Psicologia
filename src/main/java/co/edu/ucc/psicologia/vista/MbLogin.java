/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucc.psicologia.vista;

import co.edu.ucc.psicologia.base.Md5;
import co.edu.ucc.psicologia.base.SessionOperations;
import co.edu.ucc.psicologia.logica.LogicaLoguin;
import co.edu.ucc.psicologia.modelo.Usuario;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@SessionScoped
@ManagedBean(name = "MbLogin")
public class MbLogin implements Serializable {

    public MbLogin() {
    }

    private Usuario usuario;
    private Boolean autenticado;
    private Boolean isusuario;
    private Boolean isadmin;
    private String contextPath;
    private String mensaje;

    @EJB
    private LogicaLoguin logicaLoguin;

    //Login
    private String nombreDeUsuaio;
    private String password;

    @PostConstruct
    public void init() {
        contextPath = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getContextPath();
        usuario = (Usuario) SessionOperations.getSessionValue("USUARIO");
        if (usuario == null) {
            usuario = new Usuario();
            autenticado = Boolean.FALSE;
            isusuario = Boolean.FALSE;
            isadmin = Boolean.FALSE;
            SessionOperations.setSessionValue("USER", Boolean.FALSE);
        } else {
            autenticado = Boolean.TRUE;
            isusuario = Boolean.TRUE;
        }
    }

    public void Resetinit() {
        System.out.println("reiniciar el login");
        init();
    }

    public String accionLogin() {
        if (verificarFormulario()) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().getFlash().setKeepMessages(true);
            autenticado = false;
            isusuario = false;
            isadmin = false;
            Usuario u = logicaLoguin.login(nombreDeUsuaio, Md5.getEncoddedString(password));
            SessionOperations.setSessionValue("USER", Boolean.FALSE);
            if (u != null) {
                mensaje = "";
                String url;
                usuario = u;
                autenticado = true;
                if (u.getNombreUsuario().equals("Administrador")) {
                    isadmin = true;
                    usuario.setNombreCompleto("Administrador");
                    SessionOperations.setSessionValue("ADMIN", Boolean.TRUE);
                    SessionOperations.setSessionValue("USER", Boolean.FALSE);
                    System.out.println("logueo admin");
                    url = "admin/instituciones.xhtml";
                } else {
                    isusuario = true;
                    SessionOperations.setSessionValue("USER", Boolean.TRUE);
                    SessionOperations.setSessionValue("ADMIN", Boolean.FALSE);
                    System.out.println("logueo user");
                    url = "usuario/resultados.xhtml";
                }
                SessionOperations.setSessionValue("USUARIO", usuario);
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, u.getNombreUsuario(), "Bienvenido"));
                redirect(url);
            } else {
                mensaje = "Verifique sus Credenciales";
            }
        }
        return null;
    }

    public Boolean verificarFormulario() {
        Boolean resultado = Boolean.TRUE;
        if (nombreDeUsuaio.length() == 0) {
            System.out.println("nombreDeUsuaio.length() " + nombreDeUsuaio.length());
            resultado = Boolean.FALSE;
            mensaje = "Error: Inserte Nombre de usuario";
            //mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Inserte Nombre de usuario");
        }

        if (password.trim().length() == 0) {
            resultado = Boolean.FALSE;
            mensaje = "Error: Inserte su contraseña ";
            //mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Inserte su  Contraseña");
        } else {
            String[] campos = password.split(" ");
            if (campos.length > 1) {
                resultado = Boolean.FALSE;
                mensaje = "Error: la Contraseña no permite espacios";
                //mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "la Contraseña no permite espacios");
            }
        }
        return resultado;
    }

    /**
     * Funcion tipo accion las cual es llamada desde un event del un html en
     * esta acion se realiza el proceso de cierre se sesion lo que se realiza es
     * cambiar el estado de las variable de sesion que almacena el usuario
     * actual.
     *
     * @return
     */
    public String accionLogout() {
        System.out.println("cerrr sesion");
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getFlash().setKeepMessages(true);
        try {
            SessionOperations.setSessionValue("USER", Boolean.FALSE);
            SessionOperations.setSessionValue("ADMIN", Boolean.FALSE);
            SessionOperations.setSessionValue("USUARIO", null);
            context.getExternalContext().invalidateSession();
        } catch (Exception e) {

        }
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Salida", "Se ha cerrado la sesion correctamente"));
        redirect(contextPath);
        return null;
    }

    /**
     * Metodo encargado de rediccionar como parametro recibe un String que
     * contiene el link ejemplo /usuario/index.xhtml
     *
     * @param url
     */
    private void redirect(String url) {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            context.getExternalContext().redirect(url);
        } catch (IOException ex) {
            Logger.getLogger(MbLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Metodo utilizado para ejecutar la presentacion de un mensaje emergente
     * tipo Growl en pantall
     *
     * @param icono
     * @param titulo
     * @param mensaje
     */
    public void mostrarMensaje(FacesMessage.Severity icono, String titulo, String mensaje) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(icono, titulo, mensaje));
    }

    public String getNombreDeUsuaio() {
        return nombreDeUsuaio;
    }

    public void setNombreDeUsuaio(String nombreDeUsuaio) {
        this.nombreDeUsuaio = nombreDeUsuaio;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}
