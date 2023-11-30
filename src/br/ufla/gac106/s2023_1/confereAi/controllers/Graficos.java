package br.ufla.gac106.s2023_1.confereAi.controllers;

import java.util.ArrayList;
import java.util.List;

import br.ufla.gac106.s2023_1.confereAi.views.relatorios.Contabilizador;
import br.ufla.gac106.s2023_1.confereAi.views.relatorios.ContabilizadorIngressos;
import br.ufla.gac106.s2023_1.confereAi.views.relatorios.GraficoIngressos;

public class Graficos 
{
    private Ingressos controller;
    private GraficoIngressos graficoIngressos;


    public Graficos()
    {
        this.controller = Arquivos.getController();
        graficoIngressos = new GraficoIngressos();
    }

    public void ingressosPorEvento()
    {
        List<ContabilizadorIngressos> contabilizadores = new ArrayList<>();
        for(String evento : controller.ingressosPorEvento().keySet())
        {
            contabilizadores.add(new Contabilizador(evento, controller.ingressosPorEvento().get(evento), controller.arrecadacoesPorEvento().get(evento)));
        }
        graficoIngressos.exibir("Ingressos por evento", contabilizadores, false);
    }

    public void ingressosPorAtividade()
    {
        List<ContabilizadorIngressos> contabilizadores = new ArrayList<>();
        for(String atividade : controller.ingressosPorAtividade().keySet())
        {
            contabilizadores.add(new Contabilizador(atividade, controller.ingressosPorAtividade().get(atividade), controller.arrecadacoesPorAtividade().get(atividade)));
        }
        graficoIngressos.exibir("Ingressos por atividade", contabilizadores, false);
    }

    public void ingressosPorCliente()
    {
        List<ContabilizadorIngressos> contabilizadores = new ArrayList<>();
        for(String cliente : controller.ingressosPorCliente().keySet())
        {
            contabilizadores.add(new Contabilizador(cliente, controller.ingressosPorCliente().get(cliente), controller.arrecadacoesPorComprador().get(cliente)));
        }
        graficoIngressos.exibir("Ingressos por cliente", contabilizadores, false);
    }

    public void arrecadacoesPorEvento()
    {
        List<ContabilizadorIngressos> contabilizadores = new ArrayList<>();
        for(String evento : controller.arrecadacoesPorEvento().keySet())
        {
            contabilizadores.add(new Contabilizador(evento, controller.ingressosPorEvento().get(evento), controller.arrecadacoesPorEvento().get(evento)));
        }
        graficoIngressos.exibir("Arrecadações por evento", contabilizadores, true);
    }

    public void arrecadacoesPorAtividade()
    {
        List<ContabilizadorIngressos> contabilizadores = new ArrayList<>();
        for(String atividade : controller.arrecadacoesPorAtividade().keySet())
        {
            contabilizadores.add(new Contabilizador(atividade, controller.ingressosPorAtividade().get(atividade), controller.arrecadacoesPorAtividade().get(atividade)));
        }
        graficoIngressos.exibir("Arrecadações por atividade", contabilizadores, true);
    }

    public void arrecadacoesPorComprador()
    {
        List<ContabilizadorIngressos> contabilizadores = new ArrayList<>();
        for(String comprador : controller.arrecadacoesPorComprador().keySet())
        {
            contabilizadores.add(new Contabilizador(comprador, controller.ingressosPorAtividade().get(comprador), controller.arrecadacoesPorComprador().get(comprador)));
        }
        graficoIngressos.exibir("Arrecadações por comprador", contabilizadores, true);
      
    }


}
