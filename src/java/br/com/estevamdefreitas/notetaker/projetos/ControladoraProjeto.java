/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.estevamdefreitas.notetaker.projetos;

import br.com.estevamdefreitas.notetaker.anotacao.Controladora;
import br.com.estevamdefreitas.notetaker.anotacao.Requisicao;
import java.time.LocalDate;

/**
 *
 * @author estev
 */
@Controladora("projeto")
public class ControladoraProjeto {
    
    @Requisicao("projeto")
    public Projeto getProjeto(){
        return new Projeto("Projeto de teste", LocalDate.now(), 1);
    }
    
}
