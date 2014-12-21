package com.itver.itv;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Perfil extends Fragment implements OnClickListener {

	private EditText campo_nombre;
	private EditText campo_pass;
	private Button btn_editar;
	private Button btn_cerrar;
	private Button btn_cambiar;

	public static boolean EDITAR_GUARDAR = false;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.activity_perfil, container, false);

		campo_nombre = (EditText) rootView.findViewById(R.id.perfil_input_Nombre);
		campo_pass = (EditText) rootView.findViewById(R.id.perfil_input_pass);

		campo_nombre.setFocusable(false);
		campo_pass.setFocusable(false);

		btn_editar = (Button) rootView.findViewById(R.id.perfil_Boton_Editar);
		btn_cerrar = (Button) rootView.findViewById(R.id.perfil_Boton_CerrarSesion);
		btn_cambiar = (Button) rootView.findViewById(R.id.perfil_Boton_Cambiar);

		campo_nombre.setText("Nombre Usuario ");
		campo_pass.setText("Contraseña");

		btn_editar.setOnClickListener(this);
		btn_cerrar.setOnClickListener(this);
		btn_cambiar.setOnClickListener(this);

		return rootView;
	}

	@Override
	public void onClick(View v) {

		System.out.println("Se presiono algo");

		switch (v.getId()) {

		case R.id.perfil_Boton_Editar:

			System.out.println("Boton editar");

			if (!EDITAR_GUARDAR) {
				activarCampos();
			} else {
				desactivarCampos();
			}

			break;

		case R.id.perfil_Boton_CerrarSesion:

			System.out.println("Cerrar sesión");
			Intent nuevaApp = new Intent(this.getActivity(), MainActivity.class);
			startActivity(nuevaApp);
			System.exit(0);
			break;

		case R.id.perfil_Boton_Cambiar:
			System.out.println("cambiar...");
			Toast.makeText(getActivity(), "boton Cambiar Presionado", Toast.LENGTH_SHORT).show();
			break;
		}
	}

	private void desactivarCampos() {
		campo_nombre.setFocusable(false);
		campo_pass.setFocusable(false);
		btn_editar.setText("Editar");
		btn_cambiar.setVisibility(View.INVISIBLE);
		EDITAR_GUARDAR = false;
	}

	private void activarCampos() {
		campo_nombre.setFocusable(true);
		campo_nombre.setFocusableInTouchMode(true);

		campo_pass.setFocusable(true);
		campo_pass.setFocusableInTouchMode(true);

		btn_editar.setText("Guardar");
		btn_cambiar.setVisibility(View.VISIBLE);

		EDITAR_GUARDAR = true;
	}
}
