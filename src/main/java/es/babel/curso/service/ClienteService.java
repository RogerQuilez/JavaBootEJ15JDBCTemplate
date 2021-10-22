package es.babel.curso.service;

import java.util.List;

import es.babel.curso.entity.Cliente;

public interface ClienteService {

	int insertar(Cliente c);
	int modificar(Cliente c);
	int borrar(int id);
	Cliente buscar(int id);
	Cliente buscarConPedidos(int id);
	List<Cliente> listar();
	List<Cliente> listarConPedidos();
}
