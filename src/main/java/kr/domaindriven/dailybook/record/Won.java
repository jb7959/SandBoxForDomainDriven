package kr.domaindriven.dailybook.record;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;
import java.util.regex.Pattern;

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

    //문자열 숫자열을 구분함.
    public Won(String amount){
        String cha = amount.replaceAll("[^-]","");
        String num = amount.replaceAll( "[^0-9]", "");
        this.amount = new BigDecimal(cha+num);
    }
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
