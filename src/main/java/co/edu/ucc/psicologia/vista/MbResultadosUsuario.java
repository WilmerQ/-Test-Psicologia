/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucc.psicologia.vista;

import co.edu.ucc.psicologia.base.SessionOperations;
import co.edu.ucc.psicologia.clases.ListUsuarioXResultado;
import co.edu.ucc.psicologia.logica.CommonsBean;
import co.edu.ucc.psicologia.logica.LogicaEmail;
import co.edu.ucc.psicologia.logica.LogicaGenerarReporte;
import co.edu.ucc.psicologia.logica.LogicaResultados;
import co.edu.ucc.psicologia.modelo.EntidadParaResultado;
import co.edu.ucc.psicologia.modelo.Usuario;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.model.ByteArrayContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author Jorge
 */
@ViewScoped
@ManagedBean(name = "MbResultadosUsuario")
public class MbResultadosUsuario implements Serializable {

    @EJB
    CommonsBean cb;
    @EJB
    LogicaResultados logicaResultados;
    @EJB
    LogicaGenerarReporte generarReporte;
    @EJB
    LogicaEmail logicaEmail;
    private List<ListUsuarioXResultado> listUsuarioXResultados;
    private List<ListUsuarioXResultado> listUsuarioXResultadosXUsuario;
    private List<ListUsuarioXResultado> listUsuarioXResultadosFilter;
    Usuario usuario;
    private String ip;
    private String contextPath;
    private int port;
    private UUID idEntidadParaResultado;
    //-----------
    private Boolean popupGrafica;
    private Boolean enviarDiagnosticoCorreo;
    private ListUsuarioXResultado listUsuarioXResultadoPopup;
    private String diagnostico;
    private String usuarioDiagnostico;
    private List<String> listCorreo;
    private String asuntoCorreo;

    public MbResultadosUsuario() {
    }

