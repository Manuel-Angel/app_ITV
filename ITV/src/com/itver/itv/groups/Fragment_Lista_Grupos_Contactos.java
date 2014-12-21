package com.itver.itv.groups;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

@SuppressWarnings("unused")
public class Fragment_Lista_Grupos_Contactos extends ListFragment {

	private Callbacks mCallbacks = CallbacksVacios;

	public interface Callbacks {
		public void onEntradaSelecionada(String id);
	}

	private static Callbacks CallbacksVacios = new Callbacks() {
		@Override
		public void onEntradaSelecionada(String id) {
		}
	};

	public Fragment_Lista_Grupos_Contactos() {

	}
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
//		setListAdapter(new Adapter_List_Members_Groups (getActivity(), R.layout.model_list_grupo , Lista_contenido.ENTRADAS_LISTA);
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);

		if (!(activity instanceof Callbacks)) {
			throw new IllegalStateException("Error: La actividad debe implementar el callback del fragmento");
		}

		mCallbacks = (Callbacks) activity;
	}

	@Override
	public void onDetach() {
		super.onDetach();
		mCallbacks = CallbacksVacios;
	}

	@Override
	public void onListItemClick(ListView listView, View view, int posicion, long id) {
		super.onListItemClick(listView, view, posicion, id);
		//mCallbacks.onEntradaSelecionada(Lista_contenido.ENTRADAS_LISTA.get(posicion).id);
	}

}
