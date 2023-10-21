package com.example.taskmanagerdemo.service;

import com.example.taskmanagerdemo.dto.TaskDTO;
import com.example.taskmanagerdemo.mapper.TaskListMapperImpl;
import com.example.taskmanagerdemo.mapper.TaskMapperImpl;
import com.example.taskmanagerdemo.model.Task;
import com.example.taskmanagerdemo.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapperImpl taskMapper;
    private final TaskListMapperImpl taskListMapper;

    public TaskService(TaskRepository taskRepository, TaskMapperImpl taskMapper, TaskListMapperImpl taskListMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
        this.taskListMapper = taskListMapper;
    }

    public TaskDTO createTask(TaskDTO task) {
        Task savedTask = taskRepository.save(taskMapper.taskDTOtoTask(task));
        return taskMapper.taskToTaskDTO(savedTask);
    }

    public List<TaskDTO> getAllTask() {
        return taskListMapper.taskListToTaskDTOList(taskRepository.findAll());
    }

    public TaskDTO getTaskById(Long id) {
        return taskMapper.taskToTaskDTO(taskRepository.findById(id).get());
    }
}
