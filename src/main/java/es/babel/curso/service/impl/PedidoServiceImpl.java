package es.babel.curso.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.babel.curso.entity.Pedido;
import es.babel.curso.repository.PedidoRepository;
import es.babel.curso.service.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService{

	@Autowired 
	private PedidoRepository pedidoRepo;
	
	@Override
	public int insertar(Pedido p) {
		return pedidoRepo.insertar(p);
	}

	@Override
	public int modificar(Pedido p) {
		return pedidoRepo.modificar(p);
	}

	@Override
	public int borrar(int id) {
		return pedidoRepo.borrar(id);
	}

	@Override
	public Pedido buscar(int id) {
		return pedidoRepo.buscar(id);
	}

	@Override
	public List<Pedido> listar() {
		return pedidoRepo.listar();
	}

}
