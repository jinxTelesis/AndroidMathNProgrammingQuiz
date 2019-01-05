package com.example.dre.individualprojectquest2v1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

// incomplete this code does not do anything in the app
// felt like leaving it in
// use scoreInflatorActivity

public class MyArrayAdapter extends ArrayAdapter<String> implements View.OnClickListener, View.OnContextClickListener {

    private final Context mContext;
    private final String[] lstItems;


    public MyArrayAdapter(Context mContext, int resource, String[] objects) {
        super(mContext, resource, objects);

        this.mContext = mContext;
        this.lstItems = objects;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater= (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.itemlayout,parent, false);
        TextView tv1 = (TextView) rowView.findViewById(R.id.initialsID);
        TextView tv2 = (TextView) rowView.findViewById(R.id.scoreId);

        return rowView;

    }



    @Override
    public void onClick(View v) { // didnt need this thought about expanding

    }

    @Override
    public boolean onContextClick(View v) {
        return false;
    }
}
