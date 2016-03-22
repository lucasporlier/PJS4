package com.pjs4.roleplaie.roleplaie.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.pjs4.roleplaie.roleplaie.R;
import com.pjs4.roleplaie.roleplaie.dataBase.DataBasePJS4;
import com.pjs4.roleplaie.roleplaie.dataBase.Partie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZHOU Eric on 21/03/2016.
 *
 * Activity
 *
 */
public class LoadGameActivity extends Activity {

	public static final String EXTRA_GAME_NAME = "com.pjs4.roleplaie.roleplaie.EXTRA_GAME_NAME";
	DataBasePJS4 db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.load_game_layout);

		Log.i("projet", "Récupération de la base de données");


		ListView lisGames = (ListView) findViewById(R.id.list_game);

		Log.i("projet", "REMPLISSAGE DE LA LISTE");
		fillGameList(lisGames);
	}

	private void fillGameList(ListView listViewGames) {
		Log.i("projet", "DEBUT DU REMPLISSAGE DE LA LISTE");
		db = new DataBasePJS4(this);
		Log.i("projet", "Récupération des données");
		List<Partie> listGames =  db.getAllGames();
		Log.i("projet", "Terminée" + listGames.toString());
		List<String> listGamesName = new ArrayList<>();

		// list adapter have to be changed
		for (Partie p : listGames){
			listGamesName.add(p.getNom());
		}

		Log.i("projet", "Ajout de l'adapter");
		ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listGamesName);

		listViewGames.setAdapter(listAdapter);
		Log.i("projet", "Ajout de listener");
		listViewGames.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Log.i("projet", "Cliqué dsur un item");
				String chosenGame = String.valueOf(parent.getItemAtPosition(position));
				Intent intent = new Intent(LoadGameActivity.this, InGameMenuActivity.class);
				intent.putExtra(EXTRA_GAME_NAME, chosenGame);
				startActivity(intent);
			}
		});

		Log.i("projet", "FIN DU REMPLISSAGE DE LA LISTE");
	}
}
