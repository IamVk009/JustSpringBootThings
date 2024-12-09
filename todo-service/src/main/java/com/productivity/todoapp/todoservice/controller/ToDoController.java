package com.productivity.todoapp.todoservice.controller;

import com.productivity.todoapp.todoservice.entity.ToDo;
import com.productivity.todoapp.todoservice.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
public class ToDoController {

    private final TodoService todoService;

    @PostMapping("/create")
    public ResponseEntity<ToDo> addTodo(@RequestBody ToDo todo) {
        ToDo toDo = todoService.createTodo(todo);
        return new ResponseEntity<>(toDo, HttpStatus.OK);
    }
}
