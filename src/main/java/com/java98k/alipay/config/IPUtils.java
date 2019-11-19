package com.java98k.alipay.config;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
 
import sun.net.www.protocol.http.HttpURLConnection;
 
/**
 * @author ajiu
 */
public class IPUtils {
    public static String getIP() {
        String ip = "http://pv.sohu.com/cityjson?ie=utf-8";
        String inputLine = "";
        String read = "";
        try {
            URL url = new URL(ip);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            while ((read = in.readLine()) != null) {
                inputLine += read;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inputLine;
    }
}