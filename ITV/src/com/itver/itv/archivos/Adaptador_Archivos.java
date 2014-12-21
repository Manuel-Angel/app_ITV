package com.itver.itv.archivos;

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
public class Adaptador_Archivos extends ArrayAdapter<Archivo> {

	Activity context;
	ArrayList<Archivo> lista_Archivos;

	public Adaptador_Archivos(Activity contexto, ArrayList<Archivo> archivos) {
		super(contexto, R.layout.model_list_grupo, archivos);
		context = contexto;
		lista_Archivos = archivos;
	}

	public View getView(int position, View convertView, ViewGroup parent) {

		View item = convertView;
		item = context.getLayoutInflater().inflate(R.layout.model_list_grupo, null);

		Archivo c = lista_Archivos.get(position);

		// Definimos los elementos que tiene nuestro layout
		ImageView img = (ImageView) item.findViewById(R.id.Imagen_Lista_Noticias);
		TextView nombre = (TextView) item.findViewById(R.id.Lista_nombreIdentificador);

		img.setImageDrawable(context.getResources().getDrawable(c.getImagen()));
		nombre.setText(c.getNombre());

		return (item);
	}

}