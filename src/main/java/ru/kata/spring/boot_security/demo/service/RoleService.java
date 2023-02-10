package ru.kata.spring.boot_security.demo.service;


import ru.kata.spring.boot_security.demo.model.Role;

import java.util.List;

public interface RoleService {
    Role findById(long role_id);
    Role addRole(Role role);

    List<Role> findAllRoles();
}
