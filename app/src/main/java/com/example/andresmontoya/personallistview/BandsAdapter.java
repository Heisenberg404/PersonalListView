package com.example.andresmontoya.personallistview;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by andres.montoya on 25/09/2016.
 */

public class BandsAdapter extends ArrayAdapter<Band> {

    Context context;
    int layoutResourceId;
    Band data[] = null;

    public BandsAdapter(Context context, int layoutResourceId, Band[] data){
        super(context, layoutResourceId, data);
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.data = data;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        BandsHolder holder = null;

        if(row == null){
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new BandsHolder();
            holder.imagen = (ImageView) row.findViewById(R.id.imagen);
            holder.texto = (TextView) row.findViewById(R.id.tv);
            row.setTag(holder);
        }
        else{
            holder = (BandsHolder)row.getTag();
        }
        Band bands = data[position];
        holder.texto.setText(bands.title);
        holder.imagen.setImageResource(bands.icon);

        return  row;
        //return super.getView(position, convertView, parent);
    }

    static class  BandsHolder{
        ImageView imagen;
        TextView texto;
    }
}
