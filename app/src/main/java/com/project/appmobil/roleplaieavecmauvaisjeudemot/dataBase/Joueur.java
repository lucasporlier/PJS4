package com.project.appmobil.roleplaieavecmauvaisjeudemot.dataBase;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by qu2 on 21/03/2016.
 */
public class Joueur implements Parcelable{
	private int id;
	private String nom;
	private String race;
	private int pv;
	private int mana;
	private int lvl;
	private int nbExp;
	private String lore;
	private String nomPartie;
	private int hpMax;
	private int manaMax;




	public Joueur(String nom, String race, int pv, int mana,String lore, String nomPartie) {
		this.nom = nom;
		this.race = race;
		this.pv = pv;
		this.mana = mana;
		this.lvl = 1;
		this.nbExp = 0;
		this.lore = lore;
		this.nomPartie = nomPartie;
		this.hpMax = pv;
		this.manaMax = mana;
	}

	public Joueur(String nom, String race, int pv, int mana,String lore, String nomPartie,int hpMax,int manaMax) {
		this.nom = nom;
		this.race = race;
		this.pv = pv;
		this.mana = mana;
		this.lvl = 1;
		this.nbExp = 0;
		this.lore = lore;
		this.nomPartie = nomPartie;
		this.hpMax = hpMax;
		this.manaMax = manaMax;
	}

	public Joueur() {
	}

	public String getNom() {
		return nom;
	}

	public String getRace() {
		return race;
	}

	public int getPv() {
		return pv;
	}

	public int getMana() {
		return mana;
	}

	public int getLvl() {
		return lvl;
	}

	public int getNbExp() {
		return nbExp;
	}

	public String getLore() {
		return lore;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public void setPv(int pv) {
		this.pv = pv;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public void setLvl(int lvl) {
		this.lvl = lvl;
	}

	public void setNbExp(int nbExp) {
		this.nbExp = nbExp;
	}

	public void setLore(String lore) {
		this.lore = lore;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomPartie() {
		return nomPartie;
	}

	public void setNomPartie(String nomPartie) {
		this.nomPartie = nomPartie;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(id);
		dest.writeString(nom);
		dest.writeString(race);
		dest.writeInt(pv);
		dest.writeInt(mana);
		dest.writeInt(lvl);
		dest.writeInt(nbExp);
		dest.writeString(lore);
		dest.writeString(nomPartie);
	}

	public Joueur(Parcel in){
		this.id = in.readInt();
		this.nom = in.readString();
		this.race = in.readString();
		this.pv = in.readInt();
		this.mana = in.readInt();
		this.lvl = in.readInt();
		this.nbExp = in.readInt();
		this.lore = in.readString();
		this.nomPartie = in.readString();
	}

	public static final Creator<Joueur> CREATOR = new Creator<Joueur>() {
		@Override
		public Joueur createFromParcel(Parcel in) {
			return new Joueur(in);
		}

		@Override
		public Joueur[] newArray(int size) {
			return new Joueur[size];
		}
	};

	public int getManaMax() {
		return manaMax;
	}

	public void setManaMax(int manaMax) {
		this.manaMax = manaMax;
	}

	public int getHpMax() {
		return hpMax;
	}

	public void setHpMax(int hpMax) {
		this.hpMax = hpMax;
	}
}
