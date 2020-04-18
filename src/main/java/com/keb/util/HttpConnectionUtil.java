package com.keb.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpConnectionUtil {
	public static String httpConnection(String targetUrl) {
        URL url = null;
        HttpURLConnection conn = null;
        String line = "";
        BufferedReader br = null;
        StringBuffer sb = null;
     
        try {
            url = new URL(targetUrl);
     
            conn = (HttpURLConnection) url.openConnection();
            conn.addRequestProperty("User-Agent", "Mozilla"); //403 에러 대응
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestMethod("GET");
            conn.connect();
     
            br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            sb = new StringBuffer();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
     
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        return sb.toString();
    }
}
