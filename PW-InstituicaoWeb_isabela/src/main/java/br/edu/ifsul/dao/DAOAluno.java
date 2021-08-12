
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Aluno;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author bela
 */
@Stateful
public class DAOAluno<TIPO> extends DAOGenerico<Aluno> implements Serializable{
    
    public DAOAluno(){
        super();
        classPersistente = Aluno. class; 
    }
    
}
