package br.ufla.gac106.s2023_1.confereAi.models.ingressos;

public class IngressoNormal implements Ingresso
{
    protected double modificador;

    public IngressoNormal()
    {
        modificador = 1;
    }

    public double calcularValor(Integer valorBase, Integer qtd)
    {
        return (valorBase * modificador) * qtd;
    }

    public double getModificador()
    {
        return modificador;
    }
}