    @PostConstruct
    public void init() {
        listCorreo = new ArrayList<>();
        popupGrafica = Boolean.FALSE;
        enviarDiagnosticoCorreo = Boolean.FALSE;
        diagnostico = null;
        usuarioDiagnostico = null;
        ip = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getServerName();
        contextPath = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getContextPath();
        port = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getServerPort();
        listUsuarioXResultadosXUsuario = new ArrayList<>();
        listUsuarioXResultados = new ArrayList<>();
        listUsuarioXResultados = logicaResultados.getAllTestXidXusuario();
        usuario = (Usuario) SessionOperations.getSessionValue("USUARIO");
        try {
            if (usuario != null) {
                for (ListUsuarioXResultado temp : listUsuarioXResultados) {
                    try {
                        if (temp.getIpaBoolean()) {
                            if (temp.getIpaTest().getAcompanante().getNumeroIdentificacion().equals(usuario.getNumeroIdentificacion())) {
                                listUsuarioXResultadosXUsuario.add(temp);
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("catch MbResultadosUsuario listUsuarioXResultados getIpaBoolean");
                    }
                    try {
                        if (temp.getPataNegraBoolean()) {
                            if (temp.getPataNegra().getAcompanante().getNumeroIdentificacion().equals(usuario.getNumeroIdentificacion())) {
                                listUsuarioXResultadosXUsuario.add(temp);
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("catch MbResultadosUsuario listUsuarioXResultados getPataNegraBoolean");
                    }
                    try {
                        if (temp.getDualTest()) {
                            if (temp.getPataNegra().getAcompanante().getNumeroIdentificacion().equals(usuario.getNumeroIdentificacion())) {
                                listUsuarioXResultadosXUsuario.add(temp);
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("catch MbResultadosUsuario listUsuarioXResultados getDualTest");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void DescargarXServlet(ListUsuarioXResultado temp) {
        idEntidadParaResultado = UUID.randomUUID();
        System.out.println("idEntidadParaResultado " + idEntidadParaResultado.toString().toUpperCase());
        EntidadParaResultado entidadParaResultado = new EntidadParaResultado(temp);
        entidadParaResultado.setIdManual(idEntidadParaResultado.toString().toUpperCase());
        try {
            if (temp.getIpaBoolean()) {
                entidadParaResultado.setIpaTest(temp.getIpaTest());
            }
        } catch (Exception e) {
            System.out.println("IPPA False para resporte");
        }
        try {
            if (temp.getPataNegraBoolean()) {
                entidadParaResultado.setPataNegra(temp.getPataNegra());
            }
        } catch (Exception e) {
            System.out.println("PataNegra False para reporte");
        }

        try {
            if (temp.getDualTest()) {
                entidadParaResultado.setIpaTest(temp.getIpaTest());
                entidadParaResultado.setPataNegra(temp.getPataNegra());
            }
        } catch (Exception e) {
            System.out.println("Dual False para reporte");
        }
        if (cb.guardar(entidadParaResultado)) {
            String url = "http://" + ip + ":" + port + contextPath + "/descargarresultado?id=" + idEntidadParaResultado.toString().toUpperCase();
            System.out.println(" url servlet " + url);
            FacesContext context = FacesContext.getCurrentInstance();
            try {
                context.getExternalContext().redirect(url);
            } catch (IOException ex) {
                Logger.getLogger(MbResultados.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void accionGrafica(ListUsuarioXResultado luxr) {
        diagnostico = null;
        usuarioDiagnostico = null;
        asuntoCorreo = null;
        listCorreo.clear();
        enviarDiagnosticoCorreo = Boolean.FALSE;
        this.listUsuarioXResultadoPopup = luxr;
        //-----------------------------------
        try {
            if (listUsuarioXResultadoPopup.getDualTest()) {
                if (listUsuarioXResultadoPopup.getPataNegra().getDiagnostico().length() != 0) {
                    this.diagnostico = listUsuarioXResultadoPopup.getPataNegra().getDiagnostico();
                    this.usuarioDiagnostico = listUsuarioXResultadoPopup.getPataNegra().getUsuarioDiagnostico();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //------------------------------
        try {
            if (listUsuarioXResultadoPopup.getIpaBoolean()) {
                if (listUsuarioXResultadoPopup.getIpaTest().getDiagnostico().trim().length() != 0) {
                    this.diagnostico = listUsuarioXResultadoPopup.getIpaTest().getDiagnostico();
                    this.usuarioDiagnostico = listUsuarioXResultadoPopup.getIpaTest().getUsuarioDiagnostico();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //-------------------------------------------
        try {
            if (listUsuarioXResultadoPopup.getPataNegraBoolean()) {
                if (listUsuarioXResultadoPopup.getPataNegra().getDiagnostico().length() != 0) {
                    this.diagnostico = listUsuarioXResultadoPopup.getPataNegra().getDiagnostico();
                    this.usuarioDiagnostico = listUsuarioXResultadoPopup.getPataNegra().getUsuarioDiagnostico();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("nombre" + listUsuarioXResultadoPopup.getU().getNombreCompleto());
        popupGrafica = Boolean.TRUE;
    }

    public void accionGuardarDiagnostico() {
        if (verificarFormulario()) {
            Usuario temp = new Usuario();
            temp = (Usuario) SessionOperations.getSessionValue("USUARIO");
            try {
                if (listUsuarioXResultadoPopup.getDualTest()) {
                    listUsuarioXResultadoPopup.getIpaTest().setDiagnostico(diagnostico);
                    listUsuarioXResultadoPopup.getPataNegra().setDiagnostico(diagnostico);
                    listUsuarioXResultadoPopup.getIpaTest().setUsuarioDiagnostico(temp.getNombreCompleto());
                    listUsuarioXResultadoPopup.getPataNegra().setUsuarioDiagnostico(temp.getNombreCompleto());
                    if ((cb.guardar(listUsuarioXResultadoPopup.getIpaTest()))
                            && (cb.guardar(listUsuarioXResultadoPopup.getPataNegra()))) {
                        mostrarMensaje(FacesMessage.SEVERITY_INFO, "Éxito ", "Se ha Guardado el diagnóstico");
                        init();
                    } else {
                        mostrarMensaje(FacesMessage.SEVERITY_ERROR, "Error ", "No se ha guardado");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (listUsuarioXResultadoPopup.getIpaBoolean()) {
                    listUsuarioXResultadoPopup.getIpaTest().setDiagnostico(diagnostico);
                    listUsuarioXResultadoPopup.getIpaTest().setUsuarioDiagnostico(temp.getNombreCompleto());
                    if (cb.guardar(listUsuarioXResultadoPopup.getIpaTest())) {
                        mostrarMensaje(FacesMessage.SEVERITY_INFO, "Éxito ", "Se ha Guardado el diagnóstico");
                        init();
                    } else {
                        mostrarMensaje(FacesMessage.SEVERITY_ERROR, "Error ", "No se ha actualizado");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (listUsuarioXResultadoPopup.getPataNegraBoolean()) {
                    listUsuarioXResultadoPopup.getPataNegra().setDiagnostico(diagnostico);
                    listUsuarioXResultadoPopup.getPataNegra().setUsuarioDiagnostico(temp.getNombreCompleto());
                    if (cb.guardar(listUsuarioXResultadoPopup.getPataNegra())) {
                        mostrarMensaje(FacesMessage.SEVERITY_INFO, "Éxito ", "Se ha Guardado el diagnóstico");
                        init();
                    } else {
                        mostrarMensaje(FacesMessage.SEVERITY_ERROR, "Error ", "No se ha actualizado");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void enviarDiagnostivo() {
        if (guardarAntesDeEnviar()) {
            List<String> listCorreosTemp = new ArrayList<>();
            List<String> listCorreosRemove = new ArrayList<>();
            for (String s : listCorreo) {
                if (validateEmail(s)) {
                    listCorreosTemp.add(s);
                } else {
                    listCorreosRemove.add(s);
                }
            }
            listCorreo.removeAll(listCorreosRemove);
            if (listCorreosRemove.size() > 0) {
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "Error ", "verifique - " + listCorreosRemove.size() + " correo fueron eliminados porque no cumplen el formato");
            } else {
                String cuerpoCorreo = "\n" + diagnostico + "\n\n Atte: " + usuarioDiagnostico;
                popupGrafica = Boolean.FALSE;
                logicaEmail.enviarCorreoelectronico(listCorreo, null, null, asuntoCorreo, cuerpoCorreo);
                mostrarMensaje(FacesMessage.SEVERITY_INFO, "Enviando", "Enviando correo");
            }
        }
    }

    public Boolean guardarAntesDeEnviar() {
        if (verificarFormulario()) {
            Usuario temp = new Usuario();
            temp = (Usuario) SessionOperations.getSessionValue("USUARIO");
            try {
                if (listUsuarioXResultadoPopup.getDualTest()) {
                    listUsuarioXResultadoPopup.getIpaTest().setDiagnostico(diagnostico);
                    listUsuarioXResultadoPopup.getPataNegra().setDiagnostico(diagnostico);
                    usuarioDiagnostico = temp.getNombreCompleto();
                    listUsuarioXResultadoPopup.getIpaTest().setUsuarioDiagnostico(temp.getNombreCompleto());
                    listUsuarioXResultadoPopup.getPataNegra().setUsuarioDiagnostico(temp.getNombreCompleto());
                    if ((cb.guardar(listUsuarioXResultadoPopup.getIpaTest()))
                            && (cb.guardar(listUsuarioXResultadoPopup.getPataNegra()))) {
                        mostrarMensaje(FacesMessage.SEVERITY_INFO, "Éxito ", "Se ha Guardado el diagnóstico");
                        return Boolean.TRUE;
                    } else {
                        mostrarMensaje(FacesMessage.SEVERITY_ERROR, "Error ", "No se ha guardado");
                        return Boolean.FALSE;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (listUsuarioXResultadoPopup.getIpaBoolean()) {
                    usuarioDiagnostico = temp.getNombreCompleto();
                    listUsuarioXResultadoPopup.getIpaTest().setDiagnostico(diagnostico);
                    listUsuarioXResultadoPopup.getIpaTest().setUsuarioDiagnostico(temp.getNombreCompleto());
                    if (cb.guardar(listUsuarioXResultadoPopup.getIpaTest())) {
                        mostrarMensaje(FacesMessage.SEVERITY_INFO, "Éxito ", "Se ha Guardado el diagnóstico");
                        return Boolean.TRUE;
                    } else {
                        mostrarMensaje(FacesMessage.SEVERITY_ERROR, "Error ", "No se ha actualizado");
                        return Boolean.FALSE;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (listUsuarioXResultadoPopup.getPataNegraBoolean()) {
                    usuarioDiagnostico = temp.getNombreCompleto();
                    listUsuarioXResultadoPopup.getPataNegra().setDiagnostico(diagnostico);
                    listUsuarioXResultadoPopup.getPataNegra().setUsuarioDiagnostico(temp.getNombreCompleto());
                    if (cb.guardar(listUsuarioXResultadoPopup.getPataNegra())) {
                        mostrarMensaje(FacesMessage.SEVERITY_INFO, "Éxito ", "Se ha Guardado el diagnóstico");
                        return Boolean.TRUE;
                    } else {
                        mostrarMensaje(FacesMessage.SEVERITY_ERROR, "Error ", "No se ha actualizado");
                        return Boolean.FALSE;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void prepararEnvio() {
        if (verificarFormulario()) {
            enviarDiagnosticoCorreo = Boolean.TRUE;
            listCorreo.add(listUsuarioXResultadoPopup.getU().getEmail());
        }
    }

    public boolean validateEmail(String email) {
        String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(PATTERN_EMAIL);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public Boolean verificarFormulario() {
        Boolean resultado = Boolean.TRUE;
        if (diagnostico.trim().length() == 0) {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Ingrese Diagnostico");
        }
        return resultado;
    }

    /**
     * Metodo utilizado para ejecutar la presentacion de un mensaje emergente
     * tipo Growl en pantall
     *
     * @param icono
     * @param titulo
     * @param mensaje
     */
    public void mostrarMensaje(FacesMessage.Severity icono, String titulo, String mensaje) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(icono, titulo, mensaje));
    }

    public List<ListUsuarioXResultado> getListUsuarioXResultados() {
        return listUsuarioXResultados;
    }

    public void setListUsuarioXResultados(List<ListUsuarioXResultado> listUsuarioXResultados) {
        this.listUsuarioXResultados = listUsuarioXResultados;
    }

    public List<ListUsuarioXResultado> getListUsuarioXResultadosFilter() {
        return listUsuarioXResultadosFilter;
    }

    public void setListUsuarioXResultadosFilter(List<ListUsuarioXResultado> listUsuarioXResultadosFilter) {
        this.listUsuarioXResultadosFilter = listUsuarioXResultadosFilter;
    }

    public List<ListUsuarioXResultado> getListUsuarioXResultadosXUsuario() {
        return listUsuarioXResultadosXUsuario;
    }

    public void setListUsuarioXResultadosXUsuario(List<ListUsuarioXResultado> listUsuarioXResultadosXUsuario) {
        this.listUsuarioXResultadosXUsuario = listUsuarioXResultadosXUsuario;
    }

    public Boolean getEnviarDiagnosticoCorreo() {
        return enviarDiagnosticoCorreo;
    }

    public void setEnviarDiagnosticoCorreo(Boolean enviarDiagnosticoCorreo) {
        this.enviarDiagnosticoCorreo = enviarDiagnosticoCorreo;
    }

    public List<String> getListCorreo() {
        return listCorreo;
    }

    public void setListCorreo(List<String> listCorreo) {
        this.listCorreo = listCorreo;
    }

    public String getAsuntoCorreo() {
        return asuntoCorreo;
    }

    public void setAsuntoCorreo(String asuntoCorreo) {
        this.asuntoCorreo = asuntoCorreo;
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

    public Boolean getPopupGrafica() {
        return popupGrafica;
    }

    public void setPopupGrafica(Boolean popupGrafica) {
        this.popupGrafica = popupGrafica;
    }

    public ListUsuarioXResultado getListUsuarioXResultadoPopup() {
        return listUsuarioXResultadoPopup;
    }

    public void setListUsuarioXResultadoPopup(ListUsuarioXResultado listUsuarioXResultadoPopup) {
        this.listUsuarioXResultadoPopup = listUsuarioXResultadoPopup;
    }

}
