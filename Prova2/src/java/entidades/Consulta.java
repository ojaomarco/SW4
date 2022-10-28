/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Consulta implements Serializable {

    private Veterinario vet;
    private String tutor;
    private String nomeAml;
    private String motivo;
    private String telefone;
    private Date data;

    public Consulta(Veterinario vet, String tutor, String nomeAml, String motivo, String telefone, Date data) {

        this.vet = vet;
        this.tutor = tutor;
        this.nomeAml = nomeAml;
        this.motivo = motivo;
        this.telefone = telefone;
        this.data = data;
    }

    public Consulta() {

    }

    public Veterinario getVet() {
        return vet;
    }

    public void setVet(Veterinario vet) {
        this.vet = vet;
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public String getNomeAml() {
        return nomeAml;
    }

    public void setNomeAml(String nomeAml) {
        this.nomeAml = nomeAml;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getData() {

        return data;
    }

    public void setData(Date data) throws ParseException {
        this.data = data;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.data);
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
        final Consulta other = (Consulta) obj;
        return Objects.equals(this.data, other.data);
    }

}
