package com.example.taskmanagerdemo.service;

import com.example.taskmanagerdemo.dto.UserDTO;
import com.example.taskmanagerdemo.mapper.UserListMapperImpl;
import com.example.taskmanagerdemo.mapper.UserMapperImpl;
import com.example.taskmanagerdemo.model.User;
import com.example.taskmanagerdemo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapperImpl userMapper;
    private final UserListMapperImpl userListMapper;

    public UserService(UserRepository userRepository, UserMapperImpl userMapper, UserListMapperImpl userListMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.userListMapper = userListMapper;
    }

    public UserDTO createUser(UserDTO userDTO) {
        User user = userRepository.save(userMapper.userDTOtoUser(userDTO));
        return userMapper.userToUserDTO(user);
    }

    public List<UserDTO> getAllUser() {
        return userListMapper.userListToUserDTOList(userRepository.findAll());
    }
}
