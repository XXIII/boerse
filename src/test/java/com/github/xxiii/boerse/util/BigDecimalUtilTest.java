package com.github.xxiii.boerse.util;

import org.testng.annotations.Test;

import java.math.BigDecimal;

import static com.github.xxiii.boerse.util.BigDecimalUtil.differenceInPercent;
import static org.testng.Assert.assertEquals;

public class BigDecimalUtilTest {
    @Test
    public void testDifferenceInPercent() throws Exception {
        assertDifference("1", "1", "0");
        assertDifference("100", "95", "-0.05");
        assertDifference("100", "105", "0.05");
    }

    private void assertDifference(String reference, String now, String difference) {
        assertEquals(differenceInPercent(new BigDecimal(reference), new BigDecimal(now)), new BigDecimal(difference));

    }
}
