package com.project.appmobil.roleplaieavecmauvaisjeudemot.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TableRow;
import android.widget.TextView;

import com.project.appmobil.roleplaieavecmauvaisjeudemot.R;
import com.project.appmobil.roleplaieavecmauvaisjeudemot.dataBase.DataBasePJS4;
import com.project.appmobil.roleplaieavecmauvaisjeudemot.dataBase.Joueur;
import com.project.appmobil.roleplaieavecmauvaisjeudemot.dataBase.Stat;


/**
 * Used to manage the player's information
 * Created by ZHOU Eric on 22/02/2016.
 */
public class PlayerFileActivity extends Activity {

	private TextView namePerso;
	private TextView lvlPerso;
	private TextView pvPerso;
	private TextView manaPerso;
	private TextView xpPerso;


	public static final String EXTRA_NOMPROP = "com.project.appmobil.roleplaieavecmauvaisjeudemot.activity.EXTRA_NOMPROP";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.player_file_layout);
		Log.i("projet", "OnCreate PlayerFileActivity");

		Intent intent = getIntent();

		Joueur j =intent.getExtras().getParcelable(PlayerListActivity.EXTRA_PLAYER_NAME);

		DataBasePJS4 db = MainActivity.db;

		namePerso = (TextView) findViewById(R.id.player_file_title);
		lvlPerso = (TextView) findViewById(R.id.player_level);
		pvPerso = (TextView) findViewById(R.id.tvHP);
		manaPerso = (TextView) findViewById(R.id.tvMP);
		xpPerso = (TextView) findViewById(R.id.tvXP);

		namePerso.setText(j.getNom());
		lvlPerso.setText(j.getLvl());
		pvPerso.setText(j.getPv());
		manaPerso.setText(j.getMana());
		xpPerso.setText(j.getNbExp());

		TableRow tableRowName = (TableRow) findViewById(R.id.table_caracteristics_name);
		TextView tv;

		for(Stat s :db.getAllStats(j.getNom())){
			tv = new TextView(this);
			tv.setText(s.getNomStat());
			tableRowName.addView(tv);
		}

		TableRow tableRowValues = (TableRow) findViewById(R.id.table_row_caracteristics_value);
		for(Stat s :db.getAllStats(j.getNom())){
			tv = new TextView(this);
			tv.setText(s.getNomStat());
			tableRowValues.addView(tv);
		}


        //TODO Les 2 ListView
		PlayerCapacityArrayAdaptater adaptater = new PlayerCapacityArrayAdaptater(this,db.getCompetenceWithPro(j.getNom()));
		ListView capacitiesView = (ListView) findViewById(R.id.list_capacities);
		capacitiesView.setAdapter(adaptater);

		final TextView tvHP = (TextView) findViewById(R.id.tvHP);
		SeekBar sbHP = (SeekBar) findViewById(R.id.seekBarHP);
		sbHP.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				Log.i("projet", "onProgressChanged");

				tvHP.setText(String.valueOf(progress));
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
			}
		});


		final TextView tvMP = (TextView) findViewById(R.id.tvMP);
		SeekBar sbMP = (SeekBar) findViewById(R.id.seekBarMP);
		sbMP.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				Log.i("projet", "onProgressChanged");

				tvMP.setText(String.valueOf(progress));
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
			}
		});

		final TextView tvXP = (TextView) findViewById(R.id.tvXP);
		SeekBar sbXP = (SeekBar) findViewById(R.id.seekBarXP);
		sbXP.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				Log.i("projet", "onProgressChanged");

				tvXP.setText(String.valueOf(progress));
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
			}
		});

	}

	public void inventory(View view) {
		//Toast.makeText(this, R.string.todo, Toast.LENGTH_SHORT).show();

		Intent intent = new Intent(this, InventoryActivity.class);
		intent.putExtra(EXTRA_NOMPROP, ((TextView) findViewById(R.id.name)).getText());
		startActivity(intent);

	}
}
