package com.github.xxiii.boerse.analysis.firsttry;

import com.github.xxiii.boerse.analysis.BuyRecommendation;
import com.github.xxiii.boerse.analysis.BuyStrategy;
import com.github.xxiii.boerse.trading.StockTradingDay;

import java.math.BigDecimal;

import static com.github.xxiii.boerse.util.BigDecimalUtil.differenceInPercent;

/**
 * Idee:
 * <p/>
 * Aktie ist vor drei Tagen von close auf open um mindestens 5% gefallen und hat sich seitdem *nicht*
 * mehr als zwei Prozent erholt, dann zuschlagen
 */
public class FallDownFivePercentWaitThreeDaysLessThanTwoPercentRaiseBuyStrategy implements BuyStrategy {

    private static final BigDecimal FALL_DOWN_PERCENTAGE_MINIMUM = new BigDecimal("-0.05");
    private static final int DAYS_TWO_WAIT = 3;
    private static final BigDecimal RAISE_PERCENTAGE_MAXIMUM_AFTER_DAYS_TO_WAIT = new BigDecimal("0.02");

    @Override
    public BuyRecommendation buy(StockTradingDay stockTradingDay) {
        StockTradingDay stockTradingDayBeforeDaysToWait = getStockTradingDayBeforeDaysToWait(stockTradingDay);
        if (stockTradingDayBeforeDaysToWait == null || stockTradingDayBeforeDaysToWait.getPreviousDay() == null) {
            return BuyRecommendation.NO_BUY; // NO DATA
        }
        if (isFallDownEventHappened(stockTradingDayBeforeDaysToWait) && !isRecoveredAfterWait(stockTradingDayBeforeDaysToWait, stockTradingDay)) {
            return BuyRecommendation.buy(stockTradingDay.getOpen());
        }
        return BuyRecommendation.NO_BUY;
    }

    protected boolean isRecoveredAfterWait(StockTradingDay stockTradingDayBeforeDaysToWait, StockTradingDay stockTradingDay) {
        return isRecoveredAfterWait(stockTradingDayBeforeDaysToWait.getOpen(), stockTradingDay.getOpen());
    }

    protected boolean isRecoveredAfterWait(BigDecimal reference, BigDecimal now) {
        return differenceInPercent(reference, now).compareTo(getRaisePercentageMaximumAfterDaysToWait()) > 0;
    }

    protected BigDecimal getRaisePercentageMaximumAfterDaysToWait() {
        return RAISE_PERCENTAGE_MAXIMUM_AFTER_DAYS_TO_WAIT;
    }

    protected boolean isFallDownEventHappened(StockTradingDay stockTradingDay) {
        return stockTradingDay.getChangeInPercentageThisDayOpenYesterdayClose().compareTo(getFallDownPercentageMinimum()) <= 0;

    }

    protected BigDecimal getFallDownPercentageMinimum() {
        return FALL_DOWN_PERCENTAGE_MINIMUM;
    }

    private StockTradingDay getStockTradingDayBeforeDaysToWait(StockTradingDay stockTradingDay) {
        StockTradingDay result = stockTradingDay;
        for (int i = 0; result != null && i < DAYS_TWO_WAIT; i++) {
            result = result.getPreviousDay();
        }
        return result;
    }
}
