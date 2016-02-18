package kr.domaindriven.dailybook;

import kr.domaindriven.dailybook.record.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * <p>
 *     {@link Record} 저장소 구현체 인터페이스로 {@link JpaRepository} 상속
 * </p>
 *
 * @author Jerry Ahn
 */
public interface RecordRepository extends JpaRepository<Record,Long> {

    public final static String FIND_BY_LAST_RECORD_ID = "select max(id) from Record";

    /**
     * 자동생성하는 관리번호(ID 속성)를 이용하여 특정 {@link Record}를 찾는다
     * @param Id
     * @return Record
     */
    Record findById(Long Id);

    /**
     * FIND_BY_LAST_RECORD_ID를 이용하여 마지막 {@link Record}의 ID를 찾는다
     * @param
     * @return Long
     */
    @Query(FIND_BY_LAST_RECORD_ID)
    Long findByLastRecordId();

}
