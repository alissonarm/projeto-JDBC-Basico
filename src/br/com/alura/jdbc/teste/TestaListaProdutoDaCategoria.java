package br.com.alura.jdbc.teste;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.jdbc.dao.CategoriaDAO;
import br.com.alura.jdbc.dao.ProdutoDAO;
import br.com.alura.jdbc.factory.ConnectionFactory;
import br.com.alura.jdbc.modelo.Categoria;
import br.com.alura.jdbc.modelo.Produto;

public class TestaListaProdutoDaCategoria {

	public static void main(String[] args) throws SQLException {
		
		try(Connection connection = new ConnectionFactory().recuperaConexao()){

			CategoriaDAO cDao = new CategoriaDAO(connection);
			List<Categoria> categorias = cDao.listar();
			categorias.stream().forEach(ct -> {
				System.out.println(ct.getId() + " " + ct.getNome());
				try {
					for (Produto prd : new ProdutoDAO(connection).busca(ct)) {
						System.out.println(ct.getNome() + " - " + prd.getNome());
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			});
			
			
		}


	}

}
