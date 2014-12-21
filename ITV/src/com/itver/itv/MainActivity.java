package com.itver.itv;


import com.itver.itv.menu.MenuUserActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	private Button btn_ingresar;
	private Button btn_register;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btn_ingresar = (Button) findViewById(R.id.button_SignIn);
		btn_register = (Button) findViewById(R.id.button_Register);

		btn_ingresar.setOnClickListener(this);
		btn_register.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		// Ingresar
		case R.id.button_SignIn:
			changeViewUser(v); // Cambiar vista a usuario registrado.
			break;
		// Registrar
		case R.id.button_Register:
			changeViewRegister(v); // Registrar Usuario.
			break;
		}
	}

	private void changeViewRegister(View v) {
		
	}

	private void changeViewUser(View v) {
		String user = ((EditText) findViewById(R.id.Login_in_User)).getText().toString();
		String pass = ((EditText) findViewById(R.id.Login_in_pass)).getText().toString();
		
		boolean comprobarDatos = test(user , pass);
		
		if(comprobarDatos){
			Intent vista = new Intent(this, MenuUserActivity.class);
			startActivity(vista);
			finish();
		} else {
			Toast.makeText(this,"Datos incompletos", Toast.LENGTH_SHORT).show();
		}
		
	}

	private boolean test(String user, String pass) {
		
		boolean uno = user.compareTo("") == 0;
		boolean dos = pass.compareTo("") == 0;
		
		return (!uno && !dos);
	}
}
