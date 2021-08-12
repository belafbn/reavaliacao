/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;
import java.io.Serializable;
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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
/**
 *
 * @author bela
 */
@Entity
@Table(name = "disciplina")
public class Disciplina implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_disciplina", sequenceName = "seq_disciplina_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_disciplina", strategy = GenerationType.SEQUENCE) 
    private Integer id;
    
    @Column(name = "nome", length = 30, nullable = false) 
    @NotBlank(message = "O nome da disciplina deve ser informado")
    @Length(max = 30, message = "O nome da disciplina não pode ter mais que {max} caracteres")
    private String nome;
    
    @Column(name = "descriçao", nullable = false, columnDefinition = "text")
    private String decricao;
    
    @Column(name = "cargaHoraria", nullable = false, columnDefinition = "numeric(4,2)") 
    @NotNull(message = "A nota 2 deve ser informada")
    private Double cargaHoraria;
    
    @Column(name = "conhecimentosMinimos", columnDefinition = "text")
    private String conhecimentosMinimos;
    
    @OneToMany(mappedBy = "disciplina", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Notas> notas;
    
    @NotNull(message = "O curso deve ser informado")
    @ManyToOne
    @JoinColumn(name = "curso_id", referencedColumnName = "id", nullable = false)        
    private Curso curso;
    
    public Disciplina(){
    
    }
    public void adicionarNotas(Notas obj){
        obj.setDisciplina(this);
        this.notas.add(obj);
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

    public String getDecricao() {
        return decricao;
    }

    public void setDecricao(String decricao) {
        this.decricao = decricao;
    }

    public Double getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Double cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getConhecimentosMinimos() {
        return conhecimentosMinimos;
    }

    public void setConhecimentosMinimos(String conhecimentosMinimos) {
        this.conhecimentosMinimos = conhecimentosMinimos;
    }

    public List<Notas> getNotas() {
        return notas;
    }

    public void setNotas(List<Notas> notas) {
        this.notas = notas;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Disciplina other = (Disciplina) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
     public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
    
}
