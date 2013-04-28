package com.github.xxiii.boerse.trading;

import com.github.xxiii.boerse.stock.Stock;

import java.util.ArrayList;
import java.util.List;

public abstract class StockTradingDayHistorieLoader {

    private List<StockTradingDayHistory> stockTradingDayHistories;

    public List<StockTradingDayHistory> getStockTradingDayHistories() {
        if (stockTradingDayHistories == null) {
            stockTradingDayHistories = loadStockTradingDayHistories();
        }
        return stockTradingDayHistories;
    }

    private List<StockTradingDayHistory> loadStockTradingDayHistories() {
        List<StockTradingDayHistory> result = new ArrayList<>();
        for (Stock stock : getStocksToLoad()) {
            result.add(createHistorieForStock(stock));

        }
        return result;


    }

    protected abstract StockTradingDayHistory createHistorieForStock(Stock stock);

    protected abstract List<Stock> getStocksToLoad();
}
