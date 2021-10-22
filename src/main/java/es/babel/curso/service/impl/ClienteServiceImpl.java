package es.babel.curso.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.babel.curso.entity.Cliente;
import es.babel.curso.repository.ClienteRepository;
import es.babel.curso.repository.PedidoRepository;
import es.babel.curso.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	ClienteRepository clienteRepo;
	
	@Autowired
	PedidoRepository pedidoRepo;

	@Override
	public int insertar(Cliente c) {
		return clienteRepo.insertar(c);
	}

	@Override
	public int modificar(Cliente c) {
		return clienteRepo.modificar(c);
	}

	@Override
	public int borrar(int id) {
		return clienteRepo.borrar(id);
	}
	
	@Override
	public Cliente buscar(int id) {
		return clienteRepo.buscar(id);
	}

	@Override
	public Cliente buscarConPedidos(int id) {
		Cliente cliente = clienteRepo.buscar(id);
		cliente.setPedidos(pedidoRepo.listarPedidosCliente(id));
		return cliente;
	}
	
	@Override
	public List<Cliente> listar() {
		return clienteRepo.listar();
	}

	@Override
	public List<Cliente> listarConPedidos() {
		List<Cliente> clientes = clienteRepo.listar();
		for (Cliente c: clientes) {
			c.setPedidos(pedidoRepo.listarPedidosCliente(c.getId()));
		}
		return clientes;
	}

}
