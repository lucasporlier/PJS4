package com.pjs4.roleplaie.roleplaie;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

/**
 Created by ZHOU Eric on 01/02/2016.
 */
public class NewGameActivity extends Activity{

    public static final String EXTRA_GAMENAME = "COM.PJS4.ROLEPLAIE.ROLEPLAIE.GameName";
    public static final String EXTRA_NUMBEROFPLAYER = "COM.PJS4.ROLEPLAIE.ROLEPLAIE.NumberOfPlayer";
    public static final String EXTRA_GAMETYPE = "COM.PJS4.ROLEPLAIE.ROLEPLAIE.GameType";


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

    public void createGame(View view){
        Log.i("projet","Préparation de l'intent PlayerFileCreationActivity");
        Intent intent = new Intent(NewGameActivity.this,PlayerFileCreationActivity.class);
        Log.i("projet","Récupération de l'EditText ETGameName");
        EditText gameName = (EditText)findViewById(R.id.ETGameName);
        Log.i("projet","Récupération de l'EditText ETNbPlayer");
        EditText nbPlayer = (EditText)findViewById(R.id.ETNbPlayer);
        Log.i("projet","Récupération de l'EditText ETGameType");
        EditText gameType = (EditText)findViewById(R.id.ETTypeGame);

        Log.i("projet","Préparation du putExtra EXTRA_GAMENAME");
        intent.putExtra(EXTRA_GAMENAME, gameName.getText().toString());
        Log.i("projet", "Préparation du putExtra EXTRA_NUMBEROFPLAYER");
        intent.putExtra(EXTRA_NUMBEROFPLAYER, nbPlayer.getText().toString());
        Log.i("projet", "Préparation du putExtra EXTRA_GAMETYPE");
        intent.putExtra(EXTRA_GAMETYPE,gameType.getText().toString());
        startActivity(intent);
    }
}
