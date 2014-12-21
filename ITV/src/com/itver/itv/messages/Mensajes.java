package com.itver.itv.messages;

import java.util.ArrayList;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.itver.itv.R;
import com.itver.itv.model_list_messages.Adaptador_Mensajes;
import com.itver.itv.model_list_messages.Contacto;

public class Mensajes extends Fragment {

	private ListView listView;
	private ArrayList<Contacto> lista_Grupos;

	private Adaptador_Mensajes adapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		View rootView = inflater.inflate(R.layout.activity_mensajes, container, false);

		listView = (ListView) rootView.findViewById(R.id.Mensajes_ListView);
		lista_Grupos = new ArrayList<Contacto>();

		adapter = new Adaptador_Mensajes(this.getActivity(), lista_Grupos);
		listView.setAdapter(adapter);

		int imagen = android.R.drawable.sym_action_chat;

		lista_Grupos.add(new Contacto(imagen, "Jesús Manuel Pérez García", "11:00 AM", "Hola :)"));
		lista_Grupos.add(new Contacto(imagen, "Manuel Ángel ", "15:30 PM", "Son las 3 : 30"));
		lista_Grupos.add(new Contacto(imagen, "Victor Daniel", "04/12/2014", "Hola mundo !!!"));
		lista_Grupos.add(new Contacto(imagen, "Ivan Romero", "04/12/2014", "Hola nuevo !!!"));
		lista_Grupos.add(new Contacto(imagen, "Anilu del Carmen", "04/12/2014", "Hola !!"));
		lista_Grupos.add(new Contacto(imagen, "ITVer", "04/12/2014", "Hola !!"));
		lista_Grupos.add(new Contacto(imagen, "Ezequiel Piña", "04/12/2014", "Verificando la app proceso de archivos en una linea esperando resultados"));

		return rootView;
	}
}
