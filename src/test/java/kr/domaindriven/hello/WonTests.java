package kr.domaindriven.hello;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by tony on 2016. 1. 30..
 */
public class WonTests {

    @Test
    public void using_BigDecimal_and_Currency(){
        BigDecimal decimal = new BigDecimal(30000);
        assertEquals("default scale is 0", 0, decimal.scale()); // h2-console에 30000.00 으로 저장되어 있어서 확인해봄

        Currency won = Currency.getInstance(Locale.KOREA);
        assertEquals("Symbol 확인", "￦", won.getSymbol());
        assertEquals("표시 이름 확인", "대한민국 원", won.getDisplayName());
        assertEquals("통화 코드 확인", "KRW", won.getCurrencyCode());
    }

    @Test
    public void design_Won(){
        // 1. 문자열로 저장하고 앞에 Currency 기호를 부착하자
        Won won = new Won(30000);

        assertEquals("계산할 때는 BigDecimal로", new BigDecimal(30000), won.toBigDecimal());
        assertEquals("Currency에서 추출", "KRW", won.getCurrencyCode());
        assertEquals("DB 저장할 때 숫자 앞에 부착 목적", "KRW30000", won.toString());

        // 2. JPA 2.1 AttributeConverter-powered
        WonAttributeConverter converter = new WonAttributeConverter();
        assertEquals("DB 입력을 위한 값은 String", "KRW30000", converter.convertToDatabaseColumn(won));
        assertEquals("DB에서 꺼내면 Won으로", won, converter.convertToEntityAttribute("KRW30000"));

    }


}
