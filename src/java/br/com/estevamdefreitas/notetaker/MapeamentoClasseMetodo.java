/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.estevamdefreitas.notetaker;

import java.lang.reflect.Method;

/**
 *
 * @author estev
 */
public class MapeamentoClasseMetodo {

    private Class classe;
    private Method metodo;

    public MapeamentoClasseMetodo(Class classe, Method metodo) {
        this.classe = classe;
        this.metodo = metodo;
    }
    
    public Class getClasse() {
        return classe;
    }

    public void setClasse(Class classe) {
        this.classe = classe;
    }

    public Method getMetodo() {
        return metodo;
    }

    public void setMetodo(Method metodo) {
        this.metodo = metodo;
    }

}
