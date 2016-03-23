package com.pjs4.roleplaie.roleplaie.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.pjs4.roleplaie.roleplaie.R;
import com.pjs4.roleplaie.roleplaie.dataBase.Partie;

/**
 * Used by the layout player_file_creation_layout.xml
 * Created by ZHOU Eric on 08/02/2016.
 */
public class PlayerFileCreationActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_file_creation_layout);

        Log.i("projet", "Lancement de la création d'une fiche de personnage");

        Intent intent = getIntent();
        Partie p = intent.getExtras().getParcelable(NewGameActivity2.EXTRA_GAME);




        Log.i("testParcelabel", p.getNom());
        Log.i("testParcelabel", p.getType());
        Log.i("testParcelabel", String.valueOf((p.getNombreJoueur())));
        Log.i("testParcelabel", p.getStat(p.getStatNumber() - 1));

        Log.i("testListGame",p.getListStat().toString());


    }

    /**
     * Add a new line in the table of capacities
     *
     * @param view the view
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
