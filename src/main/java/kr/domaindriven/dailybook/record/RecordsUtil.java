package kr.domaindriven.dailybook.record;

/**
 * Created by Jerry on 2016-02-07.
 */
public final class RecordsUtil {
    public String change(String CharacterOfCurrency ){
        String resultCharacter = "";
        if(CharacterOfCurrency.equals("KRW")){
            resultCharacter = "\\";
        }
        return resultCharacter;
    }
}
