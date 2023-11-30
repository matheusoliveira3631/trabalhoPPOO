package br.ufla.gac106.s2023_1.confereAi.cli;
import java.util.Scanner;

import br.ufla.gac106.s2023_1.confereAi.controllers.*;


public class Administrador {
    private Scanner scanner;
    private Ingressos controller;
    private AdministradorGraficos graficos;

    public Administrador() {
        scanner = new Scanner(System.in);
        controller = Arquivos.getController();
        graficos = new AdministradorGraficos();
    }

    public void iniciar()
    {
        do{
            menu();
            tratarResposta();
        }while(true);
    }


    private void tratarResposta()
    {
        int opcao; 
        do{
        System.out.println("Digite o número da opção desejada: ");
        opcao = Integer.parseInt(scanner.nextLine());
        switch(opcao)
        {
            case 1:
                cadastrarEvento();
                break;
            case 2:
                removerEvento();
                break;
            case 3:
                listarEventos();
                break;
            case 4:
                cadastrarAtividade();
                break;
            case 5:
                removerAtividade();
                break;
            case 6:
                listarAtividades();
                break;
            case 7:
                cadastrarLocal();
                break;
            case 8:
                removerLocal();
                break;
            case 9:
                listarLocais();
                break;
            case 10:
                detalharEvento();
                break;
            case 11:
                detalharAtividade();
                break;
            case 12:
                detalharLocal();
                break;
            case 13:
                salvarDados();
                break;
            case 14:
                graficos.menu();
                graficos.tratarResposta();
                break;
            case 15:
                System.exit(0);
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
        break;
    }while(opcao != 14);
    }

    private void menu()
    {
        System.out.println("1 - Cadastrar evento");
        System.out.println("2 - Remover evento");
        System.out.println("3 - Listar eventos");
        System.out.println("4 - Cadastrar atividade");
        System.out.println("5 - Remover atividade");
        System.out.println("6 - Listar atividades");
        System.out.println("7 - Cadastrar local");
        System.out.println("8 - Remover local");
        System.out.println("9 - Listar locais");
        System.out.println("10 - Detalhar evento");
        System.out.println("11 - Detalhar atividade");
        System.out.println("12 - Detalhar local");
        System.out.println("13 - Salvar");
        System.out.println("14 - Gráficos");
        System.out.println("15 - Sair");
    }


    private void cadastrarEvento() {
        System.out.print("Nome do evento: ");
        String nome = scanner.nextLine();
        System.out.print("Tema do evento: ");
        String tema = scanner.nextLine();
        System.out.print("Número de palestrantes: ");
        int nPalestrantes = Integer.parseInt(scanner.nextLine());
        System.out.print("Duração do evento (minutos): ");
        int duracao = Integer.parseInt(scanner.nextLine());

        controller.addEvento(nome, tema, nPalestrantes, duracao);
    }

    private void removerEvento() {
        System.out.println("Nome do evento: ");
        String nome = scanner.nextLine();
        controller.removeEvento(nome);
    }

    private void listarEventos()
    {
        String lista = "";
        for(String evento : controller.listarEventos())
        {
            lista += evento+"\n";
        }

        System.out.println(lista);
    }

    private void detalharEvento()
    {
        System.out.print("Nome do evento: ");
        String nome = scanner.nextLine();
        String detalhes=controller.getEvento(nome);
        if(detalhes!=null)
        {
            System.out.println(detalhes);
        }
        else
        {
            System.out.println("Evento não encontrado!");
        }
    }

    private void cadastrarAtividade()
    {
        
        System.out.print("Nome da atividade: ");
        String id = scanner.nextLine();
        System.out.print("Data da atividade: ");
        String data = scanner.nextLine();
        System.out.print("Local da atividade");
        String nomeLocal = scanner.nextLine();
        System.out.print("Conferência correspondente: ");
        String nomeEvento = scanner.nextLine();
        System.out.println("Palestra ou workshop? (P/W)");
        String tipo = scanner.nextLine();
        if(tipo.equals("W"))
        {
            controller.addWorkshop(id, nomeLocal, nomeEvento, data);
        }
        else if(tipo.equals("P"))
        {
            controller.addPalestra(id, nomeLocal, nomeEvento, data);
        }
        else
        {
            System.out.println("Tipo inválido!");
        }

    }

    private void removerAtividade()
    {
        System.out.print("Nome da atividade: ");
        String id = scanner.nextLine();
        controller.removeAtividade(id);
    }

    private void listarAtividades()
    {
        System.out.print("Nome da conferência: ");
        String nomeEvento = scanner.nextLine();
        System.out.println(controller.listarAtividades(nomeEvento));
    }

    private void detalharAtividade()
    {
        System.out.print("Nome da conferência: ");
        String nomeEvento = scanner.nextLine();
        System.out.print("Nome da atividade: ");
        String id = scanner.nextLine();
        System.out.println(controller.detalharAtividade(nomeEvento, id));
    }

    private void cadastrarLocal()
    {
        System.out.print("Nome do local: ");
        String nome = scanner.nextLine();
        System.out.print("Cidade: ");
        String cidade = scanner.nextLine();
        controller.addLocal(nome, cidade);
    }

    private void removerLocal()
    {
        System.out.print("Nome do local: ");
        String nome = scanner.nextLine();
        controller.removeLocal(nome);
    }

    private void listarLocais()
    {
        System.out.println(controller.listarLocais());

    }

    private void detalharLocal()
    {
        System.out.print("Nome do local: ");
        String nome = scanner.nextLine();
        System.out.println(controller.detalharLocal(nome));
    }
    
    private void salvarDados()
    {
        Arquivos.salvar(controller);
    }


}