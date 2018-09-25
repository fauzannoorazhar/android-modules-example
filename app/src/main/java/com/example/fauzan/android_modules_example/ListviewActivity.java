package com.example.fauzan.android_modules_example;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ListviewActivity extends AppCompatActivity {

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

        /*
        * Untuk membuat listView kita gunakan ArrayList, fungsinya untuk menampung list kedalam ListArray
        * Setelah membuat object ArrayList, kita gunakan method ``add`` untuk mengisi arrayList yang kita buat
        * Kita buat customeAdapter fungsinya untuk menampilkan setiap list yang kita buat
        * */
        //ArrayList<Universitas> customeArrayList = new ArrayList<>();
        //customeArrayList.add(new Universitas("Institute Tekhnologi Bandung"));
        //customeArrayList.add(new Universitas("Institute Pertanian Bogor"));
        //customeArrayList.add(new Universitas("Universitas Komputer"));
        //customeArrayList.add(new Universitas("Universitas Pendidikan Indonesia"));
        //customeArrayList.add(new Universitas("Universitas Padjajaran"));
        //customeArrayList.add(new Universitas("Universitas BSI Bandung"));
        //customeArrayList.add(new Universitas("Universitas Pasundan"));
        //customeArrayList.add(new Universitas("Universitas Maranatha"));
        //customeArrayList.add(new Universitas("Universitas Gadjah Mada"));
        //customeArrayList.add(new Universitas("Universitas Indonesia"));
        //customeArrayList.add(new Universitas("Universitas Parahyangan"));

        ArrayList<Universitas> customeArrayList = ExtractJson.extractJsonKampus();

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
