package kr.domaindriven.dailybook.record;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Created by tony on 2016. 1. 30..
 */
@Converter(autoApply = true)
public class WonAttributeConverter implements AttributeConverter<Won, String> {
    @Override
    public String convertToDatabaseColumn(Won attribute) {
        return (attribute == null ? null : attribute.toString());
    }

    @Override
    public Won convertToEntityAttribute(String dbData) {
        return (dbData == null ? null : new Won(Integer.parseInt(dbData.substring("KSW".length()))));
    }
}
