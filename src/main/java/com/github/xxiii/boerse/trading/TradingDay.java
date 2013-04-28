package com.github.xxiii.boerse.trading;

import java.util.Date;

public class TradingDay<D extends TradingDay> {

    private final Date date;

    private D previousDay;
    private D nextDay;

    public TradingDay(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public D getPreviousDay() {
        return previousDay;
    }

    public void setPreviousDay(D previousDay) {
        this.previousDay = previousDay;
    }

    public D getNextDay() {
        return nextDay;
    }

    public void setNextDay(D nextDay) {
        this.nextDay = nextDay;
    }
}
