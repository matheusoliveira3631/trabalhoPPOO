package br.ufla.gac106.s2023_1.confereAi.models;

public class Workshop extends Atividade
{
    public Workshop(String id, Local local, Evento conferencia, String data)
    {
        super(id, local, conferencia, data);
        this.precoIngresso=100;
        this.maxIngressos=50;
        this.tipo="Workshop";
    }


   
}