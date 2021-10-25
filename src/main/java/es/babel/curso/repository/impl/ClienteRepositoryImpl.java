package es.babel.curso.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import es.babel.curso.entity.Cliente;
import es.babel.curso.repository.ClienteRepository;

@Repository
public class ClienteRepositoryImpl implements ClienteRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private ClienteRepositoryRowMapper clienteRowMapper;

	public int insertar(Cliente c) {
		String query = "INSERT INTO clientes (NOMBRE) values(?)";
		
		return jdbcTemplate.update(query,
				c.getNombre());
		
	}

	public int modificar(Cliente c) {
		String query = "UPDATE clientes SET NOMBRE = ?";
		
		return jdbcTemplate.update(query, 
				c.getNombre());
	}

	public int borrar(int id) {
		String query = "DELETE FROM clientes WHERE id=?";
		return jdbcTemplate.update(query, id);
	}

	public Cliente buscar(int id) {
		String query = "SELECT * FROM clientes WHERE id = ?";
		
		try {
			return jdbcTemplate.queryForObject(query, clienteRowMapper, id);
		} catch (EmptyResultDataAccessException e) {
			System.out.println(e.getMessage());
			return null;
		} 
	}

	public List<Cliente> listar() {
		String query = "SELECT * FROM clientes";
		return jdbcTemplate.query(query, clienteRowMapper);
	}
	
	public void crearTablaClientes() {
		jdbcTemplate.execute("CREATE TABLE clientes (" + 
				"id int NOT NULL AUTO_INCREMENT," + 
				"nombre varchar(255) NOT NULL," + 
				"PRIMARY KEY (id)" + 
				"); ");
	}

}
