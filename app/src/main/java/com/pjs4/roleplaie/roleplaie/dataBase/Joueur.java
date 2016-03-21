package com.pjs4.roleplaie.roleplaie.dataBase;

/**
 * Created by qu2 on 21/03/2016.
 */
public class Joueur {
	private int id;
	private String nom;
	private String race;
	private int pv;
	private int mana;
	private int lvl;
	private int nbExp;
	private String lore;
	private String nomPartie;


	public Joueur(String nom, String race, int pv, int mana, int lvl, int nbExp, String lore, String nomPartie) {
		this.nom = nom;
		this.race = race;
		this.pv = pv;
		this.mana = mana;
		this.lvl = lvl;
		this.nbExp = nbExp;
		this.lore = lore;
		this.nomPartie = nomPartie;
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
}
