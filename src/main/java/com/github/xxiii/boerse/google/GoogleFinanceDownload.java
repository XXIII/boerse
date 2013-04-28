package com.github.xxiii.boerse.google;

import com.github.kevinsawicki.http.HttpRequest;
import com.github.xxiii.boerse.stock.FinancialMarket;
import com.github.xxiii.boerse.stock.Stock;
import org.joda.time.DateTime;

import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class GoogleFinanceDownload {
    private final Date startDate;
    private final Date endDate;
    private final FinancialMarket financialMarket;
    private final Stock stock;
    private final GoogleFileFormat fileFormat;

    public GoogleFinanceDownload(Date startDate, Date endDate, FinancialMarket financialMarket, Stock stock, GoogleFileFormat fileFormat) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.financialMarket = financialMarket;
        this.stock = stock;
        this.fileFormat = fileFormat;
    }

    public void download(OutputStream os) {
        HttpRequest httpRequest = HttpRequest
                .get("https://www.google.com/finance/historical", createParamMap(), false);
        System.out.println(httpRequest.url());
        httpRequest
                .receive(os);
    }

    private Map<String, String> createParamMap() {
        Map<String, String> result = new HashMap<>();
        result.put("q", financialMarket.getGoogleFinanceCode() + ":" + stock.getGoogleFinanceCode());
        result.put("output", fileFormat.getGoogleFormatName());
        result.put("startdate", formatDate(startDate));
        result.put("enddate", formatDate(endDate));
        return result;
    }

    protected String formatDate(Date date) {
        return new SimpleDateFormat("MMM+d,+yyyy").format(date);
    }

    public static Date createDate(int year, int month, int day) {
        return new DateTime(year, month, day, 0, 0, 0).toDate();
    }
}
