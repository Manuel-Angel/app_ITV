package com.itver.itv.groups;

import java.util.ArrayList;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.itver.itv.R;
import com.itver.itv.model_list_group.Adaptador_Grupos;
import com.itver.itv.model_list_group.Grupo;

public class Grupos extends /* FragmentActivity */Fragment implements
		OnItemClickListener {

	private ListView listView;
	private ArrayList<Grupo> lista_Grupos;

	private Adaptador_Grupos adapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		View rootView = inflater.inflate(R.layout.activity_grupos, container, false);

		listView = (ListView) rootView.findViewById(R.id.lista_Grupos);
		lista_Grupos = new ArrayList<Grupo>();

		adapter = new Adaptador_Grupos(this.getActivity(), lista_Grupos);
		listView.setAdapter(adapter);

		listView.setOnItemClickListener(this);

		int imagen = android.R.drawable.ic_menu_my_calendar;
		
		lista_Grupos.add(new Grupo(imagen, "Simulación"));
		lista_Grupos.add(new Grupo(imagen, "Ingeniería de software"));
		lista_Grupos.add(new Grupo(imagen, "Desarrollo Sustentable"));
		lista_Grupos.add(new Grupo(imagen, "POO"));
		lista_Grupos.add(new Grupo(imagen, "Taller de Base de Datos"));
		lista_Grupos.add(new Grupo(imagen, "Fundamentos de Base de Datos"));
		lista_Grupos.add(new Grupo(imagen, "Principios Eléctricos"));
		lista_Grupos.add(new Grupo(imagen, "Arquitectura de Computadoras"));

		return rootView;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

		String nombre = lista_Grupos.get(position).getNombre();
		FragmentManager fm = getFragmentManager();
		FragmentTransaction trans = fm.beginTransaction();
		
		ContactosGrupo grupo = new ContactosGrupo();
		
		Bundle datos = new Bundle();
		datos.putString("nombre",nombre );
		
		grupo.setArguments(datos);
		
		trans.replace(R.id.container, grupo);
		trans.addToBackStack(null);
		trans.commit();

	}
}
