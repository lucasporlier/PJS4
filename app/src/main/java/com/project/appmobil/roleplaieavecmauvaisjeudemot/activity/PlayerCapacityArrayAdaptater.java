package com.project.appmobil.roleplaieavecmauvaisjeudemot.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.project.appmobil.roleplaieavecmauvaisjeudemot.R;
import com.project.appmobil.roleplaieavecmauvaisjeudemot.dataBase.Competence;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nivet on 29/03/2016.
 */
public class PlayerCapacityArrayAdaptater extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private List<Competence> competences;
    private List<LinearLayout> layoutItems =  new ArrayList<LinearLayout>();

    public PlayerCapacityArrayAdaptater(Context context, List<Competence> competences) {
        this.mContext = context;
        this.competences = competences;
        mInflater = LayoutInflater.from(mContext);
    }


    @Override
    public int getCount() {
        int size = competences.size();
        return size;
    }

    @Override
    public Object getItem(int position) {
        return competences.get(position);
    }

    @Override
    public long getItemId(int position) {
        return ((EditText)layoutItems.get(position).findViewById(R.id.capacityName)).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout layoutItem;
        if (convertView == null) {
            layoutItem = (LinearLayout) mInflater.inflate(R.layout.player_file_capacity_layout, parent, false);
        }
        else{
            layoutItem = (LinearLayout) convertView;
        }

        TextView capacityName = (TextView)layoutItem.findViewById(R.id.capacityName);
        TextView capacityDesciption = (TextView)layoutItem.findViewById(R.id.capacityDesciption);

        capacityName.setText(competences.get(position).getNomComp());
        capacityDesciption.setText(competences.get(position).getEffetComp());
        layoutItems.add(layoutItem);
        return layoutItem;
    }
}
