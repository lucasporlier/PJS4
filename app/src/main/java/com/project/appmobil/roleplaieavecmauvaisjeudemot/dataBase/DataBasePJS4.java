package com.project.appmobil.roleplaieavecmauvaisjeudemot.dataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qu2 on 21/03/2016.
 *
 * The SQLiteOpenHelper class
 * Content all the methods for access, updates and deletes on the data base
 *
 */
public class DataBasePJS4 extends SQLiteOpenHelper {

	private static final int version = 1;
	private static final String dataBaseName = "PJS4.db";

	/*-----------------------------------------------------------------Competance---------------------------------------------------------*/
	private static final String tab_competance = "table_competance";

	private static final String COL_IDComp = "ID";
	private static final int NUM_COL_IDComp = 0;

	private static final String COL_nomComp = "nomComp";
	private static final int NUM_COL_nomComp = 1;

	private static final String COL_effetComp = "effet";
	private static final int NUM_COL_effetComp = 2;

	private static final String COL_nomProComp = "nomproprietaire";
	private static final int NUM_COL_nomProComp = 3;

	private static final String COL_manaUseComp = "manaUse";
	private static final int NUM_COL_manaUseComp = 4;

	private static final String tab_comp = "CREATE TABLE "
			+ tab_competance + " (" + COL_IDComp + " INTEGER PRIMARY KEY AUTOINCREMENT, "
			+ COL_nomComp + " TEXT NOT NULL, " + COL_effetComp + " TEXT NOT NULL, "
			+ COL_nomProComp + " TEXT NOT NULL, "
			+ COL_manaUseComp + " INTEGER NOT NULL);";

	/*---------------------------------------------------------------------Objet-------------------------------------------------------*/
	private static final String tab_objet = "table_objet";

	private static final String COL_IDObj = "ID";
	private static final int NUM_COL_IDObj = 0;

	private static final String COL_nomObj = "nom";
	private static final int NUM_COL_nomObj = 1;

	private static final String COL_nbObj = "nombre";
	private static final int NUM_COL_nbObj = 2;

	private static final String COL_effetObj = "effet";
	private static final int NUM_COL_effetObj = 3;

	private static final String COL_nomproObj = "nomproprietaire";
	private static final int NUM_COL_nomproObj = 4;

	private static final String tab_ob = "CREATE TABLE "
			+ tab_objet + " (" + COL_IDObj + " INTEGER PRIMARY KEY AUTOINCREMENT, "
			+ COL_nomObj + " TEXT NOT NULL, "
			+ COL_nbObj + " TEXT NOT NULL, " + COL_effetObj
			+ " TEXT NOT NULL, "
			+ COL_nomproObj + " TEXT NOT NULL);";

	/*------------------------------------------------------------------------Joueur---------------------------------------------------------------*/
	private static final String tab_joueur = "table_joueur";

	private static final String COL_IDPerso = "ID";
	private static final int NUM_COL_ID = 0;

	private static final String COL_nomPerso = "nom";
	private static final int NUM_COL_nomPerso = 1;

	private static final String COL_racePerso = "race";
	private static final int NUM_COL_racePerso = 2;

	private static final String COL_pvPerso = "pv";
	private static final int NUM_COL_pvPerso = 3;

	private static final String COL_manaPerso = "mana";
	private static final int NUM_COL_manaPerso = 4;

	private static final String COL_lvlPerso = "lvl";
	private static final int NUM_COL_lvlPerso = 5;

	private static final String COL_nbExpPerso = "nbexp";
	private static final int NUM_COL_nbExpPerso = 6;

	private static final String COL_lorePerso = "lore";
	private static final int NUM_COL_lorePerso = 7;

	private static final String COL_nomPartiePerso = "nomPartie";
	private static final int NUM_COL_nomPartiePerso = 8;

	private static final String COL_hpMax = "pvMax";
	private static final int NUM_COL_hpMax = 9;

