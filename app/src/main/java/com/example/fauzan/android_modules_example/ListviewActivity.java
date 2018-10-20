package com.example.fauzan.android_modules_example;

import android.os.AsyncTask;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class ListviewActivity extends AppCompatActivity {

    public URL URL;
    public HttpURLConnection httpURLConnection;

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

        new GetDataAsyncTask().execute("http://192.168.0.103/basic/web/index.php?r=api%2Fdefault%2Funiversitas");

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

        /*ArrayList<Universitas> customeArrayList = ExtractJson.extractJsonKampus();

        CustomAdapter customAdapter = new CustomAdapter(this,customeArrayList);
        ListView listView = (ListView) findViewById(R.id.listview_activty);
        listView.setAdapter(customAdapter);*/
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public class GetDataAsyncTask extends AsyncTask<String , Void ,String> {
        String stringJson;

        @Override
        protected String doInBackground(String... strings) {
            httpURLConnection = null;

            try {
                URL = new URL(strings[0]);
                httpURLConnection = (HttpURLConnection) URL.openConnection();
                stringJson = Helper.readStream(httpURLConnection.getInputStream());
                Log.i("stringJson"," " + stringJson);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return stringJson;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            Boolean stringJsonValid = Helper.checkJsonValid(result);

            if (stringJsonValid) {
                doListView(result);
            }
        }
    }

    public void doListView(String stringJsonResult) {
        ArrayList<Universitas> customeArrayList = ExtractJson.extractJsonKampus(stringJsonResult);

        CustomAdapter customAdapter = new CustomAdapter(this,customeArrayList);
        ListView listView = (ListView) findViewById(R.id.listview_activty);
        listView.setAdapter(customAdapter);
    }
}
