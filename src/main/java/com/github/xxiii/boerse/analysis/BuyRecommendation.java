package com.github.xxiii.boerse.analysis;

import java.math.BigDecimal;

public class BuyRecommendation {

    public static final BuyRecommendation NO_BUY = new BuyRecommendation(false, null);

    private final boolean buy;
    private final BigDecimal buyAt;

    private BuyRecommendation(boolean buy, BigDecimal buyAt) {
        this.buy = buy;
        this.buyAt = buyAt;
    }

    public static BuyRecommendation buy(BigDecimal buyAt) {
        return new BuyRecommendation(true, buyAt);
    }

    public boolean isBuy() {
        return buy;
    }

    public BigDecimal getBuyAt() {
        return buyAt;
    }
}
