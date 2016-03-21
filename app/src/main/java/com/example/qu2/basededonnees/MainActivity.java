package com.example.qu2.basededonnees;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

   private DataBasePJS4 databd = new DataBasePJS4(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });





        Objet o = new Objet(1,"potion","Rend 10pv","Jean");
        databd.insertObjets(o);
        databd.insertObjets(new Objet(15, "Torche", "utilisé pour eclairer des endrois sombre telle ques les grottes et ect", "Jean"));
        databd.insertObjets(new Objet(1000, "Pièce d'or", "rien", "Jean"));
        databd.insertObjets(new Objet(2, "flèche", "tirer grâce à un arc", "Jean"));
        databd.close();


        Competance c = new Competance("nomCOmpp", "sa fé D truc", 2, "Jean");
        databd.insertCompetance(c);
        databd.close();


        Joueur j = new Joueur("Jean", "elfe", 20 , 10 , 1 , 0, "Il etait une fois...","p1");
        databd.insertJoueur(j);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void onClick(View view) {

        TextView tv = (TextView) findViewById(R.id.tvTest);

        tv.setText(databd.getObjetWithName("Torche").getNom());
        databd.close();
    }

    public void onClick2(View view) {

        ((TextView) view).setText(databd.getCompetanceWithName("nomCOmpp").getEffetComp());
        databd.close();
    }

    public void onClick3(View view) {

        ((TextView) view).setText(databd.getJoueurWithName("Jean").getRace());
        databd.close();
    }
}
