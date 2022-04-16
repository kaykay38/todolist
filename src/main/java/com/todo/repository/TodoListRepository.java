package com.todo.repository;

import com.todo.entity.TodoList;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoListRepository extends JpaRepository<TodoList, Integer>{
    public TodoList findById(int id);
    public TodoList findByName(String name);
    public TodoList deleteById(int id);
    public TodoList deleteByName(String name);
}
