package es.babel.curso.repository;

import java.util.List;

import es.babel.curso.entity.Cliente;

public interface ClienteRepository {
	
	int insertar(Cliente c);
	int modificar(Cliente c, int id);
	int borrar(int id);
	Cliente buscar(int id);
	List<Cliente> listar();
	
}
