package br.ufla.gac106.s2023_1.confereAi.cli;

import java.util.Scanner;

import br.ufla.gac106.s2023_1.confereAi.controllers.Graficos;

public class AdministradorGraficos
{
    private Graficos graficos;
    private Scanner scanner;

    public AdministradorGraficos()
    {
        graficos = new Graficos();
        scanner = new Scanner(System.in);
    }

    public void menu()
    {
        System.out.print("1 - Ingressos por evento\n");
        System.out.print("2 - Ingressos por atividade\n");
        System.out.print("3 - Ingressos por comprador\n");
        System.out.print("4 - Arrecadações por evento\n");
        System.out.print("5 - Arrecadações por atividade\n");
        System.out.print("6 - Arrecadações por comprador\n");
    }

    public void tratarResposta()
    {
        int opcao; 
        do{
        System.out.println("Digite o número da opção desejada: ");
        opcao = Integer.parseInt(scanner.nextLine());
        switch(opcao)
        {
            case 1:
                graficos.ingressosPorEvento();
                break;
            case 2:
                graficos.ingressosPorAtividade();
                break;
            case 3:
                graficos.ingressosPorCliente();
                break;
            case 4:
                graficos.arrecadacoesPorEvento();
                break;
            case 5:
                graficos.arrecadacoesPorAtividade();
                break;
            case 6:
                graficos.arrecadacoesPorComprador();
                break;
            case 7:
                System.exit(0);
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
        break;
    }while(opcao != 7);
    }
}
