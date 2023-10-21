package com.example.taskmanagerdemo.dto;

import com.example.taskmanagerdemo.model.Status;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    @NotNull
    @Email
    private String email;
    @NotNull
    @Pattern(regexp = "([a-z]|[A-Z])+")
    @Size(max = 50)
    private String firstName;
    @NotNull
    @Pattern(regexp = "([a-z]|[A-Z])+")
    @Size(max = 50)
    private String lastName;
    @NotNull
    private Status status;
}
