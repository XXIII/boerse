package com.github.xxiii.boerse.market;

import com.github.xxiii.boerse.trader.Account;
import com.github.xxiii.boerse.trader.Portfolio;
import com.github.xxiii.boerse.trading.StockTradingDay;

import java.math.BigDecimal;

public interface Market {

    void buy(StockTradingDay stockTradingDay, BigDecimal price, int quantity, Account account, Portfolio portfolio);

    void sell(StockTradingDay stockTradingDay, BigDecimal price, int quantity, Account account, Portfolio portfolio);
}
