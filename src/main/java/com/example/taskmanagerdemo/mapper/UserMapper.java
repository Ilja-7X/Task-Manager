package com.example.taskmanagerdemo.mapper;

import com.example.taskmanagerdemo.dto.UserDTO;
import com.example.taskmanagerdemo.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User userToUserDTO(UserDTO userDTO);
    UserDTO userDTOtoUser(User user);
}
