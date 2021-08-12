/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Instituicao;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author bela
 */
@Stateful
public class DAOInstituicao<TIPO> extends DAOGenerico<Instituicao> implements Serializable {
    public DAOInstituicao(){
        super();
        classPersistente = Instituicao.class;
    }
}