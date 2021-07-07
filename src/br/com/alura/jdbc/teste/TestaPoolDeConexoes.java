package br.com.alura.jdbc.teste;
import java.sql.SQLException;

import br.com.alura.jdbc.factory.ConnectionFactory;

public class TestaPoolDeConexoes {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		
		for (int i = 0; i < 20; i++) {
			connectionFactory.recuperaConexao();
			System.out.println("Conexao de número: " + i);
		} 
		
		System.out.println("Fechando Conexao");
		
	}

}
