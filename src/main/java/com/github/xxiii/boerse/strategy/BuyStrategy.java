package com.github.xxiii.boerse.strategy;

import com.github.xxiii.boerse.trading.StockTradingDay;

public interface BuyStrategy {

    BuyRecommendation buy(StockTradingDay today);
}
