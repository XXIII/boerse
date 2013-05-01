package com.github.xxiii.boerse.analysis;

import com.github.xxiii.boerse.trading.StockTradingDay;

import java.math.BigDecimal;

public interface SellStrategy {

    SellRecommendation sell(StockTradingDay today, StockTradingDay dayOfBuy, BigDecimal boughtAt);
}
