package com.pjs4.roleplaie.roleplaie;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

/**
 * Used by the layout player_file_creation_layout.xml
 * Created by ZHOU Eric on 08/02/2016.
 */
public class PlayerFileCreationActivity extends Activity {

    public static final String EXTRA_NUMPLAYER = "COM.PJS4.ROLEPLAIE.ROLEPLAIE.NumPlayer";
    public static final String EXTRA_MAXPLAYER = "COM.PJS4.ROLEPLAIE.ROLEPLAIE.MaxPlayer";

    private int numPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_file_creation_layout);
        Log.i("projet", "Lancement de la création d'une fiche de personnage");

        Intent intent = getIntent();
        String gameName = intent.getStringExtra(NewGameActivity.EXTRA_GAMENAME);
        String numberOfPlayer = intent.getStringExtra(NewGameActivity.EXTRA_NUMBEROFPLAYER);
        String gameType = intent.getStringExtra(NewGameActivity.EXTRA_GAMETYPE);

        final int NUMDEPART = 1; //On commence avec la fiche perso du joueur 1

        if(intent.getStringExtra(PlayerFileCreationActivity.EXTRA_NUMPLAYER) != null){ //est ce que ca marche?? A voir
            Log.i("projet", "EXTRA_NUMPLAYER existe, numPLayer prend la valeur suivante");
            numPlayer = Integer.parseInt(intent.getStringExtra(PlayerFileCreationActivity.EXTRA_NUMPLAYER));
        }else{
            Log.i("projet", "EXTRA_NUMPLAYER n'existe pas, numPlayer est initié à 1");
            numPlayer = NUMDEPART;
        }
        TextView title = (TextView)findViewById(R.id.Text_Title);
        title.setText(title.getText() + " " + numPlayer + "/" + numberOfPlayer); //Affiche le titre + le numero du joueur actuel
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

    public void retour(View view){
        this.finish();
    }

    public void suivant(View view){
        //Création d'un objet Personnage où on stocke toute ces données

        Log.i("projet","Préparation de l'intent PlayerFileCreationActivity");
        Intent intent = new Intent(this, PlayerFileCreationActivity.class);
//        Log.i("projet","Récupération de l'EditText ETGameName");
//        EditText gameName = (EditText)findViewById(R.id.ETGameName);
//        Log.i("projet","Récupération de l'EditText ETNbPlayer");
//        EditText nbPlayer = (EditText)findViewById(R.id.ETNbPlayer);
//        Log.i("projet","Récupération de l'EditText ETGameType");
//        EditText gameType = (EditText)findViewById(R.id.ETTypeGame);

//        Log.i("projet","Préparation du putExtra EXTRA_GAMENAME");
//        intent.putExtra(EXTRA_GAMENAME, gameName.getText().toString());
//        Log.i("projet", "Préparation du putExtra EXTRA_NUMBEROFPLAYER");
//        intent.putExtra(EXTRA_NUMBEROFPLAYER, nbPlayer.getText().toString());
//        Log.i("projet", "Préparation du putExtra EXTRA_GAMETYPE");
//        intent.putExtra(EXTRA_GAMETYPE,gameType.getText().toString());
        Log.i("projet", "Préparation du putExtra EXTRA_NUMPLAYER");
        intent.putExtra(EXTRA_NUMPLAYER, numPlayer+1);
        startActivity(intent);

        //Si on arrive à la fin de la création de tout les persos, on les stocke dans la BDD
    }
}
