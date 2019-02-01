/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucc.psicologia.clasesResporte;

/**
 * clase donde se almacenan los datos que todos los reportes deben presentar de
 * manera obligatoria
 */
public class DatosComunes {

    /**
     * nombre del estudiante o persona que haya aplicado el test
     */
    String nombreCompleto;
    /**
     * numero de identificacion del estudiante
     */
    Long numeroIdentificacion;
    /**
     * edad del estudiante
     */
    Long edad;
    /**
     * genero - Masculino o femenino
     */
    String genero;
    /**
     * estado civil actual
     */
    String estadoCivil;
    /**
     * ocupacion actual
     */
    String ocupacion;
    /**
     * grado de estudio
     */
    String escolaridad;
    /**
     * numero de personas que viven en su hogar
     */
    Long numeroPersonasConviven;
    /**
     * correo electronico de la persona
     */
    String email;
    /**
     * telefono de la persona
     */
    String telefono;

    //institucion
    /**
     * todo test debe estar anidado a un colegio o institucion, String para
     * guardar el nit de la institucion
     */
    String nit;
    /**
     * nombre de la institucion
     */
    String nombreIntitucion;
    /**
     *direccion de la institucion,
     */
    String direccion;

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Long getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(Long numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public Long getEdad() {
        return edad;
    }

    public void setEdad(Long edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getEscolaridad() {
        return escolaridad;
    }

    public void setEscolaridad(String escolaridad) {
        this.escolaridad = escolaridad;
    }

    public Long getNumeroPersonasConviven() {
        return numeroPersonasConviven;
    }

    public void setNumeroPersonasConviven(Long numeroPersonasConviven) {
        this.numeroPersonasConviven = numeroPersonasConviven;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombreIntitucion() {
        return nombreIntitucion;
    }

    public void setNombreIntitucion(String nombreIntitucion) {
        this.nombreIntitucion = nombreIntitucion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}
