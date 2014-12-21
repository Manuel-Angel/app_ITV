package com.itver.itv.news;

import com.itver.itv.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Noticia_Completa extends Fragment {
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.activity_noticia__completa, container, false);

		if(savedInstanceState == null){
			
			TextView titulo_Noticia = (TextView) rootView.findViewById(R.id.Noticia_Input_Titulo);
			TextView mensaje_Noticia = (TextView) rootView.findViewById(R.id.Noticia_cuerpo_mensaje);
			TextView autor_Noticia = (TextView) rootView.findViewById(R.id.Noticia_Input_autor);
			TextView fecha_Noticia = (TextView) rootView.findViewById(R.id.Noticia_Input_Fecha);          
					
			Bundle extras = getArguments();
			String titulo = extras.getString("titulo");
			String mensaje = extras.getString("mensaje");
			String autor = extras.getString("autor");
			String fecha = extras.getString("fecha");

			titulo_Noticia.setText(titulo);
			mensaje_Noticia.setText(mensaje);
			autor_Noticia.setText(autor_Noticia.getText()+" "+autor);
			fecha_Noticia.setText(fecha_Noticia.getText()+" "+fecha);

		}
		
		return rootView;
	}

}
