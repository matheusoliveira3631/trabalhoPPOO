package br.ufla.gac106.s2023_1.confereAi.models;

public class Palestra extends Atividade
{
    public Palestra(String id, Local local, Evento conferencia, String data)
    {
        super(id, local, conferencia, data);
        this.precoIngresso = 50;
        this.maxIngressos=150;
        this.tipo="Palestra";
    }

    

}