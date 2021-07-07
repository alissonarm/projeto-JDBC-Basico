package br.com.alura.jdbc.teste;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.alura.jdbc.factory.ConnectionFactory;

public class TestaSelect {

	public static void main(String[] args) throws SQLException {

		//Abrindo a conexão
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection con = connectionFactory.recuperaConexao();
		
		PreparedStatement stm = con.prepareStatement("SELECT * FROM PRODUTO");
		stm.execute();
		
		boolean retornou = stm.execute();
		ResultSet resultado = stm.getResultSet();

		System.out.println(retornou);
		while (resultado.next()) {

			Integer id = resultado.getInt("ID");
			String nome = resultado.getString("NOME");
			String descricao = resultado.getString("DESCRICAO");
			System.out.println(id + " " + nome + " " + descricao);
			
		}
		
		System.out.println(resultado);
		
		con.close();
	}

}
