/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucc.psicologia.modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 **entidad que almacena toda la informacion cuando se realiza un test de tipo
 * pata negra
 *
 * @author Jorge
 * @see Entity
 * @see CamposComunesdeEntidad
 * @see Serializable
 * @see ManyToOne
 *
 */
@Entity
public class TipoTestPataNegra extends CamposComunesdeEntidad implements Serializable {

    /**
     * test que se asociada a esta respuesta
     */
    @ManyToOne
    private Test test;
    /**
     * usuario que realiza el test
     */
    @ManyToOne
    private Usuario usuario;
    /**
     * usuario que acompaña en la realizacion del test
     */
    @ManyToOne
    private Usuario acompanante;
    private String UsuarioDiagnostico;
    private String diagnostico;
    private String Respuesta1;
    private String Respuesta2;
    private String Respuesta3;
    private String Respuesta4;
    private String Respuesta5;
    private String Respuesta6;
    private String Respuesta7;
    private String Respuesta8;
    private String Respuesta9;
    private String Respuesta10;
    private String Respuesta11;
    private String Respuesta12;
    private String Respuesta13;
    private String Respuesta14;
    private String Respuesta15;
    private String Respuesta16;
    private String Respuesta17;

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getAcompanante() {
        return acompanante;
    }

    public void setAcompanante(Usuario acompanante) {
        this.acompanante = acompanante;
    }

    public String getRespuesta1() {
        return Respuesta1;
    }

    public void setRespuesta1(String Respuesta1) {
        this.Respuesta1 = Respuesta1;
    }

    public String getRespuesta2() {
        return Respuesta2;
    }

    public void setRespuesta2(String Respuesta2) {
        this.Respuesta2 = Respuesta2;
    }

    public String getRespuesta3() {
        return Respuesta3;
    }

    public void setRespuesta3(String Respuesta3) {
        this.Respuesta3 = Respuesta3;
    }

    public String getRespuesta4() {
        return Respuesta4;
    }

    public void setRespuesta4(String Respuesta4) {
        this.Respuesta4 = Respuesta4;
    }

    public String getRespuesta5() {
        return Respuesta5;
    }

    public void setRespuesta5(String Respuesta5) {
        this.Respuesta5 = Respuesta5;
    }

    public String getRespuesta6() {
        return Respuesta6;
    }

    public void setRespuesta6(String Respuesta6) {
        this.Respuesta6 = Respuesta6;
    }

    public String getRespuesta7() {
        return Respuesta7;
    }

    public void setRespuesta7(String Respuesta7) {
        this.Respuesta7 = Respuesta7;
    }

    public String getRespuesta8() {
        return Respuesta8;
    }

    public void setRespuesta8(String Respuesta8) {
        this.Respuesta8 = Respuesta8;
    }

    public String getRespuesta9() {
        return Respuesta9;
    }

    public void setRespuesta9(String Respuesta9) {
        this.Respuesta9 = Respuesta9;
    }

    public String getRespuesta10() {
        return Respuesta10;
    }

    public void setRespuesta10(String Respuesta10) {
        this.Respuesta10 = Respuesta10;
    }

    public String getRespuesta11() {
        return Respuesta11;
    }

    public void setRespuesta11(String Respuesta11) {
        this.Respuesta11 = Respuesta11;
    }

    public String getRespuesta12() {
        return Respuesta12;
    }

    public void setRespuesta12(String Respuesta12) {
        this.Respuesta12 = Respuesta12;
    }

    public String getRespuesta13() {
        return Respuesta13;
    }

    public void setRespuesta13(String Respuesta13) {
        this.Respuesta13 = Respuesta13;
    }

    public String getRespuesta14() {
        return Respuesta14;
    }

    public void setRespuesta14(String Respuesta14) {
        this.Respuesta14 = Respuesta14;
    }

    public String getRespuesta15() {
        return Respuesta15;
    }

    public void setRespuesta15(String Respuesta15) {
        this.Respuesta15 = Respuesta15;
    }

    public String getRespuesta16() {
        return Respuesta16;
    }

    public void setRespuesta16(String Respuesta16) {
        this.Respuesta16 = Respuesta16;
    }

    public String getRespuesta17() {
        return Respuesta17;
    }

    public void setRespuesta17(String Respuesta17) {
        this.Respuesta17 = Respuesta17;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getUsuarioDiagnostico() {
        return UsuarioDiagnostico;
    }

    public void setUsuarioDiagnostico(String UsuarioDiagnostico) {
        this.UsuarioDiagnostico = UsuarioDiagnostico;
    }

}
