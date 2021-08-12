/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author bela
 */
@Entity
@Table(name = "curso")
public class Curso implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_curso", sequenceName = "seq_curso_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_curso", strategy = GenerationType.SEQUENCE) 
    private Integer id;
    
    @Column(name = "nome", length = 50, nullable = false)
    @NotBlank(message = "O nome deve ser informado")
    @Length(max = 50, message = "O nome não pode ter mais que {max} caracteres")
    private String nome;
    
    @Column(name = "descricao", columnDefinition = "text")
    private String descricao;
    
    @Column(name = "sigla", length = 5, nullable = false)
    @NotBlank(message = "A sigla deve ser informada")
    @Length(max = 5, message = "A sigla não pode ter mais que {max} caracteres")
    private String sigla;
    
    @Column(name = "status", nullable = false, columnDefinition = "boolean")
    @NotNull(message = "O nome deve ser informado")
    private Boolean status;
    
    @Column(name = "inicioAtividades", nullable = false)
    @Temporal(TemporalType.DATE)
    @NotNull(message = "O inicio das atividades deve ser informada")
    private Calendar inicioAtividades;
    
    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Disciplina> disciplinas;
    
    @NotNull(message = "A instituição deve ser informada")
    @ManyToOne
    @JoinColumn(name = "instituicao", referencedColumnName = "id", nullable = false)
    private Instituicao intituicao;
    
    public Curso(){
    
    }
    public void adicionarDisciplina(Disciplina obj){
        obj.setCurso(this);
        this.disciplinas.add(obj);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Calendar getInicioAtividades() {
        return inicioAtividades;
    }

    public void setInicioAtividades(Calendar inicioAtividades) {
        this.inicioAtividades = inicioAtividades;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public Instituicao getIntituicao() {
        return intituicao;
    }

    public void setIntituicao(Instituicao intituicao) {
        this.intituicao = intituicao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Curso other = (Curso) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
   
    
}
