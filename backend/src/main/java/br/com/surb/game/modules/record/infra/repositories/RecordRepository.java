package br.com.surb.game.modules.record.infra.repositories;

import br.com.surb.game.modules.record.infra.entities.Record;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.Instant;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {

    @Query("SELECT record FROM Record record WHERE "
            + "(COALESCE(:minDate, NULL) IS NULL OR record.createdAt >= :minDate) AND "
            + "(COALESCE(:maxDate, NULL) IS NULL OR record.createdAt <= :maxDate)")
    Page<Record> findByMoments(Instant minDate, Instant maxDate, Pageable pageable);
}
