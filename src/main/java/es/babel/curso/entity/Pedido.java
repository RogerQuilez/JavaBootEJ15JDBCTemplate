package es.babel.curso.entity;

import java.util.Date;

public class Pedido {

	private int id;
	private int importe;
	private int clienteId;
	private Date fecha;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getImporte() {
		return importe;
	}
	
	public void setImporte(int importe) {
		this.importe = importe;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getClienteId() {
		return clienteId;
	}

	public void setClienteId(int id) {
		this.clienteId = id;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", importe=" + importe + ", clienteId=" + clienteId + ", fecha=" + fecha + "]";
	}
	
}
