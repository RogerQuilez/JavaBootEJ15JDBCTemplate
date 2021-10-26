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
		if (!"".equals(c.getNombre())) {
			System.out.println("Se ha dado de alta al cliente " + c.getNombre());
			return clienteRepo.insertar(c);
		}
		return -1;
	}

	@Override
	public int modificar(Cliente c) {
		if (!"".equals(c.getNombre())) {
			System.out.println("Se ha modificado correctamente al cliente " + c.getNombre());
			return clienteRepo.modificar(c, c.getId());
		}
		return -1;
	}

	@Override
	public int borrar(int id) {
		if (clienteRepo.buscar(id) == null) {
			System.out.println("No existen clientes con el ID: " + id);
		} else {
			System.out.println("Cliente con ID " + id + " borrado.");
		}
		return clienteRepo.borrar(id);
	}
	
	@Override
	public Cliente buscar(int id) {
		Cliente c = clienteRepo.buscar(id);
		if (c == null) {
			System.out.println("No existen clientes con el ID: " + id);
		} else {
			System.out.println("Cliente con ID " + id + " encontrado: \n" + c);
		}
		return c;
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
