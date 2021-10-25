package es.babel.curso.main;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import es.babel.curso.cfg.ApplicationConfiguration;
import es.babel.curso.entity.Cliente;
import es.babel.curso.entity.Pedido;
import es.babel.curso.service.ClienteService;
import es.babel.curso.service.PedidoService;

public class Main {

	public static ApplicationContext context;
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
		ClienteService clienteService = context.getBean("clienteServiceImpl", ClienteService.class);	
		PedidoService pedidoService = context.getBean("pedidoServiceImpl", PedidoService.class);
		
		int opcion = 0;
		
		do {
			
			opcion = printMenu();
			
			switch(opcion) {
			
				case 1:
					altaCliente(clienteService);
					break;
					
				case 2:
					bajaCliente(clienteService);
					break;
					
				case 3:
					buscarCliente(clienteService);
					break;
				
				case 4:
					modificarCliente(clienteService);
					break;
					
				case 5:
					añadirPedidoCliente(pedidoService);
					break;
					
				case 6:
					listarClientes(clienteService);
					break;
					
				case 7:
					buscarConProductos(clienteService);
					break;
					
				case 8:
					listarConProductos(clienteService);
					break;				
				
			}
			
		} while (opcion != 0);
	}

	private static int printMenu() {
		System.out.println("---------------Bienvenido a la aplicación de pedidos-----------------\n"
				+ "\t 1. Dar de alta un nuevo cliente\n"
				+ "\t 2. Dar de baja un cliente\n"
				+ "\t 3. Buscar un cliente\n"
				+ "\t 4. Modificar un cliente\n"
				+ "\t 5. Añadir un pedido a un cliente\n"
				+ "\t 6. Listar Clientes\n"
				+ "\t 7. Buscar un cliente con sus productos\n"
				+ "\t 8. Listar los clientes con sus productos\n"
				+ "\t 0. Salir");
		return Integer.parseInt(sc.nextLine());
	}
	
	private static void altaCliente(ClienteService clienteService) {
		Cliente c = new Cliente();
		System.out.println("Por favor, introduzca el nombre del cliente");
		c.setNombre(sc.nextLine());
		clienteService.insertar(c);
	}
	
	private static void bajaCliente(ClienteService clienteService) {
		clienteService.borrar(getIdCliente());
	}
	
	private static void buscarCliente(ClienteService clienteService) {
		System.out.println(clienteService.buscar(getIdCliente()));
	}
	
	private static void modificarCliente(ClienteService clienteService) {
		Cliente cliente = clienteService.buscar(getIdCliente());
		System.out.println("Introduzca un nuevo nombre");
		cliente.setNombre(sc.nextLine());
		clienteService.modificar(cliente);		
	}
	
	private static void añadirPedidoCliente(PedidoService pedidoService) {
		pedidoService.insertar(getNewProduct());
	}
	
	private static int getIdCliente() {
		System.out.println("Por favor, introduza la id del cliente");
		return Integer.parseInt(sc.nextLine());
	}
	
	private static Pedido getNewProduct() {
		Pedido p = new Pedido();
		System.out.println("Por favor, introduzca el importe del pedido");
		p.setImporte(Integer.parseInt(sc.nextLine()));
		p.setClienteId(getIdCliente());
		return p;
	}
	
	private static void listarClientes(ClienteService clienteService) {
		List<Cliente> clientes = clienteService.listar();
		clientes.forEach((c) -> System.out.println(c));
	}
	
	private static void buscarConProductos(ClienteService clienteService) {
		System.out.println(clienteService.buscarConPedidos(getIdCliente()));
	}
	
	private static void listarConProductos(ClienteService clienteService) {
		List<Cliente> clientes = clienteService.listarConPedidos();
		clientes.forEach((c) -> System.out.println(c));
	}
	
}
