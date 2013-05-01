package com.github.xxiii.boerse.analysis;

import java.math.BigDecimal;

public class SellRecommendation {

    public static final SellRecommendation HOLD = new SellRecommendation(false, null);
    private final boolean sell;
    private final BigDecimal sellAt;

    private SellRecommendation(boolean sell, BigDecimal sellAt) {
        this.sell = sell;
        this.sellAt = sellAt;
    }

    public static SellRecommendation sell(BigDecimal sellAt) {
        return new SellRecommendation(true, sellAt);
    }

    public boolean isSell() {
        return sell;
    }

    public BigDecimal getSellAt() {
        return sellAt;
    }
}
