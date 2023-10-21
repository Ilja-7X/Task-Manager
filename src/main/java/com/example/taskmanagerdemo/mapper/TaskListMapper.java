package com.example.taskmanagerdemo.mapper;

import com.example.taskmanagerdemo.dto.TaskDTO;
import com.example.taskmanagerdemo.model.Task;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {TaskMapper.class})
public interface TaskListMapper {
    List<Task> taskDTOListToTaskList(List<TaskDTO> taskDTOList);
    List<TaskDTO> taskListToTaskDTOList(List<Task> taskList);
}


