package com.github.xxiii.boerse.trading;

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
