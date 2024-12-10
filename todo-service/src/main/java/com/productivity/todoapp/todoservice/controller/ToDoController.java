package com.productivity.todoapp.todoservice.controller;

import com.productivity.todoapp.todoservice.entity.ToDo;
import com.productivity.todoapp.todoservice.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
public class ToDoController {

    private final TodoService todoService;

    @PostMapping("/create")
    public ResponseEntity<ToDo> addTodo(@RequestBody ToDo todo) {
        ToDo toDo = todoService.createTodo(todo);
        return new ResponseEntity<>(toDo, HttpStatus.CREATED);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<ToDo>> todos() {
        List<ToDo> todos = todoService.getAllTodos();
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ToDo>> getTodoById(@PathVariable String id) {
        Optional<ToDo> todo = todoService.getTodoById(id);
        return new ResponseEntity<>(todo, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ToDo> update(@RequestBody ToDo toDo) {
        ToDo updatedTodo = todoService.updateTodo(toDo);
        return new ResponseEntity<>(updatedTodo, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        todoService.deleteTodo(id);
        return new ResponseEntity<>("ToDo Deleted Successfully", HttpStatus.OK);
    }
}
