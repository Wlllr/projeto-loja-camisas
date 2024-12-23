package br.com.ifpb.projetos.projetoLoja;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.nio.file.Files.readAllLines;
import static java.nio.file.Path.of;


public class Catalogo {
    //cria o arraylist do obj Camisa
    private final ArrayList<Camisa> listaDeCamisas = new ArrayList<>();
    private final Scanner teclado = new Scanner(System.in);

    //construtor

    public Catalogo() throws IOException {
        List<String> cargaCamisas = readAllLines(of("dados/camisas.txt"));

        construirListaCamisas(cargaCamisas);
    }

    private void construirListaCamisas(List<String> fromCargaCamisas) {
        for ( String cadaLinha : fromCargaCamisas) {
            String[] arrayPartesCamisa = cadaLinha.split(",");

            criarCamisa(arrayPartesCamisa);
        }
    }

    private void criarCamisa(String[] fromArrayPartesCamisa) {
        listaDeCamisas.add(new Camisa(parseInt(fromArrayPartesCamisa[0]), fromArrayPartesCamisa[1], parseDouble(fromArrayPartesCamisa[2])));
    }

    //permite voce adicionar quantas camisas quiser
    public void perguntaSeDesejaCamisa(){
        boolean continuar;
        do {
            System.out.println("Deseja adicionar uma camisa a lista? (true/false)");
            continuar = teclado.nextBoolean();
            if (!continuar){
                return;
            }

            montarNovaCamisa();
        }
        while (continuar);
    }

    private void montarNovaCamisa() {
        System.out.println("Atençao, apois digitar cada informacao aperte Enter.");
        System.out.println("Para adicionar uma camisa na Lista de Camisas " +
        "informe o codigo(int), descricao(String), preco(double COM VIRGULA): ");

        criarCamisa();
    }

    private void criarCamisa() {
        int cod = teclado.nextInt();
        teclado.nextLine();
        String desc = teclado.nextLine();
        double preco = teclado.nextDouble();

        //teclado.nextInt(), teclado.nextLine(), teclado.nextDouble()
        adicionarCamisaNaLista(cod, desc, preco);
    }


    public void lacoRemocaoCamisa(){
        boolean continuar = true;
        while (continuar) {
            continuar = perguntaParaIniciar();

            if (!continuar) break;

            verificarRemocaoCamisa();
        }
    }

    private boolean perguntaParaIniciar() {
        boolean continuar;
        System.out.println("Deseja remover alguma camisa da Lista de Camisas? (true/false)");
        continuar = teclado.nextBoolean();
        return continuar;
    }

    private void verificarRemocaoCamisa() {
        System.out.println("Informe o codigo da camisa a ser removida: ");
        int remover = teclado.nextInt();

        removerCamisa(remover);
    }

    private void removerCamisa(int remover) {
        boolean resultado = removerCamisaDaLista(remover);
        //operador ternario
        System.out.println(resultado ? "Camisa removida com sucesso!" : "Camisa nao encontrada.");
    }

    public void lacoBuscarCamisa(){
        boolean continuar = true;
        while (true) {
            continuar = realizarOutraBusca();
            if (!continuar) return;

            resultadoBuscaCamisa();
        }
    }

    private boolean realizarOutraBusca() {
        boolean continuar;
        System.out.println("Deseja realizar a busca por uma camisa especifica em nosso catalogo? (true/false)");
        continuar = teclado.nextBoolean();
        return continuar;
    }

    private void resultadoBuscaCamisa() {
        int codigoBusca = codigoParaBusca();
        var encontrada = buscarCamisaNaLista(codigoBusca);

        outPutDaBusca(encontrada);
    }

    private int codigoParaBusca() {
        System.out.println("Informe o codigo da camisa que deseja buscar: ");
        int codigoBusca = teclado.nextInt();
        return codigoBusca;
    }

    private static void outPutDaBusca(Camisa encontrada) {
        if (encontrada != null){
            System.out.println("Camisa: " + encontrada);
        } else {
            System.out.println("Camisa nao encontrada.");
        }
    }

    void lacoListagemCamisa(){
        boolean continuar = true;
        while (continuar){
            continuar = respostaParaFazerListagem();

            if (outPutListagemCamisa(continuar)) return;

        }

    }

    private boolean respostaParaFazerListagem() {
        boolean continuar;
        System.out.println("Deseja visualizar a lista completa de camisas em nosso catalogo? (true/false)");
        continuar = teclado.nextBoolean();
        return continuar;
    }

    private boolean outPutListagemCamisa(boolean continuar) {
        if (!continuar){
            System.out.println("Obrigado por nos acessar!");
            return true;
        } else if (continuar) {
            imprimirCamisasDaLista();
            System.out.println("Obrigado por visitar nosso catalogo!");
            return true;
        }
        return false;
    }

    //adiciona camisa
    void adicionarCamisaNaLista(int cod, String descricao, double preco){
        //percore a lista de camisa
        for ( Camisa cadaCamisa : listaDeCamisas) {
            //compara se ja existe essa camisa
            if (verificaExistenciaCamisa(cod, cadaCamisa)) return;
        }
        //senao, ele cria o obj ccamisa
        listaDeCamisas.add(new Camisa(cod, descricao, preco));

    }

    private static boolean verificaExistenciaCamisa(int cod, Camisa cadaCamisa) {
        if ( cadaCamisa.getCod() == cod){
            return true;
        }
        return false;
    }

    //remove a camisa
    boolean removerCamisaDaLista(int cod){
        //percore a lista de camisas
        for (Camisa cadaCamisa : listaDeCamisas){
            //verifica se essa camisa existe
            if (camisaParaRemocao(cod, cadaCamisa)) return true;
        }
        return false;
    }

    private boolean camisaParaRemocao(int cod, Camisa cadaCamisa) {
        if (cadaCamisa.getCod() == cod){
            //remove a camisa da lista
            listaDeCamisas.remove(cadaCamisa);
            return true;
        }
        return false;
    }

    Camisa buscarCamisaNaLista(int cod){
        for (Camisa cadaCamisa : listaDeCamisas){
            if (cadaCamisa.getCod() == cod){
                return cadaCamisa;
            }
        }
        return null;
    }

    void imprimirCamisasDaLista(){
        for (Camisa cadaCamisa : listaDeCamisas){
            cadaCamisa.imprimirDados();
        }
    }
}
