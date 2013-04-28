package com.github.xxiii.boerse.stock;

public enum FinancialMarket {
    FRANKFURT("FRA"),
    XETRA("ETR");

    private final String googleFinanceCode;

    private FinancialMarket(String googleFinanceCode) {
        this.googleFinanceCode = googleFinanceCode;
    }

    public String getGoogleFinanceCode() {
        return googleFinanceCode;
    }
}
