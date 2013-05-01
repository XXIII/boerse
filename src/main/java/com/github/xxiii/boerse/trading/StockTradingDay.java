package com.github.xxiii.boerse.trading;

import com.github.xxiii.boerse.stock.Stock;

import java.math.BigDecimal;
import java.util.Date;

import static com.github.xxiii.boerse.util.BigDecimalUtil.differenceInPercent;

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
        return differenceInPercent(getPreviousDay().getClose(), getOpen());
    }

    public BigDecimal getOpenOrCloseMaximum() {
        if (getOpen().compareTo(getClose()) > 0) {
            return getOpen();
        }
        return getClose();
    }

    public int getNumberOfDaysAfter(StockTradingDay other) {
        if (this.equals(other)) {
            return 0;
        }
        return 1 + getPreviousDay().getNumberOfDaysAfter(other);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StockTradingDay)) return false;
        if (!super.equals(o)) return false;

        StockTradingDay that = (StockTradingDay) o;

        if (stock != that.stock) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + stock.hashCode();
        return result;
    }
}
