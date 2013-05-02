package com.github.xxiii.boerse.trader;

import com.github.xxiii.boerse.stock.Stock;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Portfolio {

    private Map<Stock, List<PortfolioEntry>> portfolioEntries = new HashMap<>();

    public List<PortfolioEntry> getPortfolioEntriesForStock(Stock stock) {

        if (portfolioEntries.containsKey(stock)) {
            return portfolioEntries.get(stock);
        }

        return Collections.emptyList();
    }


}
