package com.pjs4.roleplaie.roleplaie.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pjs4.roleplaie.roleplaie.R;
import com.pjs4.roleplaie.roleplaie.dataBase.Objet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nivet on 23/03/2016.
 */
public class ObjectArrayAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<Objet> obj;
    private List<LinearLayout> layoutItems =  new ArrayList<LinearLayout>();
    private LinearLayout layoutItem;

    public ObjectArrayAdapter(Context context, ArrayList<Objet> o) {
        this.mContext = context;
        this.obj = o;
        mInflater = LayoutInflater.from(mContext);

    }

    @Override
    public int getCount() {
        return obj.size();
    }

    @Override
    public Object getItem(int position) {
        return obj.get(position);
    }

    @Override
    public long getItemId(int position) {
        return layoutItems.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            layoutItem = (LinearLayout) mInflater.inflate(R.layout.inventory_object_layout, parent, false);
        }
        else{
            layoutItem = (LinearLayout) convertView;
        }

        TextView nomObjet = (TextView)layoutItem.findViewById(R.id.nomObjet);
        TextView effetObjet = (TextView)layoutItem.findViewById(R.id.effetObjet);
        TextView nbObjet = (TextView)layoutItem.findViewById(R.id.nbObjet);

        nomObjet.setText(obj.get(position).getNom());
        effetObjet.setText(obj.get(position).getEffet());
        nbObjet.setText(obj.get(position).getNb());

        layoutItems.add(layoutItem);
        return layoutItem;
    }
}
