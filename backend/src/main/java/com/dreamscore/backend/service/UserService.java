package com.dreamscore.backend.service;

import com.dreamscore.backend.entity.User;
import com.dreamscore.backend.repository.UserRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public Optional<User> getUser(String id) {
        return userRepository.findById(id);
    }
}
