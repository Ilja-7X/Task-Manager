package com.example.taskmanagerdemo.controller;


import com.example.taskmanagerdemo.dto.TaskDTO;
import com.example.taskmanagerdemo.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("new")
    public ResponseEntity<TaskDTO> createTask(@Valid @RequestBody TaskDTO taskDTO, BindingResult result) {
        if(result.hasErrors()) {
            return new ResponseEntity<>(taskDTO, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(taskService.createTask(taskDTO), HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<TaskDTO> getTaskById(@PathVariable("id") Long userId) {
        return new ResponseEntity<>(taskService.getTaskById(userId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TaskDTO>> getAllTasks() {
        return new ResponseEntity<>(taskService.getAllTask(), HttpStatus.OK);
    }

    /*@Value("${error.message}")
    private String errorMessage;

    @GetMapping("/")
    public String getString() {
        return "home";
    }

    @GetMapping("/tasks")
    public String getMessage(Model model) {
        model.addAttribute("color", "red");
        model.addAttribute("tasks",taskService.findAll());
        return "tasks";
    }
    @GetMapping("/addTask")
    public String showAddTaskPage(Model model) {
        TaskForm taskForm = new TaskForm();
        model.addAttribute("taskForm", taskForm);
        return "addTask";
    }

    @PostMapping("/addTask")
    public String saveTask(Model model, @ModelAttribute("taskForm") TaskForm taskForm) {
        String title = taskForm.getTitle();
        String description = taskForm.getDescription();

        if(title != null && title.length() > 0 && description != null && description.length() > 0) {
            Task task = new Task();
            task.setTitle(title);
            task.setDescription(description);
            taskService.saveTask(task);
            return "redirect:/tasks";
        }
        model.addAttribute("errorMessage", errorMessage);
        return "addTask";
    }*/
}
