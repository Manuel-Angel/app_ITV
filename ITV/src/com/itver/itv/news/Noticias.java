package com.itver.itv.news;

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
import android.widget.Toast;

import com.itver.itv.R;
import com.itver.itv.model_list_news.Adaptador_Noticias;
import com.itver.itv.model_list_news.Noticia;

public class Noticias extends Fragment implements OnItemClickListener {

	private ArrayList<Noticia> lista_Noticias;
	private ListView listView;
	private Adaptador_Noticias noticias;
	private static String notic = "En el marco de la semana cultural del ITV, y con el propósito de promover el hábito  de la lectura en los estudiantes, personal Administrativo y  docentes de esta institución, se llevó a cabo este jueves 21 de noviembre el Segundo Maratón de Lectura en Voz Alta  “Cuentos Chicos, Para Pensar en Grande”, en el sombreadero central de este Instituto Tecnológico. Ante la respetable presencia de autoridades escolares, jefes de Departamentos y estudiantes,  la Ing. Gabriela Clavel Martínez, Subdirectora de Planeación inauguró el Maratón ”Lectura en Voz Alta” en donde mencionó  la importancia del evento ya que la dosis de cultura enmarca fundamentos integrales en el aprendizaje de los jóvenes y es muy enriquecedora para la Institución, y  para ellos mismos. La participación se desarrolló bajo la temática siguiente:  lectura de un cuento, tema abierto,  con una duración no mayor a 5 minutos, ya sea de la propia autoría del participante, o de algún otro autor.  El evento académico, organizado por el Departamento de Actividades Extraescolares , fue todo un éxito ya que contaron con la participación, no tan sólo de alumnos de distintos semestres y especialidades, sino también de catedráticos del ITV,  los cuales contaron grandes historias, cuya colaboración ayudó a que dicho evento fuera ameno y de gran valor para los asistentes.";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.activity_noticias, container, false);

		listView = (ListView) rootView.findViewById(R.id.listView_Noticias);

		lista_Noticias = new ArrayList<Noticia>();

		noticias = new Adaptador_Noticias(this.getActivity(), lista_Noticias);
		listView.setAdapter(noticias);

		int imagen = R.drawable.itver;
		// int imagen = android.R.drawable.ic_dialog_info;
		// int imagen = android.R.drawable.stat_sys_warning;

		lista_Noticias.add(new Noticia(imagen, "Instituto Tecnológico de Veracruz", "A toda la comunidad estudiantil",
				"Fecha : 14-12-2014", "Primera noticia en el mundo de la interfaz !!"));
		lista_Noticias.add(new Noticia(imagen, "Instituto Tecnológico de Veracruz", "A toda la comunidad estudiantil",
				"Fecha : 14-12-2014", notic));
		lista_Noticias.add(new Noticia(imagen, "Jesus Manuel Pérez García", "Título de Noticia", "Fecha : 14-12-2014",
				"Segunda noticia en el mundo de la interfaz !!"));
		lista_Noticias.add(new Noticia(imagen, "Manuel Ángel Muñoz Solano", "Ejemplo 2 de Noticia",
				"Fecha : 14-12-2014", "Tercera noticia en el mundo de la interfaz !!"));
		lista_Noticias.add(new Noticia(imagen, "Victor Daniel Rebolloso Degante", "Ejemplo 3 de Noticia",
				"Fecha : 14-12-2014", "Cuarda noticia en el mundo de la interfaz vas bien, vas bien !!"));
		lista_Noticias.add(new Noticia(imagen, "Ivan Romero García", "Ejemplo 4 de Noticia", "Fecha : 14-12-2014",
				"Quinta noticia en el mundo de la interfaz esto esta que arde !!"));
		lista_Noticias.add(new Noticia(imagen, "Ezequiel Piña Ortiz", "Ejemplo 5 de Noticia", "Fecha : 14-12-2014",
				"Sexta noticia en el mundo de la interfaz esto esta que arde !! increíble todo esto vamos bien :)"));

		listView.setOnItemClickListener(this);

		return rootView;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

		Toast.makeText(getActivity(), "Presionado posicion : " + position, Toast.LENGTH_SHORT).show();

		String titulo = lista_Noticias.get(position).getTitulo_Noticia();
		String mensaje = lista_Noticias.get(position).getCuerpo_Mensaje();
		String autor = lista_Noticias.get(position).getAutor();
		String fecha = lista_Noticias.get(position).getFecha();
		int imagen = lista_Noticias.get(position).getImagen();

		FragmentManager fm = getFragmentManager();
		FragmentTransaction trans = fm.beginTransaction();

		Noticia_Completa noticia = new Noticia_Completa();

		Bundle datos = new Bundle();

		datos.putString("titulo", titulo);
		datos.putString("mensaje", mensaje);
		datos.putString("autor", autor);
		datos.putString("fecha", fecha);
		datos.putInt("imagen", imagen);

		noticia.setArguments(datos);

		trans.replace(R.id.container, noticia);
		trans.addToBackStack(null);
		trans.commit();

	}
}
