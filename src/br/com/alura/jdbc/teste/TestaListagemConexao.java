package br.com.alura.jdbc.teste;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaListagemConexao {

	public static void main(String[] args) throws SQLException {

		//Abrindo a conexão
		Connection con = DriverManager
				.getConnection("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC", "root", "F0500025");
		
		Statement stm = con.createStatement();
		boolean resultado = stm.execute("SELECT ID, NOME, DESCRICAO FROM PRODUTO");
		
		ResultSet rst = stm.getResultSet();
		
		while (rst.next()) {
			Integer id = rst.getInt("ID");
			System.out.println(id);
			String nome = rst.getString("NOME");
			System.out.println(nome);
			String descricao = rst.getString("DESCRICAO");
			System.out.println(descricao);
		}
		
		System.out.println(resultado);
		
		System.out.println("Fechando Conexao");
		con.close();
	}

}
