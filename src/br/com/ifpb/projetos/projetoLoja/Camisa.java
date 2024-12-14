package br.com.ifpb.projetos.projetoLoja;

public class Camisa {
    private int cod;
    private String descricao;
    private double preco;

    public Camisa(int cod, String desc, double preco){
        this.cod = cod;
        this.descricao = desc;
        this.preco = preco;
    }

    public int getCod(){
        return cod;
    }

    void imprimirDados(){
        System.out.println(
                " Codigo: " + cod +
                " Descricao: " + descricao +
                " Preço: " + preco);
    }
}
