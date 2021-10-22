package es.babel.curso.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import es.babel.curso.entity.Cliente;

@Component
public class ClienteRepositoryRowMapper implements RowMapper<Cliente> {

	public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
		Cliente c = new Cliente();
		c.setId(rs.getInt("ID"));
		c.setNombre(rs.getString("NOMBRE"));
		return c;
	}

}
