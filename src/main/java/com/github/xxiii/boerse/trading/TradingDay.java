package com.github.xxiii.boerse.trading;

import java.util.Date;

public class TradingDay {

    private final Date date;

    public TradingDay(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }
}
