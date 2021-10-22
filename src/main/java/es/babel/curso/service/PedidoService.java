package es.babel.curso.service;

import java.util.List;

import es.babel.curso.entity.Pedido;

public interface PedidoService {

	int insertar(Pedido p);
	int modificar(Pedido p);
	int borrar(int id);
	Pedido buscar(int id);
	List<Pedido> listar();
	
}
