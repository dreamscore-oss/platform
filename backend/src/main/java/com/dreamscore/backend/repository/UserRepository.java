package com.dreamscore.backend.repository;

import com.dreamscore.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {}
