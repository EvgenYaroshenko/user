package com.ievgen.iaroshenko.usercore.entity;

import java.util.Arrays;

//Should be mapped to the same values as in migration scripts
public enum Role {
    ADMIN(0),
    USER(1);

    private int id;

    Role(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static Role fromId(int id) {
        return Arrays.stream(Role.values())
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
