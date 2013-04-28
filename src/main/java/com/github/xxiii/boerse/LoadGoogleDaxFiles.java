package com.github.xxiii.boerse;

import com.github.xxiii.boerse.stock.Stock;
import com.github.xxiii.boerse.stock.StockExchange;

public class LoadGoogleDaxFiles {

    public static void main(String[] args) {
        for (Stock stock : StockExchange.DAX.getStocks()) {

        }
    }
}
