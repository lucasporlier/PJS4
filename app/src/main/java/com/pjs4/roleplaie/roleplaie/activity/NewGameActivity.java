package com.pjs4.roleplaie.roleplaie.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.pjs4.roleplaie.roleplaie.R;

/**
 Created by ZHOU Eric on 01/02/2016.
 */
public class NewGameActivity extends Activity{

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
}
