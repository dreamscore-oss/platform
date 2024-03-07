package com.dreamscore.backend.repository;

import com.dreamscore.backend.model.Visit;
import java.time.OffsetDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VisitRepository extends JpaRepository<Visit, Long> {
    @Query("select v from Visit v where v.date between :dateStart and :dateEnd order by v.pet.id")
    List<Visit> findByDateBetween(
        @Param("dateStart") OffsetDateTime dateStart,
        @Param("dateEnd") OffsetDateTime dateEnd
    );
}
