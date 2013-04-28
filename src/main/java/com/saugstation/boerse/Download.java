package com.saugstation.boerse;

import com.saugstation.boerse.google.Company;
import com.saugstation.boerse.google.GoogleFileFormat;
import com.saugstation.boerse.google.GoogleFinanceDownload;
import com.saugstation.boerse.google.StockExchange;

import java.io.FileOutputStream;
import java.io.IOException;

public class Download {

    public static void main(String[] args) throws IOException {

        GoogleFinanceDownload download = new GoogleFinanceDownload(null, null, StockExchange.FRANKFURT, Company.BMW, GoogleFileFormat.CSV);
        download.download(new FileOutputStream("dummy"));

    }
}
