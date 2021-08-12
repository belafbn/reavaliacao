
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Professor;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author bela
 */
@Stateful
public class DAOProfessor<TIPO> extends DAOGenerico<Professor> implements Serializable{
    
    public DAOProfessor(){
        super();
        classPersistente = Professor.class;
    }
    
}
