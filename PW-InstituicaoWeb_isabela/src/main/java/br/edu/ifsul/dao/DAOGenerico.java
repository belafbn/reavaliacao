/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author bela
 * 
 * @param <TIPO>
 */
public class DAOGenerico<TIPO> implements Serializable {
    private List<TIPO> listaObjetos; //consulta que será paginada
    private List<TIPO> listaTodos;
    @PersistenceContext(unitName = "PW-InstituicaoWeb_isabela")
    protected EntityManager em;
    protected Class classPersistente;
    
    public DAOGenerico(){
    
    }

    public List<TIPO> getListaObjetos() {
        String jpql = "from " + classPersistente.getSimpleName();
        return em.createQuery(jpql).getResultList();
    }

    public void setListaObjetos(List<TIPO> listaObjetos) {
        this.listaObjetos = listaObjetos;
    }

    public List<TIPO> getListaTodos() {
       String jpql = "from " + classPersistente.getSimpleName();
       return em.createQuery(jpql).getResultList();
    }
    
    public void persist (TIPO obj) throws Exception{
        em.persist(obj);
    }
    
    public void merge (TIPO obj) throws Exception{
        em.merge(obj);
    }
    
    public void remover (TIPO obj) throws Exception{
        obj = em.merge(obj);
        em.persist(obj);
    }
    
    public TIPO localizar(Object id) throws Exception{
        return (TIPO) em.find(classPersistente, id); 
    }
    public void setListaTodos(List<TIPO> listaTodos) {
        this.listaTodos = listaTodos;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public Class getClassPersistente() {
        return classPersistente;
    }

    public void setClassPersistente(Class classPersistente) {
        this.classPersistente = classPersistente;
    }
}
