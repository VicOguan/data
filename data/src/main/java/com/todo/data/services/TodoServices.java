package com.todo.data.services;

import com.todo.data.exception.RecordNotFoundException;
import com.todo.data.model.Todo;
import com.todo.data.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServices implements TodoServicesImpl{

    @Autowired
    TodoRepository todoRepository;

    @Override
    public List<Todo> getAll(Todo getAllTodo) throws RecordNotFoundException {
        return todoRepository.findAll();
    }

    @Override
    public Todo addTodo(Todo todo) throws RecordNotFoundException {
        return todoRepository.save(todo);
    }

    @Override
    public Todo updateTodo(Todo updateTodo, Long id) throws RecordNotFoundException {
        return todoRepository.findById(id).map(todo -> {
            todo.setTittle(updateTodo.getTittle());
            todo.setDescription(updateTodo.getDescription());
            todo.setImg(updateTodo.getImg());
            return todoRepository.save(todo);
        }).orElseThrow(() -> new RecordNotFoundException("Record not Found"));
    }

    @Override
    public void deleteTodo(Long id) throws RecordNotFoundException {
        Optional<Todo>todo =todoRepository.findById(id);
        if (todo.isEmpty()){
            todoRepository.findById(id).stream().filter(todoModel1 -> todoModel1.getId()==id);
        }else todoRepository.delete(todo.get());
    }
}
