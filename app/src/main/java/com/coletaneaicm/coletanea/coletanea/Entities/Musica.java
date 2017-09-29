package com.coletaneaicm.coletanea.coletanea.Entities;

import java.io.Serializable;

/**
 * Created by cesar on 28/09/17.
 */
public class Musica implements Serializable {

    private Integer id;

    private String nome;

    private String letra;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public String toString() {
        return this.getNome();
    }
}
