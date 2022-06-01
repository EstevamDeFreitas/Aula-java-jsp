/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.estevamdefreitas.notetaker;

import br.com.estevamdefreitas.notetaker.anotacao.Controladora;
import br.com.estevamdefreitas.notetaker.anotacao.Requisicao;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author estev
 */
public class FrontController extends ServletFatec {

    private Map<String, MapeamentoClasseMetodo> urlParaClasseMetodo
            = new HashMap<>();

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        CarregadorClasses carregadorClasses = new CarregadorClasses();
        try {
            List<Class> classes = carregadorClasses.encontrarClassesNoPacote("br.com.estevamdefreitas");

            for (Class classe : classes) {

                Controladora controladora = (Controladora) classe.getDeclaredAnnotation(Controladora.class);
                if (null == controladora) {
                    System.out.println("## Descartada como controladora: " + classe.getName());
                } else {
                    System.out.println("-- Encontrada controladora para o endpoint "
                            + controladora.value() + ": " + classe.getName());

                    Method[] metodos = classe.getDeclaredMethods();
                    for (Method metodo : metodos) {

                        Requisicao mapeamentoRequisicao
                                = metodo.getDeclaredAnnotation(Requisicao.class);

                        if (null == mapeamentoRequisicao) {
                            System.out.println("#### Descartado método da controladora: " + metodo.getName());
                        } else {
                            String endpoint = controladora.value() + mapeamentoRequisicao.value();
                            System.out.println("-- Encontrado método para o endpoint " + endpoint);

                            urlParaClasseMetodo.put(endpoint, new MapeamentoClasseMetodo(classe, metodo));
                        }

                    }
                }

            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ServletException(ex.getMessage());
        }
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = request.getRequestURI().substring(
                request.getContextPath().length());

        MapeamentoClasseMetodo mapeamentoClasseMetodo = urlParaClasseMetodo.get(url);
        System.out.println("Quem deve tratar essa requisição é o método "
                + mapeamentoClasseMetodo.getMetodo().getName() + " da classe " + mapeamentoClasseMetodo.getClasse().getName());

        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

}