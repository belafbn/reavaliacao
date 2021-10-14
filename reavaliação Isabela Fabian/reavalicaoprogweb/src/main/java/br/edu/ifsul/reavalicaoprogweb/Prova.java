package br.edu.ifsul.reavalicaoprogweb;


import java.io.Serializable;
import java.util.ArrayList;
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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bela
 */
@Entity
@Table(name = "prova")
public class Prova implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_prova", sequenceName = "seq_prova_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_prova", strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;
    
    @NotBlank(message = "A descrição deve ser informada")
    @Length(max = 150, message = "A descrição não pode ter mais que {max} caracteres")
    @Column(name = "descricao", length = 150, nullable = false) 
    private String descricao;
    
    @NotBlank(message = "O conteudo deve ser informado")
    @Length(max = 150, message = "A descrição não pode ter mais que {max} caracteres")
    @Column(name = "conteudo", length = 150, nullable = false)
    private String conteudo;
    
    @Temporal(TemporalType.DATE)
    @NotNull(message = "A data da prova deve ser informada")
    @Column(name = "dataProva", nullable = false)
    private Calendar dataProva;
    
    @NotNull(message = "A média geral deve ser informada")
    @Column(name = "mediaGeral", nullable = false, columnDefinition = "numeric(4,2)")
    private Double mediaGeral;
    
    @NotBlank(message = "O professor deve ser informado")
    @Length(max = 50, message = "O nome do professor não pode ter mais que {max} caracteres")
    @Column(name = "professor", length = 150, nullable = false) 
    private String professor;
    
    @OneToMany(mappedBy = "prova", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)    
    private List<Nota> notas = new ArrayList<>();

     public Prova() {
    
     }
     public void adicionarNotas(Nota obj){
        obj.setProva(this);
        this.notas.add(obj);
    }
    public void removerNotas(int index){
        this.notas.remove(index);
    }
     
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Calendar getDataProva() {
        return dataProva;
    }

    public void setDataProva(Calendar dataProva) {
        this.dataProva = dataProva;
    }

    public Double getMediaGeral() {
        return mediaGeral;
    }

    public void setMediaGeral(Double mediaGeral) {
        this.mediaGeral = mediaGeral;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

   public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final Prova other = (Prova) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
