package com.dreamscore.backend.mapper;

import com.dreamscore.backend.dto.VisitWithPetDto;
import com.dreamscore.backend.model.Visit;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = ComponentModel.SPRING)
public interface VisitMapper {
    Visit toEntity(VisitWithPetDto visitWithPetDto);

    VisitWithPetDto toDto(Visit visit);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Visit partialUpdate(VisitWithPetDto visitWithPetDto, @MappingTarget Visit visit);
}
