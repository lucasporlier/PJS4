package com.project.appmobil.roleplaieavecmauvaisjeudemot.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.project.appmobil.roleplaieavecmauvaisjeudemot.R;
import com.project.appmobil.roleplaieavecmauvaisjeudemot.dataBase.Joueur;
import com.project.appmobil.roleplaieavecmauvaisjeudemot.dataBase.Objet;

import java.util.List;

/**
 * Created by nivet on 23/03/2016.
 */
public class InventoryActivity extends AppCompatActivity {
    public static final String EXTRA_NOMPRO = "com.project.appmobil.roleplaieavecmauvaisjeudemot.activity.EXTRA_NOMPRO";
    public static final String EXTRA_NOMOBJET = "com.project.appmobil.roleplaieavecmauvaisjeudemot.activity.EXTRA_NOMOBJET";
    private Joueur joueur;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inventory);
         joueur = getIntent().getParcelableExtra(PlayerFileActivity.EXTRA_NOMPROP);
        ListView lv = (ListView) findViewById(R.id.listObjectView);
        List<Objet> objets = MainActivity.db.getObjetWithNomPro(joueur.getNom());

        if (objets.isEmpty()){
            TextView tv = (TextView) findViewById(R.id.invenrotyTitle);
            tv.setText(tv.getText() + "\n\n" + getString(R.string.inventory_is_empty));
        }else{

            ObjetArrayAdapter adapter = new ObjetArrayAdapter(this, objets);
            ListView objetView = (ListView) findViewById(R.id.listObjectView);
            objetView.setAdapter(adapter);

            objetView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(final AdapterView<?> parent, View view, final int position, long id) {
                PopupMenu popupMenu = new PopupMenu(InventoryActivity.this, view);

                popupMenu.getMenuInflater().inflate(R.menu.inventory_pop_up_menu, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                    // Toast.makeText(InventoryActivity.this, "You Clicked : " + (parent.getItemAtPosition(position)), Toast.LENGTH_SHORT).show();
                    if (item.getItemId() == R.id.add) {
                        Intent intent = new Intent(InventoryActivity.this, AddItemActivity.class);

                        intent.putExtra(EXTRA_NOMOBJET, String.valueOf(parent.getItemAtPosition(position)));
                        intent.putExtra(EXTRA_NOMPRO, joueur.getNom());

                        Log.i("projet", "NOM : " + String.valueOf(parent.getItemAtPosition(position) + "  Proprietaire : " + joueur.getNom()));

                        startActivity(intent);
                    }

                    if(item.getItemId() ==R.id.use){
                        Intent intent = new Intent(InventoryActivity.this, UseItemActivity.class);

                        intent.putExtra(EXTRA_NOMOBJET, String.valueOf(parent.getItemAtPosition(position)));
                        intent.putExtra(EXTRA_NOMPRO, joueur.getNom());

                        Log.i("projet", "NOM : " + String.valueOf(parent.getItemAtPosition(position) + "  Proprietaire : " + joueur.getNom()));

                                startActivity(intent);
                    }

                    return true;
                    }
                });

                    popupMenu.show();
                }
            });

        }
    }

    public void newObjet(View view) {
        Intent intent = new Intent(this,AddObjetActivity.class);

        intent.putExtra(EXTRA_NOMPRO,joueur.getNom());
        startActivity(intent);
    }


    public void back(View view) {
        Intent intent = new Intent(this, PlayerFileActivity.class);
        intent.putExtra(PlayerListActivity.EXTRA_PLAYER_NAME, joueur);

        startActivity(intent);

    }
}
