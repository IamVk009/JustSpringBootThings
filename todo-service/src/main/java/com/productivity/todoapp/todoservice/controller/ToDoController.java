package com.productivity.todoapp.todoservice.controller;

import com.productivity.todoapp.todoservice.entity.ToDo;
import com.productivity.todoapp.todoservice.response.ApiResponseMessage;
import com.productivity.todoapp.todoservice.service.TodoService;
import lombok.RequiredArgsConstructor;
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
    public ResponseEntity<ApiResponseMessage<ToDo>> addTodo(@RequestBody ToDo todo) {
        ToDo toDo = todoService.createTodo(todo);
        ApiResponseMessage<ToDo> response = ApiResponseMessage.<ToDo>builder()
                .status("Success")
                .message("Todo Created")
                .data(toDo)
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/todos")
    public ResponseEntity<ApiResponseMessage<List<ToDo>>> todos() {
        List<ToDo> todos = todoService.getAllTodos();
        ApiResponseMessage<List<ToDo>> response = ApiResponseMessage.<List<ToDo>>builder()
                .message("All Todos")
                .status("Success")
                .data(todos)
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseMessage<Optional<ToDo>>> getTodoById(@PathVariable String id) {
        Optional<ToDo> todo = todoService.getTodoById(id);
        ApiResponseMessage<Optional<ToDo>> response = ApiResponseMessage.<Optional<ToDo>>builder()
                .message("Todo")
                .status("Success")
                .data(todo)
                .build();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update")
    public ResponseEntity<ApiResponseMessage<ToDo>> update(@RequestBody ToDo toDo) {
        ToDo updatedTodo = todoService.updateTodo(toDo);
        ApiResponseMessage<ToDo> response = ApiResponseMessage.<ToDo>builder()
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
