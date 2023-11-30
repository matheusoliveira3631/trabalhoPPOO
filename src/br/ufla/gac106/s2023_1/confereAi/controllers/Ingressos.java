package br.ufla.gac106.s2023_1.confereAi.controllers;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;


import br.ufla.gac106.s2023_1.confereAi.models.*;
import br.ufla.gac106.s2023_1.confereAi.models.ingressos.IngressoDesconto;
import br.ufla.gac106.s2023_1.confereAi.models.ingressos.IngressoMeia;
import br.ufla.gac106.s2023_1.confereAi.models.ingressos.IngressoNormal;


public class Ingressos implements Serializable
{
    private HashMap<Evento, ArrayList<Atividade>> eventos;
    private ArrayList<Local> locais; 
    private HashMap<String, Integer> ingressosVendidos;
    private HashMap<String, Double> valorPorComprador;

    public Ingressos()
    {
        this.eventos = new HashMap<Evento, ArrayList<Atividade>>();
        this.locais = new ArrayList<Local>();
        this.ingressosVendidos = new HashMap<String, Integer>();
        this.valorPorComprador = new HashMap<String, Double>();
    }

    public void addEvento(String nome, String tema, int nPalestrantes, int duracao)
    {
        if(buscaEvento(nome) == null)
        {
            Evento evento = new Evento(nome, tema, nPalestrantes, duracao);
            eventos.put(evento, new ArrayList<Atividade>());
        }else
        {
            throw new IllegalArgumentException("Evento já cadastrado");
        }
        
    }
    
    private Evento buscaEvento(String nome)
    {
        for(Evento evento : eventos.keySet())
        {
            if(evento.getNome().equals(nome))
            {
                return evento;
            }
        }
        return null;
    }

    public String getEvento(String nome)
    {
        String detalhes="";
        Evento evento = buscaEvento(nome);
        if(evento!=null)
        {
            detalhes+="Nome do evento: "+evento.getNome()+"\n";
            detalhes+="Tema: "+evento.getTema()+"\n";
            detalhes+="Número de palestrantes: "+evento.getNPalestrantes()+"\n";
            detalhes+="Duração: "+evento.getDuracao()+"\n";
            detalhes+="Atividades cadastradas: \n";
            for(Atividade atividade : eventos.get(evento))
            {
                detalhes+=atividade.getId()+"\n";
            }
            return detalhes;
        }else
        {
            throw new IllegalArgumentException("Evento não cadastrado");
        }
    }

    public void removeEvento(String nome)
    {
        Evento evento = buscaEvento(nome);
        if(evento!=null)
        {
            eventos.remove(evento);
        }else
        {
            throw new IllegalArgumentException("Evento não cadastrado");
        }    
    }

    public void addLocal(String nome, String cidade)
    {
        Local local = new Local(nome, cidade);
        locais.add(local);
    } 

    private Local buscaLocal(String nome)
    {
        for(Local local : locais)
        {
            if(local.getNome().equals(nome))
            {
                return local;
            }
        }
        return null;
    }

    public void removeLocal(String nome)
    {
        Local local = buscaLocal(nome);
        if(local!=null)
        {
            locais.remove(local);
        }else
        {
            throw new IllegalArgumentException("Local não cadastrado");
        }    
    }

    public void addPalestra(String id, String local, String evento, String data)
    {
        Local localPalestra = buscaLocal(local);
        Evento eventoPalestra = buscaEvento(evento);
        if(localPalestra!=null && eventoPalestra!=null)
        {
            Palestra palestra = new Palestra(id, localPalestra, eventoPalestra, data);
            eventos.get(eventoPalestra).add(palestra);
        }else
        {
            throw new IllegalArgumentException("Local ou evento não cadastrado");
        }
    }

    public void addWorkshop(String id, String local, String evento, String data)
    {
        Local localWorkshop = buscaLocal(local);
        Evento eventoWorkshop = buscaEvento(evento);
        if(localWorkshop!=null && eventoWorkshop!=null)
        {
            Workshop workshop = new Workshop(id, localWorkshop, eventoWorkshop, data);
            eventos.get(eventoWorkshop).add(workshop);
        }else
        {
            throw new IllegalArgumentException("Local ou evento não cadastrado");
        }
    }

    public void removeAtividade(String id)
    {
        for(Evento evento : eventos.keySet())
        {
            for(Atividade atividade : eventos.get(evento))
            {
                if(atividade.getId().equals(id))
                {
                    eventos.get(evento).remove(atividade);
                    return;
                }
            }
        }
        throw new IllegalArgumentException("Atividade não cadastrada");
    }

