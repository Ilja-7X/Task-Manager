package com.example.taskmanagerdemo.controller;

import com.example.taskmanagerdemo.model.Task;
import com.example.taskmanagerdemo.model.TaskForm;
import com.example.taskmanagerdemo.service.TaskService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @Value("${error.message}")
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
    }
}
