package com.project.appmobil.roleplaieavecmauvaisjeudemot.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.project.appmobil.roleplaieavecmauvaisjeudemot.R;
import com.project.appmobil.roleplaieavecmauvaisjeudemot.dataBase.Objet;

/**
 * Used by the layout add_object.xml
 *
 * Created by qu2 on 29/03/2016.
 *
 * @see InventoryActivity
 * @see Objet
 */
public class AddObjetActivity extends Activity {
    private EditText nomObjet;
    private EditText effetObjet;
    private EditText quantiteObjet;
    private String nomPro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_objet_layout);

        nomObjet = (EditText) findViewById(R.id.EditText_Object_Name);
        effetObjet = (EditText) findViewById(R.id.EditText_Object_Effect);
        quantiteObjet = (EditText) findViewById(R.id.EditText_Object_Quantity);
        nomPro = getIntent().getStringExtra(InventoryActivity.EXTRA_NOMPRO);
    }


    /**
     * Add an object and prepare the activity for an other new Item
     *
     * @param view a view
     */
    public void addAndNew(View view) {
        Objet o = new Objet(Integer.parseInt(quantiteObjet.getText().toString()), nomObjet.getText().toString(), effetObjet.getText().toString(), nomPro);
        MainActivity.db.insertObjets(o);

        nomObjet.setText("");
        effetObjet.setText("");
        quantiteObjet.setText("");
    }

    /**
     * Add an Item and end this activity
     *
     * @param view a view
     */
    public void addAndQuit(View view) {
        Objet o = new Objet(Integer.parseInt(quantiteObjet.getText().toString()), nomObjet.getText().toString(), effetObjet.getText().toString(), nomPro);
        MainActivity.db.insertObjets(o);
        Intent intent = new Intent(this, InventoryActivity.class);
        startActivity(intent);
        finish();
    }
}
