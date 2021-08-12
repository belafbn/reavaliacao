/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Disciplina;
import br.edu.ifsul.modelo.Notas;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author bela
 */
public class TestePersistirNotas {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW-InstituicaoModel_isabela");
        EntityManager em = emf.createEntityManager();
        Disciplina d = em.find(Disciplina.class, 1);
        Notas n = new Notas();
        n.setNota01(10.0);
        n.setNota02(6.0);
        n.setMedia(8.0);
        n.setDisciplina(em.find(Disciplina.class,1));
        d.adicionarNotas(n);
        em.getTransaction().begin();
        em.persist(n);
        em.merge(d);
        em.getTransaction().commit();
        em.close();
        emf.close();
        
    }
    
}
