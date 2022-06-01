/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.estevamdefreitas.notetaker.projetos;

import java.time.LocalDate;

/**
 *
 * @author estev
 */
public class Projeto {
    private int id;
    private String nome;
    private LocalDate dataConclusao;
    private int status;

    public Projeto(int id, String nome, LocalDate dataConclusao, int status) {
        this.id = id;
        this.nome = nome;
        this.dataConclusao = dataConclusao;
        this.status = status;
    }

    public Projeto(String nome, LocalDate dataConclusao, int status) {
        this.nome = nome;
        this.dataConclusao = dataConclusao;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDate dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
}
