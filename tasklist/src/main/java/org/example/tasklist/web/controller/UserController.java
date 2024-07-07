package org.example.tasklist.web.controller;

import lombok.RequiredArgsConstructor;
import org.example.tasklist.domain.task.Task;
import org.example.tasklist.domain.user.User;
import org.example.tasklist.service.ITaskService;
import org.example.tasklist.service.IUserService;
import org.example.tasklist.web.dto.task.TaskDto;
import org.example.tasklist.web.dto.user.UserDto;
import org.example.tasklist.web.dto.validation.IOnCreate;
import org.example.tasklist.web.dto.validation.IOnUpdate;
import org.example.tasklist.web.mappers.ITaskMapper;
import org.example.tasklist.web.mappers.IUserMapper;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Validated
public class UserController {

    private final ITaskService taskService;
    private final IUserService userService;

    private final IUserMapper userMapper;
    private final ITaskMapper taskMapper;

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable Long id){

        User user = userService.getById(id);

        return userMapper.toDto(user);
    }

    @PutMapping
    public UserDto update(
            @Validated(IOnUpdate.class) @RequestBody UserDto dto
    ){

        User user = userMapper.toEntity(dto);
        User updUser = userService.update(user);

        return userMapper.toDto(updUser);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        userService.delete(id);
    }

    @GetMapping("/{id}/tasks")
    public List<TaskDto> getTasksByUserId(@PathVariable Long id){

        List<Task> tasks = taskService.getAllByUserId(id);
        return taskMapper.toDto(tasks);
    }

    @PostMapping("/{id}/tasks")
    public TaskDto createTask(@PathVariable Long id,
        @Validated(IOnCreate.class) @RequestBody TaskDto dto) {

        Task task = taskMapper.toEntity(dto);
        Task crtTask = taskService.create(task, id);

        return taskMapper.toDto(crtTask);
    }

}
