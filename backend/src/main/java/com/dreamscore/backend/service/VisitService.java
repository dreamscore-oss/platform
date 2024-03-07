package com.dreamscore.backend.service;

import com.dreamscore.backend.model.Visit;
import com.dreamscore.backend.repository.VisitRepository;
import java.time.OffsetDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class VisitService {

    private final VisitRepository visitRepository;

    public VisitService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    public List<Visit> getVisitsFromInterval(OffsetDateTime start, OffsetDateTime end) {
        return visitRepository.findByDateBetween(start, end);
    }
}
