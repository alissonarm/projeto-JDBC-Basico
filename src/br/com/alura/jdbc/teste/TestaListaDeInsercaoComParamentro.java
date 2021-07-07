package br.com.alura.jdbc.teste;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.alura.jdbc.factory.ConnectionFactory;

public class TestaListaDeInsercaoComParamentro {

	public static void main(String[] args) throws SQLException {

		// Abrindo a conexão
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recuperaConexao();
		connection.setAutoCommit(false); // Se informado false, o controle do commit é do desenvolvedor

		try {
			// Preparação
			PreparedStatement stm = connection.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (?,?)",
					Statement.RETURN_GENERATED_KEYS);

			adicionarRegistro("Monitor", "Monitor 17 Polegadas", stm);
			adicionarRegistro("SmartTV", "45 polegadas", stm);

			connection.commit();
			stm.close();
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Rollback executado");
			connection.rollback();
		}
		connection.close();
	}

	private static void adicionarRegistro(String nome, String descricao, PreparedStatement stm) throws SQLException {

		// o numero do parametro , variavel
		stm.setString(1, nome);
		stm.setString(2, descricao);

		stm.execute();

		// retorna a chave gerada
		ResultSet resultado = stm.getGeneratedKeys();
		while (resultado.next()) {
			Integer id = resultado.getInt(1);
			System.out.println("O id gerado foi: " + id);
		}
		resultado.close();
	}

}
