
package br.edu.ifsul.controle;


import br.edu.ifsul.dao.DAOEspecialidade;
import br.edu.ifsul.dao.DAOProfessor;
import br.edu.ifsul.modelo.Especialidade;
import br.edu.ifsul.modelo.Professor;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author bela
 */
@Named(value = "controleProfessor")
@ViewScoped
public class ControleProfessor implements Serializable{
    @EJB
    private DAOProfessor<Professor> dao; 
    private Professor objeto;
    @EJB
    private DAOEspecialidade<Especialidade> daoEspecialidade;
    
    public ControleProfessor(){
    
    }
    
    public String listar(){
        return "/privado/professor/listar?faces-redirect=true";
    }
    public void novo(){
        objeto = new Professor();
    }
public void alterar(Object id) {
        try {
            objeto = dao.localizar(id);
        } catch (Exception e) {
            Util.mensagemErro("Erro ao recuperar objeto: " + Util.getMensagemErro(e));
        }
    }
    
    public void excluir(Object id){
        try {
            objeto = dao.localizar(id);
            dao.remover(objeto);
            Util.mensagemInformacao("Objeto removido com sucesso");
        } catch (Exception e){
            Util.mensagemErro("Erro ao remover objeto: " + Util.getMensagemErro(e));
        }
    }
    
    public void salvar(){
        try {
            if (objeto.getId() == null){
                dao.persist(objeto);
            } else {
                dao.merge(objeto);
            }
            Util.mensagemInformacao("Objeto persistido com sucesso!");
        } catch (Exception e){
            Util.mensagemErro("Erro ao persistir objeto: " + Util.getMensagemErro(e));
        }
    }

    public DAOProfessor<Professor> getDao() {
        return dao;
    }

    public void setDao(DAOProfessor<Professor> dao) {
        this.dao = dao;
    }

    public Professor getObjeto() {
        return objeto;
    }

    public void setObjeto(Professor objeto) {
        this.objeto = objeto;
    }

    public DAOEspecialidade<Especialidade> getDaoEstado() {
        return daoEspecialidade;
    }

    public void setDaoEstado(DAOEspecialidade<Especialidade> daoEspecialidade) {
        this.daoEspecialidade = daoEspecialidade;
    }

}

