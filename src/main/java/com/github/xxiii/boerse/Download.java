package com.github.xxiii.boerse;

import com.github.xxiii.boerse.google.Company;
import com.github.xxiii.boerse.google.GoogleFileFormat;
import com.github.xxiii.boerse.google.GoogleFinanceDownload;
import com.github.xxiii.boerse.google.StockExchange;

import java.io.FileOutputStream;
import java.io.IOException;

public class Download {

    public static void main(String[] args) throws IOException {

        GoogleFinanceDownload download = new GoogleFinanceDownload(null, null, StockExchange.FRANKFURT, Company.BMW, GoogleFileFormat.CSV);
        download.download(new FileOutputStream("dummy"));

    }
}
