package com.example.taskmanagerdemo.controller;

import com.example.taskmanagerdemo.model.Developer;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class UserController {
    public List<Developer> USERLIST = Stream.of(
            new Developer(1L, "Ilya", "Oshlakov"),
            new Developer(2L, "Alina", "Oshlkova")).collect(Collectors.toList());

    @GetMapping("/users")
    public List<Developer> getUsers() {
        return USERLIST;
    }

    @GetMapping("user/{id}")
    public Developer getById(@PathVariable Long id) {
        return USERLIST.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }
    @PostMapping("/new-user/v1/{id}/{firstName}/{lastName}")
    public Developer create(@PathVariable Long id, @PathVariable String firstName, @PathVariable String lastName) {
        Developer newUser = new Developer(id, firstName, lastName);
        USERLIST.add(newUser);
        return newUser;
    }

    @PostMapping("/new-user/v2")
    public Developer create(@RequestBody Developer user) {
        Developer newUser = new Developer(user.getId(), user.getFirstName(), user.getLastName());
        USERLIST.add(newUser);
        return newUser;
    }
    @DeleteMapping("delete-user/{id}")
    public Developer deleteById(@PathVariable Long id) {
        Developer user = USERLIST.stream().filter(element -> element.getId().equals(id)).findFirst().orElse(null);
        if(user == null) {
            return null;
        }
        USERLIST.remove(user);
        return user;
    }
}
