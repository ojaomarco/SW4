package converters;

import dao.AnimalDAO;
import entidades.Veterinario;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

@ApplicationScoped
@Named(value="veterinarioConverter")
public class VeterinarioConverter implements Converter {

    @Inject
    AnimalDAO marcaBean;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            int id = Integer.parseInt( value );
            return marcaBean.buscarVet(id );
        } catch(NumberFormatException ex) { }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
       if (value == null) {
           return null;
       }
       Veterinario mod = (Veterinario) value;
       return String.valueOf( mod.getId() );
    }
    
}
