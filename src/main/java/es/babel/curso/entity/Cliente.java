package es.babel.curso.entity;

import java.util.LinkedList;
import java.util.List;

public class Cliente {
	
	private int id;
	private String nombre;
	private List<Pedido> pedidos;
	
	public Cliente() {
		pedidos = new LinkedList<Pedido>();
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getImporteTotalPedido() {
		int totalPedido = 0;
		for (Pedido p: this.getPedidos()) {
			totalPedido += p.getImporte();
		}
		return totalPedido;
	}
	
	public List<Pedido> getPedidos() {
		return pedidos;
	}
	
	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", pedidos=" + pedidos + "]";
	}
	
}
