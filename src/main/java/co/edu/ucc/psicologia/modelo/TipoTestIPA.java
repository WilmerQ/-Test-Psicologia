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
 * entidad que almacena toda la informacion cuando se realiza un test de tipo
 * ippa
 *
 * @author Jorge
 * @see Entity
 * @see CamposComunesdeEntidad
 * @see Serializable
 * @see ManyToOne
 */
@Entity
public class TipoTestIPA extends CamposComunesdeEntidad implements Serializable {

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
    private String usuarioDiagnostico;
    private String diagnostico;
    private String respuesta1;
    private String respuesta2;
    private String respuesta3;
    private String respuesta4;
    private String respuesta5;
    private String respuesta6;
    private String respuesta7;
    private String respuesta8;
    private String respuesta9;
    private String respuesta10;
    private String respuesta11;
    private String respuesta12;
    private String respuesta13;
    private String respuesta14;
    private String respuesta15;
    private String respuesta16;
    private String respuesta17;
    private String respuesta18;
    private String respuesta19;
    private String respuesta20;
    private String respuesta21;
    private String respuesta22;
    private String respuesta23;
    private String respuesta24;
    private String respuesta25;
    private String respuesta26;
    private String respuesta27;
    private String respuesta28;
    private String respuesta29;
    private String respuesta30;
    private String respuesta31;
    private String respuesta32;
    private String respuesta33;
    private String respuesta34;
    private String respuesta35;
    private String respuesta36;
    private String respuesta37;
    private String respuesta38;
    private String respuesta39;
    private String respuesta40;
    private String respuesta41;
    private String respuesta42;
    private String respuesta43;
    private String respuesta44;
    private String respuesta45;
    private String respuesta46;
    private String respuesta47;
    private String respuesta48;
    private String respuesta49;
    private String respuesta50;
    private String respuesta51;
    private String respuesta52;
    private String respuesta53;
    private String respuesta54;
    private String respuesta55;
    private String respuesta56;
    private String respuesta57;
    private String respuesta58;
    private String respuesta59;
    private String respuesta60;
    private String respuesta61;
    private String respuesta62;
    private String respuesta63;
    private String respuesta64;
    private String respuesta65;
    private String respuesta66;
    private String respuesta67;
    private String respuesta68;
    private String respuesta69;
    private String respuesta70;
    private String respuesta71;
    private String respuesta72;
    private String respuesta73;
    private String respuesta74;
    private String respuesta75;

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
        return respuesta1;
    }

    public void setRespuesta1(String respuesta1) {
        this.respuesta1 = respuesta1;
    }

    public String getRespuesta2() {
        return respuesta2;
    }

    public void setRespuesta2(String respuesta2) {
        this.respuesta2 = respuesta2;
    }

    public String getRespuesta3() {
        return respuesta3;
    }

    public void setRespuesta3(String respuesta3) {
        this.respuesta3 = respuesta3;
    }

    public String getRespuesta4() {
        return respuesta4;
    }

    public void setRespuesta4(String respuesta4) {
        this.respuesta4 = respuesta4;
    }

    public String getRespuesta5() {
        return respuesta5;
    }

    public void setRespuesta5(String respuesta5) {
        this.respuesta5 = respuesta5;
    }

    public String getRespuesta6() {
        return respuesta6;
    }

    public void setRespuesta6(String respuesta6) {
        this.respuesta6 = respuesta6;
    }

    public String getRespuesta7() {
        return respuesta7;
    }

    public void setRespuesta7(String respuesta7) {
        this.respuesta7 = respuesta7;
    }

    public String getRespuesta8() {
        return respuesta8;
    }

    public void setRespuesta8(String respuesta8) {
        this.respuesta8 = respuesta8;
    }

    public String getRespuesta9() {
        return respuesta9;
    }

    public void setRespuesta9(String respuesta9) {
        this.respuesta9 = respuesta9;
    }

    public String getRespuesta10() {
        return respuesta10;
    }

    public void setRespuesta10(String respuesta10) {
        this.respuesta10 = respuesta10;
    }

    public String getRespuesta11() {
        return respuesta11;
    }

    public void setRespuesta11(String respuesta11) {
        this.respuesta11 = respuesta11;
    }

    public String getRespuesta12() {
        return respuesta12;
    }

    public void setRespuesta12(String respuesta12) {
        this.respuesta12 = respuesta12;
    }

    public String getRespuesta13() {
        return respuesta13;
    }

    public void setRespuesta13(String respuesta13) {
        this.respuesta13 = respuesta13;
    }

    public String getRespuesta14() {
        return respuesta14;
    }

    public void setRespuesta14(String respuesta14) {
        this.respuesta14 = respuesta14;
    }

    public String getRespuesta15() {
        return respuesta15;
    }

    public void setRespuesta15(String respuesta15) {
        this.respuesta15 = respuesta15;
    }

    public String getRespuesta16() {
        return respuesta16;
    }

    public void setRespuesta16(String respuesta16) {
        this.respuesta16 = respuesta16;
    }

    public String getRespuesta17() {
        return respuesta17;
    }

    public void setRespuesta17(String respuesta17) {
        this.respuesta17 = respuesta17;
    }

    public String getRespuesta18() {
        return respuesta18;
    }

    public void setRespuesta18(String respuesta18) {
        this.respuesta18 = respuesta18;
    }

    public String getRespuesta19() {
        return respuesta19;
    }

    public void setRespuesta19(String respuesta19) {
        this.respuesta19 = respuesta19;
    }

    public String getRespuesta20() {
        return respuesta20;
    }

    public void setRespuesta20(String respuesta20) {
        this.respuesta20 = respuesta20;
    }

    public String getRespuesta21() {
        return respuesta21;
    }

    public void setRespuesta21(String respuesta21) {
        this.respuesta21 = respuesta21;
    }

    public String getRespuesta22() {
        return respuesta22;
    }

    public void setRespuesta22(String respuesta22) {
        this.respuesta22 = respuesta22;
    }

    public String getRespuesta23() {
        return respuesta23;
    }

    public void setRespuesta23(String respuesta23) {
        this.respuesta23 = respuesta23;
    }

    public String getRespuesta24() {
        return respuesta24;
    }

    public void setRespuesta24(String respuesta24) {
        this.respuesta24 = respuesta24;
    }

    public String getRespuesta25() {
        return respuesta25;
    }

    public void setRespuesta25(String respuesta25) {
        this.respuesta25 = respuesta25;
    }

    public String getRespuesta26() {
        return respuesta26;
    }

    public void setRespuesta26(String respuesta26) {
        this.respuesta26 = respuesta26;
    }

    public String getRespuesta27() {
        return respuesta27;
    }

    public void setRespuesta27(String respuesta27) {
        this.respuesta27 = respuesta27;
    }

    public String getRespuesta28() {
        return respuesta28;
    }

    public void setRespuesta28(String respuesta28) {
        this.respuesta28 = respuesta28;
    }

    public String getRespuesta29() {
        return respuesta29;
    }

    public void setRespuesta29(String respuesta29) {
        this.respuesta29 = respuesta29;
    }

    public String getRespuesta30() {
        return respuesta30;
    }

    public void setRespuesta30(String respuesta30) {
        this.respuesta30 = respuesta30;
    }

    public String getRespuesta31() {
        return respuesta31;
    }

    public void setRespuesta31(String respuesta31) {
        this.respuesta31 = respuesta31;
    }

    public String getRespuesta32() {
        return respuesta32;
    }

    public void setRespuesta32(String respuesta32) {
        this.respuesta32 = respuesta32;
    }

    public String getRespuesta33() {
        return respuesta33;
    }

    public void setRespuesta33(String respuesta33) {
        this.respuesta33 = respuesta33;
    }

    public String getRespuesta34() {
        return respuesta34;
    }

    public void setRespuesta34(String respuesta34) {
        this.respuesta34 = respuesta34;
    }

    public String getRespuesta35() {
        return respuesta35;
    }

    public void setRespuesta35(String respuesta35) {
        this.respuesta35 = respuesta35;
    }

    public String getRespuesta36() {
        return respuesta36;
    }

    public void setRespuesta36(String respuesta36) {
        this.respuesta36 = respuesta36;
    }

    public String getRespuesta37() {
        return respuesta37;
    }

    public void setRespuesta37(String respuesta37) {
        this.respuesta37 = respuesta37;
    }

    public String getRespuesta38() {
        return respuesta38;
    }

    public void setRespuesta38(String respuesta38) {
        this.respuesta38 = respuesta38;
    }

    public String getRespuesta39() {
        return respuesta39;
    }

    public void setRespuesta39(String respuesta39) {
        this.respuesta39 = respuesta39;
    }

    public String getRespuesta40() {
        return respuesta40;
    }

    public void setRespuesta40(String respuesta40) {
        this.respuesta40 = respuesta40;
    }

    public String getRespuesta41() {
        return respuesta41;
    }

    public void setRespuesta41(String respuesta41) {
        this.respuesta41 = respuesta41;
    }

    public String getRespuesta42() {
        return respuesta42;
    }

    public void setRespuesta42(String respuesta42) {
        this.respuesta42 = respuesta42;
    }

    public String getRespuesta43() {
        return respuesta43;
    }

    public void setRespuesta43(String respuesta43) {
        this.respuesta43 = respuesta43;
    }

    public String getRespuesta44() {
        return respuesta44;
    }

    public void setRespuesta44(String respuesta44) {
        this.respuesta44 = respuesta44;
    }

    public String getRespuesta45() {
        return respuesta45;
    }

    public void setRespuesta45(String respuesta45) {
        this.respuesta45 = respuesta45;
    }

    public String getRespuesta46() {
        return respuesta46;
    }

    public void setRespuesta46(String respuesta46) {
        this.respuesta46 = respuesta46;
    }

    public String getRespuesta47() {
        return respuesta47;
    }

    public void setRespuesta47(String respuesta47) {
        this.respuesta47 = respuesta47;
    }

    public String getRespuesta48() {
        return respuesta48;
    }

    public void setRespuesta48(String respuesta48) {
        this.respuesta48 = respuesta48;
    }

    public String getRespuesta49() {
        return respuesta49;
    }

    public void setRespuesta49(String respuesta49) {
        this.respuesta49 = respuesta49;
    }

    public String getRespuesta50() {
        return respuesta50;
    }

    public void setRespuesta50(String respuesta50) {
        this.respuesta50 = respuesta50;
    }

    public String getRespuesta51() {
        return respuesta51;
    }

    public void setRespuesta51(String respuesta51) {
        this.respuesta51 = respuesta51;
    }

    public String getRespuesta52() {
        return respuesta52;
    }

    public void setRespuesta52(String respuesta52) {
        this.respuesta52 = respuesta52;
    }

    public String getRespuesta53() {
        return respuesta53;
    }

    public void setRespuesta53(String respuesta53) {
        this.respuesta53 = respuesta53;
    }

    public String getRespuesta54() {
        return respuesta54;
    }

    public void setRespuesta54(String respuesta54) {
        this.respuesta54 = respuesta54;
    }

    public String getRespuesta55() {
        return respuesta55;
    }

    public void setRespuesta55(String respuesta55) {
        this.respuesta55 = respuesta55;
    }

    public String getRespuesta56() {
        return respuesta56;
    }

    public void setRespuesta56(String respuesta56) {
        this.respuesta56 = respuesta56;
    }

    public String getRespuesta57() {
        return respuesta57;
    }

    public void setRespuesta57(String respuesta57) {
        this.respuesta57 = respuesta57;
    }

    public String getRespuesta58() {
        return respuesta58;
    }

    public void setRespuesta58(String respuesta58) {
        this.respuesta58 = respuesta58;
    }

    public String getRespuesta59() {
        return respuesta59;
    }

    public void setRespuesta59(String respuesta59) {
        this.respuesta59 = respuesta59;
    }

    public String getRespuesta60() {
        return respuesta60;
    }

    public void setRespuesta60(String respuesta60) {
        this.respuesta60 = respuesta60;
    }

    public String getRespuesta61() {
        return respuesta61;
    }

    public void setRespuesta61(String respuesta61) {
        this.respuesta61 = respuesta61;
    }

    public String getRespuesta62() {
        return respuesta62;
    }

    public void setRespuesta62(String respuesta62) {
        this.respuesta62 = respuesta62;
    }

    public String getRespuesta63() {
        return respuesta63;
    }

    public void setRespuesta63(String respuesta63) {
        this.respuesta63 = respuesta63;
    }

    public String getRespuesta64() {
        return respuesta64;
    }

    public void setRespuesta64(String respuesta64) {
        this.respuesta64 = respuesta64;
    }

    public String getRespuesta65() {
        return respuesta65;
    }

    public void setRespuesta65(String respuesta65) {
        this.respuesta65 = respuesta65;
    }

    public String getRespuesta66() {
        return respuesta66;
    }

    public void setRespuesta66(String respuesta66) {
        this.respuesta66 = respuesta66;
    }

    public String getRespuesta67() {
        return respuesta67;
    }

    public void setRespuesta67(String respuesta67) {
        this.respuesta67 = respuesta67;
    }

    public String getRespuesta68() {
        return respuesta68;
    }

    public void setRespuesta68(String respuesta68) {
        this.respuesta68 = respuesta68;
    }

    public String getRespuesta69() {
        return respuesta69;
    }

    public void setRespuesta69(String respuesta69) {
        this.respuesta69 = respuesta69;
    }

    public String getRespuesta70() {
        return respuesta70;
    }

    public void setRespuesta70(String respuesta70) {
        this.respuesta70 = respuesta70;
    }

    public String getRespuesta71() {
        return respuesta71;
    }

    public void setRespuesta71(String respuesta71) {
        this.respuesta71 = respuesta71;
    }

    public String getRespuesta72() {
        return respuesta72;
    }

    public void setRespuesta72(String respuesta72) {
        this.respuesta72 = respuesta72;
    }

    public String getRespuesta73() {
        return respuesta73;
    }

    public void setRespuesta73(String respuesta73) {
        this.respuesta73 = respuesta73;
    }

    public String getRespuesta74() {
        return respuesta74;
    }

    public void setRespuesta74(String respuesta74) {
        this.respuesta74 = respuesta74;
    }

    public String getRespuesta75() {
        return respuesta75;
    }

    public void setRespuesta75(String respuesta75) {
        this.respuesta75 = respuesta75;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getUsuarioDiagnostico() {
        return usuarioDiagnostico;
    }

    public void setUsuarioDiagnostico(String usuarioDiagnostico) {
        this.usuarioDiagnostico = usuarioDiagnostico;
    }

}
