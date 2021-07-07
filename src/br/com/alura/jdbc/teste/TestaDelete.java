package br.com.alura.jdbc.teste;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.alura.jdbc.factory.ConnectionFactory;

public class TestaDelete {

	public static void main(String[] args) throws SQLException {

		//Abrindo a conexão
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection con = connectionFactory.recuperaConexao();
		
		PreparedStatement stm = con.prepareStatement("DELETE FROM PRODUTO WHERE id > ?");
		// o numero do parametro , o valor do parametro
		stm.setInt(1, 2);
		
		stm.execute();

		Integer quantidadeDeLinhasDeletadas = stm.getUpdateCount();

		System.out.println(quantidadeDeLinhasDeletadas);
		
		con.close();
	}

}
