package com.pjs4.roleplaie.roleplaie;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
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

    /**
     Add a new capacity line in the table
     @param view
     */
    public void moreCapacity(View view) {
        Log.i("projet", "Ajout d'une nouelle ligne");
        TableLayout tbL = (TableLayout) findViewById(R.id.capacitiesTable);

        EditText ed1 = new EditText(this);
        ed1.setHint("Name");

        EditText ed2 = new EditText(this);
        ed2.setHint("Description");

        TableRow tr = new TableRow(this);
        tr.addView(ed1);
        tr.addView(ed2);

        tbL.addView(tr);

        Log.i("projet", "Ligne ajoutée");

    }
}
