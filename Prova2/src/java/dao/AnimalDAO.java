/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entidades.Animal;
import entidades.Veterinario;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import javax.faces.model.SelectItem;

/**
 *
 * @author ojaomarco
 */
public class AnimalDAO implements Serializable{
    private static LinkedList<Animal> animais;
    private static LinkedList<SelectItem> tipoAnimal;
    private static AtomicInteger count = new AtomicInteger(30);

    public AnimalDAO() {
        System.out.flush();
        if (animais == null) {
            animais = new LinkedList<>();
            Animal a = new Animal(1, "Cachorro");
            a.adicionarVeterinario(1, "Dr. Rodrigo");
            a.adicionarVeterinario(2, "Dr. Julio");
            a.adicionarVeterinario(3, "Dra. Marcela");
          
            animais.add(a);

            a = new Animal(2, "Gato");
            a.adicionarVeterinario(10, "Dr. Roberto");
            a.adicionarVeterinario(11, "Dr. Adrian");
            a.adicionarVeterinario(12, "Dra. Paula");
            animais.add(a);

            a = new Animal(3, "Pássaros");
            a.adicionarVeterinario(20, "Dr. Vinicius");
            a.adicionarVeterinario(21, "Dr. João");
            a.adicionarVeterinario(22, "Dra. Leticia");
            animais.add(a);
        }
        tipoAnimal = new LinkedList<>();
        tipoAnimal.add(new SelectItem(null, "Selecione o Animal"));
        for (Animal a1 : animais) {
            tipoAnimal.add(new SelectItem(a1, a1.getTipo()));
        }
    }

    public LinkedList<Animal> getAnimais() {
        return animais;
    }
    
      public Animal buscarAnimal(int id) {
        for (Animal a : animais) {
            if (a.getId() == id) {
                return a;
            }
        }
        return null;
    }

    public Veterinario buscarVet(int id) {
        for (Animal a : animais) {
            for (Veterinario v : a.getVeterinarios()) {
                if (v.getId() == id) {
                    return v;
                }
            }
        }
        return null;
    }

    public LinkedList<SelectItem> getTipoAnimal() {
        return tipoAnimal;
    }

    public static void setAnimais(LinkedList<Animal> animais) {
        AnimalDAO.animais = animais;
    }
    
    public static void cadastrarAnimal(String tipo){
        Animal novo = new Animal(tipo);
        tipoAnimal.add(new SelectItem(novo, novo.getTipo()));
        animais.add(novo);
    }
    public static void cadastrarVet(Animal a, String nome){
        a.adicionarVeterinario(count.incrementAndGet(), nome);
    }
        
    
    
}
