/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;


import br.edu.ifsul.reavalicaoprogweb.Prova;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author bela
 */
public class PersistirProva {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("reavalicaoprogweb");
        EntityManager em = emf.createEntityManager();
        Prova p = new Prova();
        p.setDescricao("Prova primeira etapa");
        p.setConteudo("Conteúdo primeira etapa");
        p.setDataProva(Calendar.getInstance());
        p.setMediaGeral(6.0);
        p.setProfessor("Isabela");
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
