/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Aluno;
import br.edu.ifsul.modelo.Curso;
import br.edu.ifsul.modelo.Disciplina;
import br.edu.ifsul.modelo.Notas;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author bela
 */
public class TestePersistirDisciplina {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW-InstituicaoModel_isabela");
        EntityManager em = emf.createEntityManager();
        Disciplina d = new Disciplina();
        Aluno a = em.find(Aluno.class, 1);
        Disciplina d3 = em.find(Disciplina.class, 1);
        d.setNome("Programação Web");
        d.setDecricao("Aulas de programação web");
        d.setCargaHoraria(45.0);
        d.setConhecimentosMinimos("blablablabla");
        Curso c = em.find(Curso.class, 1);
        em.getTransaction().begin();
        em.persist(d);
        c.adicionarDisciplina(d);
        a.getDisplinas().add(d3);
        em.merge(a);
        em.getTransaction().commit();
        em.close();
        emf.close(); 
    }
    
}
