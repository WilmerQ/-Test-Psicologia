/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucc.psicologia.modelo;

import co.edu.ucc.psicologia.clases.ListUsuarioXResultado;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Entidad que se utlizara para almacenar los registros de los resultados que se
 * le hayan generado reporte.
 *
 * @see Entity
 * @see Serializable
 * @see CamposComunesdeEntidad
 * @see ManyToOne
 * @author Jorge
 */
@Entity
public class EntidadParaResultado extends CamposComunesdeEntidad implements Serializable {

    /**
     *id manual para realizar busquedas precisas
     */
    private String idManual;
    /**
     * Usuario que realizo el test 
     */
    @ManyToOne
    private Usuario u;
    /**
     * id generado manualmente perteneciente al id del test
     */
    private Long idManualTest;
    /**
     * objeto tipo test ipa
     */
    @ManyToOne
    private TipoTestIPA ipaTest;
    /**
     * objeto tipo test pata negra
     */
    @ManyToOne
    private TipoTestPataNegra pataNegra;
    /**
     * Boolean en caso que contenga el objeto ipa 
     */
    private Boolean ipaBoolean;
    /**
     * Boolean en caso que contenga el objeto Pata Negra
     */
    private Boolean pataNegraBoolean;
    /**
     * Boolean para cuando el objeto cuanto con los dos tipos de test 
     */
    private Boolean dualTest;

    public EntidadParaResultado() {
    }

    public EntidadParaResultado(ListUsuarioXResultado luxr) {
        this.u = luxr.getU();
        this.ipaBoolean = luxr.getIpaBoolean();
        this.pataNegraBoolean = luxr.getPataNegraBoolean();
        this.dualTest = luxr.getDualTest();
    }

    public Usuario getU() {
        return u;
    }

    public void setU(Usuario u) {
        this.u = u;
    }

    public Long getIdManualTest() {
        return idManualTest;
    }

    public void setIdManualTest(Long idManualTest) {
        this.idManualTest = idManualTest;
    }

    public TipoTestIPA getIpaTest() {
        return ipaTest;
    }

    public void setIpaTest(TipoTestIPA ipaTest) {
        this.ipaTest = ipaTest;
    }

    public TipoTestPataNegra getPataNegra() {
        return pataNegra;
    }

    public void setPataNegra(TipoTestPataNegra pataNegra) {
        this.pataNegra = pataNegra;
    }

    public Boolean getIpaBoolean() {
        return ipaBoolean;
    }

    public void setIpaBoolean(Boolean ipaBoolean) {
        this.ipaBoolean = ipaBoolean;
    }

    public Boolean getPataNegraBoolean() {
        return pataNegraBoolean;
    }

    public void setPataNegraBoolean(Boolean pataNegraBoolean) {
        this.pataNegraBoolean = pataNegraBoolean;
    }

    public Boolean getDualTest() {
        return dualTest;
    }

    public void setDualTest(Boolean dualTest) {
        this.dualTest = dualTest;
    }

    public String getIdManual() {
        return idManual;
    }

    public void setIdManual(String idManual) {
        this.idManual = idManual;
    }

}
