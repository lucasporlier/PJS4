package com.project.appmobil.roleplaieavecmauvaisjeudemot.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.project.appmobil.roleplaieavecmauvaisjeudemot.R;
import com.project.appmobil.roleplaieavecmauvaisjeudemot.dataBase.Objet;

import java.util.List;

/**
 * Created by nivet on 23/03/2016.
 */
public class InventoryActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inventory);
        String joueur = getIntent().getStringExtra(PlayerFileActivity.EXTRA_NOMPROP);
        ListView lv = (ListView) findViewById(R.id.listObjectView);
        List<Objet> objets = MainActivity.db.getObjetWithNomPro(joueur);

        ObjetArrayAdapter adapter = new ObjetArrayAdapter(this, objets);
        ListView objetView = (ListView) findViewById(R.id.listObjectView);
        objetView.setAdapter(adapter);
    }
}
