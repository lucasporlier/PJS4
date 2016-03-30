package com.project.appmobil.roleplaieavecmauvaisjeudemot.dataBase;

/**
 * Created by qu2 on 21/03/2016.
 */
public class Competance {
	private int id;

	private String NomComp;
	private String effetComp;
	private String nomPro;

	public Competance() {
	}

	public Competance(String nomComp, String effetComp, String nomPro) {
		NomComp = nomComp;
		this.effetComp = effetComp;
		this.nomPro = nomPro;
	}

	public String getNomComp() {
		return NomComp;
	}

	public String getNomPro() {
		return nomPro;
	}


	public String getEffetComp() {
		return effetComp;
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