    public boolean venderIngressos(String id, int qtd)
    {
        for(Evento evento : eventos.keySet())
        {
            for(Atividade atividade : eventos.get(evento))
            {
                if(atividade.getId().equals(id))
                {
                    if(atividade.getIngressosVendidos()+qtd <= atividade.getMaxIngressos())
                    {
                        atividade.venderIngressos(qtd);
                        return true;
                    }else
                    {
                        return false;
                    }
                }
            }
        }
        throw new IllegalArgumentException("Atividade não cadastrada");
    }

    public ArrayList<String> listarEventos()
    {
        ArrayList<String> lista = new ArrayList<String>();
        for(Evento evento : eventos.keySet())
        {
            lista.add(evento.getNome());
        }
        return lista;
    }

    public String listarLocais()
    {
        String lista="";
        for(Local local : locais)
        {
            lista += local.getNome() + "\n";
        }
        return lista;
    }

    public ArrayList<String> listarAtividades(String nome)
    {
        ArrayList<String> lista = new ArrayList<String>();
        Evento evento = buscaEvento(nome);
        if(evento!=null)
        {
            for(Atividade atividade : eventos.get(evento))
            {
                lista.add(atividade.getId());
            }
        }else
        {
            throw new IllegalArgumentException("Evento não cadastrado");
        }
        return lista;
    }
    
    public String detalharAtividade(String nomeEvento, String id)
    {
        Evento evento = buscaEvento(nomeEvento);
        if(evento!=null)
        {
            for(Atividade atividade : eventos.get(evento))
            {
                if(atividade.getId().equals(id))
                {
                    return atividade.detalhar();
                }
            }
            throw new IllegalArgumentException("Atividade não cadastrada");
    }
        throw new IllegalArgumentException("Evento não cadastrado");
}

    private Atividade buscaAtividade(String nome)
    {
        for(Evento evento : eventos.keySet())
        {
            for(Atividade atividade : eventos.get(evento))
            {
                if(atividade.getId().equals(nome))
                {
                    return atividade;
                }
            }
        }
        return null;
    }

    public String detalharLocal(String nome)
    {
        String detalhes="";
        Local local = buscaLocal(nome);
        if(local!=null)
        {
            detalhes+="Nome do local: "+local.getNome()+"\n";
            detalhes+="Cidade: "+local.getCidade()+"\n";
            detalhes+="Atividades: \n";
            for(Evento evento : eventos.keySet())
            {
                for(Atividade atividade : eventos.get(evento))
                {
                    if(atividade.getLocal().equals(nome))
                    {
                        detalhes+=atividade.getId()+"\n";
                    }
                }
            }
            return detalhes;
        }else
        {
            throw new IllegalArgumentException("Local não cadastrado");
        }
    }

    public double calcularIngressos(HashMap<String, Integer> ingressos, String nomeAtividade)
    {
        int valorBase = buscaAtividade(nomeAtividade).getPreco();
        double comuns = new IngressoNormal().calcularValor(valorBase, ingressos.get("comuns"));
        double meia = new IngressoMeia().calcularValor(valorBase, ingressos.get("meia"));
        double desconto = new IngressoDesconto().calcularValor(valorBase, ingressos.get("desconto"));
        return comuns+meia+desconto;
    }

