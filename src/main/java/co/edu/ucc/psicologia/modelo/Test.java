/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucc.psicologia.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.Transient;

/**
 * entidad encargada de generar el test para que se apliquen los intrumentos,
 * aqui se cruza la institucion y el tipo de test que se utilizaran
 *
 * @see CamposComunesdeEntidad
 * @see Serializable
 * @see Entity
 * @author Jorge
 */
@Entity
public class Test extends CamposComunesdeEntidad implements Serializable {

    /**
     * id manual generado cada test
     */
    private Long idManual;
    /**
     * fecha y hora de la creacion del test 
     */
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechayHoraCrecaion;
    /**
     * duracion del test
     */
    private Long duracionTest;
    /**
     * institucion selecionada para el test
     */
    @ManyToOne
    private Institucion institucionaRealizar;
    /**
     * Boolean activar el test tipo pata negra
     */
    private Boolean pataNegra;
    /**
     * Boolean activar el test tipo ippa
     */
    private Boolean IPA;
    @Transient
    private Boolean EstadoActivo;

    public Long getIdManual() {
        return idManual;
    }

    public void setIdManual(Long idManual) {
        this.idManual = idManual;
    }

    public Date getFechayHoraCrecaion() {
        return fechayHoraCrecaion;
    }

    public void setFechayHoraCrecaion(Date fechayHoraCrecaion) {
        this.fechayHoraCrecaion = fechayHoraCrecaion;
    }

    public Long getDuracionTest() {
        return duracionTest;
    }

    public void setDuracionTest(Long duracionTest) {
        this.duracionTest = duracionTest;
    }

    public Institucion getInstitucionaRealizar() {
        return institucionaRealizar;
    }

    public void setInstitucionaRealizar(Institucion institucionaRealizar) {
        this.institucionaRealizar = institucionaRealizar;
    }

    public Boolean getPataNegra() {
        return pataNegra;
    }

    public void setPataNegra(Boolean pataNegra) {
        this.pataNegra = pataNegra;
    }

    public Boolean getIPA() {
        return IPA;
    }

    public void setIPA(Boolean IPA) {
        this.IPA = IPA;
    }

    public Boolean getEstadoActivo() {
        return EstadoActivo;
    }

    public void setEstadoActivo(Boolean EstadoActivo) {
        this.EstadoActivo = EstadoActivo;
    }

}
