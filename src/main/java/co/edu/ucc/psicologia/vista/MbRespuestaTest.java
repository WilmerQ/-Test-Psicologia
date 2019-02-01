/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucc.psicologia.vista;

import co.edu.ucc.psicologia.base.SessionOperations;
import co.edu.ucc.psicologia.logica.CommonsBean;
import co.edu.ucc.psicologia.modelo.Test;
import co.edu.ucc.psicologia.modelo.TipoTestIPA;
import co.edu.ucc.psicologia.modelo.TipoTestPataNegra;
import co.edu.ucc.psicologia.modelo.Usuario;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Jorge
 */
@ViewScoped
@ManagedBean(name = "MbRespuestaTest")
public class MbRespuestaTest implements Serializable {

    @EJB
    CommonsBean cb;

    private TipoTestPataNegra pataNegra;
    private TipoTestIPA testIPA;
    private Usuario u;
    private Usuario acompanante;
    private Test test;
    private List<String> respuesta, respuesta2, respuesta3, respuesta4, respuesta5, respuesta6, respuesta7, respuesta8, respuesta9, respuesta10, respuesta11, respuesta12, respuesta13, respuesta14, respuesta15, respuesta16, respuesta17, respuesta18, respuesta19, respuesta20, respuesta21, respuesta22, respuesta23, respuesta24, respuesta25;
    private List<String> respuesta26, respuesta27, respuesta28, respuesta29, respuesta30, respuesta31, respuesta32, respuesta33, respuesta34, respuesta35, respuesta36, respuesta37, respuesta38, respuesta39, respuesta40, respuesta41, respuesta42, respuesta43, respuesta44, respuesta45, respuesta46, respuesta47, respuesta48, respuesta49, respuesta50;
    private List<String> respuesta51, respuesta52, respuesta53, respuesta54, respuesta55, respuesta56, respuesta57, respuesta58, respuesta59, respuesta60, respuesta61, respuesta62, respuesta63, respuesta64, respuesta65, respuesta66, respuesta67, respuesta68, respuesta69, respuesta70, respuesta71, respuesta72, respuesta73, respuesta74, respuesta75;

    /**
     * Creates a new instance of MbRespuestaTest
     */
    public MbRespuestaTest() {
    }

    @PostConstruct
    public void init() {
        pataNegra = new TipoTestPataNegra();
        testIPA = new TipoTestIPA();
        u = (Usuario) SessionOperations.getSessionValue("USUARIOAUX");
        acompanante = (Usuario) SessionOperations.getSessionValue("acompanante");
        test = (Test) SessionOperations.getSessionValue("test");
        if (acompanante != null) {
            System.out.println("nombre acompañante:MbRespuestaTest " + acompanante.getNombreCompleto());
        }
        if (test != null) {
            System.out.println("id test:MbRespuestaTest  " + test.getIdManual());
        }
    }

    public void accionGuardaPataNegra() throws Exception {
        if (verificarFormularioPataNegra()) {
            if (acompanante != null) {
                pataNegra.setAcompanante(acompanante);
            }
            pataNegra.setTest(test);
            pataNegra.setUsuario(u);
            if (cb.guardar(pataNegra)) {
                mostrarMensaje(FacesMessage.SEVERITY_INFO, "Exitoso", "Se ha Guardado el test");
                if (test.getIPA()) {
                    redirect("ipa.xhtml");
                } else {
                    mostrarMensaje(FacesMessage.SEVERITY_INFO, "Exitoso", "Se ha Finalizado el Test");
                    String contextPath = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getContextPath();
                    redirect(contextPath);
                    init();
                }

            } else {
                mostrarMensaje(FacesMessage.SEVERITY_FATAL, "Error", "Ha fallado al Guardar el test");
            }
        }

    }

