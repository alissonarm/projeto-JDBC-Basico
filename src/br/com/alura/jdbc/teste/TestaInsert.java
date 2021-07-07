package br.com.alura.jdbc.teste;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.alura.jdbc.factory.ConnectionFactory;

public class TestaInsert {

	public static void main(String[] args) throws SQLException {

		//Abrindo a conexão
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recuperaConexao();
		
		Statement stm = connection.createStatement();
		
		// devolve true quando seu resultado é um java.sql.Result(lista) e false se caso contrario (for update, delete...)
		// Statement.RETURN_GENERATED_KEYS -> solicita o retorno da chave gerada.
		stm.execute("INSERT INTO PRODUTO (nome, descricao) VALUES ('FOGAO', 'FOGAO 4 BOCAS')", Statement.RETURN_GENERATED_KEYS);
		
		// retorna a chave gerada
		ResultSet resultado = stm.getGeneratedKeys();
		
		System.out.println(resultado);
		while (resultado.next()) {

			Integer id = resultado.getInt(1);
			System.out.println("O id gerado foi: " + id );
			
		}

		connection.close();
	}

}
