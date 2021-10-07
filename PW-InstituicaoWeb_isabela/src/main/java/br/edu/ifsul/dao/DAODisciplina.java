
package br.edu.ifsul.dao;

import br.edu.ifsul.converters.ConverterOrdem;
import br.edu.ifsul.modelo.Disciplina;
import br.edu.ifsul.modelo.Professor;
import java.io.Serializable;
import javax.ejb.Stateful;
import javax.persistence.Query;

/**
 *
 * @author bela
 */
@Stateful
public class DAODisciplina<TIPO> extends DAOGenerico<Disciplina> implements Serializable{
    
    public DAODisciplina(){
        super();
        classPersistente = Disciplina.class;
        listaOrdem.add(new Ordem("id", "ID","="));
        listaOrdem.add(new Ordem("nome","Nome","like"));
        listaOrdem.add(new Ordem("descricao","Descrição","like"));
        listaOrdem.add(new Ordem("cargaHoraria","Carga Horária","like"));
        listaOrdem.add(new Ordem("conhecimentosMinimos","Conhecimentos Mínimos","like"));
        
        //definição da ordem atual
        ordemAtual = listaOrdem.get(1);
        //criando uma instancia do conversor
        converterOrdem = new ConverterOrdem();
        //associando a lista de ordens ao conversor
        converterOrdem.setListaOrdem(listaOrdem);
    }
    
    @Override
    public Disciplina localizar(Object id) throws Exception{
        Disciplina objeto = em.find(Disciplina.class, id);
        objeto.getNotas().size();
        return objeto;
    }
    
     public boolean verificaUnicidadeNomeDisciplina(String nomeDisciplina) throws Exception {
        String jpql = "from Disciplina where nome = :pNomeDisciplina";
        Query query = em.createQuery(jpql);
        query.setParameter("pNomeDisciplina", nomeDisciplina);
        if (query.getResultList().size() > 0){
            return false;
        } else {
            return true;
        }
    }
    
}
