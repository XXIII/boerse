package com.github.xxiii.boerse.analysis.firsttry;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.math.BigDecimal;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class RaisedAtLeastTwoPercentOrSellAfterMaxTenDaysAtAnyPriceSellStrategyTest {
    RaisedAtLeastTwoPercentOrSellAfterMaxTenDaysAtAnyPriceSellStrategy sut;

    @BeforeMethod
    public void setUp() throws Exception {
        sut = spy(new RaisedAtLeastTwoPercentOrSellAfterMaxTenDaysAtAnyPriceSellStrategy());
    }

    @Test
    public void testIsRaisedAtLeastMinimum() throws Exception {
        whenRaiseMinimum("0.05");
        assertIsRaisedAtLeastMinimum("100", "105");
        assertIsRaisedAtLeastMinimum("100", "106");
        assertIsNotRaisedAtLeastMinimum("100", "104");
    }

    private void assertIsNotRaisedAtLeastMinimum(String boughtAt, String now) {
        assertFalse(sut.isRaisedAtLeastMinimum(new BigDecimal(boughtAt), new BigDecimal(now)));
    }

    private void assertIsRaisedAtLeastMinimum(String boughtAt, String now) {
        assertTrue(sut.isRaisedAtLeastMinimum(new BigDecimal(boughtAt), new BigDecimal(now)));
    }

    private void whenRaiseMinimum(String raiseMinimum) {
        doReturn(new BigDecimal(raiseMinimum)).when(sut).getSellWhenRaisedMinimumInPercent();
    }
}
