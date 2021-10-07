package br.edu.ifsul.dao;

import br.edu.ifsul.converters.ConverterOrdem;
import br.edu.ifsul.modelo.Permissao;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author bela
 */
@Stateful
public class DAOPermissao<TIPO>  extends DAOGenerico<Permissao> implements Serializable {
    
    public DAOPermissao(){
        super();
        classPersistente = Permissao.class;
        // definir as ordens possíveis        
        listaOrdem.add(new Ordem("nome", "Nome", "like"));
        listaOrdem.add(new Ordem("descricao", "Descrição", "like"));
        // difinir a ordem inicial
        ordemAtual = listaOrdem.get(0);
        // inicializar o conversor das ordens
        converterOrdem = new ConverterOrdem();
        converterOrdem.setListaOrdem(listaOrdem);              
    }

}
