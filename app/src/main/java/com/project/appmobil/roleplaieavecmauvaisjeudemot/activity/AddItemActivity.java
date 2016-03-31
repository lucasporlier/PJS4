package com.project.appmobil.roleplaieavecmauvaisjeudemot.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.project.appmobil.roleplaieavecmauvaisjeudemot.R;
import com.project.appmobil.roleplaieavecmauvaisjeudemot.dataBase.Joueur;
import com.project.appmobil.roleplaieavecmauvaisjeudemot.dataBase.Objet;

/**
 * Used to add Items in the data base
 * <p/>
 * Created by qu2 on 30/03/2016.
 *
 * @see InventoryActivity
 * @see UseItemActivity
 * @see Objet
 */
public class AddItemActivity extends Activity {

    Objet objet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_item_layout);
        Intent intent = getIntent();

        String nomObjet = intent.getStringExtra(InventoryActivity.EXTRA_NOMOBJET);
        String nomPro = intent.getStringExtra(InventoryActivity.EXTRA_NOMPRO);

        objet = MainActivity.db.getObjetWithName(nomObjet, nomPro);

        Log.i("projet", objet.getNom() + " " + objet.getNomPro());

        TextView textViewNomPro = (TextView) findViewById(R.id.nomProObjUtil);
        TextView textViewNom = (TextView) findViewById(R.id.nomObjUtil);
        TextView textViewQuantity = (TextView) findViewById(R.id.quantityObjUtil);
        TextView textViewEffet = (TextView) findViewById(R.id.effetObjUtil);

        textViewNomPro.setText(objet.getNomPro());
        textViewNom.setText(objet.getNom());
        textViewQuantity.setText(String.valueOf(objet.getNb()));
        textViewEffet.setText(objet.getEffet());
    }

    /**
     * End the activiy
     *
     * @param view
     */
    public void cancel(View view) {
        finish();
    }

    /**
     * Go to the add Item Activity
     *
     * @param view
     */
    public void add(View view) {

        EditText useQuantity = (EditText) findViewById(R.id.nombreUse);

        objet.setNb(objet.getNb() + Integer.parseInt(useQuantity.getText().toString()));

        Log.i("projet", String.valueOf(objet.getNb()));

        MainActivity.db.updateObjet(objet.getNom(), objet, objet.getNomPro());

        Log.i("TestUpdate", String.valueOf(MainActivity.db.getObjetWithName(objet.getNom(), objet.getNomPro()).getNb()));

        Intent intent = new Intent(this, InventoryActivity.class);

        Joueur j = MainActivity.db.getJoueurWithName(objet.getNomPro());
        intent.putExtra(PlayerFileActivity.EXTRA_NOMPROP, j);

        startActivity(intent);

        finish();


    }
}
