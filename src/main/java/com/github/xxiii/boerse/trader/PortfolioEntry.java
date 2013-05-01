package com.github.xxiii.boerse.trader;

import com.github.xxiii.boerse.stock.Stock;
import com.github.xxiii.boerse.trading.StockTradingDay;

import java.math.BigDecimal;

public class PortfolioEntry {
    private final StockTradingDay dayOfPurchase;
    private final int numberOfShares;
    private final BigDecimal boughtAt;

    public PortfolioEntry(Stock stock, int numberOfShares, BigDecimal boughtAt, StockTradingDay dayOfPurchase) {
        this.numberOfShares = numberOfShares;
        this.boughtAt = boughtAt;
        this.dayOfPurchase = dayOfPurchase;
    }

    public int getNumberOfShares() {
        return numberOfShares;
    }

    public BigDecimal getBoughtAt() {
        return boughtAt;
    }

    public StockTradingDay getDayOfPurchase() {
        return dayOfPurchase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PortfolioEntry)) return false;

        PortfolioEntry that = (PortfolioEntry) o;

        if (!dayOfPurchase.equals(that.dayOfPurchase)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return dayOfPurchase.hashCode();
    }
}

