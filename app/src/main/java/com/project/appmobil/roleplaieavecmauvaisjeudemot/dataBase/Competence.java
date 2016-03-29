package com.project.appmobil.roleplaieavecmauvaisjeudemot.dataBase;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by qu2 on 21/03/2016.
 */
public class Competence implements Parcelable {
	private int id;

	private String nomComp;
	private String effetComp;
	private int manaUse;
	private String nomPro;

	public Competence() {
	}

	public Competence(String nomComp, String effetComp, int manaUse, String nomPro) {
		this.nomComp = nomComp;
		this.effetComp = effetComp;
		this.manaUse = manaUse;
		this.nomPro = nomPro;
	}

	public String getNomComp() {
		return nomComp;
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
		this.nomComp = nomComp;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {

		return id;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(id);
		dest.writeString(nomComp);
		dest.writeString(effetComp);
		dest.writeInt(manaUse);
		dest.writeString(nomPro);
	}

	public Competence(Parcel in){
		this.id = in.readInt();
		this.nomComp = in.readString();
		this.effetComp = in.readString();
		this.manaUse = in.readInt();
		this.nomPro = in.readString();
	}

	public static final Creator<Competence> CREATOR = new Creator<Competence>() {
		@Override
		public Competence createFromParcel(Parcel in) {
			return new Competence(in);
		}

		@Override
		public Competence[] newArray(int size) {
			return new Competence[size];
		}
	};


}
