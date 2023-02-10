package ru.kata.spring.boot_security.demo.service;

import org.springframework.security.core.userdetails.UserDetails;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService {
    void saveUser(User user, long[] listRoles);

    void updateUser(User user, long[] listRoles);

    void update(User user);

    List<User> findAll();

    User getUserById(Long id);

    void deleteById(User user);

    void deleteUser(Long userId);

    User findByUsername(String username);

    List<Role> listRoles();

    UserDetails loadUserByUsername(String username);
    void svUser(User user);

}