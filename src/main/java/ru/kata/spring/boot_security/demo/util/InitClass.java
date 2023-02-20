package ru.kata.spring.boot_security.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

@Component
public class InitClass {

    @Autowired
    private UserService userService;


    public  void createUser() {

        User user = new User("user@gmail.com", "100", "user", 20L, "user");
        user.addRole(new Role("ROLE_USER"));
        User admin = new User("admin@gmail.com", "100", "admin", 220L, "admin");
        admin.addRole(new Role("ROLE_ADMIN"));
        admin.addRole(new Role("ROLE_USER"));

        userService.saveUser(admin);
        userService.saveUser(user);
    }
}
