package br.com.alura.jdbc.teste;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.alura.jdbc.factory.ConnectionFactory;

// utilizacao do TRY Com recursos para deixar o tratamento do close de todos os recursos com o java 

public class TestaTryWithResources {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory factory = new ConnectionFactory();

		try (Connection connection = factory.recuperaConexao()) {

			connection.setAutoCommit(false);

			try (PreparedStatement stm = connection.prepareStatement(
					"INSERT INTO PRODUTO (nome, descricao) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS)) {

				adicionarRegistro("Monitor", "Monitor 17 Polegadas", stm);
				adicionarRegistro("SmartTV", "45 polegadas", stm);

				connection.commit();

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Rollback executado");
				connection.rollback();
			}
		}
	}

	private static void adicionarRegistro(String nome, String descricao, PreparedStatement stm) throws SQLException {

		// o numero do parametro , variavel
		stm.setString(1, nome);
		stm.setString(2, descricao);

		stm.execute();

		try (ResultSet resultado = stm.getGeneratedKeys()) {
			while (resultado.next()) {
				Integer id = resultado.getInt(1);
				System.out.println("O id gerado foi: " + id);
			}
		}
	}
}
