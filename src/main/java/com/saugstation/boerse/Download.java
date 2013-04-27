package com.saugstation.boerse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Download {

    public static void main(String[] args) throws IOException {
        URL url = new URL("BLUBBERhttps://www.google.com/finance/historical?q=FRA%3ADTE&startdate=Jan+1%2C+2000&enddate=Apr+27%2C+2013&output=csv");
        String s;
        BufferedReader r = new BufferedReader(new InputStreamReader(url.openStream()));
        while ((s = r.readLine()) != null) {
            System.out.println(s);
        }

    }
}
