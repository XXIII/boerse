package com.saugstation.boerse.google;

import com.github.kevinsawicki.http.HttpRequest;

import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class GoogleFinanceDownload {
    private final Date startDate;
    private final Date endDate;
    private final StockExchange stockExchange;
    private final Company company;
    private final GoogleFileFormat fileFormat;

    public GoogleFinanceDownload(Date startDate, Date endDate, StockExchange stockExchange, Company company, GoogleFileFormat fileFormat) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.stockExchange = stockExchange;
        this.company = company;
        this.fileFormat = fileFormat;
    }

    public void download(OutputStream os) {
        HttpRequest
                .get("https://www.google.com/finance/historical", createParamMap(), true)
                .receive(os);
    }

    private Map<String, String> createParamMap() {
        Map<String, String> result = new HashMap<>();
        result.put("q", stockExchange.getGoogleFinanceCode() + ":" + company.getGoogleFinanceCode());
        result.put("output", fileFormat.getGoogleFormatName());
        return result;
    }
}
