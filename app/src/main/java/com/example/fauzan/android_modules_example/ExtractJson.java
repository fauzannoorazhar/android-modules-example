package com.example.fauzan.android_modules_example;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class ExtractJson {

    private static final String SAMPEL_JSON = "{ \"kampus\": [ { \"nama\": \"Universitas Gadjah Mada\", \"lokasi\": \"Yogyakarta\" }, { \"nama\": \"Universitas Indonesia\", \"lokasi\": \"Depok, Jawa Barat\" }, { \"nama\": \"Universitas Negeri Yogyakarta\", \"lokasi\": \"Yogyakarta\" }, { \"nama\": \"Universitas Brawijaya\", \"lokasi\": \"Malang\" }, { \"nama\": \"Institut Pertanian Bogor\", \"lokasi\": \"Bogor\" }, { \"nama\": \"Universitas Diponegoro\", \"lokasi\": \"Semarang\" }, { \"nama\": \"Universitas Sebelas Maret\", \"lokasi\": \"Surakarta\" }, { \"nama\": \"Universitas Sumatera Utara\", \"lokasi\": \"Medan\" }, { \"nama\": \"Institut Teknologi Bandung\", \"lokasi\": \"Bandung\" }, { \"nama\": \"Universitas Airlangga\", \"lokasi\": \"Surabaya\" }, { \"nama\": \"Universitas Pendidikan Indonesia\", \"lokasi\": \"Bandung\" }, { \"nama\": \"Universitas Lampung\", \"lokasi\": \"Bandar Lampung\" }, { \"nama\": \"Institut Teknologi Sepuluh Nopember\", \"lokasi\": \"Surabaya\" }, { \"nama\": \"Universitas Negeri Semarang\", \"lokasi\": \"Semarang\" } ] }";

    public static ArrayList<Universitas> extractJsonKampus() {

        ArrayList<Universitas> universitasArrayList = new ArrayList<>();

        try {
            JSONObject baseJsonObject = new JSONObject(SAMPEL_JSON);
            JSONArray baseJsonArray = baseJsonObject.getJSONArray("kampus");
            Log.i("baseJsonArray", "" + baseJsonArray.toString());

            for (int i = 0; i < baseJsonArray.length(); i++) {
                JSONObject baseJsonKampus = baseJsonArray.getJSONObject(i);
                String namaKampus = baseJsonKampus.getString("nama");
                String lokasiKampus = baseJsonKampus.getString("lokasi");

                Universitas universitas = new Universitas(namaKampus);
                universitasArrayList.add(universitas);
            }

        } catch (JSONException e) {
            Log.e("extractJson","Problem parsing the earthquake JSON result", e);
        }

        return universitasArrayList;
    }
}
