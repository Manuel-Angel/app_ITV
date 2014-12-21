package com.itver.itv.model_list_news;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.itver.itv.R;

@SuppressLint({ "InflateParams", "ViewHolder" })
public class Adaptador_Noticias  extends ArrayAdapter<Noticia> {
	
	Activity context;
	ArrayList<Noticia> listaNoticias;
	
	public Adaptador_Noticias (Activity contexto, ArrayList<Noticia> contactos) {
		super(contexto, R.layout.model_list_news , contactos);
		context = contexto;
		listaNoticias = contactos;
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
		
		View item = convertView;
		
		item = context.getLayoutInflater().inflate(R.layout.model_list_news , null);
		
		Noticia noticia = listaNoticias.get(position);
		
		ImageView img = (ImageView)item.findViewById(R.id.Imagen_Lista_Noticias);
		TextView autor = (TextView) item.findViewById(R.id.Model_Noticia_autor);
		TextView fecha = (TextView) item.findViewById(R.id.Model_Noticia_Fecha);
		TextView titulo_noticia = (TextView) item.findViewById(R.id.Model_Noticia_Titulo);
		TextView mensaje = (TextView) item.findViewById(R.id.Model_Noticias_Mensaje);
		
		img.setImageDrawable(context.getResources().getDrawable(noticia.getImagen()));
		autor.setText(noticia.getAutor());
		fecha.setText(noticia.getFecha());
		titulo_noticia.setText(noticia.getTitulo_Noticia());
		mensaje.setText(noticia.getCuerpo_Mensaje());
		
		return (item);
	}
}