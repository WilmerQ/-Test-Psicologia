/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucc.psicologia.logica;

import co.edu.ucc.psicologia.clases.ListUsuarioXResultado;
import co.edu.ucc.psicologia.clasesResporte.TestDualConAcomp;
import co.edu.ucc.psicologia.clasesResporte.TestDualSinAcomp;
import co.edu.ucc.psicologia.clasesResporte.TestIpaConAcomp;
import co.edu.ucc.psicologia.clasesResporte.TestIpaSinAcomp;
import co.edu.ucc.psicologia.clasesResporte.TestPataNegraConAcomp;
import co.edu.ucc.psicologia.clasesResporte.TestPataNegraSinAcomp;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 * EJB LogicaGenerarReporte donde se almacenan los metodos para la creacion de
 * los reportes de la aplicacion
 *
 * @see Stateless
 * @see LocalBean
 * @see EntityManager
 * @see PersistenceContext
 *
 * @author Jorge
 */
@Stateless
@LocalBean
public class LogicaGenerarReporte {

    @PersistenceContext(unitName = "psicologiapu")
    private EntityManager em;

    /**
     * metodo que recibe un objeto de tipo ListUsuarioXResultado y retorna un
     * byte[] que sera el pdf del reporte
     *
     * @param hea
     * @return
     */
    public byte[] generarReporte(ListUsuarioXResultado hea) {
        System.out.println("generarReporte ");
        try {
            System.out.println("hea getIpaBoolean" + hea.getIpaBoolean());
            System.out.println("hea getDualTest" + hea.getDualTest());
            System.out.println("hea getPataNegraBoolean" + hea.getPataNegraBoolean());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (hea.getPataNegraBoolean()) {
                System.out.println("test pata negra");
                if (hea.getPataNegra().getAcompanante() == null) {
                    System.out.println("sin acompañante");
                    TestPataNegraSinAcomp pataNegraSinAcomp = new TestPataNegraSinAcomp();
                    pataNegraSinAcomp.setNombreCompleto(hea.getU().getNombreCompleto());
                    pataNegraSinAcomp.setNumeroIdentificacion(hea.getU().getNumeroIdentificacion());
                    pataNegraSinAcomp.setEdad(hea.getU().getEdad());
                    pataNegraSinAcomp.setGenero(hea.getU().getGenero());
                    pataNegraSinAcomp.setEstadoCivil(hea.getU().getEstadoCivil());
                    pataNegraSinAcomp.setOcupacion(hea.getU().getOcupacion());
                    pataNegraSinAcomp.setEscolaridad(hea.getU().getEscolaridad());
                    pataNegraSinAcomp.setNumeroPersonasConviven(hea.getU().getNumeroPersonasConvive());
                    pataNegraSinAcomp.setEmail(hea.getU().getEmail());
                    pataNegraSinAcomp.setTelefono(hea.getU().getTelefono());
                    pataNegraSinAcomp.setNit(hea.getPataNegra().getTest().getInstitucionaRealizar().getNIT());
                    pataNegraSinAcomp.setNombreIntitucion(hea.getPataNegra().getTest().getInstitucionaRealizar().getNombre());
                    pataNegraSinAcomp.setDireccion(hea.getPataNegra().getTest().getInstitucionaRealizar().getDireccion());
                    pataNegraSinAcomp.setPregunta1(hea.getPataNegra().getRespuesta1());
                    pataNegraSinAcomp.setPregunta2(hea.getPataNegra().getRespuesta2());
                    pataNegraSinAcomp.setPregunta3(hea.getPataNegra().getRespuesta3());
                    pataNegraSinAcomp.setPregunta4(hea.getPataNegra().getRespuesta4());
                    pataNegraSinAcomp.setPregunta5(hea.getPataNegra().getRespuesta5());
                    pataNegraSinAcomp.setPregunta6(hea.getPataNegra().getRespuesta6());
                    pataNegraSinAcomp.setPregunta7(hea.getPataNegra().getRespuesta7());
                    pataNegraSinAcomp.setPregunta8(hea.getPataNegra().getRespuesta8());
                    pataNegraSinAcomp.setPregunta9(hea.getPataNegra().getRespuesta9());
                    pataNegraSinAcomp.setPregunta10(hea.getPataNegra().getRespuesta10());
                    pataNegraSinAcomp.setPregunta11(hea.getPataNegra().getRespuesta11());
                    pataNegraSinAcomp.setPregunta12(hea.getPataNegra().getRespuesta12());
                    pataNegraSinAcomp.setPregunta13(hea.getPataNegra().getRespuesta13());
                    pataNegraSinAcomp.setPregunta14(hea.getPataNegra().getRespuesta14());
                    pataNegraSinAcomp.setPregunta15(hea.getPataNegra().getRespuesta15());
                    pataNegraSinAcomp.setPregunta16(hea.getPataNegra().getRespuesta16());
                    pataNegraSinAcomp.setPregunta17(hea.getPataNegra().getRespuesta17());

                    List<TestPataNegraSinAcomp> pataNegraSinAcomps = new ArrayList<>();
                    pataNegraSinAcomps.add(pataNegraSinAcomp);

                    Map mapPersonalizado = new HashMap();
                    URL url = getClass().getResource("/reporte/reportePataNegraSinAcomp.jasper");
                    System.out.println("url: " + url.toString());
                    System.out.println("Buscando problema");
                    InputStream is = null;
                    System.out.println("Buscando problema 2");
                    try {
                        System.out.println("buscando problema 3");
                        is = url.openStream();
                        System.out.println("buscando problema 4");
                        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(pataNegraSinAcomps);
                        System.out.println("buscando problema 5");
                        System.out.println("beanCollectionDataSource.getRecordCount() " + beanCollectionDataSource.getRecordCount());
                        JasperPrint jasperPrint = JasperFillManager.fillReport(is, mapPersonalizado, beanCollectionDataSource);
                        System.out.println("buscando problema 6");
                        return JasperExportManager.exportReportToPdf(jasperPrint);
                    } catch (JRException ex) {
                        System.out.println("JRException");
                        ex.printStackTrace();
                        return null;
                    } catch (IOException ex) {
                        Logger.getLogger(LogicaGenerarReporte.class.getName()).log(Level.SEVERE, null, ex);
                        return null;
                    } finally {
                        try {
                            if (is != null) {
                                is.close();
                            }
                        } catch (IOException ex) {
                            Logger.getLogger(LogicaGenerarReporte.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                } else {
                    System.out.println("con acompañante");
                    TestPataNegraConAcomp test = new TestPataNegraConAcomp();
                    test.setNombreAcomp(hea.getPataNegra().getAcompanante().getNombreCompleto());
                    test.setNumeroIdentificacionAcomp(hea.getPataNegra().getAcompanante().getNumeroIdentificacion());
                    test.setEmailAcomp(hea.getPataNegra().getAcompanante().getEmail());
                    test.setTelefonoAcomp(hea.getPataNegra().getAcompanante().getTelefono());
                    test.setNombreCompleto(hea.getU().getNombreCompleto());
                    test.setNumeroIdentificacion(hea.getU().getNumeroIdentificacion());
                    test.setEdad(hea.getU().getEdad());
                    test.setGenero(hea.getU().getGenero());
                    test.setEstadoCivil(hea.getU().getEstadoCivil());
                    test.setOcupacion(hea.getU().getOcupacion());
                    test.setEscolaridad(hea.getU().getEscolaridad());
                    test.setNumeroPersonasConviven(hea.getU().getNumeroPersonasConvive());
                    test.setEmail(hea.getU().getEmail());
                    test.setTelefono(hea.getU().getTelefono());
                    test.setNit(hea.getPataNegra().getTest().getInstitucionaRealizar().getNIT());
                    test.setNombreIntitucion(hea.getPataNegra().getTest().getInstitucionaRealizar().getNombre());
                    test.setDireccion(hea.getPataNegra().getTest().getInstitucionaRealizar().getDireccion());
                    test.setPregunta1(hea.getPataNegra().getRespuesta1());
                    test.setPregunta2(hea.getPataNegra().getRespuesta2());
                    test.setPregunta3(hea.getPataNegra().getRespuesta3());
                    test.setPregunta4(hea.getPataNegra().getRespuesta4());
                    test.setPregunta5(hea.getPataNegra().getRespuesta5());
                    test.setPregunta6(hea.getPataNegra().getRespuesta6());
                    test.setPregunta7(hea.getPataNegra().getRespuesta7());
                    test.setPregunta8(hea.getPataNegra().getRespuesta8());
                    test.setPregunta9(hea.getPataNegra().getRespuesta9());
                    test.setPregunta10(hea.getPataNegra().getRespuesta10());
                    test.setPregunta11(hea.getPataNegra().getRespuesta11());
                    test.setPregunta12(hea.getPataNegra().getRespuesta12());
                    test.setPregunta13(hea.getPataNegra().getRespuesta13());
                    test.setPregunta14(hea.getPataNegra().getRespuesta14());
                    test.setPregunta15(hea.getPataNegra().getRespuesta15());
                    test.setPregunta16(hea.getPataNegra().getRespuesta16());
                    test.setPregunta17(hea.getPataNegra().getRespuesta17());

                    List<TestPataNegraConAcomp> listTest = new ArrayList<>();
                    listTest.add(test);

                    Map mapPersonalizado = new HashMap();
                    URL url = getClass().getResource("/reporte/reportePataNegraConAcomp.jasper");
                    System.out.println("url: " + url.toString());
                    InputStream is = null;
                    try {
                        is = url.openStream();
                        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(listTest);
                        JasperPrint jasperPrint = JasperFillManager.fillReport(is, mapPersonalizado, beanCollectionDataSource);
                        return JasperExportManager.exportReportToPdf(jasperPrint);
                    } catch (JRException ex) {
                        System.out.println("JRException");
                        ex.printStackTrace();
                        return null;
                    } catch (IOException ex) {
                        Logger.getLogger(LogicaGenerarReporte.class.getName()).log(Level.SEVERE, null, ex);
                        return null;
                    } finally {
                        try {
                            if (is != null) {
                                is.close();
                            }
                        } catch (IOException ex) {
                            Logger.getLogger(LogicaGenerarReporte.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("catch generar reporte - patanegra");
        }

        //IPA ---------------------------------------------------------------------------------------
        try {
            if (hea.getIpaBoolean()) {
                System.out.println("test Ippa");
                if (hea.getIpaTest().getAcompanante() == null) {
                    System.out.println("sin acompañante");
                    TestIpaSinAcomp test = new TestIpaSinAcomp(hea.getIpaTest());
                    test.setNombreCompleto(hea.getU().getNombreCompleto());
                    test.setNumeroIdentificacion(hea.getU().getNumeroIdentificacion());
                    test.setEdad(hea.getU().getEdad());
                    test.setGenero(hea.getU().getGenero());
                    test.setEstadoCivil(hea.getU().getEstadoCivil());
                    test.setOcupacion(hea.getU().getOcupacion());
                    test.setEscolaridad(hea.getU().getEscolaridad());
                    test.setNumeroPersonasConviven(hea.getU().getNumeroPersonasConvive());
                    test.setEmail(hea.getU().getEmail());
                    test.setTelefono(hea.getU().getTelefono());
                    test.setNit(hea.getIpaTest().getTest().getInstitucionaRealizar().getNIT());
                    test.setNombreIntitucion(hea.getIpaTest().getTest().getInstitucionaRealizar().getNombre());
                    test.setDireccion(hea.getIpaTest().getTest().getInstitucionaRealizar().getDireccion());

                    List<TestIpaSinAcomp> ipaSinAcomps = new ArrayList<>();
                    System.out.println(" ipaSinAcomps.add(test)" + ipaSinAcomps.add(test));

                    System.out.println("respues" + ipaSinAcomps.get(0).getRespuestaIpa12());

                    Map mapPersonalizado = new HashMap();
                    URL url = getClass().getResource("/reporte/testIpaSinacomp.jasper");
                    System.out.println("url: " + url.toString());
                    InputStream is = null;
                    try {
                        is = url.openStream();
                        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(ipaSinAcomps);
                        System.out.println(" beanCollectionDataSource.getRecordCoun" + beanCollectionDataSource.getRecordCount());
                        JasperPrint jasperPrint = JasperFillManager.fillReport(is, mapPersonalizado, beanCollectionDataSource);
                        return JasperExportManager.exportReportToPdf(jasperPrint);
                    } catch (JRException ex) {
                        System.out.println("JRException");
                        ex.printStackTrace();
                        return null;
                    } catch (IOException ex) {
                        Logger.getLogger(LogicaGenerarReporte.class.getName()).log(Level.SEVERE, null, ex);
                        return null;
                    } finally {
                        try {
                            if (is != null) {
                                is.close();
                            }
                        } catch (IOException ex) {
                            Logger.getLogger(LogicaGenerarReporte.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                } else {
                    System.out.println("con acompañante");
                    TestIpaConAcomp test = new TestIpaConAcomp(hea.getIpaTest());
                    test.setNombreAcomp(hea.getIpaTest().getAcompanante().getNombreCompleto());
                    test.setNumeroIdentificacionAcomp(hea.getIpaTest().getAcompanante().getNumeroIdentificacion());
                    test.setEmailAcomp(hea.getIpaTest().getAcompanante().getEmail());
                    test.setTelefonoAcomp(hea.getIpaTest().getAcompanante().getTelefono());
                    test.setNombreCompleto(hea.getU().getNombreCompleto());
                    test.setNumeroIdentificacion(hea.getU().getNumeroIdentificacion());
                    test.setEdad(hea.getU().getEdad());
                    test.setGenero(hea.getU().getGenero());
                    test.setEstadoCivil(hea.getU().getEstadoCivil());
                    test.setOcupacion(hea.getU().getOcupacion());
                    test.setEscolaridad(hea.getU().getEscolaridad());
                    test.setNumeroPersonasConviven(hea.getU().getNumeroPersonasConvive());
                    test.setEmail(hea.getU().getEmail());
                    test.setTelefono(hea.getU().getTelefono());
                    test.setNit(hea.getIpaTest().getTest().getInstitucionaRealizar().getNIT());
                    test.setNombreIntitucion(hea.getIpaTest().getTest().getInstitucionaRealizar().getNombre());
                    test.setDireccion(hea.getIpaTest().getTest().getInstitucionaRealizar().getDireccion());

                    List<TestIpaConAcomp> ipaConAcomps = new ArrayList<>();
                    System.out.println(" ipaSinAcomps.add(test)" + ipaConAcomps.add(test));

                    Map mapPersonalizado = new HashMap();
                    URL url = getClass().getResource("/reporte/testIpaConAcomp.jasper");
                    System.out.println("url: " + url.toString());
                    InputStream is = null;
                    try {
                        is = url.openStream();
                        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(ipaConAcomps);
                        System.out.println(" beanCollectionDataSource.getRecordCoun" + beanCollectionDataSource.getRecordCount());
                        JasperPrint jasperPrint = JasperFillManager.fillReport(is, mapPersonalizado, beanCollectionDataSource);
                        return JasperExportManager.exportReportToPdf(jasperPrint);
                    } catch (JRException ex) {
                        System.out.println("JRException");
                        ex.printStackTrace();
                        return null;
                    } catch (IOException ex) {
                        Logger.getLogger(LogicaGenerarReporte.class.getName()).log(Level.SEVERE, null, ex);
                        return null;
                    } finally {
                        try {
                            if (is != null) {
                                is.close();
                            }
                        } catch (IOException ex) {
                            Logger.getLogger(LogicaGenerarReporte.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                }
            }
        } catch (Exception e) {
            System.out.println("cath generar reporte - ippa");
        }
        try {
            if (hea.getDualTest()) {
                System.err.println("Tesd Dual");
                if (hea.getIpaTest().getAcompanante() == null) {
                    System.out.println("Sin Acomp");
                    TestDualSinAcomp test = new TestDualSinAcomp(hea.getIpaTest(), hea.getPataNegra());
                    test.setNombreCompleto(hea.getU().getNombreCompleto());
                    test.setNumeroIdentificacion(hea.getU().getNumeroIdentificacion());
                    test.setEdad(hea.getU().getEdad());
                    test.setGenero(hea.getU().getGenero());
                    test.setEstadoCivil(hea.getU().getEstadoCivil());
                    test.setOcupacion(hea.getU().getOcupacion());
                    test.setEscolaridad(hea.getU().getEscolaridad());
                    test.setNumeroPersonasConviven(hea.getU().getNumeroPersonasConvive());
                    test.setEmail(hea.getU().getEmail());
                    test.setTelefono(hea.getU().getTelefono());
                    test.setNit(hea.getIpaTest().getTest().getInstitucionaRealizar().getNIT());
                    test.setNombreIntitucion(hea.getIpaTest().getTest().getInstitucionaRealizar().getNombre());
                    test.setDireccion(hea.getIpaTest().getTest().getInstitucionaRealizar().getDireccion());

                    List<TestDualSinAcomp> dualSinAcomps = new ArrayList<>();
                    System.out.println("dualSinAcomps.add(test) " + dualSinAcomps.add(test));

                    Map mapPersonalizado = new HashMap();
                    URL url = getClass().getResource("/reporte/testDualSinacomp.jasper");
                    System.out.println("url: " + url.toString());
                    InputStream is = null;
                    try {
                        is = url.openStream();
                        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(dualSinAcomps);
                        System.out.println(" beanCollectionDataSource.getRecordCoun" + beanCollectionDataSource.getRecordCount());
                        JasperPrint jasperPrint = JasperFillManager.fillReport(is, mapPersonalizado, beanCollectionDataSource);
                        return JasperExportManager.exportReportToPdf(jasperPrint);
                    } catch (JRException ex) {
                        System.out.println("JRException");
                        ex.printStackTrace();
                        return null;
                    } catch (IOException ex) {
                        Logger.getLogger(LogicaGenerarReporte.class.getName()).log(Level.SEVERE, null, ex);
                        return null;
                    } finally {
                        try {
                            if (is != null) {
                                is.close();
                            }
                        } catch (IOException ex) {
                            Logger.getLogger(LogicaGenerarReporte.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                } else {
                    System.err.println("Con Acomp");
                    TestDualConAcomp test = new TestDualConAcomp(hea.getIpaTest(), hea.getPataNegra());
                    test.setNombreAcomp(hea.getIpaTest().getAcompanante().getNombreCompleto());
                    test.setNumeroIdentificacionAcomp(hea.getIpaTest().getAcompanante().getNumeroIdentificacion());
                    test.setEmailAcomp(hea.getIpaTest().getAcompanante().getEmail());
                    test.setTelefonoAcomp(hea.getIpaTest().getAcompanante().getTelefono());
                    test.setNombreCompleto(hea.getU().getNombreCompleto());
                    test.setNumeroIdentificacion(hea.getU().getNumeroIdentificacion());
                    test.setEdad(hea.getU().getEdad());
                    test.setGenero(hea.getU().getGenero());
                    test.setEstadoCivil(hea.getU().getEstadoCivil());
                    test.setOcupacion(hea.getU().getOcupacion());
                    test.setEscolaridad(hea.getU().getEscolaridad());
                    test.setNumeroPersonasConviven(hea.getU().getNumeroPersonasConvive());
                    test.setEmail(hea.getU().getEmail());
                    test.setTelefono(hea.getU().getTelefono());
                    test.setNit(hea.getIpaTest().getTest().getInstitucionaRealizar().getNIT());
                    test.setNombreIntitucion(hea.getIpaTest().getTest().getInstitucionaRealizar().getNombre());
                    test.setDireccion(hea.getIpaTest().getTest().getInstitucionaRealizar().getDireccion());

                    List<TestDualConAcomp> dualConAcomps = new ArrayList<>();
                    System.out.println(" dualConAcomps.add(test) " + dualConAcomps.add(test));

                    Map mapPersonalizado = new HashMap();
                    URL url = getClass().getResource("/reporte/testDualConAcomp.jasper");
                    System.out.println("url: " + url.toString());
                    InputStream is = null;
                    try {
                        is = url.openStream();
                        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(dualConAcomps);
                        System.out.println(" beanCollectionDataSource.getRecordCoun" + beanCollectionDataSource.getRecordCount());
                        JasperPrint jasperPrint = JasperFillManager.fillReport(is, mapPersonalizado, beanCollectionDataSource);
                        return JasperExportManager.exportReportToPdf(jasperPrint);
                    } catch (JRException ex) {
                        System.out.println("JRException");
                        ex.printStackTrace();
                        return null;
                    } catch (IOException ex) {
                        Logger.getLogger(LogicaGenerarReporte.class.getName()).log(Level.SEVERE, null, ex);
                        return null;
                    } finally {
                        try {
                            if (is != null) {
                                is.close();
                            }
                        } catch (IOException ex) {
                            Logger.getLogger(LogicaGenerarReporte.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("cath generar reporte - Dual test");
        }
        return null;
    }

}
