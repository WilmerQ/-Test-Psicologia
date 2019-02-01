/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucc.psicologia.servlet;

import co.edu.ucc.psicologia.clases.ListUsuarioXResultado;
import co.edu.ucc.psicologia.logica.CommonsBean;
import co.edu.ucc.psicologia.logica.LogicaGenerarReporte;
import co.edu.ucc.psicologia.modelo.EntidadParaResultado;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * servlet utilizado para que se genere el reporte, desde la pantalla de
 * resultados se envia la solicitud y el servlet repornde con el reporte
 *
 * @see Override
 * @see LogicaGenerarReporte
 * @see CommonsBean
 * @see EJB
 * @see HttpServlet
 * @see WebServlet
 * @author Jorge
 */
@WebServlet(urlPatterns = {"/descargarresultado"})
public class DercargarResultado extends HttpServlet {

    @EJB
    private CommonsBean cb;
    @EJB
    LogicaGenerarReporte generarReporte;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String idManualEntdadParaResultado = req.getParameter("id");
        System.out.println("+++++++++" + idManualEntdadParaResultado);
        try {
            EntidadParaResultado entidadParaResultado = (EntidadParaResultado) cb.getByOneFieldWithOneResult(EntidadParaResultado.class, "idManual", idManualEntdadParaResultado);
            if (entidadParaResultado != null) {
                System.out.println("entidadParaResultado != null");
                ListUsuarioXResultado luxr = new ListUsuarioXResultado();
                luxr.setU(entidadParaResultado.getU());
                luxr.setIdManualTest(entidadParaResultado.getIdManualTest());
                luxr.setDualTest(entidadParaResultado.getDualTest());
                luxr.setIpaBoolean(entidadParaResultado.getIpaBoolean());
                luxr.setPataNegraBoolean(entidadParaResultado.getPataNegraBoolean());
                try {
                    if (entidadParaResultado.getIpaBoolean()) {
                        luxr.setIpaTest(entidadParaResultado.getIpaTest());
                    }
                } catch (Exception e) {
                    System.out.println("IPPA False para resporte");
                }
                try {
                    if (entidadParaResultado.getPataNegraBoolean()) {
                        luxr.setPataNegra(entidadParaResultado.getPataNegra());
                    }
                } catch (Exception e) {
                    System.out.println("PataNegra False para reporte");
                }

                try {
                    if (entidadParaResultado.getDualTest()) {
                        luxr.setIpaTest(entidadParaResultado.getIpaTest());
                        luxr.setPataNegra(entidadParaResultado.getPataNegra());
                    }
                } catch (Exception e) {
                    System.out.println("Dual False para reporte");
                }
                byte[] bs = generarReporte.generarReporte(luxr);
                resp.setContentType("application/pdf");
                resp.setContentLength(bs.length);
                resp.setHeader("Content-Disposition",  "attachment; filename=Reporte - "+luxr.getU().getNombreCompleto()+".pdf");
                resp.getOutputStream().write(bs);
            }
        } catch (Exception e) {
            System.out.println("catch servlet");
        }
    }

}
