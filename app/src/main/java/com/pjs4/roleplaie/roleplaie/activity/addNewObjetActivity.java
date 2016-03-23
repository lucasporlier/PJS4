package com.pjs4.roleplaie.roleplaie.activity;


import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;


import com.pjs4.roleplaie.roleplaie.R;
import com.pjs4.roleplaie.roleplaie.dataBase.Objet;


/**
 * Created by qu2 on 23/03/2016.
 */
public class addNewObjetActivity extends AppCompatActivity {
    private TextView nomObjet;
    private TextView effetObjet;
    private TextView nbObjet;
    private  String nom = " olm";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creation_objet);

        nomObjet = (TextView) findViewById(R.id.nbObjetED);
        effetObjet = (TextView) findViewById(R.id.effetObjetED);
        nbObjet = (TextView) findViewById(R.id.nbObjetED);



    }

    public void confirmerCreation(View view) {

        Objet o = new Objet(Integer.parseInt(nbObjet.getText().toString()),nomObjet.getText().toString(),effetObjet.getText().toString(),nom);//TODO Nom a changer

        MainActivity.db.insertObjets(o);
        Intent intent = new Intent(this,InventoryActivity.class);
        startActivity(intent);


    }



    public void newObjetCreation(View view) {
        Objet o = new Objet(Integer.parseInt(nbObjet.getText().toString()),nomObjet.getText().toString(),effetObjet.getText().toString(),nom);//TODO Nom a changer

        MainActivity.db.insertObjets(o);

        nbObjet.setText("");
        nomObjet.setText("");
        effetObjet.setText("");
    }
}
