package com.example.taskmanagerdemo.mapper;

import com.example.taskmanagerdemo.dto.TaskDTO;
import com.example.taskmanagerdemo.model.Task;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")//, uses = {UserMapper.class})
public interface TaskMapper {
    Task taskDTOtoTask(TaskDTO taskDTO);
    TaskDTO taskToTaskDTO(Task task);

}
