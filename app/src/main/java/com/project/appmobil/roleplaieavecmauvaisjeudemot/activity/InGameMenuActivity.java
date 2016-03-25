package com.project.appmobil.roleplaieavecmauvaisjeudemot.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.project.appmobil.roleplaieavecmauvaisjeudemot.R;
import com.project.appmobil.roleplaieavecmauvaisjeudemot.dataBase.Partie;


/**
 * The main menu in game
 * Created by ZHOU Eric on 01/02/2016.
 */
public class InGameMenuActivity extends Activity {

	private String gameName;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu_in_game);

		Intent intent = getIntent();

		TextView textView = (TextView) findViewById(R.id.game_name);

		Partie p = intent.getExtras().getParcelable(LoadGameActivity.EXTRA_GAMENAME);

		textView.setText(p.getNom());



		Log.i("projet", "lancement du menu in game");
	}

	/**
	 * Changes the activity and show the Dice Activity
	 *
	 * @param view a view
	 */
	public void chooseDice(View view) {
		Log.i("projet", "préparation du choix des dés");
		Intent intent2 = new Intent(InGameMenuActivity.this, DiceActivity.class);
		startActivity(intent2);

	}

	public void miniMap(View view) {
		Log.i("projet", "préparation de a carte du monde");
		Intent intent = new Intent(this, MiniMapActivity.class);
		startActivity(intent);
	}

	public void seeCaractereProfile(View view) {
		Log.i("projet", "affichage de la liste des joueurs");
		Intent intent = new Intent(this, PlayerListActivity.class);
		TextView textView = (TextView) findViewById(R.id.game_name);
		Partie  p = MainActivity.db.getPartietWithName(textView.toString());
		intent.putExtra(LoadGameActivity.EXTRA_GAMENAME, p);
		startActivity(intent);
	}
}
