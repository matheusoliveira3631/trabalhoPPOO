package br.ufla.gac106.s2023_1.confereAi.views.relatorios;

public class Contabilizador implements ContabilizadorIngressos
{
    private String nome;
    private Integer qtdIngressos;
    private Double valorTotal;

    public Contabilizador(String nome, Integer qtdIngressos, Double valorTotal)
    {
        this.nome = nome;
        this.qtdIngressos = qtdIngressos;
        this.valorTotal = valorTotal;
    }

    @Override
    public String identificador()
    {
        return nome;
    }

    @Override
    public int quantidadeIngressos()
    {
        return qtdIngressos;
    }

    @Override
    public double valorTotal()
    {
        return valorTotal;
    }
}