package com.todo.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;

@Entity
@Table(name = "tasks")
public class TodoItem {
    @Id
    @GeneratedValue
    private int id;

    // @Column(name = "name", unique = true, updatable = true)
    private String name;

    // @Column(name = "description", updatable = true)
    private String description;

    // @Column(name = "state", updatable = true)
    private String state;

    private Date deadline;

    private int priority;

    @Column(name = "todolist_id")
    private int todoListId;

    public TodoItem() {
        super();
    }

    public TodoItem(String name, String description, String state, int todoListId) {
        super();
        this.name = name;
        this.description = description;
        this.state = state;
        this.todoListId = todoListId;
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

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getTodoListId() {
        return todoListId;
    }

    public void setTodoListId(int todoListId) {
        this.todoListId = todoListId;
    }

    public void setDeadline(Date newDeadline) {
        this.deadline = newDeadline;
    }

    public Date getDeadline() {
        return this.deadline;
    }

    public void setPriority(int newPriority) {
        this.priority = newPriority;
    }

    public int getPriority() {
        return this.priority;
    }
}
