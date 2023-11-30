package br.ufla.gac106.s2023_1.confereAi.views.compraIngressos;

import java.util.HashMap;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;

import br.ufla.gac106.s2023_1.confereAi.controllers.Ingressos;
import br.ufla.gac106.s2023_1.confereAi.views.compraIngressos.inputs.ComprarIngresso;
import br.ufla.gac106.s2023_1.confereAi.controllers.Arquivos;


import javax.swing.JOptionPane;

import java.awt.GridLayout;

public class JanelaCompra extends JPanel
{
    private String nomeEvento;
    private Ingressos controller;

    public JanelaCompra(String nome)
    {
        nomeEvento = nome;
        controller=Arquivos.getController();
        listarAtividades();

    }

    private void listarAtividades()
    {
        for(String nome : controller.listarAtividades(nomeEvento))
        {
            JPanel painel = new JPanel();
            painel.setLayout(new GridLayout(1, 2));
            String detalhe = controller.detalharAtividade(nomeEvento, nome);
            JTextArea texto = new JTextArea(detalhe);
            texto.setEditable(false);
            painel.add(texto);
            JButton botao = new JButton("Comprar");
            botao.addActionListener(e -> {
                ComprarIngresso comprarIngresso = new ComprarIngresso();
                int opcao = JOptionPane.showConfirmDialog(
                        null,
                        comprarIngresso,
                        nomeEvento,
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.INFORMATION_MESSAGE
                );

                if (opcao == JOptionPane.OK_OPTION)
                {
                    HashMap<String, Integer> ingressos = comprarIngresso.getIngressos();
                    int totalIngressos = ingressos.get("comuns") + ingressos.get("meia") + ingressos.get("desconto");
                    double valorTotal = controller.calcularIngressos(ingressos, nome);
                    opcao = JOptionPane.showConfirmDialog(
                            null,
                            "Valor total: R$" + valorTotal,
                            "Confirmar compra",
                            JOptionPane.OK_CANCEL_OPTION,
                            JOptionPane.INFORMATION_MESSAGE
                    );
                    if(opcao == JOptionPane.OK_OPTION)
                    {
                        if(controller.venderIngressos(nome, totalIngressos))
                        {
                            JOptionPane.showMessageDialog(null, "Ingressos comprados com sucesso!");
                            controller.gerarPdf(ingressos, nome, comprarIngresso.getNome());
                        }else
                        {
                            JOptionPane.showMessageDialog(null, "Você ultrapassou o limite de ingressos disponíveis!");
                        }
                    }
                    

                }
            });
            painel.add(botao);
            add(painel);
        }
        
    }
}