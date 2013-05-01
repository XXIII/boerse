package com.github.xxiii.boerse.trading;

import com.github.xxiii.boerse.stock.Stock;

import java.util.ArrayList;
import java.util.List;

public abstract class StockTradingDayHistoryLoader {

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
            result.add(createHistoryForStock(stock));

        }
        return result;


    }

    protected abstract StockTradingDayHistory createHistoryForStock(Stock stock);

    protected abstract List<Stock> getStocksToLoad();
}
