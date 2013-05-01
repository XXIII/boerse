package com.github.xxiii.boerse.analysis;

public class BuyRecommendation {

    public static final BuyRecommendation BUY = new BuyRecommendation(true);
    public static final BuyRecommendation NO_BUY = new BuyRecommendation(false);

    private final boolean buy;

    public BuyRecommendation(boolean buy) {
        this.buy = buy;
    }

    public boolean isBuy() {
        return buy;
    }
}