    public void gerarPdf(HashMap<String, Integer> quantidadeIngressos, String nomeAtividade, String nomeCliente)
    {
        Atividade atividade = buscaAtividade(nomeAtividade);
        int valorBase = atividade.getPreco();
        ArrayList<String> infoIngressos = new ArrayList<String>();
        int contadorIngressos=1;
        double valorTotal = 0;
        for(int i=0; i<quantidadeIngressos.get("comuns"); i++)
        {
            String info="";
            IngressoNormal ingresso = new IngressoNormal();
            double valor =ingresso.calcularValor(valorBase, 1);
            info+="Ingresso Nº"+contadorIngressos+"\n";
            info+=atividade.getConferencia().getNome()+"\n";
            info+=atividade.getTipo()+"\n";
            info+=atividade.getId()+"\n";
            info+=atividade.getLocal()+"\n";
            info+=atividade.getData()+"\n";
            info+=nomeCliente+"\n";
            info+="Ingresso comum"+"\n";
            info+="Valor: R$" + valor +"\n";
            infoIngressos.add(info);  
            valorTotal+=valor;
            contadorIngressos++;
            

        }
        for(int i=0; i<quantidadeIngressos.get("meia"); i++)
        {
            String info="";
            IngressoMeia ingresso =new IngressoMeia();
            double valor =ingresso.calcularValor(valorBase, 1);
            info+="Ingresso Nº"+contadorIngressos+"\n";
            info+=atividade.getConferencia().getNome()+"\n";
            info+=atividade.getTipo()+"\n";
            info+=atividade.getId()+"\n";
            info+=atividade.getLocal()+"\n";
            info+=atividade.getData()+"\n";
            info+=nomeCliente+"\n";
            info+="Ingresso meia"+"\n";
            info+="Valor: R$" + valor +"\n"; 
            infoIngressos.add(info); 
            valorTotal+=valor;
            contadorIngressos++;

        }

        for(int i=0; i<quantidadeIngressos.get("desconto"); i++)
        {
            String info="";
            IngressoDesconto ingresso = new IngressoDesconto();
            double valor = ingresso.calcularValor(valorBase, 1);
            info+="Ingresso Nº"+contadorIngressos+"\n";
            info+=atividade.getConferencia().getNome()+"\n";
            info+=atividade.getTipo()+"\n";
            info+=atividade.getId()+"\n";
            info+=atividade.getLocal()+"\n";
            info+=atividade.getData()+"\n";
            info+=nomeCliente+"\n";
            info+="Ingresso com desconto"+"\n";
            info+="Valor: R$" +valor +"\n"; 
            infoIngressos.add(info); 
            valorTotal+=valor;

        }
        if(ingressosVendidos.containsKey(nomeCliente))
        {
            ingressosVendidos.put(nomeCliente, ingressosVendidos.get(nomeCliente)+contadorIngressos);
        }else
        {
            ingressosVendidos.put(nomeCliente, contadorIngressos);
        }   
        if(valorPorComprador.containsKey(nomeCliente))
        {
            valorPorComprador.put(nomeCliente, valorPorComprador.get(nomeCliente)+valorTotal);
        }else
        {
            valorPorComprador.put(nomeCliente, valorTotal);
        }

        Arquivos.gerarPdf(infoIngressos);
    }

    public HashMap<String, Integer> ingressosPorEvento()
    {
        HashMap<String, Integer> ingressosPorEvento = new HashMap<String, Integer>();
        for(Evento evento : eventos.keySet())
        {
            int ingressosVendidos=0;
            for(Atividade atividade : eventos.get(evento))
            {
                ingressosVendidos+=atividade.getIngressosVendidos();
            }
            ingressosPorEvento.put(evento.getNome(), ingressosVendidos);
        }
        return ingressosPorEvento;
    }

    public HashMap<String, Integer> ingressosPorCliente()
    {
        return ingressosVendidos;
    }

    public HashMap<String, Integer> ingressosPorAtividade()
    {
        HashMap<String, Integer> ingressosPorAtividade = new HashMap<String, Integer>();
        //arrecadações de todas as atividades
        for(Evento evento : eventos.keySet())
        {
            for(Atividade atividade : eventos.get(evento))
            {
                ingressosPorAtividade.put(atividade.getId(), atividade.getIngressosVendidos());
            }
        }
        return ingressosPorAtividade;
    }

    public HashMap<String, Double>arrecadacoesPorAtividade()
    {
        HashMap<String, Double> arrecadacoesPorAtividade = new HashMap<String, Double>();
        for(Evento evento : eventos.keySet())
        {
            for(Atividade atividade : eventos.get(evento))
            {
                arrecadacoesPorAtividade.put(atividade.getId(), atividade.getTotalArrecadado());
            }
        }
        return arrecadacoesPorAtividade;
    }

    public HashMap<String, Double> arrecadacoesPorEvento()
    {
        HashMap<String, Double> arrecadacoesPorEvento = new HashMap<String, Double>();
        for(Evento evento : eventos.keySet())
        {
            double arrecadacao=0;
            for(Atividade atividade : eventos.get(evento))
            {
                arrecadacao+=atividade.getTotalArrecadado();
            }
            arrecadacoesPorEvento.put(evento.getNome(), arrecadacao);
        }
        return arrecadacoesPorEvento;
    }

    public HashMap<String, Double> arrecadacoesPorComprador()
    {
        return valorPorComprador;
    }
    

    
}