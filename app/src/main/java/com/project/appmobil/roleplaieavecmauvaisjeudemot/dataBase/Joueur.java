package com.project.appmobil.roleplaieavecmauvaisjeudemot.dataBase;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * A player
 * <p/>
 * Created by qu2 on 21/03/2016.
 *
 * @see DataBasePJS4
 */
public class Joueur implements Parcelable {
    /**
     * A player Identifier
     */
    private int id;

    /**
     * the player's name
     */
    private String nom;

    /**
     * the player's race
     */
    private String race;

    /**
     * the player's actual health
     */
    private int pv;

    /**
     * the player actual mana
     */
    private int mana;

    /**
     * the player level
     */
    private int lvl;

    /**
     * the player experience point
     */
    private int nbExp;

    /**
     * the player's lore
     */
    private String lore;

    /**
     * the game in which the player is
     */
    private String nomPartie;

    /**
     * the player's max amount of  health
     */
    private int hpMax;

    /**
     * the player max amount of mana
     */
    private int manaMax;


    public Joueur(String nom, String race, int pv, int mana, String lore, String nomPartie) {
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

    public Joueur(String nom, String race, int pv, int mana, String lore, String nomPartie, int hpMax, int manaMax) {
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


    // ***** GETTER
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

    public int getId() {
        return id;
    }

    public String getNomPartie() {
        return nomPartie;
    }

    public int getManaMax() {
        return manaMax;
    }

    public int getHpMax() {
        return hpMax;
    }
    // ***** END GETTER *****


    // ***** SETTER *****
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

    public void setNomPartie(String nomPartie) {
        this.nomPartie = nomPartie;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setManaMax(int manaMax) {
        this.manaMax = manaMax;
    }

    public void setHpMax(int hpMax) {
        this.hpMax = hpMax;
    }
    // ***** END SETTER


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

    public Joueur(Parcel in) {
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
}


