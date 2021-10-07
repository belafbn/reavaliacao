/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.converters.ConverterOrdem;
import br.edu.ifsul.modelo.Instituicao;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author bela
 */
@Stateful
public class DAOInstituicao<TIPO> extends DAOGenerico<Instituicao> implements Serializable {
    public DAOInstituicao(){
        super();
        classPersistente = Instituicao.class;
        listaOrdem.add(new Ordem("id", "ID","="));
        listaOrdem.add(new Ordem("nome","Nome","like"));
        listaOrdem.add(new Ordem("anoFundacao","Ano Fundação","like"));
        //definição da ordem atual
        ordemAtual = listaOrdem.get(1);
        //criando uma instancia do conversor
        converterOrdem = new ConverterOrdem();
        //associando a lista de ordens ao conversor
        converterOrdem.setListaOrdem(listaOrdem);
        
    }
}
