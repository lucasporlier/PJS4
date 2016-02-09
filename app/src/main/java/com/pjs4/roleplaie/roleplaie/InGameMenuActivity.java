package com.pjs4.roleplaie.roleplaie;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

/**
 * The main menu in game
 * Created by Eric ZHOU on 01/02/2016.
 */
public class InGameMenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_in_game);
        Log.i("projet", "lancement du menu in game");
    }

    /**
     * Choose the dice to launch
     *
     * @param view
     */
    public void chooseDice(View view) {
        Log.i("projet", "préparation du choix des dés");
        Intent intent2 = new Intent(InGameMenuActivity.this, DiceActivity.class);
        startActivity(intent2);

    }
}
