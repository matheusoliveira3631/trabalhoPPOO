package br.ufla.gac106.s2023_1.confereAi.views.compraIngressos.elementos;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.GridLayout;

public class ElementoEvento extends JPanel
{
    private JLabel nome;
    private JButton detalhes;

    public ElementoEvento(String nome)
    {
        this.nome = new JLabel(nome);
        this.detalhes = new JButton("Detalhes");
        setLayout(new GridLayout(1, 2, 15, 5));
        add(this.nome);
        add(this.detalhes);
    }

    public JButton getBotao()
    {
        return this.detalhes;
    }

}