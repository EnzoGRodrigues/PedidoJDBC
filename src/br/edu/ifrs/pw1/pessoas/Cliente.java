package br.edu.ifrs.pw1.pessoas;

public class Cliente {
    private int idCliente;

    private String nome;
    private String endereco;

    public Cliente(){}

    public Cliente(String nome, String endereco){
        this.idCliente = -1;
        this.nome = nome;
        this.endereco = endereco;
    }
    public Cliente(int idCliente, String nome, String endereco){
        this.idCliente = idCliente;
        this.nome = nome;
        this.endereco = endereco;
    }

    public int getIdCliente(){return idCliente;}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(getNome()).append("\n");
        sb.append("Endereco: ").append(getEndereco()).append("\n");
        return sb.toString();
    }
}
