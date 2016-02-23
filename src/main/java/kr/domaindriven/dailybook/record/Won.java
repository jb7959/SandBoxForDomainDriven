package kr.domaindriven.dailybook.record;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

/**
 * <p>
 *     대한민국 화폐로 금액을 표현하기 위한 클래스
 * </p>
 *
 * @author Younghoe Ahn
 */
public class Won {

    private final String currencyCode = Currency.getInstance(Locale.KOREA).getCurrencyCode();

    private final String symbol = Currency.getInstance(Locale.KOREA).getSymbol();

    private BigDecimal amount;

    public Won(String amount){this(Integer.parseInt(amount));}
    public Won(int amount) {
        this.amount = new BigDecimal(amount);
    }
    public Won(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal toBigDecimal() {
        return amount;
    }

    public String getCurrencyCode() {
        return this.currencyCode;
    }

    /**
     * 데이터베이스에 문자열로 저장할 형식으로 출력
     * @return
     */
    @Override
    public String toString() {
        return this.currencyCode + this.amount;
    }

    public String getSymbol() {
        return symbol;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj.getClass().equals(Won.class) ? this.amount.equals(((Won) obj).toBigDecimal()) : false);
    }
}
