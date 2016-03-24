package com.project.appmobil.roleplaieavecmauvaisjeudemot.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.project.appmobil.roleplaieavecmauvaisjeudemot.R;
import com.project.appmobil.roleplaieavecmauvaisjeudemot.dataBase.Partie;


/**
 Created by ZHOU Eric on 01/02/2016.
 */
public class NewGameActivity extends Activity implements Parcelable{

	public static final String EXTRA_GAME1 = "com.project.appmobil.roleplaieavecmauvaisjeudemot.activity.EXTRA_GAME1";

	public  NewGameActivity(){};

	protected NewGameActivity(Parcel in) {
	}

	public static final Creator<NewGameActivity> CREATOR = new Creator<NewGameActivity>() {
		@Override
		public NewGameActivity createFromParcel(Parcel in) {
			return new NewGameActivity(in);
		}

		@Override
		public NewGameActivity[] newArray(int size) {
			return new NewGameActivity[size];
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.new_game);
		Log.i("projet", "Lancement d'une nouvelel partie");
	}

	@Override
	protected void onPause() {
		super.onPause();


	}

	public void ConfirmNewGame(View view) {
		String gameName = ((TextView) findViewById(R.id.GameNameEdiText)).getText().toString();
		String nbPlayer = ((TextView) findViewById(R.id.NbPlayereditText)).getText().toString();
		String typeGame = ((TextView) findViewById(R.id.TypeGameditText)).getText().toString();
		String nbStat = ((TextView) findViewById(R.id.nbStatEditText)).getText().toString();

		Partie partie = new Partie(gameName,typeGame,Integer.parseInt(nbPlayer),Integer.parseInt(nbStat));

		Intent intent = new Intent(this,NewGameActivity2.class);

		intent.putExtra(EXTRA_GAME1, partie);
		startActivity(intent);

	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
	}
}
