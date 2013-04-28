package com.github.xxiii.boerse.google;

import com.github.xxiii.boerse.stock.Stock;
import com.github.xxiii.boerse.trading.StockTradingDay;
import com.github.xxiii.boerse.trading.StockTradingDayHistory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StockTradingDayHistoryGoogleCSVFormat extends StockTradingDayHistory {

    private final File csvFile;
    private final Stock stock;

    public StockTradingDayHistoryGoogleCSVFormat(Stock stock, File csvFile) {
        this.stock = stock;
        this.csvFile = csvFile;
    }

    @Override
    protected List<StockTradingDay> loadTradingDays() {

        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
            List<StockTradingDay> result = new ArrayList<>();
            boolean firstLine = true;
            String line;
            while ((line = reader.readLine()) != null) {
                // skip header
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                result.add(new StockTradingDayGoogleCSVFormat(stock, line.split(",")));
            }
            return result;
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}

