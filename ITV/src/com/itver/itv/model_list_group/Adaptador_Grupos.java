package com.itver.itv.model_list_group;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.itver.itv.R;

@SuppressLint({ "ViewHolder", "InflateParams" })
public class Adaptador_Grupos extends ArrayAdapter<Grupo> {
	
	Activity context;
	ArrayList<Grupo> listaGrupos;
	
	public Adaptador_Grupos(Activity contexto, ArrayList<Grupo> grupos) {
		super(contexto, R.layout.model_list_grupo, grupos);
		context = contexto;
		listaGrupos = grupos;
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
		
		View item = convertView;
		item = context.getLayoutInflater().inflate(R.layout.model_list_grupo, null);
		
		Grupo c = listaGrupos.get(position);
		
		ImageView img = (ImageView)item.findViewById(R.id.Imagen_Lista_Noticias);
		TextView nombre = (TextView) item.findViewById(R.id.Lista_nombreIdentificador);
		
		img.setImageDrawable(context.getResources().getDrawable(c.getImagen()));
		nombre.setText(c.getNombre());
		
		return (item);
	}
	
}