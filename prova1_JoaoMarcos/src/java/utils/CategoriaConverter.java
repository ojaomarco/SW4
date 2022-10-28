package utils;

import beans.PalavrasBean;
import dados.Categoria;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value="conversorCategoria")
@ApplicationScoped
public class CategoriaConverter implements Converter {

    @Inject 
    PalavrasBean palavraBean;
    
    @Override
    public Object getAsObject(FacesContext context, 
            UIComponent component, String value) {
        try {
            int id = Integer.parseInt( value );
            return palavraBean.getCategoria(id);
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, 
             UIComponent component, Object value) {
        if (value == null) 
            return null;
        Categoria s = (Categoria) value;
        return String.valueOf( s.getId() );
    }    
}
