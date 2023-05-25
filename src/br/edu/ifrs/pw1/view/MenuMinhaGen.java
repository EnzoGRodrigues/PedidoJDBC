package br.edu.ifrs.pw1.view;


import br.edu.ifrs.pw1.dao.MinhaGen;
import br.edu.ifrs.pw1.pessoas.ClientePF;

import java.util.Scanner;

import static br.edu.ifrs.pw1.view.Menu.menu;

public class MenuMinhaGen {
    private static final MinhaGen<ClientePF> minhaGenCPF = new MinhaGen<>();
    private static final Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {

        while (true){
            switch (menu()){
                case 1:
                    cadastro();
                    break;
                case 2:
                    pesquisar();
                    break;
                case 3:
                    excluir();
                    break;
                case 4:
                    listar();
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

    public static int menu(){
        StringBuilder stringBuilder = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        for(OpcoesMenu opcoesMenu : OpcoesMenu.values())
            stringBuilder.append(opcoesMenu.toString());
        System.out.println(stringBuilder.append("\nEscolha uma opcao: "));
        return Integer.parseInt((scanner.next()));
    }
    private static void cadastro(){
        try {
            System.out.println("--> CADASTRAR CLIENTEPF <--");
            System.out.println("Digite o nome: ");
            String nome = teclado.nextLine();
            System.out.println("Digite o endereco: ");
            String endereco = teclado.nextLine();
            System.out.println("Digite o CPF: ");
            String cpf = teclado.nextLine();
            System.out.println("Digite o telefone: ");
            String telefone = teclado.nextLine();
            ClientePF clientePF = new ClientePF(nome, endereco, cpf, telefone);
            minhaGenCPF.adiciona(clientePF);
        }catch (Exception e){
            System.out.println("--> Erro no metodo cadastro. <--");
        }
    }
    private static void pesquisar(){
        if(!minhaGenCPF.listAll().isEmpty()){
            System.out.println("--> PESQUISAR CLIENTEPF PELO CPF <--");
            System.out.println("Digite o cpf: ");
            String pesquisaCPF = teclado.nextLine();
            ClientePF clientePF = minhaGenCPF.pesquisaCPF(pesquisaCPF);
            if(clientePF !=null){
                System.out.println(clientePF);
            }else {
                System.out.println("--> ClientePF nao existe <--");
            }
        }else
            System.out.println("--> A lista de ClientePF esta vazia <--");
    }

    private static void excluir(){
        if(!minhaGenCPF.listAll().isEmpty()){
            System.out.println("--> EXCLUIR CLIENTEPF PELO NOME <--");
            System.out.println("Digite o nome: ");
            String excluiNome = teclado.nextLine();
            String result = minhaGenCPF.excluirNome(excluiNome);
            System.out.println("--> ClientePF excluido <--");
        }else {
            System.out.println("--> ClientePF nao excluido <--");
        }
    }

    private static void listar(){
        if (!minhaGenCPF.listAll().isEmpty()){
            for (ClientePF clientePF : minhaGenCPF.listAll()){
                System.out.println(clientePF.toString());
            }
        }else {
            System.out.println("--> Lista de ClientePF vazia <--");
        }
    }


}
