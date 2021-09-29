package com.example.android.mowik;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import static com.example.android.mowik.R.id.america;

public class WordAdapter extends ArrayAdapter<word> {

    public WordAdapter(Activity context, ArrayList<word> words) {
        super(context, 0,words);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
         View listItemView=convertView;
         if(listItemView==null)
             listItemView= LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        word currentword = getItem(position);
        TextView miwoktext = (TextView)    listItemView.findViewById(R.id.mowii);
        miwoktext.setText(currentword.getMmowiktrans());
        TextView engtext=(TextView) listItemView.findViewById(america);
        engtext.setText(currentword.getdefaultword());

        if(currentword.getRsourceId()!=0)
        { ImageView iconView = (ImageView) listItemView.findViewById(R.id.imagii);
        iconView.setImageResource(currentword.getRsourceId());}
        else
        {
            ImageView iconView = (ImageView) listItemView.findViewById(R.id.imagii);
            iconView.setVisibility(View.GONE);
        }


        return listItemView;

    }

}

