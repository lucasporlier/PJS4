package com.pjs4.roleplaie.roleplaie.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.pjs4.roleplaie.roleplaie.R;
import com.pjs4.roleplaie.roleplaie.dataBase.Partie;

import java.util.ArrayList;

public class NewGameActivity2 extends AppCompatActivity {
    public static final String EXTRA_GAME = "com.pjs4.roleplaie.roleplaie.activity.EXTRA_GAME";
    private Partie game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game2);


        game = getIntent().getExtras().getParcelable(NewGameActivity.EXTRA_GAME1);

        ListView statView = (ListView) findViewById(R.id.listStatView);
        ArrayList<String> s = new ArrayList<>();

        for (int i = 1; i <= game.getStatNumber(); i++) {
            s.add(i-1,"Caracteristique " + i);
        }

        StatArrayAdapter adapter = new StatArrayAdapter(this, s);

        statView.setAdapter(adapter);
    }

    public void confirmNewGame2(View v){

        ListView statView = (ListView) findViewById(R.id.listStatView);

	    ListAdapter listAdapter = statView.getAdapter();
        if(listAdapter == null){
            return;
        }

        for(int i = 0; i < game.getStatNumber(); i++) {
            //statView.findViewById(i);
            String string = String.valueOf(listAdapter.getItem(i));
            if(string != null){
                game.addStat(i, string);
            }
        }

	    Log.i("projet", "lancement de PlayerFileCreation");
        Intent intent = new Intent(this, PlayerFileCreationActivity.class);
        intent.putExtra(EXTRA_GAME, game);
        startActivity(intent);
    }
}
