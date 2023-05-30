package br.edu.ifrs.pw1.view;

import br.edu.ifrs.pw1.dao.MinhaGen;
import br.edu.ifrs.pw1.pessoas.ClientePF;

import java.util.Scanner;

public class Menu {
    private static final ClientePF clientepf = new ClientePF();
    private static final Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {

        while (true){
            menu();
            int op = teclado.nextInt();
            teclado.nextLine();
            switch (op){
                case 1:
                    cadastrarClienteBD();
                    break;
                case 2:
                    pesquisarClienteCPF();
                    break;
                case 3:
                    deleteClienteNome();
                    break;
                case 4:
                    listarTodos();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcao invalida");
                    break;
            }
        }
    }

    public static void menu() {
        System.out.println("--> MENU <--");
        for (OpcoesMenu opcao : OpcoesMenu.values()) {
            System.out.println(opcao);
        }
        System.out.print("\nEscolha uma opção: ");
    }
    public static void cadastrarClienteBD(){
            System.out.println("--> CADASTRO <--");
            System.out.println("Digite o seu nome: ");
            String nome = teclado.nextLine();
            System.out.println("Digite seu endereco: ");
            String endereco = teclado.nextLine();
            System.out.println("Digite seu CPF: ");
            String cpf = teclado.nextLine();
            System.out.println("Digite seu telefone: ");
            String telefone = teclado.nextLine();
            ClientePF clientePF = new ClientePF(nome, endereco, cpf, telefone);
            clientePF.cadastrarClientePF(clientePF); //chamando o método DAO da classe ClientePF
            System.out.println("ClientePF cadastrado");
    }
    public static void pesquisarClienteCPF(){
            System.out.println("--> PESQUISAR CLIENTEPF PELO CPF <--");
            System.out.println("Digite o cpf: ");
            String pesquisaCpf = teclado.next();
            ClientePF searchCliente = clientepf.pesquiasarPorCPF(pesquisaCpf); //chamando o método DAO da classe ClientePF
            if (searchCliente != null){
                System.out.println(searchCliente);
            }else {
                System.out.println("Não existe este cliente");
            }
    }
    public static void deleteClienteNome(){
            System.out.println("--> EXCLUIR CLIENTEPF PELO NOME <--");
            System.out.println("Digite o nome do cliente que deseja deletar: ");
            String deleteNome = teclado.next();
            if(clientepf.deletarPorNome(deleteNome) >= 1){
                System.out.println("Deletado");
            }else {
                System.out.println("Nao deletado");
            }; //chamando o método DAO da classe ClientePF

    }
    public static void listarTodos(){
        System.out.println("--> LISTAR TODOS <--");
        MinhaGen<ClientePF> clientePFList = clientepf.listAll();
        if(clientePFList.listAll().size() >= 1){
            for (ClientePF clientePF : clientePFList.listAll()){
                System.out.println(clientePF.toString());
            }
        }else {
            System.out.println("Sem clientes na lista");
        }
    }
}
