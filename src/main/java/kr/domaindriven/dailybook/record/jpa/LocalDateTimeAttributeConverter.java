package kr.domaindriven.dailybook.record.jpa;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * <p>
 *     {@link LocalDateTime} 데이터를 {@link Timestamp} 데이터로 변환하여 데이터베이스에 저장하기 위한 클래스로
 *     JPA {@link AttributeConverter} 구현하여 작성
 * </p>
 *
 * @author Younghoe Ahn
 */

@Converter(autoApply = true)
public class LocalDateTimeAttributeConverter implements AttributeConverter<LocalDateTime, Timestamp>{
    @Override
    public Timestamp convertToDatabaseColumn(LocalDateTime attribute) {
        return (attribute == null ? null : Timestamp.valueOf(attribute));
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Timestamp dbData) {
        return (dbData == null ? null : dbData.toLocalDateTime());
    }
}
