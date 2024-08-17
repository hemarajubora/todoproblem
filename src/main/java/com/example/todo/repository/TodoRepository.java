package com.example.todo.repository;

import java.util.*;
import com.example.todo.model.*;

public interface TodoRepository {
    ArrayList<Todo> getTodoList();

    Todo addTodoList(Todo t);

    Todo getTodo(int id);

    Todo updateTodoList(int id, Todo t);

    void deleteTodoList(int id);
}