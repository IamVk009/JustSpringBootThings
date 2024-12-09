package com.productivity.todoapp.todoservice.service.impl;

import com.productivity.todoapp.todoservice.entity.ToDo;
import com.productivity.todoapp.todoservice.repository.TodoRepository;
import com.productivity.todoapp.todoservice.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public ToDo createTodo(ToDo todo) {
        todoRepository.save(todo);
        return todo;
    }
}
