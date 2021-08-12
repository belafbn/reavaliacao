
package br.edu.ifsul.converts;


import br.edu.ifsul.modelo.Especialidade;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jessica
 */
@Named(value = "converterEspecialidade")
@RequestScoped
public class ConverterEspecialidade implements Serializable,  Converter{
    
    @PersistenceContext(unitName = "PW-InstituicaoWeb_isabela")
    private EntityManager em;
    
    @Override
   public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (string == null || string.equals("Selecione um registro")){
            return null;
        }
        return em.find(Especialidade.class, Integer.parseInt(string));
    }

    // converte o objeto que vem do banco em uma string para tela
    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        if (t == null){
            return null;
        }
        Especialidade obj = (Especialidade) t;
        return obj.getId().toString();
    }

}
