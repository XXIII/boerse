package com.github.xxiii.boerse.analysis;

import com.github.xxiii.boerse.trading.StockTradingDay;

public interface BuyStrategy {

    BuyRecommendation buy(StockTradingDay today);
}
