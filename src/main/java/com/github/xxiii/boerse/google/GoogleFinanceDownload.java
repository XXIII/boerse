package com.github.xxiii.boerse.google;

import com.github.kevinsawicki.http.HttpRequest;
import com.github.xxiii.boerse.Stock;
import com.github.xxiii.boerse.StockExchange;

import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class GoogleFinanceDownload {
    private final Date startDate;
    private final Date endDate;
    private final StockExchange stockExchange;
    private final Stock stock;
    private final GoogleFileFormat fileFormat;

    public GoogleFinanceDownload(Date startDate, Date endDate, StockExchange stockExchange, Stock stock, GoogleFileFormat fileFormat) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.stockExchange = stockExchange;
        this.stock = stock;
        this.fileFormat = fileFormat;
    }

    public void download(OutputStream os) {
        HttpRequest
                .get("https://www.google.com/finance/historical", createParamMap(), true)
                .receive(os);
    }

    private Map<String, String> createParamMap() {
        Map<String, String> result = new HashMap<>();
        result.put("q", stockExchange.getGoogleFinanceCode() + ":" + stock.getGoogleFinanceCode());
        result.put("output", fileFormat.getGoogleFormatName());
        return result;
    }
}
