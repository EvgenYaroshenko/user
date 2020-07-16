package com.ievgen.iaroshenko.usercore.controller;


import com.ievgen.iaroshenko.usercommon.controller.CreateUserRequest;
import com.ievgen.iaroshenko.usercore.entity.User;
import com.ievgen.iaroshenko.usercore.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {


    private UserService userService;

    @GetMapping("/{id}")
    //TODO refactor exceptions
    public ResponseEntity<User> getUsersById(@PathVariable(value = "id") UUID userId)  {
        User user =
                userService.findBydId(userId)
                        .orElseThrow(() -> new RuntimeException("User not found on :: " + userId));
        return ResponseEntity.ok().body(user);
    }

    @PostMapping
    //TODO refactor exceptions
    public ResponseEntity<User> createUser(CreateUserRequest request)  {
        User user =
                userService.save(request);
        return ResponseEntity.ok().body(user);
    }
}
