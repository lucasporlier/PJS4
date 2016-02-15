package com.pjs4.roleplaie.roleplaie;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by ZHOU Eric on 15/02/2016.
 */
public class MiniMapActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_layout);
        Log.i("projet", "affichage de la carte");
        /*
        Retrouver l'image et l'afficher en plein ecran
        LinearLayout l =(LinearLayout) findViewById(R.id.map_background);
        l.setBackground();
         */


    }


}
