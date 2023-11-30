package br.ufla.gac106.s2023_1.confereAi.models;

import java.io.Serializable;
/*
Apresentação na conferência: identificação da apresentação, 
conferência, tipo de apresentação, centro de conferência, dia.
*/

public class Atividade implements Serializable
{
    private String id;
    private Local local;
    private Evento conferencia;
    private String data;
    protected int precoIngresso;
    protected int maxIngressos;
    protected String tipo;
    private int ingressosVendidos;
    private double totalArrecadado;
    


    public Atividade(String id, Local local, Evento conferencia, String data)
    {
        this.id = id;
        this.local = local;
        this.conferencia = conferencia;
        this.data = data;
        this.ingressosVendidos=0;
        this.totalArrecadado=0;
    }

    public String getId()
    {
        return id;
    }   

    public String getLocal()
    {
        return local.getNome();
    }

    public Evento getConferencia()
    {
        return conferencia;
    }

    public String getData()
    {
        return data;
    }

    public int getIngressosVendidos()
    {
        return ingressosVendidos;
    }

    public void venderIngressos(int qtd)
    {
        ingressosVendidos += qtd;
    }

    public int getMaxIngressos()
    {
        return maxIngressos;
    }

    public int getPreco()
    {
        return precoIngresso;
    }

    public String getTipo()
    {
        return tipo;
    }

    public String detalhar()
    {
        String detalhes="";
        detalhes+="ID: "+id+"\n";
        detalhes+="Local: "+local.getNome()+"\n";
        detalhes+="Conferência: "+conferencia.getNome()+"\n";
        detalhes+="Data: "+data+"\n";
        detalhes+="Preço: "+precoIngresso+"\n";
        detalhes+="Ingressos vendidos: "+ingressosVendidos+"\n";
        detalhes+="Ingressos disponíveis: "+(maxIngressos-ingressosVendidos)+"\n";
        return detalhes;
    }

    public double getTotalArrecadado()
    {
        return totalArrecadado;
    }

    public void setTotalArrecadado(int totalArrecadado)
    {
        this.totalArrecadado += totalArrecadado;
    }

}
