package br.ufla.gac106.s2023_1.confereAi.models;

import java.io.Serializable;

public class Evento implements Serializable
{
    private String nome;
    private String tema;
    private int nPalestrantes;
    private int duracao;

    public Evento(String nome, String tema, int nPalestrantes, int duracao)
    {
        this.nome = nome;
        this.tema = tema;
        this.nPalestrantes = nPalestrantes;
        this.duracao = duracao;
    }

    public String getNome()
    {
        return nome;
    }

    public String getTema()
    {
        return tema;
    }

    public int getNPalestrantes()
    {
        return nPalestrantes;
    }

    public int getDuracao()
    {
        return duracao;
    }
}