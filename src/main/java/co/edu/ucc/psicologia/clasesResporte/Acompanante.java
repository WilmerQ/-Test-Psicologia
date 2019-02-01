/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucc.psicologia.clasesResporte;

/**
 * clase utilizada para mapear la informacion para el reporte
 */
public class Acompanante extends DatosComunes {

    /**
     *Long utilizado para almacenar el numero de identificacion
     */
    Long numeroIdentificacionAcomp;
    /**
     * nombre del usuario acompañante
     */
    String nombreAcomp;
    /**
     * String para almacenar el correo electronico
     */
    String emailAcomp;
    /**
     * String para almacenar el telefono
     */
    String telefonoAcomp;

    public Long getNumeroIdentificacionAcomp() {
        return numeroIdentificacionAcomp;
    }

    public void setNumeroIdentificacionAcomp(Long numeroIdentificacionAcomp) {
        this.numeroIdentificacionAcomp = numeroIdentificacionAcomp;
    }

    public String getNombreAcomp() {
        return nombreAcomp;
    }

    public void setNombreAcomp(String nombreAcomp) {
        this.nombreAcomp = nombreAcomp;
    }

    public String getEmailAcomp() {
        return emailAcomp;
    }

    public void setEmailAcomp(String emailAcomp) {
        this.emailAcomp = emailAcomp;
    }

    public String getTelefonoAcomp() {
        return telefonoAcomp;
    }

    public void setTelefonoAcomp(String telefonoAcomp) {
        this.telefonoAcomp = telefonoAcomp;
    }

}
