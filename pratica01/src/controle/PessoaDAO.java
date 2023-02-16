package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Pessoa;

public class PessoaDAO {

	private Conexao con;

	public boolean inserir(Pessoa p) {

		// Instacia classe Conexao
		con = Conexao.getInstancia();

		// abrir conexao
		con.conectar();

		Connection c = con.conectar();
		try {
			String query = "INSERT INTO pessoa " + "(nome, cpf) VALUES (?,?);";
			PreparedStatement stm = c.prepareStatement(query);

			stm.setString(1, "Ezequiel");
			stm.setInt(2, 123);

			stm.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		// fechar conexao
		con.fechaConexao();

		return false;
	}

	public boolean atualizar(Pessoa p) {
		return false;
	}

	public boolean deletar(Pessoa p) {
		return false;
	}

	public ArrayList<Pessoa> listaPessoas() {
		// Instacia classe Conexao
		con = Conexao.getInstancia();

		// abrir conexao
		con.conectar();

		Connection c = con.conectar();
		ArrayList<Pessoa> pessoas = new ArrayList<>();
		try {
			Statement stm = c.createStatement();
			String query = "SELECT * FROM pessoa";
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				String nome = rs.getString("nome");
				int cpf = rs.getInt("cpf");
				Pessoa p = new Pessoa();
				p.setCpf(cpf);
				p.setNome(nome);
				pessoas.add(p);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		// fechar conexao
		con.fechaConexao();

		return pessoas;
	}

}
