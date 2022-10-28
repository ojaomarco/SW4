/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import dao.AnimalDAO;
import dao.ConsultaDAO;
import entidades.Animal;
import entidades.Consulta;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

/**
 *
 * @author ojaomarco
 */
@Named(value = "animalBean")
@ApplicationScoped
public class AnimalBean {

    AnimalDAO animalDAO;
    ConsultaDAO consultaDAO;

    @Produces
    public ConsultaDAO getConsultaDAO() {
        if (consultaDAO == null) {
            consultaDAO = new ConsultaDAO();
        }
        return consultaDAO;
    }

    public AnimalBean() {
    }

    @Produces
    public AnimalDAO getAnimalDAO() {
        if (animalDAO == null) {
            animalDAO = new AnimalDAO();
        }
        return animalDAO;
    }

    @PostConstruct
    public void iniciar() {
        try {
            System.out.println("inicio");
            FileInputStream fis = new FileInputStream("arq.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            LinkedList<Animal> animais = (LinkedList<Animal>) ois.readObject();
            
            AnimalDAO.setAnimais(animais);
            
        } catch (Exception ex) {
        }
    }

    @PreDestroy
    public void finalizar() {
        try {
            System.out.println("fim");
            FileOutputStream fos = new FileOutputStream("arq.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(animalDAO.getAnimais());
            oos.flush();
            fos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
