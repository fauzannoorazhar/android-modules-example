package com.example.fauzan.android_modules_example;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Helper {

    // Converting InputStream to String
    public static String readStream(InputStream in) {
        BufferedReader reader = null;
        StringBuffer response = new StringBuffer();
        try {
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return response.toString();
    }

    public static boolean checkJsonValid(String stringJson) {
        try {
            new JSONObject(stringJson);
        } catch (JSONException e) {
            try {
                new JSONArray(stringJson);
            } catch (JSONException ex) {
                return false;
            }
        }

        return true;
    }
}
