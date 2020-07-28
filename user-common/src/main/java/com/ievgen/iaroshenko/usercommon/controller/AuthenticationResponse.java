package com.ievgen.iaroshenko.usercommon.controller;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data
public class AuthenticationResponse implements Serializable {

    private final String jwt;
    private UUID id;
	private String username;
    private List<String> roles;

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

}
