package com.example.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.todo.model.*;
import com.example.todo.service.*;

@RestController
public class TodoController {
    @Autowired
    public TodoJpaService todoJpaService;

    @GetMapping("/todos")
    public ArrayList<Todo> getTodoList() {
        return todoJpaService.getTodoList();
    }

    @PostMapping("/todos")
    public Todo addTodoList(@RequestBody Todo t) {
        return todoJpaService.addTodoList(t);
    }

    @GetMapping("/todos/{id}")
    public Todo getTodo(@PathVariable("id") int id) {
        return todoJpaService.getTodo(id);
    }

    @PutMapping("/todos/{id}")
    public Todo updateTodoList(@PathVariable("id") int id, @RequestBody Todo t) {
        return todoJpaService.updateTodoList(id, t);
    }

    @DeleteMapping("/todos/{id}")
    public void deleteTodoList(@PathVariable("id") int id) {
        todoJpaService.deleteTodoList(id);
    }
}
