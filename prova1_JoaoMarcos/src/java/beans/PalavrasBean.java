 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import dados.Categoria;
import java.util.LinkedList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author ojaomarco
 */
@Named(value = "palavrasBean")
@ApplicationScoped
public class PalavrasBean {

    private List<Categoria> categorias;
    private List<SelectItem> listaCategorias;
    private Categoria catSel;
    String palavra;
    int tamanho;
    
    public int getTamanho() {
        return tamanho;
    }
    

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public Categoria getCatSel() {
        return catSel;
    }

    public void setCatSel(Categoria catSel) {
        this.catSel = catSel;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public List<SelectItem> getListaCategorias() {
        return listaCategorias;
    }
    

    public PalavrasBean() {

        categorias = new LinkedList<>();

        categorias.add(new Categoria(1, "Cidades", new String[]{"Recife", "Fortaleza", "Curitiba", "Umuarama"}));
        categorias.add(new Categoria(2, "Frutas", new String[]{"Laranja", "Banana", "Goiaba", "Morango"}));
        categorias.add(new Categoria(3, "Cores", new String[]{"Azul", "Amarelo", "Verde", "Vermelho"}));

        listaCategorias = new LinkedList<>();
        listaCategorias.add(new SelectItem(null, "Selecione a Categoria:"));
        for (Categoria c : categorias) {
            listaCategorias.add(new SelectItem(c, c.getNomeCategoria()));
        }

    }

    public String jogar() { 
        int sorteio = (int)(Math.random()*3);
        palavra = catSel.umaPalavra(sorteio);
        tamanho=palavra.length();
        return null;
    }

    

    public Categoria getCategoria(int id) {
        for (Categoria s : categorias) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }
}
