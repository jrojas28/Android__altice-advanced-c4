package com.altice_crt_a.android__avanzado_4.classes;

import android.util.Log;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by jaime on 6/2/2018.
 */

public class HTTPClient {
    private URL url;

    public HTTPClient() {}

    public HTTPClient(URL url) {
        this.url = url;
    }
    public HTTPClient(String url) {
        try {
            this.url = new URL(url);
        }
        catch(Exception e) {
            Log.wtf("HTTP ERROR", e.toString());
        }
    }

    public ArrayList<String> retreiveData() {
        HttpURLConnection connection = null;
        ArrayList<String> data = new ArrayList<String>();
        try {
            connection = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(connection.getInputStream());
            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\n");
            while(scanner.hasNext()) {
                data.add(scanner.next());
            }
        }
        catch(Exception e) {
            Log.wtf("HTTP ERROR", e.toString());
        }
        finally {
            connection.disconnect();
        }
        return data;
    }
}
