package com.productivity.todoapp.todoservice.service.impl;

import com.productivity.todoapp.todoservice.dto.ToDoDto;
import com.productivity.todoapp.todoservice.entity.ToDo;
import com.productivity.todoapp.todoservice.exception.DatabaseException;
import com.productivity.todoapp.todoservice.exception.ToDoNotFoundException;
import com.productivity.todoapp.todoservice.mapper.ToDoMapper;
import com.productivity.todoapp.todoservice.repository.TodoRepository;
import com.productivity.todoapp.todoservice.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    @Override
    public ToDoDto createTodo(ToDoDto toDoDto) {
        ToDo toDo = dtoToEntity(toDoDto);
        try {
            todoRepository.save(toDo);
        } catch (DataAccessException exception) {
            throw new DatabaseException("Failed to save ToDo due to Database Error", exception, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return entityToDto(toDo);
    }

    @Override
    public List<ToDoDto> getAllTodos() {
        List<ToDo> allTodos = todoRepository.findAll();
        List<ToDoDto> todos = allTodos.stream().map(toDo -> new ToDoDto(toDo.getId(), toDo.getTodo())).toList();
        return todos;
    }

    @Override
    public ToDoDto getTodoById(String id) {
        Optional<ToDo> todo = todoRepository.findById(id);
        return ToDoMapper.INSTANCE.mapOptionalToDto(todo);
    }

    @Override
    public ToDoDto updateTodo(ToDoDto toDoDto) {
        ToDo toDo = dtoToEntity(toDoDto);
        ToDo existingTodo = todoRepository.findById(toDo.getId()).orElseThrow(() -> new ToDoNotFoundException("Todo With Given Id : " + toDo.getId() + " does not Exist.", HttpStatus.NOT_FOUND));
        existingTodo.setTodo(toDo.getTodo());
        ToDo updatedTodo = todoRepository.save(existingTodo);
        return entityToDto(updatedTodo);
    }

    @Override
    public void deleteTodo(String id) {
        ToDo existingTodo = todoRepository.findById(id).orElseThrow(() -> new ToDoNotFoundException("Todo With Given Id : " + id + " does not Exist.", HttpStatus.NOT_FOUND));
        todoRepository.delete(existingTodo);
    }

    private ToDoDto entityToDto(ToDo toDo) {
        return ToDoMapper.INSTANCE.entityToDto(toDo);
    }

    private ToDo dtoToEntity(ToDoDto toDoDto) {
        return ToDoMapper.INSTANCE.dtoToEntity(toDoDto);
    }
}
