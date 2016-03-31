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
 * Used by the layout use_item_layout
 * <p/>
 * Created by ZHOU Eric on 29/03/2016.
 */
public class UseItemActivity extends Activity {

    Objet objet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.use_item_layout);
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
     * Returns to the last activity
     *
     * @param view a view
     */
    public void cancel(View view) {
        finish();
    }

    /**
     * Uses an Item
     *
     * @param view a view
     */
    public void use(View view) {


        EditText useQuantity = (EditText) findViewById(R.id.nombreUse);

        if (Integer.parseInt(useQuantity.getText().toString()) <= objet.getNb()) {
            objet.setNb(objet.getNb() - Integer.parseInt(useQuantity.getText().toString()));

            Log.i("projet", String.valueOf(objet.getNb()));

            MainActivity.db.updateObjet(objet.getNom(), objet, objet.getNomPro());

            Log.i("TestUpdate", String.valueOf(MainActivity.db.getObjetWithName(objet.getNom(), objet.getNomPro()).getNb()));

            Intent intent = new Intent(this, InventoryActivity.class);

            Joueur j = MainActivity.db.getJoueurWithName(objet.getNomPro());
            intent.putExtra(PlayerFileActivity.EXTRA_NOMPROP, j);

            startActivity(intent);

            finish();
        } else {
            Toast.makeText(this, R.string.not_enought_item, Toast.LENGTH_LONG).show();
        }
    }
}
