package src.model.principal;

import src.model.conexao.ConexaoBD;
import src.model.dadosSQL.ConsultaBD;
import src.model.inserirDados.Inserindo;

public class Main {
    public static void main(String[] args) {

        ConexaoBD conexaoBD = new ConexaoBD();
        conexaoBD.conectarBanco();

       Inserindo inserindo = new Inserindo();
       inserindo.InserirTabelaProduto();
       inserindo.inserirProduto("PC", 2000.00);

        ConsultaBD consultaBD = new ConsultaBD();
        consultaBD.consultar();


    }
}
