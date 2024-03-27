package com.dreamscore.backend.service;

import com.dreamscore.backend.entity.User;
import com.dreamscore.backend.repository.UserRepository;
import java.util.Optional;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    @PreAuthorize("#id == authentication.principal.claims['sub']")
    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }
}
