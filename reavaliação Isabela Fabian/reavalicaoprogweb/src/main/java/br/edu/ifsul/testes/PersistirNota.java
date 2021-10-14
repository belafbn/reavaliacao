/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.reavalicaoprogweb.Nota;
import br.edu.ifsul.reavalicaoprogweb.Prova;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author bela
 */
public class PersistirNota {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("reavalicaoprogweb");
        EntityManager em = emf.createEntityManager();
        Nota n = new Nota();
        Prova p = em.find(Prova.class, 1);
        n.setAluno("Natália");
        n.setNota(9.5);
        em.getTransaction().begin();
        em.persist(n);
        p.adicionarNotas(n);
        em.getTransaction().commit();
        em.close();
        emf.close(); 
          }
    
}
