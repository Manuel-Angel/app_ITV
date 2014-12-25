package com.itver.itv.groups;

import java.util.ArrayList;

import android.app.ActionBar;
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

public class Grupos extends Fragment implements OnItemClickListener {

	public static final String TAG_GRUPO_SELECCIONADO = "grupo_seleccionado";
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
		
		lista_Grupos.add(new Grupo(imagen, "Simulaci�n"));
		lista_Grupos.add(new Grupo(imagen, "Ingenier�a de software"));
		lista_Grupos.add(new Grupo(imagen, "Desarrollo Sustentable"));
		lista_Grupos.add(new Grupo(imagen, "POO"));
		lista_Grupos.add(new Grupo(imagen, "Taller de Base de Datos"));
		lista_Grupos.add(new Grupo(imagen, "Fundamentos de Base de Datos"));
		lista_Grupos.add(new Grupo(imagen, "Principios El�ctricos"));
		lista_Grupos.add(new Grupo(imagen, "Arquitectura de Computadoras"));
		
		ActionBar barra = getActivity().getActionBar();
		barra.setTitle("Grupos");
		
		tieneGrupoSeleccionado();
		
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
		
		trans.replace(R.id.container, grupo,TAG_GRUPO_SELECCIONADO);
		trans.addToBackStack(null);
		trans.commit();

	}
	
	private void tieneGrupoSeleccionado(){
		FragmentManager fm = getFragmentManager();
		Fragment grupoSeleccionado = fm.findFragmentByTag(TAG_GRUPO_SELECCIONADO);
		
		if(grupoSeleccionado != null){
			FragmentTransaction trans = fm.beginTransaction();
			trans.remove(grupoSeleccionado).replace(R.id.container, grupoSeleccionado, TAG_GRUPO_SELECCIONADO);
			trans.commit();
		}
	}
}
