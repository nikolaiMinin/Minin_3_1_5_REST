package ru.kata.spring.boot_security.demo.controller;


import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class RSController {
    private UserService userService;

    private RoleService roleService;

    public RSController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/principal")
    public User getAuthorizedUser(Principal principal) {
        User user = userService.findByUsername(principal.getName());
        return user;
    }



    @GetMapping("/roles")
    public List<Role> showAllRoles() {
        List<Role> allRole = roleService.findAllRoles();
        return allRole;
    }

    @GetMapping("/users")
    public List<User> showAllUsers() {
        List<User> allUsers = userService.findAll();
        return allUsers;
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return user;
    }


    @PostMapping("/users")
    public User addNewUser(@RequestBody User user) {
        userService.svUser(user);
        return user;
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {
        if (user.getRoles().isEmpty()) {
            Set<Role> roles = userService.getUserById(user.getId()).getRoles();
            user.setRoles(roles);
        }
        userService.update(user);
        return user;
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "User with ID = " + id + " was deleted!";
    }
}


