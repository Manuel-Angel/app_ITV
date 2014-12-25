package com.itver.itv.menu;

import com.itver.itv.R;
import com.itver.itv.archivos.Archivos;
import com.itver.itv.groups.Grupos;
import com.itver.itv.messages.Mensajes;
import com.itver.itv.news.Noticias;
import com.itver.itv.perfil.Perfil;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;

public class MenuUserActivity extends Activity implements NavigationDrawerFragment.NavigationDrawerCallbacks {

	private NavigationDrawerFragment mNavigationDrawerFragment;
	
	private static final String TAG_NOTICIAS = "noticias";
	private static final String TAG_MENSAJES = "mensajes";
	private static final String TAG_GRUPOS = "grupos";
	private static final String TAG_ARCHIVOS = "archivos";
	private static final String TAG_PERFIL = "perfil";
	
//	private static final String [] TAGS = {TAG_ARCHIVOS , TAG_GRUPOS , TAG_MENSAJES , TAG_NOTICIAS , TAG_PERFIL};
	
	private CharSequence mTitle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu_user);

		//verificarVista();
		
		mNavigationDrawerFragment = (NavigationDrawerFragment) getFragmentManager().findFragmentById(
				R.id.navigation_drawer);
		mTitle = getTitle();

		mNavigationDrawerFragment.setUp(R.id.navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout));
		
		System.out.println("metodo onCreate principal");
		
	}

	@Override
	public void onNavigationDrawerItemSelected(int position) {
		FragmentManager fragmentManager = getFragmentManager();
		// Las posiciones comienzan de 0.

		Fragment vista = null;
		String tag = "";

		switch (position) {
		case 0:
			vista = new Noticias();
			tag = TAG_NOTICIAS;
			break;
		case 1:
			vista = new Mensajes();
			tag = TAG_MENSAJES;
			break;
		case 2:
			vista = new Grupos();
			tag = TAG_GRUPOS;
			break;
		case 3:
			vista = new Archivos();
			tag = TAG_ARCHIVOS;
			break;
		case 4:
			vista = new Perfil();
			tag = TAG_PERFIL;
			break;
		}
		
		fragmentManager.beginTransaction().replace(R.id.container, vista, tag).commit();
		onSectionAttached(position + 1);
	}

	public void onSectionAttached(int number) {
		switch (number) {
		case 1:
			mTitle = getString(R.string.section1);
			break;
		case 2:
			mTitle = getString(R.string.section2);
			break;
		case 3:
			mTitle = getString(R.string.section3);
			break;
		case 4:
			mTitle = getString(R.string.section4);
			break;
		case 5:
			mTitle = getString(R.string.section5);
			break;
		}
	}

	@SuppressWarnings("deprecation")
	public void restoreActionBar() {
		ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setTitle(mTitle);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		if (!mNavigationDrawerFragment.isDrawerOpen()) {
			getMenuInflater().inflate(R.menu.menu_user, menu);
			restoreActionBar();
			return true;
		}
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
/*
	private void verificarVista() {
		
		FragmentManager fm = getFragmentManager();
		
		for (int i = 0 ; i < TAGS.length ; i++){
			
			Fragment vista = fm.findFragmentByTag(TAGS[i]);
			
			if (vista != null) {
				FragmentTransaction trans = fm.beginTransaction();
				trans.remove(vista).replace(R.id.container, vista, TAGS[i]);
				trans.commit();
				System.out.println("lo encontre !! "+TAGS[i]);
				break;
			}
		}
	}
*/
}
