package com.github.xxiii.boerse.trading;

import com.github.xxiii.boerse.stock.Stock;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.testng.Assert.assertEquals;

public class StockTradingDayTest {

    StockTradingDay thisDay;
    StockTradingDay yesterday;

    @Test
    public void testGetChangeInPercentageThisDayOpenYesterdayClose() throws Exception {
        whenThisDayOpen("10");
        whenYesterdayClose("10");
        assertChangeInPercentageThisDayOpenYesterdayCloseIs("0");

        whenThisDayOpen("10");
        whenYesterdayClose("5");
        assertChangeInPercentageThisDayOpenYesterdayCloseIs("1");

        whenThisDayOpen("5");
        whenYesterdayClose("10");
        assertChangeInPercentageThisDayOpenYesterdayCloseIs("-0.5");

        whenThisDayOpen("95");
        whenYesterdayClose("100");
        assertChangeInPercentageThisDayOpenYesterdayCloseIs("-0.05");
    }

    @Test
    public void testGetOpenOrCloseMaximum() {
        whenOpenClose("100", "120");
        assertGetOpenOrCloseMaximum("120");

        whenOpenClose("200", "100");
        assertGetOpenOrCloseMaximum("200");
    }

    @Test
    public void testGetNumberOfDaysAfter() {
        StockTradingDay day1 = new StockTradingDay(new Date(1), Stock.ADIDAS, null, null, null, null);
        StockTradingDay day2 = new StockTradingDay(new Date(3), Stock.ADIDAS, null, null, null, null);
        StockTradingDay day3 = new StockTradingDay(new Date(4), Stock.ADIDAS, null, null, null, null);

        day1.setNextDay(day2);
        day2.setNextDay(day3);

        day3.setPreviousDay(day2);
        day2.setPreviousDay(day1);

        assertEquals(day3.getNumberOfDaysAfter(day3), 0);
        assertEquals(day3.getNumberOfDaysAfter(day2), 1);
        assertEquals(day3.getNumberOfDaysAfter(day1), 2);


    }

    private void assertGetOpenOrCloseMaximum(String maximum) {
        assertEquals(thisDay.getOpenOrCloseMaximum().compareTo(new BigDecimal(maximum)), 0);
    }

    private void whenOpenClose(String open, String close) {
        thisDay = new StockTradingDay(null, null, new BigDecimal(open), null, null, new BigDecimal(close));
    }

    private void assertChangeInPercentageThisDayOpenYesterdayCloseIs(String change) {
        assertEquals(thisDay.getChangeInPercentageThisDayOpenYesterdayClose(), new BigDecimal(change));
    }

    private void whenYesterdayClose(String close) {
        yesterday = new StockTradingDay(new Date(), null, null, null, null, new BigDecimal(close));
        thisDay.setPreviousDay(yesterday);
        yesterday.setNextDay(thisDay);
    }

    private void whenThisDayOpen(String open) {
        thisDay = new StockTradingDay(new Date(), null, new BigDecimal(open), null, null, null);
    }
}