	private static final String COL_manaMax = "manaMax";
	private static final int NUM_COL_manaMax = 10;


	private static final String tab_player = "CREATE TABLE " + tab_joueur + " (" +
			COL_IDPerso + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
			COL_nomPerso + " TEXT NOT NULL, " +
			COL_racePerso + " TEXT NOT NULL, " +
			COL_pvPerso + " INTEGER NOT NULL, " +
			COL_manaPerso + " INTEGER NOT NULL, " +
			COL_lvlPerso + " INTEGER NOT NULL, " +
			COL_nbExpPerso + " INT NOT NULL, " +
			COL_nomPartiePerso + " TEXT NOT NULL, " +
			COL_lorePerso + " TEXT, "+
			COL_hpMax + " INTEGER NOT NULL , +" +
			COL_manaMax + " Integer NOT NULL);";
/*--------------------------------------------------------------------------------------------Partie----------------------------------------------------------------------------------------*/

	private static final String tab_partie = "table_partie";

	private static final String COL_IDParti = "ID";
	private static final int NUM_COL_IDParti = 0;

	private static final String COL_nomParti = "nom";
	private static final int NUM_COL_nomParti = 1;

	private static final String COL_typeParti = "type";
	private static final int NUM_COL_typeParti = 2;

	private static final String COL_nbJoueurParti = "nbJoueur";
	private static final int NUM_COL_nbJoueurParti = 3;

	private static final String COL_resume = "resume";
	private  static final int NUM_COL_resume = 4;


	private static final String tab_game = "CREATE TABLE " + tab_partie + " (" +
			COL_IDParti + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
			COL_nomParti + " TEXT NOT NULL, " +
			COL_nbJoueurParti + " TEXT NOT NULL, " +
			COL_typeParti + " TEXT NOT NULL, " +
			COL_resume + " TEXT);";

/*----------------------------------------------------STATS------------------------------------------------------------------------------*/

	private static final String tab_stat = "table_stat";

	private static final String COL_IDStat = "ID";
	private static final int NUM_COL_IDStat = 0;

	private static final String COL_stat = "stat";
	private static final int NUM_COL_stat = 1;

	private static final String COL_nomStat = "nomStat";
	private static final int NUM_COL_nomStat = 2;

	private static final String COL_nomJoueurStat = "nomJoueurStat";
	private static final int NUM_COL_nomJoueurStat = 3;

	private static final String tab_stats = "CREATE TABLE " + tab_stat + " (" +
			COL_IDStat + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
			COL_stat + " INTEGER NOT NULL, " +
			COL_nomStat + " TEXT NOT NULL, " +
			COL_nomJoueurStat + " TEXT NOT NULL);";

/*------------------------------------------------------------------------------------------------------------------*/


