package br.com.ifpb.projetos.projetoLoja;

public class Camisa {
    private int cod;
    private String descricao;
    private double preco;

    public Camisa(int cod, String descricao, double preco) {
        this.cod = cod;
        this.descricao = descricao;
        this.preco = preco;
    }

    public int getCod(){
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    void imprimirDados(){
        System.out.println(
                " Codigo: " + cod +
                " Descricao: " + descricao +
                " Preço: " + preco);
    }
}
