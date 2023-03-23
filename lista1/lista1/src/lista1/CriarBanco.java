package lista1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarBanco {
	private static final String USER = "root";
	private static final String PSW = "aluno";
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        
        try {
            // Conexão com o banco de dados
            conn = DriverManager.getConnection("jdbc:mysql://localhost/", USER,
					PSW);
            
            //: Criação do banco de dados
            stmt = conn.createStatement();
            String sql = "CREATE DATABASE IF NOT EXISTS minha_db";
            stmt.executeUpdate(sql);
            System.out.println("Banco de dados criado com sucesso!");

            sql = "Use minha_db";
            stmt.executeUpdate(sql);
            
            //  Criação da tabela
            sql = "CREATE TABLE IF NOT EXISTS minha_tabela ("
                    + "id INT PRIMARY KEY,"
                    + "nome VARCHAR(50),"
                    + "idade INT)";
            stmt.executeUpdate(sql);
            System.out.println("Tabela criada com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}