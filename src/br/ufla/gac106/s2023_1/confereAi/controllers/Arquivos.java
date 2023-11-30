package br.ufla.gac106.s2023_1.confereAi.controllers;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class Arquivos
{
    private static Arquivos arquivos;
    private Ingressos controller;

    private Arquivos()
    {
        try{
            controller = carregar();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static Ingressos getController()
    {
        if(arquivos == null)
        {
            arquivos = new Arquivos();
        }
        return arquivos.controller;
    }

    public static void salvar(Ingressos obj) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("dados.ser"))) {
            oos.writeObject(obj);
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void salvar()
    {
        salvar(arquivos.controller);
    }

    public static Ingressos carregar() throws ClassNotFoundException{
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("dados.ser"))) {
            Ingressos obj = (Ingressos) ois.readObject();
            return obj;
        }catch(IOException e){
            return new Ingressos();
        
    }
    }

    public static void gerarPdf(ArrayList<String> listaIngressos) 
    {
        try {
            Document document = new Document();

            PdfWriter.getInstance(document, new FileOutputStream("ingressos.pdf"));
            document.open();

            for (String item : listaIngressos) {
                document.newPage(); 
                document.add(new Paragraph(item)); 
            }

            document.close();
            System.out.println("PDF generation completed.");
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}