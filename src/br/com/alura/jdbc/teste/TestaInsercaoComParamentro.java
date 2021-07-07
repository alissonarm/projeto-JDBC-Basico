package br.com.alura.jdbc.teste;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.alura.jdbc.factory.ConnectionFactory;

public class TestaInsercaoComParamentro {

	public static void main(String[] args) throws SQLException {
		
		String nome = "Mouse";
		String descricao = "Mouse sem fio";

		//Abrindo a conexão
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recuperaConexao();
		
		PreparedStatement stm = connection.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);
		// o numero do parametro , variavel
		stm.setString(1, nome);
		stm.setString(2, descricao);
		
		stm.execute();
		
		// retorna a chave gerada
		ResultSet resultado = stm.getGeneratedKeys();
		
		System.out.println(resultado);
		while (resultado.next()) {

			Integer id = resultado.getInt(1);
			System.out.println("O id gerado foi: " + id );
			
		}

		stm.close();
		connection.close();
	}

}
