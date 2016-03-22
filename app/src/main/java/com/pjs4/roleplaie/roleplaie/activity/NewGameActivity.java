package com.pjs4.roleplaie.roleplaie.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.pjs4.roleplaie.roleplaie.R;
import com.pjs4.roleplaie.roleplaie.dataBase.Partie;

/**
 Created by ZHOU Eric on 01/02/2016.
 */
public class NewGameActivity extends Activity implements Parcelable{

    public  NewGameActivity(){};

    protected NewGameActivity(Parcel in) {
    }

    public static final Creator<NewGameActivity> CREATOR = new Creator<NewGameActivity>() {
        @Override
        public NewGameActivity createFromParcel(Parcel in) {
            return new NewGameActivity(in);
        }

        @Override
        public NewGameActivity[] newArray(int size) {
            return new NewGameActivity[size];
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_game);
        Log.i("projet", "Lancement d'une nouvelel partie");
    }

    @Override
    protected void onPause() {
        super.onPause();


    }

    public void ConfirmNewGame(View view) {
        TextView gameName = (TextView) findViewById(R.id.GameNameEdiText);
        TextView nbPlayer = (TextView) findViewById(R.id.NbPlayereditText);
        TextView typeGame = (TextView) findViewById(R.id.TypeGameditText);

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
