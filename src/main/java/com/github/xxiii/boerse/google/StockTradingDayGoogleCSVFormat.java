package com.github.xxiii.boerse.google;

import com.github.xxiii.boerse.stock.Stock;
import com.github.xxiii.boerse.trading.StockTradingDay;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StockTradingDayGoogleCSVFormat extends StockTradingDay {


    private static final int POSITION_DATE = 0;
    private static final int POSITION_OPEN = 1;
    private static final int POSITION_HIGH = 2;
    private static final int POSITION_LOW = 3;
    private static final int POSITION_CLOSE = 4;

    public StockTradingDayGoogleCSVFormat(Stock stock, String[] csvLineAsArray) {
        super(parseDate(csvLineAsArray[POSITION_DATE]), stock, parse(csvLineAsArray[POSITION_OPEN]), parse(csvLineAsArray[POSITION_HIGH]), parse(csvLineAsArray[POSITION_LOW]), parse(csvLineAsArray[POSITION_CLOSE]));
    }

    protected static Date parseDate(String s) {
        try {
            return new SimpleDateFormat("d-MMM-yy").parse(s);
        } catch (ParseException e) {
            throw new RuntimeException("Error, parsing Date: '" + s + "'", e);
        }
    }

    protected static BigDecimal parse(String s) {
        return new BigDecimal(s);
    }
}
