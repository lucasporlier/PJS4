package com.project.appmobil.roleplaieavecmauvaisjeudemot.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.project.appmobil.roleplaieavecmauvaisjeudemot.R;
import com.project.appmobil.roleplaieavecmauvaisjeudemot.dataBase.Partie;

/**
 * Created by qu2 on 31/03/2016.
 */
public class SummaryActivity extends Activity{
    private static EditText gameSummary;
    private static Partie p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.summary_layout);

        Intent intent = getIntent();
        p = intent.getParcelableExtra(InGameMenuActivity.EXTRA_NOMPARTIE);

        gameSummary = (EditText) findViewById(R.id.editText);

      /*  if(p.getResume() == null){
            gameSummary.setText("");
            return;
        }*/
        String resumer = MainActivity.db.getPartieWithName(p.getNom()).getResume();
        Log.i("TestInsert",resumer);
        gameSummary.setText(resumer);
    }

    public void Confirm(View view) {
        p.setResume(gameSummary.getText().toString());
        Log.i("TestInsert", p.getResume());

        MainActivity.db.updateParti(p.getNom(), p);

        Log.i("TestInsert",MainActivity.db.getPartieWithName(p.getNom()).getResume());
/*
        Intent intent = new Intent(this,InGameMenuActivity.class);
        intent.putExtra(LoadGameActivity.EXTRA_GAMENAME,p);
        startActivity(intent);*/

        finish();

    }
}
