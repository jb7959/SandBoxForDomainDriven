package com.domaindriven.hello;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

/**
 * Created by tony on 2016. 1. 22..
 */
public class FakeRecords {

    public Record getRecord(int i) {
        if(i == 1){
            return new Record(LocalDate.of(2015, Month.AUGUST, 29).atTime(10, 0), true, Money.of(CurrencyUnit.of("KRW"), new BigDecimal(30000)), "30,000", "임춘봉 1년 커뮤니티 후원금", "후원금");
        }else if(i==2){
            return new Record(LocalDate.of(2015, Month.AUGUST, 29).atTime(10, 0), true, Money.of(CurrencyUnit.of("KRW"), new BigDecimal(30000)), "60,000", "박세종 1년 커뮤니티 후원금", "후원금");
        }else if(i == 3){
            return new Record(LocalDate.of(2015, Month.AUGUST, 31).atTime(10, 0), true, Money.of(CurrencyUnit.of("KRW"), new BigDecimal(30000)), "90,000", "안영회 1년 커뮤니티 후원금", "후원금");
        }else if(i == 4){
            return new Record(LocalDate.of(2015, Month.SEPTEMBER, 5).atTime(10, 0), false,Money.of(CurrencyUnit.of("KRW"), new BigDecimal(12754)),  "77,246", "아틀라시안 위키 1달 요금", "위키유지비");
        }else if(i == 5){
            return new Record(LocalDate.of(2015, Month.SEPTEMBER, 6).atTime(10, 0), true, Money.of(CurrencyUnit.of("KRW"), new BigDecimal(30000)), "107,246", "서정덕 1년 커뮤니티 후원금", "후원금");
        }else if(i == 6){
            return new Record(LocalDate.of(2015, Month.SEPTEMBER, 6).atTime(10, 0), true, Money.of(CurrencyUnit.of("KRW"), new BigDecimal(30000)), "137,246", "유영모 1년 커뮤니티 후원금", "후원금");
        }else if(i == 7){
            return new Record(LocalDate.of(2015, Month.OCTOBER, 5).atStartOfDay(), false, Money.of(CurrencyUnit.of("KRW"), new BigDecimal(13727)), "123,519", "아틀라시안 위키 1달 요금", "위키유지비");
        }else if(i == 8){
            return new Record(LocalDate.of(2015, Month.NOVEMBER, 5).atStartOfDay(), false, Money.of(CurrencyUnit.of("KRW"), new BigDecimal(13344)), "110,175", "아틀라시안 위키 1달 요금", "위키유지비");
        }else if(i == 9){
            return new Record(LocalDate.of(2015, Month.DECEMBER, 5).atStartOfDay(), false, Money.of(CurrencyUnit.of("KRW"), new BigDecimal(13610)), "96,565", "아틀라시안 위키 1달 요금", "위키유지비");
        }else if(i == 10){
            return new Record(LocalDate.of(2016, Month.JANUARY, 5).atStartOfDay(), false, Money.of(CurrencyUnit.of("KRW"), new BigDecimal(13947)), "82,618", "아틀라시안 위키 1달 요금", "위키유지비");
        }else if(i == 11){
            return new Record(LocalDate.of(2016, Month.JANUARY, 9).atTime(10, 0), true,Money.of(CurrencyUnit.of("KRW"), new BigDecimal(30000)), "112,618", "정지인 1년 커뮤니티 후원금", "후원금");
        }else if(i == 12){
            return new Record(LocalDate.of(2016, Month.JANUARY, 10).atTime(10, 0), true,Money.of(CurrencyUnit.of("KRW"), new BigDecimal(30000)), "142,618", "신동렬 1년 커뮤니티 후원금", "후원금");
        }else if(i == 13){
            return new Record(LocalDate.of(2016, Month.JANUARY, 11).atTime(10, 0), true, Money.of(CurrencyUnit.of("KRW"), new BigDecimal(30000)), "172,618", "김도영 1년 커뮤니티 후원금", "후원금");
        }else if(i == 14){
            return new Record(LocalDate.of(2016, Month.JANUARY, 23).atTime(10, 0), true, Money.of(CurrencyUnit.of("KRW"), new BigDecimal(30000)), "202,618", "오상택 1년 커뮤니티 후원금", "후원금");
        }
        return null;
    }
}
