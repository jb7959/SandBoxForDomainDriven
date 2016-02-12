package kr.domaindriven.dailybook.record.jpa;

import kr.domaindriven.dailybook.record.Won;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 *<p>
 *     {@link Won} 데이터를 KSW와 금액을 합친 문자열 데이터로 변환하여 데이터베이스에 저장하기 위한 클래스로
 *     JPA {@link AttributeConverter} 구현하여 작성
 * </p>
 *
 * @author Younghoe Ahn
 */
@Converter(autoApply = true)
public class WonAttributeConverter implements AttributeConverter<Won, String> {
    /**
     * 문자열 형식은 {@link Won#toString()} 메소드 결과를 따름
     * @param attribute
     * @return
     */
    @Override
    public String convertToDatabaseColumn(Won attribute) {
        return (attribute == null ? null : attribute.toString());
    }

    /**
     * 데이터베이스에서 저장된 값에서 통화 코드인 KSW를 제외한 금액 숫자 값을 이용해서 {@link Won} 객체를 생성하여 반환
     * @param dbData
     * @return
     */
    @Override
    public Won convertToEntityAttribute(String dbData) {
        return (dbData == null ? null : new Won(Integer.parseInt(dbData.substring("KSW".length()))));
    }
}
