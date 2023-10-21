package com.example.taskmanagerdemo.mapper;

import com.example.taskmanagerdemo.dto.UserDTO;
import com.example.taskmanagerdemo.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface UserListMapper {
    List<UserDTO> userListToUserDTOList(List<User> userList);
    List<User> userDTOListToUserList(List<UserDTO> userDTOList);
}

