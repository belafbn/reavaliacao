/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Professor")
public class Professor  extends Aluno{
    
    @Column(name = "titulacao", length = 50, nullable = false)  
    @NotBlank(message = "A titulação deve ser informada")
    @Length(max = 50, message = "A titulação não pode ter mais que {max} caracteres")
    private String titulacao;
    
    @Column(name = "topicosInteresse", columnDefinition = "text")
    private String topicosInteresse;
    
    @NotNull(message = "A especialidade deve ser informado")
    @ManyToOne
    @JoinColumn(name = "especialidade", referencedColumnName = "id", nullable = false)
    private Especialidade especialidade;
    
    public Professor(){
    
    }


    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }
    public String getTopicosInteresse() {
        return topicosInteresse;
    }

    public void setTopicosInteresse(String topicosInteresse) {
        this.topicosInteresse = topicosInteresse;
    }

 

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }
    
    
}
