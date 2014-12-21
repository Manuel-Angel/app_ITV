package com.itver.itv.archivos;

public class Archivo {

	private int imagen;
	private String nombre;

	public Archivo (int imagen, String nombre) {
		this.imagen = imagen;
		this.nombre = nombre;
	}

	public int getImagen() {
		return imagen;
	}

	public void setImagen(int imagen) {
		this.imagen = imagen;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
