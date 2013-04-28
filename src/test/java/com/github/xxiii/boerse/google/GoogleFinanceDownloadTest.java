package com.github.xxiii.boerse.google;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.github.xxiii.boerse.google.GoogleFinanceDownload.createDate;
import static org.mockito.Mockito.CALLS_REAL_METHODS;
import static org.mockito.Mockito.mock;
import static org.testng.Assert.assertEquals;

public class GoogleFinanceDownloadTest {

    GoogleFinanceDownload download;

    @BeforeMethod
    public void init() {
        download = mock(GoogleFinanceDownload.class, CALLS_REAL_METHODS);
    }

    @Test
    public void testFormatDate() throws Exception {
        assertEquals(download.formatDate(createDate(2000, 4, 1)), "Apr+1,+2000");
        assertEquals(download.formatDate(createDate(2000, 11, 12)), "Nov+12,+2000");
    }


}
