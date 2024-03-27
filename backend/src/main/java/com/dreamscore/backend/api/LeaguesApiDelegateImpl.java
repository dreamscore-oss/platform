package com.dreamscore.backend.api;

import com.dreamscore.backend.entity.League;
import com.dreamscore.backend.mapper.LeagueMapper;
import com.dreamscore.backend.model.LeagueSummaryDto;
import com.dreamscore.backend.service.LeagueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class LeaguesApiDelegateImpl implements LeaguesApiDelegate {

    private final LeagueService leagueService;
    private final LeagueMapper leagueMapper;

    public LeaguesApiDelegateImpl(LeagueService leagueService, LeagueMapper leagueMapper) {
        this.leagueService = leagueService;
        this.leagueMapper = leagueMapper;
    }

    @Override
    public ResponseEntity<LeagueSummaryDto> getLeagueById(String leagueId) {
        League league = leagueService
            .getLeagueById(leagueId)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "League Not Found"));

        return new ResponseEntity<>(leagueMapper.toSummaryDto(league), HttpStatus.OK);
    }
}
