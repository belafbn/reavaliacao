package br.edu.ifsul.controle;


import br.edu.ifsul.dao.DAOAluno;
import br.edu.ifsul.dao.DAOCurso;
import br.edu.ifsul.dao.DAODisciplina;
import br.edu.ifsul.dao.DAOInstituicao;
import br.edu.ifsul.dao.DAONotas;
import br.edu.ifsul.modelo.Aluno;
import br.edu.ifsul.modelo.Curso;
import br.edu.ifsul.modelo.Disciplina;
import br.edu.ifsul.modelo.Instituicao;
import br.edu.ifsul.modelo.Notas;
import br.edu.ifsul.util.Util;
import br.edu.ifsul.util.UtilRelatorios;
import java.io.Serializable;
import java.util.HashMap;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author bela
 */
@Named(value = "controleDisciplina")
@ViewScoped
public class ControleDisciplina implements Serializable {

    @EJB
    private DAODisciplina<Disciplina> dao;
    private Disciplina objeto;
    private boolean novo;
    
    @EJB
    private DAOAluno<Aluno> daoAluno;
    private Aluno aluno;
    

    @EJB
    private DAOInstituicao<Instituicao> daoInstituicao;
    private Notas notas;
    private Boolean novaNota;

    public ControleDisciplina() {

    }
/*
    public void removerAluno(Aluno obj) {
        objeto.getAlunos().remove(obj);
        Util.mensagemInformacao("Aluno removido com sucesso!");
    }

    public void adicionarAluno() {
        if (!objeto.getAlunos().contains(aluno)) {
            if (aluno != null) {
                objeto.getAlunos().add(aluno);
                Util.mensagemInformacao("Aluno adicionado com sucesso!");
            } else {
                Util.mensagemErro("Selecione o aluno");
            }
        } else {
            Util.mensagemErro("Disciplina já possui este aluno");
        }
    }

    public void verificarUnicidadeNomeDisciplina() {
        if (novo) {
            try {
                if (!dao.verificaUnicidadeNomeDisciplina(objeto.getNome())) {
                    Util.mensagemErro("Nome da disciplina '" + objeto.getNome() + "' "
                            + " já existe no banco de dados!");
                    objeto.setNome(null);
                    // capturar o componente que chamou o método
                    UIComponent comp
                            = UIComponent.getCurrentComponent(FacesContext.getCurrentInstance());
                    if (comp != null) {
                        // deixar em vermelho após o update
                        UIInput input = (UIInput) comp;
                        input.setValid(false);
                    }
                }
            } catch (Exception e) {
                Util.mensagemErro("Erro do sistema:" + Util.getMensagemErro(e));
            }
        }
    }
*/
    public void imprimeDisciplinas(){
        HashMap parametros = new HashMap();
        UtilRelatorios.imprimeRelatorio("relatorioDisciplinas", parametros, dao.getListaTodos());
    }
    
    public void novaNota(){
        novaNota = true;
        notas = new Notas();
    }
    
    public void alterarNota(int index){
        notas = objeto.getNotas().get(index);
        novaNota = false;
    }
    
    public void salvarNota(){
        if (novaNota){
            objeto.adicionarNotas(notas);
        }
        Util.mensagemInformacao("Nota adicionada ou atualizada com sucesso");
    }
    
    public void removerNota(int index){
        objeto.removerNotas(index);
        Util.mensagemInformacao("Nota removida com sucesso!");
    }
    public String listar() {
        return "/privado/disciplinas/listar?faces-redirect=true";
    }
     public void novo() {
        objeto = new Disciplina();
        novo = true;
    }

    public void alterar(Object id) {
        try {
            objeto = dao.localizar(id);
            novo = false;
        } catch (Exception e) {
            Util.mensagemInformacao("Erro ao recuperar objeto: " + Util.getMensagemErro(e));
        }
    }

    public void excluir(Object id) {
        try {
            objeto = dao.localizar(id);
            dao.remover(objeto);
            Util.mensagemInformacao("Objeto removido com sucesso!");
        } catch (Exception e) {
            Util.mensagemInformacao("Erro ao remover objeto: " + Util.getMensagemErro(e));
        }
    }

    public void salvar() {
        try {
            if (novo) {
                dao.persist(objeto);
            } else {
                dao.merge(objeto);
            }
            Util.mensagemInformacao("Objeto persistido com sucesso!");
        } catch (Exception e) {
            Util.mensagemInformacao("Erro ao salvar objeto: " + Util.getMensagemErro(e));
        }
    }
    public DAODisciplina<Disciplina> getDao() {
        return dao;
    }

    public void setDao(DAODisciplina<Disciplina> dao) {
        this.dao = dao;
    }

    public Disciplina getObjeto() {
        return objeto;
    }

    public void setObjeto(Disciplina objeto) {
        this.objeto = objeto;
    }

  

    public DAOInstituicao<Instituicao> getDaoInstituicao() {
        return daoInstituicao;
    }

    public void setDaoInstituicao(DAOInstituicao<Instituicao> daoInstituicao) {
        this.daoInstituicao = daoInstituicao;
    }

    public Notas getNotas() {
        return notas;
    }

    public void setNotas(Notas notas) {
        this.notas = notas;
    }

    public Boolean getNovaNota() {
        return novaNota;
    }

    public void setNovaNota(Boolean novaNota) {
        this.novaNota = novaNota;
    }

    public boolean isNovo() {
        return novo;
    }

    public void setNovo(boolean novo) {
        this.novo = novo;
    }

    public DAOAluno<Aluno> getDaoAluno() {
        return daoAluno;
    }

    public void setDaoAluno(DAOAluno<Aluno> daoAluno) {
        this.daoAluno = daoAluno;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
   

  

}