/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucc.psicologia.vista;

import co.edu.ucc.psicologia.logica.CommonsBean;
import co.edu.ucc.psicologia.modelo.Enlace;
import co.edu.ucc.psicologia.modelo.Institucion;
import co.edu.ucc.psicologia.modelo.Test;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;

@ViewScoped
@ManagedBean(name = "MbTest")
public class MbTest implements Serializable {

    private Test test;
    private List<Institucion> institucions;
    private List<SelectItem> ListaInstitucionesSelect;
    private Long idInstitucion;
    private Long codigoAuth;
    private Long duracion;
    private String url;
    private String urlCorto;
    private Boolean generado;
    private List<Test> tests;
    private Long idTest;
    private String ip;
    private int port;
    Enlace enlace;
    List<Enlace> listEnles;

    @EJB
    private CommonsBean cb;

    /**
     * Creates a new instance of MbTest
     */
    public MbTest() {
    }

    @PostConstruct
    public void init() {
        listEnles = new ArrayList<>();
        listEnles = cb.getAll(Enlace.class);
        if (!listEnles.isEmpty()) {
            enlace = new Enlace();
            enlace = listEnles.get(0);
        } else {
            enlace = new Enlace();
            enlace.setUrl("http://" + ip + ":" + port + "/psicologia/");
            cb.guardar(enlace);
        }
        ip = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getServerName();
        port = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getServerPort();
        test = new Test();
        institucions = new ArrayList<>();
        institucions = cb.getAll(Institucion.class);
        codigoAuth = (long) (Math.random() * 1000000);
        test.setIdManual(codigoAuth);
        ListaInstitucionesSelect = new LinkedList<>();
        for (Institucion i : institucions) {
            ListaInstitucionesSelect.add(new SelectItem(i.getId(), i.getNombre()));
        }
        List<Test> temp = cb.getAll(Test.class);
        for (Test t : temp) {
            System.out.println("test != null");
            System.out.println("" + t.getDuracionTest());
            Date d = new Date(t.getFechayHoraCrecaion().getTime() + t.getDuracionTest());
            System.out.println("d " + d);
            System.out.println("fecha y creacion " + t.getFechayHoraCrecaion());
            if (d.before(new Date())) {
                System.out.println("before");
                t.setEstadoActivo(Boolean.TRUE);
            } else {
                System.out.println("else ");
                t.setEstadoActivo(Boolean.FALSE);
            }
        }
        tests = temp;
        //urlCorto = "index.xhtml";
        urlCorto = enlace.getUrl() + "index.xhtml";
    }

    public void accionGuarda() throws Exception {
        if (verificarFormulario()) {
            test.setDuracionTest(duracion * 3600 * 1000);
            test.setFechayHoraCrecaion(new Date());
            test.setInstitucionaRealizar((Institucion) cb.getByOneFieldWithOneResult(Institucion.class, "id", idInstitucion));
            if (cb.guardar(test)) {
                mostrarMensaje(FacesMessage.SEVERITY_INFO, "Exitoso", "Se ha Guardado el test");
                //url = "http://" + ip + ":" + port + "/psicologia/index.xhtml?testid=" + test.getIdManual();
                url = enlace.getUrl() + "index.xhtml?testid=" + test.getIdManual();
                System.out.println("url " + url);
                idTest = test.getIdManual();
                generado = Boolean.TRUE;
                idInstitucion = null;
                duracion = null;
                init();
            } else {
                mostrarMensaje(FacesMessage.SEVERITY_FATAL, "Error", "Ha fallado al Guardar el test");
            }
        }

    }

    public Boolean verificarFormulario() throws Exception {
        Boolean resultado = Boolean.TRUE;

        if (test.getIdManual() == null) {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Problema con ID ");
        } else {
            Test u = (Test) cb.getByOneFieldWithOneResult(Test.class, "idManual", test.getIdManual());
            if (u != null) {
                System.out.println("id ya existe - se remplaza por otro nuevo");
                test.setIdManual((long) (Math.random() * 1000000));
            }
        }
        try {
            if (idInstitucion == null) {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Seleccione la institución donde se realiza el test");
            }
        } catch (Exception e) {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Seleccione la institución donde se realiza el test");
        }
        try {
            if (duracion == null) {
                resultado = Boolean.FALSE;
                mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Debe indidar la cantidad de horas que durara activo el test");
            }
        } catch (Exception e) {
            resultado = Boolean.FALSE;
            mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR", "Debe indidar la cantidad de horas que durara activo el test");
        }

        return resultado;
    }

    public void resetTest() {
        test = new Test();
        test.setIdManual((long) (Math.random() * 1000000));
        duracion = null;
        idInstitucion = null;
        generado = null;
    }

    public void cargarTest(Test t) {
        this.test = t;
        idTest = test.getIdManual();
        generado = true;
        //url = "http://localhost:8080/psicologia/index.xhtml?testid=" + test.getIdManual();
        url = enlace.getUrl() + "index.xhtml?testid=" + test.getIdManual();
        idInstitucion = test.getInstitucionaRealizar().getId();
        duracion = test.getDuracionTest() / 3600000;
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

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public List<SelectItem> getListaInstitucionesSelect() {
        return ListaInstitucionesSelect;
    }

    public void setListaInstitucionesSelect(List<SelectItem> ListaInstitucionesSelect) {
        this.ListaInstitucionesSelect = ListaInstitucionesSelect;
    }

    public Long getIdInstitucion() {
        return idInstitucion;
    }

    public void setIdInstitucion(Long idInstitucion) {
        this.idInstitucion = idInstitucion;
    }

    public Long getDuracion() {
        return duracion;
    }

    public void setDuracion(Long duracion) {
        this.duracion = duracion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getGenerado() {
        return generado;
    }

    public void setGenerado(Boolean generado) {
        this.generado = generado;
    }

    public List<Test> getTests() {
        return tests;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }

    public String getUrlCorto() {
        return urlCorto;
    }

    public void setUrlCorto(String urlCorto) {
        this.urlCorto = urlCorto;
    }

    public Long getIdTest() {
        return idTest;
    }

    public void setIdTest(Long idTest) {
        this.idTest = idTest;
    }

}
