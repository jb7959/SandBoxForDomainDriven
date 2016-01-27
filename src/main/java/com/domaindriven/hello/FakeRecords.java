package com.domaindriven.hello;

/**
 * Created by tony on 2016. 1. 22..
 */
public class FakeRecords {
    public Record getRecord(int i) {
        if(i == 1){
            return new Record("2015.08.29", true, "30,000", "30,000", "임춘봉 1년 커뮤니티 후원금", "후원금");
        }else if(i==2){
            return new Record("2015.08.29", true, "30,000", "60,000", "박세종 1년 커뮤니티 후원금", "후원금");
        }else if(i == 3){
            return new Record("2015.08.31", true, "30,000", "90,000", "안영회 1년 커뮤니티 후원금", "후원금");
        }else if(i == 4){
            return new Record("2015.09.05", false,"12,754", "77,246", "아틀라시안 위키 1달 요금", "위키유지비");
        }else if(i == 5){
            return new Record("2015.09.06", true, "30,000", "107,246", "서정덕 1년 커뮤니티 후원금", "후원금");
        }else if(i == 6){
            return new Record("2015.09.06", true, "30,000", "137,246", "유영모 1년 커뮤니티 후원금", "후원금");
        }else if(i == 7){
            return new Record("2015.10.05", false,"13,727", "123,519", "아틀라시안 위키 1달 요금", "위키유지비");
        }else if(i == 8){
            return new Record("2015.11.05", false,"13,344", "110,175", "아틀라시안 위키 1달 요금", "위키유지비");
        }else if(i == 9){
            return new Record("2015.12.05", false,"13,610", "96,565", "아틀라시안 위키 1달 요금", "위키유지비");
        }else if(i == 10){
            return new Record("2016.01.05", false,"13,947", "82,618", "아틀라시안 위키 1달 요금", "위키유지비");
        }else if(i == 11){
            return new Record("2016.01.09", true, "30,000", "112,618", "정지인 1년 커뮤니티 후원금", "후원금");
        }else if(i == 12){
            return new Record("2016.01.10", true, "30,000", "142,618", "신동렬 1년 커뮤니티 후원금", "후원금");
        }else if(i == 13){
            return new Record("2016.01.11", true, "30,000", "172,618", "김도영 1년 커뮤니티 후원금", "후원금");
        }
        return null;
    }
}
