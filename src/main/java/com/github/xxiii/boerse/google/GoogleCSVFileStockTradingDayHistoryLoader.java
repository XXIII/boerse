package com.github.xxiii.boerse.google;

import com.github.xxiii.boerse.stock.Stock;
import com.github.xxiii.boerse.trading.StockTradingDayHistory;
import com.github.xxiii.boerse.trading.StockTradingDayHistoryLoader;

import java.io.FileInputStream;
import java.io.IOException;

public abstract class GoogleCSVFileStockTradingDayHistoryLoader extends StockTradingDayHistoryLoader {

    public static String createFileNameForStock(Stock stock) {
        return "google-" + stock.name() + ".csv";
    }

    @Override
    protected StockTradingDayHistory createHistoryForStock(Stock stock) {
        try {
            return new GoogleCSVFormatStockTradingDayHistory(stock, new FileInputStream(createFileNameForStock(stock)));
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

}
