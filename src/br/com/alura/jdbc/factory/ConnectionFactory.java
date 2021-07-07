package br.com.alura.jdbc.factory;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;


// cria conexao
public class ConnectionFactory {

	public DataSource dataSource;

	public ConnectionFactory() {
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC");
		comboPooledDataSource.setUser("root");
		comboPooledDataSource.setPassword("F0500025");
		
		// seta a quantidade maxima de conexoes
		comboPooledDataSource.setMaxPoolSize(15);
		
		
		this.dataSource = comboPooledDataSource;
	}

	public Connection recuperaConexao() throws SQLException {
		return this.dataSource.getConnection();
	}

//  Abre uma conexao direto no JDBC	
//	public Connection recuperaConexao() throws SQLException {
//		Connection con = DriverManager.getConnection(
//				"jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC", "root", "F0500025");
//
//		return con;
//	}

}
