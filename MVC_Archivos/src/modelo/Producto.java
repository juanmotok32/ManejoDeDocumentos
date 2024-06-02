package modelo;

import java.io.Serializable;

public class Producto implements Serializable{
	
	private String nombre;
	private int precio;
	private String descripcion;
	
	
	public Producto(String nombre, int precio, String descripcion) {
		this.nombre = nombre;
		this.precio = precio;
		this.descripcion = descripcion;
	}
	
	public Producto() {
	}

	public String getNombre() {
		return nombre;
	}

	
	
	
	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPrecio() {
		return precio;
	}

	private void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	private void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	@Override
	public String toString() {
		return "[ " +nombre+ " " + precio + " "+ descripcion + " ]";
	}
	
	
	
	
}
