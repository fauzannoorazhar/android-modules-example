package com.example.fauzan.android_modules_example;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

    private String[] universitas;
    private Activity activity;

    public CustomAdapter(Activity activity, String[] universitas) {
        this.activity = activity;
        this.universitas = universitas;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(activity.LAYOUT_INFLATER_SERVICE);

        View viewCustomAdapter = inflater.inflate(R.layout.row_listview, null);

        TextView textViewList = viewCustomAdapter.findViewById(R.id.tv_row_listview);
        textViewList.setText(universitas[i]);

        return viewCustomAdapter;
    }
}
