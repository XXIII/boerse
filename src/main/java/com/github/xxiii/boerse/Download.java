package com.github.xxiii.boerse;

import com.github.xxiii.boerse.google.GoogleFileFormat;
import com.github.xxiii.boerse.google.GoogleFinanceDownload;
import com.github.xxiii.boerse.stock.Stock;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import static com.github.xxiii.boerse.google.GoogleFinanceDownload.createDate;

public class Download {

    public static void main(String[] args) throws IOException {

        GoogleFinanceDownload download = new GoogleFinanceDownload(createDate(2000, 1, 1), new Date(), FinancialMarket.XETRA, Stock.DEUTSCHE_TELEKOM, GoogleFileFormat.CSV);
        download.download(new FileOutputStream("dummy"));

    }
}
