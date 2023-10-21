package com.example.taskmanagerdemo.controller;

import com.example.taskmanagerdemo.dto.UserDTO;
import com.example.taskmanagerdemo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    private ResponseEntity<List<UserDTO>> getUsers() {
        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.ACCEPTED);
    }


}
