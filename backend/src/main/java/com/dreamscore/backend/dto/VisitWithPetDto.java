package com.dreamscore.backend.dto;

import java.io.Serializable;
import java.time.OffsetDateTime;

/**
 * A DTO for the {@link com.dreamscore.backend.model.Visit} entity
 */

public record VisitWithPetDto(Long id, com.dreamscore.backend.dto.VisitWithPetDto.PetDto pet, OffsetDateTime date)
    implements Serializable {
    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" + "id = " + id + ", " + "pet = " + pet + ", " + "date = " + date + ")";
    }

    /**
     * A DTO for the {@link com.dreamscore.backend.model.Pet} entity
     */

    public record PetDto(Long id, Long userId, String name) implements Serializable {
        @Override
        public String toString() {
            return (
                getClass().getSimpleName() +
                "(" +
                "id = " +
                id +
                ", " +
                "userId = " +
                userId +
                ", " +
                "name = " +
                name +
                ")"
            );
        }
    }
}
