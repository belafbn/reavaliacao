/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Especialidade;
import br.edu.ifsul.modelo.Professor;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author bela
 */
public class TestePersistirProfessor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW-InstituicaoModel_isabela");
        EntityManager em = emf.createEntityManager();
        Professor p = new Professor();
        p.setTitulacao("Mestre");
        p.setTopicosInteresse("blablablabla");
        p.setNome("Lucas");
        p.setEmail("lucaslucas@email.com");
        p.setNascimento(Calendar.getInstance());
        p.setEspecialidade(em.find(Especialidade.class, 1));
        em.getTransaction().begin();
        em.merge(p);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
