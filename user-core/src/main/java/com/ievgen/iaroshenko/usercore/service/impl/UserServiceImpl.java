package com.ievgen.iaroshenko.usercore.service.impl;


import com.ievgen.iaroshenko.usercommon.controller.CreateUserRequest;
import com.ievgen.iaroshenko.usercore.entity.User;
import com.ievgen.iaroshenko.usercore.repository.UserRepository;
import com.ievgen.iaroshenko.usercore.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public Optional<User> findBydId(UUID id) {
        return userRepository.findById(id);
    }

    @Override
    public User save(CreateUserRequest request) {
        return userRepository.save(userRepository.save(new User()));
    }
}
