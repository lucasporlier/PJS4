package com.pjs4.roleplaie.roleplaie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Porlier-Pagnon Lucas on 21/03/2016.
 */
public class Faces {
    private static List<List<Integer>> faces;


    public Faces() {
        faces = new ArrayList<>();

        faces.add(new ArrayList<Integer>());

        List<Integer> tmp = faces.get(0);

        tmp.add(R.drawable.d6f1);
        tmp.add(R.drawable.d6f2);
        tmp.add(R.drawable.d6f3);
        tmp.add(R.drawable.d6f4);
        tmp.add(R.drawable.d6f5);
        tmp.add(R.drawable.d6f6);
/*
        tmp = faces.get(1);

        tmp.add(R.drawable.face1);
        tmp.add(R.drawable.face2);
        tmp.add(R.drawable.face3);
        tmp.add(R.drawable.face4);
        tmp.add(R.drawable.face5);
        tmp.add(R.drawable.face6);

*/
    }

    public static int getFace(int de, int i) {
        return faces.get(de).get(i);    //TODO pas de gestion d'erreur pour l'instant
    }
}
