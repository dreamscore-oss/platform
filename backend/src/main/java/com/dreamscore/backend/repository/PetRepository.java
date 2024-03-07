package com.dreamscore.backend.repository;

import com.dreamscore.backend.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {}
