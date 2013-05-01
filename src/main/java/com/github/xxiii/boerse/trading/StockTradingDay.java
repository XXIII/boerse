package com.github.xxiii.boerse.trading;

import com.github.xxiii.boerse.stock.Stock;

import java.math.BigDecimal;
import java.util.Date;

public class StockTradingDay extends TradingDay<StockTradingDay> {

    private final Stock stock;
    private final BigDecimal open;
    private final BigDecimal high;
    private final BigDecimal low;
    private final BigDecimal close;

    public StockTradingDay(Date date, Stock stock, BigDecimal open, BigDecimal high, BigDecimal low, BigDecimal close) {
        super(date);
        this.stock = stock;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
    }

    public Stock getStock() {
        return stock;
    }

    public BigDecimal getOpen() {
        return open;
    }

    public BigDecimal getHigh() {
        return high;
    }

    public BigDecimal getLow() {
        return low;
    }

    public BigDecimal getClose() {
        return close;
    }

    public BigDecimal getChangeInPercentageThisDayOpenYesterdayClose() {
        if (getPreviousDay() == null) {
            return null;
        }

        return getOpen().divide(getPreviousDay().getClose()).subtract(BigDecimal.ONE);
    }
}
