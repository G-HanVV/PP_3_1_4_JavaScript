package ru.truecasper.javascript.services;

import ru.truecasper.javascript.models.Role;

import java.util.List;

public interface RoleService {

    List<Role> findAll();

    Role findById(String id);
}
