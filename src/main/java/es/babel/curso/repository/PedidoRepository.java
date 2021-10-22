package es.babel.curso.repository;

import java.util.List;

import es.babel.curso.entity.Pedido;

public interface PedidoRepository {
	
	int insertar(Pedido p);
	int modificar(Pedido p);
	int borrar(int id);
	Pedido buscar(int id);
	List<Pedido> listar();
	List<Pedido> listarPedidosCliente(int idCliente);
}
