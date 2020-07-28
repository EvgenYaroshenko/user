package com.ievgen.iaroshenko.usercore.controller;


import com.ievgen.iaroshenko.usercommon.controller.AuthenticationRequest;
import com.ievgen.iaroshenko.usercommon.controller.AuthenticationResponse;
import com.ievgen.iaroshenko.usercommon.controller.CreateUserRequest;
import com.ievgen.iaroshenko.usercore.entity.User;
import com.ievgen.iaroshenko.usercore.service.UserService;
import com.ievgen.iaroshenko.usercore.util.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1.0")
@AllArgsConstructor
public class UserController {
    private AuthenticationManager authenticationManager;
    private UserService userService;
    private JwtUtil jwtTokenUtil;

    @PostMapping(value = "/login")
    //@CrossOrigin
    //TODO refactor it
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        HttpHeaders responseHeaders = new HttpHeaders();

        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
        );

        //if authentication was succesful else throw an exception
        final User userDetails = (User) userService
                .findByUserName(authenticationRequest.getUsername());
        final String jwt = jwtTokenUtil.generateToken(userDetails);
        AuthenticationResponse response = new AuthenticationResponse(jwt);

        response.setId(userDetails.getUuid());
        response.setUsername(userDetails.getUsername());
        List<String> roles = new ArrayList<String>();
        userDetails.getAuthorities().forEach((a) -> roles.add(a.getAuthority()));
        response.setRoles(roles);

        return new ResponseEntity<>(response, responseHeaders, HttpStatus.OK);

    }

    @GetMapping("/users/{id}")
    //TODO refactor exceptions
    public ResponseEntity<User> getUsersById(@PathVariable(value = "id") UUID userId)  {
        User user =
                userService.findBydId(userId)
                        .orElseThrow(() -> new RuntimeException("User not found on :: " + userId));
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/sign-up")
    //TODO refactor exceptions
    public User createUser(@RequestBody CreateUserRequest request)  {
        return userService.save(request);
    }
}
