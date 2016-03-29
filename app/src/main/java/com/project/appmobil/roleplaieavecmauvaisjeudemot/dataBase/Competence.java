package com.project.appmobil.roleplaieavecmauvaisjeudemot.dataBase;

/**
 * Created by qu2 on 21/03/2016.
 */
public class Competence {
	private int id;

	private String NomComp;
	private String effetComp;
	private int manaUse;
	private String nomPro;

	public Competence() {
	}

	public Competence(String nomComp, String effetComp, int manaUse, String nomPro) {
		NomComp = nomComp;
		this.effetComp = effetComp;
		this.manaUse = manaUse;
		this.nomPro = nomPro;
	}

	public String getNomComp() {
		return NomComp;
	}

	public String getNomPro() {
		return nomPro;
	}

	public int getManaUse() {
		return manaUse;
	}

	public String getEffetComp() {
		return effetComp;
	}

	public void setManaUse(int manaUse) {
		this.manaUse = manaUse;
	}

	public void setNomPro(String nomPro) {
		this.nomPro = nomPro;
	}

	public void setEffetComp(String effetComp) {
		this.effetComp = effetComp;
	}

	public void setNomComp(String nomComp) {
		NomComp = nomComp;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {

		return id;
	}

}
