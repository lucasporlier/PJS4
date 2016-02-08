package com.pjs4.roleplaie.roleplaie;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
/**
 Created by ZHOU Eric on 08/02/2016.
 */
public class PlayerFileCreationActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_file_creation_layout);

        Log.i("projet", "Lancement de la création d'une fiche de personnage");
    }
}
