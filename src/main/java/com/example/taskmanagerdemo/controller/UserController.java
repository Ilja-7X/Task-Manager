package com.example.taskmanagerdemo.controller;

import com.example.taskmanagerdemo.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class UserController {
    public List<User> USERLIST = Stream.of(
            new User(1L, "Ilya", "Oshlakov"),
            new User(2L, "Alina", "Oshlkova")).collect(Collectors.toList());

    @GetMapping("/")
    public String getString() {
        return "Welcome!";
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return USERLIST;
    }

    @GetMapping("user/{id}")
    public User getById(@PathVariable Long id) {
        return USERLIST.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }

    @PostMapping("/new-user/v1/{id}/{firstName}/{lastName}")
    public User create(@PathVariable Long id, @PathVariable String firstName, @PathVariable String lastName) {
        User newUser = new User(id, firstName, lastName);
        USERLIST.add(newUser);
        return newUser;
    }

    @PostMapping("/new-user/v2")
    public User create(@RequestBody User user) {
        User newUser = new User(user.getId(), user.getFirstName(), user.getLastName());
        USERLIST.add(newUser);
        return newUser;
    }
    @DeleteMapping("delete-user/{id}")
    public User deleteById(@PathVariable Long id) {
        User user = USERLIST.stream().filter(element -> element.getId().equals(id)).findFirst().orElse(null);
        if(user == null) {
            return null;
        }
        USERLIST.remove(user);
        return user;
    }
}
