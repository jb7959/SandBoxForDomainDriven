package kr.domaindriven.dailybook;

import kr.domaindriven.dailybook.record.Record;
import org.springframework.data.repository.CrudRepository;

/**
 * <p>
 *     {@link Record} 저장소 구현체 인터페이스로 {@link CrudRepository} 상속
 * </p>
 *
 * @author Jerry Ahn
 */
public interface RecordRepository extends CrudRepository<Record,Long> {

    /**
     * 자동생성하는 관리번호(ID 속성)를 이용하여 특정 {@link Record}를 찾는다
     * @param Id
     * @return
     */
    Record findById(Long Id);
}
