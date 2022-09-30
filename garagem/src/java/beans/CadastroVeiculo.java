package beans;

import entidade.Marca;
import entidade.Modelo;
import entidade.Veiculo;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.model.SelectItem;

@Named(value = "cadastroVeiculo")
@SessionScoped
public class CadastroVeiculo implements Serializable {

    private ArrayList<Veiculo> veiculos, filtrados;
    private Veiculo veiculo;
    private boolean editando = false;
    private Marca marcaEscolhida, marcaFiltro;
    private int anoInicio;
    private int anoFim;

    public int getAnoInicio() {
        return anoInicio;
    }

    public void setAnoInicio(int anoInicio) {
        this.anoInicio = anoInicio;
    }

    public int getAnoFim() {
        return anoFim;
    }

    public void setAnoFim(int anoFim) {
        this.anoFim = anoFim;
    }

    public CadastroVeiculo() {

    }

    public Marca getMarcaEscolhida() {
        return marcaEscolhida;
    }

    public ArrayList<Veiculo> getFiltrados() {
        return filtrados;
    }

    public void setFiltrados(ArrayList<Veiculo> filtrados) {
        this.filtrados = filtrados;
    }

    public Marca getMarcaFiltro() {
        return marcaFiltro;
    }

    public void setMarcaFiltro(Marca marcaFiltro) {
        this.marcaFiltro = marcaFiltro;
    }

    public void setMarcaEscolhida(Marca marcaEscolhida) {
        this.marcaEscolhida = marcaEscolhida;
    }

    @PostConstruct
    public void init() {
        veiculos = new ArrayList<>();
        veiculo = new Veiculo();
    }

    public ArrayList<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(ArrayList<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public String confirmar() {
        if (!editando) {
            veiculos.add(veiculo);
        }
        editando = false;
        veiculo = new Veiculo();
        
        filtrar();
        return null;
    }

    public void remover(Veiculo veic) {
        veiculos.remove(veic);
        filtrados.remove(veic);
    }

    public void editar(Veiculo v) {
        veiculo = v;
        editando = true;
    }

    public String cancelar() {
        editando = false;
        veiculo = new Veiculo();
        return null;
    }

    public List<SelectItem> getModelosItens() {
        if (marcaEscolhida == null) {
            return new LinkedList<>();
        }
        LinkedList<SelectItem> itens = new LinkedList<>();
        itens.add(new SelectItem(null, "Selecione o modelo"));
        for (Modelo mod : marcaEscolhida.getModelos()) {
            itens.add(new SelectItem(mod, mod.getNome()));
        }
        return itens;
    }

    public String filtrar() {
        if (marcaFiltro == null) {
            filtrados = veiculos;
        } else {
            filtrados = new ArrayList<Veiculo>();
            for (Veiculo v : veiculos) {
                if (v.getModelo().getMarca().equals(marcaFiltro)) {
                    filtrados.add(v);
                }

            }
        }
        if (anoInicio > 0 && anoFim > 0) {
            ArrayList<Veiculo> filtroAnos = new ArrayList<>();
            for (Veiculo v : veiculos) {
                if (v.getAnoFabricacao() >= anoInicio && v.getAnoFabricacao() <= anoFim) {
                    filtroAnos.add(v);
                }

            }
            filtrados = filtroAnos;
        }
        return null;
    }
}
