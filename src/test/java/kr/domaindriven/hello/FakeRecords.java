package kr.domaindriven.hello;

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
            return new Record(LocalDate.of(2015, Month.AUGUST, 29).atTime(10, 0), true, new Won(30000), new Won(30000), "임춘봉 1년 커뮤니티 후원금", RecordCategory.후원금);
        }else if(i==2){
            return new Record(LocalDate.of(2015, Month.AUGUST, 29).atTime(10, 0), true, new Won(30000), new Won(60000), "박세종 1년 커뮤니티 후원금", RecordCategory.후원금);
        }else if(i == 3){
            return new Record(LocalDate.of(2015, Month.AUGUST, 31).atTime(10, 0), true, new Won(30000), new Won(90000), "안영회 1년 커뮤니티 후원금", RecordCategory.후원금);
        }else if(i == 4){
            return new Record(LocalDate.of(2015, Month.SEPTEMBER, 5).atTime(10, 0), false, new Won(12754),  new Won(77246), "아틀라시안 위키 1달 요금", RecordCategory.위키유지비);
        }else if(i == 5){
            return new Record(LocalDate.of(2015, Month.SEPTEMBER, 6).atTime(10, 0), true, new Won(30000), new Won(107246), "서정덕 1년 커뮤니티 후원금", RecordCategory.후원금);
        }else if(i == 6){
            return new Record(LocalDate.of(2015, Month.SEPTEMBER, 6).atTime(10, 0), true, new Won(30000), new Won(137246), "유영모 1년 커뮤니티 후원금", RecordCategory.후원금);
        }else if(i == 7){
            return new Record(LocalDate.of(2015, Month.OCTOBER, 5).atStartOfDay(), false, new Won(13727), new Won(123519), "아틀라시안 위키 1달 요금", RecordCategory.위키유지비);
        }else if(i == 8){
            return new Record(LocalDate.of(2015, Month.NOVEMBER, 5).atStartOfDay(), false, new Won(13344), new Won(110175), "아틀라시안 위키 1달 요금", RecordCategory.위키유지비);
        }else if(i == 9){
            return new Record(LocalDate.of(2015, Month.DECEMBER, 5).atStartOfDay(), false, new Won(13610), new Won(96565), "아틀라시안 위키 1달 요금", RecordCategory.위키유지비);
        }else if(i == 10){
            return new Record(LocalDate.of(2016, Month.JANUARY, 5).atStartOfDay(), false, new Won(13947), new Won(82618), "아틀라시안 위키 1달 요금", RecordCategory.위키유지비);
        }else if(i == 11){
            return new Record(LocalDate.of(2016, Month.JANUARY, 9).atTime(10, 0), true, new Won(30000), new Won(112618), "정지인 1년 커뮤니티 후원금", RecordCategory.후원금);
        }else if(i == 12){
            return new Record(LocalDate.of(2016, Month.JANUARY, 10).atTime(10, 0), true, new Won(30000), new Won(142618), "신동렬 1년 커뮤니티 후원금", RecordCategory.후원금);
        }else if(i == 13){
            return new Record(LocalDate.of(2016, Month.JANUARY, 11).atTime(10, 0), true, new Won(30000), new Won(172618), "김도영 1년 커뮤니티 후원금", RecordCategory.후원금);
        }else if(i == 14){
            return new Record(LocalDate.of(2016, Month.JANUARY, 23).atTime(10, 0), true, new Won(30000), new Won(202618), "오상택 1년 커뮤니티 후원금", RecordCategory.후원금);
        }
        return null;
    }
}
