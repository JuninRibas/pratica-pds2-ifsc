package CriarBanco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CriarBanco {

	public static void main(String[] args) {
		private static final String DATABASE = "ezequiel";
		private static final String USER = "root";
		private static final String PSW = "aluno";

			public Connection conectar() {
				try {
					conexao = DriverManager.getConnection("jdbc:mysql://localhost/" + DATABASE + "?serverTimezone=UTC", USER,
							PSW);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return conexao;
			}

			public boolean fechaConexao() {
				try {
					conexao.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return false;
				}
				return true;
			}

		

	}

}
