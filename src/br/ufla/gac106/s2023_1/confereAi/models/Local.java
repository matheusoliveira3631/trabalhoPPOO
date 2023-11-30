package br.ufla.gac106.s2023_1.confereAi.models;

import java.io.Serializable;


public class Local implements Serializable
{
    private String nome;
    private String cidade;
    
    public Local(String nome, String cidade)
    {
        this.nome = nome;
        this.cidade = cidade;
    }

    public String getNome()
    {
        return nome;
    }

    public String getCidade()
    {
        return cidade;
    }
}