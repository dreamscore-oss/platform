package com.dreamscore.backend.api;

import com.dreamscore.backend.entity.User;
import com.dreamscore.backend.mapper.UserMapper;
import com.dreamscore.backend.model.UserDto;
import com.dreamscore.backend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class UsersApiDelegateImpl implements UsersApiDelegate {

    private final UserService userService;
    private final UserMapper userMapper;

    public UsersApiDelegateImpl(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @Override
    public ResponseEntity<Void> addUser() {
        return UsersApiDelegate.super.addUser();
    }

    @Override
    public ResponseEntity<UserDto> getUserById(String userId) {
        User user = userService
            .getUserById(userId)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User Not Found"));

        return new ResponseEntity<>(userMapper.toDto(user), HttpStatus.OK);
    }
}
