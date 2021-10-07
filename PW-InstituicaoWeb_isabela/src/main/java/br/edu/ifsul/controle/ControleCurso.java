package br.edu.ifsul.controle;

import br.edu.ifsul.dao.DAOAluno;
import br.edu.ifsul.dao.DAOCurso;
import br.edu.ifsul.dao.DAODisciplina;
import br.edu.ifsul.dao.DAOInstituicao;
import br.edu.ifsul.dao.DAOUsuario;
import br.edu.ifsul.modelo.Aluno;
import br.edu.ifsul.modelo.Curso;
import br.edu.ifsul.modelo.Disciplina;

import br.edu.ifsul.modelo.Instituicao;
import br.edu.ifsul.modelo.Notas;
import br.edu.ifsul.modelo.Usuario;
import br.edu.ifsul.util.Util;
import br.edu.ifsul.util.UtilRelatorios;
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
@Named(value = "controleCurso")
@ViewScoped
public class ControleCurso implements Serializable {

    @EJB
    private DAOCurso<Curso> dao;
    private Curso objeto;
    @EJB
    private DAOInstituicao<Instituicao> daoInstituicao;
    @EJB
    private DAODisciplina<Disciplina> daoDisciplina;
    private Disciplina disciplina;
    private Boolean novaDisciplina;
   

    public ControleCurso() {

    }
    
    public void imprimeCursos(){
        HashMap parametros = new HashMap();
        UtilRelatorios.imprimeRelatorio("relatorioCursos", parametros, getDao().getListaTodos());
    }
    
    public void imprimeCurso (Object id){
        try{
            objeto = dao.localizar(id);
            List<Curso> lista = new ArrayList<>();
            lista.add(objeto);
            HashMap parametros = new HashMap();
            UtilRelatorios.imprimeRelatorio("relatorioCursos", parametros, lista);
        }catch(Exception e){
            Util.mensagemErro("Erro ao imprimir relatório: " + Util.getMensagemErro(e));
        }
    }
    public void novaDisciplina(){
        setNovaDisciplina((Boolean) true);
        setDisciplina(new Disciplina());
    }
    
    public void alterarDisciplina(int index){
        setDisciplina(getObjeto().getDisciplinas().get(index));
        setNovaDisciplina((Boolean) false);
    }
    
    public void salvarDisciplina(){
        if (getNovaDisciplina()){
            getObjeto().adicionarDisciplina(getDisciplina());
        }
        Util.mensagemInformacao("Disciplina adicionada ou atualizada com sucesso");
    }
    
    public void removerDisciplina(int index){
        getObjeto().removerDisciplinas(index);
        Util.mensagemInformacao("Disciplina removida com sucesso!");
    }

    public String listar() {
        return "/privado/curso/listar?faces-redirect=true";
    }

    public void novo() {
        objeto = new Curso();
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

    public DAOCurso<Curso> getDao() {
        return dao;
    }

    public void setDao(DAOCurso<Curso> dao) {
        this.dao = dao;
    }

    public Curso getObjeto() {
        return objeto;
    }

    public void setObjeto(Curso objeto) {
        this.objeto = objeto;
    }

    public DAOInstituicao<Instituicao> getDaoInstituicao() {
        return daoInstituicao;
    }

    public void setDaoCidade(DAOInstituicao<Instituicao> daoInstituicao) {
        this.daoInstituicao= daoInstituicao;
    }

    public DAODisciplina<Disciplina> getDaoDisciplina() {
        return daoDisciplina;
    }

    public void setDaoDisciplina(DAODisciplina<Disciplina> daoDisciplina) {
        this.daoDisciplina = daoDisciplina;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Boolean getNovaDisciplina() {
        return novaDisciplina;
    }

    public void setNovaDisciplina(Boolean novaDisciplina) {
        this.novaDisciplina = novaDisciplina;
    }

}