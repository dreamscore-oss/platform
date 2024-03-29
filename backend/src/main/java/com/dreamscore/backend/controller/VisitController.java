package com.dreamscore.backend.controller;

import com.dreamscore.backend.dto.VisitWithPetDto;
import com.dreamscore.backend.mapper.VisitMapper;
import com.dreamscore.backend.service.VisitService;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/visit")
public class VisitController {

    private final VisitService visitService;
    private final VisitMapper visitMapper;

    public VisitController(VisitService visitService, VisitMapper visitMapper) {
        this.visitService = visitService;
        this.visitMapper = visitMapper;
    }

    @GetMapping("/from-interval")
    public List<VisitWithPetDto> getVisitsFromInterval(
        @RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) OffsetDateTime start,
        @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) OffsetDateTime end
    ) {
        return visitService
            .getVisitsFromInterval(start, end)
            .stream()
            .map(visitMapper::toDto)
            .collect(Collectors.toList());
    }
}
