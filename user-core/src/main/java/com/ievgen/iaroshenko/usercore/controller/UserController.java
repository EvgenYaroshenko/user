package com.ievgen.iaroshenko.usercore.controller;


import com.ievgen.iaroshenko.usercommon.controller.CreateUserRequest;
import com.ievgen.iaroshenko.usercore.entity.User;
import com.ievgen.iaroshenko.usercore.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@AllArgsConstructor
public class UserController {


    private UserService userService;

    @GetMapping("/users/{id}")
    //TODO refactor exceptions
    public ResponseEntity<User> getUsersById(@PathVariable(value = "id") UUID userId)  {
        User user =
                userService.findBydId(userId)
                        .orElseThrow(() -> new RuntimeException("User not found on :: " + userId));
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/users")
    //TODO refactor exceptions
    public User createUser(@RequestBody CreateUserRequest request)  {
        return userService.save(request);
    }
}
