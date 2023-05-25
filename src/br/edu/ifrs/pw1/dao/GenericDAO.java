package br.edu.ifrs.pw1.dao;

import java.util.List;

public interface GenericDAO<T> {

    public int insert(T obj);
    public int update(T obj);
    public int delete(T obj);
    public T findByCPF(String cpf);
    public T findByID(int obj);
    public List<T> listAll();
}
