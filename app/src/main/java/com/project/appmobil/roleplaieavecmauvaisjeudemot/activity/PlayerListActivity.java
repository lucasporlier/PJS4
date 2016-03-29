package com.project.appmobil.roleplaieavecmauvaisjeudemot.activity;

        import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.project.appmobil.roleplaieavecmauvaisjeudemot.R;
import com.project.appmobil.roleplaieavecmauvaisjeudemot.dataBase.Joueur;
import com.project.appmobil.roleplaieavecmauvaisjeudemot.dataBase.Partie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZHOU Eric on 21/03/2016.
 *
 * Used for the gestion of the player list activity
 */

public class PlayerListActivity extends Activity {

    public static final String EXTRA_PLAYER_NAME = "com.pjs4.roleplaie.roleplaie.EXTRA_PLAYER_NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_player_on_this_game);

        ListView listPlayer = (ListView) findViewById(R.id.list_of_players);

        Intent intent = getIntent();

        Partie p = intent.getParcelableExtra(InGameMenuActivity.EXTRA_NOMPARTIE);

        List<Joueur> list_joueur = MainActivity.db.getJoueurWithNomPartie(p.getNom());

        List<String> list_player_name = new ArrayList<>();

        for (Joueur j : list_joueur){
            list_player_name.add(j.getNom());
        }

        ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list_player_name);
        listPlayer.setAdapter(listAdapter);

        listPlayer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String chosenPlayerName = String.valueOf(parent.getItemAtPosition(position));
                Joueur j = MainActivity.db.getJoueurWithName(chosenPlayerName);
                Intent intent = new Intent(PlayerListActivity.this, PlayerFileActivity.class);
                intent.putExtra(EXTRA_PLAYER_NAME,j);
                startActivity(intent);
            }
        });

    }
}