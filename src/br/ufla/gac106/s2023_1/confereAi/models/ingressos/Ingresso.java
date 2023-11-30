package br.ufla.gac106.s2023_1.confereAi.models.ingressos;

public interface Ingresso {
    
    public double calcularValor(Integer valorBase, Integer qtd);

    public double getModificador();

}
