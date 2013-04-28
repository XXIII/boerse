package com.github.xxiii.boerse;

import com.github.xxiii.boerse.google.GoogleFileFormat;
import com.github.xxiii.boerse.google.GoogleFinanceDownload;
import com.github.xxiii.boerse.stock.Stock;
import com.github.xxiii.boerse.stock.StockExchange;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import static com.github.xxiii.boerse.google.GoogleFinanceDownload.createDate;

public class Download {

    public static void main(String[] args) throws IOException {
        for (Stock stock : StockExchange.DAX.getStocks()) {
            GoogleFinanceDownload download = new GoogleFinanceDownload(createDate(2000, 1, 1), new Date(), FinancialMarket.XETRA, stock, GoogleFileFormat.CSV);
            download.download(new FileOutputStream("google-" + stock.name() + ".csv"));
        }

    }
}
