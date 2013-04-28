package com.github.xxiii.boerse;

public enum StockExchange {
    FRANKFURT {
        @Override
        public String getGoogleFinanceCode() {
            return "FRA";
        }
    };

    public abstract String getGoogleFinanceCode();
}