	public DataBasePJS4(Context context) {
		super(context, dataBaseName, null, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {

		db.execSQL(tab_comp);
		db.execSQL(tab_ob);
		db.execSQL(tab_player);
		db.execSQL(tab_game);
		db.execSQL(tab_stats);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


		db.execSQL("DROP TABLE IF EXIST " + tab_competance + ";");
		db.execSQL("DROP TABLE IF EXIST " + tab_objet + ";");
		db.execSQL("DROP TABLE IF EXIST " + tab_joueur + ";");
		db.execSQL("DROP TABLE IF EXIST " + tab_partie + ";");
		db.execSQL("DROP TABLE IF EXIST " + tab_stat + ";");
		onCreate(db);
	}


    /* *********************************************************** OBJET ********************************************************** */

	/**
	 * find an object with it name
	 * @param nom the name of the object
	 * @return the found object
	 */
	public Objet getObjetWithName(String nom) {

		SQLiteDatabase bdd = getWritableDatabase();

		String query = "SELECT * FROM " + tab_objet + " WHERE " + COL_nomObj + " = \"" + nom + "\"";
		Cursor c = bdd.rawQuery(query, null);

		return cursorToObjet(c);
	}

	/**
	 *
	 * @param nom the name of the proprietaire
	 * @return
	 */
	public List<Objet> getObjetWithNomPro(String nom) {

		SQLiteDatabase bdd = getWritableDatabase();
		List<Objet> objetList =  new ArrayList<Objet>();

		String query = "SELECT * FROM " + tab_objet + " WHERE " + COL_nomproObj + " = "+ nom;
		Cursor c = bdd.rawQuery(query, null);

		objetList = cursorToObjetList(c);

		return objetList;
	}

	/**
	 * insert an object
	 * @param o the object to be inserted
	 */
	public void insertObjets(Objet o) {

		SQLiteDatabase bdd = getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(COL_nomObj, o.getNom());
		values.put(COL_nbObj, o.getNb());
		values.put(COL_effetObj, o.getEffet());
		values.put(COL_nomproObj, o.getNomPro());

		bdd.insert(tab_objet, null, values);
	}

	public int updateObjet(String nom, Objet o) {
		SQLiteDatabase bdd = getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(COL_nomObj, o.getNom());
		values.put(COL_nbObj, o.getNb());
		values.put(COL_effetComp, o.getEffet());
		values.put(COL_nomProComp, o.getNomPro());
		return bdd.update(tab_objet, values, COL_nomObj + " = " + nom, null);
	}

	public int removeObjetWithName(String name) {
		SQLiteDatabase bdd = getWritableDatabase();
		return bdd.delete(tab_objet, COL_nomObj + " = " + name, null);
	}

	public List<Objet> getListObjet(){
		SQLiteDatabase bdd = getWritableDatabase();
		List<Objet> objetList =  new ArrayList<Objet>();

		String query = "SELECT * FROM " + tab_objet ;
		Cursor c = bdd.rawQuery(query, null);

		objetList = cursorToObjetList(c);

		return objetList;
	}

	private List<Objet> cursorToObjetList(Cursor c){
		List<Objet> oList = new ArrayList<Objet>();
		if (c.getCount() == 0) {
			return null;
		}



		Objet o = new Objet();
		while(c.moveToNext()) {
			o.setId(c.getInt(NUM_COL_IDObj));
			o.setNom(c.getString(NUM_COL_nomObj));
			o.setNb(c.getInt(NUM_COL_nbObj));
			o.setEffet(c.getString(NUM_COL_effetObj));
			o.setNomPro(c.getString(NUM_COL_nomproObj));
			oList.add(o);
		}
		c.close();

		return oList;

	}

	private Objet cursorToObjet(Cursor c) {

		if (c.getCount() == 0) {
			return null;
		}

		c.moveToFirst();

		Objet o = new Objet();

		o.setId(c.getInt(NUM_COL_IDObj));
		o.setNom(c.getString(NUM_COL_nomObj));
		o.setNb(c.getInt(NUM_COL_nbObj));
		o.setEffet(c.getString(NUM_COL_effetObj));
		o.setNomPro(c.getString(NUM_COL_nomproObj));

		c.close();

		return o;
	}

    /* *********************************************************** COMPETENCES ********************************************************** */

	public Competance getCompetanceWithName(String nom) {
		SQLiteDatabase bdd = getWritableDatabase();
		String query = "SELECT * FROM " + tab_competance + " WHERE " + COL_nomComp + " = \"" + nom + "\"";
		Cursor c = bdd.rawQuery(query, null);

		return cursorToCompetance(c);
	}

	public void insertCompetance(Competance c) {
		SQLiteDatabase bdd = getWritableDatabase();
		ContentValues values = new ContentValues();


		values.put(COL_nomComp, c.getNomComp());
		values.put(COL_effetComp, c.getEffetComp());
		values.put(COL_nomProComp, c.getNomPro());
		values.put(COL_manaUseComp, c.getManaUse());

		bdd.insert(tab_competance, null, values);
	}

	public int updateCompetance(String nom, Objet o) {
		SQLiteDatabase bdd = getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(COL_nomComp, o.getNom());
		values.put(COL_effetComp, o.getNb());
		values.put(COL_nomProComp, o.getEffet());
		values.put(COL_manaUseComp, o.getNomPro());
		return bdd.update(tab_competance, values, COL_nomComp + " = " + nom, null);
	}

	public int removeCompetanceWithName(String name) {
		SQLiteDatabase bdd = getWritableDatabase();
		return bdd.delete(tab_competance, COL_nomComp + " = " + name, null);
	}

	private Competance cursorToCompetance(Cursor c) {
		//si aucun élément n'a été retourné dans la requête, on renvoie null
		if (c.getCount() == 0)
			return null;

		c.moveToFirst();

		Competance competance = new Competance();

		competance.setId(c.getInt(NUM_COL_ID));
		competance.setNomComp(c.getString(NUM_COL_nomComp));
		competance.setEffetComp(c.getString(NUM_COL_effetComp));
		competance.setNomPro(c.getString(NUM_COL_nomProComp));
		competance.setManaUse(c.getInt(NUM_COL_manaUseComp));

		c.close();

		return competance;
	}

    /* *********************************************************** JOUEURS ********************************************************** */

	public Joueur getJoueurWithName(String nom) {
		SQLiteDatabase bdd = getWritableDatabase();
		String query = "SELECT * FROM " + tab_joueur + " WHERE " + COL_nomPerso + " = \"" + nom + "\"";
		Cursor c = bdd.rawQuery(query, null);

		return cursorToJoueur(c);
	}

	public void insertJoueur(Joueur j) {
		SQLiteDatabase bdd = getWritableDatabase();
		ContentValues values = new ContentValues();

		values.put(COL_nomPerso, j.getNom());
		values.put(COL_racePerso, j.getRace());
		values.put(COL_pvPerso, j.getPv());
		values.put(COL_manaPerso, j.getMana());
		values.put(COL_lvlPerso, j.getLvl());
		values.put(COL_nbExpPerso, j.getNbExp());
		values.put(COL_lorePerso, j.getLore());
		values.put(COL_nomPartiePerso, j.getNomPartie());
		values.put(COL_hpMax, j.getHpMax());
		values.put(COL_manaMax, j.getManaMax());

		bdd.insert(tab_joueur, null, values);
	}

	public int updateJoueur(String nom, Joueur j) {
		SQLiteDatabase bdd = getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(COL_nomPerso, j.getNom());
		values.put(COL_racePerso, j.getRace());
		values.put(COL_pvPerso, j.getPv());
		values.put(COL_manaPerso, j.getMana());
		values.put(COL_lvlPerso, j.getLvl());
		values.put(COL_nbExpPerso, j.getNbExp());
		values.put(COL_lorePerso, j.getLore());
		values.put(COL_nomPartiePerso, j.getNomPartie());
		values.put(COL_hpMax, j.getHpMax());
		values.put(COL_manaMax, j.getManaMax());

		return bdd.update(tab_joueur, values, COL_nomPerso + " = " + nom, null);
	}

	public int removeJoueurWithName(String name) {
		SQLiteDatabase bdd = getWritableDatabase();
		//Suppression d'un livre de la BDD grâce à l'ID
		return bdd.delete(tab_joueur, COL_nomPerso + " = " + name, null);
	}


	private Joueur cursorToJoueur(Cursor c) {

		if (c.getCount() == 0)
			return null;

		c.moveToFirst();

		Joueur joueur = new Joueur();
		//on lui affecte toutes les infos grâce aux infos contenues dans le Cursor
		joueur.setId(c.getInt(NUM_COL_ID));
		joueur.setNom(c.getString(NUM_COL_nomPerso));
		joueur.setRace(c.getString(NUM_COL_racePerso));
		joueur.setPv(c.getInt(NUM_COL_pvPerso));
		joueur.setMana(c.getInt(NUM_COL_manaPerso));
		joueur.setLvl(c.getInt(NUM_COL_lvlPerso));
		joueur.setNbExp(c.getInt(NUM_COL_nbExpPerso));
		joueur.setLore(c.getString(NUM_COL_lorePerso));
		joueur.setNomPartie(c.getString(NUM_COL_nomPartiePerso));
		joueur.setHpMax(c.getInt(NUM_COL_hpMax));
		joueur.setHpMax(c.getInt(NUM_COL_manaMax));

		c.close();
		return joueur;
	}


	private static List<Joueur> cursorToListJoueur(Cursor c) {
		List<Joueur> l = new ArrayList<Joueur>();


		while (c.moveToNext()) {
			Joueur joueur = new Joueur();
			//on lui affecte toutes les infos grâce aux infos contenues dans le Cursor
			joueur.setId(c.getInt(NUM_COL_ID));
			joueur.setNom(c.getString(NUM_COL_nomPerso));
			joueur.setRace(c.getString(NUM_COL_racePerso));
			joueur.setPv(c.getInt(NUM_COL_pvPerso));
			joueur.setMana(c.getInt(NUM_COL_manaPerso));
			joueur.setLvl(c.getInt(NUM_COL_lvlPerso));
			joueur.setNbExp(c.getInt(NUM_COL_nbExpPerso));
			joueur.setLore(c.getString(NUM_COL_lorePerso));
			joueur.setNomPartie(c.getString(NUM_COL_nomPartiePerso));
			joueur.setHpMax(c.getInt(NUM_COL_hpMax));
			joueur.setHpMax(c.getInt(NUM_COL_manaMax));
			l.add(joueur);
		}


		return l;
	}

	public List<Joueur> getAllPlayer(String extraGameName) {
		SQLiteDatabase bdd = getWritableDatabase();

		String query = "SELECT * FROM " + tab_joueur + " WHERE " + COL_nomPartiePerso + " = \"" + extraGameName + "\"";

		Cursor c = bdd.rawQuery(query, null);
		List<Joueur> list_Joueur = cursorToListJoueur(c);

		return list_Joueur;

	}

	public List<Joueur> getJoueurWithNomPartie(String nomPartie) {
		SQLiteDatabase bdd = getWritableDatabase();
		String query = "SELECT * FROM " + tab_joueur + " WHERE " + COL_nomPartiePerso + " = \"" + nomPartie + "\"";
		Cursor c = bdd.rawQuery(query, null);

		return cursorToListJoueur(c);
	}


   /* *********************************************************** PARTIE ********************************************************** */

	public Partie getPartietWithName(String nom) {
		SQLiteDatabase bdd = getWritableDatabase();
		String query = "SELECT * FROM " + tab_partie + " WHERE " + COL_nomParti + " = \"" + nom + "\"";
		Cursor c = bdd.rawQuery(query, null);

		return cursorToparti(c);
	}

	/**
	 * gets the list of all the games
	 *
	 * @return a list with all of the games in the data base
	 */
	public List<Partie> getAllGames() {

		Log.i("projet", "Récupération des données en cours");
		SQLiteDatabase bdd = getWritableDatabase();

		String query = "SELECT * FROM " + tab_partie;
		Log.i("projet", "Debut execution de la requete");
		Cursor c = bdd.rawQuery(query, null);
		Log.i("projet", "requete executé");
		List<Partie> listGames = new ArrayList<>();
		Partie partie = new Partie();

		while (c.moveToNext()) {

			partie.setId(c.getInt(NUM_COL_IDParti));
			partie.setNom(c.getString(NUM_COL_nomParti));
			partie.setNombreJoueur(c.getInt(NUM_COL_nbJoueurParti));
			partie.setType(c.getString(NUM_COL_typeParti));
			partie.setResume(c.getString(NUM_COL_resume));

			Log.i("projet", partie.toString());
			listGames.add(partie);
		}

		Log.i("projet", "fin");
		return listGames;

	}

	public void insertparti(Partie p) {
		SQLiteDatabase bdd = getWritableDatabase();
		ContentValues values = new ContentValues();


		values.put(COL_nomParti, p.getNom());
		values.put(COL_typeParti, p.getType());
		values.put(COL_nbJoueurParti, p.getNombreJoueur());
		values.put(COL_resume,p.getResume());

		bdd.insert(tab_partie, null, values);
	}

	public int updateParti(String nom, Partie p) {
		SQLiteDatabase bdd = getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(COL_nomParti, p.getNom());
		values.put(COL_typeParti, p.getType());
		values.put(COL_nbJoueurParti, p.getNombreJoueur());
		values.put(COL_resume,p.getResume());

		return bdd.update(tab_partie, values, COL_nomParti + " = " + nom, null);
	}

	public int removePartiWithName(String name) {
		SQLiteDatabase bdd = getWritableDatabase();
		return bdd.delete(tab_partie, COL_nomParti + " = " + name, null);
	}


	private Partie cursorToparti(Cursor c) {

		if (c.getCount() == 0) {
			return null;
		}

		c.moveToFirst();

		Partie j = new Partie();

		j.setId(c.getInt(NUM_COL_ID));
		j.setNom(c.getString(NUM_COL_nomParti));
		j.setType(c.getString(NUM_COL_typeParti));
		j.setNombreJoueur(c.getInt(NUM_COL_nbJoueurParti));

		c.close();

		return j;
	}

	/* **************************************************** STAT **************************************************** */

	public void insertStat(Stat s) {
		SQLiteDatabase bdd = getWritableDatabase();
		ContentValues values = new ContentValues();


		values.put(COL_stat, s.getStat());
		values.put(COL_nomStat, s.getNomStat());
		values.put(COL_nomJoueurStat, s.getNomJoueurStat());

		bdd.insert(tab_partie, null, values);
	}

	public int updateStat(String nom, Stat s) {
		SQLiteDatabase bdd = getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(COL_stat, s.getStat());
		values.put(COL_nomStat, s.getNomStat());
		values.put(COL_nomJoueurStat, s.getNomJoueurStat());

		return bdd.update(tab_partie, values, COL_nomParti + " = " + nom, null);
	}

	private Stat cursorToStat(Cursor c) {

		if (c.getCount() == 0) {
			return null;
		}

		c.moveToFirst();

		Stat s = new Stat();

		s.setStat(c.getInt(NUM_COL_stat));
		s.setNomStat(c.getString(NUM_COL_nomStat));
		s.setNomJoueurStat(c.getString(NUM_COL_nomJoueurStat));

		c.close();

		return s;
	}

	public List<Stat> getAllStats(String player) {

		Log.i("projet", "Récupération des données en cours");
		SQLiteDatabase bdd = getWritableDatabase();

		String query = "SELECT * FROM " + tab_stat + " WHERE " + COL_nomJoueurStat  + " = \"" + player + "\"";
		Log.i("projet", "Debut execution de la requete");
		Cursor c = bdd.rawQuery(query, null);
		Log.i("projet", "requete executé");
		List<Stat> listStat = new ArrayList<>();
		Stat stat = new Stat();

		while (c.moveToNext()) {

			stat.setID(c.getInt(NUM_COL_IDStat));
			stat.setNomStat(c.getString(NUM_COL_nomStat));
			stat.setStat(c.getInt(NUM_COL_stat));
			stat.setNomJoueurStat(c.getString(NUM_COL_nomJoueurStat));

			Log.i("projet", stat.toString());
			listStat.add(stat);
		}

		Log.i("projet", "fin");
		return listStat;

	}


}
