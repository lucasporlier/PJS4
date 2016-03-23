package com.pjs4.roleplaie.roleplaie.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.pjs4.roleplaie.roleplaie.R;
import com.pjs4.roleplaie.roleplaie.dataBase.DataBasePJS4;
import com.pjs4.roleplaie.roleplaie.dataBase.Objet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nivet on 23/03/2016.
 */
public class InventoryActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inventory);
        ListView lv = (ListView) findViewById(R.id.listObjectView);
        List<Objet> objets = MainActivity.db.getListObjet();

        ObjectArrayAdapter adapter = new ObjectArrayAdapter(this, objets);
        ListView objetView = (ListView) findViewById(R.id.listObjectView);
        objetView.setAdapter(adapter);
    }
}
