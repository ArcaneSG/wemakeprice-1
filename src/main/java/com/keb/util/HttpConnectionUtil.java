package com.keb.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Optional;
import java.util.zip.GZIPInputStream;

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
            
            System.out.println(conn.getHeaderFields());

            if(Optional.ofNullable(conn.getHeaderField("Content-Encoding")).orElse("").contains("gzip")) {
            	br = new BufferedReader(new InputStreamReader(new GZIPInputStream(conn.getInputStream()))); //wemakeprice 사이트 대응
            } else {
            	br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            }
            
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
