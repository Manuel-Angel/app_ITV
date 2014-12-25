package com.itver.itv.news;

import com.itver.itv.R;

import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Noticia_Completa extends Fragment {

	public static final String TAG_NOTICIA_SELECCIONADA = "noticia";
	private String titulo;
	private String mensaje;
	private String autor;
	private String fecha;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.activity_noticia__completa, container, false);

		TextView titulo_Noticia = (TextView) rootView.findViewById(R.id.Noticia_Input_Titulo);
		TextView mensaje_Noticia = (TextView) rootView.findViewById(R.id.Noticia_cuerpo_mensaje);
		TextView autor_Noticia = (TextView) rootView.findViewById(R.id.Noticia_Input_autor);
		TextView fecha_Noticia = (TextView) rootView.findViewById(R.id.Noticia_Input_Fecha);

		Bundle extras = getArguments();

		titulo = extras.getString("titulo");
		mensaje = extras.getString("mensaje");
		autor = extras.getString("autor");
		fecha = extras.getString("fecha");

		titulo_Noticia.setText(titulo);
		mensaje_Noticia.setText(mensaje);
		autor_Noticia.setText(autor_Noticia.getText() + " " + autor);
		fecha_Noticia.setText(fecha_Noticia.getText() + " " + fecha);

		ActionBar barra = getActivity().getActionBar();
		barra.setTitle("Noticia");
		
		return rootView;
	}
}