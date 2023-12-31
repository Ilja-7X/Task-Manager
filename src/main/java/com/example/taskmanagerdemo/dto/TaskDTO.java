package com.example.taskmanagerdemo.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO {
    @NotNull
    @Size(max = 50)
    private String title;
    @NotNull
    private String description;
    private UserDTO user;
}