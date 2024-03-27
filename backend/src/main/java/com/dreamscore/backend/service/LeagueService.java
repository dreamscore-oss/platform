package com.dreamscore.backend.service;

import com.dreamscore.backend.entity.League;
import com.dreamscore.backend.repository.LeagueRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LeagueService {

    private final LeagueRepository leagueRepository;

    public LeagueService(LeagueRepository leagueRepository) {
        this.leagueRepository = leagueRepository;
    }

    @Transactional(readOnly = true)
    public Optional<League> getLeagueById(String id) {
        return leagueRepository.findById(id);
    }
}
