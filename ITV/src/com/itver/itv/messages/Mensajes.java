package com.itver.itv.messages;

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
import com.itver.itv.model_list_messages.Adaptador_Mensajes;
import com.itver.itv.model_list_messages.Contacto;

public class Mensajes extends Fragment implements OnItemClickListener {
	
	public static final String TAG_MENSAJE_SELECCIONADO = "mensaje_seleccionado";
	
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
		
		listView.setOnItemClickListener(this);

		int imagen = android.R.drawable.sym_action_chat;

		lista_Grupos.add(new Contacto(imagen, "Jesús Manuel Pérez García", "11:00 AM", "Hola :)"));
		lista_Grupos.add(new Contacto(imagen, "Manuel Ángel ", "15:30 PM", "Son las 3 : 30"));
		lista_Grupos.add(new Contacto(imagen, "Victor Daniel", "04/12/2014", "Hola mundo !!!"));
		lista_Grupos.add(new Contacto(imagen, "Ivan Romero", "04/12/2014", "Hola nuevo !!!"));
		lista_Grupos.add(new Contacto(imagen, "Anilu del Carmen", "04/12/2014", "Hola !!"));
		lista_Grupos.add(new Contacto(imagen, "ITVer", "04/12/2014", "Hola !!"));
		lista_Grupos.add(new Contacto(imagen, "Ezequiel Piña", "04/12/2014", "Verificando la app proceso de archivos en una linea esperando resultados"));

		ActionBar barra = getActivity().getActionBar();
		barra.setTitle("Mensajes");

		tieneMensajeSeleccionado();
		
		return rootView;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		
		Contacto persona = lista_Grupos.get(position);
		
		FragmentManager fm = getFragmentManager();
		FragmentTransaction trans = fm.beginTransaction();
		
		Mensaje_a_Activity conversacion = new Mensaje_a_Activity();
		
		Bundle datos = new Bundle();
		datos.putString("nombre", persona.getNombre());
		datos.putString("mensaje", persona.getCuerpo_Mensaje());
		
		conversacion.setArguments(datos);
		
		trans.replace(R.id.container, conversacion, TAG_MENSAJE_SELECCIONADO);
		trans.addToBackStack(null);
		trans.commit();
	}
	
	private void tieneMensajeSeleccionado(){
		FragmentManager fm = getFragmentManager();
		Fragment mensajeSeleccionado = fm.findFragmentByTag(TAG_MENSAJE_SELECCIONADO);
		
		if(mensajeSeleccionado != null){
			FragmentTransaction trans = fm.beginTransaction();
			trans.remove(mensajeSeleccionado).replace(R.id.container, mensajeSeleccionado, TAG_MENSAJE_SELECCIONADO);
			trans.commit();
		}
	}
}
