/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucc.psicologia.vista;

import co.edu.ucc.psicologia.base.Md5;
import co.edu.ucc.psicologia.logica.CommonsBean;
import co.edu.ucc.psicologia.modelo.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Jorge
 */
@SessionScoped
@ManagedBean(name = "MbUsuarios")
public class MbUsuarios implements Serializable{

    private List<Usuario> usuarios;
    private Usuario usuario;
    private String contrasena;
    private String confirmacion;

    @EJB
    private CommonsBean cb;

    public MbUsuarios() {
    }

    @PostConstruct
    public void init() {
        usuario = new Usuario();
        usuario.setIsEstudiante(Boolean.FALSE);
        usuarios = new ArrayList<>();
        usuarios = cb.getByOneField(Usuario.class, "isEstudiante", Boolean.FALSE);
        //usuarios = cb.getAll(Usuario.class);
    }

    public void accionGuarda() throws Exception {
        if (verificarFormulario()) {
            usuario.setContrasena(Md5.getEncoddedString(contrasena));
            if (cb.guardar(usuario)) {
                mostrarMensaje(FacesMessage.SEVERITY_INFO, "Exitoso", "Se ha Guardado el usuario");
                init();
            } else {
                mostrarMensaje(FacesMessage.SEVERITY_FATAL, "Error", "Ha fallado al Guardar el Usuario");
            }
        }

    }

    public void cargaUsuario(Usuario row) {
        this.usuario = row;
    }

    public void resetUsuario() {
        this.usuario = new Usuario();
    }

    public Boolean verificarFormulario() throws Exception {
        Boolean resultado = Boolean.TRUE;

        if (usuario.getNombreUsuario().trim().length() == 0) {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue nombre de usuario");
        } else {
            Usuario u = (Usuario) cb.getByOneFieldWithOneResult(Usuario.class, "nombreUsuario", usuario.getNombreUsuario());
            if (u != null) {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Nombre de usuario ya existe");
            }
        }

        if (usuario.getNombreCompleto().trim().length() == 0) {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue nombre completo");
        }

        if (usuario.getNumeroIdentificacion() == null) {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue número de identificación");
        } else {
            Usuario u = (Usuario) cb.getByOneFieldWithOneResult(Usuario.class, "numeroIdentificacion", usuario.getNumeroIdentificacion());
            if (u != null) {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Numero de identificación ya existe");
            }
        }

        if (contrasena.trim().length() == 0) {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue clave");
        } else {
            String[] campos = contrasena.split(" ");
            if (campos.length > 1) {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "El campo clave  no permite espacio");
            }
        }

        if (confirmacion.trim().length() == 1) {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue clave de confirmacion");
        } else {
            String[] campos = confirmacion.split(" ");
            if (campos.length > 1) {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "El campo clave de confirmacion no permite espacio");
            }
        }

        if (!contrasena.equals(confirmacion)) {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Contraseña no coinciden");
        }

        if (usuario.getEmail().trim().length() == 0) {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue Correo Electronico");
        } else if (!(validateEmail(usuario.getEmail()))) {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Formato de Correo Electronico no admitido");
        }

        if (usuario.getTelefono().trim().length() == 0) {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue Telefono");
        } else {
            String[] campos = usuario.getTelefono().split(" ");
            if (campos.length > 1) {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "El campo telefono no permite espacio");
            }
        }
        return resultado;
    }

    public boolean validateEmail(String email) {
        String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(PATTERN_EMAIL);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    /**
     * Metodo utilizado para ejecutar la presentacion de un mensaje emergente
     * tipo Growl en pantalla
     *
     * @param icono
     * @param titulo
     * @param mensaje
     */
    public void mostrarMensaje(FacesMessage.Severity icono, String titulo, String mensaje) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(icono, titulo, mensaje));
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getConfirmacion() {
        return confirmacion;
    }

    public void setConfirmacion(String confirmacion) {
        this.confirmacion = confirmacion;
    }

}
