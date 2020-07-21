package com.ievgen.iaroshenko.usercommon.controller;

import lombok.Data;
import javax.validation.constraints.*;

@Data
public class CreateUserRequest {
    @NotNull
    String firstName;
    @NotNull
    String lastName;

    @NotNull
    String userName;

    @NotNull
    String password;

    @NotNull
    String email;
}
