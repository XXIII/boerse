package com.github.xxiii.boerse;

import com.github.xxiii.boerse.google.DaxGoogleCSVFileStockTradingDayHistoryLoader;
import com.github.xxiii.boerse.trading.StockTradingDay;
import com.github.xxiii.boerse.trading.StockTradingDayHistory;

import java.util.List;

public class LoadGoogleDaxFiles {

    public static void main(String[] args) {

        List<StockTradingDayHistory> histories = new DaxGoogleCSVFileStockTradingDayHistoryLoader().getStockTradingDayHistories();
        for (StockTradingDayHistory history : histories) {
            int count = 0;
            StockTradingDay stockTradingPreviousDay = null;
            for (StockTradingDay stockTradingDay : history.getStockTradingDays()) {

                if (stockTradingPreviousDay != null) {
                    double thisDayOpen = stockTradingDay.getOpen().doubleValue();
                    double previousDayClose = stockTradingPreviousDay.getClose().doubleValue();
                    if (((thisDayOpen / previousDayClose) - 1d) <= -0.05d) {
                        count++;
                        if (isRaisedTwoPercentInNext15Days(thisDayOpen, stockTradingDay)) {

                        }
                    }

                }

                stockTradingPreviousDay = stockTradingDay;

            }
            System.out.println(count);
        }


    }

    private static boolean isRaisedTwoPercentInNext15Days(double thisDayOpen, StockTradingDay stockTradingDay) {


        return false;
    }
}
