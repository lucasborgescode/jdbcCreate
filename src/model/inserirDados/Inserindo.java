package src.model.inserirDados;


import src.model.conexao.ConexaoBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Inserindo {

    public static void InserirTabelaProduto() {

        String sql = "CREATE TABLE IF NOT EXISTS produto (" +
                "IdProduto INT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                "nome VARCHAR(100)," +
                "preco VARCHAR(100))";
        try (
                Connection conectado = ConexaoBD.conectarBanco();
                Statement statement = conectado.createStatement();
        ) {
            statement.executeUpdate(sql);
            System.out.println("TABELA CRIADA COM SUCESSO");
        }catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

    }
    public static void inserirProduto(String nome, double preco) {

        String sql = "INSERT INTO produto (nome, preco) VALUES (?, ?)";

        try (Connection conectado = ConexaoBD.conectarBanco();
             PreparedStatement ps = conectado.prepareStatement(sql)) {

            ps.setString(1, nome);
            ps.setDouble(2, preco);
            ps.executeUpdate();
            System.out.println("Produto inserido com sucesso.");

        } catch (SQLException e) {
            System.out.println("Erro ao inserir produto: " + e.getMessage());
        }
    }



}
