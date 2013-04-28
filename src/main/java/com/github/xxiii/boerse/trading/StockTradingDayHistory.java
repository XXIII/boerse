package com.github.xxiii.boerse.trading;

import java.util.List;

public abstract class StockTradingDayHistory {

    private List<StockTradingDay> stockTradingDays;

    public List<StockTradingDay> getStockTradingDays() {
        if (stockTradingDays == null) {
            stockTradingDays = loadTradingDays();
        }
        return stockTradingDays;
    }

    protected abstract List<StockTradingDay> loadTradingDays();


}
