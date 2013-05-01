package com.github.xxiii.boerse.util;

import java.math.BigDecimal;

public final class BigDecimalUtil {
    private BigDecimalUtil() {
        super();
    }

    public static BigDecimal differenceInPercent(BigDecimal reference, BigDecimal now) {
        return now.divide(reference).subtract(BigDecimal.ONE);
    }
}
