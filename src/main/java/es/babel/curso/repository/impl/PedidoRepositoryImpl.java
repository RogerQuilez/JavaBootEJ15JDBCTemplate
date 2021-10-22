package es.babel.curso.repository.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import es.babel.curso.entity.Pedido;
import es.babel.curso.repository.PedidoRepository;

@Repository
public class PedidoRepositoryImpl implements PedidoRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private PedidoRepositoryRowMapper pedidoRepositoryRowMapper;

	public int insertar(Pedido p) {
		String query = "INSERT INTO pedidos (IMPORTE, FECHA, CLIENTE_ID) values(?,?,?)";
		
		return jdbcTemplate.update(query,
				p.getImporte(),
				new Date(),
				p.getClienteId());
		
	}

	public int modificar(Pedido p) {
		String query = "UPDATE pedidos SET IMPORTE = ?, FECHA = ?, CLIENTE_ID = ?";
		
		return jdbcTemplate.update(query, 
				p.getImporte(),
				p.getFecha(),
				p.getClienteId());
	}

	public int borrar(int id) {
		String query = "DELETE FROM pedidos WHERE id=?";
		return jdbcTemplate.update(query, id);
	}

	public Pedido buscar(int id) {
		String query = "SELECT * FROM pedidos WHERE ID = ?";
		
		try {
			return jdbcTemplate.queryForObject(query, pedidoRepositoryRowMapper, id);
		} catch (EmptyResultDataAccessException e) {
			System.out.println(e.getMessage());
			return null;
		} 
	}

	public List<Pedido> listar() {
		String query = "SELECT * FROM pedidos";
		return jdbcTemplate.query(query, pedidoRepositoryRowMapper);
	}
	
	public List<Pedido> listarPedidosCliente(int idCliente) {
		String query = "SELECT * FROM pedidos WHERE cliente_id = ?";
		return jdbcTemplate.query(query, pedidoRepositoryRowMapper, idCliente);
	}
	
	public void crearTablaClientes() {
		jdbcTemplate.execute("CREATE TABLE pedidos (" + 
				"id int NOT NULL AUTO_INCREMENT," + 
				"importe int NOT NULL," + 
				"cliente_id int NOT NULL," +
				"fecha date," +
				"PRIMARY KEY (id)," + 
				"FOREIGN KEY (cliente_id) REFERENCES clientes(id)" +
				"); ");
	}

}
