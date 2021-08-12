/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "Aluno")
public class Aluno implements Serializable {

    public Set<Disciplina> getDisplinas() {
        return displinas;
    }

    public void setDisplinas(Set<Disciplina> displinas) {
        this.displinas = displinas;
    }

    @Id
    @SequenceGenerator(name = "seq_aluno", sequenceName = "seq_aluno_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_aluno", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "nome", length = 50, nullable = false)
    @NotBlank(message = "O nome deve ser informado")
    @Length(max = 50, message = "O nome não pode ter mais que {max} caracteres")
    private String nome;

    @Column(name = "email", length = 50, nullable = false)
    @NotBlank(message = "O email deve ser informado")
    @Length(max = 50, message = " não pode ter mais que {max} caracteres")
    private String email;

    @Column(name = "nascimento", nullable = false)
    @Temporal(TemporalType.DATE)
    @NotNull(message = "O nascimento deve ser informado")
    private Calendar nascimento;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "disciplinas_alunos",
            joinColumns
            = @JoinColumn(name = "nome_aluno", referencedColumnName = "id", nullable = false),
            inverseJoinColumns
            = @JoinColumn(name = "disciplina", referencedColumnName = "id", nullable = false))
    private Set<Disciplina> displinas = new HashSet<>();
    
    public Aluno(){
    
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Calendar getNascimento() {
        return nascimento;
    }

    public void setNascimento(Calendar nascimento) {
        this.nascimento = nascimento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.id);
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
        final Aluno other = (Aluno) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
