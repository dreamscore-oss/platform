package com.dreamscore.backend.mapper;

import com.dreamscore.backend.dto.VisitWithPetDto;
import com.dreamscore.backend.model.Pet;
import com.dreamscore.backend.model.Visit;
import java.time.OffsetDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-07T21:50:35+0100",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.5.jar, environment: Java 21.0.2 (Azul Systems, Inc.)"
)
@Component
public class VisitMapperImpl implements VisitMapper {

    @Override
    public Visit toEntity(VisitWithPetDto visitWithPetDto) {
        if (visitWithPetDto == null) {
            return null;
        }

        Visit visit = new Visit();

        visit.setPet(petDtoToPet(visitWithPetDto.pet()));
        visit.setId(visitWithPetDto.id());
        visit.setDate(visitWithPetDto.date());

        return visit;
    }

    @Override
    public VisitWithPetDto toDto(Visit visit) {
        if (visit == null) {
            return null;
        }

        Long id = null;
        VisitWithPetDto.PetDto pet = null;
        OffsetDateTime date = null;

        id = visit.getId();
        pet = petToPetDto(visit.getPet());
        date = visit.getDate();

        VisitWithPetDto visitWithPetDto = new VisitWithPetDto(id, pet, date);

        return visitWithPetDto;
    }

    @Override
    public Visit partialUpdate(VisitWithPetDto visitWithPetDto, Visit visit) {
        if (visitWithPetDto == null) {
            return visit;
        }

        if (visitWithPetDto.pet() != null) {
            if (visit.getPet() == null) {
                visit.setPet(new Pet());
            }
            petDtoToPet1(visitWithPetDto.pet(), visit.getPet());
        }
        if (visitWithPetDto.id() != null) {
            visit.setId(visitWithPetDto.id());
        }
        if (visitWithPetDto.date() != null) {
            visit.setDate(visitWithPetDto.date());
        }

        return visit;
    }

    protected Pet petDtoToPet(VisitWithPetDto.PetDto petDto) {
        if (petDto == null) {
            return null;
        }

        Pet pet = new Pet();

        pet.setId(petDto.id());
        pet.setName(petDto.name());

        return pet;
    }

    protected VisitWithPetDto.PetDto petToPetDto(Pet pet) {
        if (pet == null) {
            return null;
        }

        Long id = null;
        String name = null;

        id = pet.getId();
        name = pet.getName();

        Long userId = null;

        VisitWithPetDto.PetDto petDto = new VisitWithPetDto.PetDto(id, userId, name);

        return petDto;
    }

    protected void petDtoToPet1(VisitWithPetDto.PetDto petDto, Pet mappingTarget) {
        if (petDto == null) {
            return;
        }

        if (petDto.id() != null) {
            mappingTarget.setId(petDto.id());
        }
        if (petDto.name() != null) {
            mappingTarget.setName(petDto.name());
        }
    }
}
