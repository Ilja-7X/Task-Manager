package com.example.taskmanagerdemo.controller;

import com.example.taskmanagerdemo.dto.UserDTO;
import com.example.taskmanagerdemo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("new")
    private ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDTO, BindingResult result) {
        if(result.hasErrors()) {
            return new ResponseEntity<>(userDTO, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
    }

    @GetMapping()
    private ResponseEntity<List<UserDTO>> getUsers() {
        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.ACCEPTED);
    }


}
