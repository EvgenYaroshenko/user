package com.ievgen.iaroshenko.usercore.service.impl;


import com.ievgen.iaroshenko.usercommon.controller.CreateUserRequest;
import com.ievgen.iaroshenko.usercore.entity.Role;
import com.ievgen.iaroshenko.usercore.entity.User;
import com.ievgen.iaroshenko.usercore.repository.UserRepository;
import com.ievgen.iaroshenko.usercore.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    public Optional<User> findBydId(UUID id) {
        return userRepository.findById(id);
    }

    @Override
    public User save(CreateUserRequest request) {
        return userRepository.save(userRepository.save(User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getFirstName())
                .userName(request.getUserName())
//                .passwordHash(bCryptPasswordEncoder.encode(request.getPassword()))
                .passwordHash(request.getPassword())
                .role(Role.USER)
                .email(request.getEmail())
                .build()));
    }

    @Override
    public User findByUserName(String userName) {
        //TODO add proper exception
        return userRepository.findByUserName(userName).orElseThrow();
    }
}
