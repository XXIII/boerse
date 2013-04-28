package com.github.xxiii.boerse.google;

public enum StockExchange {
    FRANKFURT {
        @Override
        public String getGoogleFinanceCode() {
            return "FRA";
        }
    };

    public abstract String getGoogleFinanceCode();
}
