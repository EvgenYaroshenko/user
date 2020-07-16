package com.ievgen.iaroshenko.usercore.service;

import com.ievgen.iaroshenko.usercommon.controller.CreateUserRequest;
import com.ievgen.iaroshenko.usercore.entity.User;

import java.util.Optional;
import java.util.UUID;

public interface UserService {
    Optional<User> findBydId(UUID id);

    User save(CreateUserRequest request);
}
