package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContatoDAO {

    private final Connection connection;

    public ContatoDAO(Connection connection) {
        this.connection = connection;
    }

    public void inserir(Contato Contato) throws SQLException {
        String sql = "INSERT INTO contatos (nome, Telefone) VALUES (?, ?)";
        try ( PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, Contato.getNome());
            statement.setString(2, Contato.getTelefone());
            statement.executeUpdate();
        }
    }

    public Contato buscarPorId(int id) throws SQLException {
        String sql = "SELECT id, nome, telefone FROM Contatos WHERE id = ?";
        try ( PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Contato(
                        resultSet.getInt("id"),
                        resultSet.getString("nome"),
                        resultSet.getString("telefone")
                );
            }
        }
        return null;
    }

    public List<Contato> buscarPorNome(String nome) throws SQLException {
        String sql = "SELECT id, nome, telefone FROM contatos WHERE nome LIKE ?";
        try ( PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, "%" + nome + "%"); // Busca por nome contendo o termo
            ResultSet resultSet = statement.executeQuery();
            List<Contato> contato = new ArrayList<>();
            while (resultSet.next()) {
                contato.add(new Contato(
                        resultSet.getInt("id"),
                        resultSet.getString("nome"),
                        resultSet.getString("telefone")
                ));
            }
            return contato;
        }
    }

    public void atualizar(Contato Contato) throws SQLException {
        String sql = "UPDATE contatos SET nome = ?, telefone = ? WHERE id = ?";
        try ( PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, Contato.getNome());
            statement.setString(2, Contato.getTelefone());
            statement.setInt(3, Contato.getID());
            statement.executeUpdate();
        }
    }

    public void excluir(int id) throws SQLException {
        String sql = "DELETE FROM contatos WHERE id = ?";
        try ( PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

    public List<Contato> listarContatos() throws SQLException {
        String sql = "SELECT id, nome, telefone FROM contatos";
        try ( PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            List<Contato> Contatos = new ArrayList<>();
            while (resultSet.next()) {
                Contatos.add(new Contato(
                        resultSet.getInt("id"),
                        resultSet.getString("nome"),
                        resultSet.getString("telefone")
                ));
            }
            return Contatos;
        }
    }
}


