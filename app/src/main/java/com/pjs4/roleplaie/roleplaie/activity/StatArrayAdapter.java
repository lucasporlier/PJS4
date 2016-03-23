package com.pjs4.roleplaie.roleplaie.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pjs4.roleplaie.roleplaie.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nivet on 22/02/2016.
 */
public class StatArrayAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<String> stats;
    private View convertView;
    private ViewGroup parent;
    private LinearLayout layoutItem;
    private List<LinearLayout> layoutItems =  new ArrayList<LinearLayout>();

    public StatArrayAdapter(Context context, ArrayList<String> stats) {
        this.mContext = context;
        this.stats = stats;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return stats.size();
    }

    @Override
    public String getItem(int position) {

        return ((EditText)layoutItems.get(position).findViewById(R.id.ET_Stat)).getText().toString();

    }

    @Override
    public long getItemId(int position) {
        return ((EditText)layoutItems.get(position).findViewById(R.id.ET_Stat)).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        this.convertView=convertView;
        if (convertView == null) {
            layoutItem = (LinearLayout) mInflater.inflate(R.layout.statlist_layout, parent, false);
        }
        else{
            layoutItem = (LinearLayout) convertView;
        }


        TextView tv_Num = (TextView)layoutItem.findViewById(R.id.TV_Num);
        EditText et_Stat = (EditText)layoutItem.findViewById(R.id.ET_Stat);

        tv_Num.setText("Caractéristique n°"+Integer.toString(position+1));
        et_Stat.setHint(stats.get(position));

        layoutItems.add(layoutItem);

        return layoutItem;
    }

}

