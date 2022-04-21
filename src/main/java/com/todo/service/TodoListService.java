package com.todo.service;

import com.todo.entity.TodoItem;
import com.todo.entity.TodoList;
import com.todo.repository.TodoItemRepository;
import com.todo.repository.TodoListRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoListService {

    @Autowired
    TodoListRepository todoListRepository;
    @Autowired
    TodoItemRepository todoItemRepository;

    public TodoItem getTodoItemById(int id) {
        return todoItemRepository.findById(id);
    }

    public TodoItem getTodoItemByName(String name) {
        return todoItemRepository.findByName(name);
    }

    public TodoItem addTodoItem(TodoItem newItem) {
        todoItemRepository.save(newItem);
        return newItem;
    }
    
    public TodoItem deleteTodoItemById(int id) {
        return todoItemRepository.deleteById(id);
    }

    public TodoItem deleteTodoItemByName(String name) {
        return todoItemRepository.deleteByName(name);
    }

    public TodoItem updateTodoItem(int id, TodoItem inputTodoItem) {
        TodoItem todo = todoItemRepository.findById(id);
        if (todo != null) {
            todo.setName(inputTodoItem.getName());
            if(inputTodoItem.getState()!=null) {
                switch (inputTodoItem.getState()) {
                    case "incomplete":
                    case "complete":
                        todo.setState(inputTodoItem.getState());
                        break;
                }
            }
            else
                todo.setState(inputTodoItem.getState());
            todo.setDescription(inputTodoItem.getDescription());
            todo.setTodoListId(inputTodoItem.getTodoListId());
            todoItemRepository.save(todo);

        }
        return todo;
    }

    public TodoItem toggleTodoItemState(int id) {
        TodoItem todo = todoItemRepository.findById(id);
        if (todo != null) {
            if (todo.getState() == null || todo.getState().equals("incompete")) {
                todo.setState("complete");
            } else {
                todo.setState("incompete");
            }
            todoItemRepository.save(todo);
        }
        return todo;
    }

    public List<TodoList> getAllTodoLists() {
        return todoListRepository.findAll();
    }

    public TodoList getTodoListById(int id) {
        return todoListRepository.findById(id);
    }

    public TodoList getTodoListByName(String name) {
        return todoListRepository.findByName(name);
    }

    public TodoList addTodoList(TodoList newList) {
        todoListRepository.save(newList);
        return newList;
    }

    public TodoList addTodoListByName(String newTodoListName) {
        TodoList newList = new TodoList(newTodoListName);
        todoListRepository.save(newList);
        return newList;
    }

    public TodoList deleteTodoListById(int id) {
        return todoListRepository.deleteById(id);
    }

    public boolean deleteTodoListByName(String name) {
        TodoList toDelete = todoListRepository.findByName(name);
        if (toDelete != null) {
            todoListRepository.deleteById(toDelete.getId());
            return true;
        }
        return false;
    }

    public TodoList updateTodoList(int id, TodoList inputTodoList) {
        TodoList list = todoListRepository.findById(id);
        if (list != null) {
            list.setName(inputTodoList.getName());
            list.setDescription(inputTodoList.getDescription());
            todoListRepository.save(list);
        }
        return list;
    }

}
