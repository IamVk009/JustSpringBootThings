package com.productivity.todoapp.todoservice.service;

import com.productivity.todoapp.todoservice.entity.ToDo;

import java.util.List;
import java.util.Optional;

public interface TodoService {

    ToDo createTodo(ToDo todo);

    List<ToDo> getAllTodos();

    Optional<ToDo> getTodoById(String id);

    ToDo updateTodo(ToDo toDo);

    void deleteTodo(String id);
}
