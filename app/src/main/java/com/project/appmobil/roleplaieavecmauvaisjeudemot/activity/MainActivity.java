package com.project.appmobil.roleplaieavecmauvaisjeudemot.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.project.appmobil.roleplaieavecmauvaisjeudemot.R;
import com.project.appmobil.roleplaieavecmauvaisjeudemot.dataBase.DataBasePJS4;

/**
 * The main class of the application
 */
public class MainActivity extends AppCompatActivity {

	public static DataBasePJS4 db;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Log.i("projet", "Lancement de l'application");

		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		db = new DataBasePJS4(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		Log.i("projet", "lancement de la création d'une nouvelle partie");
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			Log.i("projet", "option");
			Toast.makeText(this, R.string.todo, Toast.LENGTH_SHORT).show();
		}
/*
		if (id == R.id.action_exit) {
			Log.i("projet", "quitter");

			DialogFragment quitDialog = new DialogExit();

			quitDialog.show(getFragmentManager(), "alert");

			return true;
		}*/

		return super.onOptionsItemSelected(item);
	}

	public void newGame(View view) {
		Log.i("projet", "Préparation de l'intent Nouvelle partie");
		Intent intent = new Intent(MainActivity.this, NewGameActivity.class);
		startActivity(intent);
	}

	public void loadGame(View view) {
		Log.i("projet", "Préparation de l'intent Chargement partie");
		Intent intent = new Intent(MainActivity.this, LoadGameActivity.class);
		startActivity(intent);
	}

	public void test(View view) {
		Log.i("projet", "TEST MENU IN GAME");
		Intent intent2 = new Intent(MainActivity.this, InGameMenuActivity.class);
		startActivity(intent2);
	}

	public void test2(View view) {
		Log.i("projet", "TEST CREATION FICHE PERSO");
		Intent intent2 = new Intent(MainActivity.this, PlayerFileCreationActivity.class);
		startActivity(intent2);
	}

	public void test3(View view) {
		Log.i("projet", "TEST FICHE PERSO");
		Intent intent2 = new Intent(MainActivity.this, PlayerFileActivity.class);
		startActivity(intent2);
	}

	public void test4(View view) {
		Log.i("projet", "TEST Dice activity");
		Intent intent2 = new Intent(MainActivity.this, DiceActivity.class);
		startActivity(intent2);
	}
}
