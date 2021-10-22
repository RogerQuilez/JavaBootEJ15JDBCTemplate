package es.babel.curso.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import es.babel.curso.entity.Pedido;

@Component
public class PedidoRepositoryRowMapper implements RowMapper<Pedido> {

	@Override
	public Pedido mapRow(ResultSet rs, int rowNum) throws SQLException {
		Pedido p = new Pedido();
		p.setId(rs.getInt("ID"));
		p.setImporte(rs.getInt("IMPORTE"));
		p.setClienteId(rs.getInt("CLIENTE_ID"));
		p.setFecha(rs.getDate("FECHA"));
		return p;
	}
	
}
