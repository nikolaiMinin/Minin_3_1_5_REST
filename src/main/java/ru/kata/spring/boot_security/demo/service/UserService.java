package ru.kata.spring.boot_security.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> findByUserName(String name);

    User findUserById(Long id);

    List<User> allUser();

    boolean saveUser(User user);

    void deleteUser(Long userId);

    void update(User user);
}