    /**
     * Metodo encargado de rediccionar como parametro recibe un String que
     * contiene el link ejemplo /usuario/index.xhtml
     *
     * @param url
     */
    private void redirect(String url) {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            context.getExternalContext().redirect(url);
        } catch (IOException ex) {
            Logger.getLogger(MbLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Boolean verificarFormularioPataNegra() {
        Boolean resultado = Boolean.TRUE;
        if (pataNegra.getRespuesta1().trim().length() == 0) {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la lamina #1");
        }

        if (pataNegra.getRespuesta2().trim().length() == 0) {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la lamina #2");
        }

        if (pataNegra.getRespuesta3().trim().length() == 0) {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la lamina #3");
        }

        if (pataNegra.getRespuesta4().trim().length() == 0) {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la lamina #4");
        }

        if (pataNegra.getRespuesta5().trim().length() == 0) {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la lamina #5");
        }

        if (pataNegra.getRespuesta6().trim().length() == 0) {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la lamina #6");
        }

        if (pataNegra.getRespuesta7().trim().length() == 0) {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la lamina #7");
        }

        if (pataNegra.getRespuesta8().trim().length() == 0) {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la lamina #8");
        }

        if (pataNegra.getRespuesta9().trim().length() == 0) {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la lamina #9");
        }

        if (pataNegra.getRespuesta10().trim().length() == 0) {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la lamina #10");
        }

        if (pataNegra.getRespuesta11().trim().length() == 0) {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la lamina #11");
        }

        if (pataNegra.getRespuesta12().trim().length() == 0) {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la lamina #12");
        }

        if (pataNegra.getRespuesta13().trim().length() == 0) {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la lamina #13");
        }

        if (pataNegra.getRespuesta14().trim().length() == 0) {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la lamina #14");
        }

        if (pataNegra.getRespuesta15().trim().length() == 0) {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la lamina #15");
        }

        if (pataNegra.getRespuesta16().trim().length() == 0) {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la lamina #16");
        }

        if (pataNegra.getRespuesta17().trim().length() == 0) {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la lamina #17");
        }
        return resultado;
    }

    public void accionGuardaIPA() throws Exception {
        if (verificarFormularioIPA()) {
            if (acompanante != null) {
                testIPA.setAcompanante(acompanante);
            }
            testIPA.setTest(test);
            testIPA.setUsuario(u);
            if (cb.guardar(testIPA)) {
                mostrarMensaje(FacesMessage.SEVERITY_INFO, "Exitoso", "Se ha Finalizado el Test");
                String contextPath = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getContextPath();
                redirect(contextPath);
                init();
            } else {
                mostrarMensaje(FacesMessage.SEVERITY_FATAL, "Error", "Ha fallado al Guardar el test");
            }
        }
    }

    public Boolean verificarFormularioIPA() {
        Boolean resultado = Boolean.TRUE;

        if (respuesta != null) {
            if (respuesta.size() > 0) {
                testIPA.setRespuesta1(respuesta.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #1");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #1");
        }

        if (respuesta2 != null) {
            if (respuesta2.size() > 0) {
                testIPA.setRespuesta2(respuesta2.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #2");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #2");
        }

        if (respuesta3 != null) {
            if (respuesta3.size() > 0) {
                testIPA.setRespuesta3(respuesta3.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #3");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #3");
        }

        if (respuesta4 != null) {
            if (respuesta4.size() > 0) {
                testIPA.setRespuesta4(respuesta4.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #4");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #4");
        }

        if (respuesta5 != null) {
            if (respuesta5.size() > 0) {
                testIPA.setRespuesta5(respuesta5.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #5");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #5");
        }

        if (respuesta6 != null) {
            if (respuesta6.size() > 0) {
                testIPA.setRespuesta6(respuesta6.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #6");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #6");
        }

        if (respuesta7 != null) {
            if (respuesta7.size() > 0) {
                testIPA.setRespuesta7(respuesta7.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #7");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #7");
        }

        if (respuesta8 != null) {
            if (respuesta8.size() > 0) {
                testIPA.setRespuesta8(respuesta8.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #8");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #8");
        }

        if (respuesta9 != null) {
            if (respuesta9.size() > 0) {
                testIPA.setRespuesta9(respuesta9.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #9");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #9");
        }

        if (respuesta10 != null) {
            if (respuesta10.size() > 0) {
                testIPA.setRespuesta10(respuesta10.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #10");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #10");
        }

        if (respuesta11 != null) {
            if (respuesta11.size() > 0) {
                testIPA.setRespuesta11(respuesta11.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #11");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #11");
        }

        if (respuesta12 != null) {
            if (respuesta12.size() > 0) {
                testIPA.setRespuesta12(respuesta12.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #12");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #12");
        }

        if (respuesta13 != null) {
            if (respuesta13.size() > 0) {
                testIPA.setRespuesta13(respuesta13.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #13");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #13");
        }

        if (respuesta14 != null) {
            if (respuesta14.size() > 0) {
                testIPA.setRespuesta14(respuesta14.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #14");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #14");
        }

        if (respuesta15 != null) {
            if (respuesta15.size() > 0) {
                testIPA.setRespuesta15(respuesta15.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #15");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #15");
        }

        if (respuesta16 != null) {
            if (respuesta16.size() > 0) {
                testIPA.setRespuesta16(respuesta16.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #16");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #16");
        }

        if (respuesta17 != null) {
            if (respuesta17.size() > 0) {
                testIPA.setRespuesta17(respuesta17.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #17");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #17");
        }

        if (respuesta18 != null) {
            if (respuesta18.size() > 0) {
                testIPA.setRespuesta18(respuesta18.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #18");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #18");
        }

        if (respuesta19 != null) {
            if (respuesta19.size() > 0) {
                testIPA.setRespuesta19(respuesta19.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #19");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #19");
        }

        if (respuesta20 != null) {
            if (respuesta20.size() > 0) {
                testIPA.setRespuesta20(respuesta20.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #20");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #20");
        }

        if (respuesta21 != null) {
            if (respuesta21.size() > 0) {
                testIPA.setRespuesta21(respuesta21.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #21");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #21");
        }

        if (respuesta22 != null) {
            if (respuesta22.size() > 0) {
                testIPA.setRespuesta22(respuesta22.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #22");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #22");
        }

        if (respuesta23 != null) {
            if (respuesta23.size() > 0) {
                testIPA.setRespuesta23(respuesta23.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #23");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #23");
        }

        if (respuesta24 != null) {
            if (respuesta24.size() > 0) {
                testIPA.setRespuesta24(respuesta24.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #24");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #24");
        }

        if (respuesta25 != null) {
            if (respuesta25.size() > 0) {
                testIPA.setRespuesta25(respuesta25.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #25");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #25");
        }

        if (respuesta26 != null) {
            if (respuesta26.size() > 0) {
                testIPA.setRespuesta26(respuesta26.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #26");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #26");
        }

        if (respuesta27 != null) {
            if (respuesta27.size() > 0) {
                testIPA.setRespuesta27(respuesta27.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #27");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #27");
        }

        if (respuesta28 != null) {
            if (respuesta28.size() > 0) {
                testIPA.setRespuesta28(respuesta28.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #28");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #28");
        }

        if (respuesta29 != null) {
            if (respuesta29.size() > 0) {
                testIPA.setRespuesta29(respuesta29.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #29");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #29");
        }

        if (respuesta30 != null) {
            if (respuesta30.size() > 0) {
                testIPA.setRespuesta30(respuesta30.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #30");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #30");
        }

        if (respuesta31 != null) {
            if (respuesta31.size() > 0) {
                testIPA.setRespuesta31(respuesta31.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #31");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #31");
        }

        if (respuesta32 != null) {
            if (respuesta32.size() > 0) {
                testIPA.setRespuesta32(respuesta32.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #32");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #32");
        }

        if (respuesta33 != null) {
            if (respuesta33.size() > 0) {
                testIPA.setRespuesta33(respuesta33.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #33");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #33");
        }

        if (respuesta34 != null) {
            if (respuesta34.size() > 0) {
                testIPA.setRespuesta34(respuesta34.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #34");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #34");
        }

        if (respuesta35 != null) {
            if (respuesta35.size() > 0) {
                testIPA.setRespuesta35(respuesta35.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #35");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #35");
        }

        if (respuesta36 != null) {
            if (respuesta36.size() > 0) {
                testIPA.setRespuesta36(respuesta36.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #36");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #36");
        }

        if (respuesta37 != null) {
            if (respuesta37.size() > 0) {
                testIPA.setRespuesta37(respuesta37.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #37");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #37");
        }

        if (respuesta38 != null) {
            if (respuesta38.size() > 0) {
                testIPA.setRespuesta38(respuesta38.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #38");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #38");
        }

        if (respuesta39 != null) {
            if (respuesta39.size() > 0) {
                testIPA.setRespuesta39(respuesta39.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #39");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #39");
        }

        if (respuesta40 != null) {
            if (respuesta40.size() > 0) {
                testIPA.setRespuesta40(respuesta40.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #40");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #40");
        }

        if (respuesta41 != null) {
            if (respuesta41.size() > 0) {
                testIPA.setRespuesta41(respuesta41.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #41");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #41");
        }

        if (respuesta42 != null) {
            if (respuesta42.size() > 0) {
                testIPA.setRespuesta42(respuesta42.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #42");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #42");
        }

        if (respuesta43 != null) {
            if (respuesta43.size() > 0) {
                testIPA.setRespuesta43(respuesta43.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #43");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #43");
        }

        if (respuesta44 != null) {
            if (respuesta44.size() > 0) {
                testIPA.setRespuesta44(respuesta44.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #44");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #44");
        }

        if (respuesta45 != null) {
            if (respuesta45.size() > 0) {
                testIPA.setRespuesta45(respuesta45.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #45");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #45");
        }

        if (respuesta46 != null) {
            if (respuesta46.size() > 0) {
                testIPA.setRespuesta46(respuesta46.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #46");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #46");
        }

        if (respuesta47 != null) {
            if (respuesta47.size() > 0) {
                testIPA.setRespuesta47(respuesta47.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #47");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #47");
        }

        if (respuesta48 != null) {
            if (respuesta48.size() > 0) {
                testIPA.setRespuesta48(respuesta48.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #48");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #48");
        }

        if (respuesta49 != null) {
            if (respuesta49.size() > 0) {
                testIPA.setRespuesta49(respuesta49.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #49");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #49");
        }

        if (respuesta50 != null) {
            if (respuesta50.size() > 0) {
                testIPA.setRespuesta50(respuesta50.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #50");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #50");
        }

        if (respuesta51 != null) {
            if (respuesta51.size() > 0) {
                testIPA.setRespuesta51(respuesta51.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #51");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #51");
        }

        if (respuesta52 != null) {
            if (respuesta52.size() > 0) {
                testIPA.setRespuesta52(respuesta52.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #52");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #52");
        }

        if (respuesta53 != null) {
            if (respuesta53.size() > 0) {
                testIPA.setRespuesta53(respuesta53.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #53");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #53");
        }

        if (respuesta54 != null) {
            if (respuesta54.size() > 0) {
                testIPA.setRespuesta54(respuesta54.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #54");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #54");
        }

        if (respuesta55 != null) {
            if (respuesta55.size() > 0) {
                testIPA.setRespuesta55(respuesta55.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #55");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #55");
        }

        if (respuesta56 != null) {
            if (respuesta56.size() > 0) {
                testIPA.setRespuesta56(respuesta56.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #56");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #56");
        }

        if (respuesta57 != null) {
            if (respuesta57.size() > 0) {
                testIPA.setRespuesta57(respuesta57.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #57");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #57");
        }

        if (respuesta58 != null) {
            if (respuesta58.size() > 0) {
                testIPA.setRespuesta58(respuesta58.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #58");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #58");
        }

        if (respuesta59 != null) {
            if (respuesta59.size() > 0) {
                testIPA.setRespuesta59(respuesta59.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #59");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #59");
        }

        if (respuesta60 != null) {
            if (respuesta60.size() > 0) {
                testIPA.setRespuesta60(respuesta60.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #60");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #60");
        }

        if (respuesta61 != null) {
            if (respuesta61.size() > 0) {
                testIPA.setRespuesta61(respuesta61.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #61");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #61");
        }

        if (respuesta62 != null) {
            if (respuesta62.size() > 0) {
                testIPA.setRespuesta62(respuesta62.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #62");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #62");
        }

        if (respuesta63 != null) {
            if (respuesta63.size() > 0) {
                testIPA.setRespuesta63(respuesta63.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #63");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #63");
        }

        if (respuesta64 != null) {
            if (respuesta64.size() > 0) {
                testIPA.setRespuesta64(respuesta64.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #64");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #64");
        }

        if (respuesta65 != null) {
            if (respuesta65.size() > 0) {
                testIPA.setRespuesta65(respuesta65.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #65");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #65");
        }

        if (respuesta66 != null) {
            if (respuesta66.size() > 0) {
                testIPA.setRespuesta66(respuesta66.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #66");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #66");
        }

        if (respuesta67 != null) {
            if (respuesta67.size() > 0) {
                testIPA.setRespuesta67(respuesta67.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #67");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #67");
        }

        if (respuesta68 != null) {
            if (respuesta68.size() > 0) {
                testIPA.setRespuesta68(respuesta68.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #68");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #68");
        }

        if (respuesta69 != null) {
            if (respuesta69.size() > 0) {
                testIPA.setRespuesta69(respuesta69.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #69");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #69");
        }

        if (respuesta70 != null) {
            if (respuesta70.size() > 0) {
                testIPA.setRespuesta70(respuesta70.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #70");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #70");
        }

        if (respuesta71 != null) {
            if (respuesta71.size() > 0) {
                testIPA.setRespuesta71(respuesta71.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #71");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #71");
        }

        if (respuesta72 != null) {
            if (respuesta72.size() > 0) {
                testIPA.setRespuesta72(respuesta72.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #72");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #72");
        }

        if (respuesta73 != null) {
            if (respuesta73.size() > 0) {
                testIPA.setRespuesta73(respuesta73.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #73");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #73");
        }

        if (respuesta74 != null) {
            if (respuesta74.size() > 0) {
                testIPA.setRespuesta74(respuesta74.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #74");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #74");
        }

        if (respuesta75 != null) {
            if (respuesta75.size() > 0) {
                testIPA.setRespuesta75(respuesta75.get(0));
            } else {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #75");
            }
        } else {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Agregue su respuesta a la pregunta #75");
        }

        return resultado;
    }

    /**
     * Metodo utilizado para ejecutar la presentacion de un mensaje emergente
     * tipo Growl en pantalla
     *
     * @param icono
     * @param titulo
     * @param mensaje
     */
    public void mostrarMensaje(FacesMessage.Severity icono, String titulo, String mensaje) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(icono, titulo, mensaje));
    }

    public void resetTestPataNegra() {
        pataNegra = new TipoTestPataNegra();
    }

    public void resetTestIPA() {
        testIPA = new TipoTestIPA();
    }

    private List<String> aux = new ArrayList<>();

    public void cambio() {
        if (respuesta.size() > 1) {
            System.out.println("mayor a 1");
            respuesta.removeAll(aux);
            aux = respuesta;
        } else if (respuesta.size() == 1) {
            if (!aux.isEmpty()) {
                aux.clear();
            }
            aux = respuesta;
        }
        System.out.println("respuesta" + respuesta.size());
        for (int i = 0; i < respuesta.size(); i++) {
            System.out.println("i -" + i + " " + respuesta.get(i));
        }
    }

    private List<String> auxr2 = new ArrayList<>();

    public void cambior2() {
        if (respuesta2.size() > 1) {
            System.out.println("mayor a 1");
            respuesta2.removeAll(auxr2);
            auxr2 = respuesta2;
        } else if (respuesta2.size() == 1) {
            if (!auxr2.isEmpty()) {
                auxr2.clear();
            }
            auxr2 = respuesta2;
        }
        System.out.println("respuesta2 " + respuesta2.size());
        for (int i = 0; i < respuesta2.size(); i++) {
            System.out.println("i -" + i + " " + respuesta2.get(i));
        }
    }

    private List<String> auxr3 = new ArrayList<>();

    public void cambior3() {
        if (respuesta3.size() > 1) {
            System.out.println("mayor a 1");
            respuesta3.removeAll(auxr3);
            auxr3 = respuesta3;
        } else if (respuesta3.size() == 1) {
            if (!auxr3.isEmpty()) {
                auxr3.clear();
            }
            auxr3 = respuesta3;
        }
        System.out.println("respuesta3 " + respuesta3.size());
        for (int i = 0; i < respuesta3.size(); i++) {
            System.out.println("i -" + i + " " + respuesta3.get(i));
        }
    }

    private List<String> auxr4 = new ArrayList<>();

    public void cambior4() {
        if (respuesta4.size() > 1) {
            System.out.println("mayor a 1");
            respuesta4.removeAll(auxr4);
            auxr4 = respuesta4;
        } else if (respuesta4.size() == 1) {
            if (!auxr4.isEmpty()) {
                auxr4.clear();
            }
            auxr4 = respuesta4;
        }
        System.out.println("respuesta4 " + respuesta4.size());
        for (int i = 0; i < respuesta4.size(); i++) {
            System.out.println("i -" + i + " " + respuesta4.get(i));
        }
    }

    private List<String> auxr5 = new ArrayList<>();

    public void cambior5() {
        if (respuesta5.size() > 1) {
            System.out.println("mayor a 1");
            respuesta5.removeAll(auxr5);
            auxr5 = respuesta5;
        } else if (respuesta5.size() == 1) {
            if (!auxr5.isEmpty()) {
                auxr5.clear();
            }
            auxr5 = respuesta5;
        }
        System.out.println("respuesta5 " + respuesta5.size());
        for (int i = 0; i < respuesta5.size(); i++) {
            System.out.println("i -" + i + " " + respuesta5.get(i));
        }
    }

    private List<String> auxr6 = new ArrayList<>();

    public void cambior6() {
        if (respuesta6.size() > 1) {
            System.out.println("mayor a 1");
            respuesta6.removeAll(auxr6);
            auxr6 = respuesta6;
        } else if (respuesta6.size() == 1) {
            if (!auxr6.isEmpty()) {
                auxr6.clear();
            }
            auxr6 = respuesta6;
        }
        System.out.println("respuesta6 " + respuesta6.size());
        for (int i = 0; i < respuesta6.size(); i++) {
            System.out.println("i -" + i + " " + respuesta6.get(i));
        }
    }

    private List<String> auxr7 = new ArrayList<>();

    public void cambior7() {
        if (respuesta7.size() > 1) {
            System.out.println("mayor a 1");
            respuesta7.removeAll(auxr7);
            auxr7 = respuesta7;
        } else if (respuesta7.size() == 1) {
            if (!auxr7.isEmpty()) {
                auxr7.clear();
            }
            auxr7 = respuesta7;
        }
        System.out.println("respuesta7 " + respuesta7.size());
        for (int i = 0; i < respuesta7.size(); i++) {
            System.out.println("i -" + i + " " + respuesta7.get(i));
        }
    }

    private List<String> auxr8 = new ArrayList<>();

    public void cambior8() {
        if (respuesta8.size() > 1) {
            System.out.println("mayor a 1");
            respuesta8.removeAll(auxr8);
            auxr8 = respuesta8;
        } else if (respuesta8.size() == 1) {
            if (!auxr8.isEmpty()) {
                auxr8.clear();
            }
            auxr8 = respuesta8;
        }
        System.out.println("respuesta8 " + respuesta8.size());
        for (int i = 0; i < respuesta8.size(); i++) {
            System.out.println("i -" + i + " " + respuesta8.get(i));
        }
    }

    private List<String> auxr9 = new ArrayList<>();

    public void cambior9() {
        if (respuesta9.size() > 1) {
            System.out.println("mayor a 1");
            respuesta9.removeAll(auxr9);
            auxr9 = respuesta9;
        } else if (respuesta9.size() == 1) {
            if (!auxr9.isEmpty()) {
                auxr9.clear();
            }
            auxr9 = respuesta9;
        }
        System.out.println("respuesta9 " + respuesta9.size());
        for (int i = 0; i < respuesta9.size(); i++) {
            System.out.println("i -" + i + " " + respuesta9.get(i));
        }
    }

    private List<String> auxr10 = new ArrayList<>();

    public void cambior10() {
        if (respuesta10.size() > 1) {
            System.out.println("mayor a 1");
            respuesta10.removeAll(auxr10);
            auxr10 = respuesta10;
        } else if (respuesta10.size() == 1) {
            if (!auxr10.isEmpty()) {
                auxr10.clear();
            }
            auxr10 = respuesta10;
        }
        System.out.println("respuesta10 " + respuesta10.size());
        for (int i = 0; i < respuesta10.size(); i++) {
            System.out.println("i -" + i + " " + respuesta10.get(i));
        }
    }

    private List<String> auxr11 = new ArrayList<>();

    public void cambior11() {
        if (respuesta11.size() > 1) {
            System.out.println("mayor a 1");
            respuesta11.removeAll(auxr11);
            auxr11 = respuesta11;
        } else if (respuesta11.size() == 1) {
            if (!auxr11.isEmpty()) {
                auxr11.clear();
            }
            auxr11 = respuesta11;
        }
        System.out.println("respuesta11 " + respuesta11.size());
        for (int i = 0; i < respuesta11.size(); i++) {
            System.out.println("i -" + i + " " + respuesta11.get(i));
        }
    }

    private List<String> auxr12 = new ArrayList<>();

    public void cambior12() {
        if (respuesta12.size() > 1) {
            System.out.println("mayor a 1");
            respuesta12.removeAll(auxr12);
            auxr12 = respuesta12;
        } else if (respuesta12.size() == 1) {
            if (!auxr12.isEmpty()) {
                auxr12.clear();
            }
            auxr12 = respuesta12;
        }
        System.out.println("respuesta12 " + respuesta12.size());
        for (int i = 0; i < respuesta12.size(); i++) {
            System.out.println("i -" + i + " " + respuesta12.get(i));
        }
    }

    private List<String> auxr13 = new ArrayList<>();

    public void cambior13() {
        if (respuesta13.size() > 1) {
            System.out.println("mayor a 1");
            respuesta13.removeAll(auxr13);
            auxr13 = respuesta13;
        } else if (respuesta13.size() == 1) {
            if (!auxr13.isEmpty()) {
                auxr13.clear();
            }
            auxr13 = respuesta13;
        }
        System.out.println("respuesta13 " + respuesta13.size());
        for (int i = 0; i < respuesta13.size(); i++) {
            System.out.println("i -" + i + " " + respuesta13.get(i));
        }
    }

    private List<String> auxr14 = new ArrayList<>();

    public void cambior14() {
        if (respuesta14.size() > 1) {
            System.out.println("mayor a 1");
            respuesta14.removeAll(auxr14);
            auxr14 = respuesta14;
        } else if (respuesta14.size() == 1) {
            if (!auxr14.isEmpty()) {
                auxr14.clear();
            }
            auxr14 = respuesta14;
        }
        System.out.println("respuesta14 " + respuesta14.size());
        for (int i = 0; i < respuesta14.size(); i++) {
            System.out.println("i -" + i + " " + respuesta14.get(i));
        }
    }

    private List<String> auxr15 = new ArrayList<>();

    public void cambior15() {
        if (respuesta15.size() > 1) {
            System.out.println("mayor a 1");
            respuesta15.removeAll(auxr15);
            auxr15 = respuesta15;
        } else if (respuesta15.size() == 1) {
            if (!auxr15.isEmpty()) {
                auxr15.clear();
            }
            auxr15 = respuesta15;
        }
        System.out.println("respuesta15 " + respuesta15.size());
        for (int i = 0; i < respuesta15.size(); i++) {
            System.out.println("i -" + i + " " + respuesta15.get(i));
        }
    }

    private List<String> auxr16 = new ArrayList<>();

    public void cambior16() {
        if (respuesta16.size() > 1) {
            System.out.println("mayor a 1");
            respuesta16.removeAll(auxr16);
            auxr16 = respuesta16;
        } else if (respuesta16.size() == 1) {
            if (!auxr16.isEmpty()) {
                auxr16.clear();
            }
            auxr16 = respuesta16;
        }
        System.out.println("respuesta16 " + respuesta16.size());
        for (int i = 0; i < respuesta16.size(); i++) {
            System.out.println("i -" + i + " " + respuesta16.get(i));
        }
    }

    private List<String> auxr17 = new ArrayList<>();

    public void cambior17() {
        if (respuesta17.size() > 1) {
            System.out.println("mayor a 1");
            respuesta17.removeAll(auxr17);
            auxr17 = respuesta17;
        } else if (respuesta17.size() == 1) {
            if (!auxr17.isEmpty()) {
                auxr17.clear();
            }
            auxr17 = respuesta17;
        }
        System.out.println("respuesta17 " + respuesta17.size());
        for (int i = 0; i < respuesta17.size(); i++) {
            System.out.println("i -" + i + " " + respuesta17.get(i));
        }
    }

    private List<String> auxr18 = new ArrayList<>();

    public void cambior18() {
        if (respuesta18.size() > 1) {
            System.out.println("mayor a 1");
            respuesta18.removeAll(auxr18);
            auxr18 = respuesta18;
        } else if (respuesta18.size() == 1) {
            if (!auxr18.isEmpty()) {
                auxr18.clear();
            }
            auxr18 = respuesta18;
        }
        System.out.println("respuesta18 " + respuesta18.size());
        for (int i = 0; i < respuesta18.size(); i++) {
            System.out.println("i -" + i + " " + respuesta18.get(i));
        }
    }

    private List<String> auxr19 = new ArrayList<>();

    public void cambior19() {
        if (respuesta19.size() > 1) {
            System.out.println("mayor a 1");
            respuesta19.removeAll(auxr19);
            auxr19 = respuesta19;
        } else if (respuesta19.size() == 1) {
            if (!auxr19.isEmpty()) {
                auxr19.clear();
            }
            auxr19 = respuesta19;
        }
        System.out.println("respuesta19 " + respuesta19.size());
        for (int i = 0; i < respuesta19.size(); i++) {
            System.out.println("i -" + i + " " + respuesta19.get(i));
        }
    }

    private List<String> auxr20 = new ArrayList<>();

    public void cambior20() {
        if (respuesta20.size() > 1) {
            System.out.println("mayor a 1");
            respuesta20.removeAll(auxr20);
            auxr20 = respuesta20;
        } else if (respuesta20.size() == 1) {
            if (!auxr20.isEmpty()) {
                auxr20.clear();
            }
            auxr20 = respuesta20;
        }
        System.out.println("respuesta20 " + respuesta20.size());
        for (int i = 0; i < respuesta20.size(); i++) {
            System.out.println("i -" + i + " " + respuesta20.get(i));
        }
    }

    private List<String> auxr21 = new ArrayList<>();

    public void cambior21() {
        if (respuesta21.size() > 1) {
            System.out.println("mayor a 1");
            respuesta21.removeAll(auxr21);
            auxr21 = respuesta21;
        } else if (respuesta21.size() == 1) {
            if (!auxr21.isEmpty()) {
                auxr21.clear();
            }
            auxr21 = respuesta21;
        }
        System.out.println("respuesta21 " + respuesta21.size());
        for (int i = 0; i < respuesta21.size(); i++) {
            System.out.println("i -" + i + " " + respuesta21.get(i));
        }
    }

    private List<String> auxr22 = new ArrayList<>();

    public void cambior22() {
        if (respuesta22.size() > 1) {
            System.out.println("mayor a 1");
            respuesta22.removeAll(auxr22);
            auxr22 = respuesta22;
        } else if (respuesta22.size() == 1) {
            if (!auxr22.isEmpty()) {
                auxr22.clear();
            }
            auxr22 = respuesta22;
        }
        System.out.println("respuesta22 " + respuesta22.size());
        for (int i = 0; i < respuesta22.size(); i++) {
            System.out.println("i -" + i + " " + respuesta22.get(i));
        }
    }

    private List<String> auxr23 = new ArrayList<>();

    public void cambior23() {
        if (respuesta23.size() > 1) {
            System.out.println("mayor a 1");
            respuesta23.removeAll(auxr23);
            auxr23 = respuesta23;
        } else if (respuesta23.size() == 1) {
            if (!auxr23.isEmpty()) {
                auxr23.clear();
            }
            auxr23 = respuesta23;
        }
        System.out.println("respuesta23 " + respuesta23.size());
        for (int i = 0; i < respuesta23.size(); i++) {
            System.out.println("i -" + i + " " + respuesta23.get(i));
        }
    }

    private List<String> auxr24 = new ArrayList<>();

    public void cambior24() {
        if (respuesta24.size() > 1) {
            System.out.println("mayor a 1");
            respuesta24.removeAll(auxr24);
            auxr24 = respuesta24;
        } else if (respuesta24.size() == 1) {
            if (!auxr24.isEmpty()) {
                auxr24.clear();
            }
            auxr24 = respuesta24;
        }
        System.out.println("respuesta24 " + respuesta24.size());
        for (int i = 0; i < respuesta24.size(); i++) {
            System.out.println("i -" + i + " " + respuesta24.get(i));
        }
    }

    private List<String> auxr25 = new ArrayList<>();

    public void cambior25() {
        if (respuesta25.size() > 1) {
            System.out.println("mayor a 1");
            respuesta25.removeAll(auxr25);
            auxr25 = respuesta25;
        } else if (respuesta25.size() == 1) {
            if (!auxr25.isEmpty()) {
                auxr25.clear();
            }
            auxr25 = respuesta25;
        }
        System.out.println("respuesta25 " + respuesta25.size());
        for (int i = 0; i < respuesta25.size(); i++) {
            System.out.println("i -" + i + " " + respuesta25.get(i));
        }
    }

    private List<String> auxr26 = new ArrayList<>();

    public void cambior26() {
        if (respuesta26.size() > 1) {
            System.out.println("mayor a 1");
            respuesta26.removeAll(auxr26);
            auxr26 = respuesta26;
        } else if (respuesta26.size() == 1) {
            if (!auxr26.isEmpty()) {
                auxr26.clear();
            }
            auxr26 = respuesta26;
        }
        System.out.println("respuesta26 " + respuesta26.size());
        for (int i = 0; i < respuesta26.size(); i++) {
            System.out.println("i -" + i + " " + respuesta26.get(i));
        }
    }

    private List<String> auxr27 = new ArrayList<>();

    public void cambior27() {
        if (respuesta27.size() > 1) {
            System.out.println("mayor a 1");
            respuesta27.removeAll(auxr27);
            auxr27 = respuesta27;
        } else if (respuesta27.size() == 1) {
            if (!auxr27.isEmpty()) {
                auxr27.clear();
            }
            auxr27 = respuesta27;
        }
        System.out.println("respuesta27 " + respuesta27.size());
        for (int i = 0; i < respuesta27.size(); i++) {
            System.out.println("i -" + i + " " + respuesta27.get(i));
        }
    }

    private List<String> auxr28 = new ArrayList<>();

    public void cambior28() {
        if (respuesta28.size() > 1) {
            System.out.println("mayor a 1");
            respuesta28.removeAll(auxr28);
            auxr28 = respuesta28;
        } else if (respuesta28.size() == 1) {
            if (!auxr28.isEmpty()) {
                auxr28.clear();
            }
            auxr28 = respuesta28;
        }
        System.out.println("respuesta28 " + respuesta28.size());
        for (int i = 0; i < respuesta28.size(); i++) {
            System.out.println("i -" + i + " " + respuesta28.get(i));
        }
    }

    private List<String> auxr29 = new ArrayList<>();

    public void cambior29() {
        if (respuesta29.size() > 1) {
            System.out.println("mayor a 1");
            respuesta29.removeAll(auxr29);
            auxr29 = respuesta29;
        } else if (respuesta29.size() == 1) {
            if (!auxr29.isEmpty()) {
                auxr29.clear();
            }
            auxr29 = respuesta29;
        }
        System.out.println("respuesta29 " + respuesta29.size());
        for (int i = 0; i < respuesta29.size(); i++) {
            System.out.println("i -" + i + " " + respuesta29.get(i));
        }
    }

    private List<String> auxr30 = new ArrayList<>();

    public void cambior30() {
        if (respuesta30.size() > 1) {
            System.out.println("mayor a 1");
            respuesta30.removeAll(auxr30);
            auxr30 = respuesta30;
        } else if (respuesta30.size() == 1) {
            if (!auxr30.isEmpty()) {
                auxr30.clear();
            }
            auxr30 = respuesta30;
        }
        System.out.println("respuesta30 " + respuesta30.size());
        for (int i = 0; i < respuesta30.size(); i++) {
            System.out.println("i -" + i + " " + respuesta30.get(i));
        }
    }

    private List<String> auxr31 = new ArrayList<>();

    public void cambior31() {
        if (respuesta31.size() > 1) {
            System.out.println("mayor a 1");
            respuesta31.removeAll(auxr31);
            auxr31 = respuesta31;
        } else if (respuesta31.size() == 1) {
            if (!auxr31.isEmpty()) {
                auxr31.clear();
            }
            auxr31 = respuesta31;
        }
        System.out.println("respuesta31 " + respuesta31.size());
        for (int i = 0; i < respuesta31.size(); i++) {
            System.out.println("i -" + i + " " + respuesta31.get(i));
        }
    }

    private List<String> auxr32 = new ArrayList<>();

    public void cambior32() {
        if (respuesta32.size() > 1) {
            System.out.println("mayor a 1");
            respuesta32.removeAll(auxr32);
            auxr32 = respuesta32;
        } else if (respuesta32.size() == 1) {
            if (!auxr32.isEmpty()) {
                auxr32.clear();
            }
            auxr32 = respuesta32;
        }
        System.out.println("respuesta32 " + respuesta32.size());
        for (int i = 0; i < respuesta32.size(); i++) {
            System.out.println("i -" + i + " " + respuesta32.get(i));
        }
    }

    private List<String> auxr33 = new ArrayList<>();

    public void cambior33() {
        if (respuesta33.size() > 1) {
            System.out.println("mayor a 1");
            respuesta33.removeAll(auxr33);
            auxr33 = respuesta33;
        } else if (respuesta33.size() == 1) {
            if (!auxr33.isEmpty()) {
                auxr33.clear();
            }
            auxr33 = respuesta33;
        }
        System.out.println("respuesta33 " + respuesta33.size());
        for (int i = 0; i < respuesta33.size(); i++) {
            System.out.println("i -" + i + " " + respuesta33.get(i));
        }
    }

    private List<String> auxr34 = new ArrayList<>();

    public void cambior34() {
        if (respuesta34.size() > 1) {
            System.out.println("mayor a 1");
            respuesta34.removeAll(auxr34);
            auxr34 = respuesta34;
        } else if (respuesta34.size() == 1) {
            if (!auxr34.isEmpty()) {
                auxr34.clear();
            }
            auxr34 = respuesta34;
        }
        System.out.println("respuesta34 " + respuesta34.size());
        for (int i = 0; i < respuesta34.size(); i++) {
            System.out.println("i -" + i + " " + respuesta34.get(i));
        }
    }

    private List<String> auxr35 = new ArrayList<>();

    public void cambior35() {
        if (respuesta35.size() > 1) {
            System.out.println("mayor a 1");
            respuesta35.removeAll(auxr35);
            auxr35 = respuesta35;
        } else if (respuesta35.size() == 1) {
            if (!auxr35.isEmpty()) {
                auxr35.clear();
            }
            auxr35 = respuesta35;
        }
        System.out.println("respuesta35 " + respuesta35.size());
        for (int i = 0; i < respuesta35.size(); i++) {
            System.out.println("i -" + i + " " + respuesta35.get(i));
        }
    }

    private List<String> auxr36 = new ArrayList<>();

    public void cambior36() {
        if (respuesta36.size() > 1) {
            System.out.println("mayor a 1");
            respuesta36.removeAll(auxr36);
            auxr36 = respuesta36;
        } else if (respuesta36.size() == 1) {
            if (!auxr36.isEmpty()) {
                auxr36.clear();
            }
            auxr36 = respuesta36;
        }
        System.out.println("respuesta36 " + respuesta36.size());
        for (int i = 0; i < respuesta36.size(); i++) {
            System.out.println("i -" + i + " " + respuesta36.get(i));
        }
    }

    private List<String> auxr37 = new ArrayList<>();

    public void cambior37() {
        if (respuesta37.size() > 1) {
            System.out.println("mayor a 1");
            respuesta37.removeAll(auxr37);
            auxr37 = respuesta37;
        } else if (respuesta37.size() == 1) {
            if (!auxr37.isEmpty()) {
                auxr37.clear();
            }
            auxr37 = respuesta37;
        }
        System.out.println("respuesta37 " + respuesta37.size());
        for (int i = 0; i < respuesta37.size(); i++) {
            System.out.println("i -" + i + " " + respuesta37.get(i));
        }
    }

    private List<String> auxr38 = new ArrayList<>();

    public void cambior38() {
        if (respuesta38.size() > 1) {
            System.out.println("mayor a 1");
            respuesta38.removeAll(auxr38);
            auxr38 = respuesta38;
        } else if (respuesta38.size() == 1) {
            if (!auxr38.isEmpty()) {
                auxr38.clear();
            }
            auxr38 = respuesta38;
        }
        System.out.println("respuesta38 " + respuesta38.size());
        for (int i = 0; i < respuesta38.size(); i++) {
            System.out.println("i -" + i + " " + respuesta38.get(i));
        }
    }

    private List<String> auxr39 = new ArrayList<>();

    public void cambior39() {
        if (respuesta39.size() > 1) {
            System.out.println("mayor a 1");
            respuesta39.removeAll(auxr39);
            auxr39 = respuesta39;
        } else if (respuesta39.size() == 1) {
            if (!auxr39.isEmpty()) {
                auxr39.clear();
            }
            auxr39 = respuesta39;
        }
        System.out.println("respuesta39 " + respuesta39.size());
        for (int i = 0; i < respuesta39.size(); i++) {
            System.out.println("i -" + i + " " + respuesta39.get(i));
        }
    }

    private List<String> auxr40 = new ArrayList<>();

    public void cambior40() {
        if (respuesta40.size() > 1) {
            System.out.println("mayor a 1");
            respuesta40.removeAll(auxr40);
            auxr40 = respuesta40;
        } else if (respuesta40.size() == 1) {
            if (!auxr40.isEmpty()) {
                auxr40.clear();
            }
            auxr40 = respuesta40;
        }
        System.out.println("respuesta40 " + respuesta40.size());
        for (int i = 0; i < respuesta40.size(); i++) {
            System.out.println("i -" + i + " " + respuesta40.get(i));
        }
    }

    private List<String> auxr41 = new ArrayList<>();

    public void cambior41() {
        if (respuesta41.size() > 1) {
            System.out.println("mayor a 1");
            respuesta41.removeAll(auxr41);
            auxr41 = respuesta41;
        } else if (respuesta41.size() == 1) {
            if (!auxr41.isEmpty()) {
                auxr41.clear();
            }
            auxr41 = respuesta41;
        }
        System.out.println("respuesta41 " + respuesta41.size());
        for (int i = 0; i < respuesta41.size(); i++) {
            System.out.println("i -" + i + " " + respuesta41.get(i));
        }
    }

    private List<String> auxr42 = new ArrayList<>();

    public void cambior42() {
        if (respuesta42.size() > 1) {
            System.out.println("mayor a 1");
            respuesta42.removeAll(auxr42);
            auxr42 = respuesta42;
        } else if (respuesta42.size() == 1) {
            if (!auxr42.isEmpty()) {
                auxr42.clear();
            }
            auxr42 = respuesta42;
        }
        System.out.println("respuesta42 " + respuesta42.size());
        for (int i = 0; i < respuesta42.size(); i++) {
            System.out.println("i -" + i + " " + respuesta42.get(i));
        }
    }

    private List<String> auxr43 = new ArrayList<>();

    public void cambior43() {
        if (respuesta43.size() > 1) {
            System.out.println("mayor a 1");
            respuesta43.removeAll(auxr43);
            auxr43 = respuesta43;
        } else if (respuesta43.size() == 1) {
            if (!auxr43.isEmpty()) {
                auxr43.clear();
            }
            auxr43 = respuesta43;
        }
        System.out.println("respuesta43 " + respuesta43.size());
        for (int i = 0; i < respuesta43.size(); i++) {
            System.out.println("i -" + i + " " + respuesta43.get(i));
        }
    }

    private List<String> auxr44 = new ArrayList<>();

    public void cambior44() {
        if (respuesta44.size() > 1) {
            System.out.println("mayor a 1");
            respuesta44.removeAll(auxr44);
            auxr44 = respuesta44;
        } else if (respuesta44.size() == 1) {
            if (!auxr44.isEmpty()) {
                auxr44.clear();
            }
            auxr44 = respuesta44;
        }
        System.out.println("respuesta44 " + respuesta44.size());
        for (int i = 0; i < respuesta44.size(); i++) {
            System.out.println("i -" + i + " " + respuesta44.get(i));
        }
    }

    private List<String> auxr45 = new ArrayList<>();

    public void cambior45() {
        if (respuesta45.size() > 1) {
            System.out.println("mayor a 1");
            respuesta45.removeAll(auxr45);
            auxr45 = respuesta45;
        } else if (respuesta45.size() == 1) {
            if (!auxr45.isEmpty()) {
                auxr45.clear();
            }
            auxr45 = respuesta45;
        }
        System.out.println("respuesta45 " + respuesta45.size());
        for (int i = 0; i < respuesta45.size(); i++) {
            System.out.println("i -" + i + " " + respuesta45.get(i));
        }
    }

    private List<String> auxr46 = new ArrayList<>();

    public void cambior46() {
        if (respuesta46.size() > 1) {
            System.out.println("mayor a 1");
            respuesta46.removeAll(auxr46);
            auxr46 = respuesta46;
        } else if (respuesta46.size() == 1) {
            if (!auxr46.isEmpty()) {
                auxr46.clear();
            }
            auxr46 = respuesta46;
        }
        System.out.println("respuesta46 " + respuesta46.size());
        for (int i = 0; i < respuesta46.size(); i++) {
            System.out.println("i -" + i + " " + respuesta46.get(i));
        }
    }

    private List<String> auxr47 = new ArrayList<>();

    public void cambior47() {
        if (respuesta47.size() > 1) {
            System.out.println("mayor a 1");
            respuesta47.removeAll(auxr47);
            auxr47 = respuesta47;
        } else if (respuesta47.size() == 1) {
            if (!auxr47.isEmpty()) {
                auxr47.clear();
            }
            auxr47 = respuesta47;
        }
        System.out.println("respuesta47 " + respuesta47.size());
        for (int i = 0; i < respuesta47.size(); i++) {
            System.out.println("i -" + i + " " + respuesta47.get(i));
        }
    }

    private List<String> auxr48 = new ArrayList<>();

    public void cambior48() {
        if (respuesta48.size() > 1) {
            System.out.println("mayor a 1");
            respuesta48.removeAll(auxr48);
            auxr48 = respuesta48;
        } else if (respuesta48.size() == 1) {
            if (!auxr48.isEmpty()) {
                auxr48.clear();
            }
            auxr48 = respuesta48;
        }
        System.out.println("respuesta48 " + respuesta48.size());
        for (int i = 0; i < respuesta48.size(); i++) {
            System.out.println("i -" + i + " " + respuesta48.get(i));
        }
    }

    private List<String> auxr49 = new ArrayList<>();

    public void cambior49() {
        if (respuesta49.size() > 1) {
            System.out.println("mayor a 1");
            respuesta49.removeAll(auxr49);
            auxr49 = respuesta49;
        } else if (respuesta49.size() == 1) {
            if (!auxr49.isEmpty()) {
                auxr49.clear();
            }
            auxr49 = respuesta49;
        }
        System.out.println("respuesta49 " + respuesta49.size());
        for (int i = 0; i < respuesta49.size(); i++) {
            System.out.println("i -" + i + " " + respuesta49.get(i));
        }
    }

    private List<String> auxr50 = new ArrayList<>();

    public void cambior50() {
        if (respuesta50.size() > 1) {
            System.out.println("mayor a 1");
            respuesta50.removeAll(auxr50);
            auxr50 = respuesta50;
        } else if (respuesta50.size() == 1) {
            if (!auxr50.isEmpty()) {
                auxr50.clear();
            }
            auxr50 = respuesta50;
        }
        System.out.println("respuesta50 " + respuesta50.size());
        for (int i = 0; i < respuesta50.size(); i++) {
            System.out.println("i -" + i + " " + respuesta50.get(i));
        }
    }
    private List<String> auxr51 = new ArrayList<>();

    public void cambior51() {
        if (respuesta51.size() > 1) {
            System.out.println("mayor a 1");
            respuesta51.removeAll(auxr51);
            auxr51 = respuesta51;
        } else if (respuesta51.size() == 1) {
            if (!auxr51.isEmpty()) {
                auxr51.clear();
            }
            auxr51 = respuesta51;
        }
        System.out.println("respuesta51 " + respuesta51.size());
        for (int i = 0; i < respuesta51.size(); i++) {
            System.out.println("i -" + i + " " + respuesta51.get(i));
        }
    }

    private List<String> auxr52 = new ArrayList<>();

    public void cambior52() {
        if (respuesta52.size() > 1) {
            System.out.println("mayor a 1");
            respuesta52.removeAll(auxr52);
            auxr52 = respuesta52;
        } else if (respuesta52.size() == 1) {
            if (!auxr52.isEmpty()) {
                auxr52.clear();
            }
            auxr52 = respuesta52;
        }
        System.out.println("respuesta52 " + respuesta52.size());
        for (int i = 0; i < respuesta52.size(); i++) {
            System.out.println("i -" + i + " " + respuesta52.get(i));
        }
    }

    private List<String> auxr53 = new ArrayList<>();

    public void cambior53() {
        if (respuesta53.size() > 1) {
            System.out.println("mayor a 1");
            respuesta53.removeAll(auxr53);
            auxr53 = respuesta53;
        } else if (respuesta53.size() == 1) {
            if (!auxr53.isEmpty()) {
                auxr53.clear();
            }
            auxr53 = respuesta53;
        }
        System.out.println("respuesta53 " + respuesta53.size());
        for (int i = 0; i < respuesta53.size(); i++) {
            System.out.println("i -" + i + " " + respuesta53.get(i));
        }
    }

    private List<String> auxr54 = new ArrayList<>();

    public void cambior54() {
        if (respuesta54.size() > 1) {
            System.out.println("mayor a 1");
            respuesta54.removeAll(auxr54);
            auxr54 = respuesta54;
        } else if (respuesta54.size() == 1) {
            if (!auxr54.isEmpty()) {
                auxr54.clear();
            }
            auxr54 = respuesta54;
        }
        System.out.println("respuesta54 " + respuesta54.size());
        for (int i = 0; i < respuesta54.size(); i++) {
            System.out.println("i -" + i + " " + respuesta54.get(i));
        }
    }

    private List<String> auxr55 = new ArrayList<>();

    public void cambior55() {
        if (respuesta55.size() > 1) {
            System.out.println("mayor a 1");
            respuesta55.removeAll(auxr55);
            auxr55 = respuesta55;
        } else if (respuesta55.size() == 1) {
            if (!auxr55.isEmpty()) {
                auxr55.clear();
            }
            auxr55 = respuesta55;
        }
        System.out.println("respuesta55 " + respuesta55.size());
        for (int i = 0; i < respuesta55.size(); i++) {
            System.out.println("i -" + i + " " + respuesta55.get(i));
        }
    }

    private List<String> auxr56 = new ArrayList<>();

    public void cambior56() {
        if (respuesta56.size() > 1) {
            System.out.println("mayor a 1");
            respuesta56.removeAll(auxr56);
            auxr56 = respuesta56;
        } else if (respuesta56.size() == 1) {
            if (!auxr56.isEmpty()) {
                auxr56.clear();
            }
            auxr56 = respuesta56;
        }
        System.out.println("respuesta56 " + respuesta56.size());
        for (int i = 0; i < respuesta56.size(); i++) {
            System.out.println("i -" + i + " " + respuesta56.get(i));
        }
    }

    private List<String> auxr57 = new ArrayList<>();

    public void cambior57() {
        if (respuesta57.size() > 1) {
            System.out.println("mayor a 1");
            respuesta57.removeAll(auxr57);
            auxr57 = respuesta57;
        } else if (respuesta57.size() == 1) {
            if (!auxr57.isEmpty()) {
                auxr57.clear();
            }
            auxr57 = respuesta57;
        }
        System.out.println("respuesta57 " + respuesta57.size());
        for (int i = 0; i < respuesta57.size(); i++) {
            System.out.println("i -" + i + " " + respuesta57.get(i));
        }
    }

    private List<String> auxr58 = new ArrayList<>();

    public void cambior58() {
        if (respuesta58.size() > 1) {
            System.out.println("mayor a 1");
            respuesta58.removeAll(auxr58);
            auxr58 = respuesta58;
        } else if (respuesta58.size() == 1) {
            if (!auxr58.isEmpty()) {
                auxr58.clear();
            }
            auxr58 = respuesta58;
        }
        System.out.println("respuesta58 " + respuesta58.size());
        for (int i = 0; i < respuesta58.size(); i++) {
            System.out.println("i -" + i + " " + respuesta58.get(i));
        }
    }

    private List<String> auxr59 = new ArrayList<>();

    public void cambior59() {
        if (respuesta59.size() > 1) {
            System.out.println("mayor a 1");
            respuesta59.removeAll(auxr59);
            auxr59 = respuesta59;
        } else if (respuesta59.size() == 1) {
            if (!auxr59.isEmpty()) {
                auxr59.clear();
            }
            auxr59 = respuesta59;
        }
        System.out.println("respuesta59 " + respuesta59.size());
        for (int i = 0; i < respuesta59.size(); i++) {
            System.out.println("i -" + i + " " + respuesta59.get(i));
        }
    }

    private List<String> auxr60 = new ArrayList<>();

    public void cambior60() {
        if (respuesta60.size() > 1) {
            System.out.println("mayor a 1");
            respuesta60.removeAll(auxr60);
            auxr60 = respuesta60;
        } else if (respuesta60.size() == 1) {
            if (!auxr60.isEmpty()) {
                auxr60.clear();
            }
            auxr60 = respuesta60;
        }
        System.out.println("respuesta60 " + respuesta60.size());
        for (int i = 0; i < respuesta60.size(); i++) {
            System.out.println("i -" + i + " " + respuesta60.get(i));
        }
    }

    private List<String> auxr61 = new ArrayList<>();

    public void cambior61() {
        if (respuesta61.size() > 1) {
            System.out.println("mayor a 1");
            respuesta61.removeAll(auxr61);
            auxr61 = respuesta61;
        } else if (respuesta61.size() == 1) {
            if (!auxr61.isEmpty()) {
                auxr61.clear();
            }
            auxr61 = respuesta61;
        }
        System.out.println("respuesta61 " + respuesta61.size());
        for (int i = 0; i < respuesta61.size(); i++) {
            System.out.println("i -" + i + " " + respuesta61.get(i));
        }
    }

    private List<String> auxr62 = new ArrayList<>();

    public void cambior62() {
        if (respuesta62.size() > 1) {
            System.out.println("mayor a 1");
            respuesta62.removeAll(auxr62);
            auxr62 = respuesta62;
        } else if (respuesta62.size() == 1) {
            if (!auxr62.isEmpty()) {
                auxr62.clear();
            }
            auxr62 = respuesta62;
        }
        System.out.println("respuesta62 " + respuesta62.size());
        for (int i = 0; i < respuesta62.size(); i++) {
            System.out.println("i -" + i + " " + respuesta62.get(i));
        }
    }

    private List<String> auxr63 = new ArrayList<>();

    public void cambior63() {
        if (respuesta63.size() > 1) {
            System.out.println("mayor a 1");
            respuesta63.removeAll(auxr63);
            auxr63 = respuesta63;
        } else if (respuesta63.size() == 1) {
            if (!auxr63.isEmpty()) {
                auxr63.clear();
            }
            auxr63 = respuesta63;
        }
        System.out.println("respuesta63 " + respuesta63.size());
        for (int i = 0; i < respuesta63.size(); i++) {
            System.out.println("i -" + i + " " + respuesta63.get(i));
        }
    }

    private List<String> auxr64 = new ArrayList<>();

    public void cambior64() {
        if (respuesta64.size() > 1) {
            System.out.println("mayor a 1");
            respuesta64.removeAll(auxr64);
            auxr64 = respuesta64;
        } else if (respuesta64.size() == 1) {
            if (!auxr64.isEmpty()) {
                auxr64.clear();
            }
            auxr64 = respuesta64;
        }
        System.out.println("respuesta64 " + respuesta64.size());
        for (int i = 0; i < respuesta64.size(); i++) {
            System.out.println("i -" + i + " " + respuesta64.get(i));
        }
    }

    private List<String> auxr65 = new ArrayList<>();

    public void cambior65() {
        if (respuesta65.size() > 1) {
            System.out.println("mayor a 1");
            respuesta65.removeAll(auxr65);
            auxr65 = respuesta65;
        } else if (respuesta65.size() == 1) {
            if (!auxr65.isEmpty()) {
                auxr65.clear();
            }
            auxr65 = respuesta65;
        }
        System.out.println("respuesta65 " + respuesta65.size());
        for (int i = 0; i < respuesta65.size(); i++) {
            System.out.println("i -" + i + " " + respuesta65.get(i));
        }
    }

    private List<String> auxr66 = new ArrayList<>();

    public void cambior66() {
        if (respuesta66.size() > 1) {
            System.out.println("mayor a 1");
            respuesta66.removeAll(auxr66);
            auxr66 = respuesta66;
        } else if (respuesta66.size() == 1) {
            if (!auxr66.isEmpty()) {
                auxr66.clear();
            }
            auxr66 = respuesta66;
        }
        System.out.println("respuesta66 " + respuesta66.size());
        for (int i = 0; i < respuesta66.size(); i++) {
            System.out.println("i -" + i + " " + respuesta66.get(i));
        }
    }

    private List<String> auxr67 = new ArrayList<>();

    public void cambior67() {
        if (respuesta67.size() > 1) {
            System.out.println("mayor a 1");
            respuesta67.removeAll(auxr67);
            auxr67 = respuesta67;
        } else if (respuesta67.size() == 1) {
            if (!auxr67.isEmpty()) {
                auxr67.clear();
            }
            auxr67 = respuesta67;
        }
        System.out.println("respuesta67 " + respuesta67.size());
        for (int i = 0; i < respuesta67.size(); i++) {
            System.out.println("i -" + i + " " + respuesta67.get(i));
        }
    }

    private List<String> auxr68 = new ArrayList<>();

    public void cambior68() {
        if (respuesta68.size() > 1) {
            System.out.println("mayor a 1");
            respuesta68.removeAll(auxr68);
            auxr68 = respuesta68;
        } else if (respuesta68.size() == 1) {
            if (!auxr68.isEmpty()) {
                auxr68.clear();
            }
            auxr68 = respuesta68;
        }
        System.out.println("respuesta68 " + respuesta68.size());
        for (int i = 0; i < respuesta68.size(); i++) {
            System.out.println("i -" + i + " " + respuesta68.get(i));
        }
    }

    private List<String> auxr69 = new ArrayList<>();

    public void cambior69() {
        if (respuesta69.size() > 1) {
            System.out.println("mayor a 1");
            respuesta69.removeAll(auxr69);
            auxr69 = respuesta69;
        } else if (respuesta69.size() == 1) {
            if (!auxr69.isEmpty()) {
                auxr69.clear();
            }
            auxr69 = respuesta69;
        }
        System.out.println("respuesta69 " + respuesta69.size());
        for (int i = 0; i < respuesta69.size(); i++) {
            System.out.println("i -" + i + " " + respuesta69.get(i));
        }
    }

    private List<String> auxr70 = new ArrayList<>();

    public void cambior70() {
        if (respuesta70.size() > 1) {
            System.out.println("mayor a 1");
            respuesta70.removeAll(auxr70);
            auxr70 = respuesta70;
        } else if (respuesta70.size() == 1) {
            if (!auxr70.isEmpty()) {
                auxr70.clear();
            }
            auxr70 = respuesta70;
        }
        System.out.println("respuesta70 " + respuesta70.size());
        for (int i = 0; i < respuesta70.size(); i++) {
            System.out.println("i -" + i + " " + respuesta70.get(i));
        }
    }

    private List<String> auxr71 = new ArrayList<>();

    public void cambior71() {
        if (respuesta71.size() > 1) {
            System.out.println("mayor a 1");
            respuesta71.removeAll(auxr71);
            auxr71 = respuesta71;
        } else if (respuesta71.size() == 1) {
            if (!auxr71.isEmpty()) {
                auxr71.clear();
            }
            auxr71 = respuesta71;
        }
        System.out.println("respuesta71 " + respuesta71.size());
        for (int i = 0; i < respuesta71.size(); i++) {
            System.out.println("i -" + i + " " + respuesta71.get(i));
        }
    }

    private List<String> auxr72 = new ArrayList<>();

    public void cambior72() {
        if (respuesta72.size() > 1) {
            System.out.println("mayor a 1");
            respuesta72.removeAll(auxr72);
            auxr72 = respuesta72;
        } else if (respuesta72.size() == 1) {
            if (!auxr72.isEmpty()) {
                auxr72.clear();
            }
            auxr72 = respuesta72;
        }
        System.out.println("respuesta72 " + respuesta72.size());
        for (int i = 0; i < respuesta72.size(); i++) {
            System.out.println("i -" + i + " " + respuesta72.get(i));
        }
    }

    private List<String> auxr73 = new ArrayList<>();

    public void cambior73() {
        if (respuesta73.size() > 1) {
            System.out.println("mayor a 1");
            respuesta73.removeAll(auxr73);
            auxr73 = respuesta73;
        } else if (respuesta73.size() == 1) {
            if (!auxr73.isEmpty()) {
                auxr73.clear();
            }
            auxr73 = respuesta73;
        }
        System.out.println("respuesta73 " + respuesta73.size());
        for (int i = 0; i < respuesta73.size(); i++) {
            System.out.println("i -" + i + " " + respuesta73.get(i));
        }
    }

    private List<String> auxr74 = new ArrayList<>();

    public void cambior74() {
        if (respuesta74.size() > 1) {
            System.out.println("mayor a 1");
            respuesta74.removeAll(auxr74);
            auxr74 = respuesta74;
        } else if (respuesta74.size() == 1) {
            if (!auxr74.isEmpty()) {
                auxr74.clear();
            }
            auxr74 = respuesta74;
        }
        System.out.println("respuesta74 " + respuesta74.size());
        for (int i = 0; i < respuesta74.size(); i++) {
            System.out.println("i -" + i + " " + respuesta74.get(i));
        }
    }

    private List<String> auxr75 = new ArrayList<>();

    public void cambior75() {
        if (respuesta75.size() > 1) {
            System.out.println("mayor a 1");
            respuesta75.removeAll(auxr75);
            auxr75 = respuesta75;
        } else if (respuesta75.size() == 1) {
            if (!auxr75.isEmpty()) {
                auxr75.clear();
            }
            auxr75 = respuesta75;
        }
        System.out.println("respuesta75 " + respuesta75.size());
        for (int i = 0; i < respuesta75.size(); i++) {
            System.out.println("i -" + i + " " + respuesta75.get(i));
        }
    }

    public TipoTestPataNegra getPataNegra() {
        return pataNegra;
    }

    public void setPataNegra(TipoTestPataNegra pataNegra) {
        this.pataNegra = pataNegra;
    }

    public TipoTestIPA getTestIPA() {
        return testIPA;
    }

    public void setTestIPA(TipoTestIPA testIPA) {
        this.testIPA = testIPA;
    }

    public List<String> getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(List<String> respuesta) {
        this.respuesta = respuesta;
    }

    public List<String> getRespuesta2() {
        return respuesta2;
    }

    public void setRespuesta2(List<String> respuesta2) {
        this.respuesta2 = respuesta2;
    }

    public List<String> getRespuesta3() {
        return respuesta3;
    }

    public void setRespuesta3(List<String> respuesta3) {
        this.respuesta3 = respuesta3;
    }

    public List<String> getRespuesta4() {
        return respuesta4;
    }

    public void setRespuesta4(List<String> respuesta4) {
        this.respuesta4 = respuesta4;
    }

    public List<String> getRespuesta5() {
        return respuesta5;
    }

    public void setRespuesta5(List<String> respuesta5) {
        this.respuesta5 = respuesta5;
    }

    public List<String> getRespuesta6() {
        return respuesta6;
    }

    public void setRespuesta6(List<String> respuesta6) {
        this.respuesta6 = respuesta6;
    }

    public List<String> getRespuesta7() {
        return respuesta7;
    }

    public void setRespuesta7(List<String> respuesta7) {
        this.respuesta7 = respuesta7;
    }

    public List<String> getRespuesta8() {
        return respuesta8;
    }

    public void setRespuesta8(List<String> respuesta8) {
        this.respuesta8 = respuesta8;
    }

    public List<String> getRespuesta9() {
        return respuesta9;
    }

    public void setRespuesta9(List<String> respuesta9) {
        this.respuesta9 = respuesta9;
    }

    public List<String> getRespuesta10() {
        return respuesta10;
    }

    public void setRespuesta10(List<String> respuesta10) {
        this.respuesta10 = respuesta10;
    }

    public List<String> getRespuesta11() {
        return respuesta11;
    }

    public void setRespuesta11(List<String> respuesta11) {
        this.respuesta11 = respuesta11;
    }

    public List<String> getRespuesta12() {
        return respuesta12;
    }

    public void setRespuesta12(List<String> respuesta12) {
        this.respuesta12 = respuesta12;
    }

    public List<String> getRespuesta13() {
        return respuesta13;
    }

    public void setRespuesta13(List<String> respuesta13) {
        this.respuesta13 = respuesta13;
    }

    public List<String> getRespuesta14() {
        return respuesta14;
    }

    public void setRespuesta14(List<String> respuesta14) {
        this.respuesta14 = respuesta14;
    }

    public List<String> getRespuesta15() {
        return respuesta15;
    }

    public void setRespuesta15(List<String> respuesta15) {
        this.respuesta15 = respuesta15;
    }

    public List<String> getRespuesta16() {
        return respuesta16;
    }

    public void setRespuesta16(List<String> respuesta16) {
        this.respuesta16 = respuesta16;
    }

    public List<String> getRespuesta17() {
        return respuesta17;
    }

    public void setRespuesta17(List<String> respuesta17) {
        this.respuesta17 = respuesta17;
    }

    public List<String> getRespuesta18() {
        return respuesta18;
    }

    public void setRespuesta18(List<String> respuesta18) {
        this.respuesta18 = respuesta18;
    }

    public List<String> getRespuesta19() {
        return respuesta19;
    }

    public void setRespuesta19(List<String> respuesta19) {
        this.respuesta19 = respuesta19;
    }

    public List<String> getRespuesta20() {
        return respuesta20;
    }

    public void setRespuesta20(List<String> respuesta20) {
        this.respuesta20 = respuesta20;
    }

    public List<String> getRespuesta21() {
        return respuesta21;
    }

    public void setRespuesta21(List<String> respuesta21) {
        this.respuesta21 = respuesta21;
    }

    public List<String> getRespuesta22() {
        return respuesta22;
    }

    public void setRespuesta22(List<String> respuesta22) {
        this.respuesta22 = respuesta22;
    }

    public List<String> getRespuesta23() {
        return respuesta23;
    }

    public void setRespuesta23(List<String> respuesta23) {
        this.respuesta23 = respuesta23;
    }

    public List<String> getRespuesta24() {
        return respuesta24;
    }

    public void setRespuesta24(List<String> respuesta24) {
        this.respuesta24 = respuesta24;
    }

    public List<String> getRespuesta25() {
        return respuesta25;
    }

    public void setRespuesta25(List<String> respuesta25) {
        this.respuesta25 = respuesta25;
    }

    public List<String> getRespuesta26() {
        return respuesta26;
    }

    public void setRespuesta26(List<String> respuesta26) {
        this.respuesta26 = respuesta26;
    }

    public List<String> getRespuesta27() {
        return respuesta27;
    }

    public void setRespuesta27(List<String> respuesta27) {
        this.respuesta27 = respuesta27;
    }

    public List<String> getRespuesta28() {
        return respuesta28;
    }

    public void setRespuesta28(List<String> respuesta28) {
        this.respuesta28 = respuesta28;
    }

    public List<String> getRespuesta29() {
        return respuesta29;
    }

    public void setRespuesta29(List<String> respuesta29) {
        this.respuesta29 = respuesta29;
    }

    public List<String> getRespuesta30() {
        return respuesta30;
    }

    public void setRespuesta30(List<String> respuesta30) {
        this.respuesta30 = respuesta30;
    }

    public List<String> getRespuesta31() {
        return respuesta31;
    }

    public void setRespuesta31(List<String> respuesta31) {
        this.respuesta31 = respuesta31;
    }

    public List<String> getRespuesta32() {
        return respuesta32;
    }

    public void setRespuesta32(List<String> respuesta32) {
        this.respuesta32 = respuesta32;
    }

    public List<String> getRespuesta33() {
        return respuesta33;
    }

    public void setRespuesta33(List<String> respuesta33) {
        this.respuesta33 = respuesta33;
    }

    public List<String> getRespuesta34() {
        return respuesta34;
    }

    public void setRespuesta34(List<String> respuesta34) {
        this.respuesta34 = respuesta34;
    }

    public List<String> getRespuesta35() {
        return respuesta35;
    }

    public void setRespuesta35(List<String> respuesta35) {
        this.respuesta35 = respuesta35;
    }

    public List<String> getRespuesta36() {
        return respuesta36;
    }

    public void setRespuesta36(List<String> respuesta36) {
        this.respuesta36 = respuesta36;
    }

    public List<String> getRespuesta37() {
        return respuesta37;
    }

    public void setRespuesta37(List<String> respuesta37) {
        this.respuesta37 = respuesta37;
    }

    public List<String> getRespuesta38() {
        return respuesta38;
    }

    public void setRespuesta38(List<String> respuesta38) {
        this.respuesta38 = respuesta38;
    }

    public List<String> getRespuesta39() {
        return respuesta39;
    }

    public void setRespuesta39(List<String> respuesta39) {
        this.respuesta39 = respuesta39;
    }

    public List<String> getRespuesta40() {
        return respuesta40;
    }

    public void setRespuesta40(List<String> respuesta40) {
        this.respuesta40 = respuesta40;
    }

    public List<String> getRespuesta41() {
        return respuesta41;
    }

    public void setRespuesta41(List<String> respuesta41) {
        this.respuesta41 = respuesta41;
    }

    public List<String> getRespuesta42() {
        return respuesta42;
    }

    public void setRespuesta42(List<String> respuesta42) {
        this.respuesta42 = respuesta42;
    }

    public List<String> getRespuesta43() {
        return respuesta43;
    }

    public void setRespuesta43(List<String> respuesta43) {
        this.respuesta43 = respuesta43;
    }

    public List<String> getRespuesta44() {
        return respuesta44;
    }

    public void setRespuesta44(List<String> respuesta44) {
        this.respuesta44 = respuesta44;
    }

    public List<String> getRespuesta45() {
        return respuesta45;
    }

    public void setRespuesta45(List<String> respuesta45) {
        this.respuesta45 = respuesta45;
    }

    public List<String> getRespuesta46() {
        return respuesta46;
    }

    public void setRespuesta46(List<String> respuesta46) {
        this.respuesta46 = respuesta46;
    }

    public List<String> getRespuesta47() {
        return respuesta47;
    }

    public void setRespuesta47(List<String> respuesta47) {
        this.respuesta47 = respuesta47;
    }

    public List<String> getRespuesta48() {
        return respuesta48;
    }

    public void setRespuesta48(List<String> respuesta48) {
        this.respuesta48 = respuesta48;
    }

    public List<String> getRespuesta49() {
        return respuesta49;
    }

    public void setRespuesta49(List<String> respuesta49) {
        this.respuesta49 = respuesta49;
    }

    public List<String> getRespuesta50() {
        return respuesta50;
    }

    public void setRespuesta50(List<String> respuesta50) {
        this.respuesta50 = respuesta50;
    }

    public List<String> getRespuesta51() {
        return respuesta51;
    }

    public void setRespuesta51(List<String> respuesta51) {
        this.respuesta51 = respuesta51;
    }

    public List<String> getRespuesta52() {
        return respuesta52;
    }

    public void setRespuesta52(List<String> respuesta52) {
        this.respuesta52 = respuesta52;
    }

    public List<String> getRespuesta53() {
        return respuesta53;
    }

    public void setRespuesta53(List<String> respuesta53) {
        this.respuesta53 = respuesta53;
    }

    public List<String> getRespuesta54() {
        return respuesta54;
    }

    public void setRespuesta54(List<String> respuesta54) {
        this.respuesta54 = respuesta54;
    }

    public List<String> getRespuesta55() {
        return respuesta55;
    }

    public void setRespuesta55(List<String> respuesta55) {
        this.respuesta55 = respuesta55;
    }

    public List<String> getRespuesta56() {
        return respuesta56;
    }

    public void setRespuesta56(List<String> respuesta56) {
        this.respuesta56 = respuesta56;
    }

    public List<String> getRespuesta57() {
        return respuesta57;
    }

    public void setRespuesta57(List<String> respuesta57) {
        this.respuesta57 = respuesta57;
    }

    public List<String> getRespuesta58() {
        return respuesta58;
    }

    public void setRespuesta58(List<String> respuesta58) {
        this.respuesta58 = respuesta58;
    }

    public List<String> getRespuesta59() {
        return respuesta59;
    }

    public void setRespuesta59(List<String> respuesta59) {
        this.respuesta59 = respuesta59;
    }

    public List<String> getRespuesta60() {
        return respuesta60;
    }

    public void setRespuesta60(List<String> respuesta60) {
        this.respuesta60 = respuesta60;
    }

    public List<String> getRespuesta61() {
        return respuesta61;
    }

    public void setRespuesta61(List<String> respuesta61) {
        this.respuesta61 = respuesta61;
    }

    public List<String> getRespuesta62() {
        return respuesta62;
    }

    public void setRespuesta62(List<String> respuesta62) {
        this.respuesta62 = respuesta62;
    }

    public List<String> getRespuesta63() {
        return respuesta63;
    }

    public void setRespuesta63(List<String> respuesta63) {
        this.respuesta63 = respuesta63;
    }

    public List<String> getRespuesta64() {
        return respuesta64;
    }

    public void setRespuesta64(List<String> respuesta64) {
        this.respuesta64 = respuesta64;
    }

    public List<String> getRespuesta65() {
        return respuesta65;
    }

    public void setRespuesta65(List<String> respuesta65) {
        this.respuesta65 = respuesta65;
    }

    public List<String> getRespuesta66() {
        return respuesta66;
    }

    public void setRespuesta66(List<String> respuesta66) {
        this.respuesta66 = respuesta66;
    }

    public List<String> getRespuesta67() {
        return respuesta67;
    }

    public void setRespuesta67(List<String> respuesta67) {
        this.respuesta67 = respuesta67;
    }

    public List<String> getRespuesta68() {
        return respuesta68;
    }

    public void setRespuesta68(List<String> respuesta68) {
        this.respuesta68 = respuesta68;
    }

    public List<String> getRespuesta69() {
        return respuesta69;
    }

    public void setRespuesta69(List<String> respuesta69) {
        this.respuesta69 = respuesta69;
    }

    public List<String> getRespuesta70() {
        return respuesta70;
    }

    public void setRespuesta70(List<String> respuesta70) {
        this.respuesta70 = respuesta70;
    }

    public List<String> getRespuesta71() {
        return respuesta71;
    }

    public void setRespuesta71(List<String> respuesta71) {
        this.respuesta71 = respuesta71;
    }

    public List<String> getRespuesta72() {
        return respuesta72;
    }

    public void setRespuesta72(List<String> respuesta72) {
        this.respuesta72 = respuesta72;
    }

    public List<String> getRespuesta73() {
        return respuesta73;
    }

    public void setRespuesta73(List<String> respuesta73) {
        this.respuesta73 = respuesta73;
    }

    public List<String> getRespuesta74() {
        return respuesta74;
    }

    public void setRespuesta74(List<String> respuesta74) {
        this.respuesta74 = respuesta74;
    }

    public List<String> getRespuesta75() {
        return respuesta75;
    }

    public void setRespuesta75(List<String> respuesta75) {
        this.respuesta75 = respuesta75;
    }

    public Usuario getU() {
        return u;
    }

    public void setU(Usuario u) {
        this.u = u;
    }
}
