package com.dreamscore.backend.service;

import com.dreamscore.backend.mapper.PetMapper;
import com.dreamscore.backend.model.Pet;
import com.dreamscore.backend.repository.PetRepository;
import com.swagger.client.codegen.rest.api.PetApi;
import com.swagger.client.codegen.rest.model.PetDto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PetSyncService {

    private final PetApi petApi;
    private final PetRepository petRepository;
    private final PetMapper petMapper;

    public PetSyncService(PetApi petApi, PetRepository petRepository, PetMapper petMapper) {
        this.petApi = petApi;
        this.petRepository = petRepository;
        this.petMapper = petMapper;
    }

    public Pet syncPetById(Long id) {
        return petRepository.existsById(id) ? updatePetById(id) : addPet(id);
    }

    private Pet addPet(Long id) {
        PetDto petDto = petApi.getPetById(id);
        return petRepository.save(petMapper.toEntity(petDto));
    }

    private Pet updatePetById(Long id) {
        Pet pet = petRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        Pet updatedPet = petMapper.partialUpdate(petApi.getPetById(id), pet);
        return petRepository.save(updatedPet);
    }
}
