/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucc.psicologia.vista;

import co.edu.ucc.psicologia.base.SessionOperations;
import co.edu.ucc.psicologia.logica.CommonsBean;
import co.edu.ucc.psicologia.modelo.Test;
import co.edu.ucc.psicologia.modelo.Usuario;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ViewScoped
@ManagedBean(name = "MbAplicante")
public class MbAplicante implements Serializable {

    private Long idtest;
    private Boolean renderBotonPataNegra;
    private Boolean renderBotonIPA;
    private Boolean renderDual;
    private Usuario usuario;
    private Long acompanate;
    private Usuario acompanante;
    Test u;
    private String mensaje;

    @EJB
    private CommonsBean cb;

    public MbAplicante() {
    }

    @PostConstruct
    public void init() {
        mensaje = "";
        usuario = new Usuario();
        renderDual = Boolean.FALSE;
        renderBotonIPA = Boolean.FALSE;
        renderBotonPataNegra = Boolean.FALSE;
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

    public void accionGuarda() throws Exception {
        if (verificarFormulario()) {
            usuario.setIsEstudiante(Boolean.TRUE);
            if (cb.guardar(usuario)) {
                Usuario a = (Usuario) SessionOperations.getSessionValue("USUARIO");
                if (a != null) {
                    System.out.println("usuario antes de entrar es diferente de null");
                }
                mensaje = "se ha Guardado el test";
                //mostrarMensaje(FacesMessage.SEVERITY_INFO, "Exitoso", "Se ha Guardado el test");
                SessionOperations.setSessionValue("USER", Boolean.TRUE);
                SessionOperations.setSessionValue("ADMIN", Boolean.FALSE);
                SessionOperations.setSessionValue("USUARIO", usuario);
                SessionOperations.setSessionValue("USUARIOAUX", usuario);
                SessionOperations.setSessionValue("acompanante", acompanante);
                System.out.println("login estudiante");
                if (renderBotonPataNegra) {
                    redirect("usuario/patanegra.xhtml");
                } else if (renderBotonIPA) {
                    redirect("usuario/ipa.xhtml");
                } else if (renderDual) {
                    redirect("usuario/patanegra.xhtml");
                }
            } else {
                mensaje = "Ha fallado al Guardar los datos";
                //mostrarMensaje(FacesMessage.SEVERITY_FATAL, "Error", "Ha fallado al Guardar el test");
            }
        }

    }

    /**
     * Funcion utilizada para verificar campo por campo a diligenciar por el
     * usaurio al momento de restigrase en caso de que el campo se encuentre con
     * informacion invalidad se le mostrara al usuario un mensaje
     *
     * @return @throws Exception
     */
    public Boolean verificarFormulario() throws Exception {
        Boolean resultado = Boolean.TRUE;

        if (usuario.getNumeroIdentificacion() == null) {
            resultado = Boolean.FALSE;
            mensaje = "Agregue número de identificación";
            //mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue número de identificación");
        } else {
            /*Usuario u = (Usuario) cb.getByOneFieldWithOneResult(Usuario.class, "numeroIdentificacion", usuario.getNumeroIdentificacion());
            if (u != null) {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "El usuario ya existe");
            }*/
        }

        try {
            if (acompanate != null) {
                acompanante = (Usuario) cb.getByOneFieldWithOneResult(Usuario.class, "numeroIdentificacion", acompanate);
                //System.out.println("nombre acompanante " + acompanante.getNombreCompleto());
                if (acompanante == null) {
                    resultado = Boolean.FALSE;
                    mensaje = "Error: El acompañante no existe en el sistema";
                    //mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "El del acompañante no existe");
                }
            }
        } catch (Exception e) {
            resultado = Boolean.FALSE;
           mensaje = "Error: El acompañante no existe en el sistema";
        }

        if (usuario.getNombreCompleto().trim().length() == 0) {
            resultado = Boolean.FALSE;
            mensaje = "Agregue su nombre completo";
            //mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su nombre completo");
        }

        if (usuario.getEdad() == null) {
            resultado = Boolean.FALSE;
            mensaje = "Agregue su edad";
            //mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su edad");
        } else {
            if (!(usuario.getEdad() > 0)) {
                resultado = Boolean.FALSE;
                mensaje = "la edad debe ser mayor a 0";
                // mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "la edad debe ser mayor a 0");
            }
        }

        try {
            if (usuario.getGenero().trim().length() == 0) {
                resultado = Boolean.FALSE;
                mensaje = "Seleccione el genero";
                //mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Seleccione el genero");
            }
        } catch (Exception e) {
            resultado = Boolean.FALSE;
            mensaje = "Seleccione el genero";
        }

        try {
            if (usuario.getEstadoCivil().trim().length() == 0) {
                resultado = Boolean.FALSE;
                mensaje = "Seleccione su estado civil actual";
                //mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Seleccione su estado civil actual");
            }
        } catch (Exception e) {
            resultado = Boolean.FALSE;
            mensaje = "Seleccione su estado civil actual";
        }

        try {
            if (usuario.getOcupacion().trim().length() == 0) {
                resultado = Boolean.FALSE;
                mensaje = "Seleccione su ocupación actual";
                //mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Seleccione su ocupación actual");
            }
        } catch (Exception e) {
            resultado = Boolean.FALSE;
            mensaje = "Seleccione su ocupación actual";
        }

        try {
            if (usuario.getEscolaridad().trim().length() == 0) {
                resultado = Boolean.FALSE;
                mensaje = "Seleccione su nivel de educación";
                //mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Seleccione su nivel de educación");
            }
        } catch (Exception e) {
            resultado = Boolean.FALSE;
            mensaje = "Seleccione su nivel de educación";
        }

        if (usuario.getNumeroPersonasConvive() == null) {
            resultado = Boolean.FALSE;
            mensaje = "Agregue el número de personas que conviven en su casa";
            //mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue el número de personas que conviven en su casa");
        } else {
            if (!(usuario.getNumeroPersonasConvive() > 0)) {
                resultado = Boolean.FALSE;
                mensaje = "numero de personas debe ser mayor a 0";
                // mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "la edad debe ser mayor a 0");
            }
        }

        if (usuario.getEmail().trim().length() == 0) {
            resultado = Boolean.FALSE;
            mensaje = "Agregue Correo Electronico";
            //mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue Correo Electronico");
        } else if (!(validateEmail(usuario.getEmail()))) {
            resultado = Boolean.FALSE;
            mensaje = "Formato de Correo Electronico no admitido";
            // mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Formato de Correo Electronico no admitido");
        }

        if (usuario.getTelefono().trim().length() == 0) {
            resultado = Boolean.FALSE;
            mensaje = "Agregue Telefono";
            //mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue Telefono");
        } else {
            String[] campos = usuario.getTelefono().split(" ");
            if (campos.length > 1) {
                resultado = Boolean.FALSE;
                mensaje = "El campo telefono no permite espacio";
                // mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "El campo telefono no permite espacio");
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

    public void onload() {
        System.out.println("id test pasado por parametro " + idtest);
        try {
            u = (Test) cb.getByOneFieldWithOneResult(Test.class, "idManual", idtest);
            if (u != null) {
                System.out.println("test != null");
                System.out.println("" + u.getDuracionTest());
                Date d = new Date(u.getFechayHoraCrecaion().getTime() + u.getDuracionTest());
                System.out.println("d " + d);
                System.out.println("fecha y creacion " + u.getFechayHoraCrecaion());
                if (d.before(new Date())) {
                    System.out.println("before");
                    redirect("testfailed.xhtml");
                } else {
                    System.out.println("else ");
                    SessionOperations.setSessionValue("test", u);
                    if ((u.getPataNegra()) && !(u.getIPA())) {
                        System.out.println(" pata negra true y ipa false");
                        SessionOperations.setSessionValue("test", u);
                        renderBotonPataNegra = Boolean.TRUE;
                    } else if (!(u.getPataNegra()) && (u.getIPA())) {
                        System.out.println(" pata negra false y ipa true");
                        SessionOperations.setSessionValue("test", u);
                        renderBotonIPA = Boolean.TRUE;
                    } else if ((u.getPataNegra()) && (u.getIPA())) {
                        System.out.println(" pata negra true y ipa true");
                        SessionOperations.setSessionValue("test", u);
                        renderDual = Boolean.TRUE;
                    }
                }
            } else {
                System.out.println("test u == null");
                redirect("testfailed.xhtml");
            }
        } catch (Exception ex) {
            System.out.println("catch - test u == null");
            redirect("testfailed.xhtml");
        }
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

    public Long getIdtest() {
        return idtest;
    }

    public void setIdtest(Long idtest) {
        this.idtest = idtest;
    }

    public Boolean getRenderBotonPataNegra() {
        return renderBotonPataNegra;
    }

    public void setRenderBotonPataNegra(Boolean renderBotonPataNegra) {
        this.renderBotonPataNegra = renderBotonPataNegra;
    }

    public Boolean getRenderBotonIPA() {
        return renderBotonIPA;
    }

    public void setRenderBotonIPA(Boolean renderBotonIPA) {
        this.renderBotonIPA = renderBotonIPA;
    }

    public Boolean getRenderDual() {
        return renderDual;
    }

    public void setRenderDual(Boolean renderDual) {
        this.renderDual = renderDual;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Long getAcompanate() {
        return acompanate;
    }

    public void setAcompanate(Long acompanate) {
        this.acompanate = acompanate;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}
