package br.ufla.gac106.s2023_1.confereAi.views.compraIngressos.inputs;

import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.GridLayout;


public class ComprarIngresso extends JPanel
{
    private JTextField comuns;
    private JTextField meia;
    private JTextField desconto;
    private JTextField nome;

    public ComprarIngresso()
    {
        setLayout(new GridLayout(4, 2, 10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        add(new JLabel("Nome:"));
        nome = new JTextField();
        add(nome);
        add(new JLabel("Ingressos comuns:"));
        comuns = new JTextField();
        comuns.setText("0");
        add(comuns);
        add(new JLabel("Ingressos meia:"));
        meia = new JTextField();
        meia.setText("0");
        add(meia);
        add(new JLabel("Ingressos com desconto:"));
        desconto = new JTextField();
        desconto.setText("0");
        add(desconto);        
    }

    public String getNome()
    {
        return nome.getText();
    }

    public HashMap<String, Integer> getIngressos()
    {
        HashMap<String, Integer> ingressos = new HashMap<>();
        ingressos.put("comuns", Integer.parseInt(comuns.getText()));
        ingressos.put("meia", Integer.parseInt(meia.getText()));
        ingressos.put("desconto", Integer.parseInt(desconto.getText()));
        return ingressos;
    }
}
