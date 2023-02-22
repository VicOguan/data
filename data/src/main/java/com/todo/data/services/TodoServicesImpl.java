package com.todo.data.services;

import com.todo.data.exception.RecordNotFoundException;
import com.todo.data.model.Todo;

import java.util.List;

public interface TodoServicesImpl {
    List<Todo> getAll(Todo getAllTodo)throws RecordNotFoundException;
    Todo addTodo(Todo todo) throws RecordNotFoundException;
    Todo updateTodo(Todo updateTodo, Long id) throws RecordNotFoundException;
    void deleteTodo(Long id)throws RecordNotFoundException;
}
