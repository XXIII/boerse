package com.github.xxiii.boerse.stock;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static com.github.xxiii.boerse.stock.Stock.*;

public enum StockExchange {

    DAX(
            ADIDAS,
            ALLIANZ,
            BASF,
            BAYER,
            BMW,
            COMMERZBANK,
            DAIMLER,
            DEUTSCHE_BANK,
            DEUTSCHE_TELEKOM,
            FRESENIUS_MEDICAL_CARE,
            HENKEL,
            LINDE,
            RWE,
            SAP,
            SIEMENS,
            THYSSEN_KRUPP,
            VOLKSWAGEN
    );
    private final Set<Stock> stocks;

    private StockExchange(Stock... stocks) {
        this.stocks = new HashSet<>(Arrays.asList(stocks));
    }

    public Set<Stock> getStocks() {
        return stocks;
    }

    public boolean contains(Stock stock) {
        return stocks.contains(stock);
    }
}
