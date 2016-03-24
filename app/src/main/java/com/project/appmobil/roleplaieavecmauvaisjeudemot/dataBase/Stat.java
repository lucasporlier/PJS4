package com.project.appmobil.roleplaieavecmauvaisjeudemot.dataBase;

/**
 * Created by qu2 on 21/03/2016.
 */
public class Stat {
	private int ID;
	private int stat;
	private String nomStat;
	private String nomJoueurStat;



	public Stat() {
	}

	public Stat(int stat, String nomStat, String nomJoueurStat) {
		this.stat = stat;
		this.nomStat = nomStat;
		this.nomJoueurStat = nomJoueurStat;
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public String getNomStat() {
		return nomStat;
	}

	public int getStat() {
		return stat;
	}

	public void setNomStat(String nomStat) {
		this.nomStat = nomStat;
	}

	public void setStat(int stat) {
		this.stat = stat;
	}

	public void setNomJoueurStat(String nomJoueurStat) {
		this.nomJoueurStat = nomJoueurStat;
	}

	public String getNomJoueurStat() {

		return nomJoueurStat;
	}
}

