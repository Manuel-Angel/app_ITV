package com.itver.itv.groups;

import java.util.ArrayList;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.itver.itv.R;
import com.itver.itv.model_list_messages.Adapter_List_Members_Groups;
import com.itver.itv.model_list_messages.Contacto;

public class ContactosGrupo extends Fragment implements OnClickListener{

	private TextView nombre_Grupo;
	private ArrayList<Contacto> lista_Grupos;
	private ListView listView;
	private Button mensajeAGrupo;
	private Adapter_List_Members_Groups miembros;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.activity_contactos_grupo, container, false);

		System.out.println("voy bien");
		nombre_Grupo = (TextView) rootView.findViewById(R.id.contactos_grupos_etiq);

		Bundle extras = getArguments();
		String nombre = extras.getString("nombre");

		nombre_Grupo.setText("Grupo\n"+nombre);

		listView = (ListView) rootView.findViewById(R.id.listView_Contactos_Grupos);
		
		lista_Grupos = new ArrayList<Contacto>();

		miembros = new Adapter_List_Members_Groups(this.getActivity(),lista_Grupos);
		listView.setAdapter(miembros);

		int imagen = android.R.drawable.sym_action_chat;

		lista_Grupos.add(new Contacto(imagen, "Jesús Manuel Pérez García"));
		lista_Grupos.add(new Contacto(imagen, "Manuel Ángel Muñoz Solano"));
		lista_Grupos.add(new Contacto(imagen, "Victor Daniel Rebolloso Degante"));
		lista_Grupos.add(new Contacto(imagen, "Ivan Romero García"));
		lista_Grupos.add(new Contacto(imagen, "Anilu del Carmen"));
		lista_Grupos.add(new Contacto(imagen, "Ezequiel Piña Ortiz"));
		
		// Agregando Escuchador al Botón Mensajes.
		mensajeAGrupo = (Button) rootView.findViewById(R.id.button_mensaje_Grupo);
		mensajeAGrupo.setOnClickListener(this);
		return rootView;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button_mensaje_Grupo:
				Toast.makeText(getActivity(), "Enviar Mensaje Presionado", Toast.LENGTH_SHORT).show();
			break;

		default:
			break;
		}
	}

}
