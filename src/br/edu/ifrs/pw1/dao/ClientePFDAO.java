package br.edu.ifrs.pw1.dao;

import br.edu.ifrs.pw1.factory.ConnectionFactory;
import br.edu.ifrs.pw1.pessoas.ClientePF;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ClientePFDAO implements GenericDAO<ClientePF>{
    @Override
    public int insert(ClientePF obj) {
        int primaryKey = -1;
        try(Connection connection = new ConnectionFactory().getConnection();
            PreparedStatement statement = connection.prepareStatement(SQLs.INSERT.getSql(),
                    Statement.RETURN_GENERATED_KEYS)){
            statement.setString(1,obj.getNome().toLowerCase());
            statement.setString(2,obj.getEndereco().toLowerCase());
            statement.setString(3,obj.getTelefone());
            statement.setString(4,obj.getCpf());
            statement.execute();
            ResultSet keys = statement.getGeneratedKeys();
            if(keys.next()) primaryKey = keys.getInt(1);
        }catch (SQLTimeoutException e){
            System.out.println("Timeout ao inserir no banco");
        }catch (SQLException e){
            System.out.println("Erro ao inserir Cliente.");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return primaryKey;
    }

    @Override
    public int update(ClientePF obj) {
        int primaryKey = -1;
        try(Connection connection = new ConnectionFactory().getConnection();
            PreparedStatement statement = connection.prepareStatement(SQLs.UPDATE.getSql(),
                    Statement.RETURN_GENERATED_KEYS)){
            statement.setString(1, obj.getNome().toLowerCase());
            statement.setString(2, obj.getEndereco().toLowerCase());
            statement.setString(3, obj.getCpf());
            statement.setString(4,obj.getTelefone());
            statement.executeUpdate();
            ResultSet keys = statement.getGeneratedKeys();
            if(keys.next()) primaryKey = keys.getInt(1);
        }catch (SQLTimeoutException e){
            System.out.println("Timeout ao inserir cliente");
        }catch (SQLException e){
            System.out.println("Erro ao atualizar cliente.");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return primaryKey;
    }

    @Override
    public int delete(ClientePF obj) {
        try(Connection connection = new ConnectionFactory().getConnection();
            PreparedStatement statement = connection.prepareStatement(SQLs.DELETE.getSql())){
            statement.setInt(1, obj.getIdCliente());
            return statement.executeUpdate();
        }catch (SQLTimeoutException e){
            System.out.println("Timeout ao deletar cliente");
        }catch (SQLException e){
            System.out.println("Erro ao deletar cliente");
        }catch (ClassNotFoundException e){
            System.out.println("Classe nao encontrada");
        }
        return 0;
    }

    @Override
    public ClientePF findByID(int idCliente) {
        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement statement = connection.prepareStatement(SQLs.FIND_BY_ID.getSql())) {
            statement.setInt(1, idCliente);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new ClientePF(
                        resultSet.getString("nome"),
                        resultSet.getString("endereco"),
                        resultSet.getString("cpf"),
                        resultSet.getString("telefone")
                );
            }
        } catch (SQLTimeoutException ex) {
            System.out.println("Timeout ao consultar cliente pelo nome");
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar Cliente por nome!\n" + ex.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<ClientePF> listAll() {
        List<ClientePF> listaClientes = new LinkedList<>();
        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement statement = connection.prepareStatement(SQLs.LISTALL.getSql())) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                listaClientes.add(new ClientePF(
                        resultSet.getString("nome"),
                        resultSet.getString("endereco"),
                        resultSet.getString("cpf"),
                        resultSet.getString("telefone")
                ));
            }
            return listaClientes;
        } catch (SQLTimeoutException ex){
            System.out.println("Timeout ao consultar lista de clientes");
        } catch (SQLException ex) {
            System.out.println("Erro ao listar todos os Clientes!\n" + ex.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public int deleteNome(String nome) {
        try(Connection connection = new ConnectionFactory().getConnection();
            PreparedStatement statement = connection.prepareStatement(SQLs.DELETE_NOME.getSql())){
            statement.setString(1,nome.toLowerCase());
            return statement.executeUpdate();
        }catch (SQLTimeoutException e){
            System.out.println("Timeout ao deletar cliente");
        }catch (SQLException e){
            System.out.println("Erro ao deletar cliente");
        }catch (ClassNotFoundException e){
            System.out.println("Classe nao encontrada");
        }
        return -1;
    }
    public ClientePF findByCPF(String cpf) {
        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement statementmt = connection.prepareStatement(SQLs.FIND_BY_CPF.getSql())) {
            statementmt.setString(1,cpf);
            ResultSet resultSet = statementmt.executeQuery();
            if (resultSet.next()) {
                return new ClientePF(
                        resultSet.getString("nome"),
                        resultSet.getString("endereco"),
                        resultSet.getString("cpf"),
                        resultSet.getString("telefone")
                );
            }
        } catch (SQLTimeoutException e){
            System.out.println("Timeout ao consultar cliente por ID");
        } catch (SQLException e) {
            System.out.println("Erro ao buscar Cliente por CPF!\n");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
