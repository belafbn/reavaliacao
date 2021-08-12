package br.edu.ifsul.controle;

import br.edu.ifsul.dao.DAOAluno;
import br.edu.ifsul.modelo.Aluno;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author bela
 */
@Named(value = "controleAluno")
@ViewScoped
public class ControleAluno implements Serializable {

    @EJB
    private DAOAluno<Aluno> dao;
    private Aluno objeto;

    public ControleAluno() {

    }

    public String listar() {
        return "/privado/aluno/listar?faces-redirect=true";
    }
    
    public void novo(){
        objeto = new Aluno();
        
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

    public DAOAluno<Aluno> getDao() {
        return dao;
    }

    public void setDao(DAOAluno<Aluno> dao) {
        this.dao = dao;
    }

    public Aluno getObjeto() {
        return objeto;
    }

    public void setObjeto(Aluno objeto) {
        this.objeto = objeto;
    }


}
