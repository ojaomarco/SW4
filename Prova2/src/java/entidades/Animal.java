/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author ojaomarco
 */
public class Animal implements Serializable {
    private static final AtomicInteger count = new AtomicInteger(4); 
    private int id;
    private String tipo;
    private LinkedList<Veterinario> veterinarios;

    public Animal(int id, String tipo) {
        this.id = id;
        this.tipo = tipo;
        veterinarios = new LinkedList<>();
    }

    public Animal(String tipo) {
        this.id=count.incrementAndGet();
        this.tipo = tipo;
        veterinarios = new LinkedList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Animal other = (Animal) obj;
        return this.id == other.id;
    }

    public void adicionarVeterinario(int id, String nome) {
        Veterinario v = new Veterinario(id, nome, this);
        veterinarios.add(v);
    }

    public LinkedList<Veterinario> getVeterinarios() {
        return veterinarios;
    }
    
    
    

}
