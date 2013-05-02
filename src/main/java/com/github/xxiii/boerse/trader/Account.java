package com.github.xxiii.boerse.trader;

import java.math.BigDecimal;

public class Account {
    private BigDecimal amount;

    public Account(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void add(BigDecimal cash) {
        amount = amount.add(cash);
    }

    public void subtract(BigDecimal cash) {
        amount = amount.subtract(cash);
    }
}
