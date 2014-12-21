package com.itver.itv.model_list_messages;

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
public class Adaptador_Mensajes extends ArrayAdapter<Contacto> {
	
	Activity context;
	ArrayList<Contacto> listaContactos;
	
	public Adaptador_Mensajes (Activity contexto, ArrayList<Contacto> contactos) {
		super(contexto, R.layout.model_list_messages , contactos);
		context = contexto;
		listaContactos = contactos;
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
		
		View item = convertView;
		item = context.getLayoutInflater().inflate(R.layout.model_list_messages , null);
		
		Contacto c = listaContactos.get(position);
		
		ImageView img = (ImageView)item.findViewById(R.id.Imagen_Lista_Noticias);
		TextView nombre = (TextView) item.findViewById(R.id.Noticia_autor_modelo);
		TextView fecha = (TextView) item.findViewById(R.id.Lista_fecha_Messages);
		TextView mensaje = (TextView) item.findViewById(R.id.mensaje_Cuerpo);
		
		img.setImageDrawable(context.getResources().getDrawable(c.getImagen()));
		nombre.setText(c.getNombre());
		fecha.setText(c.getFecha());
		mensaje.setText(c.getCuerpo_Mensaje());
		
		return (item);
	}
}