package com.github.xxiii.boerse.trader;

import com.github.xxiii.boerse.market.Market;
import com.github.xxiii.boerse.strategy.BuyStrategy;
import com.github.xxiii.boerse.strategy.SellRecommendation;
import com.github.xxiii.boerse.strategy.SellStrategy;
import com.github.xxiii.boerse.trading.StockTradingDay;

public abstract class AbstractTrader implements Trader {

    private final BuyStrategy buyStrategy;
    private final SellStrategy sellStrategy;
    private final Account account;
    private final Portfolio portfolio = new Portfolio();

    public AbstractTrader(BuyStrategy buyStrategy, SellStrategy sellStrategy, Account account) {
        this.buyStrategy = buyStrategy;
        this.sellStrategy = sellStrategy;
        this.account = account;
    }

    public void trade(StockTradingDay stockTradingDay, Market market) {
        checkSell(stockTradingDay, market);
        checkBuy(stockTradingDay, market);
    }

    protected void checkBuy(StockTradingDay stockTradingDay, Market market) {


    }

    protected void checkSell(StockTradingDay stockTradingDay, Market market) {
        for (PortfolioEntry portfolioEntry : getPortfolio().getPortfolioEntriesForStock(stockTradingDay.getStock())) {
            SellRecommendation sellRecommendation = shouldSell(portfolioEntry, market);
            if (sellRecommendation.isSell()) {
                market.sell(stockTradingDay, sellRecommendation.getSellAt(), portfolioEntry.getNumberOfShares(), getAccount(), getPortfolio());
            }
        }
    }

    private SellRecommendation shouldSell(PortfolioEntry portfolioEntry, Market market) {

        return null;
    }

    public Account getAccount() {
        return account;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

}
