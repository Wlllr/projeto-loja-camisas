package br.com.ifpb.projetos.projetoLoja;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Catalogo {
    //cria o arraylist do obj Camisa
    private final ArrayList<Camisa> listaCamisas = new ArrayList<>();
    private final Scanner teclado = new Scanner(System.in);

    //construtor

    Catalogo() throws IOException {
        List<String> listaCamisasTXT = Files.readAllLines(Path.of("dados/camisas.txt"));

        for ( String cadaListaCamisasTXT : listaCamisasTXT) {
            String[] partes = cadaListaCamisasTXT.split(",");

            listaCamisas.add(new Camisa(Integer.parseInt(partes[0] ), partes[1], Double.parseDouble(partes[2])));
        }
    }


    //permite voce adicionar quantas camisas quiser
    public void adicionarCamisa(){
        boolean continuar;
        do {
            System.out.println("Deseja adicionar uma camisa a lista? (true/false)");
            continuar = teclado.nextBoolean();

            if (!continuar){
                break;
            }

            System.out.println("Atençao, apois digitar cada informacao aperte Enter.");
            System.out.println("Para adicionar uma camisa na Lista de Camisas " +
            "informe o codigo(int), descricao(String), preco(double COM VIRGULA): ");
            int cod = teclado.nextInt();
            teclado.nextLine();
            String desc = teclado.nextLine();
            double preco = teclado.nextDouble();

            adicionarCamisaNaLista(cod, desc, preco);

        }
        while (continuar);
    }


    public void removerCamisa(){
        boolean continuar = true;

        while (continuar) {
            System.out.println("Deseja remover alguma camisa da Lista de Camisas? (true/false)");
            continuar = teclado.nextBoolean();

            if (!continuar){
                break;
            }

            System.out.println("Informe o codigo da camisa a ser removida: ");
            int remover = teclado.nextInt();

            boolean resultado = removerCamisaDaLista(remover);
            if (resultado) {
                System.out.println("Camisa removida com sucesso!");
            } else {
                System.out.println("Camisa nao encontrada.");
            }

        }

    }

    public void buscarCamisa(){
        boolean continuar = true;

        while (continuar) {
            System.out.println("Deseja realizar a busca por uma camisa especifica em nosso catalogo? (true/false)");
            continuar = teclado.nextBoolean();

            if (!continuar) {
                break;
            }

            System.out.println("Informe o codigo da camisa que deseja buscar: ");
            int codigoBusca = teclado.nextInt();

            Camisa encontrada = buscarCamisaNaLista(codigoBusca);

            if (encontrada != null){
                System.out.println("Camisa: " + encontrada);
            } else {
                System.out.println("Camisa nao encontrada.");
            }

        }
    }

    void listarCamisas(){
        boolean continuar = true;

        while (continuar){
            System.out.println("Deseja visualizar a lista completa de camisas em nosso catalogo? (true/false)");
            continuar = teclado.nextBoolean();

            if (!continuar){
                System.out.println("Obrigado por nos acessar!");
                break;
            } else if (continuar) {
                imprimirCamisasDaLista();
                System.out.println("Obrigado por visitar nosso catalogo!");
                break;
            }

        }

    }

    //adiciona camisa
    void adicionarCamisaNaLista(int cod, String descricao, double preco){
        //percore a lista de camisa
        for ( Camisa cadaCamisa : listaCamisas) {
            //compara se ja existe essa camisa
            if ( cadaCamisa.getCod() == cod ){
                return;
            }
        }

        //senao, ele cria o obj ccamisa
        listaCamisas.add(new Camisa(cod, descricao, preco));

    }

    //remove a camisa
    boolean removerCamisaDaLista(int cod){
        //percore a lista de camisas
        for (Camisa cadaCamisa : listaCamisas){
            //verifica se essa camisa existe
            if (cadaCamisa.getCod() == cod){
                //remove a camisa da lista
                listaCamisas.remove(cadaCamisa);
                return true;
            }
        }
        return false;
    }

    Camisa buscarCamisaNaLista(int cod){
        for (Camisa cadaCamisa : listaCamisas){
            if (cadaCamisa.getCod() == cod){
                return cadaCamisa;
            }
        }

        return null;
    }


    void imprimirCamisasDaLista(){
        for (Camisa cadaCamisa : listaCamisas){
            cadaCamisa.imprimirDados();
        }
    }
}
