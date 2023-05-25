package br.edu.ifrs.pw1.view;

public enum OpcoesMenu {

    CADASTRAR_CLIENTEPF_BD(1," Cadastrar ClientePF no Banco de dados\n"),
    PESQUISAR_CLIENTEPF_CPF(2," Pesquisar ClientePF usando CPF\n"),
    EXCLUIR_CLIENTE_NOME(3, " Excluir Cliente usando nome\n"),
    LISTAR_TODOS_CLIENTES(4, " Listar todos os clientes\n"),
    SAIR(5," Sair");

    private  final int identificador;
    private final String descricao;

    private OpcoesMenu(int identificador, String descricao){
        this.identificador = identificador;
        this.descricao = descricao;
    }
    public int getIdentificador(){
        return this.identificador;
    }
    public String getDescricao(){
        return this.descricao;
    }
    @Override
    public String toString(){
        return this.getIdentificador() + "-" + this.getDescricao();
    }
}
