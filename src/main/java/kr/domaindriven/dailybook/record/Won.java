package kr.domaindriven.dailybook.record;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

/**
 * Created by tony on 2016. 1. 30..
 */
public class Won {

    private final String currencyCode = Currency.getInstance(Locale.KOREA).getCurrencyCode();

    private BigDecimal amount;

    public Won(int amount) {
        this.amount = new BigDecimal(amount);
    }

    public BigDecimal toBigDecimal() {
        return amount;
    }

    public String getCurrencyCode() {
        return this.currencyCode;
    }

    @Override
    public String toString() {
        return this.currencyCode + this.amount;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj.getClass().equals(Won.class) ? this.amount.equals(((Won) obj).toBigDecimal()) : false);
    }
}
