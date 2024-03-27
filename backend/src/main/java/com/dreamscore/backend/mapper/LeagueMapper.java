package com.dreamscore.backend.mapper;

import com.dreamscore.backend.entity.League;
import com.dreamscore.backend.model.LeagueDto;
import com.dreamscore.backend.model.LeagueSummaryDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface LeagueMapper {
    League toEntity(LeagueDto leagueDto);

    LeagueDto toDto(League league);

    LeagueSummaryDto toSummaryDto(League league);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    League partialUpdate(LeagueDto leagueDto, @MappingTarget League league);
}
