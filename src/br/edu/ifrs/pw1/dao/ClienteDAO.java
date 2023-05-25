package br.edu.ifrs.pw1.dao;

import br.edu.ifrs.pw1.pessoas.Cliente;

import java.util.List;

public class ClienteDAO implements GenericDAO<Cliente>{
    @Override
    public int insert(Cliente obj) {
        return 0;
    }

    @Override
    public int update(Cliente obj) {
        return 0;
    }

    @Override
    public int delete(Cliente obj) {
        return 0;
    }

    @Override
    public Cliente findByCPF(String cpf) {
        return null;
    }

    @Override
    public Cliente findByID(int obj) {
        return null;
    }

    @Override
    public List<Cliente> listAll() {
        return null;
    }
}
