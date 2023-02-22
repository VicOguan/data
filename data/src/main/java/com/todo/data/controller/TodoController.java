package com.todo.data.controller;

import com.todo.data.exception.RecordNotFoundException;
import com.todo.data.model.Todo;
import com.todo.data.dto.TodoDTO;
import com.todo.data.services.TodoServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
@CrossOrigin("http://localhost:3000/")
public class TodoController {
    @Autowired
    private TodoServices todoServices;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodo(Todo getAllTodo) throws RecordNotFoundException{
        List<Todo> todoModels = todoServices.getAll(getAllTodo);
        return new ResponseEntity<List<Todo>>(todoModels, HttpStatus.OK);
    }
    @PostMapping
    public TodoDTO addTodo(@RequestBody Todo todo)throws RecordNotFoundException{
        return modelMapper.map(todoServices.addTodo(todo), TodoDTO.class);
    }
    @PutMapping("/{id}")
    public Todo updateTodo(@RequestBody Todo updateTodo, @PathVariable Long id) throws RecordNotFoundException{
        return todoServices.updateTodo(updateTodo, id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?>deleteTodo(@PathVariable Long id)throws RecordNotFoundException{
        todoServices.deleteTodo(id);
        return new ResponseEntity<>("The content has been deleted", HttpStatus.OK);
    }

}
