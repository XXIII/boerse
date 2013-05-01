package com.github.xxiii.boerse.strategy;

import com.github.xxiii.boerse.trading.StockTradingDay;

import java.math.BigDecimal;

public interface SellStrategy {

    SellRecommendation sell(StockTradingDay today, StockTradingDay dayOfPurchase, BigDecimal boughtAt);
}
