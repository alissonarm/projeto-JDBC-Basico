package br.com.alura.jdbc.teste;
import java.sql.Connection;
import java.sql.SQLException;

import br.com.alura.jdbc.factory.ConnectionFactory;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {

		//Abrindo a conexão
//		Connection con = DriverManager
//				.getConnection("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC", "root", "F0500025");
		
		ConnectionFactory cf = new ConnectionFactory();
		Connection con = cf.recuperaConexao();
		
		System.out.println("Fechando Conexao");
		
		con.close();
	}

}
