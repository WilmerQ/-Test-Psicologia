/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucc.psicologia.modelo;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 * entidad instutucion pensada para almacenar los datos de los lugares donde se
 * aplicaran los test.
 *
 * @see Entity
 * @see CamposComunesdeEntidad
 * @see SerializableF
 * @author Jorge
 */
@Entity
public class Institucion extends CamposComunesdeEntidad implements Serializable {

    /**
     * Strign para guardar el nit de la instutucion 
     */
    private String NIT;
    /**
     * Strign para guardar el nombre
     */
    private String nombre;
    /**
     * String paraalamacenar la direccion
     */
    private String Direccion;

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

}
