
package br.edu.ifsul.dao;

import br.edu.ifsul.converters.ConverterOrdem;
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
        listaOrdem.add(new Ordem("id", "ID","="));
        listaOrdem.add(new Ordem("nome","Nome","like"));
        listaOrdem.add(new Ordem("email","Email","like"));
        listaOrdem.add(new Ordem("nascimento","Nascimento","like"));
        listaOrdem.add(new Ordem("disciplinas","Disciplinas","like"));
        
        //definição da ordem atual
        ordemAtual = listaOrdem.get(1);
        //criando uma instancia do conversor
        converterOrdem = new ConverterOrdem();
        //associando a lista de ordens ao conversor
        converterOrdem.setListaOrdem(listaOrdem);
        
    }
    
}
