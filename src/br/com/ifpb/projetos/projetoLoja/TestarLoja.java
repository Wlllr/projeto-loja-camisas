package br.com.ifpb.projetos.projetoLoja;

import java.io.IOException;

public class TestarLoja {
    public static void main(String[] args) throws IOException {
        Catalogo catalogo = new Catalogo();

        catalogo.adicionarCamisa();
        catalogo.removerCamisa();
        catalogo.buscarCamisa();
        catalogo.listarCamisas();
    }
}
