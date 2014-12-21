package com.itver.itv.model_list_messages;

public class Contacto {

	private int imagen;
	private String nombre;
	private String fecha;
	private String cuerpo_Mensaje;

	public Contacto (int img, String nom) {
		imagen = img;
		nombre = nom;
	}
	
	public Contacto(int img , String nom , String date , String men) {
		imagen = img;
		nombre = nom;
		fecha = date;
		cuerpo_Mensaje = men;
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

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getCuerpo_Mensaje() {
		return cuerpo_Mensaje;
	}

	public void setCuerpo_Mensaje(String cuerpo_Mensaje) {
		this.cuerpo_Mensaje = cuerpo_Mensaje;
	}
}