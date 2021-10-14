/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.converter.ConverterOrdem;
import br.edu.ifsul.reavalicaoprogweb.Prova;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateful;

/**
 *
 * @author jessi
 */
@Stateful
public class DAOProva<TIPO> extends DAOGenerico<Prova> implements  Serializable{
    
    public DAOProva(){
        super();
        classePersistente = Prova.class;
        listaOrdem.add(new Ordem("id", "ID", "="));
        listaOrdem.add(new Ordem("descricao", "Descricao", "like"));
        listaOrdem.add(new Ordem("conteudo", "Conteúdo", "like"));
        listaOrdem.add(new Ordem("dataProva", "Data Prova", "like"));
        listaOrdem.add(new Ordem("mediaGeral", "Media Geral", "like"));
        listaOrdem.add(new Ordem("professor", "Professor", "like"));
        
        ordemAtual = listaOrdem.get(1);
        converterOrdem = new ConverterOrdem();
        converterOrdem.setListaOrdem(listaOrdem);
    }
    @Override
    public Prova localizar(Object id) throws Exception{
        Prova objeto = em.find(Prova.class, id);
        objeto.getNotas().size();
        return objeto;
    }
    public List<Prova> getListaCompleta (){
        String jpql = "select distinct p from Prova p left join fetch p.notas order by p.id";
        return em.createQuery(jpql).getResultList();
    }
    
}
