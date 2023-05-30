package br.edu.ifrs.pw1.dao;

import br.edu.ifrs.pw1.pessoas.ClientePF;

import java.util.ArrayList;
import java.util.List;

public class MinhaGen<T> {
    private final List<T> listGeneric;

    public MinhaGen() {
        listGeneric = new ArrayList<>();
    }

    public boolean adiciona(T obj) {
        try {
            return listGeneric.add(obj);
        } catch (UnsupportedOperationException e) {
            System.out.println("Erro ao adicionar o objeto na lista");
        } catch (Exception e) {
            System.out.println("Erro no metodo adiciona");
        }
        return false;
    }

    public T pesquisaCPF(String cpf) {
        for (T obj : listGeneric) {
            if (obj instanceof ClientePF) {
                ClientePF clientePF = (ClientePF) obj;
                if (clientePF.getCpf().equals(cpf)) {
                    return obj;
                }
            }
        }
        return null;
    }

    public String excluirNome(String nome) {
        for (T obj : listGeneric) {
            if (obj instanceof ClientePF) {
                ClientePF clientePF = (ClientePF) obj;
                if (clientePF.getNome().equalsIgnoreCase(nome)) {
                    listGeneric.remove(obj);
                    return "--> ClientePF deletado <--";
                }
            }
        }
        return "--> ClientePF nao deletado <--";
    }

    public List<T> listAll() {
        return listGeneric;
    }
}
