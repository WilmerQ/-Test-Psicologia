/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucc.psicologia.vista;

import co.edu.ucc.psicologia.logica.CommonsBean;
import co.edu.ucc.psicologia.modelo.Institucion;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
@ManagedBean(name = "MbInstitucion")
public class MbInstitucion implements Serializable {

    private List<Institucion> institucions;
    private Institucion institucion;

    @EJB
    private CommonsBean cb;

    public MbInstitucion() {
    }

    @PostConstruct
    public void init() {
        institucion = new Institucion();
        institucions = new ArrayList<>();
        institucions = cb.getAll(Institucion.class);
    }

    public void accionGuarda() {
        if (cb.guardar(institucion)) {
            mostrarMensaje(FacesMessage.SEVERITY_INFO, "Exitoso", "Se ha Guardado la Institución");
            init();
        } else {
            mostrarMensaje(FacesMessage.SEVERITY_FATAL, "Error", "Ha fallado al Guardar el Institución");
        }
    }

    /**
     * cargaRoll
     *
     * @param row
     */
    public void cargaInstitucion(Institucion row) {
        this.institucion = row;
    }

    public void resetInstitucion() {
        this.institucion = new Institucion();
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

    public Institucion getInstitucion() {
        return institucion;
    }

    public void setInstitucion(Institucion institucion) {
        this.institucion = institucion;
    }

    public List<Institucion> getInstitucions() {
        return institucions;
    }

    public void setInstitucions(List<Institucion> institucions) {
        this.institucions = institucions;
    }

}
