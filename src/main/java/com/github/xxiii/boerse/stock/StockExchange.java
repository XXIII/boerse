package com.github.xxiii.boerse.stock;

import java.util.Arrays;
import java.util.List;

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
    private final List<Stock> stocks;

    private StockExchange(Stock... stocks) {
        this.stocks = Arrays.asList(stocks);
    }

    public List<Stock> getStocks() {
        return stocks;
    }

    public boolean contains(Stock stock) {
        return stocks.contains(stock);
    }
}
