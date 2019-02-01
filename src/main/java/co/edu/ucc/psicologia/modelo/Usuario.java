/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucc.psicologia.modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Transient;

/**
 * entidad que alamcena todos los usuarios del sistema, tanto como los
 * estudiantes que responden un test como lo que registra el administrador
 *
 * @author Jorge
 * @see CamposComunesdeEntidad
 * @see Serializable
 * @see Entity
 *
 */
@Entity
public class Usuario extends CamposComunesdeEntidad implements Serializable {

    /**
     * numeroIdentificacion del usuario o persona
     */
    private Long numeroIdentificacion;
    /**
     * nombre completo del usuario
     */
    private String nombreCompleto;
    /**
     * nombre de usuario (solo para los usuarios registrados por el
     * administrador)
     */
    private String NombreUsuario;
    /**
     * edad (solo disponible para los que respondan un test)
     */
    private Long edad;
    /**
     * genero (solo disponible para los que respondan un test)
     */
    private String genero;
    /**
     * estadoCivil (solo disponible para los que respondan un test)
     */
    private String estadoCivil;
    /**
     * ocupacion (solo disponible para los que respondan un test)
     */
    private String ocupacion;
    /**
     * escolaridad (solo disponible para los que respondan un test)
     */
    private String escolaridad;
    /**
     * numeroPersonasConvive (solo disponible para los que respondan un test)
     */
    private Long numeroPersonasConvive;
    /**
     * correo electronico
     */
    private String email;
    /**
     * telefono
     */
    private String telefono;
    /**
     * contraseña de ingreso (solo para los usuarios registrados por el
     * administrador)
     */
    private String contrasena;
    /**
     * confirmacion de la contraseña (solo para los usuarios registrados por el
     * administrador)
     */
    private Boolean isEstudiante;

    @Transient
    private Integer informeDeError;

    @Lob
    private byte[] imagenperfil;

    public Long getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setNumeroIdentificacion(Long numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String NombreUsuario) {
        this.NombreUsuario = NombreUsuario;
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

    public Long getNumeroPersonasConvive() {
        return numeroPersonasConvive;
    }

    public void setNumeroPersonasConvive(Long numeroPersonasConvive) {
        this.numeroPersonasConvive = numeroPersonasConvive;
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

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Integer getInformeDeError() {
        return informeDeError;
    }

    public void setInformeDeError(Integer informeDeError) {
        this.informeDeError = informeDeError;
    }

    public byte[] getImagenperfil() {
        return imagenperfil;
    }

    public void setImagenperfil(byte[] imagenperfil) {
        this.imagenperfil = imagenperfil;
    }

    public Boolean getIsEstudiante() {
        return isEstudiante;
    }

    public void setIsEstudiante(Boolean isEstudiante) {
        this.isEstudiante = isEstudiante;
    }

}
