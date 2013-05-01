package com.github.xxiii.boerse.analysis.firsttry;

import com.github.xxiii.boerse.strategy.firsttry.FallDownFivePercentWaitThreeDaysLessThanTwoPercentRaiseBuyStrategy;
import com.github.xxiii.boerse.trading.StockTradingDay;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;
import static org.testng.Assert.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class FallDownFivePercentWaitThreeDaysLessThanTwoPercentRaiseBuyStrategyTest {


    FallDownFivePercentWaitThreeDaysLessThanTwoPercentRaiseBuyStrategy sut;
    StockTradingDay stockTradingDay;

    @BeforeMethod
    public void setUp() throws Exception {
        sut = spy(new FallDownFivePercentWaitThreeDaysLessThanTwoPercentRaiseBuyStrategy());
    }

    @Test
    public void testIsFallDownEventHappened() throws Exception {
        whenLimitIs("-0.05");
        whenFallDownIs("-0.05");
        thenFallDownEventHappened();

        whenLimitIs("-0.05");
        whenFallDownIs("-0.049");
        thenFallDownEventNotHappened();

        whenLimitIs("-0.05");
        whenFallDownIs("-0.051");
        thenFallDownEventHappened();

    }

    @Test
    public void testIsRecoveredAfterWait() {
        whenRaisePercentageMaximumAfterDaysToWait("0.05");
        assertIsRecoveredAfterWait("100", "106");
        assertIsNotRecoveredAfterWait("100", "105");
        assertIsNotRecoveredAfterWait("100", "104");
    }

    private void assertIsNotRecoveredAfterWait(String reference, String now) {
        assertFalse(sut.isRecoveredAfterWait(new BigDecimal(reference), new BigDecimal(now)));
    }

    private void assertIsRecoveredAfterWait(String reference, String now) {
        assertTrue(sut.isRecoveredAfterWait(new BigDecimal(reference), new BigDecimal(now)));
    }

    private void whenRaisePercentageMaximumAfterDaysToWait(String value) {
        doReturn(new BigDecimal(value)).when(sut).getRaisePercentageMaximumAfterDaysToWait();
    }

    private void thenFallDownEventNotHappened() {
        assertFalse(sut.isFallDownEventHappened(stockTradingDay));
    }

    private void thenFallDownEventHappened() {
        assertTrue(sut.isFallDownEventHappened(stockTradingDay));

    }

    private void whenFallDownIs(String fallDown) {
        stockTradingDay = mock(StockTradingDay.class);
        doReturn(new BigDecimal(fallDown)).when(stockTradingDay).getChangeInPercentageThisDayOpenYesterdayClose();
    }

    private void whenLimitIs(String limit) {
        doReturn(new BigDecimal(limit)).when(sut).getFallDownPercentageMinimum();
    }
}
