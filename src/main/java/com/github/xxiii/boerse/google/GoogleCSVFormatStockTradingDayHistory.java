package com.github.xxiii.boerse.google;

import com.github.xxiii.boerse.stock.Stock;
import com.github.xxiii.boerse.trading.StockTradingDay;
import com.github.xxiii.boerse.trading.StockTradingDayHistory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GoogleCSVFormatStockTradingDayHistory extends StockTradingDayHistory {

    private final InputStream csvInputStream;

    public GoogleCSVFormatStockTradingDayHistory(Stock stock, InputStream csvInputStream) {
        super(stock);
        this.csvInputStream = csvInputStream;
    }

    @Override
    protected List<StockTradingDay> loadTradingDays() {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(csvInputStream))) {
            List<StockTradingDay> result = new ArrayList<>();
            boolean firstLine = true;
            String line;
            while ((line = reader.readLine()) != null) {
                // skip header
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                result.add(new GoogleCSVFormatStockTradingDay(getStock(), line.split(",")));
            }
            return result;
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}

