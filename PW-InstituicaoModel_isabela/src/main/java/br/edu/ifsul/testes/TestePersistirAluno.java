/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Aluno;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author bela
 */
public class TestePersistirAluno {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW-InstituicaoModel_isabela");
        EntityManager em = emf.createEntityManager();
        Aluno a = new Aluno();
        a.setNome("Pedro");
        a.setEmail("pedropedro@email.com");
        a.setNascimento(Calendar.getInstance());
        
        em.getTransaction().begin();
        em.persist(a);        
        em.getTransaction().commit();
        em.close();
        emf.close();
        
        
        
    }
    
}
