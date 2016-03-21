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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_game);
        Log.i("projet", "Lancement d'une nouvelle partie");
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    public void confirmNewGame1(View v){
        String game_name = ((EditText) findViewById(R.id.game_name)).getText().toString();
        String game_type = ((EditText) findViewById(R.id.game_type)).getText().toString();
        int player_nbre = Integer.parseInt(((EditText) findViewById(R.id.player_number)).getText().toString());
        int stat_nbre = Integer.parseInt(((EditText) findViewById(R.id.stat_number)).getText().toString());

        Game game = new Game(game_name, player_nbre, stat_nbre, game_type);
        Intent intent = new Intent(this, NewGameActivity2.class);
        intent.putExtra("game",game);
        startActivity(intent);
    }
}
