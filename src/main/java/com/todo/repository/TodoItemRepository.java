package com.todo.repository;

import com.todo.entity.TodoItem;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoItemRepository extends JpaRepository<TodoItem, Integer> {
    public TodoItem findById(int id);
    public TodoItem findByName(String name);
    public TodoItem deleteById(int id);
    public TodoItem deleteByName(String name);
}
