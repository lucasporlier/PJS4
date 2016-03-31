package com.project.appmobil.roleplaieavecmauvaisjeudemot.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.project.appmobil.roleplaieavecmauvaisjeudemot.R;
import com.project.appmobil.roleplaieavecmauvaisjeudemot.dataBase.Partie;

import java.util.ArrayList;

/**
 * Used by the activity content_new_game2.xml
 * Operates the capacities
 *
 * Created by Edouard Nivet
 *
 * @see NewGameActivity
 * @see PlayerFileCreationActivity
 */
public class NewGameActivity2 extends Activity {
	public static final String EXTRA_GAME = "com.project.appmobil.roleplaieavecmauvaisjeudemot.activity.EXTRA_GAME";
	private Partie game;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.content_new_game2);


		game = getIntent().getExtras().getParcelable(NewGameActivity.EXTRA_GAME1);

		ListView statView = (ListView) findViewById(R.id.listStatView);
		ArrayList<String> s = new ArrayList<>();

		for (int i = 1; i <= game.getStatNumber(); i++) {
			s.add(i-1,"Caracteristique " + i);
		}

		StatArrayAdapter adapter = new StatArrayAdapter(this, s);

		statView.setAdapter(adapter);
	}

	/**
	 * Confirms the list of capacities
	 *
	 * @param v a view
	 */
	public void confirmNewGame2(View v){

		ListView statView = (ListView) findViewById(R.id.listStatView);

		ListAdapter listAdapter = statView.getAdapter();
		if(listAdapter == null){
			return;
		}

		for(int i = 0; i < game.getStatNumber(); i++) {
			//statView.findViewById(i);
			String string = String.valueOf(listAdapter.getItem(i));
			if(string != null){
				game.addStat(i, string);
			}
			else{
				Toast.makeText(this, R.string.please_comp_all_fielsd, Toast.LENGTH_LONG).show();
				return;
			}
		}



		Log.i("projet", "lancement de PlayerFileCreation");
		Intent intent = new Intent(this, PlayerFileCreationActivity.class);
		intent.putExtra(EXTRA_GAME, game);
		startActivity(intent);
	}
}
