package br.ufla.gac106.s2023_1.confereAi.views.compraIngressos;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

import br.ufla.gac106.s2023_1.confereAi.controllers.Arquivos;
import br.ufla.gac106.s2023_1.confereAi.controllers.Ingressos;
import br.ufla.gac106.s2023_1.confereAi.views.compraIngressos.elementos.DetalhesEvento;
import br.ufla.gac106.s2023_1.confereAi.views.compraIngressos.elementos.ElementoEvento;

public class JanelaEventos extends JPanel
{
    private Ingressos controller;
    private JPanel eventos;


    public JanelaEventos()
    {
        eventos = new JPanel();
        controller = Arquivos.getController();
        listarEventos();

    }


    private void listarEventos()
    {
        ArrayList<String> listaEventos = controller.listarEventos();
        if(listaEventos.size() == 0)
        {
            eventos.add(new JLabel("Nenhum evento cadastrado"));
        }else
        {
        eventos.setLayout(new GridLayout(0, 1, 5, 5));
        for(String evento : listaEventos)
        {
            ElementoEvento elemento = new ElementoEvento(evento);
            JButton botao = elemento.getBotao();
            botao.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {
                    String nomeEvento = evento;
                    DetalhesEvento detalhes = new DetalhesEvento(controller.getEvento(nomeEvento));
                    JButton botao = detalhes.getBotao();
                    botao.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e)
                        {
                            Principal.mudarPagina("compra", nomeEvento);
                        }
                    });
                    JOptionPane.showMessageDialog(null, detalhes, nomeEvento, JOptionPane.INFORMATION_MESSAGE);
                }
            });
            eventos.add(elemento);
        }
        }
        add(eventos, BorderLayout.CENTER);
        
    }
}