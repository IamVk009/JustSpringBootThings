package com.productivity.todoapp.todoservice.controller;

import com.productivity.todoapp.todoservice.dto.ToDoDto;
import com.productivity.todoapp.todoservice.response.ApiResponseMessage;
import com.productivity.todoapp.todoservice.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
public class ToDoController {

    private final TodoService todoService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponseMessage<ToDoDto>> addTodo(@RequestBody ToDoDto toDoDto) {
        ToDoDto toDo = todoService.createTodo(toDoDto);
        ApiResponseMessage<ToDoDto> response = ApiResponseMessage.<ToDoDto>builder()
                .status("Success")
                .message("Todo Created")
                .data(toDo)
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/todos")
    public ResponseEntity<ApiResponseMessage<List<ToDoDto>>> todos() {
        List<ToDoDto> todos = todoService.getAllTodos();
        ApiResponseMessage<List<ToDoDto>> response = ApiResponseMessage.<List<ToDoDto>>builder()
                .message("All Todos")
                .status("Success")
                .data(todos)
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseMessage<ToDoDto>> getTodoById(@PathVariable String id) {
        ToDoDto todo = todoService.getTodoById(id);
        ApiResponseMessage<ToDoDto> response = ApiResponseMessage.<ToDoDto>builder()
                .message("Todo")
                .status("Success")
                .data(todo)
                .build();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update")
    public ResponseEntity<ApiResponseMessage<ToDoDto>> update(@RequestBody ToDoDto toDoDto) {
        ToDoDto updatedTodo = todoService.updateTodo(toDoDto);
        ApiResponseMessage<ToDoDto> response = ApiResponseMessage.<ToDoDto>builder()
                .message("Todo Updated")
                .status("Success")
                .data(updatedTodo)
                .build();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponseMessage<String>> delete(@PathVariable String id) {
        todoService.deleteTodo(id);
        ApiResponseMessage<String> response = ApiResponseMessage.<String>builder()
                .message("Todo Deleted")
                .status("Success")
                .build();
        return ResponseEntity.ok(response);
    }
}
