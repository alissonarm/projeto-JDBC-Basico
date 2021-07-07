package br.com.alura.jdbc.teste;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.jdbc.dao.CategoriaDAO;
import br.com.alura.jdbc.factory.ConnectionFactory;
import br.com.alura.jdbc.modelo.Categoria;

public class TestaListagemDeCategorias {

	public static void main(String[] args) throws SQLException {
		
		try(Connection connection = new ConnectionFactory().recuperaConexao()){

			CategoriaDAO cDao = new CategoriaDAO(connection);
			List<Categoria> categorias = cDao.listar();
			categorias.stream().forEach(ct -> System.out.println(ct.getId() + " " + ct.getNome()));
			
		}


	}

}
