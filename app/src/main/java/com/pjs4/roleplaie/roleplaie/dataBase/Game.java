package com.pjs4.roleplaie.roleplaie.dataBase;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nivet on 15/02/2016.
 */
public class Game implements Parcelable {
    private String name;
    private int player_number;
    private int stat_number;
    private String type;
    private List<String> stats;

    public Game(String n, int p, int s, String t){
        name = n;
        player_number = p;
        stat_number = s;
        type = t;
        stats = new ArrayList<String>();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeString(name);
        dest.writeString(type);
        dest.writeInt(player_number);
        dest.writeInt(stat_number);
        dest.writeStringList(stats);
    }

    public static final Parcelable.Creator<Game> CREATOR = new Parcelable.Creator<Game>()
    {
        @Override
        public Game createFromParcel(Parcel source)
        {
            return new Game(source);
        }

        @Override
        public Game[] newArray(int size)
        {
            return new Game[size];
        }
    };

    public Game(Parcel in) {
        name = in.readString();
        type = in.readString();
        player_number = in.readInt();
        stat_number = in.readInt();
        List<String> l = new ArrayList<String>();
        in.readStringList(l);
        if(l!=null){
            stats = l;
        }
        else
            stats = new ArrayList<String>();
    }

    public void addStat(int i, String name){
        stats.add(i,name);
    }
    public int getStatNumber(){
        return stat_number;
    }

}
