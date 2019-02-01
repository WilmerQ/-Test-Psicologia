/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucc.psicologia.logica;

import co.edu.ucc.psicologia.clases.ListUsuarioXResultado;
import co.edu.ucc.psicologia.modelo.TipoTestIPA;
import co.edu.ucc.psicologia.modelo.TipoTestPataNegra;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;

/**
 * EJB que contiene la logica que permiten presentar los resultados en la
 * pantalla de resultados.
 *
 * @see Stateless
 * @see LocalBean
 * @see EntityManager
 * @see PersistenceContext
 * @see CommonsBean
 * @author Jorge
 */
@Stateless
@LocalBean
public class LogicaResultados {

    @PersistenceContext(unitName = "psicologiapu")
    private EntityManager em;

    @EJB
    CommonsBean cb;

    /**
     * consulta todos los test ipa y pata negra que existan y si el usuario que
     * los reponde y el numero de test don iguales los agrupa en un solo
     * elemento para mostrar el resultado una sola fila por resultado.
     *
     * @return
     */
    public List<ListUsuarioXResultado> getAllTestXidXusuario() {
        try {
            List<TipoTestIPA> testIpas = new ArrayList<>();
            List<TipoTestPataNegra> pataNegras = new ArrayList<>();
            List<ListUsuarioXResultado> listUsuarioXResultados = new ArrayList<>();
            testIpas = cb.getAll(TipoTestIPA.class);
            pataNegras = cb.getAll(TipoTestPataNegra.class);

            System.out.println("testIpas.size() " + testIpas.size());
            System.out.println("pataNegras.size() " + pataNegras.size());

            for (TipoTestIPA testIPA : testIpas) {
                ListUsuarioXResultado luxr = new ListUsuarioXResultado();
                luxr.setU(testIPA.getUsuario());
                luxr.setIpaBoolean(Boolean.TRUE);
                luxr.setIpaTest(testIPA);
                luxr.setIdManualTest(testIPA.getTest().getIdManual());
                listUsuarioXResultados.add(luxr);
            }

            System.out.println("listUsuarioXResultados.size() " + listUsuarioXResultados.size());
            List<TipoTestPataNegra> paraRemover = new ArrayList<>();
            for (int i = 0; i < listUsuarioXResultados.size(); i++) {
                System.out.println("aqui-");
                for (TipoTestPataNegra ttpn : pataNegras) {
                    System.out.println("aqui---");
                    if ((ttpn.getUsuario().getId().equals(listUsuarioXResultados.get(i).getU().getId()))
                            && (ttpn.getTest().getIdManual().equals(listUsuarioXResultados.get(i).getIdManualTest()))) {
                        System.out.println("aqui-----if");
                        listUsuarioXResultados.get(i).setPataNegra(ttpn);
                        listUsuarioXResultados.get(i).setPataNegraBoolean(Boolean.TRUE);
                        paraRemover.add(ttpn);
                        try {
                            if ((listUsuarioXResultados.get(i).getIpaBoolean()) && (listUsuarioXResultados.get(i).getPataNegraBoolean())) {
                                listUsuarioXResultados.get(i).setDualTest(Boolean.TRUE);
                                listUsuarioXResultados.get(i).setIpaBoolean(Boolean.FALSE);
                                listUsuarioXResultados.get(i).setPataNegraBoolean(Boolean.FALSE);
                            }
                            System.out.println("aqui-----if-----");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

            if (!(pataNegras.isEmpty()) && !(paraRemover.isEmpty())) {
                System.out.println("paraRemover.size() " + paraRemover.size());
                System.out.println("pataNegras.size() " + pataNegras.size());
                System.out.println("remover " + pataNegras.removeAll(paraRemover));
            }

            if (!pataNegras.isEmpty()) {
                System.out.println("pataNegras.size() " + pataNegras.size());
                for (TipoTestPataNegra ttpn : pataNegras) {
                    ListUsuarioXResultado luxr1 = new ListUsuarioXResultado();
                    System.out.println(" identi" + ttpn.getUsuario().getNumeroIdentificacion());
                    luxr1.setU(ttpn.getUsuario());
                    luxr1.setPataNegraBoolean(Boolean.TRUE);
                    luxr1.setPataNegra(ttpn);
                    System.out.println("add " + listUsuarioXResultados.add(luxr1));
                }
                System.out.println("return size listUsuarioXResultados" + listUsuarioXResultados.size());
            }
            return listUsuarioXResultados;
        } catch (Exception e) {
            System.out.println("return null");
            return null;
        }
    }
}
