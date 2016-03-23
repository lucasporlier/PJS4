package com.pjs4.roleplaie.roleplaie.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.pjs4.roleplaie.roleplaie.R;
import com.pjs4.roleplaie.roleplaie.dataBase.Partie;

import java.util.List;

/**
 * Used by the layout player_file_creation_layout.xml
 * Created by ZHOU Eric on 08/02/2016.
 */
public class PlayerFileCreationActivity extends Activity {

	private int numCapacities = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.player_file_creation_layout);

		Log.i("projet", "Lancement de la création d'une fiche de personnage");
		Intent intent = getIntent();
		Partie p = intent.getExtras().getParcelable(NewGameActivity2.EXTRA_GAME);

		TableRow tableRowName = (TableRow) findViewById(R.id.table_row_caracteristics_name);
		TableRow tableRowValue = (TableRow) findViewById(R.id.table_row_caracteristics_value);

		List<String> listStats = p.getListStat();

		Log.i("testParcelabel", p.getNom());
		Log.i("testParcelabel", p.getType());
		Log.i("testParcelabel", String.valueOf((p.getNombreJoueur())));
		Log.i("testParcelabel", p.getStat(p.getStatNumber() - 1));

		Log.i("testParcelabel", listStats.toString());


		TextView tv;
		for (int i = 0; i < p.getStatNumber(); i++) {
			tv = new TextView(this);

			Log.i("projet", "ajout de la stat : " + String.valueOf(i));
			tv.setText(listStats.get(i));
			tableRowName.addView(tv);
			Log.i("projet", "ok");
		}




        Log.i("testParcelabel", p.getNom());
        Log.i("testParcelabel", p.getType());
        Log.i("testParcelabel", String.valueOf((p.getNombreJoueur())));
        Log.i("testParcelabel", p.getStat(p.getStatNumber() - 1));

        Log.i("testListGame",p.getListStat().toString());

		EditText ed;
		for (int i = 0; i < p.getStatNumber(); i++) {
			ed = new EditText(this);
			ed.setHint(getResources().getString(R.string.value));


			Log.i("projet", "ajout de la value : " + String.valueOf(i));
			tableRowValue.addView(ed, i);
			Log.i("projet", "ok");
		}

	}

	/**
	 * Add a new line in the table of capacities
	 *
	 * @param view the view
	 */
	public void moreCapacity(View view) {
		Log.i("projet", "Ajout d'une nouelle ligne");
		TableLayout tbL = (TableLayout) findViewById(R.id.capacitiesTable);

		EditText ed1 = new EditText(this);
		ed1.setHint("Name");

		EditText ed2 = new EditText(this);
		ed2.setHint("Description");

		TableRow tr = new TableRow(this);
		tr.addView(ed1);
		tr.addView(ed2);

		tbL.addView(tr);

		Log.i("projet", "Ligne ajoutée");

	}
}
