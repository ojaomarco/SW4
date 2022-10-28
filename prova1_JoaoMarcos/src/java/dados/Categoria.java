/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dados;

import java.io.Serializable;

/**
 *
 * @author ojaomarco
 */
public class Categoria implements Serializable{
    int id;
    String nomeCategoria;
    String[] palavrasCat;

    public Categoria(int id, String nomeCategoria, String[] palavrasCat) {
        this.id = id;
        this.nomeCategoria = nomeCategoria;
        this.palavrasCat = palavrasCat;
    }

    @Override
    public String toString() {
        return "Categoria: "+nomeCategoria;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public String[] getPalavrasCat() {
        return palavrasCat;
    }

    public void setPalavrasCat(String[] palavrasCat) {
        this.palavrasCat = palavrasCat;
    }
    
    public String umaPalavra(int i){
     return this.palavrasCat[i];  
    }
    
    
    
}
