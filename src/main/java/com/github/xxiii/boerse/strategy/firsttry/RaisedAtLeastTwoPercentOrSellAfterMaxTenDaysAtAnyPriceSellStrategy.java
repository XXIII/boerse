package com.github.xxiii.boerse.strategy.firsttry;

import com.github.xxiii.boerse.strategy.SellRecommendation;
import com.github.xxiii.boerse.strategy.SellStrategy;
import com.github.xxiii.boerse.trading.StockTradingDay;

import java.math.BigDecimal;

import static com.github.xxiii.boerse.util.BigDecimalUtil.differenceInPercent;

/**
 * Verkaufe, wenn mindestens zwei Prozent gestiegen oder verkaufe nach 10 Tagen zu jedem Preis
 */
public class RaisedAtLeastTwoPercentOrSellAfterMaxTenDaysAtAnyPriceSellStrategy implements SellStrategy {

    private static final BigDecimal SELL_WHEN_RAISED_MINIMUM_IN_PERCENT = new BigDecimal("0.02");
    private static final int HOLD_MAX_DAYS = 10;

    @Override
    public SellRecommendation sell(StockTradingDay today, StockTradingDay dayOfBuy, BigDecimal boughtAt) {
        if (isRaisedAtLeastMinimum(boughtAt, today.getOpenOrCloseMaximum())) {
            return SellRecommendation.sell(today.getOpenOrCloseMaximum());
        }

        if (isMaximumHoldDaysReached(today, dayOfBuy)) {
            return SellRecommendation.sell(today.getOpenOrCloseMaximum());
        }

        return SellRecommendation.HOLD;
    }

    private boolean isMaximumHoldDaysReached(StockTradingDay today, StockTradingDay dayOfBuy) {
        return today.getNumberOfDaysAfter(dayOfBuy) >= holdMaxDays();
    }

    private int holdMaxDays() {
        return HOLD_MAX_DAYS;
    }

    protected boolean isRaisedAtLeastMinimum(BigDecimal boughtAt, BigDecimal now) {
        return differenceInPercent(boughtAt, now).compareTo(getSellWhenRaisedMinimumInPercent()) >= 0;

    }

    protected BigDecimal getSellWhenRaisedMinimumInPercent() {
        return SELL_WHEN_RAISED_MINIMUM_IN_PERCENT;
    }


}
