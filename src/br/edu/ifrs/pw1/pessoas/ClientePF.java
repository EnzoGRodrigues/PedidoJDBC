package br.edu.ifrs.pw1.pessoas;

import br.edu.ifrs.pw1.dao.ClientePFDAO;
import br.edu.ifrs.pw1.dao.MinhaGen;

import java.util.List;


public class ClientePF extends Cliente{

    private String cpf;
    private String telefone;

    public ClientePF(){}
    public ClientePF(String nome, String endereco, String cpf, String telefone){
        super(-1,nome, endereco);
        this.cpf = cpf;
        this.telefone = telefone;
    }
    public ClientePF(int idClientePF, String nome, String endereco, String cpf, String telefone){
        super(idClientePF,nome, endereco);
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("CPF: ").append(cpf).append("\n");
        sb.append("Telefone: ").append(telefone).append("\n");
        return sb.toString();
    }

    public int cadastrarClientePF(ClientePF clientePF){
            return new ClientePFDAO().insert(clientePF);
    }
    public int deletarPorNome(String nome){
        return (new ClientePFDAO().deleteNome(nome));
    }
    public ClientePF pesquiasarPorCPF(String cpf){
        return (new ClientePFDAO().findByCPF(cpf));
    }
    public MinhaGen<ClientePF> listAll(){
        return (new ClientePFDAO().listAll());
    }
}
