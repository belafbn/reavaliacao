package br.edu.ifsul.controle;



import br.edu.ifsul.dao.DAONota;
import br.edu.ifsul.dao.DAOProva;
import br.edu.ifsul.reavalicaoprogweb.Nota;
import br.edu.ifsul.reavalicaoprogweb.Prova;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author bela
 */
@Named(value = "controleNota")
@ViewScoped
public class ControleNota implements Serializable {

    @EJB
    private DAONota<Nota> dao;
    private Nota objeto;
    @EJB
    private DAOProva<Prova> daoProva;

    public ControleNota() {
    }
    
    public String listar() {
        return "/privado/nota/listar?faces-redirect=true";
    }

    public void novo() {
        setObjeto(new Nota());
    }

  public void alterar(Object id) {
        try {
            objeto = dao.localizar(id);

        } catch (Exception e) {
            Util.mensagemErro("Erro ao recuperar objeto: " + Util.getMensagemErro(e));
        }
    }
    public void excluir(Object id) {
        try {
            objeto = dao.localizar(id);
            dao.remover(objeto);
            Util.mensagemInformacao("Objeto removido com sucesso");
        } catch (Exception e) {
            Util.mensagemErro("Erro ao remover objeto: " + Util.getMensagemErro(e));
        }
    }

    public void salvar() {
        try {
            if (objeto.getId() == null) {
                getDao().persist(objeto);
            } else {
                getDao().merge(objeto);
            }
            Util.mensagemInformacao("Objeto persistido com sucesso!");
        } catch (Exception e) {
            Util.mensagemErro("Erro ao persistir objeto: " + Util.getMensagemErro(e));
        }
    }

    public DAONota<Nota> getDao() {
        return dao;
    }

    public void setDao(DAONota<Nota> dao) {
        this.dao = dao;
    }

    public Nota getObjeto() {
        return objeto;
    }

    public void setObjeto(Nota objeto) {
        this.objeto = objeto;
    }

    public DAOProva<Prova> getDaoProva() {
        return daoProva;
    }

    public void setDaoProva(DAOProva<Prova> daoProva) {
        this.daoProva = daoProva;
    }



}
