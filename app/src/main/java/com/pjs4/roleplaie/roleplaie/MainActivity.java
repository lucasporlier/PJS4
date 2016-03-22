package com.pjs4.roleplaie.roleplaie;

import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import static com.pjs4.roleplaie.roleplaie.R.string.todo;

/**
 * The main class of the application
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("projet", "Lancement de l'application");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.i("projet", "lancement de la création d'une nouvelle partie");
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
            Log.i("projet", "option");
            Toast.makeText(this, R.string.todo, Toast.LENGTH_SHORT).show();
        }

        if (id == R.id.action_exit) {
            Log.i("projet", "quitter");

            DialogFragment quitDialog = new DialogExit();

            quitDialog.show(getFragmentManager(), "alert");

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void newGame(View view) {
        Log.i("projet", "Préparation de l'intent Nouvelle partie");
        Intent intent = new Intent(MainActivity.this, NewGameActivity.class);
        startActivity(intent);
    }

    public void loadGame(View view) {
        Toast.makeText(this, todo, Toast.LENGTH_SHORT).show();
    }

    public void test(View view) {
        Log.i("projet", "TEST MENU IN GAME");
        Intent intent2 = new Intent(MainActivity.this, InGameMenuActivity.class);
        startActivity(intent2);
    }

    public void test2(View view) {
        Log.i("projet", "TEST CREATION FICHE PERSO");
        Intent intent2 = new Intent(MainActivity.this, PlayerFileCreationActivity.class);
        startActivity(intent2);
    }

    public void test3(View view) {
        Log.i("projet", "TEST FICHE PERSO");
        Intent intent2 = new Intent(MainActivity.this, PlayerFileActivity.class);
        startActivity(intent2);
    }
}
