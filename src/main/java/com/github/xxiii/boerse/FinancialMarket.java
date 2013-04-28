package com.github.xxiii.boerse;

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
