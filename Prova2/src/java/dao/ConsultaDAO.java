package dao;

import entidades.Consulta;
import java.io.Serializable;
import java.util.ArrayList;

public class ConsultaDAO implements Serializable {

    private static ArrayList<Consulta> consultas;

    public ConsultaDAO() {
        consultas = new ArrayList<>();
    }

    public void incluir(Consulta v) throws MesmoHorario {
        for (Consulta c : consultas) {
            if (c.equals(v)) {
                if (c.getVet().getId() == v.getVet().getId()) {
                    throw new MesmoHorario();
                }
            }
        }
        consultas.add(v);
    }

    public ArrayList<Consulta> buscar() {
        ArrayList<Consulta> tabConsultas = new ArrayList<>();
        for (Consulta c : consultas) {

            tabConsultas.add(c);
        }
        return tabConsultas;
    }

    public void remover(Consulta v) {
        consultas.remove(v);
    }

    public static ArrayList<Consulta> getConsultas() {
        return consultas;
    }

    public static void setConsultas(ArrayList<Consulta> consultas) {
        ConsultaDAO.consultas = consultas;
    }
    
}
