package com.dreamscore.backend.mapper;

import com.dreamscore.backend.model.Pet;
import com.swagger.client.codegen.rest.model.PetDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = ComponentModel.SPRING)
public interface PetMapper {
    com.dreamscore.backend.model.Pet toEntity(PetDto petDto);

    PetDto toDto(com.dreamscore.backend.model.Pet pet);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Pet partialUpdate(PetDto petDto, @MappingTarget Pet pet);
}
