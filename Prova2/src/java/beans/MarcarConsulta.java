package beans;

import dao.AnimalDAO;
import dao.ConsultaDAO;
import dao.MesmoHorario;
import entidades.Animal;
import entidades.Consulta;
import entidades.Veterinario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

/**
 *
 * @author ojaomarco
 */
@Named(value = "marcarConsulta")
@SessionScoped
public class MarcarConsulta implements Serializable {

    @Inject
    AnimalDAO animalDAO;

    @Inject
    ConsultaDAO consultaDAO;

    private Animal animalEscolhido;
    private Animal animalNewVet;
    private Consulta consulta;
    private ArrayList<Consulta> consultas;
    private boolean editando = false;
    
    private String novoAnimal;
    private String novoVet;

    public MarcarConsulta() {
    }

    @PostConstruct
    public void init() {
        // Neste ponto, os daos já foram injetados. Poderiam ser usados.
        consulta = new Consulta();
    }

    public String confirmar() {
        if (!editando) {
            try {
                consultaDAO.incluir(consulta);
            } catch (MesmoHorario mh) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage("Esse horário não está disponivel!"));
            }
        }
        editando = false;
        tabela();
        consulta = new Consulta();

        return null;
    }

    public Animal getAnimalNewVet() {
        return animalNewVet;
    }

    public void setAnimalNewVet(Animal animalNewVet) {
        this.animalNewVet = animalNewVet;
    }

    public List<SelectItem> getAnimais() {
        return animalDAO.getTipoAnimal();
    }

    public List<SelectItem> getVets() {
        if (animalEscolhido == null) {
            return new LinkedList<>();
        }
        LinkedList<SelectItem> itens = new LinkedList<>();
        itens.add(new SelectItem(null, "Selecione o Veterinário"));
        for (Veterinario vet : animalEscolhido.getVeterinarios()) {
            itens.add(new SelectItem(vet, vet.getNome()));
        }

        return itens;
    }

    public void remover(Consulta c) {
        consultaDAO.remover(c);
        consultas.remove(c);
    }

    public String getNovoAnimal() {
        return novoAnimal;
    }

    public void setNovoAnimal(String novoAnimal) {
        this.novoAnimal = novoAnimal;
    }

    public void addAnimal() {
        animalDAO.cadastrarAnimal(novoAnimal);
        novoAnimal= new String();
    }
    
    public void addVet(){
        animalDAO.cadastrarVet(animalNewVet, novoVet);
        
        novoVet= new String();
    }

    public String getNovoVet() {
        return novoVet;
    }

    public void setNovoVet(String novoVet) {
        this.novoVet = novoVet;
    }

    public void editar(Consulta c) {
        consulta = c;
        editando = true;
    }

    public String cancelar() {
        editando = false;
        consulta = new Consulta();
        return null;
    }

    public Animal getAnimalEscolhido() {
        return animalEscolhido;
    }

    public void setAnimalEscolhido(Animal animalEscolhido) {
        this.animalEscolhido = animalEscolhido;
    }

    public String tabela() {
        consultas = consultaDAO.buscar();
        return null;
    }

    public AnimalDAO getAnimalDAO() {
        return animalDAO;
    }

    public void setAnimalDAO(AnimalDAO animalDAO) {
        this.animalDAO = animalDAO;
    }

    public ConsultaDAO getConsultaDAO() {
        return consultaDAO;
    }

    public void setConsultaDAO(ConsultaDAO consultaDAO) {
        this.consultaDAO = consultaDAO;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public ArrayList<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(ArrayList<Consulta> consultas) {
        this.consultas = consultas;
    }

}
