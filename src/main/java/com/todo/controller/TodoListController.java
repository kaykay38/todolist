package com.todo.controller;

import com.todo.entity.TodoList;
import com.todo.service.TodoListService;
import com.todo.entity.TodoItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/todo/v1")
public class TodoListController {

    @Autowired
    private TodoListService todoListService;

    @GetMapping("/lists")
    public List<TodoList> getAllLists() {
        return todoListService.getAllTodoLists();
    }

    @GetMapping("/list")
    public Set<String> getAllTodoLists() {
        Set<String> todoListNames = new HashSet<>();
        List<TodoList> lists = todoListService.getAllTodoLists();
        for (TodoList list: lists) {
            todoListNames.add(list.getName());
        }
        return todoListNames;
    }

    @GetMapping("/list/{name}")
    public TodoList getTodoListByName(@PathVariable String name) {
        return todoListService.getTodoListByName(name);
    }

    @PutMapping("/list/{id}")
    public TodoList updateTodoList(@PathVariable int id, @RequestBody TodoList updatedTodoList) {
        return todoListService.updateTodoList(id, updatedTodoList);
    }

    @PostMapping("/list")
    public TodoList addTodoList(@RequestBody TodoList newTodoList) {
        return todoListService.addTodoList(newTodoList);
    }

    @PostMapping("/list/{name}")
    public TodoList addTodoListByName(@PathVariable String name) {
        return todoListService.addTodoListByName(name);
    }

    @DeleteMapping("/list/{id}")
    public TodoList deleteTodoListById(@PathVariable int id) {
        return todoListService.deleteTodoListById(id);
    }

    @DeleteMapping("/list/{name}/delete")
    public boolean deleteTodoListByName(@PathVariable String name) {
        return todoListService.deleteTodoListByName(name);
    }

    @GetMapping("/{id}")
    public TodoItem getTodoItemById(@PathVariable int id) {
        return todoListService.getTodoItemById(id);
    }

    @GetMapping("/todo/{name}")
    public TodoItem getTodoItemByName(@PathVariable String name) {
        return todoListService.getTodoItemByName(name);
    }

    @PutMapping("/todo/{id}")
    public TodoItem updateTodoItem(@PathVariable int id, @RequestBody TodoItem updatedTodoItem) {
        return todoListService.updateTodoItem(id, updatedTodoItem);
    }

    @PutMapping("/todo/{id}/toggle")
    public TodoItem updateTodoItemState(@PathVariable int id) {
        return todoListService.toggleTodoItemState(id);
    }

    @PostMapping("/todo")
    public TodoItem addTodoItem(@RequestBody TodoItem newTodoItem) {
        return todoListService.addTodoItem(newTodoItem);
    }

    @DeleteMapping("/todo/{id}")
    public TodoItem deleteTodoItemById(@PathVariable int id) {
        return todoListService.deleteTodoItemById(id);
    }

    @DeleteMapping("/todo/{name}/delete")
    public TodoItem deleteTodoItemByName(@PathVariable String name) {
        return todoListService.deleteTodoItemByName(name);
    }
}