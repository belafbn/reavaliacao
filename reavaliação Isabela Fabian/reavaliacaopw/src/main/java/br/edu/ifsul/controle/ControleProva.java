/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;


import br.edu.ifsul.dao.DAONota;
import br.edu.ifsul.dao.DAOProva;
import br.edu.ifsul.reavalicaoprogweb.Nota;
import br.edu.ifsul.reavalicaoprogweb.Prova;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author bela
 */
@Named(value = "controleProva")
@ViewScoped
public class ControleProva implements Serializable {

    @EJB
    private DAOProva<Prova> dao;
    private Prova objeto;
   
    @EJB
    private DAONota<Nota> daonota;
    private Nota nota;
    private Boolean novaNota;

    public ControleProva() {

    }

    public void novaNota() {
        novaNota = true;
        nota = new Nota();
    }

    public void alterarNota(int index) {
         nota = objeto.getNotas().get(index);
        novaNota = false;
    }

    public void salvarNota() {
       if (novaNota) {
            objeto.adicionarNotas(nota);
        }
        Util.mensagemInformacao("Nota adicionada ou atualizada com sucesso");
    }

     public void removerNota(int index) {
        objeto.removerNotas(index);
        Util.mensagemInformacao("Nota removida com sucesso!");
    }


    public String listar() {
        return "/privado/prova/listar?faces-redirect=true";
    }

    public void novo() {
        objeto = new Prova();
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
                dao.persist(objeto);
            } else {
                dao.merge(objeto);
            }
            Util.mensagemInformacao("Objeto persistido com sucesso!");
        } catch (Exception e) {
            Util.mensagemErro("Erro ao persistir objeto: " + Util.getMensagemErro(e));
        }
    }


    public DAOProva<Prova> getDao() {
        return dao;
    }

    public void setDao(DAOProva<Prova> dao) {
        this.dao = dao;
    }

    public Prova getObjeto() {
        return objeto;
    }

    public void setObjeto(Prova objeto) {
        this.objeto = objeto;
    }

    public DAONota<Nota> getDaonota() {
        return daonota;
    }

    public void setDaonota(DAONota<Nota> daonota) {
        this.daonota = daonota;
    }

    public Nota getNota() {
        return nota;
    }

    public void setNota(Nota nota) {
        this.nota = nota;
    }

    public Boolean getNovaNota() {
        return novaNota;
    }

    public void setNovaNota(Boolean novaNota) {
        this.novaNota = novaNota;
    }

 

}
