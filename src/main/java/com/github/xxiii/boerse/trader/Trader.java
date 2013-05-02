package com.github.xxiii.boerse.trader;

import com.github.xxiii.boerse.market.Market;
import com.github.xxiii.boerse.trading.StockTradingDay;

public interface Trader {

    void trade(StockTradingDay stockTradingDay, Market market);

}
