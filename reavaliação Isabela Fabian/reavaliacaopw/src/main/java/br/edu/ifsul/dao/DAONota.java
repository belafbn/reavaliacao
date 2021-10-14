/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.converter.ConverterOrdem;
import br.edu.ifsul.reavalicaoprogweb.Nota;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateful;

/**
 *
 * @author bela
 */
@Stateful
public class DAONota<TIPO> extends DAOGenerico<Nota> implements Serializable {

    public DAONota() {
        super();
        classePersistente = Nota.class;
        listaOrdem.add(new Ordem("id", "ID", "="));
        listaOrdem.add(new Ordem("aluno", "Aluno", "like"));
        listaOrdem.add(new Ordem("nota", "Nota", "like"));

        ordemAtual = listaOrdem.get(1);
        converterOrdem = new ConverterOrdem();
        converterOrdem.setListaOrdem(listaOrdem);
    }
   @Override 
   public Nota localizar(Object id) throws Exception {

        Nota objeto = em.find(Nota.class, id);
        return objeto;
    }
   
}
