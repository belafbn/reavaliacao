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
import javax.validation.constraints.NotNull;

/**
 *
 * @author bela
 */
@Entity
@Table(name = "notas")
public class Notas implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_notas", sequenceName = "seq_notas_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_notas", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(name = "nota01", nullable = false, columnDefinition = "numeric(4,2)") 
    @NotNull(message = "A nota 1 deve ser informada")
    private Double nota01;
    
    @Column(name = "nota02", nullable = false, columnDefinition = "numeric(4,2)") 
    @NotNull(message = "A nota 2 deve ser informada")
    private Double nota02;
    
    @Column(name = "media", nullable = false, columnDefinition = "numeric(4,2)") 
    @NotNull(message = "A media deve ser informada")
    private Double media;
    
    @NotNull(message = "A disciplina deve ser informado")
    @ManyToOne
    @JoinColumn(name = "disciplina_id", referencedColumnName = "id", nullable = false)        
    private Disciplina disciplina;
    
    public Notas(){
    
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getNota01() {
        return nota01;
    }

    public void setNota01(Double nota01) {
        this.nota01 = nota01;
    }

    public Double getNota02() {
        return nota02;
    }

    public void setNota02(Double nota02) {
        this.nota02 = nota02;
    }

    public Double getMedia() {
        return media;
    }

    
    public void setMedia(Double media) {
        this.media= media;
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
        final Notas other = (Notas) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
    
}
