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

/**
 * Clase que muestra los Integrantes de un grupo seleccionado.
 * @author Jesus
 *
 */
@SuppressLint({ "InflateParams", "ViewHolder" })
public class Adapter_List_Members_Groups extends ArrayAdapter<Contacto> {
	
	Activity context;
	ArrayList<Contacto> listaContactos;
	
	public Adapter_List_Members_Groups (Activity contexto, ArrayList<Contacto> contactos) {
		super(contexto, R.layout.model_list_grupo , contactos);
		context = contexto;
		listaContactos = contactos;
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
		
		View item = convertView;
		item = context.getLayoutInflater().inflate(R.layout.model_list_grupo , null);
		
		Contacto c = listaContactos.get(position);
		
		ImageView img = (ImageView)item.findViewById(R.id.Imagen_Lista_Noticias);
		TextView nombre = (TextView) item.findViewById(R.id.Lista_nombreIdentificador);
		
		img.setImageDrawable(context.getResources().getDrawable(c.getImagen()));
		nombre.setText(c.getNombre());
		//nombre.setTextSize(15);

		return (item);
	}
}