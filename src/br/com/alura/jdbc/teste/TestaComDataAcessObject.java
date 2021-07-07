package br.com.alura.jdbc.teste;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.jdbc.dao.ProdutoDAO;
import br.com.alura.jdbc.factory.ConnectionFactory;
import br.com.alura.jdbc.modelo.Produto;

public class TestaComDataAcessObject {

	public static void main(String[] args) throws SQLException {

		Produto produto = new Produto("Cômoda", "Cômoda Vertical");
		
		try(Connection connection = new ConnectionFactory().recuperaConexao()){
			ProdutoDAO pDao = new ProdutoDAO(connection);
			pDao.SalvarProduto(produto);
			List<Produto> produtos = pDao.listar();
			produtos.stream().forEach(lp -> System.out.println(lp));
			
		}
	}
	
}
