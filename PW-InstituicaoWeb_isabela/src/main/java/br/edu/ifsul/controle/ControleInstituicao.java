/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.DAOInstituicao;
import br.edu.ifsul.modelo.Instituicao;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author bela
 */
@Named (value = "controleInstituicao")
@ViewScoped 
public class ControleInstituicao implements Serializable{
    @EJB
    private DAOInstituicao<Instituicao>dao;
    private Instituicao objeto;
    
    public ControleInstituicao(){
    
    }

    public String listar(){
        return "/privado/instituicao/listar?faces-redirect=true";
    }

    public void novo(){
        objeto = new Instituicao();
    }
    
    public void alterar(Object id){
        try{
        objeto = dao.localizar(id);
        }catch(Exception e){
            Util.mensagemErro("Erro ao recuperar objeto: " + Util.getMensagemErro(e));
        }
    }
    
    public void excluir(Object id){
        try{
        objeto = dao.localizar(id);
        dao.remover(objeto);
        Util.mensagemInformacao("Objeto removido com sucesso");
        }catch(Exception e){
            Util.mensagemErro("Erro ao remover objeto: " + Util.getMensagemErro(e));
        }
    }
    
    public void salvar(){
        try{
            if(objeto.getId() == null){
                dao.persist(objeto);
            }else{
                dao.merge(objeto);
            }
            Util.mensagemInformacao("Objeto persistido com sucesso");
        }catch(Exception e){
            Util.mensagemErro("Erro ao persistir objeto: " + Util.getMensagemErro(e));
        }
    }
    public DAOInstituicao<Instituicao> getDao() {
        return dao;
    }

    public void setDao(DAOInstituicao<Instituicao> dao) {
        this.dao = dao;
    }

    public Instituicao getObjeto() {
        return objeto;
    }

    public void setObjeto(Instituicao objeto) {
        this.objeto = objeto;
    }
    
}
