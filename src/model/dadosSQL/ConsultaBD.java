package src.model.dadosSQL;

import org.w3c.dom.ls.LSOutput;
import src.model.conexao.ConexaoBD;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConsultaBD {

    public static void consultar() {

        try (
                Connection conectado = ConexaoBD.conectarBanco();
                Statement statement = conectado.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM produto");

        ) {
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("IdProduto") + " " + resultSet.getString("nome") + " " + resultSet.getDouble("preco"));
            }
        }catch (SQLException e) {
            System.out.println("ERRO AO LER O BANCO");
        }

    }
}
