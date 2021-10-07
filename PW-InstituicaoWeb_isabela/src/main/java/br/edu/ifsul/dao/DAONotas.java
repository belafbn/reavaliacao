/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.converters.ConverterOrdem;
import br.edu.ifsul.modelo.Especialidade;
import br.edu.ifsul.modelo.Notas;
import java.io.Serializable;

/**
 *
 * @author bela
 */
public class DAONotas <TIPO> extends DAOGenerico<Notas> implements Serializable  {
     public DAONotas(){
        super();
        classPersistente = Especialidade.class;
        //definindo a lista de ordenações
        listaOrdem.add(new Ordem("id", "ID","="));
        listaOrdem.add(new Ordem("nota01","Nota 01","like"));
        listaOrdem.add(new Ordem("nota02","Nota 02","like"));
        listaOrdem.add(new Ordem("media","Media","like"));
        //definição da ordem atual
        ordemAtual = listaOrdem.get(1);
        //criando uma instancia do conversor
        converterOrdem = new ConverterOrdem();
        //associando a lista de ordens ao conversor
        converterOrdem.setListaOrdem(listaOrdem);
        
    }
}
