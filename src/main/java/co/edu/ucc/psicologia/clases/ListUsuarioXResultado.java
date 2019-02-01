/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucc.psicologia.clases;

import co.edu.ucc.psicologia.modelo.TipoTestIPA;
import co.edu.ucc.psicologia.modelo.TipoTestPataNegra;
import co.edu.ucc.psicologia.modelo.Usuario;
import java.io.Serializable;

/**
 *ListUsuarioXResultado se utiliza para la organizar y presentar los resultados 
 */
public class ListUsuarioXResultado implements Serializable {
    
    /**
     * usuario que realiza el test
     */
    private Usuario u;
    /**
     * id generado manualmente perteneciente al id del test
     */
    private Long idManualTest;
    /**
     * objeto tipo test ipa
     */
    private TipoTestIPA ipaTest;
    /**
     * objeto tipo test pata negra
     */
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

}
