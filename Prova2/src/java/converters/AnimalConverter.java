package converters;

import dao.AnimalDAO;
import entidades.Animal;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

@ApplicationScoped
@Named(value="animalConverter")
public class AnimalConverter implements Converter {
    
    @Inject
    AnimalDAO mBean;
   
    @Override
    public String getAsString(FacesContext context, 
            UIComponent component, Object value) {
        if (value == null) {
            return null;
        }
        Animal m = (Animal) value;
        return String.valueOf( m.getId() );
    }

    @Override
    public Object getAsObject(FacesContext context,
            UIComponent component, String value) {
        try {
            int codigo = Integer.parseInt(value);
            return mBean.buscarAnimal(codigo );
        } catch(NumberFormatException nfe) { 
        }
        return null;
    }
}
