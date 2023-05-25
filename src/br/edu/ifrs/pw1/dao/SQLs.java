package br.edu.ifrs.pw1.dao;

public enum SQLs {
    INSERT("insert into clientepf(nome, endereco, cpf, telefone) values (?, ?, ?, ?)"),
    LISTALL("select * from clientepf"),
    UPDATE("update clientepf set nome=?, endereco=?, cpf=?, telefone=? where idCliente"),
    DELETE("delete from clientepf where cpf=?"),
    DELETE_NOME("delete from clientepf where nome=?"),
    FIND_BY_CPF("select * from clientepf where cpf=?"),
    FIND_BY_NOME("select * from clientepf where nome=?"),
    FIND_BY_ID("select * from clientepf where idCliente=?");

    private final String sql;
    private SQLs(String sql) {
        this.sql = sql;
    }
    public String getSql(){
        return sql;
    }
}
