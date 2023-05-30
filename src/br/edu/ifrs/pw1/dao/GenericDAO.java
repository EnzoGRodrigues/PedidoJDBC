package br.edu.ifrs.pw1.dao;

public interface GenericDAO<T> {

    public int insert(T obj);
    public int update(T obj);
    public int delete(T obj);
    public T findByCPF(String cpf);
    public T findByID(int obj);
    public MinhaGen<T> listAll();
}
