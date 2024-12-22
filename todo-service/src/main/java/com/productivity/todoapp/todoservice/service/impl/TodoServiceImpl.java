package com.productivity.todoapp.todoservice.service.impl;

import com.productivity.todoapp.todoservice.entity.ToDo;
import com.productivity.todoapp.todoservice.exception.ToDoNotFoundException;
import com.productivity.todoapp.todoservice.repository.TodoRepository;
import com.productivity.todoapp.todoservice.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    @Override
    public ToDo createTodo(ToDo todo) {
        todoRepository.save(todo);
        return todo;
    }

    @Override
    public List<ToDo> getAllTodos() {
        return todoRepository.findAll();
    }

    @Override
    public Optional<ToDo> getTodoById(String id) {
        Optional<ToDo> todo = todoRepository.findById(id);
        return todo;
    }

    @Override
    public ToDo updateTodo(ToDo toDo) {
        ToDo existingTodo = todoRepository.findById(toDo.getId()).orElseThrow(() -> new ToDoNotFoundException(String.format("Todo With Given Id : " + toDo.getId() + " does not Exist."), HttpStatus.NOT_FOUND));
        existingTodo.setTodo(toDo.getTodo());
        return todoRepository.save(existingTodo);
    }

    @Override
    public void deleteTodo(String id) {
        ToDo existingTodo = todoRepository.findById(id).orElseThrow(() -> new ToDoNotFoundException("Todo With Given Id : " + id + " does not Exist.", HttpStatus.NOT_FOUND));
        todoRepository.delete(existingTodo);
    }
}
