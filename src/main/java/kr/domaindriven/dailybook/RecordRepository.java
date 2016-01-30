package kr.domaindriven.dailybook;

import kr.domaindriven.dailybook.record.Record;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jerry on 2016-01-26.
 */
public interface RecordRepository extends CrudRepository<Record,Long> {
    Record findById(Long Id);
}
