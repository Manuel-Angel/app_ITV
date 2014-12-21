package com.itver.itv.model_list_news;

public class Noticia {
	
	private int imagen;
	private String autor;
	private String titulo_Noticia;
	private String fecha;
	private String cuerpo_Mensaje;
	
	public Noticia(int image, String writer , String title, String date , String message) {
		super();
		imagen = image;
		autor = writer;
		titulo_Noticia = title;
		fecha = date;
		cuerpo_Mensaje = message;
	}

	public int getImagen() {
		return imagen;
	}

	public void setImagen(int imagen) {
		this.imagen = imagen;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTitulo_Noticia() {
		return titulo_Noticia;
	}

	public void setTitulo_Noticia(String titulo_Noticia) {
		this.titulo_Noticia = titulo_Noticia;
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
