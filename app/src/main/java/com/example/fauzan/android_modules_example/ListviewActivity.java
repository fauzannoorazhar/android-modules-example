package com.example.fauzan.android_modules_example;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class ListviewActivity extends AppCompatActivity {

    private String[] universitas = {"Institute Tekhnologi Bandung","Universitas Komputer","Universitas Pendidikan Indonesia","Universitas Gadjah Mada","Universitas Maranatha","Universitas Khatolik Parahyangan","Universitas Bina Sarana Indonesia","Universitas Siliwangin","Universitas Pasundan"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null) {
            actionBar.setTitle("ListView Activity");
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        /*CustomAdapter customAdapter = new CustomAdapter(this, universitas);
        listView.setAdapter(customAdapter);*/

        ArrayList<Universitas> customeArrayList = new ArrayList<Universitas>();
        customeArrayList.add(new Universitas("Institute Tekhnologi Bandung"));
        customeArrayList.add(new Universitas("Universitas Komputer"));

        Log.i("arraList", "" + customeArrayList.size());

        CustomAdapter customAdapter = new CustomAdapter(this,customeArrayList);
        ListView listView = (ListView) findViewById(R.id.listview_activty);
        listView.setAdapter(customAdapter);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
