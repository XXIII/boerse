package com.github.xxiii.boerse.trading;

import com.github.xxiii.boerse.stock.Stock;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public abstract class StockTradingDayHistory {

    private final Stock stock;
    private List<StockTradingDay> stockTradingDays;

    protected StockTradingDayHistory(Stock stock) {
        this.stock = stock;
    }

    public List<StockTradingDay> getStockTradingDays() {
        if (stockTradingDays == null) {
            stockTradingDays = filterNullValues(loadTradingDays());
            buildLinks(stockTradingDays);
        }
        return stockTradingDays;
    }

    private void buildLinks(List<StockTradingDay> stockTradingDays) {
        StockTradingDay previous = null;
        for (StockTradingDay stockTradingDay : stockTradingDays) {
            if (previous != null) {
                stockTradingDay.setPreviousDay(previous);
                previous.setNextDay(stockTradingDay);
            }
            previous = stockTradingDay;
        }
    }

    private List<StockTradingDay> filterNullValues(List<StockTradingDay> stockTradingDaysTmp) {
        ArrayList<StockTradingDay> result = new ArrayList<>(stockTradingDaysTmp.size());
        for (StockTradingDay stockTradingDay : stockTradingDaysTmp) {
            if (!isNull(stockTradingDay.getOpen()) && !isNull(stockTradingDay.getClose())) {
                result.add(stockTradingDay);
            }
        }
        return result;
    }

    private boolean isNull(BigDecimal value) {
        return value == null || value.signum() == 0;
    }

    protected abstract List<StockTradingDay> loadTradingDays();

    public Stock getStock() {
        return stock;
    }
}
