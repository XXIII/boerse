package com.github.xxiii.boerse;

public enum StockExchange {
    FRANKFURT("FRA"),
    XETRA("ETR");

    private final String googleFinanceCode;

    private StockExchange(String googleFinanceCode) {
        this.googleFinanceCode = googleFinanceCode;
    }

    public String getGoogleFinanceCode() {
        return googleFinanceCode;
    }
}
