package br.ufla.gac106.s2023_1.confereAi.views.compraIngressos.elementos;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class DetalhesEvento extends JPanel
{
    private JTextArea areaTexto;
    private JButton botao;

    public DetalhesEvento(String detalhes)
    {
        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        areaTexto.setText(detalhes);
        botao = new JButton("Ver atividades");
        add(areaTexto);
        add(botao);
    }

    public JButton getBotao()
    {
        return botao;
    }


}

