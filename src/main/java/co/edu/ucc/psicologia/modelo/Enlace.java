/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucc.psicologia.modelo;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author wilme
 */
@Entity
public class Enlace extends CamposComunesdeEntidad implements Serializable {

    String Url;

    public String getUrl() {
        return Url;
    }

    public void setUrl(String Url) {
        this.Url = Url;
    }

}
