package com.itver.itv;

import android.app.ActionBar;
import android.app.ActionBar.LayoutParams;
import android.app.Fragment;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class Mensaje_a_Activity extends Fragment implements OnClickListener {

	private ViewGroup layout;
	private ScrollView scrollView;
	private EditText mensaje_texto;
	
	private String nombre;
//	private String mensaje_emisor;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.activity_mensaje_a_, container, false);
		
		layout = (ViewGroup) rootView.findViewById(R.id.Layout_Mensajes);
		scrollView = (ScrollView) rootView.findViewById(R.id.scrollConversacion);

		Button izq = (Button) rootView.findViewById(R.id.buttonX);
		Button yo = (Button) rootView.findViewById(R.id.boton_Mensaje_Enviar);

		mensaje_texto = (EditText) rootView.findViewById(R.id.Mensaje_Salida_Enviar);
		
		izq.setOnClickListener(this);
		yo.setOnClickListener(this);
		
		Bundle extras = getArguments();
		nombre = extras.getString("nombre");
//		mensaje_emisor = extras.getString("mensaje");
		
		ActionBar barra = getActivity().getActionBar();
		barra.setTitle(nombre);
		
		return rootView;
	}

	@Override
	public void onClick(View v) {

		if(mensaje_texto.getText().toString().equals("")){
			return;
		}
		
		switch (v.getId()) {
		case R.id.buttonX:
			agregarIzq();
			break;
		case R.id.boton_Mensaje_Enviar:
			agregarDer();
			break;
		}
	}

	private void agregarIzq() {
		agregarMensaje(false);
	}

	private void agregarDer() {
		agregarMensaje(true);
	}

	private void agregarMensaje(boolean lado) {
		// Si lado == falso ... el mensaje va a Izq
		// Si lado == true ... el mensaje va a Der
		LayoutInflater inflater = LayoutInflater.from(getActivity());

		int id = R.layout.mensaje_derecha_user;

		if (lado) {
			id = R.layout.mensaje_izquierda;
		}

		LinearLayout mensaje = (LinearLayout) inflater.inflate(id, null, false);

		TextView textView = (TextView) mensaje.findViewById(R.id.Mensaje_Envio_Cuerpo);
		textView.setText(mensaje_texto.getText().toString());
		
		TextView emisor = (TextView) mensaje.findViewById(R.id.Mensaje_Emisor);
		emisor.setText(nombre);
		
		TextView fecha = (TextView) mensaje.findViewById(R.id.hora);
		fecha.setText("06:27 p.m");

		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

		if (lado) {
			params.gravity = Gravity.RIGHT;
		}
		
		params.topMargin = 15;
		mensaje.setPadding(5, 3, 5, 3);
		mensaje.setLayoutParams(params);

		layout.addView(mensaje);

		// scroll to last element
		scrollView.post(new Runnable() {
			public void run() {
				scrollView.fullScroll(ScrollView.FOCUS_DOWN);
			}
		});
		
		mensaje_texto.setText("");
	}
}
