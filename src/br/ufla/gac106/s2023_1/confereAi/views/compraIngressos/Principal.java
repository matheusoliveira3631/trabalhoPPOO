package br.ufla.gac106.s2023_1.confereAi.views.compraIngressos;
import java.awt.CardLayout;

import javax.swing.JPanel;

public class Principal extends JanelaBase
{
    private static JPanel painelCentral;
    private static CardLayout paginas;
     

    public Principal()
    {
        super("Ingressos", "Sistema de compra de ingressos", 600, 800, true, null, true, true);
/*         painelCentral.add(new JanelaEventos());
 */    }

    @Override
    public JPanel criarPainelCentral()
    {
        paginas = new CardLayout();
        painelCentral = new JPanel(paginas);

        adicionarPaginas();
        return painelCentral;


    }

    private void adicionarPaginas()
    {
        painelCentral.add(new JanelaEventos(), "eventos");
    }
    
    public static void mudarPagina(String nomePagina)
    {
        paginas.show(painelCentral, nomePagina);
    }

    public static void mudarPagina(String nomePagina, String nomeEvento)
    {
        painelCentral.add(new JanelaCompra(nomeEvento), "compra");
        paginas.show(painelCentral, nomePagina);
    }

}