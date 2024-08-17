package com.example.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;
import com.example.todo.repository.*;
import com.example.todo.model.*;

@Service
public class TodoJpaService implements TodoRepository {
    @Autowired
    private TodoJpaRepository todoJpaRepository;

    @Override
    public ArrayList<Todo> getTodoList() {
        List<Todo> z = todoJpaRepository.findAll();
        ArrayList<Todo> ar = new ArrayList<>(z);
        return ar;
    }

    @Override
    public Todo addTodoList(Todo t) {
        todoJpaRepository.save(t);
        return t;
    }

    @Override
    public Todo getTodo(int id) {
        try {
            Todo x = todoJpaRepository.findById(id).get();
            return x;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Todo updateTodoList(int id, Todo t) {
        try {
            Todo c = todoJpaRepository.findById(id).get();
            if (t.getTodo() != null) {
                c.setTodo(t.getTodo());
            }
            if (t.getStatus() != null) {
                c.setStatus(t.getStatus());
            }
            if (t.getPriority() != null) {
                c.setPriority(t.getPriority());
            }
            todoJpaRepository.save(c);
            return c;

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public void deleteTodoList(int id) {
        try {
            todoJpaRepository.deleteById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
