package com.pjs4.roleplaie.roleplaie;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class NewGameActivity2 extends AppCompatActivity {

    Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game2);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        game = getIntent().getExtras().getParcelable("game");

        ListView statView = (ListView) findViewById(R.id.listStatView);
        ArrayList<String> s = new ArrayList<String>();
        for (int i = 1; i <= game.getStatNumber(); i++) {
            s.add(i-1,"Caracteristique " + i);
            //EditText et = new EditText(this);
            //et.setId(i);
            //et.setHint(s[i - 1]);
            //statView.addView(et);
        }
        StatArrayAdapter adapter = new StatArrayAdapter(this, s);

        statView.setAdapter(adapter);
    }

    public void confirmNewGame2(View v){
        ListView statView = (ListView) findViewById(R.id.listStatView);
        StatArrayAdapter la = (StatArrayAdapter) statView.getAdapter();
        if(la == null){
            return;
        }

        for(int i = 0; i < la.getCount(); i++) {
            Object strg = la.getItem(i).;
            game.addStat(i,(String) strg);
        }

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("game",game);
        startActivity(intent);
    }
}
