package com.github.xxiii.boerse;

import com.github.xxiii.boerse.google.DaxGoogleCSVFileStockTradingDayHistorieLoader;
import com.github.xxiii.boerse.trading.StockTradingDay;
import com.github.xxiii.boerse.trading.StockTradingDayHistory;

import java.util.List;

public class LoadGoogleDaxFiles {

    public static void main(String[] args) {

        List<StockTradingDayHistory> histories = new DaxGoogleCSVFileStockTradingDayHistorieLoader().getStockTradingDayHistories();
        for (StockTradingDayHistory history : histories) {
            int count = 0;
            StockTradingDay stockTradingPreviousDay = null;
            for (StockTradingDay stockTradingDay : history.getStockTradingDays()) {

                if (stockTradingPreviousDay != null) {
                    double thisDayOpen = stockTradingDay.getOpen().doubleValue();
                    double previousDayClose = stockTradingPreviousDay.getClose().doubleValue();
                    if (((thisDayOpen / previousDayClose) - 1d) <= -0.05d) {
                        count++;
                    }

                }

                stockTradingPreviousDay = stockTradingDay;

            }
            System.out.println(count);
        }


    }
}
