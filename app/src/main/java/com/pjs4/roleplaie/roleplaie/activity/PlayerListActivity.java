package com.pjs4.roleplaie.roleplaie.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.pjs4.roleplaie.roleplaie.R;
import com.pjs4.roleplaie.roleplaie.dataBase.DataBasePJS4;
import com.pjs4.roleplaie.roleplaie.dataBase.Joueur;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZHOU Eric on 21/03/2016.
 *
 * Used for the gestion of the player list activity
 */

public class PlayerListActivity extends Activity {
	private static final String EXTRA_PLAYER_NAME = "com.pjs4.roleplaie.roleplaie.EXTRA_PLAYER_NAME";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_player_on_this_game);

		ListView listPlayer = (ListView) findViewById(R.id.list_of_players);

		DataBasePJS4 db = new DataBasePJS4(this);

		List<Joueur> list_joueur = db.getAllPlayer(LoadGameActivity.EXTRA_GAME_NAME);

		List<String> list_player_name = new ArrayList<>();

		for (Joueur j : list_joueur){
			list_player_name.add(j.getNom());
		}

		ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list_player_name);
		listPlayer.setAdapter(listAdapter);

		listPlayer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				String chosenPlayerName = String.valueOf(parent.getItemAtPosition(position));
				Intent intent = new Intent(PlayerListActivity.this, PlayerFileActivity.class);
				intent.putExtra(EXTRA_PLAYER_NAME,chosenPlayerName);
				startActivity(intent);
			}
		});

	}
}