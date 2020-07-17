package com.ievgen.iaroshenko.usercore.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class RoleConverter  implements AttributeConverter<Role, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Role role) {
        return (role != null) ? role.getId() : null;
    }

    @Override
    public Role convertToEntityAttribute(Integer id) {
        return (id != null) ? Role.fromId(id) : null;
    }
}