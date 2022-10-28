/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import dados.Categoria;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author ojaomarco
 */
@Named(value = "jogo")
@SessionScoped

public class Jogo implements Serializable {

    private Categoria catSel;
    int erros;
    int acertos = 0;
    String palavra;
    int tamanho;
    char guess;
    char[] palavraSplited;
    char[] letters;
    boolean[] showLetters;
    int letrasAcertadas;
    String nomeJogador;

    String letrasTentadas = " ";

    List<String> palavrasAcertadas = new ArrayList<>();

    boolean acertouPalavra;
    boolean perdeu;

    public String getNomeJogador() {
        return nomeJogador;
    }

    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }

    public List<String> getPalavrasAcertadas() {
        return palavrasAcertadas;
    }

    public boolean isAcertouPalavra() {
        return acertouPalavra;
    }

    public int getLetrasAcertadas() {
        return letrasAcertadas;
    }

    public char getGuess() {
        return guess;
    }

    public void setGuess(char guess) {
        this.guess = guess;
    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public int getTamanho() {
        return tamanho;
    }

    public Categoria getCatSel() {
        return catSel;
    }

    public void setCatSel(Categoria catSel) {
        this.catSel = catSel;
    }

    public int getErros() {
        return erros;
    }

    public void setErros(int erros) {
        this.erros = erros;
    }

    public int getAcertos() {
        return acertos;
    }

    public void setAcertos(int acertos) {
        this.acertos = acertos;
    }

    public String getLetrasTentadas() {
        return letrasTentadas;
    }

    public Jogo() {

    }

    public String jogar() {
        perdeu = false;
        acertouPalavra = false;
        erros = 0;
        letters = new char[10];
        showLetters = new boolean[10];
        setTrue();
        letrasAcertadas = 0;
        letrasTentadas = " ";

        int sorteio = (int) (Math.random() * 3);
        palavra = catSel.umaPalavra(sorteio);
        tamanho = palavra.length();
        palavra = palavra.toUpperCase();
        palavraSplited = palavra.toCharArray();

        esconder(tamanho);
        return "jogo";
    }

    public String esconder(int tamanho) {
        switch (tamanho) {
            case 4:
                showLetters[4] = false;

            case 5:
                showLetters[5] = false;

            case 6:
                showLetters[6] = false;

            case 7:
                showLetters[7] = false;

            case 8:
                showLetters[8] = false;

            case 9:
                showLetters[9] = false;
                break;
        }
        return null;
    }

    public boolean isPerdeu() {
        return perdeu;
    }

    public String tentativa(char c) {
        c = Character.toUpperCase(c);
        boolean acertou = false;

        if (letrasTentadas.contains(String.valueOf(c))) {
            FacesContext.getCurrentInstance().addMessage(
                    "guessForm:guessLet", new FacesMessage(
                            FacesMessage.SEVERITY_ERROR,
                            "Essa letra ja foi jogada!",
                            "Insira uma letra diferente."));
            return null;
        } else {

            for (int i = 0; i < tamanho; i++) {
                if (palavraSplited[i] == c) {
                    letters[i] = c;
                    acertou = true;
                    letrasAcertadas++;

                }
            }
            if (acertou == false) {
                erros++;
                if (erros == 6) {
                    perdeu = true;
                    return null;
                }
            }
            if (letrasAcertadas == tamanho) {
                acertouPalavra = true;
                palavrasAcertadas.add(palavra);
            }
            letrasTentadas += (c + " ");
        }
        guess = '\0';
        return null;
    }

    public char[] getLetters() {
        return letters;
    }

    public void setLetters(char[] letters) {
        this.letters = letters;
    }

    public boolean[] getShowLetters() {
        return showLetters;
    }

    public void setShowLetters(boolean[] showLetters) {
        this.showLetters = showLetters;
    }

    public void setTrue() {
        Arrays.fill(showLetters, true);
    }

    public String novoJogo() {
       palavrasAcertadas = new ArrayList<>();
       acertos = 0; 
       letrasTentadas = " ";
       nomeJogador= new String();
       
       return "index";
    }

}
