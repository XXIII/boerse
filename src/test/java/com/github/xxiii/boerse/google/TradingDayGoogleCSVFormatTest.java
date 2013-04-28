package com.github.xxiii.boerse.google;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TradingDayGoogleCSVFormatTest {
    @Test
    public void testParseDate() throws Exception {
        assertEquals(GoogleCSVFormatStockTradingDay.parseDate("26-Apr-13"), GoogleFinanceDownload.createDate(2013, 4, 26));
        assertEquals(GoogleCSVFormatStockTradingDay.parseDate("2-Apr-13"), GoogleFinanceDownload.createDate(2013, 4, 2));

        assertEquals(GoogleCSVFormatStockTradingDay.parseDate("28-Mar-13"), GoogleFinanceDownload.createDate(2013, 3, 28));


    }

    @Test
    public void testParse() {
        assertEquals(GoogleCSVFormatStockTradingDay.parse("4.5").doubleValue(), 4.5d);
    }
}
