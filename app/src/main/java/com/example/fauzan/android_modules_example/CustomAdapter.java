package com.example.fauzan.android_modules_example;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Universitas> {

    public CustomAdapter(Activity activity, ArrayList<Universitas> arrayList){
        super(activity, 0, arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.row_listview, parent, false);
        }

        Universitas universitas = getItem(position);

        TextView textView = view.findViewById(R.id.tv_row_listview);
        textView.setText(universitas.nama);

        return view;
    }
}
