package com.github.xxiii.boerse.trader;

import com.github.xxiii.boerse.strategy.BuyStrategy;
import com.github.xxiii.boerse.strategy.SellStrategy;

import java.math.BigDecimal;

public class Trader {

    private final BuyStrategy buyStrategy;
    private final SellStrategy sellStrategy;
    private BigDecimal cash;
    private Portfolio portfolio;

    public Trader(BuyStrategy buyStrategy, SellStrategy sellStrategy, BigDecimal seedCapital) {
        this.buyStrategy = buyStrategy;
        this.sellStrategy = sellStrategy;
        this.cash = seedCapital;
    }


}
