package com.github.xxiii.boerse.google;

import com.github.xxiii.boerse.stock.Stock;
import com.github.xxiii.boerse.stock.StockExchange;

import java.util.List;

public class DaxGoogleCSVFileStockTradingDayHistoryLoader extends GoogleCSVFileStockTradingDayHistoryLoader {
    @Override
    protected List<Stock> getStocksToLoad() {
        return StockExchange.DAX.getStocks();
    }
}
