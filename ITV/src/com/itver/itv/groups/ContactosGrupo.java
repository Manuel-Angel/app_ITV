package com.itver.itv.groups;

import java.util.ArrayList;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.itver.itv.R;
import com.itver.itv.messages.Mensaje_a_Activity;
import com.itver.itv.model_list_messages.Adapter_List_Members_Groups;
import com.itver.itv.model_list_messages.Contacto;

public class ContactosGrupo extends Fragment implements OnClickListener, OnItemClickListener {

	private TextView nombre_Grupo;
	private ArrayList<Contacto> lista_Grupos;
	private ListView listView;
	private Button mensajeEspecial;
	private Button mensajeAGrupo;
	private Adapter_List_Members_Groups miembros;

	private String nombreGrupo;
	private boolean mensaje_A_Elite = false;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.activity_contactos_grupo, container, false);

		System.out.println("voy bien");
		nombre_Grupo = (TextView) rootView.findViewById(R.id.contactos_grupos_etiq);

		Bundle extras = getArguments();
		nombreGrupo = extras.getString("nombre");

		nombre_Grupo.setText("Grupo\n" + nombreGrupo);

		listView = (ListView) rootView.findViewById(R.id.listView_Contactos_Grupos);
		listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

		lista_Grupos = new ArrayList<Contacto>();

		miembros = new Adapter_List_Members_Groups(this.getActivity(), lista_Grupos);
		listView.setAdapter(miembros);

		listView.setOnItemClickListener(null);

		int imagen = android.R.drawable.sym_action_chat;

		lista_Grupos.add(new Contacto(imagen, "Jesús Manuel Pérez García"));
		lista_Grupos.add(new Contacto(imagen, "Manuel Ángel Muñoz Solano"));
		lista_Grupos.add(new Contacto(imagen, "Victor Daniel Rebolloso Degante"));
		lista_Grupos.add(new Contacto(imagen, "Ivan Romero García"));
		lista_Grupos.add(new Contacto(imagen, "Anilu del Carmen"));
		lista_Grupos.add(new Contacto(imagen, "Ezequiel Piña Ortiz"));

		// Agregando Escuchador al Botón Mensajes.
		mensajeEspecial = (Button) rootView.findViewById(R.id.button_mensaje_Grupo);
		mensajeEspecial.setOnClickListener(this);

		mensajeAGrupo = (Button) rootView.findViewById(R.id.boton_Mensaje_Enviar);
		mensajeAGrupo.setOnClickListener(this);

		ActionBar barra = getActivity().getActionBar();
		barra.setTitle("Grupo " + nombreGrupo);

		return rootView;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button_mensaje_Grupo:

			if (!mensaje_A_Elite) {

				Toast.makeText(getActivity(), "Seleccione los Integrantes", Toast.LENGTH_SHORT).show();
				mensaje_A_Elite = true;
				mensajeEspecial.setText("Conversar");
				listView.setOnItemClickListener(this);

			} else {
				
				listView.setOnItemClickListener(null);
				String elite = mostrarSeleccionados();
				reiniciar();
				
				if(!elite.equals("")){
					crearConversacion(elite);
				}
				mensajeEspecial.setText("Mensaje a...");
				mensaje_A_Elite = false;
			}

			break;

		case R.id.boton_Mensaje_Enviar:
			Toast.makeText(getActivity(), "Mensaje a todo el grupo", Toast.LENGTH_SHORT).show();
			crearConversacion(nombreGrupo);
			break;
		}
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

		SparseBooleanArray seleccionados = listView.getCheckedItemPositions();

		Toast.makeText(getActivity(), "Posicion " + position, Toast.LENGTH_SHORT).show();

		view.setBackgroundColor(Color.WHITE);

		for (int i = 0; i < parent.getChildCount(); i++) {
			if (!seleccionados.valueAt(i)) {
				//parent.getChildAt(i).setBackgroundColor(Color.rgb(76, 146, 76));
				parent.getChildAt(i).setSelected(false);
				seleccionados.put(i, false);
			}
		}

	}

	public String mostrarSeleccionados() {

		SparseBooleanArray seleccionados = listView.getCheckedItemPositions();

		String elite = "";

		for (int i = 0; i < seleccionados.size(); i++) {
			if (seleccionados.valueAt(i)) {
				System.out.println("Seleccionado " + lista_Grupos.get(i).getNombre());
				elite += lista_Grupos.get(i).getNombre() + ",";
			}
		}

		Toast.makeText(getActivity(), "Enviar Mensaje Presionado \n" + elite, Toast.LENGTH_SHORT).show();

		return elite;
	}

	public void crearConversacion(String nombres) {

		FragmentManager fm = getFragmentManager();
		FragmentTransaction trans = fm.beginTransaction();

		Mensaje_a_Activity conversacion = new Mensaje_a_Activity();

		Bundle datos = new Bundle();
		datos.putString("nombre", nombres);

		conversacion.setArguments(datos);

		trans.replace(R.id.container, conversacion);
		trans.addToBackStack(null);
		trans.commit();
	}

	public void reiniciar() {
		SparseBooleanArray seleccionados = listView.getCheckedItemPositions();

		for (int i = 0; i < seleccionados.size(); i++) {
			seleccionados.put(i, false);
		}
	}
}
