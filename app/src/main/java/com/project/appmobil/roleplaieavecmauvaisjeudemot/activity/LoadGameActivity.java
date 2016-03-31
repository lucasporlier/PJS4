package com.project.appmobil.roleplaieavecmauvaisjeudemot.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.project.appmobil.roleplaieavecmauvaisjeudemot.R;
import com.project.appmobil.roleplaieavecmauvaisjeudemot.dataBase.DataBasePJS4;
import com.project.appmobil.roleplaieavecmauvaisjeudemot.dataBase.Partie;

import java.util.ArrayList;
import java.util.List;

/**
 * Used by the layout load_game_layout.xml
 * <p/>
 * Created by ZHOU Eric on 21/03/2016.
 * <p/>
 *
 * @see Partie
 */
public class LoadGameActivity extends Activity {


    public static final String EXTRA_GAMENAME = "COM.PJS4.ROLEPLAIE.ROLEPLAIE.GameName";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.load_game_layout);

        Log.i("projet", "Récupération de la base de données");


        ListView lisGames = (ListView) findViewById(R.id.list_game);

        Log.i("projet", "REMPLISSAGE DE LA LISTE");
        fillGameList(lisGames);
    }

    /**
     * Fills a list with all games names
     *
     * @param listViewGames the listView
     */
    private void fillGameList(ListView listViewGames) {
        Log.i("projet", "DEBUT DU REMPLISSAGE DE LA LISTE");
        DataBasePJS4 base = MainActivity.db;
        Log.i("projet", "Récupération des données");
        List<Partie> listGames = base.getAllGames();
        Log.i("projet", "Terminée" + listGames.toString());

        if (!listGames.isEmpty()) {
            List<String> listGamesName = new ArrayList<>();

            // list adapter have to be changed
            for (Partie p : listGames) {
                listGamesName.add(p.getNom());
            }

            Log.i("projet", "Ajout de l'adapter");
            ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listGamesName);

            listViewGames.setAdapter(listAdapter);
            Log.i("projet", "Ajout de listener");

            listViewGames.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(final AdapterView<?> parent, View view, final int position, long id) {


                    PopupMenu popupMenu = new PopupMenu(LoadGameActivity.this, view);

                    popupMenu.getMenuInflater().inflate(R.menu.list_games_pop_up_menu, popupMenu.getMenu());

                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        public boolean onMenuItemClick(MenuItem item) {

                            if (item.getItemId() == R.id.play) {
                                Log.i("projet", "Cliqué sur un item");
                                String chosenGame = String.valueOf(parent.getItemAtPosition(position));

                                Partie p = MainActivity.db.getPartieWithName(chosenGame);

                                Intent intent = new Intent(LoadGameActivity.this, InGameMenuActivity.class);
                                intent.putExtra(EXTRA_GAMENAME, p);
                                startActivity(intent);
                            }

                            if (item.getItemId() == R.id.delete) {

                                String chosenGame = String.valueOf(parent.getItemAtPosition(position));

                                MainActivity.db.removePartiWithName(chosenGame);

                                Toast.makeText(LoadGameActivity.this, "Deleted", Toast.LENGTH_SHORT).show();

                                LoadGameActivity.this.recreate();

                            }

                            return true;
                        }
                    });

                    popupMenu.show();
                }
            });


            Log.i("projet", "FIN DU REMPLISSAGE DE LA LISTE");
            Log.i("projet", base.getAllPlayer().toString());

        } else {
            TextView textView = (TextView) findViewById(R.id.title_loag_game);
            textView.setText(textView.getText() + "\n\n" + getResources().getString(R.string.no_game_saved));
        }

    }
}


