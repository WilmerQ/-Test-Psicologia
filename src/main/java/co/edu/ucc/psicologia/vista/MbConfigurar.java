/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucc.psicologia.vista;

import co.edu.ucc.psicologia.logica.CommonsBean;
import co.edu.ucc.psicologia.modelo.Enlace;
import co.edu.ucc.psicologia.modelo.Test;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Jorge
 */
@ViewScoped
@ManagedBean(name = "MbConfigurar")
public class MbConfigurar implements Serializable {

    Enlace enlace;
    List<Enlace> listEnles;
    @EJB
    CommonsBean cb;
    String ip;
    int port;

    public MbConfigurar() {
    }

    @PostConstruct
    public void init() {
        ip = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getServerName();
        port = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getServerPort();

        listEnles = new ArrayList<>();
        listEnles = cb.getAll(Enlace.class);
        try {
            if (!listEnles.isEmpty()) {
                enlace = new Enlace();
                enlace = listEnles.get(0);
            } else {
                enlace = new Enlace();
                enlace.setUrl("http://" + ip + ":" + port + "/psicologia/");
                cb.guardar(enlace);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void accionGuardar() {
        if (verificarFormulario()) {
            if (cb.guardar(enlace)) {
                mostrarMensaje(FacesMessage.SEVERITY_INFO, "Éxito ", "Se ha actualizado");
                init();
            } else {
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "Error ", "No se ha actualizado");
            }
        }
    }

    public Boolean verificarFormulario() {
        Boolean resultado = Boolean.TRUE;

        if (enlace.getUrl().trim().length() == 0) {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Inserte la URL de la aplicación");
        } else {
            String[] campos = enlace.getUrl().split(" ");
            if (campos.length > 1) {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "la URL no permite espacios");
            }
        }
        return resultado;
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

    public Enlace getEnlace() {
        return enlace;
    }

    public void setEnlace(Enlace enlace) {
        this.enlace = enlace;
    }

}
