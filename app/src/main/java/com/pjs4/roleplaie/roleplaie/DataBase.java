package com.pjs4.roleplaie.roleplaie;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Utilisateur on 07/03/2016.
 */
public class DataBase extends SQLiteOpenHelper {

	static final String dbName = "Data Base";

	static final String table_game= "Game";
	static final String col_game_id= "gameId";

	public DataBase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
		super(context, name, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}
}
