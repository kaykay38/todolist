package com.todo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Transient;
import java.util.Set;

@Entity
@Table(name = "todolists")
public class TodoList {

    @Id
    @GeneratedValue
    private int id;

    // @Column(name = "name", unique = true, updatable = true)
    private String name;

    // @Column(name = "description", updatable = true)
    private String description;

    @Transient
    // @OneToMany
    // @JoinColumn(name = "todolist_id", referencedColumnName = "id")
    private Set<TodoItem> todos;

    public TodoList() {
        super();
    }

    public TodoList(String name) {
        super();
        this.name = name;
    }

    public TodoList(String name, String description, Set<TodoItem> todos) {
        super();
        this.name = name;
        this.description = description;
        this.todos = todos;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<TodoItem> getTodos() {
        return this.todos;
    }

    public void setTodos(Set<TodoItem> newTodos) {
        this.todos = newTodos;
    }

}
