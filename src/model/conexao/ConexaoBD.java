package src.model.conexao;

import java.sql.*;

public class ConexaoBD {

    private static final String URL = "jdbc:mysql://localhost:3306/bdteste";
    private static final String USUARIO = "root";
    private static final String SENHA = "12345";

    public static Connection conectarBanco() {
        Connection conexao = null;

      try  {
          conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
          System.out.println("Banco conectado");
          return conexao;

        }catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            return null;
        }

      }
}






