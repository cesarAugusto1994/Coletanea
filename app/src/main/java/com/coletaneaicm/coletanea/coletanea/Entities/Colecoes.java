package com.coletaneaicm.coletanea.coletanea.Entities;

/**
 * Created by cesar on 26/09/17.
 */
public class Colecoes {

    private Integer id;

    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public String toString() {
        return this.getNome();
    }

}
