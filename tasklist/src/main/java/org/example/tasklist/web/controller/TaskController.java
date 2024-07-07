package org.example.tasklist.web.controller;

import lombok.RequiredArgsConstructor;
import org.example.tasklist.domain.task.Task;
import org.example.tasklist.service.ITaskService;
import org.example.tasklist.web.dto.task.TaskDto;
import org.example.tasklist.web.dto.validation.IOnUpdate;
import org.example.tasklist.web.mappers.ITaskMapper;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
@Validated
public class TaskController {

    private final ITaskService taskService;

    private final ITaskMapper taskMapper;

    @GetMapping("/{id}")
    public TaskDto getById(@PathVariable Long id){

        Task task = taskService.getById(id);

        return taskMapper.toDto(task);
    }

    @PutMapping
    public TaskDto update(
        @Validated(IOnUpdate.class) @RequestBody TaskDto dto
    ){

        Task task = taskMapper.toEntity(dto);
        Task updTask = taskService.update(task);

        return taskMapper.toDto(updTask);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        taskService.delete(id);
    }

}
