package com.itver.itv;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

public class SplashScreenActivity extends Activity {

	private static final long TIEMPO_DURACION = 1000;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// Pantalla Completa.
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		// Sin barra de Titulo.
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		setContentView(R.layout.activity_splash_screen);
		
		TimerTask tiempo = new TimerTask() {
			
			@Override
			public void run() {
				// Después del tiempo, Iniciar la Actividad Principal remplazando la SplashScreen.
				Intent actividad_Principal = new Intent().setClass(SplashScreenActivity.this, MainActivity.class);
				startActivity(actividad_Principal);
				// Finalizar la Actividad, para que el usuario no pueda regresar a ella.
				finish();
			}
		};
		
		Timer tarea_Tiempo = new Timer();
		tarea_Tiempo.schedule(tiempo, TIEMPO_DURACION);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.splash_screen, menu);
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
}
