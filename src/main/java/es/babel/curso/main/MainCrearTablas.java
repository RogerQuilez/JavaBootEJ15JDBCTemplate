package es.babel.curso.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import es.babel.curso.cfg.ApplicationConfiguration;
import es.babel.curso.repository.impl.ClienteRepositoryImpl;
import es.babel.curso.repository.impl.PedidoRepositoryImpl;

public class MainCrearTablas {

	public static ApplicationContext context;
	
	public static void main(String[] args) {
		
		context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
		
		ClienteRepositoryImpl clienteRepo = context.getBean("clienteRepositoryImpl", ClienteRepositoryImpl.class);
		clienteRepo.crearTablaClientes();
		
		PedidoRepositoryImpl pedidoRepo = context.getBean("pedidoRepositoryImpl", PedidoRepositoryImpl.class);
		pedidoRepo.crearTablaClientes();
	}
}
