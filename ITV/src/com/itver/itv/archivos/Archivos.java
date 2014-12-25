package com.itver.itv.archivos;

import java.util.ArrayList;

import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.itver.itv.R;

public class Archivos extends Fragment{

	private  ListView listView;
	private ArrayList<Archivo> lista_Grupos;
	
	private Adaptador_Archivos adapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.activity_archivos, container, false);
		
		listView = (ListView) rootView.findViewById(R.id.Archivos_ListView);
		lista_Grupos = new ArrayList<Archivo>();
		
		adapter = new Adaptador_Archivos(this.getActivity(), lista_Grupos);
		listView.setAdapter(adapter);

		int imagen = android.R.drawable.sym_contact_card;
		
		lista_Grupos.add(new Archivo(imagen,"Simulación"));
		lista_Grupos.add( new Archivo(imagen, "Ingeniería de software") );
		lista_Grupos.add( new Archivo(imagen, "Desarrollo Sustentable") );
		lista_Grupos.add(new Archivo(imagen, "POO"));
		lista_Grupos.add(new Archivo(imagen, "Taller de Base de Datos"));
		lista_Grupos.add(new Archivo(imagen, "Fundamentos de Base de Datos"));
		lista_Grupos.add(new Archivo(imagen, "Principios Eléctricos"));
		lista_Grupos.add(new Archivo(imagen, "Arquitectura de Computadoras"));
		
		ActionBar barra = getActivity().getActionBar();
		barra.setTitle("Archivos");

		return rootView;
	}
}
