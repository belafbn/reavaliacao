/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.converters.ConverterOrdem;
import br.edu.ifsul.modelo.Curso;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateful;

/**
 *
 * @author bela
 */
@Stateful
public class DAOCurso<TIPO> extends DAOGenerico<Curso> implements Serializable{
    
    public DAOCurso(){
        super();
        classPersistente = Curso. class;  
        listaOrdem.add(new Ordem("id", "ID","="));
        listaOrdem.add(new Ordem("nome","Nome","like"));
        listaOrdem.add(new Ordem("sigla","Sigla","like"));
        listaOrdem.add(new Ordem("descricao","Descrição","like"));
        listaOrdem.add(new Ordem("status","Status","like"));
        listaOrdem.add(new Ordem("inicio","Início","like"));
        
        //definição da ordem atual
        ordemAtual = listaOrdem.get(1);
        //criando uma instancia do conversor
        converterOrdem = new ConverterOrdem();
        //associando a lista de ordens ao conversor
        converterOrdem.setListaOrdem(listaOrdem);
        
    }
    @Override
    public Curso localizar(Object id) throws Exception{
        Curso objeto = em.find(Curso.class, id);
        objeto.getDisciplinas().size();
        return objeto;
    }
    
    public List<Curso> getListaCompleta(){
        String jpql = "select distinct t from Cursos t left join fetch t.disciplinas order by t.id";
        return em.createQuery(jpql).getResultList();        
    }
    
}
